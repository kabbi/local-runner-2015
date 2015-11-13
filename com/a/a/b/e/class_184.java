package com.a.a.b.e;

import com.a.a.b.class_106;
import com.a.a.b.e.class_12;

// $FF: renamed from: com.a.a.b.e.b
public class class_184 implements class_12 {
    // $FF: renamed from: a double
    private final double field_787;

    public class_184(double var1) {
        if(var1 < 0.0D) {
            throw new IllegalArgumentException("Argument \'movementFrictionFactor\' should be zero or positive.");
        } else {
            this.field_787 = var1;
        }
    }

    // $FF: renamed from: a () double
    public double method_988() {
        return this.field_787;
    }

    // $FF: renamed from: a (com.a.a.b.a, double) void
    public void method_54(class_106 var1, double var2) {
        if(this.field_787 > 0.0D) {
            double var4 = var1.method_699().getLength();
            if(var4 > 0.0D) {
                double var6 = this.field_787 * var2;
                if(var6 >= var4) {
                    var1.method_701(0.0D, 0.0D);
                } else if(var6 > 0.0D) {
                    var1.method_699().multiply(1.0D - var6 / var4);
                }

            }
        }
    }
}
