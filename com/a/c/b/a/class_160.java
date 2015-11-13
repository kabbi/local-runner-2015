package com.a.c.b.a;

import com.a.a.b.class_106;
import com.a.a.b.e.class_12;
import com.a.a.b.e.class_184;
import com.a.a.b.e.class_185;
import com.a.c.class_159;
import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.b.a.a
final class class_160 extends class_159 {
    // $FF: renamed from: a com.a.a.b.a
    @Name("body")
    private final class_106 field_656;

    class_160(long var1, class_106 var3, String var4, double var5, class_125 var7, boolean var8) {
        super(var1);
        this.field_656 = var3;
        this.method_869(var4);
        this.method_901(var5);
        this.method_903(var7 == null?null:var7.method_818());
        this.method_905(var8);
    }

    // $FF: renamed from: c () double
    public double method_870() {
        return this.field_656.method_695();
    }

    // $FF: renamed from: a (double) void
    public void method_871(double var1) {
        this.field_656.method_696(var1);
    }

    // $FF: renamed from: d () double
    public double method_872() {
        return this.field_656.method_697();
    }

    // $FF: renamed from: b (double) void
    public void method_873(double var1) {
        this.field_656.method_698(var1);
    }

    // $FF: renamed from: e () double
    public double method_874() {
        return this.field_656.method_707();
    }

    // $FF: renamed from: c (double) void
    public void method_875(double var1) {
        this.field_656.method_708(var1);
        this.field_656.method_718();
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_876() {
        return this.field_656.method_699();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_877(Vector2D var1) {
        this.field_656.method_700(var1);
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_878() {
        return this.field_656.method_702();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void method_879(Vector2D var1) {
        this.field_656.method_703(var1);
    }

    // $FF: renamed from: h () double
    public double method_880() {
        return this.field_656.method_709();
    }

    // $FF: renamed from: d (double) void
    public void method_881(double var1) {
        this.field_656.method_710(var1);
    }

    // $FF: renamed from: i () double
    public double method_882() {
        return this.field_656.method_711();
    }

    // $FF: renamed from: e (double) void
    public void method_883(double var1) {
        this.field_656.method_712(var1);
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_884() {
        return this.field_656.method_704();
    }

    // $FF: renamed from: k () double
    public double method_885() {
        return this.field_656.method_713();
    }

    // $FF: renamed from: l () double
    public double method_886() {
        return this.field_656.method_676();
    }

    // $FF: renamed from: f (double) void
    public void method_887(double var1) {
        this.field_656.method_677(var1);
    }

    // $FF: renamed from: m () double
    public double method_888() {
        return this.field_656.method_678();
    }

    // $FF: renamed from: g (double) void
    public void method_889(double var1) {
        this.field_656.method_679(var1);
    }

    // $FF: renamed from: n () double
    public double method_890() {
        class_12 var1 = this.field_656.method_680();
        if(var1 instanceof class_184) {
            return ((class_184)var1).method_988();
        } else if(var1 instanceof class_185) {
            return ((class_185)var1).method_989();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: h (double) void
    public void method_891(double var1) {
        Double var3 = this.method_892();
        if(var3 == null) {
            this.field_656.method_682(var1);
        } else {
            this.field_656.method_681(new class_185(var1, var3.doubleValue()));
        }

    }

    // $FF: renamed from: o () java.lang.Double
    public Double method_892() {
        class_12 var1 = this.field_656.method_680();
        if(var1 instanceof class_184) {
            return null;
        } else if(var1 instanceof class_185) {
            return ((class_185) var1).method_990();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void method_893(Double var1) {
        double var2 = this.method_890();
        if(var1 == null) {
            this.field_656.method_682(var2);
        } else {
            this.field_656.method_681(new class_185(var2, var1.doubleValue()));
        }

    }

    // $FF: renamed from: p () double
    public double method_894() {
        return this.field_656.method_684();
    }

    // $FF: renamed from: i (double) void
    public void method_895(double var1) {
        this.field_656.method_685(var1);
    }

    // $FF: renamed from: q () double
    public double method_896() {
        return this.field_656.method_686();
    }

    // $FF: renamed from: j (double) void
    public void method_897(double var1) {
        this.field_656.method_687(var1);
    }

    // $FF: renamed from: r () double
    public double method_898() {
        return this.field_656.method_688();
    }

    // $FF: renamed from: k (double) void
    public void method_899(double var1) {
        this.field_656.method_689(var1);
    }
}
