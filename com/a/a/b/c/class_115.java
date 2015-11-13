package com.a.a.b.c;

import com.a.a.b.c.class_113;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.e
public class class_115 extends class_113 {
    // $FF: renamed from: a double
    private final double field_469;
    // $FF: renamed from: b double
    private final double field_470;
    // $FF: renamed from: c double
    private final double field_471;
    // $FF: renamed from: d double
    private final double field_472;
    // $FF: renamed from: e double
    private final double field_473;
    // $FF: renamed from: f double
    private final double field_474;

    public class_115(double var1, double var3) {
        super(class_119.field_487);
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 > 0.0D) {
            if(!Double.isNaN(var3) && !Double.isInfinite(var3) && var3 > 0.0D) {
                this.field_469 = var1;
                this.field_470 = var3;
                this.field_471 = var1 / 2.0D;
                this.field_472 = var3 / 2.0D;
                this.field_473 = Math.hypot(var1, var3) / 2.0D;
                this.field_474 = Math.sumSqr(var1, var3) / 12.0D;
            } else {
                throw new IllegalArgumentException(String.format("Argument \'height\' should be positive finite number but got %s.", new Object[]{Double.valueOf(var3)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'width\' should be positive finite number but got %s.", new Object[]{Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: a () double
    public double method_772() {
        return this.field_469;
    }

    // $FF: renamed from: b () double
    public double method_773() {
        return this.field_470;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D[]
    public Point2D[] method_774(Point2D var1, double var2, double var4) {
        if(!Double.isNaN(var2) && !Double.isInfinite(var2)) {
            if(!Double.isNaN(var4) && !Double.isInfinite(var4) && var4 >= 1.0E-100D && var4 <= 1.0D) {
                double var6 = method_770(Math.sin(var2), var4);
                double var8 = method_770(Math.cos(var2), var4);
                double var10 = var8 * this.field_471;
                double var12 = var6 * this.field_471;
                double var14 = var6 * this.field_472;
                double var16 = -var8 * this.field_472;
                return new Point2D[]{new Point2D(var1.getX() - var10 + var14, var1.getY() - var12 + var16), new Point2D(var1.getX() + var10 + var14, var1.getY() + var12 + var16), new Point2D(var1.getX() + var10 - var14, var1.getY() + var12 - var16), new Point2D(var1.getX() - var10 - var14, var1.getY() - var12 - var16)};
            } else {
                throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
            }
        } else {
            throw new IllegalArgumentException("Argument \'angle\' is not a finite number.");
        }
    }

    // $FF: renamed from: d () double
    public double method_765() {
        return this.field_473;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_766(Point2D var1, double var2) {
        return var1;
    }

    // $FF: renamed from: a (double) double
    public double method_768(double var1) {
        return var1 * this.field_474;
    }

    public String toString() {
        return StringUtil.toString(this, false, "width", "height");
    }
}
