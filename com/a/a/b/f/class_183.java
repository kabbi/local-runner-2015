package com.a.a.b.f;

import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.f.a
public final class class_183 {
    // $FF: renamed from: a (double) double
    public static double method_985(double var0) {
        while(var0 > 3.141592653589793D) {
            var0 -= 6.283185307179586D;
        }

        while(var0 < -3.141592653589793D) {
            var0 += 6.283185307179586D;
        }

        return var0;
    }

    // $FF: renamed from: a (double, double, double) boolean
    public static boolean method_986(double var0, double var2, double var4) {
        while(var4 < var2) {
            var4 += 6.283185307179586D;
        }

        while(var4 - 6.283185307179586D > var2) {
            var4 -= 6.283185307179586D;
        }

        while(var0 < var2) {
            var0 += 6.283185307179586D;
        }

        while(var0 - 6.283185307179586D > var2) {
            var0 -= 6.283185307179586D;
        }

        return var0 >= var2 && var0 <= var4;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D[], double) boolean
    public static boolean method_987(Point2D var0, Point2D[] var1, double var2) {
        int var4 = 0;

        for(int var5 = var1.length; var4 < var5; ++var4) {
            Point2D var6 = var1[var4];
            Point2D var7 = var1[var4 == var5 - 1?0:var4 + 1];
            Line2D var8 = Line2D.getLineByTwoPoints(var6, var7);
            if(var8.getSignedDistanceFrom(var0) >= var2) {
                return true;
            }
        }

        return false;
    }
}
