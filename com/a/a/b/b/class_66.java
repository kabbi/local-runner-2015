package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_115;
import com.a.a.b.c.class_118;
import com.a.a.b.c.class_119;
import com.a.a.b.f.class_183;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.a.a.b.b.j
public class class_66 extends class_59 {
    public class_66(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_488 && var2.method_668().method_764() == class_119.field_487;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_118 var3 = (class_118)var1.method_668();
        class_115 var4 = (class_115)var2.method_668();
        Point2D var5 = var3.method_779(var1.method_693(), var1.method_707(), this.field_212);
        Point2D var6 = var3.method_780(var1.method_693(), var1.method_707(), this.field_212);
        Line2D var7 = Line2D.getLineByTwoPoints(var5, var6);
        if(var7.getDistanceFrom(var2.method_693()) > var4.method_765()) {
            return null;
        } else {
            Point2D[] var8 = var4.method_774(var2.method_693(), var2.method_707(), this.field_212);
            int var9 = var8.length;
            Line2D var10 = null;
            ArrayList var11 = new ArrayList(var9);
            int var12 = 0;

            double var18;
            double var20;
            double var22;
            double var24;
            for(int var13 = 0; var13 < var9; ++var13) {
                Point2D var14 = var8[var13];
                Point2D var15 = var8[var13 == var9 - 1?0:var13 + 1];
                Line2D var16 = Line2D.getLineByTwoPoints(var14, var15);
                Point2D var17 = var7.getIntersectionPoint(var16, this.field_212);
                if(var17 != null) {
                    var18 = Math.max(Math.min(var5.getX(), var6.getX()), Math.min(var14.getX(), var15.getX()));
                    var20 = Math.max(Math.min(var5.getY(), var6.getY()), Math.min(var14.getY(), var15.getY()));
                    var22 = Math.min(Math.max(var5.getX(), var6.getX()), Math.max(var14.getX(), var15.getX()));
                    var24 = Math.min(Math.max(var5.getY(), var6.getY()), Math.max(var14.getY(), var15.getY()));
                    if(var17.getX() > var18 - this.field_212 && var17.getX() < var22 + this.field_212 && var17.getY() > var20 - this.field_212 && var17.getY() < var24 + this.field_212) {
                        var10 = var16;
                        boolean var26 = false;
                        Iterator var27 = var11.iterator();

                        while(var27.hasNext()) {
                            Point2D var28 = (Point2D)var27.next();
                            if(var28.nearlyEquals(var17, this.field_212)) {
                                var26 = true;
                                break;
                            }
                        }

                        if(!var26) {
                            var11.add(var17);
                        }

                        ++var12;
                    }
                }
            }

            // FIXME
            if(var12 != 1 /*|| !var3.f()*/ || class_183.method_987(var5, var8, this.field_212) && class_183.method_987(var6, var8, this.field_212)) {
                Point2D var30 = var8[0];
                double var32 = var7.getSignedDistanceFrom(var30);
                Point2D var34 = var30;
                double var36 = var32;

                for(int var19 = 1; var19 < var9; ++var19) {
                    Point2D var38 = var8[var19];
                    double var21 = var7.getSignedDistanceFrom(var38);
                    if(var21 < var32) {
                        var32 = var21;
                        var30 = var38;
                    }

                    if(var21 > var36) {
                        var36 = var21;
                        var34 = var38;
                    }
                }

                if((var32 >= 0.0D || var36 >= 0.0D) && (var32 <= 0.0D || var36 <= 0.0D)) {
                    if(var11.isEmpty()) {
                        return null;
                    } else {
                        Vector2D var37;
                        if(var7.getSignedDistanceFrom(var2.method_693()) > 0.0D) {
                            var37 = var7.getParallelLine(var30).getUnitNormalFrom(var34);
                            var20 = Math.abs(var32);
                        } else {
                            var37 = var7.getParallelLine(var34).getUnitNormalFrom(var30);
                            var20 = var36;
                        }

                        var22 = 0.0D;
                        var24 = 0.0D;

                        Point2D var40;
                        for(Iterator var39 = var11.iterator(); var39.hasNext(); var24 += var40.getY() / (double)var11.size()) {
                            var40 = (Point2D)var39.next();
                            var22 += var40.getX() / (double)var11.size();
                        }

                        return new class_71(var1, var2, new Point2D(var22, var24), var37, var20, this.field_212);
                    }
                } else {
                    return null;
                }
            } else {
                Vector2D var29 = (new Vector2D(var2.method_693(), var10.getProjectionOf(var2.method_693()))).normalize();
                Line2D var31 = var10.getParallelLine(var5);
                double var33 = var31.getDistanceFrom(var2.method_693());
                Line2D var35 = var10.getParallelLine(var6);
                var18 = var35.getDistanceFrom(var2.method_693());
                var20 = (var33 < var18?var31:var35).getDistanceFrom(var10, this.field_212);
                return new class_71(var1, var2, (Point2D)var11.get(0), var29, var20, this.field_212);
            }
        }
    }
}
