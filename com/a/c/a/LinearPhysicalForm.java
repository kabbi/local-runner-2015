package com.a.c.a;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.d
public class LinearPhysicalForm extends PhysicalForm {
    // $FF: renamed from: a double
    private double x1;
    // $FF: renamed from: b double
    private double y1;
    // $FF: renamed from: c double
    private double x2;
    // $FF: renamed from: d double
    private double y2;

    public LinearPhysicalForm(double var1, double var3, double var5, double var7) {
        this.x1 = var1;
        this.y1 = var3;
        this.x2 = var5;
        this.y2 = var7;
    }

    public LinearPhysicalForm(Point2D point1, Point2D point2) {
        this.x1 = point1.getX();
        this.y1 = point1.getY();
        this.x2 = point2.getX();
        this.y2 = point2.getY();
    }

    public LinearPhysicalForm(LinearPhysicalForm var1) {
        this.x1 = var1.x1;
        this.y1 = var1.y1;
        this.x2 = var1.x2;
        this.y2 = var1.y2;
    }

    // $FF: renamed from: a () double
    public double getX1() {
        return this.x1;
    }

    // $FF: renamed from: b () double
    public double getY1() {
        return this.y1;
    }

    // $FF: renamed from: c () double
    public double getX2() {
        return this.x2;
    }

    // $FF: renamed from: f () double
    public double getY2() {
        return this.y2;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public PhysicalForm copy() {
        return new LinearPhysicalForm(this);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean equals(PhysicalForm other, double epsilon) {
        if(other != null && this.getClass() == other.getClass()) {
            LinearPhysicalForm physicalForm = (LinearPhysicalForm) other;
            return Math.abs(this.x1 - physicalForm.x1) < epsilon
                    && Math.abs(this.y1 - physicalForm.y1) < epsilon
                    && Math.abs(this.x2 - physicalForm.x2) < epsilon
                    && Math.abs(this.y2 - physicalForm.y2) < epsilon;
        } else {
            return false;
        }
    }
}
