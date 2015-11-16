import com.a.b.GameRunner;
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
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));

        Long seed = getSeed(args, properties);
        MutableBoolean renderToScreen = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("render-to-screen"))));
        MutableBoolean renderSync = new MutableBoolean(Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("render-to-screen-sync"))));
        String screenSize = getRenderToScreenSize(properties);
        String resultsFilePath = StringUtil.trimToEmpty(properties.getProperty("results-file"));
        String logFilePath = StringUtil.trimToEmpty(properties.getProperty("log-file"));
        String replayFilePath = StringUtil.trimToEmpty(properties.getProperty("replay-file"));
        int baseAdapterPort = getBaseAdapterPort(properties);
        String mapPath = StringUtil.trimToEmpty(properties.getProperty("map"));
        mapPath = Pattern.compile("[^_01-9a-zA-Z\\.\\-]+").matcher(mapPath).replaceAll("");
        if(!mapPath.isEmpty() && !mapPath.endsWith(".map")) {
            mapPath = mapPath + ".map";
        }

        int tickCount = getTickCount(properties);
        int teamSize = getTeamSize(properties);
        int playerCount = getPlayerCount(properties);
        int psychoLevel = getPsychoLevel(properties);
        boolean swapCarTypes = Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("swap-car-types")));
        boolean looseMapCheck = Boolean.parseBoolean(StringUtil.trimToEmpty(properties.getProperty("loose-map-check")));
        String pluginsDirectory = getPluginsDirectory(properties);
        String[] playerNames = new String[playerCount];
        String[] playerStrategies = new String[playerCount];
        setupPlayerNamesAndDefinitions(properties, renderToScreen, renderSync, playerCount, playerNames, playerStrategies);
        ArrayList<String> params = new ArrayList<>();
        if(tickCount > 0) {
            params.add("-tick-count=" + tickCount);
        }

        params.add("-render-to-screen=" + renderToScreen.booleanValue());
        params.add("-render-to-screen-sync=" + renderSync.booleanValue());
        params.add("-render-to-screen-size=" + screenSize);
        params.add("-results-file=" + resultsFilePath);
        params.add("-write-to-text-file=" + logFilePath);
        params.add("-replay-file=" + replayFilePath);
        params.add("-map=" + mapPath);
        params.add("-debug=true");
        params.add("-base-adapter-port=" + baseAdapterPort);
        if(seed != null) {
            params.add("-seed=" + seed);
        }

        if(psychoLevel > 0) {
            params.add("-psycho-level=" + psychoLevel);
        }

        if(swapCarTypes) {
            params.add("-swap-car-types=true");
        }

        if(looseMapCheck) {
            params.add("-loose-map-check=true");
        }

        if(pluginsDirectory != null) {
            params.add("-plugins-directory=" + pluginsDirectory);
        }

        for(int i = 0; i < playerCount; ++i) {
            params.add("-p" + (i + 1) + "-name=" + playerNames[i]);
            params.add("-p" + (i + 1) + "-team-size=" + teamSize);
            params.add(playerStrategies[i]);
        }

        (new GameRunner(params.toArray(new String[params.size()]))).run();
    }

    private static void setupPlayerNamesAndDefinitions(Properties properties, MutableBoolean var1, MutableBoolean var2, int playerCount, String[] playerNames, String[] playerStrategies) {
        HashMap<String, Integer> teamIndexByPlayerName = new HashMap<>(playerCount);
        boolean hasKeyboardPlayer = false;

        for(int i = 0; i < playerCount; ++i) {
            String playerType = StringUtil.trimToEmpty(properties.getProperty("p" + (i + 1) + "-type"));
            String playerName = StringUtil.trimToEmpty(properties.getProperty("p" + (i + 1) + "-name"));
            switch (playerType) {
                case "Local":
                    playerStrategies[i] = "#LocalTestPlayer";
                    if(playerName.isEmpty()) {
                        playerName = "MyStrategy";
                    }
                    break;
                case "Quick":
                    playerStrategies[i] = QuickStartGuyStrategy.class.getSimpleName() + ".class";
                    if(playerName.isEmpty()) {
                        playerName = "QuickStartGuy";
                    }
                    break;
                case "Smart":
                    playerStrategies[i] = EmptyStrategy.class.getSimpleName() + ".class";
                    playerName = playerName.isEmpty() ? "EmptyPlayer" : playerName;
                    break;
                case "Keyboard":
                    if(hasKeyboardPlayer) {
                        throw new IllegalArgumentException("Can\'t add two or more keyboard players.");
                    }

                    hasKeyboardPlayer = true;
                    var1.setValue(true);
                    var2.setValue(true);
                    playerStrategies[i] = "#KeyboardPlayer";
                    if(playerName.isEmpty()) {
                        playerName = "KeyboardPlayer";
                    }
                    break;
                case "Empty":
                default:
                    playerStrategies[i] = EmptyStrategy.class.getSimpleName() + ".class";
                    playerName = playerName.isEmpty()?"EmptyPlayer":playerName;
            }

            Integer teamIndex = teamIndexByPlayerName.get(playerName);
            teamIndex = teamIndex == null ? 1 : teamIndex + 1;
            teamIndexByPlayerName.put(playerName, teamIndex);
            playerNames[i] = teamIndex == 1 ? playerName : String.format("%s (%d)", playerName, teamIndex);
        }

    }

    private static Long getSeed(String[] args, Properties properties) {
        if(args.length > 1) {
            try {
                return Long.valueOf(args[1]);
            } catch (NumberFormatException ignored) {
                ;
            }
        }

        try {
            return Long.valueOf(StringUtil.trimToEmpty(properties.getProperty("seed")));
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private static String getRenderToScreenSize(Properties properties) {
        return StringUtil.trimToEmpty(properties.getProperty("render-to-screen-size"));
    }

    private static int getBaseAdapterPort(Properties properties) {
        int baseAdapterPort;
        try {
            baseAdapterPort = Integer.parseInt(StringUtil.trimToEmpty(properties.getProperty("base-adapter-port")));
            baseAdapterPort = Math.max(Math.min(baseAdapterPort, '\uffff'), 1);
        } catch (NumberFormatException ignore) {
            baseAdapterPort = 31001;
        }

        return baseAdapterPort;
    }

    private static int getTickCount(Properties properties) {
        int tickCount;
        try {
            tickCount = Integer.parseInt(StringUtil.trimToEmpty(properties.getProperty("tick-count")));
            tickCount = Math.max(Math.min(tickCount, 10000000), 1000);
        } catch (NumberFormatException ignore) {
            tickCount = Integer.MIN_VALUE;
        }

        return tickCount;
    }

    private static int getTeamSize(Properties properties) {
        int teamSize;
        try {
            teamSize = Integer.parseInt(StringUtil.trimToEmpty(properties.getProperty("team-size")));
            teamSize = Math.max(Math.min(teamSize, 2), 1);
        } catch (NumberFormatException ignore) {
            teamSize = 1;
        }

        return teamSize;
    }

    private static int getPlayerCount(Properties properties) {
        int playerCount;
        try {
            playerCount = Integer.parseInt(StringUtil.trimToEmpty(properties.getProperty("player-count")));
            playerCount = Math.max(Math.min(playerCount, 4), 1);
        } catch (NumberFormatException ignore) {
            playerCount = 4;
        }

        return playerCount;
    }

    private static int getPsychoLevel(Properties properties) {
        int psychoLevel;
        try {
            psychoLevel = Integer.parseInt(StringUtil.trimToEmpty(properties.getProperty("psycho-level")));
            psychoLevel = Math.max(Math.min(psychoLevel, 255), 0);
        } catch (NumberFormatException ignore) {
            psychoLevel = 0;
        }

        return psychoLevel;
    }

    private static String getPluginsDirectory(Properties properties) {
        String pluginsDirectory = properties.getProperty("plugins-directory");
        if(StringUtil.isBlank(pluginsDirectory) || !(new File(pluginsDirectory)).isDirectory()) {
            pluginsDirectory = null;
        }

        return pluginsDirectory;
    }
}
