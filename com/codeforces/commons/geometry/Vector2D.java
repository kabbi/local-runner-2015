package com.codeforces.commons.geometry;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.DoublePair;
import com.codeforces.commons.text.StringUtil;
import org.apache.commons.math3.util.MathArrays;

public class Vector2D extends DoublePair {
    public Vector2D(double var1, double var3) {
        super(Double.valueOf(var1), Double.valueOf(var3));
    }

    public Vector2D(double var1, double var3, double var5, double var7) {
        super(Double.valueOf(var5 - var1), Double.valueOf(var7 - var3));
    }

    public Vector2D(Point2D var1, Point2D var2) {
        super(Double.valueOf(var2.getX() - var1.getX()), Double.valueOf(var2.getY() - var1.getY()));
    }

    public Vector2D(Vector2D var1) {
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

    public Vector2D add(Vector2D var1) {
        this.setX(this.getX() + var1.getX());
        this.setY(this.getY() + var1.getY());
        return this;
    }

    public Vector2D add(double var1, double var3) {
        this.setX(this.getX() + var1);
        this.setY(this.getY() + var3);
        return this;
    }

    public Vector2D subtract(Vector2D var1) {
        this.setX(this.getX() - var1.getX());
        this.setY(this.getY() - var1.getY());
        return this;
    }

    public Vector2D multiply(double var1) {
        this.setX(var1 * this.getX());
        this.setY(var1 * this.getY());
        return this;
    }

    public Vector2D rotate(double var1) {
        double var3 = Math.cos(var1);
        double var5 = Math.sin(var1);
        double var7 = this.getX();
        double var9 = this.getY();
        this.setX(var7 * var3 - var9 * var5);
        this.setY(var7 * var5 + var9 * var3);
        return this;
    }

    public double dotProduct(Vector2D var1) {
        return MathArrays.linearCombination(this.getX(), var1.getX(), this.getY(), var1.getY());
    }

    public Vector2D negate() {
        this.setX(-this.getX());
        this.setY(-this.getY());
        return this;
    }

    public Vector2D normalize() {
        double var1 = this.getLength();
        if(var1 == 0.0D) {
            throw new IllegalStateException("Can\'t set angle of zero-width vector.");
        } else {
            this.setX(this.getX() / var1);
            this.setY(this.getY() / var1);
            return this;
        }
    }

    public double getAngle() {
        return Math.atan2(this.getY(), this.getX());
    }

    public Vector2D setAngle(double var1) {
        double var3 = this.getLength();
        if(var3 == 0.0D) {
            throw new IllegalStateException("Can\'t set angle of zero-width vector.");
        } else {
            this.setX(Math.cos(var1) * var3);
            this.setY(Math.sin(var1) * var3);
            return this;
        }
    }

    public double getLength() {
        return Math.hypot(this.getX(), this.getY());
    }

    public Vector2D setLength(double var1) {
        double var3 = this.getLength();
        if(var3 == 0.0D) {
            throw new IllegalStateException("Can\'t resize zero-width vector.");
        } else {
            return this.multiply(var1 / var3);
        }
    }

    public double getSquaredLength() {
        return this.getX() * this.getX() + this.getY() * this.getY();
    }

    public Vector2D copy() {
        return new Vector2D(this);
    }

    public Vector2D copyNegate() {
        return new Vector2D(-this.getX(), -this.getY());
    }

    public boolean nearlyEquals(Vector2D var1, double var2) {
        return var1 != null && NumberUtil.nearlyEquals(Double.valueOf(this.getX()), Double.valueOf(var1.getX()), var2) && NumberUtil.nearlyEquals(Double.valueOf(this.getY()), Double.valueOf(var1.getY()), var2);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[]{"x", "y"});
    }
}
