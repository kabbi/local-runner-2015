package com.a.b.a.a.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.a.b.a.a.c.j
public final class class_151 {
    // $FF: renamed from: id long
    private final long field_586;
    private final EffectType type;
    private final int tick;
    private final Long affectedUnitId;
    // $FF: renamed from: x java.lang.Double
    private final Double field_587;
    // $FF: renamed from: y java.lang.Double
    private final Double field_588;
    private final Double angle;
    private final Map attributes;

    public class_151(long var1, EffectType var3, int var4, Long var5, Double var6, Double var7, Double var8) {
        this.field_586 = var1;
        this.type = var3;
        this.tick = var4;
        this.affectedUnitId = var5;
        this.field_587 = var6;
        this.field_588 = var7;
        this.angle = var8;
        this.attributes = null;
    }

    public class_151(long var1, EffectType var3, int var4, Long var5, Double var6, Double var7, Double var8, Map var9) {
        this.field_586 = var1;
        this.type = var3;
        this.tick = var4;
        this.affectedUnitId = var5;
        this.field_587 = var6;
        this.field_588 = var7;
        this.angle = var8;
        this.attributes = new HashMap(var9);
    }

    public long getId() {
        return this.field_586;
    }

    public EffectType getType() {
        return this.type;
    }

    public int getTick() {
        return this.tick;
    }

    public Long getAffectedUnitId() {
        return this.affectedUnitId;
    }

    public Double getX() {
        return this.field_587;
    }

    public Double getY() {
        return this.field_588;
    }

    public Double getAngle() {
        return this.angle;
    }

    public Map getAttributes() {
        return this.attributes == null?null:Collections.unmodifiableMap(this.attributes);
    }

    public Object getAttribute(String var1) {
        return this.attributes == null?null:this.attributes.get(var1);
    }
}
