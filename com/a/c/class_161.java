package com.a.c;

import com.a.c.class_159;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.f
public final class class_161 extends class_159 {
    // $FF: renamed from: a double
    @Name("x")
    private double field_657;
    // $FF: renamed from: b double
    @Name("y")
    private double field_658;
    // $FF: renamed from: c double
    @Name("angle")
    private double field_659;
    // $FF: renamed from: d com.codeforces.commons.geometry.Vector2D
    @Name("speed")
    private Vector2D field_660 = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: e com.codeforces.commons.geometry.Vector2D
    @Name("medianSpeed")
    private Vector2D field_661 = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: f double
    @Name("angularSpeed")
    private double field_662;
    // $FF: renamed from: g double
    @Name("angularSpeed")
    private double field_663;
    // $FF: renamed from: h com.codeforces.commons.geometry.Vector2D
    @Name("force")
    private Vector2D field_664 = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: i double
    @Name("torque")
    private double field_665;
    // $FF: renamed from: j double
    @Name("movementAirFrictionFactor")
    private double field_666;
    // $FF: renamed from: k double
    @Name("rotationAirFrictionFactor")
    private double field_667;
    // $FF: renamed from: l double
    @Name("movementFrictionFactor")
    private double field_668;
    // $FF: renamed from: m java.lang.Double
    @Name("crosswiseMovementFrictionFactor")
    private Double field_669;
    // $FF: renamed from: n double
    @Name("rotationFrictionFactor")
    private double field_670;
    // $FF: renamed from: o double
    @Name("momentumTransferFactor")
    private double field_671 = 1.0D;
    // $FF: renamed from: p double
    @Name("surfaceFriction")
    private double field_672;

    public class_161(long var1) {
        super(var1);
    }

    // $FF: renamed from: c () double
    public double method_870() {
        return this.field_657;
    }

    // $FF: renamed from: a (double) void
    public void method_871(double var1) {
        this.field_657 = var1;
    }

    // $FF: renamed from: d () double
    public double method_872() {
        return this.field_658;
    }

    // $FF: renamed from: b (double) void
    public void method_873(double var1) {
        this.field_658 = var1;
    }

    // $FF: renamed from: e () double
    public double method_874() {
        return this.field_659;
    }

    // $FF: renamed from: c (double) void
    public void method_875(double var1) {
        while(var1 > 3.141592653589793D) {
            var1 -= 6.283185307179586D;
        }

        while(var1 < -3.141592653589793D) {
            var1 += 6.283185307179586D;
        }

        this.field_659 = var1;
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_876() {
        return this.field_660;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_877(Vector2D var1) {
        this.field_660 = var1;
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_878() {
        return this.field_661;
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void method_879(Vector2D var1) {
        this.field_661 = var1;
    }

    // $FF: renamed from: h () double
    public double method_880() {
        return this.field_662;
    }

    // $FF: renamed from: d (double) void
    public void method_881(double var1) {
        this.field_662 = var1;
    }

    // $FF: renamed from: i () double
    public double method_882() {
        return this.field_663;
    }

    // $FF: renamed from: e (double) void
    public void method_883(double var1) {
        this.field_663 = var1;
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_884() {
        return this.field_664;
    }

    // $FF: renamed from: k () double
    public double method_885() {
        return this.field_665;
    }

    // $FF: renamed from: l () double
    public double method_886() {
        return this.field_666;
    }

    // $FF: renamed from: f (double) void
    public void method_887(double var1) {
        this.field_666 = var1;
    }

    // $FF: renamed from: m () double
    public double method_888() {
        return this.field_667;
    }

    // $FF: renamed from: g (double) void
    public void method_889(double var1) {
        this.field_667 = var1;
    }

    // $FF: renamed from: n () double
    public double method_890() {
        return this.field_668;
    }

    // $FF: renamed from: h (double) void
    public void method_891(double var1) {
        this.field_668 = var1;
    }

    // $FF: renamed from: o () java.lang.Double
    public Double method_892() {
        return this.field_669;
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void method_893(Double var1) {
        this.field_669 = var1;
    }

    // $FF: renamed from: p () double
    public double method_894() {
        return this.field_670;
    }

    // $FF: renamed from: i (double) void
    public void method_895(double var1) {
        this.field_670 = var1;
    }

    // $FF: renamed from: q () double
    public double method_896() {
        return this.field_671;
    }

    // $FF: renamed from: j (double) void
    public void method_897(double var1) {
        this.field_671 = var1;
    }

    // $FF: renamed from: r () double
    public double method_898() {
        return this.field_672;
    }

    // $FF: renamed from: k (double) void
    public void method_899(double var1) {
        this.field_672 = var1;
    }
}
