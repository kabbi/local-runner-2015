package com.a.b.a.a.a;

import com.a.a.a.a.RandomUtils;
import com.a.b.a.a.b.e.MapUtils;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.SimplePair;
import com.codeforces.commons.text.StringUtil;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.a.b
public class GameProperties {
    // $FF: renamed from: b org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(GameProperties.class);
    // $FF: renamed from: a com.a.b.a.a.a.b
    public static final GameProperties instance = new GameProperties();
    // $FF: renamed from: c java.util.regex.Pattern
    private static final Pattern ADAPTER_PORT_PATTERN = Pattern.compile("[1-5][\\d]{4}");
    // $FF: renamed from: d java.util.regex.Pattern
    private static final Pattern TICK_COUNT_PATTERN = Pattern.compile("[1-9][0-9]{0,7}");
    // $FF: renamed from: e java.util.regex.Pattern
    private static final Pattern TEAM_SIZE_PATTERN = Pattern.compile("[1-2]");
    // $FF: renamed from: f java.util.regex.Pattern
    private static final Pattern SCREEN_DIMENSION_PATTERN = Pattern.compile("[1-9][0-9]{0,3}x[1-9][0-9]{0,3}");
    // $FF: renamed from: g java.util.Map
    private final java.util.Map keyValueArguments;
    // $FF: renamed from: h java.util.List
    private final List<String> positionalArguments;
    // $FF: renamed from: i int
    private int screenWidth;
    // $FF: renamed from: j int
    private int screenHeight;
    // $FF: renamed from: k java.lang.Integer
    private Integer tickCount;

    private GameProperties() {
        this.keyValueArguments = Collections.emptyMap();
        this.positionalArguments = Collections.emptyList();
    }

    public GameProperties(String[] args) {
        this(parseKeyValueArguments(args), parsePositionalArguments(args));
    }

    public GameProperties(java.util.Map keyValueArguments, List<String> positionalArguments) {
        this.keyValueArguments = new HashMap<>(keyValueArguments);
        this.positionalArguments = new ArrayList<>(positionalArguments);
        this.normalizeArguments();
        this.screenWidth = getScreenDimension(this.keyValueArguments, true);
        this.screenHeight = getScreenDimension(this.keyValueArguments, false);
        this.tickCount = getTickCount(this.keyValueArguments);
    }

    // $FF: renamed from: a () java.util.List
    public List<String> getPositionalArguments() {
        return Collections.unmodifiableList(this.positionalArguments);
    }

    // $FF: renamed from: b () int
    public int getScreenWidth() {
        return this.screenWidth;
    }

    // $FF: renamed from: c () int
    public int getScreenHeight() {
        return this.screenHeight;
    }

    // $FF: renamed from: d () java.lang.String
    public String getMapFilePath() {
        String mapFilePath = StringUtil.trimToNull(this.keyValueArguments.get("map"));
        return mapFilePath == null ? "default" : mapFilePath;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_77(String var1) {
        var1 = StringUtil.trimToNull(var1);
        if(var1 == null) {
            this.keyValueArguments.remove("map");
        } else {
            this.keyValueArguments.put("map", FilenameUtils.getBaseName(var1));
        }

    }

    // $FF: renamed from: b (java.lang.String) com.a.b.a.a.b.e.i$a
    public MapUtils.Map method_78(String var1) {
        return MapUtils.loadMap(var1, this.shouldCheckMapLoosely());
    }

    // $FF: renamed from: e () com.a.b.a.a.b.e.i$a
    public MapUtils.Map method_79() {
        return this.method_78(this.getMapFilePath());
    }

    // $FF: renamed from: f () int
    public int method_80() {
        return this.method_79().getTilesXY().length;
    }

    // $FF: renamed from: g () int
    public int method_81() {
        return this.method_79().getTilesXY()[0].length;
    }

    // $FF: renamed from: h () int
    public int method_82() {
        return this.tickCount == null ? 180 + this.method_79().method_416() * 4 : this.tickCount;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String getPlayerName(int playerIndex) {
        String var2 = this.keyValueArguments.get("p" + (playerIndex + 1) + "-name");
        return StringUtils.isBlank(var2)?"Player #" + (playerIndex + 1):var2;
    }

    // $FF: renamed from: b (int) int
    public int getTeamSizeForPlayer(int playerIndex) {
        logger.debug("Parsing team size for player #" + (playerIndex + 1) + '.');
        String teamSizeStr = this.keyValueArguments.get("p" + (playerIndex + 1) + "-team-size");
        if(StringUtils.isBlank(teamSizeStr)) {
            return 2;
        } else if(!TEAM_SIZE_PATTERN.matcher(teamSizeStr).matches()) {
            throw new IllegalArgumentException("Illegal team size value: \'" + teamSizeStr + "\'.");
        } else {
            return Integer.parseInt(teamSizeStr);
        }
    }

    // $FF: renamed from: i () java.io.File
    public File getReplayFile() {
        String replayFile = this.keyValueArguments.get("replay-file");
        return StringUtil.isBlank(replayFile) ? null : new File(replayFile);
    }

    // $FF: renamed from: j () java.io.File
    public File getResultsFile() {
        String resultsFile = this.keyValueArguments.get("results-file");
        return StringUtil.isBlank(resultsFile) ? null : new File(resultsFile);
    }

    // $FF: renamed from: k () java.io.File
    public File getStrategyDescriptionFile() {
        String strategyDescriptionFile = this.keyValueArguments.get("strategy-description-file");
        return StringUtil.isBlank(strategyDescriptionFile) ? null : new File(strategyDescriptionFile);
    }

    // $FF: renamed from: l () java.io.File
    public File getAttributesFile() {
        String attributesFile = this.keyValueArguments.get("attributes-file");
        return StringUtil.isBlank(attributesFile) ? null : new File(attributesFile);
    }

    // $FF: renamed from: m () java.io.File
    public File getPluginsDirectory() {
        String pluginsDirectory = this.keyValueArguments.get("plugins-directory");
        return StringUtil.isBlank(pluginsDirectory) ? null : new File(pluginsDirectory);
    }

    // $FF: renamed from: n () boolean
    public boolean isDebug() {
        return parseBoolean(this.keyValueArguments.get("debug"));
    }

    // $FF: renamed from: o () boolean
    public boolean shouldRenderToScreen() {
        return parseBoolean(this.keyValueArguments.get("render-to-screen"));
    }

    // $FF: renamed from: p () boolean
    public boolean shouldRenderSync() {
        return parseBoolean(this.keyValueArguments.get("render-to-screen-sync"));
    }

    // $FF: renamed from: q () boolean
    public boolean isLocalTestGame() {
        return parseBoolean(this.keyValueArguments.get("local-test"));
    }

    // $FF: renamed from: r () boolean
    public boolean isVerificationGame() {
        return parseBoolean(this.keyValueArguments.get("verification-game"));
    }

    // $FF: renamed from: s () java.io.File
    public File getSomeTextFile() {
        String fileName = this.keyValueArguments.get("write-to-text-file");
        return StringUtil.isBlank(fileName) ? null : new File(fileName);
    }

    // $FF: renamed from: t () java.lang.String
    public String shouldWriteToRemoteStorage() {
        return this.keyValueArguments.get("write-to-remote-storage");
    }

    // $FF: renamed from: u () java.lang.String
    public String getSystemUserLogin() {
        return this.keyValueArguments.get("system-user-login");
    }

    // $FF: renamed from: v () java.lang.String
    public String getSystemUserPassword() {
        return this.keyValueArguments.get("system-user-password");
    }

    // $FF: renamed from: w () int
    public int getBaseAdapterPort() {
        String adapterPortStr = this.keyValueArguments.get("base-adapter-port");
        Preconditions.checkArgument(!StringUtils.isBlank(adapterPortStr) && ADAPTER_PORT_PATTERN.matcher(adapterPortStr).matches(), "Argument \'base-adapter-port\' is expected to be an integer between 10000 and 59999 inclusive.");
        return Integer.parseInt(adapterPortStr);
    }

    // $FF: renamed from: c (int) java.io.File
    public File getTcpDumpFileForPlayer(int playerIndex) {
        boolean var2 = parseBoolean(this.keyValueArguments.get("dump-tcp-data"));
        return var2?new File("p" + (playerIndex + 1) + "-tcp-dump.bin"):null;
    }

    // $FF: renamed from: x () java.lang.Long
    public Long getSeed() {
        String seedStr = this.keyValueArguments.get("seed");
        return StringUtils.isBlank(seedStr) ? null : Long.parseLong(seedStr);
    }

    // $FF: renamed from: y () java.io.File
    public File getCacheDirectory() {
        String var1 = this.keyValueArguments.get("cache-directory");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: z () boolean
    public boolean shouldLogDrifting() {
        return parseBoolean(this.keyValueArguments.get("log-drifting"));
    }

    // $FF: renamed from: A () boolean
    public boolean shouldLogMaxSpeed() {
        return parseBoolean(this.keyValueArguments.get("log-max-speed"));
    }

    // $FF: renamed from: B () boolean
    public boolean shouldSwapCarTypes() {
        return parseBoolean(this.keyValueArguments.get("swap-car-types"));
    }

    // $FF: renamed from: C () boolean
    public boolean shouldCheckMapLoosely() {
        return parseBoolean(this.keyValueArguments.get("loose-map-check"));
    }

    // $FF: renamed from: D () int
    public int getPsychoLevel() {
        try {
            return Math.max(Math.min(Integer.parseInt(this.keyValueArguments.get("psycho-level")), 255), 0);
        } catch (NumberFormatException ignore) {
            return 0;
        }
    }

    // $FF: renamed from: a (java.util.Map, boolean) int
    private static int getScreenDimension(java.util.Map args, boolean firstOrSecond) {
        String screenSize = StringUtil.trimToNull(args.get("render-to-screen-size"));
        if(screenSize == null) {
            screenSize = "1280x800";
        }

        int separatorPosition = screenSize.indexOf('x');
        if(separatorPosition > 0 && separatorPosition != screenSize.length() - 1 && SCREEN_DIMENSION_PATTERN.matcher(screenSize).matches()) {
            int dimension = Integer.parseInt(firstOrSecond ? screenSize.substring(0, separatorPosition) : screenSize.substring(separatorPosition + 1));
            if(dimension >= 100 && dimension <= 100000) {
                return dimension;
            } else {
                throw new IllegalArgumentException(String.format("Illegal screen size dimension (%s): \'%d\'.", firstOrSecond ? "first" : "second", dimension));
            }
        } else {
            throw new IllegalArgumentException("Illegal screen size value: \'" + screenSize + "\'.");
        }
    }

    // $FF: renamed from: a (java.util.Map) java.lang.Integer
    private static Integer getTickCount(java.util.Map args) {
        logger.debug("Parsing tick count.");
        String tickCountStr = StringUtil.trimToNull(args.get("tick-count"));
        if(tickCountStr != null && !"0".equals(tickCountStr) && !tickCountStr.startsWith("-")) {
            if(!TICK_COUNT_PATTERN.matcher(tickCountStr).matches()) {
                throw new IllegalArgumentException("Illegal tick count value: \'" + tickCountStr + "\'.");
            } else {
                return Integer.parseInt(tickCountStr);
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: c (java.lang.String) boolean
    private static boolean parseBoolean(String booleanStr) {
        return Boolean.parseBoolean(booleanStr) || BooleanUtils.toBoolean(booleanStr) || "1".equals(booleanStr);
    }

    // $FF: renamed from: a (java.lang.String[]) java.util.Map
    private static java.util.Map parseKeyValueArguments(String[] args) {
        java.util.Map arguments = new HashMap<>();

        for (String arg : args) {
            if (arg.startsWith("-")) {
                SimplePair<String, String> argument = parseKeyValueArgument(arg.substring("-".length()));
                arguments.put(argument.getFirst(), argument.getSecond());
            }
        }

        return arguments;
    }

    // $FF: renamed from: b (java.lang.String[]) java.util.List
    private static List<String> parsePositionalArguments(String[] args) {
        List<String> arguments = new ArrayList<>();

        for (String arg : args) {
            if (!arg.startsWith("-")) {
                arguments.add(arg);
            }
        }

        return arguments;
    }

    // $FF: renamed from: d (java.lang.String) com.codeforces.commons.pair.SimplePair
    private static SimplePair<String, String> parseKeyValueArgument(String arg) {
        int equalsPosition = arg.indexOf('=');
        if(equalsPosition <= 0) {
            throw new IllegalArgumentException("Illegal property string: \'" + arg + "\'.");
        } else {
            return new SimplePair<>(arg.substring(0, equalsPosition), arg.substring(equalsPosition + 1));
        }
    }

    // $FF: renamed from: E () void
    private void normalizeArguments() {

        for (String argument : this.positionalArguments) {
            if ("#KeyboardPlayer".equals(argument)) {
                this.keyValueArguments.put("debug", "true");
                this.keyValueArguments.put("keyboard-player", "true");
                this.keyValueArguments.put("render-to-screen", "true");
                this.keyValueArguments.put("render-to-screen-sync", "true");
            } else if ("#LocalTestPlayer".equals(argument)) {
                this.keyValueArguments.put("debug", "true");
                this.keyValueArguments.put("local-test", "true");
            }
        }

        if(StringUtils.isBlank(this.keyValueArguments.get("map"))) {
            this.keyValueArguments.put("map", "default.map");
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.a.b) void
    public static void initRandomAndSeed(GameProperties gameProperties) {
        Long seed = gameProperties.getSeed();
        if(seed == null) {
            gameProperties.keyValueArguments.put("seed", String.valueOf(RandomUtils.generateSeed()));
            seed = gameProperties.getSeed();
        }

        RandomUtils.initRandomInstance(true, seed.longValue());
        logger.info("Starting game with seed \'" + seed + "\'.");
    }
}
