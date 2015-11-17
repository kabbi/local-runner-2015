package com.a.a.a.a;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.a.a.b
public class class_122 {
    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Vector2D, double) com.codeforces.commons.geometry.Point2D[]
    public static Point2D[] method_798(Point2D var0, Vector2D var1, double var2) {
        double var4 = Math.sin(var2);
        double var6 = Math.cos(var2);
        double var8 = var1.getX() * 0.5D;
        double var10 = var1.getY() * 0.5D;
        double var12 = var6 * var8;
        double var14 = var4 * var8;
        double var16 = var4 * var10;
        double var18 = -var6 * var10;
        return new Point2D[]{
                new Point2D(var0.getX() - var12 + var16, var0.getY() - var14 + var18),
                new Point2D(var0.getX() + var12 + var16, var0.getY() + var14 + var18),
                new Point2D(var0.getX() + var12 - var16, var0.getY() + var14 - var18),
                new Point2D(var0.getX() - var12 - var16, var0.getY() - var14 - var18)
        };
    }
}
