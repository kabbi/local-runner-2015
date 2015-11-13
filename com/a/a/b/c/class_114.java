package com.a.a.b.c;

import com.a.a.b.c.class_113;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.b
public class class_114 extends class_113 {
    // $FF: renamed from: a double
    private final double field_467;
    // $FF: renamed from: b double
    private final double field_468;

    public class_114(double var1) {
        super(class_119.field_486);
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 > 0.0D) {
            this.field_467 = var1;
            this.field_468 = var1 * var1 / 2.0D;
        } else {
            throw new IllegalArgumentException(String.format("Argument \'radius\' should be positive finite number but got %s.", new Object[]{Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: a () double
    public double method_771() {
        return this.field_467;
    }

    // $FF: renamed from: d () double
    public double method_765() {
        return this.field_467;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_766(Point2D var1, double var2) {
        return var1;
    }

    // $FF: renamed from: a (double) double
    public double method_768(double var1) {
        return var1 * this.field_468;
    }

    public String toString() {
        return StringUtil.toString(this, false, "radius");
    }
}
