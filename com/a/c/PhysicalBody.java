package com.a.c;

import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.util.Collections;
import java.util.Set;

// $FF: renamed from: com.a.c.c
public abstract class PhysicalBody {
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
    private class_125 form;
    // $FF: renamed from: e boolean
    @Name("staticBody")
    private boolean field_654;
    // $FF: renamed from: f java.util.Set
    @Name("excludedBodyIds")
    private Set excludedBodyIds;

    protected PhysicalBody(long var1) {
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
    public final void setName(String name) {
        this.name = name;
    }

    // $FF: renamed from: c () double
    public abstract double getX();

    // $FF: renamed from: a (double) void
    public abstract void setX(double x);

    // $FF: renamed from: d () double
    public abstract double getY();

    // $FF: renamed from: b (double) void
    public abstract void setY(double y);

    // $FF: renamed from: e () double
    public abstract double getAngle();

    // $FF: renamed from: c (double) void
    public abstract void setAngle(double angle);

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D getVelocity();

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public abstract void setVelocity(Vector2D vector);

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D getMedianVelocity();

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public abstract void setMedianVelocity(Vector2D vector);

    // $FF: renamed from: h () double
    public abstract double getAngularVelocity();

    // $FF: renamed from: d (double) void
    public abstract void setAngularVelocity(double velocity);

    // $FF: renamed from: i () double
    public abstract double getMedianAngularVelocity();

    // $FF: renamed from: e (double) void
    public abstract void setMedianAngularVelocity(double velocity);

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D getForce();

    // $FF: renamed from: k () double
    public abstract double getTorque();

    // $FF: renamed from: l () double
    public abstract double getMovementAirFrictionFactor();

    // $FF: renamed from: f (double) void
    public abstract void setMovementAirFrictionFactor(double factor);

    // $FF: renamed from: m () double
    public abstract double getRotationAirFrictionFactor();

    // $FF: renamed from: g (double) void
    public abstract void setRotationAirFrictionFactor(double factor);

    // $FF: renamed from: n () double
    public abstract double getMovementFrictionFactor();

    // $FF: renamed from: h (double) void
    public abstract void setMovementFrictionFactor(double factor);

    // $FF: renamed from: o () java.lang.Double
    public abstract Double getCrosswiseMovementFrictionFactor();

    // $FF: renamed from: a (java.lang.Double) void
    public abstract void setSomeOtherMovementFrictionFactor(Double factor);

    // $FF: renamed from: p () double
    public abstract double getRotationFrictionFactor();

    // $FF: renamed from: i (double) void
    public abstract void setRotationFrictionFactor(double factor);

    // $FF: renamed from: q () double
    public abstract double getMomentumTransferFactor();

    // $FF: renamed from: j (double) void
    public abstract void setMomentumTransferFactor(double factor);

    // $FF: renamed from: r () double
    public abstract double getSurfaceFrictionFactor();

    // $FF: renamed from: k (double) void
    public abstract void setSurfaceFrictionFactor(double factor);

    // $FF: renamed from: s () double
    public double getMass() {
        return this.mass;
    }

    // $FF: renamed from: l (double) void
    public void setMass(double mass) {
        this.mass = mass;
    }

    // $FF: renamed from: t () com.a.c.a.c
    public class_125 getForm() {
        return this.form;
    }

    // $FF: renamed from: a (com.a.c.a.c) void
    public void setForm(class_125 form) {
        this.form = form;
    }

    // $FF: renamed from: u () boolean
    public boolean method_904() {
        return this.field_654;
    }

    // $FF: renamed from: a (boolean) void
    public void method_905(boolean var1) {
        this.field_654 = var1;
    }

    // $FF: renamed from: v () java.util.Set
    public Set getExcludedBodyIds() {
        return this.excludedBodyIds == null ? Collections.emptySet() : Collections.unmodifiableSet(this.excludedBodyIds);
    }

    public String toString() {
        return StringUtil.toString(this, false, "id", "name", "x", "y");
    }
}
