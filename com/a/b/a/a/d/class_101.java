package com.a.b.a.a.d;

import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.e.class_81;
import com.a.b.a.a.c.DecoratedWorld;
import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.io.http.HttpMethod;
import com.codeforces.commons.io.http.HttpRequest;
import com.codeforces.commons.io.http.HttpResponse;
import com.codeforces.commons.io.http.HttpUtil;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.process.ThreadUtil;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.log4j.Logger;

// $FF: renamed from: com.a.b.a.a.d.k
public class class_101 implements Renderer {
    // $FF: renamed from: a org.apache.log4j.Logger
    private static final Logger field_373 = Logger.getLogger(class_101.class);
    // $FF: renamed from: b java.util.concurrent.ExecutorService
    private final ExecutorService field_374 = Executors.newSingleThreadExecutor();
    // $FF: renamed from: c java.util.concurrent.atomic.AtomicReference
    private final AtomicReference field_375 = new AtomicReference();
    // $FF: renamed from: d java.lang.String
    private final String field_376;
    // $FF: renamed from: e com.a.b.a.a.a.b
    private final GameProperties field_377;
    // $FF: renamed from: f com.a.b.a.a.b.e.d
    private final class_81 field_378;
    // $FF: renamed from: g int
    private int field_379;
    // $FF: renamed from: h boolean
    private boolean field_380;
    // $FF: renamed from: i java.lang.StringBuilder
    private final StringBuilder field_381 = new StringBuilder(NumberUtil.toInt(67108864L));
    // $FF: renamed from: j java.lang.StringBuilder
    private StringBuilder field_382 = new StringBuilder();

    public class_101(String var1, GameProperties var2) {
        this.field_376 = var1;
        this.field_377 = var2;
        this.field_378 = new class_81(var2);
        this.method_624("");
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h) void
    public void render(final DecoratedWorld var1) throws IOException {
        this.method_628();
        this.field_374.execute(new Runnable() {
            public void run() {
                if(class_101.this.field_375.get() == null) {
                    try {
                        String var1x = class_101.this.field_378.method_485(var1);
                        class_101.method_632(class_101.this);
                        class_101.this.field_381.append(var1x).append('\n');
                        class_101.this.field_382.append(var1x).append('\n');
                        if(class_101.method_623(var1)) {
                            class_101.this.method_625("", false);
                        }
                    } catch (Error | RuntimeException var2) {
                        class_101.this.method_627(var2);
                    }

                }
            }
        });
    }

    public void close() throws IOException {
        this.field_374.shutdown();

        try {
            if(!this.field_374.awaitTermination(5L, TimeUnit.MINUTES)) {
                this.method_627(new IOException("Can\'t write game log file in the allotted time."));
            }
        } catch (InterruptedException var3) {
            this.method_627(new IOException("Unexpectedly interrupted while writing game log file.", var3));
        }

        this.method_628();
        this.method_625("", true);
        FileUtil.executeIoOperation(new ThreadUtil.Operation() {
            // $FF: renamed from: a () java.lang.Void
            public Void method_621() throws Exception {
                if(class_101.this.field_380) {
                    class_101.this.field_380 = false;
                    class_101.this.method_624("");
                    class_101.this.method_626(class_101.this.field_381.toString(), class_101.this.field_376, "", true);
                    if(class_101.this.field_380) {
                        throw new IOException("Can\'t save complete document \'" + class_101.this.field_376 + "\'.");
                    }
                }

                return null;
            }

            // $FF: synthetic method
            public Object run() throws Throwable {
                return this.method_621();
            }
        }, 4, 60000L, ThreadUtil.ExecutionStrategy.Type.LINEAR);

        try {
            this.field_380 = false;
            this.method_624("-meta");
            this.method_626((new GsonBuilder()).create().toJson((Object)(new class_101.class_205(InetAddress.getLocalHost().getHostName(), new Date(), this.field_379, this.field_377.method_80(), this.field_377.method_81(), null))), this.field_376, "-meta", true);
        } catch (RuntimeException var2) {
            ;
        }

    }

    // $FF: renamed from: c (com.a.b.a.a.c.h) boolean
    private static boolean method_623(DecoratedWorld var0) {
        return (var0.getTick() + 1) % 500 == 0;
    }

    // $FF: renamed from: a (java.lang.String) void
    private void method_624(String var1) {
        String var2 = this.field_376 + var1 + "/begin";

        try {
            HttpResponse var3 = HttpUtil.executePostRequestAndReturnResponse(20000, var2);
            if(var3.hasIoException()) {
                throw var3.getIoException();
            }

            if(var3.getCode() != 200) {
                throw new IOException(String.format("Got unexpected %s from remote storage \'%s\' while creating new document.", new Object[]{var3, var2}));
            }
        } catch (IOException var4) {
            field_373.error("Got I/O-exception while starting document \'" + var2 + "\'.", var4);
            this.field_380 = true;
        }

    }

    // $FF: renamed from: a (java.lang.String, boolean) void
    private void method_625(String var1, boolean var2) {
        this.method_626(this.field_382.toString(), this.field_376, var1, var2);
        this.field_382 = new StringBuilder();
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, boolean) void
    private void method_626(String var1, String var2, String var3, boolean var4) {
        if(!this.field_380) {
            String var5 = var2 + var3 + '/' + (var4?"end":"append");

            try {
                method_629(var1, var5);
            } catch (IOException var7) {
                field_373.error("Got I/O-exception while appending document \'" + var5 + "\'.", var7);
                this.field_380 = true;
            }

        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    private void method_627(Throwable var1) {
        this.field_375.compareAndSet((Object)null, var1);
    }

    // $FF: renamed from: a () void
    private void method_628() throws IOException {
        Throwable var1 = (Throwable)this.field_375.get();
        if(var1 != null) {
            if(var1 instanceof IOException) {
                throw (IOException)var1;
            } else if(var1 instanceof RuntimeException) {
                throw (RuntimeException)var1;
            } else if(var1 instanceof Error) {
                throw (Error)var1;
            } else {
                throw new IllegalStateException("Got unexpected async. throwable.", var1);
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) void
    private static void method_629(String var0, String var1) throws IOException {
        HttpResponse var2 = HttpRequest.create(var1, new Object[0]).setMethod(HttpMethod.POST).setBinaryEntity(var0.getBytes(StandardCharsets.UTF_8)).setGzip(true).setTimeoutMillis(20000).executeAndReturnResponse();
        if(var2.getCode() != 200) {
            throw new IOException(String.format("Got unexpected %s from remote storage \'%s\' while appending document.", new Object[]{var2, var1}));
        }
    }

    // $FF: renamed from: c (com.a.b.a.a.d.k) int
    // $FF: synthetic method
    static int method_632(class_101 var0) {
        return ++var0.field_379;
    }

    private static final class class_205 {
        // $FF: renamed from: a java.lang.String
        private final String field_101;
        // $FF: renamed from: b java.util.Date
        private final Date field_102;
        // $FF: renamed from: c int
        private final int field_103;
        // $FF: renamed from: d int
        private final int field_104;
        // $FF: renamed from: e int
        private final int field_105;

        private class_205(String var1, Date var2, int var3, int var4, int var5) {
            this.field_101 = var1;
            this.field_102 = var2;
            this.field_103 = var3;
            this.field_104 = var4;
            this.field_105 = var5;
        }

        // $FF: synthetic method
        class_205(String var1, Date var2, int var3, int var4, int var5, Object var6) {
            this(var1, var2, var3, var4, var5);
        }
    }
}
