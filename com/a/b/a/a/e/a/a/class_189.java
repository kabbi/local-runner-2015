package com.a.b.a.a.e.a.a;

import com.a.b.a.a.e.a.a.class_192;
import com.a.b.a.a.e.a.a.class_200;
import com.codeforces.commons.compress.ZipUtil;
import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.resource.ResourceUtil;
import com.codeforces.commons.text.StringUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.e.a.a.a
public class class_189 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_799 = LoggerFactory.getLogger(class_189.class);
    // $FF: renamed from: b java.lang.String
    private final String field_800;
    // $FF: renamed from: c java.lang.Process
    private final Process field_801;
    // $FF: renamed from: d java.io.File
    private final File field_802;
    // $FF: renamed from: e java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_803 = new AtomicBoolean();

    private class_189(String var1, Process var2, File var3) {
        this.field_800 = var1;
        this.field_801 = var2;
        this.field_802 = var3;
    }

    // $FF: renamed from: a () java.io.File
    public File method_1006() {
        return this.field_802;
    }

    // $FF: renamed from: a (long) void
    public void method_1007(long var1) {
        Thread var3 = new Thread(new Runnable() {
            public void run() {
                try {
                    class_189.this.field_801.waitFor();
                } catch (InterruptedException var2) {
                    ;
                }

            }
        });
        var3.start();

        try {
            var3.join(var1);
        } catch (InterruptedException var5) {
            var3.interrupt();
        }

    }

    // $FF: renamed from: b () void
    public void method_1008() {
        if(this.field_803.compareAndSet(false, true)) {
            this.field_801.destroy();

            try {
                this.field_801.waitFor();
                field_799.info("Process finished with exit code \'" + this.field_801.exitValue() + "\'.");
            } catch (InterruptedException var2) {
                ;
            }

        }
    }

    protected void finalize() throws Throwable {
        if(!this.field_803.get()) {
            field_799.error(String.format("Process \'%s\' in directory \'%s\' has not been destroyed.", this.field_800, this.field_802.getAbsolutePath()));
        }

        this.method_1008();
        super.finalize();
    }

    // $FF: renamed from: a (java.lang.String, java.util.Map, java.io.File, java.lang.String[]) com.a.b.a.a.e.a.a.a
    public static class_189 method_1009(String var0, Map var1, File var2, String... var3) throws IOException {
        File var4 = new File(var0);
        File var5 = method_1013(var4.getParentFile());
        String var6 = FilenameUtils.getExtension(var4.getName());
        class_192 var7;
        if("zip".equalsIgnoreCase(var6)) {
            ZipUtil.unzip(var4, var5);
            var7 = class_200.method_1063(var4.getName().substring(0, var4.getName().length() - ".zip".length()));
        } else {
            File var8 = new File(var5, var4.getName());
            Files.createSymbolicLink(FileSystems.getDefault().getPath(var8.getAbsolutePath()), FileSystems.getDefault().getPath(var4.getAbsolutePath()));
            var7 = class_200.method_1063(var0);
        }

        method_1012(var7, var5, var2, var1);
        String var13 = var7.method_1017(FilenameUtils.getName(var0), var1);
        ArrayList var9 = new ArrayList(Arrays.asList(method_1014(var5, var13)));
        Collections.addAll(var9, var3);
        if(!(new File((String)var9.get(0))).isAbsolute()) {
            var9.set(0, (new File(var5, (String)var9.get(0))).getAbsolutePath());
        }

        String var10 = method_1011(var9);
        File var11 = new File(var5, "run.bat");
        if(!FileUtil.isFile(var11)) {
            FileUtil.writeFile(var11, var10.getBytes(StandardCharsets.UTF_8));
        }

        Process var12 = (new ProcessBuilder(var9)).directory(var5).start();
        method_1010(var12, var12.getInputStream(), new File(var5, "runexe.output"));
        method_1010(var12, var12.getErrorStream(), new File(var5, "runexe.error"));
        field_799.info("Running \'" + var10 + "\' in the \'" + var5 + "\'.");
        return new class_189(var13, var12, var5);
    }

    // $FF: renamed from: a (java.lang.Process, java.io.InputStream, java.io.File) void
    private static void method_1010(final Process var0, final InputStream var1, final File var2) {
        (new Thread(new Runnable() {
            public void run() {
                try {
                    FileUtils.copyInputStreamToFile(var1, var2);
                } catch (IOException var2x) {
                    ;
                }

                class_189.field_799.debug("Completed to write stream from " + var0 + " to \'" + var2 + "\'.");
            }
        })).start();
    }

    // $FF: renamed from: a (java.util.List) java.lang.String
    private static String method_1011(List var0) {
        StringBuilder var1 = new StringBuilder();

        String var3;
        for(Iterator var2 = var0.iterator(); var2.hasNext(); var1.append('\"').append(var3).append('\"')) {
            var3 = (String)var2.next();
            if(var1.length() > 0) {
                var1.append(' ');
            }
        }

        return var1.toString();
    }

    // $FF: renamed from: a (com.a.b.a.a.e.a.a.d, java.io.File, java.io.File, java.util.Map) void
    private static void method_1012(class_192 var0, File var1, File var2, Map var3) throws IOException {
        Iterator var4 = var0.method_1018().iterator();

        while(true) {
            while(var4.hasNext()) {
                String var5 = (String)var4.next();
                if(var3 != null && var0.method_1019(var5)) {
                    InputStream var6 = null;

                    String var7;
                    try {
                        var6 = class_189.class.getResourceAsStream(var5);
                        var7 = new String(IoUtil.toByteArray(var6), StandardCharsets.UTF_8);

                        Entry var9;
                        for(Iterator var8 = var3.entrySet().iterator(); var8.hasNext(); var7 = StringUtil.replace(var7, "${" + (String)var9.getKey() + '}', (String)var9.getValue())) {
                            var9 = (Entry)var8.next();
                        }
                    } finally {
                        IoUtil.closeQuietly((AutoCloseable)var6);
                    }

                    File var13 = new File(var1, (new File(var5)).getName());
                    ResourceUtil.saveResourceToFile(var13, (String)null, var7.getBytes(StandardCharsets.UTF_8), (Class)null);
                } else {
                    ResourceUtil.copyResourceToDir(var1, var2, var5, (byte[])null, class_189.class, false);
                }
            }

            return;
        }
    }

    // $FF: renamed from: a (java.io.File) java.io.File
    private static File method_1013(File var0) throws IOException {
        File var1;
        do {
            var1 = new File(var0, String.format("%s-%s", (new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss")).format(new Date()), RandomStringUtils.randomAlphanumeric(4)));
        } while(var1.exists());

        if(!var1.mkdirs()) {
            throw new IOException("Can\'t create temporary directory \'" + var1 + "\'.");
        } else {
            return var1;
        }
    }

    // $FF: renamed from: a (java.io.File, java.lang.String) java.lang.String[]
    private static String[] method_1014(File var0, String var1) {
        if((new File(var0, var1)).exists()) {
            return new String[]{var1};
        } else {
            var1 = var1 + " ";
            boolean var2 = false;
            boolean var3 = false;
            StringBuilder var4 = new StringBuilder();
            ArrayList var5 = new ArrayList();

            for(int var6 = 0; var6 < var1.length(); ++var6) {
                char var7 = var1.charAt(var6);
                if(var7 == 92) {
                    var2 ^= true;
                    if(!var2) {
                        var4.append('\\');
                    }
                } else {
                    if(var7 == 34) {
                        if(!var2) {
                            var3 = !var3;
                        } else {
                            var4.append('\"');
                        }
                    } else {
                        if(var2) {
                            var4.append('\\');
                        }

                        if(var7 <= 32 && !var3) {
                            if(var4.length() > 0) {
                                var5.add(var4.toString());
                                var4.setLength(0);
                            }
                        } else {
                            var4.append(var7);
                        }
                    }

                    var2 = false;
                }
            }

            return (String[])var5.toArray(new String[var5.size()]);
        }
    }
}
