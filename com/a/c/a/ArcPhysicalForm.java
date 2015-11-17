package com.a.c.a;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.a
public class ArcPhysicalForm extends PhysicalForm {
    // $FF: renamed from: a double
    private double radius;
    // $FF: renamed from: b double
    private double angle;
    // $FF: renamed from: c double
    private double sector;

    public ArcPhysicalForm(double radius, double angle, double sector) {
        this.radius = radius;
        this.angle = angle;
        this.sector = sector;
    }

    public ArcPhysicalForm(ArcPhysicalForm other) {
        this.radius = other.radius;
        this.angle = other.angle;
        this.sector = other.sector;
    }

    // $FF: renamed from: a () double
    public double getRadius() {
        return this.radius;
    }

    // $FF: renamed from: b () double
    public double getAngle() {
        return this.angle;
    }

    // $FF: renamed from: c () double
    public double getSector() {
        return this.sector;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public PhysicalForm copy() {
        return new ArcPhysicalForm(this);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean equals(PhysicalForm other, double epsilon) {
        if(other != null && this.getClass() == other.getClass()) {
            ArcPhysicalForm physicalForm = (ArcPhysicalForm) other;
            return Math.abs(this.radius - physicalForm.radius) < epsilon && Math.abs(this.sector - physicalForm.sector) < epsilon;
        } else {
            return false;
        }
    }
}
