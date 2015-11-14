package com.a.b.a.a.b.a;

import com.a.b.RectangleBody;
import com.a.b.a.a.c.class_148;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.b.a.a.b.a.a
public class class_124 {
    // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
    private static final AtomicLong field_525 = new AtomicLong();
    // $FF: renamed from: b long
    private final long field_526;
    // $FF: renamed from: c com.a.b.a.a.c.k
    private final class_148 field_527;
    // $FF: renamed from: d int
    private final int field_528;
    // $FF: renamed from: e int
    private int field_529;
    // $FF: renamed from: f com.a.b.e
    private RectangleBody field_530;
    // $FF: renamed from: g java.lang.Double
    private Double field_531;
    // $FF: renamed from: h java.lang.Double
    private Double field_532;
    // $FF: renamed from: i java.lang.Double
    private Double field_533;
    // $FF: renamed from: j java.util.Map
    private final Map field_534;

    public class_124(class_148 var1, int var2, double var3, double var5, double var7) {
        this.field_526 = field_525.incrementAndGet();
        this.field_527 = var1;
        this.field_528 = var2;
        this.field_531 = var3;
        this.field_532 = var5;
        this.field_533 = var7;
        this.field_534 = new HashMap();
    }

    public class_124(class_148 var1, int var2, RectangleBody var3) {
        this.field_526 = field_525.incrementAndGet();
        this.field_527 = var1;
        this.field_528 = var2;
        this.field_530 = var3;
        this.field_531 = 0.0D;
        this.field_532 = 0.0D;
        this.field_533 = 0.0D;
        this.field_534 = new HashMap();
    }

    public class_124(class_148 var1, int var2, RectangleBody var3, Map var4) {
        this.field_526 = field_525.incrementAndGet();
        this.field_527 = var1;
        this.field_528 = var2;
        this.field_530 = var3;
        this.field_531 = 0.0D;
        this.field_532 = 0.0D;
        this.field_533 = 0.0D;
        this.field_534 = new HashMap(var4);
    }

    // $FF: renamed from: a () long
    public final long method_803() {
        return this.field_526;
    }

    // $FF: renamed from: b () com.a.b.a.a.c.k
    public class_148 method_804() {
        return this.field_527;
    }

    // $FF: renamed from: c () int
    public int method_805() {
        return this.field_528;
    }

    // $FF: renamed from: d () int
    public int method_806() {
        return this.field_529;
    }

    // $FF: renamed from: e () void
    public void method_807() {
        ++this.field_529;
    }

    // $FF: renamed from: f () boolean
    public boolean method_808() {
        return this.field_529 >= this.field_527.getDuration();
    }

    // $FF: renamed from: g () com.a.b.e
    public RectangleBody method_809() {
        return this.field_530;
    }

    // $FF: renamed from: h () java.lang.Double
    public Double method_810() {
        return this.field_530 != null && this.field_531 != null?Double.valueOf(this.field_530.getBody().getX() + this.field_531):this.field_531;
    }

    // $FF: renamed from: i () java.lang.Double
    public Double method_811() {
        return this.field_530 != null && this.field_532 != null?Double.valueOf(this.field_530.getBody().getY() + this.field_532):this.field_532;
    }

    // $FF: renamed from: j () java.lang.Double
    public Double method_812() {
        return this.field_530 != null && this.field_533 != null?Double.valueOf(this.field_530.getBody().getAngle() + this.field_533):this.field_533;
    }

    // $FF: renamed from: k () java.util.Map
    public Map method_813() {
        return Collections.unmodifiableMap(this.field_534);
    }
}
