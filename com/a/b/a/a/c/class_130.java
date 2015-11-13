package com.a.b.a.a.c;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.u
public abstract class class_130 {
    // $FF: renamed from: id long
    private final long field_566;
    @Until(1.0D)
    private final double mass;
    // $FF: renamed from: x double
    private final double field_567;
    // $FF: renamed from: y double
    private final double field_568;
    private final double speedX;
    private final double speedY;
    private final double angle;
    private final double angularSpeed;

    protected class_130(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15) {
        this.field_566 = var1;
        this.mass = var3;
        this.field_567 = var5;
        this.field_568 = var7;
        this.speedX = var9;
        this.speedY = var11;
        this.angle = var13;
        this.angularSpeed = var15;
    }

    public long getId() {
        return this.field_566;
    }

    public double getMass() {
        return this.mass;
    }

    public final double getX() {
        return this.field_567;
    }

    public final double getY() {
        return this.field_568;
    }

    public final double getSpeedX() {
        return this.speedX;
    }

    public final double getSpeedY() {
        return this.speedY;
    }

    public final double getAngle() {
        return this.angle;
    }

    public double getAngularSpeed() {
        return this.angularSpeed;
    }

    public double getAngleTo(double var1, double var3) {
        double var5 = Math.atan2(var3 - this.field_568, var1 - this.field_567);

        double var7;
        for(var7 = var5 - this.angle; var7 > 3.141592653589793D; var7 -= 6.283185307179586D) {
            ;
        }

        while(var7 < -3.141592653589793D) {
            var7 += 6.283185307179586D;
        }

        return var7;
    }

    public double getAngleTo(class_130 var1) {
        return this.getAngleTo(var1.field_567, var1.field_568);
    }

    public double getDistanceTo(double var1, double var3) {
        return Math.hypot(var1 - this.field_567, var3 - this.field_568);
    }

    public double getDistanceTo(class_130 var1) {
        return this.getDistanceTo(var1.field_567, var1.field_568);
    }

    protected static boolean areFieldEquals(class_130 var0, class_130 var1) {
        return var0.field_566 == var1.field_566 && Double.compare(var0.mass, var1.mass) == 0 && Double.compare(var0.field_567, var1.field_567) == 0 && Double.compare(var0.field_568, var1.field_568) == 0 && Double.compare(var0.speedX, var1.speedX) == 0 && Double.compare(var0.speedY, var1.speedY) == 0 && Double.compare(var0.angle, var1.angle) == 0 && Double.compare(var0.angularSpeed, var1.angularSpeed) == 0;
    }
}
