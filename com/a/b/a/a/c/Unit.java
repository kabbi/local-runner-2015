package com.a.b.a.a.c;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.u
public abstract class Unit {
    // $FF: renamed from: id long
    private final long id;
    @Until(1.0D)
    private final double mass;
    // $FF: renamed from: x double
    private final double x;
    // $FF: renamed from: y double
    private final double y;
    private final double speedX;
    private final double speedY;
    private final double angle;
    private final double angularSpeed;

    protected Unit(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15) {
        this.id = var1;
        this.mass = var3;
        this.x = var5;
        this.y = var7;
        this.speedX = var9;
        this.speedY = var11;
        this.angle = var13;
        this.angularSpeed = var15;
    }

    public long getId() {
        return this.id;
    }

    public double getMass() {
        return this.mass;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
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

    public double getAngleTo(double x, double y) {
        double var5 = Math.atan2(y - this.y, x - this.x);

        double var7;
        for(var7 = var5 - this.angle; var7 > StrictMath.PI; var7 -= 2 * StrictMath.PI) {
            ;
        }

        while(var7 < -StrictMath.PI) {
            var7 += 2 * StrictMath.PI;
        }

        return var7;
    }

    public double getAngleTo(Unit unit) {
        return this.getAngleTo(unit.x, unit.y);
    }

    public double getDistanceTo(double x, double y) {
        return Math.hypot(x - this.x, y - this.y);
    }

    public double getDistanceTo(Unit unit) {
        return this.getDistanceTo(unit.x, unit.y);
    }

    protected static boolean areFieldEquals(Unit a, Unit b) {
        return a.id == b.id && Double.compare(a.mass, b.mass) == 0 && Double.compare(a.x, b.x) == 0 && Double.compare(a.y, b.y) == 0 && Double.compare(a.speedX, b.speedX) == 0 && Double.compare(a.speedY, b.speedY) == 0 && Double.compare(a.angle, b.angle) == 0 && Double.compare(a.angularSpeed, b.angularSpeed) == 0;
    }
}
