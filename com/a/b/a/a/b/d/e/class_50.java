package com.a.b.a.a.b.d.e;

import com.a.b.class_58;
import com.a.b.a.a.b.class_171;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.c.ProjectileType;
import com.a.c.a.CircularPhysicalForm;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.d.e.b
public class class_50 extends class_48 {
    public class_50(class_43 var1, class_171 var2, int var3, Point2D var4, double var5) {
        super(new CircularPhysicalForm(70.0D), var1, var2, ProjectileType.TIRE, var3, var4, (new Vector2D(60.0D, 0.0D)).rotate(var5), var5, 1000.0D);
    }

    // $FF: renamed from: a (com.a.b.f, int) double
    public double method_358(class_58 var1, int var2) {
        Vector2D var3 = var1.method_362().method_279().getVelocity();
        Vector2D var4 = var1.method_363().method_279().getVelocity();
        double var5 = var1.method_365().copyNegate().dotProduct(var3);
        double var7 = var1.method_365().dotProduct(var4);
        return Math.max(var5 + var7, 0.0D) / 60.0D * 0.25D;
    }
}
