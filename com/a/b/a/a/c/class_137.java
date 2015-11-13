package com.a.b.a.a.c;

import com.a.b.a.a.c.class_132;
import com.a.b.a.a.c.class_133;
import com.a.b.a.a.c.class_135;
import com.a.b.a.a.c.class_136;
import com.a.b.a.a.c.class_139;
import com.a.b.a.a.c.class_145;
import com.a.b.a.a.c.class_150;
import com.google.gson.annotations.Until;
import java.util.Arrays;

// $FF: renamed from: com.a.b.a.a.c.v
public class class_137 {
    private final int tick;
    @Until(1.0D)
    private final int tickCount;
    private final int lastTickIndex;
    @Until(1.0D)
    private final int width;
    @Until(1.0D)
    private final int height;
    private final class_145[] players;
    private final class_136[] cars;
    private final class_133[] projectiles;
    private final class_135[] bonuses;
    private final class_132[] oilSlicks;
    @Until(1.0D)
    private final String mapName;
    @Until(1.0D)
    private final class_139[][] tilesXY;
    @Until(1.0D)
    private final int[][] waypoints;
    @Until(1.0D)
    private final class_150 startingDirection;

    public class_137(int var1, int var2, int var3, int var4, int var5, class_145[] var6, class_136[] var7, class_133[] var8, class_135[] var9, class_132[] var10, String var11, class_139[][] var12, int[][] var13, class_150 var14) {
        this.tick = var1;
        this.tickCount = var2;
        this.lastTickIndex = var3;
        this.width = var4;
        this.height = var5;
        this.players = (class_145[])Arrays.copyOf(var6, var6.length);
        this.cars = (class_136[])Arrays.copyOf(var7, var7.length);
        this.projectiles = (class_133[])Arrays.copyOf(var8, var8.length);
        this.bonuses = (class_135[])Arrays.copyOf(var9, var9.length);
        this.oilSlicks = (class_132[])Arrays.copyOf(var10, var10.length);
        this.mapName = var11;
        this.tilesXY = new class_139[var4][];

        int var15;
        for(var15 = 0; var15 < var4; ++var15) {
            this.tilesXY[var15] = (class_139[])Arrays.copyOf(var12[var15], var12[var15].length);
        }

        this.waypoints = new int[var13.length][2];

        for(var15 = 0; var15 < var13.length; ++var15) {
            this.waypoints[var15][0] = var13[var15][0];
            this.waypoints[var15][1] = var13[var15][1];
        }

        this.startingDirection = var14;
    }

    public int getTick() {
        return this.tick;
    }

    public int getTickCount() {
        return this.tickCount;
    }

    public int getLastTickIndex() {
        return this.lastTickIndex;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public class_145[] getPlayers() {
        return (class_145[])Arrays.copyOf(this.players, this.players.length);
    }

    public class_136[] getCars() {
        return (class_136[])Arrays.copyOf(this.cars, this.cars.length);
    }

    public class_133[] getProjectiles() {
        return (class_133[])Arrays.copyOf(this.projectiles, this.projectiles.length);
    }

    public class_135[] getBonuses() {
        return (class_135[])Arrays.copyOf(this.bonuses, this.bonuses.length);
    }

    public class_132[] getOilSlicks() {
        return (class_132[])Arrays.copyOf(this.oilSlicks, this.oilSlicks.length);
    }

    public String getMapName() {
        return this.mapName;
    }

    public class_139[][] getTilesXY() {
        class_139[][] var1 = new class_139[this.tilesXY.length][];

        for(int var2 = 0; var2 < this.tilesXY.length; ++var2) {
            var1[var2] = (class_139[])Arrays.copyOf(this.tilesXY[var2], this.tilesXY[var2].length);
        }

        return var1;
    }

    public int[][] getWaypoints() {
        int[][] var1 = new int[this.waypoints.length][2];

        for(int var2 = 0; var2 < this.waypoints.length; ++var2) {
            var1[var2][0] = this.waypoints[var2][0];
            var1[var2][1] = this.waypoints[var2][1];
        }

        return var1;
    }

    public class_150 getStartingDirection() {
        return this.startingDirection;
    }

    public class_145 getMyPlayer() {
        for(int var1 = this.players.length - 1; var1 >= 0; --var1) {
            class_145 var2 = this.players[var1];
            if(var2.isMe()) {
                return var2;
            }
        }

        return null;
    }

    public class_145[] getPlayersUnsafe() {
        return this.players;
    }

    public class_136[] getCarsUnsafe() {
        return this.cars;
    }

    public class_133[] getProjectilesUnsafe() {
        return this.projectiles;
    }

    public class_135[] getBonusesUnsafe() {
        return this.bonuses;
    }

    public class_132[] getOilSlicksUnsafe() {
        return this.oilSlicks;
    }

    public class_139[][] getTilesXYUnsafe() {
        return this.tilesXY;
    }

    public int[][] getWaypointsUnsafe() {
        return this.waypoints;
    }
}
