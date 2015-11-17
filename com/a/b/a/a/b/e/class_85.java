package com.a.b.a.a.b.e;

import com.a.a.a.a.class_122;
import com.a.c.a.PhysicalForm;
import com.a.c.a.RectangularPhysicalForm;
import com.a.c.a.CircularPhysicalForm;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.e.h
public final class class_85 {
    // $FF: renamed from: a (com.a.c.a.c) double
    public static double method_500(PhysicalForm var0) {
        if(var0 instanceof RectangularPhysicalForm) {
            RectangularPhysicalForm var1 = (RectangularPhysicalForm)var0;
            return 0.5D * Math.hypot(var1.getWidth(), var1.getHeight());
        } else if(var0 instanceof CircularPhysicalForm) {
            return ((CircularPhysicalForm)var0).getRadius();
        } else {
            throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Vector2D, double) com.codeforces.commons.geometry.Point2D[]
    public static Point2D[] method_501(Point2D var0, Vector2D var1, double var2) {
        return class_122.method_798(var0, var1, var2);
    }
}
