package com.a.c.a;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.b
public class CircularPhysicalForm extends PhysicalForm {
    // $FF: renamed from: a double
    private double radius;

    public CircularPhysicalForm(double radius) {
        this.radius = radius;
    }

    public CircularPhysicalForm(CircularPhysicalForm other) {
        this.radius = other.radius;
    }

    // $FF: renamed from: a () double
    public double getRadius() {
        return this.radius;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public PhysicalForm copy() {
        return new CircularPhysicalForm(this);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean equals(PhysicalForm other, double epsilon) {
        if(other != null && this.getClass() == other.getClass()) {
            CircularPhysicalForm physicalForm = (CircularPhysicalForm) other;
            return Math.abs(this.radius - physicalForm.radius) < epsilon;
        } else {
            return false;
        }
    }
}
