package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_114;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b.c
public class class_62 extends class_59 {
    public class_62(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_486 && var2.method_668().method_764() == class_119.field_486;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_114 var3 = (class_114)var1.method_668();
        class_114 var4 = (class_114)var2.method_668();
        double var5 = var3.method_771();
        double var7 = var4.method_771();
        double var9 = var1.method_693().getDistanceTo(var2.method_693());
        if(var9 > var5 + var7) {
            return null;
        } else {
            Vector2D var11;
            Point2D var12;
            Vector2D var13;
            if(var9 >= this.field_212) {
                var13 = new Vector2D(var2.method_693(), var1.method_693());
                var11 = var13.copy().normalize();
                var12 = var2.method_693().copy().add(var13.copy().multiply(var7 / (var5 + var7)));
            } else {
                var13 = var2.method_699().copy().subtract(var1.method_699());
                if(var13.getLength() >= this.field_212) {
                    var11 = var13.normalize();
                } else if(var2.method_699().getLength() >= this.field_212) {
                    var11 = var2.method_699().copy().normalize();
                } else {
                    var11 = new Vector2D(1.0D, 0.0D);
                }

                var12 = var2.method_693().copy();
            }

            return new class_71(var1, var2, var12, var11, var5 + var7 - var9, this.field_212);
        }
    }
}
