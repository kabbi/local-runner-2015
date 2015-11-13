package com.codeforces.commons.geometry;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

public class Line2D {
    // $FF: renamed from: a double
    private final double field_795;
    // $FF: renamed from: b double
    private final double field_796;
    // $FF: renamed from: c double
    private final double field_797;
    private final double pseudoLength;

    public Line2D(double var1, double var3, double var5) {
        this.field_795 = var1;
        this.field_796 = var3;
        this.field_797 = var5;
        this.pseudoLength = Math.hypot(this.field_795, this.field_796);
    }

    public Line2D getParallelLine(double var1, double var3) {
        double var5 = this.field_795 * var1 + this.field_796 * var3 + this.field_797;
        return new Line2D(this.field_795, this.field_796, this.field_797 - var5);
    }

    public Line2D getParallelLine(Point2D var1) {
        return this.getParallelLine(var1.getX(), var1.getY());
    }

    public double getDistanceFrom(double var1, double var3) {
        return Math.abs((this.field_795 * var1 + this.field_796 * var3 + this.field_797) / this.pseudoLength);
    }

    public double getDistanceFrom(Point2D var1) {
        return this.getDistanceFrom(var1.getX(), var1.getY());
    }

    public double getDistanceFrom(Line2D var1, double var2) {
        return this.getIntersectionPoint(var1, var2) != null?Double.NaN:Math.abs(this.field_797 - var1.field_797) / this.pseudoLength;
    }

    public double getSignedDistanceFrom(double var1, double var3) {
        return (this.field_795 * var1 + this.field_796 * var3 + this.field_797) / this.pseudoLength;
    }

    public double getSignedDistanceFrom(Point2D var1) {
        return this.getSignedDistanceFrom(var1.getX(), var1.getY());
    }

    public Vector2D getUnitNormal() {
        return new Vector2D(this.field_795 / this.pseudoLength, this.field_796 / this.pseudoLength);
    }

    public Vector2D getUnitNormalFrom(double var1, double var3, double var5) {
        double var7 = this.getSignedDistanceFrom(var1, var3);
        if(var7 <= -var5) {
            return new Vector2D(this.field_795 / this.pseudoLength, this.field_796 / this.pseudoLength);
        } else if(var7 >= var5) {
            return new Vector2D(-this.field_795 / this.pseudoLength, -this.field_796 / this.pseudoLength);
        } else {
            throw new IllegalArgumentException(String.format("Point {x=%s, y=%s} is on the %s.", new Object[]{Double.valueOf(var1), Double.valueOf(var3), this}));
        }
    }

    public Vector2D getUnitNormalFrom(Point2D var1, double var2) {
        return this.getUnitNormalFrom(var1.getX(), var1.getY(), var2);
    }

    public Vector2D getUnitNormalFrom(Point2D var1) {
        return this.getUnitNormalFrom(var1.getX(), var1.getY(), 1.0E-6D);
    }

    public Point2D getProjectionOf(double var1, double var3, double var5) {
        double var7 = this.getDistanceFrom(var1, var3);
        if(var7 < var5) {
            return new Point2D(var1, var3);
        } else {
            Vector2D var9 = this.getUnitNormalFrom(var1, var3, var5);
            return new Point2D(var1 + var9.getX() * var7, var3 + var9.getY() * var7);
        }
    }

    public Point2D getProjectionOf(Point2D var1, double var2) {
        return this.getProjectionOf(var1.getX(), var1.getY(), var2);
    }

    public Point2D getProjectionOf(Point2D var1) {
        return this.getProjectionOf(var1.getX(), var1.getY(), 1.0E-6D);
    }

    public Point2D getIntersectionPoint(Line2D var1, double var2) {
        double var4 = this.field_795 * var1.field_796 - var1.field_795 * this.field_796;
        return Math.abs(var4) < Math.abs(var2)?null:new Point2D((this.field_796 * var1.field_797 - var1.field_796 * this.field_797) / var4, (var1.field_795 * this.field_797 - this.field_795 * var1.field_797) / var4);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[]{"a", "b", "c"});
    }

    public static Line2D getLineByTwoPoints(double var0, double var2, double var4, double var6) {
        return new Line2D(var6 - var2, var0 - var4, (var2 - var6) * var0 + (var4 - var0) * var2);
    }

    public static Line2D getLineByTwoPoints(Point2D var0, Point2D var1) {
        return getLineByTwoPoints(var0.getX(), var0.getY(), var1.getX(), var1.getY());
    }
}
