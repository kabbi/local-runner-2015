package com.a.a.b.c;

import com.a.a.b.f.GeometryUtil;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.a
public class ArcForm extends ThinForm {
    // $FF: renamed from: a double
    private final double radius;
    // $FF: renamed from: b double
    private final double angle;
    // $FF: renamed from: c double
    private final double sector;

    public ArcForm(double radius, double angle, double sector, boolean endpointCollisionEnabled) {
        super(Shape.ARC, endpointCollisionEnabled);
        if(!Double.isNaN(radius) && !Double.isInfinite(radius) && radius > 0.0D) {
            if(!Double.isNaN(angle) && !Double.isInfinite(angle)) {
                if(!Double.isNaN(sector) && !Double.isInfinite(sector) && sector > 0.0D && sector <= 6.283185307179586D) {
                    this.angle = GeometryUtil.normalizeAngle(angle);
                    this.radius = radius;
                    this.sector = sector;
                } else {
                    throw new IllegalArgumentException(String.format("Argument \'sector\' should be between 0.0 exclusive and 2 * PI inclusive but got %s.", new Object[]{Double.valueOf(sector)}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Argument \'angle\' should be a finite number but got %s.", new Object[]{Double.valueOf(angle)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'radius\' should be a positive finite number but got %s.", new Object[]{Double.valueOf(radius)}));
        }
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

    // $FF: renamed from: d () double
    public double getCircumcircleRadius() {
        return this.radius;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D getCenterOfMass(Point2D position, double angle) {
        return position; // TODO just a method stub, does not really return a center of mass
    }

    // $FF: renamed from: a (double) double
    public double getAngularMass(double mass) {
        if(Double.isInfinite(mass) && mass != Double.NEGATIVE_INFINITY) {
            return mass;
        } else {
            throw new IllegalArgumentException("Arc form is only supported for static bodies.");
        }
    }

    public String toString() {
        return StringUtil.toString(this, false, "radius", "angle", "sector");
    }
}
