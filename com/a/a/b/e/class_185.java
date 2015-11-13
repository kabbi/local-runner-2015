package com.a.a.b.e;

import com.a.a.b.class_106;
import com.a.a.b.e.class_12;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.e.a
public class class_185 implements class_12 {
    // $FF: renamed from: a double
    private final double field_788;
    // $FF: renamed from: b double
    private final double field_789;

    public class_185(double var1, double var3) {
        if(var1 < 0.0D) {
            throw new IllegalArgumentException("Argument \'lengthwiseMovementFrictionFactor\' should be zero or positive.");
        } else if(var3 < 0.0D) {
            throw new IllegalArgumentException("Argument \'crosswiseMovementFrictionFactor\' should be zero or positive.");
        } else {
            this.field_788 = var1;
            this.field_789 = var3;
        }
    }

    // $FF: renamed from: a () double
    public double method_989() {
        return this.field_788;
    }

    // $FF: renamed from: b () double
    public double method_990() {
        return this.field_789;
    }

    // $FF: renamed from: a (com.a.a.b.a, double) void
    public void method_54(class_106 var1, double var2) {
        double var4 = var1.method_699().getLength();
        if(var4 > 0.0D) {
            double var6 = this.field_788 * var2;
            double var8 = this.field_789 * var2;
            Vector2D var10 = (new Vector2D(1.0D, 0.0D)).rotate(var1.method_707());
            Vector2D var11 = (new Vector2D(0.0D, 1.0D)).rotate(var1.method_707());
            double var12 = var1.method_699().dotProduct(var10);
            if(var12 >= 0.0D) {
                var12 -= var6;
                if(var12 < 0.0D) {
                    var12 = 0.0D;
                }
            } else {
                var12 += var6;
                if(var12 > 0.0D) {
                    var12 = 0.0D;
                }
            }

            double var14 = var1.method_699().dotProduct(var11);
            if(var14 >= 0.0D) {
                var14 -= var8;
                if(var14 < 0.0D) {
                    var14 = 0.0D;
                }
            } else {
                var14 += var8;
                if(var14 > 0.0D) {
                    var14 = 0.0D;
                }
            }

            var1.method_700(var10.copy().multiply(var12).add(var11.copy().multiply(var14)));
        }
    }
}
