import com.a.b.class_32;
import com.a.b.a.a.e.class_30;
import com.a.b.a.a.e.class_31;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.log4j.Logger;

public final class LocalTestRunner {
    public static void main(String[] args) throws IOException {
//        Logger.getRootLogger().removeAllAppenders();
        Properties var1 = new Properties();
        var1.load(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        Long var2 = getSeed(args, var1);
        MutableBoolean var3 = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(var1.getProperty("render-to-screen"))));
        MutableBoolean var4 = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(var1.getProperty("render-to-screen-sync"))));
        String var5 = getRenderToScreenSize(var1);
        String var6 = StringUtil.trimToEmpty(var1.getProperty("results-file"));
        String var7 = StringUtil.trimToEmpty(var1.getProperty("log-file"));
        String var8 = StringUtil.trimToEmpty(var1.getProperty("replay-file"));
        int var9 = getBaseAdapterPort(var1);
        String var10 = StringUtil.trimToEmpty(var1.getProperty("map"));
        var10 = Pattern.compile("[^_01-9a-zA-Z\\.\\-]+").matcher(var10).replaceAll("");
        if(!var10.isEmpty() && !var10.endsWith(".map")) {
            var10 = var10 + ".map";
        }

        int var11 = getTickCount(var1);
        int var12 = getTeamSize(var1);
        int var13 = getPlayerCount(var1);
        int var14 = getPsychoLevel(var1);
        boolean var15 = Boolean.parseBoolean(StringUtil.trimToEmpty(var1.getProperty("swap-car-types")));
        boolean var16 = Boolean.parseBoolean(StringUtil.trimToEmpty(var1.getProperty("loose-map-check")));
        String var17 = getPluginsDirectory(var1);
        String[] var18 = new String[var13];
        String[] var19 = new String[var13];
        setupPlayerNamesAndDefinitions(var1, var3, var4, var13, var18, var19);
        ArrayList var20 = new ArrayList();
        if(var11 > 0) {
            var20.add("-tick-count=" + var11);
        }

        var20.add("-render-to-screen=" + var3.booleanValue());
        var20.add("-render-to-screen-sync=" + var4.booleanValue());
        var20.add("-render-to-screen-size=" + var5);
        var20.add("-results-file=" + var6);
        var20.add("-write-to-text-file=" + var7);
        var20.add("-replay-file=" + var8);
        var20.add("-map=" + var10);
        var20.add("-debug=true");
        var20.add("-base-adapter-port=" + var9);
        if(var2 != null) {
            var20.add("-seed=" + var2);
        }

        if(var14 > 0) {
            var20.add("-psycho-level=" + var14);
        }

        if(var15) {
            var20.add("-swap-car-types=true");
        }

        if(var16) {
            var20.add("-loose-map-check=true");
        }

        if(var17 != null) {
            var20.add("-plugins-directory=" + var17);
        }

        for(int var21 = 0; var21 < var13; ++var21) {
            var20.add("-p" + (var21 + 1) + "-name=" + var18[var21]);
            var20.add("-p" + (var21 + 1) + "-team-size=" + var12);
            var20.add(var19[var21]);
        }

        (new class_32((String[])var20.toArray(new String[var20.size()]))).run();
    }

    private static void setupPlayerNamesAndDefinitions(Properties var0, MutableBoolean var1, MutableBoolean var2, int var3, String[] var4, String[] var5) {
        HashMap var6 = new HashMap(var3);
        boolean var7 = false;

        for(int var8 = 0; var8 < var3; ++var8) {
            String var9 = StringUtil.trimToEmpty(var0.getProperty("p" + (var8 + 1) + "-type"));
            String var10 = StringUtil.trimToEmpty(var0.getProperty("p" + (var8 + 1) + "-name"));
            byte var12 = -1;
            switch(var9.hashCode()) {
            case 67081517:
                if(var9.equals("Empty")) {
                    var12 = 4;
                }
                break;
            case 73592651:
                if(var9.equals("Local")) {
                    var12 = 0;
                }
                break;
            case 78394829:
                if(var9.equals("Quick")) {
                    var12 = 1;
                }
                break;
            case 79996329:
                if(var9.equals("Smart")) {
                    var12 = 2;
                }
                break;
            case 568383495:
                if(var9.equals("Keyboard")) {
                    var12 = 3;
                }
            }

            switch(var12) {
            case 0:
                var5[var8] = "#LocalTestPlayer";
                if(var10.isEmpty()) {
                    var10 = "MyStrategy";
                }
                break;
            case 1:
                var5[var8] = class_31.class.getSimpleName() + ".class";
                if(var10.isEmpty()) {
                    var10 = "QuickStartGuy";
                }
                break;
            case 2:
                var5[var8] = class_30.class.getSimpleName() + ".class";
                var10 = var10.isEmpty()?"EmptyPlayer":var10;
                break;
            case 3:
                if(var7) {
                    throw new IllegalArgumentException("Can\'t add two or more keyboard players.");
                }

                var7 = true;
                var1.setValue(true);
                var2.setValue(true);
                var5[var8] = "#KeyboardPlayer";
                if(var10.isEmpty()) {
                    var10 = "KeyboardPlayer";
                }
                break;
            case 4:
            default:
                var5[var8] = class_30.class.getSimpleName() + ".class";
                var10 = var10.isEmpty()?"EmptyPlayer":var10;
            }

            Integer var11 = (Integer)var6.get(var10);
            var11 = var11 == null ? 1 : var11 + 1;
            var6.put(var10, var11);
            var4[var8] = var11 == 1?var10:String.format("%s (%d)", var10, var11);
        }

    }

    private static Long getSeed(String[] var0, Properties var1) {
        if(var0.length > 1) {
            try {
                return Long.valueOf(var0[1]);
            } catch (NumberFormatException var4) {
                ;
            }
        }

        try {
            return Long.valueOf(StringUtil.trimToEmpty(var1.getProperty("seed")));
        } catch (NumberFormatException var3) {
            return null;
        }
    }

    private static String getRenderToScreenSize(Properties var0) {
        return StringUtil.trimToEmpty(var0.getProperty("render-to-screen-size"));
    }

    private static int getBaseAdapterPort(Properties var0) {
        int var1;
        try {
            var1 = Integer.parseInt(StringUtil.trimToEmpty(var0.getProperty("base-adapter-port")));
            var1 = Math.max(Math.min(var1, '\uffff'), 1);
        } catch (NumberFormatException var3) {
            var1 = 31001;
        }

        return var1;
    }

    private static int getTickCount(Properties var0) {
        int var1;
        try {
            var1 = Integer.parseInt(StringUtil.trimToEmpty(var0.getProperty("tick-count")));
            var1 = Math.max(Math.min(var1, 10000000), 1000);
        } catch (NumberFormatException var3) {
            var1 = Integer.MIN_VALUE;
        }

        return var1;
    }

    private static int getTeamSize(Properties var0) {
        int var1;
        try {
            var1 = Integer.parseInt(StringUtil.trimToEmpty(var0.getProperty("team-size")));
            var1 = Math.max(Math.min(var1, 2), 1);
        } catch (NumberFormatException var3) {
            var1 = 1;
        }

        return var1;
    }

    private static int getPlayerCount(Properties var0) {
        int var1;
        try {
            var1 = Integer.parseInt(StringUtil.trimToEmpty(var0.getProperty("player-count")));
            var1 = Math.max(Math.min(var1, 4), 1);
        } catch (NumberFormatException var3) {
            var1 = 4;
        }

        return var1;
    }

    private static int getPsychoLevel(Properties var0) {
        int var1;
        try {
            var1 = Integer.parseInt(StringUtil.trimToEmpty(var0.getProperty("psycho-level")));
            var1 = Math.max(Math.min(var1, 255), 0);
        } catch (NumberFormatException var3) {
            var1 = 0;
        }

        return var1;
    }

    private static String getPluginsDirectory(Properties var0) {
        String var1 = var0.getProperty("plugins-directory");
        if(StringUtil.isBlank(var1) || !(new File(var1)).isDirectory()) {
            var1 = null;
        }

        return var1;
    }
}
