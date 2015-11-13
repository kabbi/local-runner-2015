package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.c
public class Car extends RectangularUnit {
    @Until(1.0D)
    private final long playerId;
    @Until(1.0D)
    private final int teammateIndex;
    @Until(1.0D)
    private final boolean teammate;
    @Until(1.0D)
    private final class_143 type;
    private final int projectileCount;
    private final int nitroChargeCount;
    private final int oilCanisterCount;
    private final int remainingProjectileCooldownTicks;
    private final int remainingNitroCooldownTicks;
    private final int remainingOilCooldownTicks;
    private final int remainingNitroTicks;
    private final int remainingOiledTicks;
    private final double durability;
    private final double enginePower;
    private final double wheelTurn;
    private final int nextWaypointX;
    private final int nextWaypointY;
    private final boolean finishedTrack;

    public Car(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("width") double var17, @Name("height") double var19, @Name("playerId") long var21, @Name("teammateIndex") int var23, @Name("teammate") boolean var24, @Name("type") class_143 var25, @Name("projectileCount") int var26, @Name("nitroChargeCount") int var27, @Name("oilCanisterCount") int var28, @Name("remainingProjectileCooldownTicks") int var29, @Name("remainingNitroCooldownTicks") int var30, @Name("remainingOilCooldownTicks") int var31, @Name("remainingNitroTicks") int var32, @Name("remainingOiledTicks") int var33, @Name("durability") double var34, @Name("enginePower") double var36, @Name("wheelTurn") double var38, @Name("nextWaypointX") int var40, @Name("nextWaypointY") int var41, @Name("finishedTrack") boolean var42) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17, var19);
        this.playerId = var21;
        this.teammateIndex = var23;
        this.teammate = var24;
        this.type = var25;
        this.projectileCount = var26;
        this.nitroChargeCount = var27;
        this.oilCanisterCount = var28;
        this.remainingProjectileCooldownTicks = var29;
        this.remainingNitroCooldownTicks = var30;
        this.remainingOilCooldownTicks = var31;
        this.remainingNitroTicks = var32;
        this.remainingOiledTicks = var33;
        this.durability = var34;
        this.enginePower = var36;
        this.wheelTurn = var38;
        this.nextWaypointX = var40;
        this.nextWaypointY = var41;
        this.finishedTrack = var42;
    }

    public long getPlayerId() {
        return this.playerId;
    }

    public int getTeammateIndex() {
        return this.teammateIndex;
    }

    public boolean isTeammate() {
        return this.teammate;
    }

    public class_143 getType() {
        return this.type;
    }

    public int getProjectileCount() {
        return this.projectileCount;
    }

    public int getNitroChargeCount() {
        return this.nitroChargeCount;
    }

    public int getOilCanisterCount() {
        return this.oilCanisterCount;
    }

    public int getRemainingProjectileCooldownTicks() {
        return this.remainingProjectileCooldownTicks;
    }

    public int getRemainingNitroCooldownTicks() {
        return this.remainingNitroCooldownTicks;
    }

    public int getRemainingOilCooldownTicks() {
        return this.remainingOilCooldownTicks;
    }

    public int getRemainingNitroTicks() {
        return this.remainingNitroTicks;
    }

    public int getRemainingOiledTicks() {
        return this.remainingOiledTicks;
    }

    public double getDurability() {
        return this.durability;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getWheelTurn() {
        return this.wheelTurn;
    }

    public int getNextWaypointX() {
        return this.nextWaypointX;
    }

    public int getNextWaypointY() {
        return this.nextWaypointY;
    }

    public boolean isFinishedTrack() {
        return this.finishedTrack;
    }

    public static boolean areFieldEquals(Car a, Car b) {
        return a == b || a != null && b != null && RectangularUnit.areFieldEquals(a, b) && a.playerId == b.playerId && a.teammateIndex == b.teammateIndex && a.teammate == b.teammate && a.type == b.type && a.projectileCount == b.projectileCount && a.nitroChargeCount == b.nitroChargeCount && a.oilCanisterCount == b.oilCanisterCount && a.remainingProjectileCooldownTicks == b.remainingProjectileCooldownTicks && a.remainingNitroCooldownTicks == b.remainingNitroCooldownTicks && a.remainingOilCooldownTicks == b.remainingOilCooldownTicks && a.remainingNitroTicks == b.remainingNitroTicks && a.remainingOiledTicks == b.remainingOiledTicks && Double.compare(a.durability, b.durability) == 0 && Double.compare(a.enginePower, b.enginePower) == 0 && Double.compare(a.wheelTurn, b.wheelTurn) == 0 && a.nextWaypointX == b.nextWaypointX && a.nextWaypointY == b.nextWaypointY && a.finishedTrack == b.finishedTrack;
    }
}
