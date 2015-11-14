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
    private final CarClass type;
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

    public Car(@Name("id") long id, @Name("mass") double mass, @Name("x") double x, @Name("y") double y, @Name("speedX") double speedX, @Name("speedY") double speedY, @Name("angle") double angle, @Name("angularSpeed") double angularSpeed, @Name("width") double width,
               @Name("height") double height, @Name("playerId") long playerId, @Name("teammateIndex") int teammateIndex, @Name("teammate") boolean teammate,
               @Name("type") CarClass type, @Name("projectileCount") int projectileCount, @Name("nitroChargeCount") int nitroChangeCount,
               @Name("oilCanisterCount") int oilCannisterCount,
               @Name("remainingProjectileCooldownTicks") int remainingProjectileCooldownTicks,
               @Name("remainingNitroCooldownTicks") int remainingNitroCooldownTicks,
               @Name("remainingOilCooldownTicks") int remainingOilCooldownTicks,
               @Name("remainingNitroTicks") int remainingNitroTicks,
               @Name("remainingOiledTicks") int remainingOiledTicks,
               @Name("durability") double durability, @Name("enginePower") double enginePower,
               @Name("wheelTurn") double wheelTurn, @Name("nextWaypointX") int nextWaypointX,
               @Name("nextWaypointY") int nextWaypointY,
               @Name("finishedTrack") boolean finishedTrack) {
        super(id, mass, x, y, speedX, speedY, angle, angularSpeed, width, height);
        this.playerId = playerId;
        this.teammateIndex = teammateIndex;
        this.teammate = teammate;
        this.type = type;
        this.projectileCount = projectileCount;
        this.nitroChargeCount = nitroChangeCount;
        this.oilCanisterCount = oilCannisterCount;
        this.remainingProjectileCooldownTicks = remainingProjectileCooldownTicks;
        this.remainingNitroCooldownTicks = remainingNitroCooldownTicks;
        this.remainingOilCooldownTicks = remainingOilCooldownTicks;
        this.remainingNitroTicks = remainingNitroTicks;
        this.remainingOiledTicks = remainingOiledTicks;
        this.durability = durability;
        this.enginePower = enginePower;
        this.wheelTurn = wheelTurn;
        this.nextWaypointX = nextWaypointX;
        this.nextWaypointY = nextWaypointY;
        this.finishedTrack = finishedTrack;
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

    public CarClass getType() {
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
