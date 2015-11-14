package com.a.c;

import com.a.c.a.Form;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.util.Collections;
import java.util.Set;

// $FF: renamed from: com.a.c.c
public abstract class Body {
    // $FF: renamed from: a long
    @Name("id")
    private final long id;
    // $FF: renamed from: b java.lang.String
    @Name("name")
    private String name;
    // $FF: renamed from: c double
    @Name("mass")
    private double mass;
    // $FF: renamed from: d com.a.c.a.c
    @Name("form")
    private Form form;
    // $FF: renamed from: e boolean
    @Name("staticBody")
    private boolean staticBody;
    // $FF: renamed from: f java.util.Set
    @Name("excludedBodyIds")
    private Set excludedBodyIds;

    protected Body(long var1) {
        this.id = var1;
    }

    // $FF: renamed from: a () long
    public final long getId() {
        return this.id;
    }

    // $FF: renamed from: b () java.lang.String
    public final String getName() {
        return this.name;
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void setUniqueName(String var1) {
        this.name = var1;
    }

    // $FF: renamed from: c () double
    public abstract double getX();

    // $FF: renamed from: a (double) void
    public abstract void setX(double var1);

    // $FF: renamed from: d () double
    public abstract double getY();

    // $FF: renamed from: b (double) void
    public abstract void setY(double var1);

    // $FF: renamed from: e () double
    public abstract double getAngle();

    // $FF: renamed from: c (double) void
    public abstract void setAngle(double var1);

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D getSpeed();

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public abstract void setSpeed(Vector2D var1);

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D setMedianSpeed();

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public abstract void getMedianSpeed(Vector2D var1);

    // $FF: renamed from: h () double
    public abstract double angularSpeed();

    // $FF: renamed from: d (double) void
    public abstract void setAngularSpeed(double var1);

    // $FF: renamed from: i () double
    public abstract double getAngularSpeed();

    // $FF: renamed from: e (double) void
    public abstract void setMoreAngularSpeed(double var1);

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D getTheForce();

    // $FF: renamed from: k () double
    public abstract double getTorque();

    // $FF: renamed from: l () double
    public abstract double getMovementAirFrictionFactor();

    // $FF: renamed from: f (double) void
    public abstract void setMovementAirFrictionFactor(double var1);

    // $FF: renamed from: m () double
    public abstract double getRotationAirFrictionFactor();

    // $FF: renamed from: g (double) void
    public abstract void setRotationAirFrictionFactor(double var1);

    // $FF: renamed from: n () double
    public abstract double getMovementFrictionFactor();

    // $FF: renamed from: h (double) void
    public abstract void setMovementFrictionFactor(double var1);

    // $FF: renamed from: o () java.lang.Double
    public abstract Double getCrosswiseMovementFrictionFactor();

    // $FF: renamed from: a (java.lang.Double) void
    public abstract void setCrosswiseMovementFrictionFactor(Double var1);

    // $FF: renamed from: p () double
    public abstract double getRotationFrictionFactor();

    // $FF: renamed from: i (double) void
    public abstract void setRotationFrictionFactor(double var1);

    // $FF: renamed from: q () double
    public abstract double getMomentumTransferFactor();

    // $FF: renamed from: j (double) void
    public abstract void setMomentumTransferFactor(double var1);

    // $FF: renamed from: r () double
    public abstract double getSurfaceFriction();

    // $FF: renamed from: k (double) void
    public abstract void setSurfaceFriction(double var1);

    // $FF: renamed from: s () double
    public double getMass() {
        return this.mass;
    }

    // $FF: renamed from: l (double) void
    public void setMass(double var1) {
        this.mass = var1;
    }

    // $FF: renamed from: t () com.a.c.a.c
    public Form getForm() {
        return this.form;
    }

    // $FF: renamed from: a (com.a.c.a.c) void
    public void setForm(Form var1) {
        this.form = var1;
    }

    // $FF: renamed from: u () boolean
    public boolean getStaticBody() {
        return this.staticBody;
    }

    // $FF: renamed from: a (boolean) void
    public void setStaticBody(boolean var1) {
        this.staticBody = var1;
    }

    // $FF: renamed from: v () java.util.Set
    public Set getExcludedBodyIds() {
        return this.excludedBodyIds == null?Collections.emptySet():Collections.unmodifiableSet(this.excludedBodyIds);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[]{"id", "name", "x", "y"});
    }
}
