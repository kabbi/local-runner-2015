package com.a.b.a.a.b.d.e;

import com.a.b.class_42;
import com.a.b.class_58;
import com.a.b.a.a.b.class_171;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.c.ProjectileType;
import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.b.d.e.a
public abstract class class_48 extends class_42 {
    // $FF: renamed from: a com.a.b.a.a.b.d.c.b
    @Name("car")
    private final class_43 field_187;
    // $FF: renamed from: b com.a.b.a.a.b.n
    @Name("player")
    private final class_171 field_188;
    // $FF: renamed from: c com.a.b.a.a.c.r
    @Name("type")
    private final ProjectileType field_189;
    // $FF: renamed from: d int
    @Name("creationTick")
    private final int field_190;
    // $FF: renamed from: e boolean
    private boolean field_191 = true;

    protected class_48(class_125 var1, class_43 var2, class_171 var3, ProjectileType var4, int var5, Point2D var6, Vector2D var7, double var8, double var10) {
        super(var1);
        if(!Double.isNaN(var10) && !Double.isInfinite(var10) && var10 > 0.0D) {
            this.field_187 = var2;
            this.field_188 = var3;
            this.field_189 = var4;
            this.field_190 = var5;
            this.method_279().setX(var6.getX());
            this.method_279().setY(var6.getY());
            this.method_279().setAngle(var8);
            this.method_279().setMass(var10);
            this.method_279().setMomentumTransferFactor(1.0D);
            this.method_279().setSurfaceFrictionFactor(1.0D);
            this.method_279().setVelocity(var7.copy());
        } else {
            throw new IllegalArgumentException("Argument \'mass\' is not a positive number.");
        }
    }

    // $FF: renamed from: k () com.a.b.a.a.b.d.c.b
    public class_43 method_352() {
        return this.field_187;
    }

    // $FF: renamed from: l () com.a.b.a.a.b.n
    public class_171 method_353() {
        return this.field_188;
    }

    // $FF: renamed from: m () com.a.b.a.a.c.r
    public ProjectileType method_354() {
        return this.field_189;
    }

    // $FF: renamed from: n () int
    public int method_355() {
        return this.field_190;
    }

    // $FF: renamed from: o () boolean
    public boolean method_356() {
        return this.field_191;
    }

    // $FF: renamed from: a (boolean) void
    public void method_357(boolean var1) {
        this.field_191 = var1;
    }

    // $FF: renamed from: a (com.a.b.f, int) double
    public abstract double method_358(class_58 var1, int var2);
}
