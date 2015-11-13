package com.a.b.a.a.b.e;

import com.a.b.a.a.b.class_171;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.Direction;
import com.a.c.a.class_125;
import com.a.c.a.class_128;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import com.google.common.base.Preconditions;

// $FF: renamed from: com.a.b.a.a.b.e.b
public final class class_79 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, double, com.a.b.a.a.b.n) com.a.b.a.a.c.c
    public static Car method_476(class_43 var0, double var1, class_171 var3) {
        class_125 var4 = var0.method_279().method_902();
        if(!(var4 instanceof class_128)) {
            throw new IllegalArgumentException("Unsupported car form: " + var4 + '.');
        } else {
            class_128 var5 = (class_128)var4;
            IntPair var6 = var0.method_312();
            Preconditions.checkNotNull(var6.getFirst());
            Preconditions.checkNotNull(var6.getSecond());
            return new Car(var0.method_278(), var0.method_279().method_900(), var0.method_279().method_870(),
                    var0.method_279().method_872(), var0.method_279().method_876().getX() * var1,
                    var0.method_279().method_876().getY() * var1, var0.method_279().method_874(),
                    var0.method_279().method_880() * var1, var5.method_827(), var5.method_828(),
                    var0.method_297().method_917(), var0.method_298(),
                    var0.method_297().equals(var3), var0.method_299(),
                    var0.method_316(), var0.method_318(), var0.method_320(),
                    var0.method_322(), var0.method_325(), var0.method_328(),
                    var0.method_331(), var0.method_334(), var0.method_300(),
                    var0.method_304(), var0.method_307(),
                    ((Integer)var6.getFirst()).intValue(),
                    ((Integer)var6.getSecond()).intValue(),
                    var0.method_345());
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.e.i$a, int, int, int, int) com.codeforces.commons.geometry.Point2D
    public static Point2D method_477(class_86.class_206 var0, int var1, int var2, int var3, int var4) {
        method_484(var1, var2, var3, var4);
        Direction var5 = var0.method_415();
        IntPair var6 = var0.method_414()[0];
        double var7 = 16.0D;
        double var9 = 80.0D + var7 + 70.0D;
        double var11 = (140.0D + var7) * (double)(var4 * var2 + var1);
        Preconditions.checkNotNull(var6.getFirst());
        Preconditions.checkNotNull(var6.getSecond());
        switch(var5.ordinal()) {
        case 1:
            return new Point2D(800.0D * ((double) (Integer) var6.getFirst() + 0.5D), 800.0D * (double)((Integer) var6.getSecond() + 1) - var9 - var11);
        case 2:
            return new Point2D(800.0D * ((double) (Integer) var6.getFirst() + 0.5D), 800.0D * (double) (Integer) var6.getSecond() + var9 + var11);
        case 3:
            return new Point2D(800.0D * (double) (Integer) var6.getFirst() + var9 + var11, 800.0D * ((double) (Integer) var6.getSecond() + 0.5D));
        case 4:
            return new Point2D(800.0D * (double)((Integer) var6.getFirst() + 1) - var9 - var11, 800.0D * ((double) (Integer) var6.getSecond() + 0.5D));
        default:
            throw new IllegalArgumentException("Unsupported starting direction: " + var0.method_415() + '.');
        }
    }

    // $FF: renamed from: b (com.a.b.a.a.b.e.i$a, int, int, int, int) double
    public static double method_478(class_86.class_206 var0, int var1, int var2, int var3, int var4) {
        method_484(var1, var2, var3, var4);
        switch(var0.method_415().ordinal()) {
        case 1:
            return 3.141592653589793D;
        case 2:
            return 0.0D;
        case 3:
            return -1.5707963267948966D;
        case 4:
            return 1.5707963267948966D;
        default:
            throw new IllegalArgumentException("Unsupported starting direction: " + var0.method_415() + '.');
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, com.a.b.a.a.b.n, double) void
    public static void method_479(class_43 var0, class_171 var1, double var2) {
        method_480(var0, var1, var2, 1.0D);
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, com.a.b.a.a.b.n, double, double) void
    public static void method_480(class_43 var0, class_171 var1, double var2, double var4) {
        if(!method_481(var0) && !var0.method_345() && var2 > 0.0D) {
            byte var6 = 0;
            var2 = Math.min(var0.method_300(), var2);
            int var7 = (int)((double)var6 + var2 * 100.0D);
            var0.method_301(var0.method_300() - var2);
            if(method_481(var0)) {
                var0.method_301(0.0D);
                var0.method_305(0.0D, false);
                var0.method_332(0);
                var0.method_338(0);
                var0.method_279().method_879(new Vector2D(0.0D, 0.0D));
                var0.method_279().method_883(0.0D);
                var7 += 100;
            } else {
                var0.method_338(var0.method_337() + NumberUtil.toInt(var2 * 300.0D * var4));
            }

            if(var1 != null && var1.method_917() != var0.method_297().method_917()) {
                var1.method_929(var7);
            }

        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b) boolean
    public static boolean method_481(class_43 var0) {
        return method_483(var0.method_300());
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c) boolean
    public static boolean method_482(Car var0) {
        return method_483(var0.getDurability());
    }

    // $FF: renamed from: a (double) boolean
    public static boolean method_483(double var0) {
        return var0 <= 1.0E-7D;
    }

    // $FF: renamed from: a (int, int, int, int) void
    private static void method_484(int var0, int var1, int var2, int var3) {
        if(var1 != 2 && var1 != 4) {
            throw new IllegalArgumentException(String.format("Argument \'teamCount\' should be either 2 or 4, but got %d.", var1));
        } else if(var0 >= 0 && var0 < var1) {
            if(var2 >= 1 && var2 <= 2) {
                if(var1 * var2 != 4) {
                    throw new IllegalArgumentException(String.format("Expected exactly 4 cars on the track, but got %d.", var1 * var2));
                } else if(var3 < 0 || var3 >= var2) {
                    throw new IllegalArgumentException(String.format("Argument \'carIndex\' should be non-negative and less than \'teamSize\', but got %d.", var3));
                }
            } else {
                throw new IllegalArgumentException(String.format("Argument \'teamSize\' should be in range of 1 to 2, but got %d.", var2));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'teamIndex\' should be non-negative and less than \'teamCount\', but got %d.", var0));
        }
    }
}
