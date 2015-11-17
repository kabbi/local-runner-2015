package com.a.c;

import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.f
public final class AstralPhysicalBody extends PhysicalBody {
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

    public AstralPhysicalBody(long var1) {
        super(var1);
    }

    // $FF: renamed from: c () double
    public double getX() {
        return this.field_657;
    }

    // $FF: renamed from: a (double) void
    public void setX(double x) {
        this.field_657 = x;
    }

    // $FF: renamed from: d () double
    public double getY() {
        return this.field_658;
    }

    // $FF: renamed from: b (double) void
    public void setY(double y) {
        this.field_658 = y;
    }

    // $FF: renamed from: e () double
    public double getAngle() {
        return this.field_659;
    }

    // $FF: renamed from: c (double) void
    public void setAngle(double angle) {
        while(angle > 3.141592653589793D) {
            angle -= 6.283185307179586D;
        }

        while(angle < -3.141592653589793D) {
            angle += 6.283185307179586D;
        }

        this.field_659 = angle;
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D getVelocity() {
        return this.field_660;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setVelocity(Vector2D vector) {
        this.field_660 = vector;
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D getMedianVelocity() {
        return this.field_661;
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void setMedianVelocity(Vector2D vector) {
        this.field_661 = vector;
    }

    // $FF: renamed from: h () double
    public double getAngularVelocity() {
        return this.field_662;
    }

    // $FF: renamed from: d (double) void
    public void setAngularVelocity(double velocity) {
        this.field_662 = velocity;
    }

    // $FF: renamed from: i () double
    public double getMedianAngularVelocity() {
        return this.field_663;
    }

    // $FF: renamed from: e (double) void
    public void setMedianAngularVelocity(double velocity) {
        this.field_663 = velocity;
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D getForce() {
        return this.field_664;
    }

    // $FF: renamed from: k () double
    public double getTorque() {
        return this.field_665;
    }

    // $FF: renamed from: l () double
    public double getMovementAirFrictionFactor() {
        return this.field_666;
    }

    // $FF: renamed from: f (double) void
    public void setMovementAirFrictionFactor(double factor) {
        this.field_666 = factor;
    }

    // $FF: renamed from: m () double
    public double getRotationAirFrictionFactor() {
        return this.field_667;
    }

    // $FF: renamed from: g (double) void
    public void setRotationAirFrictionFactor(double factor) {
        this.field_667 = factor;
    }

    // $FF: renamed from: n () double
    public double getMovementFrictionFactor() {
        return this.field_668;
    }

    // $FF: renamed from: h (double) void
    public void setMovementFrictionFactor(double factor) {
        this.field_668 = factor;
    }

    // $FF: renamed from: o () java.lang.Double
    public Double getCrosswiseMovementFrictionFactor() {
        return this.field_669;
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void setSomeOtherMovementFrictionFactor(Double factor) {
        this.field_669 = factor;
    }

    // $FF: renamed from: p () double
    public double getRotationFrictionFactor() {
        return this.field_670;
    }

    // $FF: renamed from: i (double) void
    public void setRotationFrictionFactor(double factor) {
        this.field_670 = factor;
    }

    // $FF: renamed from: q () double
    public double getMomentumTransferFactor() {
        return this.field_671;
    }

    // $FF: renamed from: j (double) void
    public void setMomentumTransferFactor(double factor) {
        this.field_671 = factor;
    }

    // $FF: renamed from: r () double
    public double getSurfaceFrictionFactor() {
        return this.field_672;
    }

    // $FF: renamed from: k (double) void
    public void setSurfaceFrictionFactor(double factor) {
        this.field_672 = factor;
    }
}
