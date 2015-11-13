package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_114;
import com.a.a.b.c.class_118;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.b.h
public class class_64 extends class_59 {
    public class_64(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_488 && var2.method_668().method_764() == class_119.field_486;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_118 var3 = (class_118)var1.method_668();
        class_114 var4 = (class_114)var2.method_668();
        Point2D var5 = var3.method_779(var1.method_693(), var1.method_707(), this.field_212);
        Point2D var6 = var3.method_780(var1.method_693(), var1.method_707(), this.field_212);
        return method_380(var1, var2, var5, var6, var4, this.field_212);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.a.a.b.c.b, double) com.a.a.b.b.f
    static class_71 method_380(class_106 var0, class_106 var1, Point2D var2, Point2D var3, class_114 var4, double var5) {
        Line2D var7 = Line2D.getLineByTwoPoints(var2, var3);
        double var8 = var7.getDistanceFrom(var1.method_693());
        double var10 = var4.method_771();
        if(var8 > var10) {
            return null;
        } else {
            double var12 = Math.min(var2.getX(), var3.getX());
            double var14 = Math.min(var2.getY(), var3.getY());
            double var16 = Math.max(var2.getX(), var3.getX());
            double var18 = Math.max(var2.getY(), var3.getY());
            Point2D var20 = var7.getProjectionOf(var1.method_693());
            boolean var21 = var20.getX() > var12 - var5 && var20.getX() < var16 + var5 && var20.getY() > var14 - var5 && var20.getY() < var18 + var5;
            if(var21) {
                Vector2D var29;
                if(var8 >= var5) {
                    var29 = (new Vector2D(var1.method_693(), var20)).normalize();
                } else {
                    Vector2D var23 = var7.getUnitNormal();
                    Vector2D var30 = var1.method_699().copy().subtract(var0.method_699());
                    if(var30.getLength() >= var5) {
                        var29 = var30.dotProduct(var23) >= var5?var23:var23.negate();
                    } else if(var1.method_699().getLength() >= var5) {
                        var29 = var1.method_699().dotProduct(var23) >= var5?var23:var23.negate();
                    } else {
                        var29 = var23;
                    }
                }

                return new class_71(var0, var1, var20, var29, var10 - var8, var5);
            } else {
                double var22 = var1.method_715(var2);
                double var24 = var1.method_715(var3);
                Point2D var26;
                double var27;
                if(var22 < var24) {
                    var26 = var2;
                    var27 = var22;
                } else {
                    var26 = var3;
                    var27 = var24;
                }

                return var27 > var10?null:new class_71(var0, var1, var26, (new Vector2D(var1.method_693(), var26)).normalize(), var10 - var27, var5);
            }
        }
    }
}
