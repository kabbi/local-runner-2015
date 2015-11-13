package com.a.a.b.c;

import com.a.a.b.c.class_116;
import com.a.a.b.c.class_119;
import com.a.a.b.f.class_183;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.a
public class class_117 extends class_116 {
    // $FF: renamed from: a double
    private final double field_476;
    // $FF: renamed from: b double
    private final double field_477;
    // $FF: renamed from: c double
    private final double field_478;

    public class_117(double var1, double var3, double var5, boolean var7) {
        super(class_119.field_489, var7);
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 > 0.0D) {
            if(!Double.isNaN(var3) && !Double.isInfinite(var3)) {
                if(!Double.isNaN(var5) && !Double.isInfinite(var5) && var5 > 0.0D && var5 <= 6.283185307179586D) {
                    this.field_477 = class_183.method_985(var3);
                    this.field_476 = var1;
                    this.field_478 = var5;
                } else {
                    throw new IllegalArgumentException(String.format("Argument \'sector\' should be between 0.0 exclusive and 2 * PI inclusive but got %s.", new Object[]{Double.valueOf(var5)}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Argument \'angle\' should be a finite number but got %s.", new Object[]{Double.valueOf(var3)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'radius\' should be a positive finite number but got %s.", new Object[]{Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: a () double
    public double method_776() {
        return this.field_476;
    }

    // $FF: renamed from: b () double
    public double method_777() {
        return this.field_477;
    }

    // $FF: renamed from: c () double
    public double method_778() {
        return this.field_478;
    }

    // $FF: renamed from: d () double
    public double method_765() {
        return this.field_476;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_766(Point2D var1, double var2) {
        return var1;
    }

    // $FF: renamed from: a (double) double
    public double method_768(double var1) {
        if(Double.isInfinite(var1) && var1 != Double.NEGATIVE_INFINITY) {
            return var1;
        } else {
            throw new IllegalArgumentException("Arc form is only supported for static bodies.");
        }
    }

    public String toString() {
        return StringUtil.toString(this, false, "radius", "angle", "sector");
    }
}
