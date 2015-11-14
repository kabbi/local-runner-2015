package com.a.c.b.a;

import com.a.a.b.class_106;
import com.a.a.b.e.class_12;
import com.a.a.b.e.class_184;
import com.a.a.b.e.class_185;
import com.a.c.Body;
import com.a.c.a.Form;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.c.b.a.a
final class NonmaterialBodyLikeAGhost extends Body {
    // $FF: renamed from: a com.a.a.b.a
    @Name("body")
    private final class_106 body;

    NonmaterialBodyLikeAGhost(long var1, class_106 var3, String var4, double var5, Form var7, boolean var8) {
        super(var1);
        this.body = var3;
        this.setUniqueName(var4);
        this.setMass(var5);
        this.setForm(var7 == null ? null : var7.method_818());
        this.setStaticBody(var8);
    }

    // $FF: renamed from: c () double
    public double getX() {
        return this.body.method_695();
    }

    // $FF: renamed from: a (double) void
    public void setX(double var1) {
        this.body.method_696(var1);
    }

    // $FF: renamed from: d () double
    public double getY() {
        return this.body.method_697();
    }

    // $FF: renamed from: b (double) void
    public void setY(double var1) {
        this.body.method_698(var1);
    }

    // $FF: renamed from: e () double
    public double getAngle() {
        return this.body.method_707();
    }

    // $FF: renamed from: c (double) void
    public void setAngle(double var1) {
        this.body.method_708(var1);
        this.body.method_718();
    }

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public Vector2D getSpeed() {
        return this.body.method_699();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setSpeed(Vector2D var1) {
        this.body.method_700(var1);
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public Vector2D setMedianSpeed() {
        return this.body.method_702();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void getMedianSpeed(Vector2D var1) {
        this.body.method_703(var1);
    }

    // $FF: renamed from: h () double
    public double angularSpeed() {
        return this.body.method_709();
    }

    // $FF: renamed from: d (double) void
    public void setAngularSpeed(double var1) {
        this.body.method_710(var1);
    }

    // $FF: renamed from: i () double
    public double getAngularSpeed() {
        return this.body.method_711();
    }

    // $FF: renamed from: e (double) void
    public void setMoreAngularSpeed(double var1) {
        this.body.method_712(var1);
    }

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public Vector2D getTheForce() {
        return this.body.method_704();
    }

    // $FF: renamed from: k () double
    public double getTorque() {
        return this.body.method_713();
    }

    // $FF: renamed from: l () double
    public double getMovementAirFrictionFactor() {
        return this.body.method_676();
    }

    // $FF: renamed from: f (double) void
    public void setMovementAirFrictionFactor(double var1) {
        this.body.method_677(var1);
    }

    // $FF: renamed from: m () double
    public double getRotationAirFrictionFactor() {
        return this.body.method_678();
    }

    // $FF: renamed from: g (double) void
    public void setRotationAirFrictionFactor(double var1) {
        this.body.method_679(var1);
    }

    // $FF: renamed from: n () double
    public double getMovementFrictionFactor() {
        class_12 var1 = this.body.method_680();
        if(var1 instanceof class_184) {
            return ((class_184)var1).method_988();
        } else if(var1 instanceof class_185) {
            return ((class_185)var1).method_989();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: h (double) void
    public void setMovementFrictionFactor(double var1) {
        Double var3 = this.getCrosswiseMovementFrictionFactor();
        if(var3 == null) {
            this.body.method_682(var1);
        } else {
            this.body.method_681(new class_185(var1, var3.doubleValue()));
        }

    }

    // $FF: renamed from: o () java.lang.Double
    public Double getCrosswiseMovementFrictionFactor() {
        class_12 var1 = this.body.method_680();
        if(var1 instanceof class_184) {
            return null;
        } else if(var1 instanceof class_185) {
            return ((class_185) var1).method_990();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var1}));
        }
    }

    // $FF: renamed from: a (java.lang.Double) void
    public void setCrosswiseMovementFrictionFactor(Double var1) {
        double var2 = this.getMovementFrictionFactor();
        if(var1 == null) {
            this.body.method_682(var2);
        } else {
            this.body.method_681(new class_185(var2, var1.doubleValue()));
        }

    }

    // $FF: renamed from: p () double
    public double getRotationFrictionFactor() {
        return this.body.method_684();
    }

    // $FF: renamed from: i (double) void
    public void setRotationFrictionFactor(double var1) {
        this.body.method_685(var1);
    }

    // $FF: renamed from: q () double
    public double getMomentumTransferFactor() {
        return this.body.method_686();
    }

    // $FF: renamed from: j (double) void
    public void setMomentumTransferFactor(double var1) {
        this.body.method_687(var1);
    }

    // $FF: renamed from: r () double
    public double getSurfaceFriction() {
        return this.body.method_688();
    }

    // $FF: renamed from: k (double) void
    public void setSurfaceFriction(double var1) {
        this.body.method_689(var1);
    }
}
