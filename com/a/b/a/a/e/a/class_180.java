package com.a.b.a.a.e.a;

import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.class_146;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;
import com.a.b.a.a.e.a.a.class_14;
import com.a.b.a.a.e.a.a.class_189;
import com.a.b.a.a.e.a.a.class_194;
import com.codeforces.commons.text.StringUtil;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.e.a.d
public class class_180 implements class_11 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_755 = LoggerFactory.getLogger(class_180.class);
    // $FF: renamed from: b java.util.concurrent.atomic.AtomicInteger
    private static final AtomicInteger field_756 = new AtomicInteger();
    // $FF: renamed from: c com.a.b.a.a.a.b
    private final GameProperties field_757;
    // $FF: renamed from: d java.lang.String
    private final String field_758;
    // $FF: renamed from: e boolean
    private final boolean field_759;
    // $FF: renamed from: f int
    private final int field_760;
    // $FF: renamed from: g int
    private final int field_761;
    // $FF: renamed from: h com.a.b.a.a.e.a.a.a
    private class_189 field_762;
    // $FF: renamed from: i com.a.b.a.a.e.a.a.e
    private class_14 field_763;
    // $FF: renamed from: j java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_764 = new AtomicBoolean(true);

    // $FF: renamed from: a (com.a.b.a.a.a.b, int, java.lang.String, int) com.a.b.a.a.e.a.d
    public static class_180 method_975(GameProperties var0, int var1, String var2, int var3) {
        method_977(var1, var3);
        Preconditions.checkArgument((new File(var2)).isFile(), "Argument \'playerDefinition\' is expected to be a file.");
        return new class_180(var0, var1, var2, var3, false);
    }

    // $FF: renamed from: b (com.a.b.a.a.a.b, int, java.lang.String, int) com.a.b.a.a.e.a.d
    public static class_180 method_976(GameProperties var0, int var1, String var2, int var3) {
        method_977(var1, var3);
        Preconditions.checkArgument("#LocalTestPlayer".equals(var2), "Argument \'playerDefinition\' is not \'#LocalTestPlayer\'.");
        return new class_180(var0, var1, var2, var3, true);
    }

    // $FF: renamed from: a (int, int) void
    private static void method_977(int var0, int var1) {
        Preconditions.checkArgument(var0 >= 0 && var0 <= 9, "Unexpected argument \'playerIndex\': " + var0 + '.');
        Preconditions.checkArgument(var1 >= 1 && var1 <= 9, "Unexpected argument \'teamSize\': " + var1 + '.');
    }

    private class_180(GameProperties var1, int var2, String var3, int var4, boolean var5) {
        this.field_760 = var2;
        this.field_757 = var1;
        this.field_758 = var3;
        this.field_761 = var4;
        this.field_759 = var5;
    }

    // $FF: renamed from: b () java.io.File
    public File method_978() {
        return this.field_762 == null?null:this.field_762.method_1006();
    }

    // $FF: renamed from: c () void
    public void method_979() {
        int var1 = this.field_757.getBaseAdapterPort() + field_756.getAndIncrement();
        String var2 = Integer.toString(var1);
        String var3;
        if(this.field_757.isDebug()) {
            var3 = StringUtils.repeat("0", 16);
        } else {
            var3 = RandomStringUtils.randomAlphanumeric(16);
        }

        File var4 = this.field_757.getTcpDumpFileForPlayer(this.field_760);
        this.field_763 = new class_194(this.field_757, var4);
        this.field_763.method_56(var1);
        if(!this.field_759) {
            long var5 = TimeUnit.MILLISECONDS.toSeconds(15L * (long)this.field_761 * (long)this.field_757.method_82() + 5000L + TimeUnit.SECONDS.toMillis(1L) - 1L);
            StringBuilder var7 = new StringBuilder();
            String var8 = this.field_757.getSystemUserLogin();
            if(!StringUtils.isBlank(var8)) {
                var7.append(" -l ").append(var8);
            }

            String var9 = this.field_757.getSystemUserPassword();
            if(!StringUtils.isBlank(var9)) {
                var7.append(" -p ").append(var9);
            }

            String var10 = method_981();
            HashMap var11 = new HashMap();
            var11.put("remote-process.port", var2);
            var11.put("time-limit-seconds", String.valueOf(var5));
            var11.put("system-user-credentials", var7.toString());
            var11.put("jruby-home", var10);
            var11.put("jruby-home.double-backslashed", StringUtil.replace(var10, "/", "\\\\"));

            try {
                File var12 = this.field_757.getCacheDirectory();
                this.field_762 = class_189.method_1009(this.field_758, var11, var12, new String[]{"127.0.0.1", var2, var3});
            } catch (IOException var13) {
                throw new class_177(String.format("Failed to start process for player \'%s\'.", new Object[]{this.field_758}), var13);
            }
        }

        this.method_980(var3);
    }

    // $FF: renamed from: a (java.lang.String) void
    private void method_980(String var1) {
        for(int var2 = 2; var2 >= 0; --var2) {
            String var3;
            try {
                this.field_763.method_57();
                var3 = this.field_763.method_58();
                if(var1.equals(var3)) {
                    break;
                }
            } catch (class_177 var5) {
                field_755.error("Got unexpected exception while authenticating strategy \'" + this.field_758 + "\'.", var5);
                if(var2 != 0) {
                    continue;
                }

                throw var5;
            }

            String var4 = String.format("Player \'%s\' has returned unexpected token: \'%s\' expected, but \'%s\' found.", new Object[]{this.field_758, var1, var3});
            field_755.error(var4);
            if(var2 == 0) {
                throw new class_177(var4);
            }
        }

    }

    // $FF: renamed from: a () int
    public int method_51() {
        this.field_763.method_59(this.field_761);
        return this.field_763.method_60();
    }

    // $FF: renamed from: a (com.a.b.a.a.c.l) void
    public void method_52(Game var1) {
        this.field_763.method_61(var1);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[], com.a.b.a.a.c.v) com.a.b.a.a.c.m[]
    public Move[] method_53(Car[] var1, World var2) {
        if(var1.length != this.field_761) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", new Object[]{this.getClass().getSimpleName(), Integer.valueOf(var1.length), Integer.valueOf(this.field_761)}));
        } else {
            this.field_763.method_62(new class_146(var1, var2), this.field_764.getAndSet(false));
            return this.field_763.method_63();
        }
    }

    public void close() {
        if(this.field_763 != null) {
            this.field_763.method_64();
        }

        (new Thread(new Runnable() {
            public void run() {
                if(class_180.this.field_762 != null) {
                    if(class_180.this.field_757.isDebug()) {
                        class_180.this.field_762.method_1007(TimeUnit.MINUTES.toMillis(20L));
                    } else {
                        class_180.this.field_762.method_1007(TimeUnit.SECONDS.toMillis(5L));
                    }
                }

                if(class_180.this.field_763 != null) {
                    class_180.this.field_763.method_65();
                }

                if(class_180.this.field_762 != null) {
                    class_180.this.field_762.method_1008();
                }

            }
        })).start();
    }

    // $FF: renamed from: d () java.lang.String
    private static String method_981() {
        String var0 = System.getenv("JRUBY_HOME");
        if(StringUtil.isNotBlank(var0)) {
            File var1 = new File(var0);
            if(var1.isDirectory() && (new File(var1, "bin")).isDirectory()) {
                for(var0 = var1.getAbsolutePath().replace('\\', '/'); var0.contains("//"); var0 = StringUtil.replace(var0, "//", "/")) {
                    ;
                }

                while(var0.endsWith("/")) {
                    var0 = var0.substring(0, var0.length() - 1);
                }

                return var0;
            }
        }

        String[] var8 = new String[]{"C:/Programs/", "C:/", "C:/Program Files/", "C:/Program Files (x86)/"};
        String[] var2 = new String[]{"jruby-9.0.3.0", "jruby-9.0.1.0", "jruby-1.7.13", "jruby"};
        int var3 = var8.length;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var3; ++var5) {
            for(int var6 = 0; var6 < var4; ++var6) {
                String var7 = var8[var5] + var2[var6];
                if((new File(var7)).isDirectory() && (new File(var7, "bin")).isDirectory()) {
                    return var7;
                }
            }
        }

        throw new class_177("Can\'t find JRuby home directory.");
    }
}
