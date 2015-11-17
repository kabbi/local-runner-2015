package com.a.a.b.c;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.e
public class RectangularForm extends Form {
    // $FF: renamed from: a double
    private final double width;
    // $FF: renamed from: b double
    private final double height;
    // $FF: renamed from: c double
    private final double halfWidth;
    // $FF: renamed from: d double
    private final double halfHeight;
    // $FF: renamed from: e double
    private final double circumcircleRadius;
    // $FF: renamed from: f double
    private final double angularMassFactor;

    public RectangularForm(double width, double height) {
        super(Shape.RECTANGLE);
        if(!Double.isNaN(width) && !Double.isInfinite(width) && width > 0.0D) {
            if(!Double.isNaN(height) && !Double.isInfinite(height) && height > 0.0D) {
                this.width = width;
                this.height = height;
                this.halfWidth = width / 2.0D;
                this.halfHeight = height / 2.0D;
                this.circumcircleRadius = Math.hypot(width, height) / 2.0D;
                this.angularMassFactor = Math.sumSqr(width, height) / 12.0D;
            } else {
                throw new IllegalArgumentException(String.format("Argument \'height\' should be positive finite number but got %s.", new Object[]{Double.valueOf(height)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'width\' should be positive finite number but got %s.", new Object[]{Double.valueOf(width)}));
        }
    }

    // $FF: renamed from: a () double
    public double getWidth() {
        return this.width;
    }

    // $FF: renamed from: b () double
    public double getHeight() {
        return this.height;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D[]
    public Point2D[] getPoints(Point2D position, double angle, double epsilon) {
        if(!Double.isNaN(angle) && !Double.isInfinite(angle)) {
            if(!Double.isNaN(epsilon) && !Double.isInfinite(epsilon) && epsilon >= 1.0E-100D && epsilon <= 1.0D) {
                double sin = normalizeSinCos(Math.sin(angle), epsilon);
                double cos = normalizeSinCos(Math.cos(angle), epsilon);

                double lengthwiseXOffset = cos * this.halfWidth;
                double lengthwiseYOffset = sin * this.halfWidth;

                double crosswiseXOffset = sin * this.halfHeight;
                double crosswiseYOffset = -cos * this.halfHeight;

                return new Point2D[]{new Point2D(position.getX() - lengthwiseXOffset + crosswiseXOffset, position.getY() - lengthwiseYOffset + crosswiseYOffset), new Point2D(position.getX() + lengthwiseXOffset + crosswiseXOffset, position.getY() + lengthwiseYOffset + crosswiseYOffset), new Point2D(position.getX() + lengthwiseXOffset - crosswiseXOffset, position.getY() + lengthwiseYOffset - crosswiseYOffset), new Point2D(position.getX() - lengthwiseXOffset - crosswiseXOffset, position.getY() - lengthwiseYOffset - crosswiseYOffset)};
            } else {
                throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
            }
        } else {
            throw new IllegalArgumentException("Argument \'angle\' is not a finite number.");
        }
    }

    // $FF: renamed from: d () double
    public double getCircumcircleRadius() {
        return this.circumcircleRadius;
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
        return StringUtil.toString(this, false, "width", "height");
    }
}
