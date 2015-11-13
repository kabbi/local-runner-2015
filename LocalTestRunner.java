import com.a.b.class_32;
import com.a.b.a.a.e.EmptyStrategy;
import com.a.b.a.a.e.QuickStartGuyStrategy;
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

public final class LocalTestRunner {
    public static void main(String[] args) throws IOException {
//        Logger.getRootLogger().removeAllAppenders();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));

        Long var2 = getSeed(args, properties);
        MutableBoolean var3 = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("render-to-screen"))));
        MutableBoolean var4 = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("render-to-screen-sync"))));
        String var5 = getRenderToScreenSize(properties);
        String var6 = StringUtil.trimToEmpty(properties.getProperty("results-file"));
        String var7 = StringUtil.trimToEmpty(properties.getProperty("log-file"));
        String var8 = StringUtil.trimToEmpty(properties.getProperty("replay-file"));
        int var9 = getBaseAdapterPort(properties);
        String var10 = StringUtil.trimToEmpty(properties.getProperty("map"));
        var10 = Pattern.compile("[^_01-9a-zA-Z\\.\\-]+").matcher(var10).replaceAll("");
        if(!var10.isEmpty() && !var10.endsWith(".map")) {
            var10 = var10 + ".map";
        }

        int var11 = getTickCount(properties);
        int var12 = getTeamSize(properties);
        int var13 = getPlayerCount(properties);
        int var14 = getPsychoLevel(properties);
        boolean var15 = Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("swap-car-types")));
        boolean var16 = Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("loose-map-check")));
        String var17 = getPluginsDirectory(properties);
        String[] var18 = new String[var13];
        String[] var19 = new String[var13];
        setupPlayerNamesAndDefinitions(properties, var3, var4, var13, var18, var19);
        ArrayList<String> params = new ArrayList<>();
        if(var11 > 0) {
            params.add("-tick-count=" + var11);
        }

        params.add("-render-to-screen=" + var3.booleanValue());
        params.add("-render-to-screen-sync=" + var4.booleanValue());
        params.add("-render-to-screen-size=" + var5);
        params.add("-results-file=" + var6);
        params.add("-write-to-text-file=" + var7);
        params.add("-replay-file=" + var8);
        params.add("-map=" + var10);
        params.add("-debug=true");
        params.add("-base-adapter-port=" + var9);
        if(var2 != null) {
            params.add("-seed=" + var2);
        }

        if(var14 > 0) {
            params.add("-psycho-level=" + var14);
        }

        if(var15) {
            params.add("-swap-car-types=true");
        }

        if(var16) {
            params.add("-loose-map-check=true");
        }

        if(var17 != null) {
            params.add("-plugins-directory=" + var17);
        }

        for(int var21 = 0; var21 < var13; ++var21) {
            params.add("-p" + (var21 + 1) + "-name=" + var18[var21]);
            params.add("-p" + (var21 + 1) + "-team-size=" + var12);
            params.add(var19[var21]);
        }

        (new class_32(params.toArray(new String[params.size()]))).run();
    }

    private static void setupPlayerNamesAndDefinitions(Properties var0, MutableBoolean var1, MutableBoolean var2, int var3, String[] var4, String[] var5) {
        HashMap<String, Integer> var6 = new HashMap<>(var3);
        boolean var7 = false;

        for(int var8 = 0; var8 < var3; ++var8) {
            String playerType = StringUtil.trimToEmpty(var0.getProperty("p" + (var8 + 1) + "-type"));
            String playerName = StringUtil.trimToEmpty(var0.getProperty("p" + (var8 + 1) + "-name"));
            switch (playerType) {
                case "Local":
                    var5[var8] = "#LocalTestPlayer";
                    if(playerName.isEmpty()) {
                        playerName = "MyStrategy";
                    }
                    break;
                case "Quick":
                    var5[var8] = QuickStartGuyStrategy.class.getSimpleName() + ".class";
                    if(playerName.isEmpty()) {
                        playerName = "QuickStartGuy";
                    }
                    break;
                case "Smart":
                    var5[var8] = EmptyStrategy.class.getSimpleName() + ".class";
                    playerName = playerName.isEmpty() ? "EmptyPlayer" : playerName;
                    break;
                case "Keyboard":
                    if(var7) {
                        throw new IllegalArgumentException("Can\'t add two or more keyboard players.");
                    }

                    var7 = true;
                    var1.setValue(true);
                    var2.setValue(true);
                    var5[var8] = "#KeyboardPlayer";
                    if(playerName.isEmpty()) {
                        playerName = "KeyboardPlayer";
                    }
                    break;
                case "Empty":
                default:
                    var5[var8] = EmptyStrategy.class.getSimpleName() + ".class";
                    playerName = playerName.isEmpty()?"EmptyPlayer":playerName;
            }

            Integer var11 = var6.get(playerName);
            var11 = var11 == null ? 1 : var11 + 1;
            var6.put(playerName, var11);
            var4[var8] = var11 == 1 ? playerName:String.format("%s (%d)", playerName, var11);
        }

    }

    private static Long getSeed(String[] var0, Properties var1) {
        if(var0.length > 1) {
            try {
                return Long.valueOf(var0[1]);
            } catch (NumberFormatException ignored) {
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
