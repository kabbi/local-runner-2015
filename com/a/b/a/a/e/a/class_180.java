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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.e.a.d
public class class_180 implements StrategyAdapter {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(class_180.class);
    // $FF: renamed from: b java.util.concurrent.atomic.AtomicInteger
    private static final AtomicInteger nextAdapterPort = new AtomicInteger();
    // $FF: renamed from: c com.a.b.a.a.a.b
    private final GameProperties gameProperties;
    // $FF: renamed from: d java.lang.String
    private final String playerDefinition;
    // $FF: renamed from: e boolean
    private final boolean remote;
    // $FF: renamed from: f int
    private final int playerIndex;
    // $FF: renamed from: g int
    private final int teamSize;
    // $FF: renamed from: h com.a.b.a.a.e.a.a.a
    private class_189 field_762;
    // $FF: renamed from: i com.a.b.a.a.e.a.a.e
    private class_14 field_763;
    // $FF: renamed from: j java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_764 = new AtomicBoolean(true);

    // $FF: renamed from: a (com.a.b.a.a.a.b, int, java.lang.String, int) com.a.b.a.a.e.a.d
    public static class_180 createFromFile(GameProperties gameProperties, int playerIndex, String playerDefinition, int teamSize) {
        validateArguments(playerIndex, teamSize);
        Preconditions.checkArgument((new File(playerDefinition)).isFile(), "Argument \'playerDefinition\' is expected to be a file.");
        return new class_180(gameProperties, playerIndex, playerDefinition, teamSize, false);
    }

    // $FF: renamed from: b (com.a.b.a.a.a.b, int, java.lang.String, int) com.a.b.a.a.e.a.d
    public static class_180 createRemote(GameProperties gameProperties, int playerIndex, String playerDefinition, int teamSize) {
        validateArguments(playerIndex, teamSize);
        Preconditions.checkArgument("#LocalTestPlayer".equals(playerDefinition), "Argument \'playerDefinition\' is not \'#LocalTestPlayer\'.");
        return new class_180(gameProperties, playerIndex, playerDefinition, teamSize, true);
    }

    // $FF: renamed from: a (int, int) void
    private static void validateArguments(int playerIndex, int teamSize) {
        Preconditions.checkArgument(playerIndex >= 0 && playerIndex <= 9, "Unexpected argument \'playerIndex\': " + playerIndex + '.');
        Preconditions.checkArgument(teamSize >= 1 && teamSize <= 9, "Unexpected argument \'teamSize\': " + teamSize + '.');
    }

    private class_180(GameProperties gameProperties, int playerIndex, String playerDefinition, int teamSize, boolean remote) {
        this.playerIndex = playerIndex;
        this.gameProperties = gameProperties;
        this.playerDefinition = playerDefinition;
        this.teamSize = teamSize;
        this.remote = remote;
    }

    // $FF: renamed from: b () java.io.File
    public File method_978() {
        return this.field_762 == null ? null : this.field_762.method_1006();
    }

    // $FF: renamed from: c () void
    public void method_979() {
        int var1 = this.gameProperties.getBaseAdapterPort() + nextAdapterPort.getAndIncrement();
        String var2 = Integer.toString(var1);
        String authToken;
        if(this.gameProperties.isDebug()) {
            authToken = StringUtils.repeat("0", 16);
        } else {
            authToken = RandomStringUtils.randomAlphanumeric(16);
        }

        File var4 = this.gameProperties.getTcpDumpFileForPlayer(this.playerIndex);
        this.field_763 = new class_194(this.gameProperties, var4);
        this.field_763.method_56(var1);
        if(!this.remote) {
            long var5 = TimeUnit.MILLISECONDS.toSeconds(15L * (long)this.teamSize * (long)this.gameProperties.method_82() + 5000L + TimeUnit.SECONDS.toMillis(1L) - 1L);
            StringBuilder var7 = new StringBuilder();
            String var8 = this.gameProperties.getSystemUserLogin();
            if(!StringUtils.isBlank(var8)) {
                var7.append(" -l ").append(var8);
            }

            String var9 = this.gameProperties.getSystemUserPassword();
            if(!StringUtils.isBlank(var9)) {
                var7.append(" -p ").append(var9);
            }

            String var10 = findJRubyHomeDirectory();
            Map<String, String> params = new HashMap<>();
            params.put("remote-process.port", var2);
            params.put("time-limit-seconds", String.valueOf(var5));
            params.put("system-user-credentials", var7.toString());
            params.put("jruby-home", var10);
            params.put("jruby-home.double-backslashed", StringUtil.replace(var10, "/", "\\\\"));

            try {
                File var12 = this.gameProperties.getCacheDirectory();
                this.field_762 = class_189.startProcess(this.playerDefinition, params, var12, new String[]{"127.0.0.1", var2, authToken});
            } catch (IOException var13) {
                throw new RemotePlayerException(String.format("Failed to start process for player \'%s\'.", new Object[]{this.playerDefinition}), var13);
            }
        }

        this.authenticatePlayer(authToken);
    }

    // $FF: renamed from: a (java.lang.String) void
    private void authenticatePlayer(String var1) {
        for(int attempts = 2; attempts >= 0; --attempts) {
            String var3;
            try {
                this.field_763.method_57();
                var3 = this.field_763.method_58();
                if(var1.equals(var3)) {
                    break;
                }
            } catch (RemotePlayerException e) {
                logger.error("Got unexpected exception while authenticating strategy \'" + this.playerDefinition + "\'.", e);
                if(attempts != 0) {
                    continue;
                }

                throw e;
            }

            String errorMessage = String.format("Player \'%s\' has returned unexpected token: \'%s\' expected, but \'%s\' found.", this.playerDefinition, var1, var3);
            logger.error(errorMessage);
            if(attempts == 0) {
                throw new RemotePlayerException(errorMessage);
            }
        }

    }

    // $FF: renamed from: a () int
    public int method_51() {
        this.field_763.method_59(this.teamSize);
        return this.field_763.method_60();
    }

    // $FF: renamed from: a (com.a.b.a.a.c.l) void
    public void method_52(Game var1) {
        this.field_763.method_61(var1);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[], com.a.b.a.a.c.v) com.a.b.a.a.c.m[]
    public Move[] method_53(Car[] var1, World var2) {
        if(var1.length != this.teamSize) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", new Object[]{this.getClass().getSimpleName(), Integer.valueOf(var1.length), Integer.valueOf(this.teamSize)}));
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
                    if(class_180.this.gameProperties.isDebug()) {
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
    private static String findJRubyHomeDirectory() {
        String homeEnv = System.getenv("JRUBY_HOME");
        if(StringUtil.isNotBlank(homeEnv)) {
            File directory = new File(homeEnv);
            if(directory.isDirectory() && (new File(directory, "bin")).isDirectory()) {
                for(homeEnv = directory.getAbsolutePath().replace('\\', '/'); homeEnv.contains("//"); homeEnv = StringUtil.replace(homeEnv, "//", "/")) {
                    ;
                }

                while(homeEnv.endsWith("/")) {
                    homeEnv = homeEnv.substring(0, homeEnv.length() - 1);
                }

                return homeEnv;
            }
        }

        String[] possiblePathes = new String[]{"C:/Programs/", "C:/", "C:/Program Files/", "C:/Program Files (x86)/"};
        String[] possibleVersions = new String[]{"jruby-9.0.3.0", "jruby-9.0.1.0", "jruby-1.7.13", "jruby"};

        for (String possiblePath : possiblePathes) {
            for (String possibleVersion : possibleVersions) {
                String path = possiblePath + possibleVersion;
                if ((new File(path)).isDirectory() && (new File(path, "bin")).isDirectory()) {
                    return path;
                }
            }
        }

        throw new RemotePlayerException("Can\'t find JRuby home directory.");
    }
}
