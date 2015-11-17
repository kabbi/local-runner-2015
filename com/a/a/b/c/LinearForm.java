package com.a.a.b.c;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.d
public class LinearForm extends ThinForm {
    // $FF: renamed from: a double
    private final double length;
    // $FF: renamed from: b double
    private final double halfLength;
    // $FF: renamed from: c double
    private final double angularMassFactor;

    // $FF: renamed from: d double
    private double lastAngle;
    // $FF: renamed from: e double
    private double lastEpsilon;
    // $FF: renamed from: f java.lang.Double
    private Double lastXOffset;
    // $FF: renamed from: g java.lang.Double
    private Double lastYOffset;

    public LinearForm(double length, boolean endpointCollisionEnabled) {
        super(Shape.LINE, endpointCollisionEnabled);
        if(!Double.isNaN(length) && !Double.isInfinite(length) && length > 0.0D) {
            this.length = length;
            this.halfLength = length / 2.0D;
            this.angularMassFactor = length * length / 12.0D;
        } else {
            throw new IllegalArgumentException(String.format("Argument \'length\' should be positive finite number but got %s.", new Object[]{Double.valueOf(length)}));
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D
    public Point2D getPoint1(Point2D position, double angle, double epsilon) {
        this.updateLastOffsets(angle, epsilon);
        return new Point2D(position.getX() - this.lastXOffset, position.getY() - this.lastYOffset);
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D
    public Point2D getPoint2(Point2D position, double angle, double epsilon) {
        this.updateLastOffsets(angle, epsilon);
        return new Point2D(position.getX() + this.lastXOffset, position.getY() + this.lastYOffset);
    }

    // $FF: renamed from: d () double
    public double getCircumcircleRadius() {
        return this.halfLength;
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
        return StringUtil.toString(this, false, "length");
    }

    // $FF: renamed from: b (double, double) void
    private void updateLastOffsets(double angle, double epsilon) {
        if(this.lastXOffset == null || this.lastYOffset == null || angle != this.lastAngle || epsilon != this.lastEpsilon) {
            if(!Double.isNaN(angle) && !Double.isInfinite(angle)) {
                if(!Double.isNaN(epsilon) && !Double.isInfinite(epsilon) && epsilon >= 1.0E-100D && epsilon <= 1.0D) {
                    this.lastAngle = angle;
                    this.lastEpsilon = epsilon;
                    if(Math.abs(this.length) < epsilon) {
                        this.lastXOffset = 0.0D;
                        this.lastYOffset = 0.0D;
                    } else {
                        if(Math.abs(1.5707963267948966D - Math.abs(angle)) < epsilon) {
                            this.lastXOffset = 0.0D;
                        } else {
                            this.lastXOffset = normalizeSinCos(Math.cos(angle), epsilon) * this.halfLength;
                        }

                        if(Math.abs(3.141592653589793D - Math.abs(angle)) >= epsilon && Math.abs(angle) >= epsilon) {
                            this.lastYOffset = normalizeSinCos(Math.sin(angle), epsilon) * this.halfLength;
                        } else {
                            this.lastYOffset = 0.0D;
                        }

                    }
                } else {
                    throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
                }
            } else {
                throw new IllegalArgumentException("Argument \'angle\' is not a finite number.");
            }
        }
    }
}
