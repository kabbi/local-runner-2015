package com.codeforces.commons.io.http;

import com.codeforces.commons.io.CountingInputStream;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.io.http.HttpMethod;
import com.codeforces.commons.io.http.HttpResponse;
import com.codeforces.commons.io.http.HttpResponseChecker;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.process.ThreadUtil;
import com.codeforces.commons.properties.internal.CommonsPropertiesUtil;
import com.codeforces.commons.text.StringUtil;
import com.codeforces.commons.text.UrlUtil;
import com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.net.Proxy.Type;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

public final class HttpRequest {
    private static final Logger logger = Logger.getLogger(HttpRequest.class);
    private final String url;
    private final Map parametersByName = new LinkedHashMap(8);
    private byte[] binaryEntity;
    private boolean gzip;
    private final Map headersByName = new LinkedHashMap(8);
    private HttpMethod method;
    private int timeoutMillis;
    private int maxRetryCount;
    private HttpResponseChecker responseChecker;
    private ThreadUtil.ExecutionStrategy retryStrategy;
    private long maxSizeBytes;

    public static HttpRequest create(String var0, Object... var1) {
        return new HttpRequest(var0, var1);
    }

    private HttpRequest(String var1, Object... var2) {
        this.method = HttpMethod.GET;
        this.timeoutMillis = NumberUtil.toInt(600000L);
        this.maxRetryCount = 1;
        this.responseChecker = new HttpResponseChecker() {
            public boolean check(HttpResponse var1) {
                return !var1.hasIoException();
            }
        };
        this.retryStrategy = new ThreadUtil.ExecutionStrategy(250L, ThreadUtil.ExecutionStrategy.Type.LINEAR);
        this.maxSizeBytes = 1073741824L;
        this.url = var1;
        this.appendParameters(var2);
    }

    public HttpRequest appendParameters(Object... var1) {
        if(this.hasBinaryEntity()) {
            throw new IllegalStateException("Can\'t send parameters and binary entity with a single request.");
        } else {
            String[] var2 = validateAndEncodeParameters(this.url, var1);
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; var4 += 2) {
                String var5 = var2[var4];
                String var6 = var2[var4 + 1];
                Object var7 = (List)this.parametersByName.get(var5);
                if(var7 == null) {
                    var7 = new ArrayList(1);
                    this.parametersByName.put(var5, var7);
                }

                ((List)var7).add(var6);
            }

            return this;
        }
    }

    public HttpRequest setBinaryEntity(byte[] var1) {
        if(!this.parametersByName.isEmpty()) {
            throw new IllegalStateException("Can\'t send parameters and binary entity with a single request.");
        } else {
            this.binaryEntity = var1;
            return this;
        }
    }

    public boolean hasBinaryEntity() {
        return this.binaryEntity != null;
    }

    public HttpRequest setGzip(boolean var1) {
        this.gzip = var1;
        return this;
    }

    public HttpRequest setMethod(HttpMethod var1) {
        Preconditions.checkNotNull(var1, "Argument \'method\' is null.");
        this.method = var1;
        return this;
    }

    public HttpRequest setTimeoutMillis(int var1) {
        Preconditions.checkArgument(var1 > 0, "Argument \'timeoutMillis\' is zero or negative.");
        this.timeoutMillis = var1;
        return this;
    }

    public HttpResponse executeAndReturnResponse() {
        return this.internalExecute(true);
    }

    private HttpResponse internalExecute(boolean var1) {
        String var2 = this.appendGetParametersToUrl(this.url);
        if(this.method == HttpMethod.GET && this.hasBinaryEntity()) {
            String var7 = "Can\'t write binary entity to \'" + var2 + "\' with GET method.";
            logger.warn(var7);
            return new HttpResponse(-1, (byte[])null, (Map)null, new IOException(var7));
        } else {
            long var3 = System.currentTimeMillis();

            for(int var5 = 1; var5 < this.maxRetryCount; ++var5) {
                HttpResponse var6 = this.internalGetHttpResponse(var1, var2, var3);
                if(this.responseChecker.check(var6)) {
                    return var6;
                }

                ThreadUtil.sleep(this.retryStrategy.getDelayTimeMillis(var5));
            }

            return this.internalGetHttpResponse(var1, var2, var3);
        }
    }

    private HttpResponse internalGetHttpResponse(boolean var1, String var2, long var3) {
        HttpURLConnection var5;
        String var7;
        try {
            var5 = this.newConnection(var2, this.method == HttpMethod.POST && (!this.parametersByName.isEmpty() || this.hasBinaryEntity()));
        } catch (IOException var19) {
            var7 = "Can\'t create connection to \'" + var2 + "\'.";
            logger.warn(var7, var19);
            return new HttpResponse(-1, (byte[])null, (Map)null, new IOException(var7, var19));
        }

        if(this.method == HttpMethod.POST) {
            if(!this.parametersByName.isEmpty()) {
                try {
                    this.writePostParameters(var5, this.parametersByName);
                } catch (IOException var16) {
                    var7 = "Can\'t write POST parameters to \'" + var2 + "\'.";
                    logger.warn(var7, var16);
                    return new HttpResponse(-1, (byte[])null, (Map)null, new IOException(var7, var16));
                }
            }

            if(this.hasBinaryEntity()) {
                try {
                    this.writeEntity(var5, this.binaryEntity);
                } catch (IOException var15) {
                    var7 = "Can\'t write binary entity to \'" + var2 + "\'.";
                    logger.warn(var7, var15);
                    return new HttpResponse(-1, (byte[])null, (Map)null, new IOException(var7, var15));
                }
            }
        }

        HttpResponse var8;
        try {
            var5.connect();
            int var6 = var5.getResponseCode();
            byte[] var20 = this.getBytes(var5, var1, var3);
            var8 = new HttpResponse(var6, var20, var5.getHeaderFields(), (IOException)null);
            return var8;
        } catch (IOException var17) {
            var7 = "Can\'t read response from \'" + var2 + "\'.";
            logger.warn(var7, var17);
            var8 = new HttpResponse(-1, (byte[])null, var5.getHeaderFields(), new IOException(var7, var17));
        } finally {
            var5.disconnect();
        }

        return var8;
    }

    private byte[] getBytes(HttpURLConnection var1, boolean var2, final long var3) throws IOException {
        byte[] var5;
        if(var2) {
            Object var6;
            try {
                var6 = var1.getInputStream();
            } catch (IOException var8) {
                var6 = var1.getErrorStream();
                if(var6 == null) {
                    throw var8;
                }
            }

            if(var6 == null) {
                var5 = null;
            } else {
                if("gzip".equalsIgnoreCase(var1.getContentEncoding())) {
                    var6 = new GZIPInputStream((InputStream)var6);
                } else if("deflate".equalsIgnoreCase(var1.getContentEncoding())) {
                    var6 = new InflaterInputStream((InputStream)var6);
                } else if("zip".equalsIgnoreCase(var1.getContentEncoding())) {
                    var6 = new ZipInputStream((InputStream)var6);
                }

                CountingInputStream var9 = new CountingInputStream((InputStream)var6, new CountingInputStream.ReadEvent() {
                    public void onRead(long var1, long var3x) throws IOException {
                        if(System.currentTimeMillis() - var3 > (long)HttpRequest.this.timeoutMillis) {
                            throw new IOException("Can\'t read response within " + HttpRequest.this.timeoutMillis + " ms.");
                        }
                    }
                });
                var5 = IoUtil.toByteArray(var9, NumberUtil.toInt(this.maxSizeBytes), true);
            }
        } else {
            var5 = null;
        }

        return var5;
    }

    private String appendGetParametersToUrl(String var1) {
        if(this.method == HttpMethod.GET) {
            Iterator var2 = this.parametersByName.entrySet().iterator();

            while(var2.hasNext()) {
                Entry var3 = (Entry)var2.next();
                String var4 = (String)var3.getKey();

                String var6;
                for(Iterator var5 = ((List)var3.getValue()).iterator(); var5.hasNext(); var1 = UrlUtil.appendParameterToUrl(var1, var4, var6)) {
                    var6 = (String)var5.next();
                }
            }
        }

        return var1;
    }

    private static String[] validateAndEncodeParameters(String var0, Object... var1) {
        if(!UrlUtil.isValidUrl(var0)) {
            throw new IllegalArgumentException('\'' + var0 + "\' is not a valid URL.");
        } else {
            boolean var2;
            try {
                var2 = CommonsPropertiesUtil.getSecureHosts().contains((new URL(var0)).getHost());
            } catch (MalformedURLException var11) {
                throw new IllegalArgumentException('\'' + var0 + "\' is not a valid URL.", var11);
            }

            int var3 = var1.length;
            if(var3 == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            } else if(var3 % 2 != 0) {
                throw new IllegalArgumentException("Argument \'parameters\' should contain even number of elements, i.e. should consist of key-value pairs.");
            } else {
                List var4 = CommonsPropertiesUtil.getSecurePasswords();
                List var5 = CommonsPropertiesUtil.getPrivateParameters();
                String[] var6 = new String[var3];

                for(int var7 = 0; var7 < var3; var7 += 2) {
                    Object var8 = var1[var7];
                    Object var9 = var1[var7 + 1];
                    if(!(var8 instanceof String) || StringUtil.isBlank((String)var8)) {
                        throw new IllegalArgumentException(String.format("Each parameter name should be non-blank string, but found: \'%s\'.", new Object[]{var8}));
                    }

                    if(var9 == null) {
                        throw new IllegalArgumentException(String.format("Value of parameter \'%s\' is null.", new Object[]{var8}));
                    }

                    try {
                        var6[var7] = URLEncoder.encode((String)var8, "UTF-8");
                        if(!var2 && (var5.contains(var8) || var4.contains(var9.toString()))) {
                            var6[var7 + 1] = "";
                        } else {
                            var6[var7 + 1] = URLEncoder.encode(var9.toString(), "UTF-8");
                        }
                    } catch (UnsupportedEncodingException var12) {
                        throw new RuntimeException("UTF-8 is unsupported.", var12);
                    }
                }

                return var6;
            }
        }
    }

    private HttpURLConnection newConnection(String var1, boolean var2) throws IOException {
        URL var3 = new URL(var1);
        Proxy var4 = getProxy(var3.getProtocol());
        HttpURLConnection var5 = (HttpURLConnection)((HttpURLConnection)(var4 == null?var3.openConnection():var3.openConnection(var4)));
        if(var5 instanceof HttpsURLConnection) {
            bypassSecureHostSslCertificateCheck((HttpsURLConnection)var5, var3);
        }

        var5.setReadTimeout(this.timeoutMillis);
        var5.setConnectTimeout(this.timeoutMillis);
        var5.setRequestMethod(this.method.name());
        var5.setDoInput(true);
        var5.setDoOutput(var2);
        var5.setInstanceFollowRedirects(true);
        var5.setRequestProperty("Connection", "close");
        if(this.method == HttpMethod.POST) {
            if(this.hasBinaryEntity()) {
                var5.setRequestProperty("Content-Type", "application/octet-stream");
            } else if(!this.parametersByName.isEmpty()) {
                var5.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }

            if(this.gzip && (this.hasBinaryEntity() || !this.parametersByName.isEmpty())) {
                var5.setRequestProperty("Content-Encoding", "gzip");
            }
        }

        Iterator var6 = this.headersByName.entrySet().iterator();

        while(var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            String var8 = (String)var7.getKey();
            boolean var9 = true;
            Iterator var10 = ((List)var7.getValue()).iterator();

            while(var10.hasNext()) {
                String var11 = (String)var10.next();
                if(var9) {
                    var5.setRequestProperty(var8, var11);
                    var9 = false;
                } else {
                    var5.addRequestProperty(var8, var11);
                }
            }
        }

        return var5;
    }

    private static void bypassSecureHostSslCertificateCheck(HttpsURLConnection var0, URL var1) {
        if(CommonsPropertiesUtil.isBypassCertificateCheck() && CommonsPropertiesUtil.getSecureHosts().contains(var1.getHost())) {
            X509TrustManager var2 = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] var1, String var2) {
                }

                public void checkServerTrusted(X509Certificate[] var1, String var2) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            SSLContext var3;
            try {
                var3 = SSLContext.getInstance("SSL");
            } catch (NoSuchAlgorithmException var6) {
                logger.warn("Can\'t get instance of SSL context.", var6);
                return;
            }

            try {
                var3.init((KeyManager[])null, new TrustManager[]{var2}, new SecureRandom());
            } catch (KeyManagementException var5) {
                logger.warn("Can\'t initialize SSL context.", var5);
                return;
            }

            var0.setSSLSocketFactory(var3.getSocketFactory());
        }
    }

    private static Proxy getProxy(String var0) {
        if(!Boolean.parseBoolean(System.getProperty("proxySet"))) {
            return null;
        } else if(!"http".equalsIgnoreCase(var0) && !"https".equalsIgnoreCase(var0)) {
            return null;
        } else {
            String var1 = System.getProperty(var0 + ".proxyHost");
            if(StringUtil.isBlank(var1)) {
                return null;
            } else {
                int var2;
                try {
                    var2 = Integer.parseInt(System.getProperty(var0 + ".proxyPort"));
                    if(var2 <= 0 || var2 > '\uffff') {
                        return null;
                    }
                } catch (NumberFormatException var4) {
                    return null;
                }

                return new Proxy(Type.HTTP, new InetSocketAddress(var1, var2));
            }
        }
    }

    private void writePostParameters(HttpURLConnection var1, Map var2) throws IOException {
        StringBuilder var3 = new StringBuilder();
        Iterator var4 = var2.entrySet().iterator();

        while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            String var6 = (String)var5.getKey();

            String var8;
            for(Iterator var7 = ((List)var5.getValue()).iterator(); var7.hasNext(); var3.append(var6).append('=').append(var8)) {
                var8 = (String)var7.next();
                if(var3.length() > 0) {
                    var3.append('&');
                }
            }
        }

        this.writeEntity(var1, var3.toString().getBytes(Charsets.UTF_8));
    }

    private void writeEntity(HttpURLConnection var1, byte[] var2) throws IOException {
        BufferedOutputStream var3 = new BufferedOutputStream((OutputStream)(this.gzip?new GZIPOutputStream(var1.getOutputStream()):var1.getOutputStream()), IoUtil.BUFFER_SIZE);
        long var4 = System.currentTimeMillis();
        boolean var13 = false;

        try {
            var13 = true;
            var3.write(var2);
            var3.flush();
            var3.close();
            var13 = false;
        } catch (IOException var14) {
            IoUtil.closeQuietly((AutoCloseable)var3);
            throw var14;
        } finally {
            if(var13) {
                long var9 = System.currentTimeMillis() - var4;
                if(var9 > 100L) {
                    logger.info(String.format("Writing of HTTP entity takes %d ms (size=%d, gzip=%s).", new Object[]{Long.valueOf(var9), Integer.valueOf(var2.length), Boolean.valueOf(this.gzip)}));
                }

            }
        }

        long var6 = System.currentTimeMillis() - var4;
        if(var6 > 100L) {
            logger.info(String.format("Writing of HTTP entity takes %d ms (size=%d, gzip=%s).", new Object[]{Long.valueOf(var6), Integer.valueOf(var2.length), Boolean.valueOf(this.gzip)}));
        }

    }

    static Map getDeepUnmodifiableMap(Map var0) {
        LinkedHashMap var1 = new LinkedHashMap(var0);
        Iterator var2 = var1.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var3.setValue(Collections.unmodifiableList(new ArrayList((Collection)var3.getValue())));
        }

        return Collections.unmodifiableMap(var1);
    }
}
