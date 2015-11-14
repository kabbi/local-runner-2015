package com.a.b.a.a.b.d.e;

import com.a.b.RectangleBody;
import com.a.b.class_58;
import com.a.b.a.a.b.BoringTeamInfo;
import com.a.b.a.a.b.d.c.CarPhysicalBody;
import com.a.b.a.a.c.ProjectileType;
import com.a.c.a.Form;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.b.d.e.a
public abstract class Car extends RectangleBody {
    // $FF: renamed from: a com.a.b.a.a.b.d.c.b
    @Name("car")
    private final CarPhysicalBody carPhys;
    // $FF: renamed from: b com.a.b.a.a.b.n
    @Name("player")
    private final BoringTeamInfo field_188;
    // $FF: renamed from: c com.a.b.a.a.c.r
    @Name("type")
    private final ProjectileType field_189;
    // $FF: renamed from: d int
    @Name("creationTick")
    private final int field_190;
    // $FF: renamed from: e boolean
    private boolean field_191 = true;

    protected Car(Form var1, CarPhysicalBody carPhys, BoringTeamInfo var3, ProjectileType var4, int var5, Point2D var6, Vector2D speed, double var8, double mass) {
        super(var1);
        if(!Double.isNaN(mass) && !Double.isInfinite(mass) && mass > 0.0D) {
            this.carPhys = carPhys;
            this.field_188 = var3;
            this.field_189 = var4;
            this.field_190 = var5;
            this.getBody().setX(var6.getX());
            this.getBody().setY(var6.getY());
            this.getBody().setAngle(var8);
            this.getBody().setMass(mass);
            this.getBody().setMomentumTransferFactor(1.0D);
            this.getBody().setSurfaceFriction(1.0D);
            this.getBody().setSpeed(speed.copy());
        } else {
            throw new IllegalArgumentException("Argument \'mass\' is not a positive number.");
        }
    }

    // $FF: renamed from: k () com.a.b.a.a.b.d.c.b
    public CarPhysicalBody method_352() {
        return this.carPhys;
    }

    // $FF: renamed from: l () com.a.b.a.a.b.n
    public BoringTeamInfo method_353() {
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
