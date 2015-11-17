package com.a.a.b.c;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.b
public class CircularForm extends Form {
    // $FF: renamed from: a double
    private final double radius;
    // $FF: renamed from: b double
    private final double angularMassFactor;

    public CircularForm(double radius) {
        super(Shape.CIRCLE);
        if(!Double.isNaN(radius) && !Double.isInfinite(radius) && radius > 0.0D) {
            this.radius = radius;
            this.angularMassFactor = radius * radius / 2.0D;
        } else {
            throw new IllegalArgumentException(String.format("Argument \'radius\' should be positive finite number but got %s.", new Object[]{Double.valueOf(radius)}));
        }
    }

    // $FF: renamed from: a () double
    public double getRadius() {
        return this.radius;
    }

    // $FF: renamed from: d () double
    public double getCircumcircleRadius() {
        return this.radius;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D getCenterOfMass(Point2D position, double angle) {
        return position;
    }

    // $FF: renamed from: a (double) double
    public double getAngularMass(double mass) {
        return mass * this.angularMassFactor;
    }

    public String toString() {
        return StringUtil.toString(this, false, "radius");
    }
}
