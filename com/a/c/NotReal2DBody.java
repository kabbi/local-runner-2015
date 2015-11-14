package com.a.c;

import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.f
public final class NotReal2DBody extends Body {
    // $FF: renamed from: a double
    @Name("x")
    private double x;
    // $FF: renamed from: b double
    @Name("y")
    private double y;
    // $FF: renamed from: c double
    @Name("angle")
    private double angle;
    // $FF: renamed from: d com.codeforces.commons.geometry.Vector2D
    @Name("speed")
    private Vector2D speed = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: e com.codeforces.commons.geometry.Vector2D
    @Name("medianSpeed")
    private Vector2D medianSpeed = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: f double
    @Name("angularSpeed")
    private double angularSpeed;
    // $FF: renamed from: g double
    @Name("angularSpeed")
    private double moreAngularSpeed;
    // $FF: renamed from: h com.codeforces.commons.geometry.Vector2D
    @Name("force")
    private Vector2D force = new Vector2D(0.0D, 0.0D);
    // $FF: renamed from: i double
    @Name("torque")
    private double torque;
    // $FF: renamed from: j double
    @Name("movementAirFrictionFactor")
    private double movementAirFrictionFactor;
    // $FF: renamed from: k double
    @Name("rotationAirFrictionFactor")
    private double rotationAirFrictionFactor;
    // $FF: renamed from: l double
    @Name("movementFrictionFactor")
    private double movementFrictionFactor;
    // $FF: renamed from: m java.lang.Double
    @Name("crosswiseMovementFrictionFactor")
    private Double crosswiseMovementFrictionFactor;
    // $FF: renamed from: n double
    @Name("rotationFrictionFactor")
    private double rotationFrictionFactor;
    // $FF: renamed from: o double
    @Name("momentumTransferFactor")
    private double momentumTransferFactor = 1.0D;
    // $FF: renamed from: p double
    @Name("surfaceFriction")
    private double surfaceFriction;

    public NotReal2DBody(long var1) {
        super(var1);
    }

    // $FF: renamed from: c () double
    public double getX() {
        return this.x;
    }

    // $FF: renamed from: a (double) void
    public void setX(double var1) {
        this.x = var1;
    }

    // $FF: renamed from: d () double
    public double getY() {
        return this.y;
    }

    // $FF: renamed from: b (double) void
    public void setY(double var1) {
        this.y = var1;
    }

    // $FF: renamed from: e () double
    public double getAngle() {
        return this.angle;
    }

    // $FF: renamed from: c (double) void
    public void setAngle(double var1) {
        while(var1 > 3.141592653589793D) {
            var1 -= 6.283185307179586D;
        }

        while(var1 < -3.141592653589793D) {
            var1 += 6.283185307179586D;
        }

        this.angle = var1;
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D getSpeed() {
        return this.speed;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setSpeed(Vector2D var1) {
        this.speed = var1;
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D setMedianSpeed() {
        return this.medianSpeed;
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void getMedianSpeed(Vector2D var1) {
        this.medianSpeed = var1;
    }

    // $FF: renamed from: h () double
    public double angularSpeed() {
        return this.angularSpeed;
    }

    // $FF: renamed from: d (double) void
    public void setAngularSpeed(double var1) {
        this.angularSpeed = var1;
    }

    // $FF: renamed from: i () double
    public double getAngularSpeed() {
        return this.moreAngularSpeed;
    }

    // $FF: renamed from: e (double) void
    public void setMoreAngularSpeed(double var1) {
        this.moreAngularSpeed = var1;
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D getTheForce() {
        return this.force;
    }

    // $FF: renamed from: k () double
    public double getTorque() {
        return this.torque;
    }

    // $FF: renamed from: l () double
    public double getMovementAirFrictionFactor() {
        return this.movementAirFrictionFactor;
    }

    // $FF: renamed from: f (double) void
    public void setMovementAirFrictionFactor(double var1) {
        this.movementAirFrictionFactor = var1;
    }

    // $FF: renamed from: m () double
    public double getRotationAirFrictionFactor() {
        return this.rotationAirFrictionFactor;
    }

    // $FF: renamed from: g (double) void
    public void setRotationAirFrictionFactor(double var1) {
        this.rotationAirFrictionFactor = var1;
    }

    // $FF: renamed from: n () double
    public double getMovementFrictionFactor() {
        return this.movementFrictionFactor;
    }

    // $FF: renamed from: h (double) void
    public void setMovementFrictionFactor(double var1) {
        this.movementFrictionFactor = var1;
    }

    // $FF: renamed from: o () java.lang.Double
    public Double getCrosswiseMovementFrictionFactor() {
        return this.crosswiseMovementFrictionFactor;
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void setCrosswiseMovementFrictionFactor(Double var1) {
        this.crosswiseMovementFrictionFactor = var1;
    }

    // $FF: renamed from: p () double
    public double getRotationFrictionFactor() {
        return this.rotationFrictionFactor;
    }

    // $FF: renamed from: i (double) void
    public void setRotationFrictionFactor(double var1) {
        this.rotationFrictionFactor = var1;
    }

    // $FF: renamed from: q () double
    public double getMomentumTransferFactor() {
        return this.momentumTransferFactor;
    }

    // $FF: renamed from: j (double) void
    public void setMomentumTransferFactor(double var1) {
        this.momentumTransferFactor = var1;
    }

    // $FF: renamed from: r () double
    public double getSurfaceFriction() {
        return this.surfaceFriction;
    }

    // $FF: renamed from: k (double) void
    public void setSurfaceFriction(double var1) {
        this.surfaceFriction = var1;
    }
}
