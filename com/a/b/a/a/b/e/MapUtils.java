package com.a.b.a.a.b.e;

import com.a.b.a.a.c.TileType;
import com.a.b.a.a.c.Direction;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import com.codeforces.commons.resource.CantReadResourceException;
import com.codeforces.commons.resource.ResourceUtil;
import com.codeforces.commons.text.Patterns;
import com.codeforces.commons.text.StringUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.mutable.MutableInt;

// $FF: renamed from: com.a.b.a.a.b.e.i
public final class MapUtils {
    // $FF: renamed from: a java.util.regex.Pattern
    private static final Pattern LOOSE_MAP_DIMENSION_PATTERN = Pattern.compile("[3-9]|[1-9][0-9]");
    // $FF: renamed from: b java.util.regex.Pattern
    private static final Pattern MAP_DIMENSION_PATTERN = Pattern.compile("[8-9]|1[01-6]");
    // $FF: renamed from: c java.util.regex.Pattern
    private static final Pattern field_318 = Pattern.compile("[1-9]?[0-9]");
    // $FF: renamed from: d java.util.Set
    private static final Set field_319 = Collections.unmodifiableSet(EnumSet.of(TileType.HORIZONTAL, TileType.LEFT_TOP_CORNER, TileType.LEFT_BOTTOM_CORNER, TileType.RIGHT_HEADED_T, TileType.TOP_HEADED_T, TileType.BOTTOM_HEADED_T, TileType.CROSSROADS));
    // $FF: renamed from: e java.util.Set
    private static final Set field_320 = Collections.unmodifiableSet(EnumSet.of(TileType.HORIZONTAL, TileType.RIGHT_TOP_CORNER, TileType.RIGHT_BOTTOM_CORNER, TileType.LEFT_HEADED_T, TileType.TOP_HEADED_T, TileType.BOTTOM_HEADED_T, TileType.CROSSROADS));
    // $FF: renamed from: f java.util.Set
    private static final Set field_321 = Collections.unmodifiableSet(EnumSet.of(TileType.VERTICAL, TileType.LEFT_TOP_CORNER, TileType.RIGHT_TOP_CORNER, TileType.LEFT_HEADED_T, TileType.RIGHT_HEADED_T, TileType.BOTTOM_HEADED_T, TileType.CROSSROADS));
    // $FF: renamed from: g java.util.Set
    private static final Set field_322 = Collections.unmodifiableSet(EnumSet.of(TileType.VERTICAL, TileType.LEFT_BOTTOM_CORNER, TileType.RIGHT_BOTTOM_CORNER, TileType.LEFT_HEADED_T, TileType.RIGHT_HEADED_T, TileType.TOP_HEADED_T, TileType.CROSSROADS));
    // $FF: renamed from: h int
    private static final int field_323 = (5 + 25) * ((25 - 5) / 5 + 1) / 2; // what??
    // $FF: renamed from: i java.util.concurrent.ConcurrentMap
    private static final ConcurrentMap<String, Map> mapCache = new ConcurrentHashMap<>();

    // $FF: renamed from: a (java.lang.String, boolean) com.a.b.a.a.b.e.i$a
    public static Map loadMap(String mapFilePath, boolean looseCheck) {
        mapFilePath = FilenameUtils.getBaseName(mapFilePath);
        Map map = mapCache.get(mapFilePath);
        if(map == null) {
            byte[] mapData = readMapContent(mapFilePath + ".map");
            String[] mapLines = Patterns.LINE_BREAK_PATTERN.split(new String(mapData, StandardCharsets.UTF_8));
            MutableInt currentLinePtr = new MutableInt(0);
            MutableInt var6 = new MutableInt(0);
            TileType[][] mapTiles = parseMapDimensions(mapLines, currentLinePtr, looseCheck);
            if(mapTiles.length > 0) {
                parseMapTiles(mapTiles, mapLines, currentLinePtr, mapTiles.length, mapTiles[0].length);
                method_506(mapTiles, mapTiles.length, mapTiles[0].length);
            }

            IntPair[] var8 = method_508(mapLines, currentLinePtr);
            if(var8.length > 0) {
                method_509(var8, mapLines, currentLinePtr, mapTiles, mapTiles.length, mapTiles[0].length);
                method_510(var8, mapTiles, mapTiles.length, mapTiles[0].length, var6);
            }

            Direction startingDirection = parseStartingDirection(mapLines, currentLinePtr, mapTiles, var8);
            map = new Map(mapFilePath, mapTiles, var8, startingDirection, var6.intValue());
            mapCache.putIfAbsent(mapFilePath, map);
        }

        return map;
    }

    // $FF: renamed from: a (java.lang.String) byte[]
    private static byte[] readMapContent(String mapFilePath) {
        byte[] data = ResourceUtil.getResourceOrNull(WorldUtils.class, "/maps/" + mapFilePath);
        if(data == null) {
            try {
                File mapFile = new File(mapFilePath);
                if(!mapFile.isFile()) {
                    throw new CantReadResourceException("Map file \'" + mapFilePath + "\' is not found in current directory.");
                }

                if(mapFile.length() > 8388608L) {
                    throw new CantReadResourceException(String.format("Size of the map file \'%s\' is greater than %d B.", mapFilePath, 8388608L));
                }

                data = FileUtils.readFileToByteArray(mapFile);
            } catch (IOException e) {
                throw new CantReadResourceException("Can\'t read map file \'" + mapFilePath + "\' from current directory.", e);
            }
        }

        return data;
    }

    // $FF: renamed from: a (java.lang.String[], org.apache.commons.lang3.mutable.MutableInt, boolean) com.a.b.a.a.c.t[][]
    private static TileType[][] parseMapDimensions(String[] mapLines, MutableInt currentLinePtr, boolean looseCheck) {
        TileType[][] mapTiles;
        for(mapTiles = null; currentLinePtr.intValue() < mapLines.length && mapTiles == null; currentLinePtr.increment()) {
            String mapLine = mapLines[currentLinePtr.intValue()];
            if(StringUtil.isNotBlank(mapLine) && mapLine.indexOf('#') != 0) {
                String[] widthHeightStr = Patterns.WHITESPACE_PATTERN.split(mapLine.trim());
                if(widthHeightStr.length < 2) {
                    throw new CantReadResourceException("Can\'t parse width and height of the map.");
                }

                Pattern dimensinPattern = looseCheck ? LOOSE_MAP_DIMENSION_PATTERN : MAP_DIMENSION_PATTERN;
                String widthStr = widthHeightStr[0];
                if(!dimensinPattern.matcher(widthStr).matches()) {
                    throw new IllegalArgumentException(String.format("Map width \'%s\' does not match pattern \'%s\'.", new Object[]{widthStr, dimensinPattern.pattern()}));
                }

                int width = Integer.parseInt(widthStr);
                String heightStr = widthHeightStr[1];
                if(!dimensinPattern.matcher(heightStr).matches()) {
                    throw new IllegalArgumentException(String.format("Map height \'%s\' does not match pattern \'%s\'.", new Object[]{heightStr, dimensinPattern.pattern()}));
                }

                int height = Integer.parseInt(heightStr);
                mapTiles = new TileType[width][height];
            }
        }

        if(mapTiles == null) {
            throw new CantReadResourceException("Can\'t read width and height of the map.");
        } else {
            return mapTiles;
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.t[][], java.lang.String[], org.apache.commons.lang3.mutable.MutableInt, int, int) void
    private static void parseMapTiles(TileType[][] mapTiles, String[] mapLines, MutableInt currentLinePtr, int width, int height) {
        int var5 = mapLines.length;

        int y;
        for(y = 0; currentLinePtr.intValue() < var5 && y < height; currentLinePtr.increment()) {
            String mapLine = mapLines[currentLinePtr.intValue()];
            if(StringUtil.isNotBlank(mapLine) && mapLine.indexOf('#') != 0) {
                mapLine = Patterns.WHITESPACE_PATTERN.matcher(mapLine).replaceAll("");
                if(mapLine.length() != width) {
                    throw new IllegalArgumentException("Length of the map line is not " + width + '.');
                }

                for(int x = 0; x < width; ++x) {
                    char c = mapLine.charAt(x);
                    mapTiles[x][y] = tileTypeByChar(c);
                }

                ++y;
            }
        }

        if(y < height) {
            throw new CantReadResourceException("Number of the map lines is not " + height + '.');
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.t[][], int, int) void
    private static void method_506(TileType[][] var0, int width, int height) {
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                TileType var5 = var0[x][y];
                TileType var6 = x > 0?var0[x - 1][y]:null;
                TileType var7 = x < width - 1?var0[x + 1][y]:null;
                TileType var8 = y > 0?var0[x][y - 1]:null;
                TileType var9 = y < height - 1?var0[x][y + 1]:null;
                method_507(x, y, var5, var6, var7, var8, var9);
            }
        }

    }

    // $FF: renamed from: a (int, int, com.a.b.a.a.c.t, com.a.b.a.a.c.t, com.a.b.a.a.c.t, com.a.b.a.a.c.t, com.a.b.a.a.c.t) void
    private static void method_507(int var0, int var1, TileType var2, TileType var3, TileType var4, TileType var5, TileType var6) {
        if(field_322.contains(var2) && (var5 == null || !field_321.contains(var5)) || field_321.contains(var2) && (var6 == null || !field_322.contains(var6)) || field_319.contains(var2) && (var4 == null || !field_320.contains(var4)) || field_320.contains(var2) && (var3 == null || !field_319.contains(var3))) {
            throw new IllegalArgumentException(String.format("Illegal environment of tile (%d, %d) (tileType=%s, leftTileType=%s, rightTileType=%s, topTileType=%s, bottomTileType=%s).", var0, var1, var2, var3, var4, var5, var6));
        }
    }

    // $FF: renamed from: a (java.lang.String[], org.apache.commons.lang3.mutable.MutableInt) com.codeforces.commons.pair.IntPair[]
    private static IntPair[] method_508(String[] var0, MutableInt var1) {
        int var2 = var0.length;

        IntPair[] var3;
        for(var3 = null; var1.intValue() < var2 && var3 == null; var1.increment()) {
            String var4 = var0[var1.intValue()];
            if(StringUtil.isNotBlank(var4) && var4.indexOf(35) != 0) {
                int var5;
                try {
                    var5 = Integer.parseInt(var4.trim());
                } catch (NumberFormatException var7) {
                    throw new CantReadResourceException("Can\'t parse number of waypoints.", var7);
                }

                if(var5 < 4 || var5 > 1000) {
                    throw new IllegalArgumentException(String.format("Number of waypoints %d is not between %d and %d.", new Object[]{Integer.valueOf(var5), Integer.valueOf(4), Integer.valueOf(1000)}));
                }

                var3 = new IntPair[var5];
            }
        }

        if(var3 == null) {
            throw new CantReadResourceException("Can\'t read number of waypoints.");
        } else {
            return var3;
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.pair.IntPair[], java.lang.String[], org.apache.commons.lang3.mutable.MutableInt, com.a.b.a.a.c.t[][], int, int) void
    private static void method_509(IntPair[] var0, String[] var1, MutableInt var2, TileType[][] var3, int var4, int var5) {
        int var6 = var0.length;
        int var7 = var1.length;

        int var8;
        for(var8 = 0; var2.intValue() < var7 && var8 < var6; var2.increment()) {
            String var9 = var1[var2.intValue()];
            if(StringUtil.isNotBlank(var9) && var9.indexOf(35) != 0) {
                String[] var10 = Patterns.WHITESPACE_PATTERN.split(var9.trim());
                if(var10.length < 2) {
                    throw new CantReadResourceException("Can\'t parse x and y of the waypoint.");
                }

                String var11 = var10[0];
                if(!field_318.matcher(var11).matches()) {
                    throw new IllegalArgumentException(String.format("Waypoint x-coordinate \'%s\' does not match pattern \'%s\'.", new Object[]{var11, field_318.pattern()}));
                }

                int var12 = Integer.parseInt(var11);
                String var13 = var10[1];
                if(!field_318.matcher(var13).matches()) {
                    throw new IllegalArgumentException(String.format("Waypoint y-coordinate \'%s\' does not match pattern \'%s\'.", new Object[]{var13, field_318.pattern()}));
                }

                int var14 = Integer.parseInt(var13);
                if(var12 >= var4 || var14 >= var5 || var3[var12][var14] == TileType.EMPTY) {
                    throw new IllegalArgumentException(String.format("Waypoint (%d, %d) is outside the track.", var12, var14));
                }

                if(var8 == 0 && var3[var12][var14] != TileType.VERTICAL && var3[var12][var14] != TileType.HORIZONTAL) {
                    throw new IllegalArgumentException(String.format("Starting waypoint (%d, %d) should lay either on VERTICAL or HORIZONTAL track tile (current is %s).", var12, var14, var3[var12][var14]));
                }

                if(var8 > 0) {
                    IntPair var15 = var0[var8 - 1];
                    if(NumberUtil.equals(var12, var15.getFirst()) && NumberUtil.equals(var14, var15.getSecond())) {
                        throw new IllegalArgumentException(String.format("Waypoint #%d (%d, %d) is the same as previous waypoint.", var8, var12, var14));
                    }
                }

                var0[var8] = new IntPair(var12, var14);
                ++var8;
            }
        }

        if(var8 < var6) {
            throw new CantReadResourceException("Number of the waypoints is not " + var6 + '.');
        } else if(var0[0].equals(var0[var6 - 1])) {
            throw new IllegalArgumentException("Last waypoint is the same as starting waypoint.");
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.pair.IntPair[], com.a.b.a.a.c.t[][], int, int, org.apache.commons.lang3.mutable.MutableInt) void
    private static void method_510(IntPair[] var0, TileType[][] var1, int var2, int var3, MutableInt var4) {
        int var5 = var0.length;
        IntPair[] var6 = new IntPair[var5 + 1];
        System.arraycopy(var0, 0, var6, 0, var5);
        var6[var5] = var0[0];
        MapUtils.class_211[] var7 = new MapUtils.class_211[var5];

        for(int var8 = 0; var8 < var5; ++var8) {
            IntPair var9 = var6[var8];
            MapUtils.class_211 var10 = new MapUtils.class_211(var9);
            if(var8 > 0) {
                var10.field_267 = var7[var8 - 1].field_267;
            }

            Integer[][] var11 = new Integer[var2][var3];
            var11[var9.getFirst()][var9.getSecond()] = 0;
            var7[var8] = method_511(var10, var6[var8 + 1], var1, var11, var2, var3);
            var4.add(var7[var8].field_268);
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.b.e.i$b, com.codeforces.commons.pair.IntPair, com.a.b.a.a.c.t[][], java.lang.Integer[][], int, int) com.a.b.a.a.b.e.i$b
    private static MapUtils.class_211 method_511(MapUtils.class_211 var0, IntPair var1, TileType[][] var2, Integer[][] var3, int var4, int var5) {
        List var6 = method_512(var0.field_266, var2, var4, var5);
        MapUtils.class_211 var7 = null;
        Iterator var8 = var6.iterator();

        IntPair var9;
        while(var8.hasNext()) {
            var9 = (IntPair)var8.next();
            if(var9.equals(var1)) {
                var7 = new MapUtils.class_211(var9);
                var7.field_267 = var0;
                var7.field_268 = method_513(var0, var9);
                return var7;
            }
        }

        var8 = var6.iterator();

        while(true) {
            MapUtils.class_211 var12;
            do {
                do {
                    int var10;
                    while(true) {
                        do {
                            if(!var8.hasNext()) {
                                return var7;
                            }

                            var9 = (IntPair)var8.next();
                        } while(var0.field_267 != null && var9.equals(var0.field_267.field_266));

                        var10 = method_513(var0, var9);
                        Integer var11 = var3[var9.getFirst()][var9.getSecond()];
                        if(var11 == null) {
                            var3[var9.getFirst()][var9.getSecond()] = var10;
                            break;
                        }

                        if(var10 <= var11 + field_323) {
                            if(var10 < var11) {
                                var3[var9.getFirst()][var9.getSecond()] = var10;
                            }
                            break;
                        }
                    }

                    var12 = new MapUtils.class_211(var9);
                    var12.field_267 = var0;
                    var12.field_268 = var10;
                    var12 = method_511(var12, var1, var2, var3, var4, var5);
                } while(var12 == null);
            } while(var7 != null && var12.field_268 >= var7.field_268);

            var7 = var12;
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.pair.IntPair, com.a.b.a.a.c.t[][], int, int) java.util.List
    private static List method_512(IntPair var0, TileType[][] var1, int var2, int var3) {
        int var4 = var0.getFirst();
        int var5 = var0.getSecond();
        ArrayList var6 = new ArrayList(4);
        if(var5 > 0 && field_321.contains(var1[var4][var5 - 1])) {
            var6.add(new IntPair(var4, var5 - 1));
        }

        if(var5 < var3 - 1 && field_322.contains(var1[var4][var5 + 1])) {
            var6.add(new IntPair(var4, var5 + 1));
        }

        if(var4 > 0 && field_319.contains(var1[var4 - 1][var5])) {
            var6.add(new IntPair(var4 - 1, var5));
        }

        if(var4 < var2 - 1 && field_320.contains(var1[var4 + 1][var5])) {
            var6.add(new IntPair(var4 + 1, var5));
        }

        return var6;
    }

    // $FF: renamed from: a (com.a.b.a.a.b.e.i$b, com.codeforces.commons.pair.IntPair) int
    private static int method_513(MapUtils.class_211 var0, IntPair var1) {
        int var2 = var1.getFirst() - var0.field_266.getFirst();
        int var3 = var1.getSecond() - var0.field_266.getSecond();
        int var4 = var0.field_266.getFirst() - var2;
        int var5 = var0.field_266.getSecond() - var3;
        int var6 = 60;

        for(MapUtils.class_211 var7 = var0.field_267; var7 != null && var7.field_266.equals(var4, var5); var7 = var7.field_267) {
            var6 -= 5;
            if(var6 <= 30) {
                break;
            }

            var4 -= var2;
            var5 -= var3;
        }

        return var0.field_268 + var6;
    }

    // $FF: renamed from: a (java.lang.String[], org.apache.commons.lang3.mutable.MutableInt, com.a.b.a.a.c.t[][], com.codeforces.commons.pair.IntPair[]) com.a.b.a.a.c.i
    private static Direction parseStartingDirection(String[] mapLines, MutableInt var1, TileType[][] var2, IntPair[] var3) {
        int var4 = mapLines.length;

        Direction var5;
        for(var5 = null; var1.intValue() < var4 && var5 == null; var1.increment()) {
            String var6 = mapLines[var1.intValue()];
            if(StringUtil.isNotBlank(var6) && var6.indexOf(35) != 0) {
                try {
                    var5 = Direction.valueOf(var6.trim().toUpperCase());
                } catch (IllegalArgumentException var8) {
                    throw new CantReadResourceException("Can\'t parse starting direction.", var8);
                }
            }
        }

        if(var5 == null) {
            throw new CantReadResourceException("Can\'t read starting direction.");
        } else {
            IntPair var9 = var3[0];
            TileType var7 = var2[var9.getFirst()][var9.getSecond()];
            switch(var7) {
            case VERTICAL:
                if(var5 != Direction.UP && var5 != Direction.DOWN) {
                    throw new IllegalArgumentException(String.format("Starting direction should be either UP or DOWN for VERTICAL waypoint, but got %s.", new Object[]{var5}));
                }
                break;
            case HORIZONTAL:
                if(var5 != Direction.LEFT && var5 != Direction.RIGHT) {
                    throw new IllegalArgumentException(String.format("Starting direction should be either LEFT or RIGHT for HORIZONTAL waypoint, but got %s.", new Object[]{var5}));
                }
                break;
            default:
                throw new IllegalArgumentException(String.format("Starting waypoint (%d, %d) should lay either on VERTICAL or HORIZONTAL track tile (current is %s).", new Object[]{var9.getFirst(), var9.getSecond(), var7}));
            }

            return var5;
        }
    }

    // $FF: renamed from: a (char) com.a.b.a.a.c.t
    private static TileType tileTypeByChar(char c) {
        switch(c) {
        case '═':
            return TileType.HORIZONTAL;
        case '║':
            return TileType.VERTICAL;
        case '╔':
            return TileType.LEFT_TOP_CORNER;
        case '╗':
            return TileType.RIGHT_TOP_CORNER;
        case '╚':
            return TileType.LEFT_BOTTOM_CORNER;
        case '╝':
            return TileType.RIGHT_BOTTOM_CORNER;
        case '╠':
            return TileType.RIGHT_HEADED_T;
        case '╣':
            return TileType.LEFT_HEADED_T;
        case '╦':
            return TileType.BOTTOM_HEADED_T;
        case '╩':
            return TileType.TOP_HEADED_T;
        case '╬':
            return TileType.CROSSROADS;
        case '█':
            return TileType.EMPTY;
        default:
            throw new IllegalArgumentException("Unexpected tile character \'" + c + "\'.");
        }
    }

    private static final class class_211 {
        // $FF: renamed from: a com.codeforces.commons.pair.IntPair
        final IntPair field_266;
        // $FF: renamed from: b com.a.b.a.a.b.e.i$b
        MapUtils.class_211 field_267;
        // $FF: renamed from: c int
        int field_268;

        class_211(IntPair var1) {
            this.field_266 = var1;
        }

        public String toString() {
            return StringUtil.toString(this, true, "tile", "previousTileInfo.tile", "weight");
        }
    }

    public static final class Map {
        // $FF: renamed from: a java.lang.String
        private final String field_261;
        // $FF: renamed from: b com.a.b.a.a.c.t[][]
        private final TileType[][] tilesXY;
        // $FF: renamed from: c com.codeforces.commons.pair.IntPair[]
        private final IntPair[] field_263;
        // $FF: renamed from: d com.a.b.a.a.c.i
        private final Direction startingDirection;
        // $FF: renamed from: e int
        private final int field_265;

        public Map(String var1, TileType[][] var2, IntPair[] var3, Direction var4, int var5) {
            this.field_261 = var1;
            this.tilesXY = var2;
            this.field_263 = var3;
            this.startingDirection = var4;
            this.field_265 = var5;
        }

        // $FF: renamed from: a () java.lang.String
        public String method_412() {
            return this.field_261;
        }

        // $FF: renamed from: b () com.a.b.a.a.c.t[][]
        public TileType[][] getTilesXY() {
            return this.tilesXY;
        }

        // $FF: renamed from: c () com.codeforces.commons.pair.IntPair[]
        public IntPair[] method_414() {
            return this.field_263;
        }

        // $FF: renamed from: d () com.a.b.a.a.c.i
        public Direction getStartingDirection() {
            return this.startingDirection;
        }

        // $FF: renamed from: e () int
        public int method_416() {
            return this.field_265;
        }
    }
}
