package com.a.b.a.a.c;

import com.google.gson.annotations.Until;
import java.util.Arrays;

// $FF: renamed from: com.a.b.a.a.c.v
public class World {
    private final int tick;
    @Until(1.0D)
    private final int tickCount;
    private final int lastTickIndex;
    @Until(1.0D)
    private final int width;
    @Until(1.0D)
    private final int height;
    private final Player[] players;
    private final Car[] cars;
    private final Projectile[] projectiles;
    private final Bonus[] bonuses;
    private final OilSlick[] oilSlicks;
    @Until(1.0D)
    private final String mapName;
    @Until(1.0D)
    private final TileType[][] tilesXY;
    @Until(1.0D)
    private final int[][] waypoints;
    @Until(1.0D)
    private final Direction startingDirection;

    public World(int var1, int var2, int var3, int var4, int var5, Player[] var6, Car[] var7, Projectile[] var8, Bonus[] var9, OilSlick[] var10, String var11, TileType[][] var12, int[][] var13, Direction var14) {
        this.tick = var1;
        this.tickCount = var2;
        this.lastTickIndex = var3;
        this.width = var4;
        this.height = var5;
        this.players = (Player[])Arrays.copyOf(var6, var6.length);
        this.cars = (Car[])Arrays.copyOf(var7, var7.length);
        this.projectiles = (Projectile[])Arrays.copyOf(var8, var8.length);
        this.bonuses = (Bonus[])Arrays.copyOf(var9, var9.length);
        this.oilSlicks = (OilSlick[])Arrays.copyOf(var10, var10.length);
        this.mapName = var11;
        this.tilesXY = new TileType[var4][];

        int var15;
        for(var15 = 0; var15 < var4; ++var15) {
            this.tilesXY[var15] = (TileType[])Arrays.copyOf(var12[var15], var12[var15].length);
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

    public Player[] getPlayers() {
        return Arrays.copyOf(this.players, this.players.length);
    }

    public Car[] getCars() {
        return Arrays.copyOf(this.cars, this.cars.length);
    }

    public Projectile[] getProjectiles() {
        return Arrays.copyOf(this.projectiles, this.projectiles.length);
    }

    public Bonus[] getBonuses() {
        return Arrays.copyOf(this.bonuses, this.bonuses.length);
    }

    public OilSlick[] getOilSlicks() {
        return Arrays.copyOf(this.oilSlicks, this.oilSlicks.length);
    }

    public String getMapName() {
        return this.mapName;
    }

    public TileType[][] getTilesXY() {
        TileType[][] var1 = new TileType[this.tilesXY.length][];

        for(int i = 0; i < this.tilesXY.length; ++i) {
            var1[i] = Arrays.copyOf(this.tilesXY[i], this.tilesXY[i].length);
        }

        return var1;
    }

    public int[][] getWaypoints() {
        int[][] var1 = new int[this.waypoints.length][2];

        for(int i = 0; i < this.waypoints.length; ++i) {
            var1[i][0] = this.waypoints[i][0];
            var1[i][1] = this.waypoints[i][1];
        }

        return var1;
    }

    public Direction getStartingDirection() {
        return this.startingDirection;
    }

    public Player getMyPlayer() {
        for(int var1 = this.players.length - 1; var1 >= 0; --var1) {
            Player var2 = this.players[var1];
            if(var2.isMe()) {
                return var2;
            }
        }

        return null;
    }

    public Player[] getPlayersUnsafe() {
        return this.players;
    }

    public Car[] getCarsUnsafe() {
        return this.cars;
    }

    public Projectile[] getProjectilesUnsafe() {
        return this.projectiles;
    }

    public Bonus[] getBonusesUnsafe() {
        return this.bonuses;
    }

    public OilSlick[] getOilSlicksUnsafe() {
        return this.oilSlicks;
    }

    public TileType[][] getTilesXYUnsafe() {
        return this.tilesXY;
    }

    public int[][] getWaypointsUnsafe() {
        return this.waypoints;
    }
}
