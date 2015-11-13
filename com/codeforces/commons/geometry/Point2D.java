package com.codeforces.commons.geometry;

import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.DoublePair;
import com.codeforces.commons.text.StringUtil;

public class Point2D extends DoublePair {
    public Point2D(double var1, double var3) {
        super(Double.valueOf(var1), Double.valueOf(var3));
    }

    public Point2D(Point2D var1) {
        super(Double.valueOf(var1.getX()), Double.valueOf(var1.getY()));
    }

    public double getX() {
        return ((Double)this.getFirst()).doubleValue();
    }

    public void setX(double var1) {
        this.setFirst(Double.valueOf(var1));
    }

    public double getY() {
        return ((Double)this.getSecond()).doubleValue();
    }

    public void setY(double var1) {
        this.setSecond(Double.valueOf(var1));
    }

    public Point2D add(Vector2D var1) {
        this.setX(this.getX() + var1.getX());
        this.setY(this.getY() + var1.getY());
        return this;
    }

    public Point2D add(double var1, double var3) {
        this.setX(this.getX() + var1);
        this.setY(this.getY() + var3);
        return this;
    }

    public Point2D subtract(Vector2D var1) {
        this.setX(this.getX() - var1.getX());
        this.setY(this.getY() - var1.getY());
        return this;
    }

    public double getDistanceTo(Point2D var1) {
        return Math.hypot(this.getX() - var1.getX(), this.getY() - var1.getY());
    }

    public double getSquaredDistanceTo(Point2D var1) {
        return Math.sumSqr(this.getX() - var1.getX(), this.getY() - var1.getY());
    }

    public Point2D copy() {
        return new Point2D(this);
    }

    public boolean nearlyEquals(Point2D var1, double var2) {
        return var1 != null && NumberUtil.nearlyEquals(Double.valueOf(this.getX()), Double.valueOf(var1.getX()), var2) && NumberUtil.nearlyEquals(Double.valueOf(this.getY()), Double.valueOf(var1.getY()), var2);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[]{"x", "y"});
    }
}
