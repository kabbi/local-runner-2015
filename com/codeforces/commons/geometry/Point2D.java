package com.codeforces.commons.geometry;

import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.DoublePair;
import com.codeforces.commons.text.StringUtil;

public class Point2D extends DoublePair {
    public Point2D(double var1, double var3) {
        super(var1, var3);
    }

    public Point2D(Point2D var1) {
        super(var1.getX(), var1.getY());
    }

    public double getX() {
        return this.getFirst();
    }

    public void setX(double x) {
        this.setFirst(x);
    }

    public double getY() {
        return this.getSecond();
    }

    public void setY(double y) {
        this.setSecond(y);
    }

    public Point2D add(Vector2D vector) {
        this.setX(this.getX() + vector.getX());
        this.setY(this.getY() + vector.getY());
        return this;
    }

    public Point2D add(double x, double y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
        return this;
    }

    public Point2D subtract(Vector2D vector) {
        this.setX(this.getX() - vector.getX());
        this.setY(this.getY() - vector.getY());
        return this;
    }

    public double getDistanceTo(Point2D point) {
        return Math.hypot(this.getX() - point.getX(), this.getY() - point.getY());
    }

    public double getSquaredDistanceTo(Point2D point) {
        return Math.sumSqr(this.getX() - point.getX(), this.getY() - point.getY());
    }

    public Point2D copy() {
        return new Point2D(this);
    }

    public boolean nearlyEquals(Point2D point, double epsilon) {
        return point != null && NumberUtil.nearlyEquals(this.getX(), point.getX(), epsilon) &&
                NumberUtil.nearlyEquals(this.getY(), point.getY(), epsilon);
    }

    public String toString() {
        return StringUtil.toString(this, false, "x", "y");
    }
}
