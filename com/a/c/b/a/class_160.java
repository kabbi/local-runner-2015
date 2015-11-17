package com.a.c.b.a;

import com.a.a.b.Body;
import com.a.a.b.e.MovementFrictionProvider;
import com.a.a.b.e.ConstantMovementFrictionProvider;
import com.a.a.b.e.BidirectionalMovementFrictionProvider;
import com.a.c.class_159;
import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.b.a.a
final class class_160 extends class_159 {
    // $FF: renamed from: a com.a.a.b.a
    @Name("body")
    private final Body field_656;

    class_160(long var1, Body var3, String var4, double var5, class_125 var7, boolean var8) {
        super(var1);
        this.field_656 = var3;
        this.method_869(var4);
        this.method_901(var5);
        this.method_903(var7 == null?null:var7.method_818());
        this.method_905(var8);
    }

    // $FF: renamed from: c () double
    public double method_870() {
        return this.field_656.getX();
    }

    // $FF: renamed from: a (double) void
    public void method_871(double var1) {
        this.field_656.setX(var1);
    }

    // $FF: renamed from: d () double
    public double method_872() {
        return this.field_656.getY();
    }

    // $FF: renamed from: b (double) void
    public void method_873(double var1) {
        this.field_656.setY(var1);
    }

    // $FF: renamed from: e () double
    public double method_874() {
        return this.field_656.getAngle();
    }

    // $FF: renamed from: c (double) void
    public void method_875(double var1) {
        this.field_656.setAngle(var1);
        this.field_656.normalizeAngle();
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_876() {
        return this.field_656.getVelocity();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_877(Vector2D var1) {
        this.field_656.setVelocity(var1);
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_878() {
        return this.field_656.getMedianVelocity();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void method_879(Vector2D var1) {
        this.field_656.setMedianVelocity(var1);
    }

    // $FF: renamed from: h () double
    public double method_880() {
        return this.field_656.getAngularVelocity();
    }

    // $FF: renamed from: d (double) void
    public void method_881(double var1) {
        this.field_656.setAngularVelocity(var1);
    }

    // $FF: renamed from: i () double
    public double method_882() {
        return this.field_656.getMedianAngularVelocity();
    }

    // $FF: renamed from: e (double) void
    public void method_883(double var1) {
        this.field_656.setMedianAngularVelocity(var1);
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_884() {
        return this.field_656.getForce();
    }

    // $FF: renamed from: k () double
    public double method_885() {
        return this.field_656.getTorque();
    }

    // $FF: renamed from: l () double
    public double method_886() {
        return this.field_656.getMovementAirFrictionFactor();
    }

    // $FF: renamed from: f (double) void
    public void method_887(double var1) {
        this.field_656.setMovementAirFrictionFactor(var1);
    }

    // $FF: renamed from: m () double
    public double method_888() {
        return this.field_656.getRotationAirFrictionFactor();
    }

    // $FF: renamed from: g (double) void
    public void method_889(double var1) {
        this.field_656.setRotationAirFrictionFactor(var1);
    }

    // $FF: renamed from: n () double
    public double method_890() {
        MovementFrictionProvider var1 = this.field_656.getMovementFrictionProvider();
        if(var1 instanceof ConstantMovementFrictionProvider) {
            return ((ConstantMovementFrictionProvider)var1).getMovementFrictionFactor();
        } else if(var1 instanceof BidirectionalMovementFrictionProvider) {
            return ((BidirectionalMovementFrictionProvider)var1).getLengthwiseMovementFrictionFactor();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: h (double) void
    public void method_891(double var1) {
        Double var3 = this.method_892();
        if(var3 == null) {
            this.field_656.setMovementFrictionFactor(var1);
        } else {
            this.field_656.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(var1, var3.doubleValue()));
        }

    }

    // $FF: renamed from: o () java.lang.Double
    public Double method_892() {
        MovementFrictionProvider var1 = this.field_656.getMovementFrictionProvider();
        if(var1 instanceof ConstantMovementFrictionProvider) {
            return null;
        } else if(var1 instanceof BidirectionalMovementFrictionProvider) {
            return ((BidirectionalMovementFrictionProvider) var1).getCrosswiseMovementFrictionFactor();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void method_893(Double var1) {
        double var2 = this.method_890();
        if(var1 == null) {
            this.field_656.setMovementFrictionFactor(var2);
        } else {
            this.field_656.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(var2, var1.doubleValue()));
        }

    }

    // $FF: renamed from: p () double
    public double method_894() {
        return this.field_656.getRotationFrictionFactor();
    }

    // $FF: renamed from: i (double) void
    public void method_895(double var1) {
        this.field_656.setRotationFrictionFactor(var1);
    }

    // $FF: renamed from: q () double
    public double method_896() {
        return this.field_656.getMomentumTransferFactor();
    }

    // $FF: renamed from: j (double) void
    public void method_897(double var1) {
        this.field_656.setMomentumTransferFactor(var1);
    }

    // $FF: renamed from: r () double
    public double method_898() {
        return this.field_656.getSurfaceFrictionFactor();
    }

    // $FF: renamed from: k (double) void
    public void method_899(double var1) {
        this.field_656.setSurfaceFrictionFactor(var1);
    }
}
