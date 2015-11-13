package com.a.b.a.a.c;

import com.google.gson.annotations.Expose;

// $FF: renamed from: com.a.b.a.a.c.f
public final class class_142 {
    @Expose(
        serialize = false,
        deserialize = false
    )
    private final double distanceTraveled;
    @Expose(
        serialize = false,
        deserialize = false
    )
    private final Integer remainingHitRecoverTicks;
    private final Boolean brakes;
    private final double wheelDistanceChangePerTick;

    public class_142(double var1, Integer var3, Boolean var4, double var5) {
        this.distanceTraveled = var1;
        this.remainingHitRecoverTicks = var3;
        this.brakes = var4;
        this.wheelDistanceChangePerTick = var5;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public Integer getRemainingHitRecoverTicks() {
        return this.remainingHitRecoverTicks;
    }

    public Boolean getBrakes() {
        return this.brakes;
    }

    public double getWheelDistanceChangePerTick() {
        return this.wheelDistanceChangePerTick;
    }
}
