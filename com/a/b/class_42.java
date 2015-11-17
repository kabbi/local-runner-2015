package com.a.b;

import com.a.c.class_159;
import com.a.c.class_161;
import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.b.e
public abstract class class_42 {
    // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
    private static final AtomicLong field_146 = new AtomicLong();
    // $FF: renamed from: b long
    @Name("id")
    private final long field_147;
    // $FF: renamed from: c com.a.c.c
    @Name("body")
    private class_159 field_148;
    // $FF: renamed from: d double
    private double field_149;
    // $FF: renamed from: e int
    private int field_150;
    // $FF: renamed from: f double
    private double field_151;
    // $FF: renamed from: g int
    private int field_152;
    // $FF: renamed from: h java.lang.Double
    private Double field_153;
    // $FF: renamed from: i java.lang.Double
    private Double field_154;
    // $FF: renamed from: j java.lang.Double
    private Double field_155;
    // $FF: renamed from: k com.codeforces.commons.geometry.Vector2D
    private Vector2D field_156 = new Vector2D(0.0D, 0.0D);

    protected class_42(class_125 var1) {
        this.field_147 = field_146.incrementAndGet();
        this.field_148 = new class_161(this.field_147);
        this.field_148.method_869(this.getClass().getSimpleName() + '#' + this.field_147);
        this.field_148.method_903(var1);
    }

    // $FF: renamed from: a () long
    public final long method_278() {
        return this.field_147;
    }

    // $FF: renamed from: b () com.a.c.c
    public class_159 method_279() {
        return this.field_148;
    }

    // $FF: renamed from: a (com.a.c.c) void
    public void method_280(class_159 var1) {
        this.field_148 = var1;
    }

    // $FF: renamed from: c () double
    public double method_281() {
        return Math.sqrt(this.field_149);
    }

    // $FF: renamed from: d () int
    public int method_282() {
        return this.field_150;
    }

    // $FF: renamed from: a (int) void
    public void method_283(int var1) {
        double var2 = this.field_148.method_876().getSquaredLength();
        if(this.field_149 < var2) {
            this.field_149 = var2;
            this.field_150 = var1;
        }

    }

    // $FF: renamed from: e () double
    public double method_284() {
        return this.field_151;
    }

    // $FF: renamed from: f () int
    public int method_285() {
        return this.field_152;
    }

    // $FF: renamed from: b (int) void
    public void method_286(int var1) {
        double var2 = Math.abs(this.field_148.method_880());
        if(this.field_151 < var2) {
            this.field_151 = var2;
            this.field_152 = var1;
        }

    }

    // $FF: renamed from: g () java.lang.Double
    public Double method_287() {
        return this.field_153;
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void method_288(Double var1) {
        this.field_153 = var1;
    }

    // $FF: renamed from: h () java.lang.Double
    public Double method_289() {
        return this.field_154;
    }

    // $FF: renamed from: b (java.lang.Double) void
    public void method_290(Double var1) {
        this.field_154 = var1;
    }

    // $FF: renamed from: i () java.lang.Double
    public Double method_291() {
        return this.field_155;
    }

    // $FF: renamed from: c (java.lang.Double) void
    public void method_292(Double var1) {
        this.field_155 = var1;
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_293() {
        return this.field_156;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_294(Vector2D var1) {
        this.field_156 = var1;
    }

    // $FF: renamed from: a (double, double) double
    public double method_295(double var1, double var3) {
        return Math.hypot(var1 - this.field_148.method_870(), var3 - this.field_148.method_872());
    }

    // $FF: renamed from: a (com.a.b.e) double
    public double method_296(class_42 var1) {
        return this.method_295(var1.field_148.method_870(), var1.field_148.method_872());
    }

    public final boolean equals(Object var1) {
        return this == var1 || var1 != null && this.getClass() == var1.getClass() && this.field_147 == ((class_42)var1).field_147;
    }

    public final int hashCode() {
        return (int)(this.field_147 ^ this.field_147 >>> 32);
    }

    public String toString() {
        return StringUtil.toString(this, false, "id", "body.name");
    }
}
