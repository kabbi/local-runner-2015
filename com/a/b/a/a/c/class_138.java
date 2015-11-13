package com.a.b.a.a.c;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Until;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.a.b.a.a.c.h
public final class class_138 extends World {
    @Until(1.0D)
    private final Long randomSeed;
    @Until(1.0D)
    private final double speedFactor;
    private final Boolean lastTick;
    private final class_151[] effects;
    private final Map decoratedCarById;
    private final Map decoratedPlayerById;
    @Expose(
        serialize = false,
        deserialize = false
    )
    private final Object systemData;

    public class_138(World var1, Long var2, double var3, boolean var5, class_151[] var6, Map var7, Map var8, Object var9) {
        super(var1.getTick(), var1.getTickCount(), var1.getLastTickIndex(), var1.getWidth(), var1.getHeight(), var1.getPlayersUnsafe(), var1.getCarsUnsafe(), var1.getProjectilesUnsafe(), var1.getBonusesUnsafe(), var1.getOilSlicksUnsafe(), var1.getMapName(), var1.getTilesXYUnsafe(), var1.getWaypointsUnsafe(), var1.getStartingDirection());
        this.randomSeed = var2;
        this.speedFactor = var3;
        this.lastTick = var5? true :null;
        this.effects = (class_151[])Arrays.copyOf(var6, var6.length);
        this.decoratedCarById = var7 == null?null:new HashMap(var7);
        this.decoratedPlayerById = var8 == null?null:new HashMap(var8);
        this.systemData = var9;
    }

    public Long getRandomSeed() {
        return this.randomSeed;
    }

    public double getSpeedFactor() {
        return this.speedFactor;
    }

    public boolean isLastTick() {
        return this.lastTick == null ? false : this.lastTick;
    }

    public class_151[] getEffects() {
        return (class_151[])Arrays.copyOf(this.effects, this.effects.length);
    }

    public Map getDecoratedCarById() {
        return this.decoratedCarById == null?null:Collections.unmodifiableMap(this.decoratedCarById);
    }

    public Map getDecoratedPlayerById() {
        return this.decoratedPlayerById == null?null:Collections.unmodifiableMap(this.decoratedPlayerById);
    }

    public Object getSystemData() {
        return this.systemData;
    }
}
