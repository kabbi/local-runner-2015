package com.a.a.b.c;

import com.a.a.b.Body;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.c.c
public abstract class Form {
    // $FF: renamed from: a com.a.a.b.c.f
    private final Shape shape;

    protected Form(Shape shape) {
        if(shape == null) {
            throw new IllegalArgumentException("Argument \'shape\' is null.");
        } else {
            this.shape = shape;
        }
    }

    // $FF: renamed from: e () com.a.a.b.c.f
    public Shape getShape() {
        return this.shape;
    }

    // $FF: renamed from: d () double
    public abstract double getCircumcircleRadius();

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public abstract Point2D getCenterOfMass(Point2D position, double angle);

    // $FF: renamed from: a (com.a.a.b.a) com.codeforces.commons.geometry.Point2D
    public final Point2D getCenterOfMass(Body body) {
        return this.getCenterOfMass(body.getPosition(), body.getAngle());
    }

    // $FF: renamed from: a (double) double
    public abstract double getAngularMass(double mass);

    public abstract String toString();

    // $FF: renamed from: a (com.a.a.b.c.c) java.lang.String
    public static String toString(Form form) {
        return form == null ? "Form {null}" : form.toString();
    }

    // $FF: renamed from: a (double, double) double
    protected static double normalizeSinCos(double value, double epsilon) {
        return Math.abs(value) < epsilon ? 0.0D
                : Math.abs(1.0D - value) < epsilon ? 1.0D
                : Math.abs(-1.0D - value) < epsilon ? -1.0D
                : value;
    }
}
