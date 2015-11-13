package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_113;
import com.a.a.b.c.class_115;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b.n
public class class_69 extends class_59 {
    public class_69(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_487 && var2.method_668().method_764() == class_119.field_487;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_115 var3 = (class_115)var1.method_668();
        class_115 var4 = (class_115)var2.method_668();
        Point2D[] var5 = var3.method_774(var1.method_693(), var1.method_707(), this.field_212);
        Point2D[] var6 = var4.method_774(var2.method_693(), var2.method_707(), this.field_212);
        class_71 var7 = this.method_385(var1, var2, var5, var6);
        if(var7 == null) {
            return null;
        } else {
            class_71 var8 = this.method_385(var2, var1, var6, var5);
            return var8 == null?null:(var8.method_390() < var7.method_390()?new class_71(var1, var2, var8.method_388(), var8.method_389().negate(), var8.method_390(), this.field_212):var7);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.codeforces.commons.geometry.Point2D[], com.codeforces.commons.geometry.Point2D[]) com.a.a.b.b.f
    private class_71 method_385(class_106 var1, class_106 var2, Point2D[] var3, Point2D[] var4) {
        int var5 = var3.length;
        int var6 = var4.length;
        double var7 = Double.POSITIVE_INFINITY;
        Point2D var9 = null;
        Vector2D var10 = null;

        for(int var11 = 0; var11 < var5; ++var11) {
            Point2D var12 = var3[var11];
            Point2D var13 = var3[var11 == var5 - 1?0:var11 + 1];
            Line2D var14 = Line2D.getLineByTwoPoints(var12, var13);
            if(var14.getSignedDistanceFrom(var1.method_693()) > -this.field_212) {
                throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{class_113.method_769(var1.method_668()), var1}));
            }

            double var15 = Double.POSITIVE_INFINITY;
            Point2D var17 = null;
            Vector2D var18 = null;

            for(int var19 = 0; var19 < var6; ++var19) {
                Point2D var20 = var4[var19];
                double var21 = var14.getSignedDistanceFrom(var20);
                if(var21 < var15) {
                    var15 = var21;
                    var17 = var20;
                    var18 = var14.getUnitNormalFrom(var1.method_693(), this.field_212).negate();
                }
            }

            if(var15 > 0.0D) {
                return null;
            }

            double var23 = -var15;
            if(var23 < var7) {
                var7 = var23;
                var9 = var17;
                var10 = var18;
            }
        }

        if(var9 != null && var10 != null) {
            return new class_71(var1, var2, var9, var10, var7, this.field_212);
        } else {
            return null;
        }
    }
}
