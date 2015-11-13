package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_64;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_114;
import com.a.a.b.c.class_115;
import com.a.a.b.c.class_119;
import com.a.a.b.f.class_183;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.b.m
public class class_68 extends class_59 {
    public class_68(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_487 && var2.method_668().method_764() == class_119.field_486;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_115 var3 = (class_115)var1.method_668();
        class_114 var4 = (class_114)var2.method_668();
        Point2D[] var5 = var3.method_774(var1.method_693(), var1.method_707(), this.field_212);
        int var6 = var5.length;
        if(!class_183.method_987(var2.method_693(), var5, this.field_212)) {
            double var7 = Double.POSITIVE_INFINITY;
            Line2D var9 = null;

            for(int var10 = 0; var10 < var6; ++var10) {
                Point2D var11 = var5[var10];
                Point2D var12 = var5[var10 == var6 - 1?0:var10 + 1];
                Line2D var13 = Line2D.getLineByTwoPoints(var11, var12);
                double var14 = var13.getDistanceFrom(var2.method_693());
                if(var14 < var7) {
                    var7 = var14;
                    var9 = var13;
                }
            }

            if(var9 != null) {
                return new class_71(var1, var2, var2.method_693(), var9.getUnitNormal().negate(), var4.method_771() - var9.getSignedDistanceFrom(var2.method_693()), this.field_212);
            }
        }

        class_71 var16 = null;

        for(int var8 = 0; var8 < var6; ++var8) {
            Point2D var17 = var5[var8];
            Point2D var18 = var5[var8 == var6 - 1?0:var8 + 1];
            class_71 var19 = class_64.method_380(var1, var2, var17, var18, var4, this.field_212);
            if(var19 != null && (var16 == null || var19.method_390() > var16.method_390())) {
                var16 = var19;
            }
        }

        return var16;
    }
}
