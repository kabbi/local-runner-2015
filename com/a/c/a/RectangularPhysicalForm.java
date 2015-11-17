package com.a.c.a;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.e
public class RectangularPhysicalForm extends PhysicalForm {
    // $FF: renamed from: a double
    private double width;
    // $FF: renamed from: b double
    private double height;

    public RectangularPhysicalForm(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectangularPhysicalForm(RectangularPhysicalForm other) {
        this.width = other.width;
        this.height = other.height;
    }

    // $FF: renamed from: a () double
    public double getWidth() {
        return this.width;
    }

    // $FF: renamed from: b () double
    public double getHeight() {
        return this.height;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public PhysicalForm copy() {
        return new RectangularPhysicalForm(this);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean equals(PhysicalForm other, double epsilon) {
        if(other != null && this.getClass() == other.getClass()) {
            RectangularPhysicalForm physicalForm = (RectangularPhysicalForm) other;
            return Math.abs(this.width - physicalForm.width) < epsilon && Math.abs(this.height - physicalForm.height) < epsilon;
        } else {
            return false;
        }
    }
}
