package com.a.c.b.a;

import com.a.a.b.Body;
import com.a.a.b.e.MovementFrictionProvider;
import com.a.a.b.e.ConstantMovementFrictionProvider;
import com.a.a.b.e.BidirectionalMovementFrictionProvider;
import com.a.c.PhysicalBody;
import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.b.a.a
final class RealPhysicalBody extends PhysicalBody {
    // $FF: renamed from: a com.a.a.b.a
    @Name("body")
    private final Body body;

    RealPhysicalBody(long var1, Body var3, String var4, double var5, class_125 var7, boolean var8) {
        super(var1);
        this.body = var3;
        this.setName(var4);
        this.setMass(var5);
        this.setForm(var7 == null ? null : var7.method_818());
        this.method_905(var8);
    }

    // $FF: renamed from: c () double
    public double getX() {
        return this.body.getX();
    }

    // $FF: renamed from: a (double) void
    public void setX(double x) {
        this.body.setX(x);
    }

    // $FF: renamed from: d () double
    public double getY() {
        return this.body.getY();
    }

    // $FF: renamed from: b (double) void
    public void setY(double y) {
        this.body.setY(y);
    }

    // $FF: renamed from: e () double
    public double getAngle() {
        return this.body.getAngle();
    }

    // $FF: renamed from: c (double) void
    public void setAngle(double angle) {
        this.body.setAngle(angle);
        this.body.normalizeAngle();
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D getVelocity() {
        return this.body.getVelocity();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setVelocity(Vector2D vector) {
        this.body.setVelocity(vector);
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D getMedianVelocity() {
        return this.body.getMedianVelocity();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void setMedianVelocity(Vector2D vector) {
        this.body.setMedianVelocity(vector);
    }

    // $FF: renamed from: h () double
    public double getAngularVelocity() {
        return this.body.getAngularVelocity();
    }

    // $FF: renamed from: d (double) void
    public void setAngularVelocity(double velocity) {
        this.body.setAngularVelocity(velocity);
    }

    // $FF: renamed from: i () double
    public double getMedianAngularVelocity() {
        return this.body.getMedianAngularVelocity();
    }

    // $FF: renamed from: e (double) void
    public void setMedianAngularVelocity(double velocity) {
        this.body.setMedianAngularVelocity(velocity);
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D getForce() {
        return this.body.getForce();
    }

    // $FF: renamed from: k () double
    public double getTorque() {
        return this.body.getTorque();
    }

    // $FF: renamed from: l () double
    public double getMovementAirFrictionFactor() {
        return this.body.getMovementAirFrictionFactor();
    }

    // $FF: renamed from: f (double) void
    public void setMovementAirFrictionFactor(double factor) {
        this.body.setMovementAirFrictionFactor(factor);
    }

    // $FF: renamed from: m () double
    public double getRotationAirFrictionFactor() {
        return this.body.getRotationAirFrictionFactor();
    }

    // $FF: renamed from: g (double) void
    public void setRotationAirFrictionFactor(double factor) {
        this.body.setRotationAirFrictionFactor(factor);
    }

    // $FF: renamed from: n () double
    public double getMovementFrictionFactor() {
        MovementFrictionProvider var1 = this.body.getMovementFrictionProvider();
        if(var1 instanceof ConstantMovementFrictionProvider) {
            return ((ConstantMovementFrictionProvider)var1).getMovementFrictionFactor();
        } else if(var1 instanceof BidirectionalMovementFrictionProvider) {
            return ((BidirectionalMovementFrictionProvider)var1).getLengthwiseMovementFrictionFactor();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: h (double) void
    public void setMovementFrictionFactor(double factor) {
        Double var3 = this.getCrosswiseMovementFrictionFactor();
        if(var3 == null) {
            this.body.setMovementFrictionFactor(factor);
        } else {
            this.body.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(factor, var3.doubleValue()));
        }

    }

    // $FF: renamed from: o () java.lang.Double
    public Double getCrosswiseMovementFrictionFactor() {
        MovementFrictionProvider var1 = this.body.getMovementFrictionProvider();
        if(var1 instanceof ConstantMovementFrictionProvider) {
            return null;
        } else if(var1 instanceof BidirectionalMovementFrictionProvider) {
            return ((BidirectionalMovementFrictionProvider) var1).getCrosswiseMovementFrictionFactor();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void setSomeOtherMovementFrictionFactor(Double factor) {
        double var2 = this.getMovementFrictionFactor();
        if(factor == null) {
            this.body.setMovementFrictionFactor(var2);
        } else {
            this.body.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(var2, factor.doubleValue()));
        }

    }

    // $FF: renamed from: p () double
    public double getRotationFrictionFactor() {
        return this.body.getRotationFrictionFactor();
    }

    // $FF: renamed from: i (double) void
    public void setRotationFrictionFactor(double factor) {
        this.body.setRotationFrictionFactor(factor);
    }

    // $FF: renamed from: q () double
    public double getMomentumTransferFactor() {
        return this.body.getMomentumTransferFactor();
    }

    // $FF: renamed from: j (double) void
    public void setMomentumTransferFactor(double factor) {
        this.body.setMomentumTransferFactor(factor);
    }

    // $FF: renamed from: r () double
    public double getSurfaceFrictionFactor() {
        return this.body.getSurfaceFrictionFactor();
    }

    // $FF: renamed from: k (double) void
    public void setSurfaceFrictionFactor(double factor) {
        this.body.setSurfaceFrictionFactor(factor);
    }
}