package com.a.b.a.a.b.e;

import com.a.a.a.a.class_122;
import com.a.c.a.class_125;
import com.a.c.a.class_128;
import com.a.c.a.class_129;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.e.h
public final class class_85 {
    // $FF: renamed from: a (com.a.c.a.c) double
    public static double method_500(class_125 var0) {
        if(var0 instanceof class_128) {
            class_128 var1 = (class_128)var0;
            return 0.5D * Math.hypot(var1.method_827(), var1.method_828());
        } else if(var0 instanceof class_129) {
            return ((class_129)var0).method_829();
        } else {
            throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Vector2D, double) com.codeforces.commons.geometry.Point2D[]
    public static Point2D[] method_501(Point2D var0, Vector2D var1, double var2) {
        return class_122.method_798(var0, var1, var2);
    }
}
