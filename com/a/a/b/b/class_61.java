package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_114;
import com.a.a.b.c.class_117;
import com.a.a.b.c.class_119;
import com.a.a.b.f.class_183;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.b.b
public class class_61 extends class_59 {
    public class_61(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_489 && var2.method_668().method_764() == class_119.field_486;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_117 var3 = (class_117)var1.method_668();
        class_114 var4 = (class_114)var2.method_668();
        double var5 = var3.method_776();
        double var7 = var4.method_771();
        double var9 = var1.method_693().getDistanceTo(var2.method_693());
        if(var9 > var5 + var7) {
            return null;
        } else if(var9 < Math.abs(var5 - var7)) {
            return null;
        } else {
            var1.method_718();
            var2.method_718();
            double var11 = var1.method_707() + var3.method_777();
            double var13 = var11 + var3.method_778();
            class_71 var15 = this.method_378(var1, var2, var5, var7, var9, var11, var13);
            if(var15 != null) {
                return var15;
            } else if(var9 < this.field_212) {
                return this.method_379(var2, var1, var3, var5, var11, var13, var7);
            } else {
                double var16 = Math.sqrt((var9 + var5 + var7) * (var9 + var5 - var7) * (var9 - var5 + var7) * (-var9 + var5 + var7)) / 4.0D;
                double var18 = var1.method_693().getSquaredDistanceTo(var2.method_693());
                double var20 = Math.sqr(var5) - Math.sqr(var7);
                double var22 = (var1.method_695() + var2.method_695()) / 2.0D + (var2.method_695() - var1.method_695()) * var20 / (2.0D * var18);
                double var24 = (var1.method_697() + var2.method_697()) / 2.0D + (var2.method_697() - var1.method_697()) * var20 / (2.0D * var18);
                double var26 = 2.0D * (var1.method_697() - var2.method_697()) * var16 / var18;
                double var28 = 2.0D * (var1.method_695() - var2.method_695()) * var16 / var18;
                Point2D var30 = new Point2D(var22, var24);
                if(Math.abs(var26) < this.field_212 && Math.abs(var28) < this.field_212) {
                    double var37 = (new Vector2D(var1.method_693(), var30)).getAngle();
                    if(var37 < var11) {
                        var37 += 6.283185307179586D;
                    }

                    if(var37 >= var11 && var37 <= var13) {
                        return new class_71(var1, var2, var30, (new Vector2D(var2.method_693(), var30)).normalize(), var7 - var2.method_715(var30), this.field_212);
                    }
                } else {
                    Point2D var31 = var30.copy().add(var26, -var28);
                    Point2D var32 = var30.copy().add(-var26, var28);
                    double var33 = (new Vector2D(var1.method_693(), var31)).getAngle();
                    if(var33 < var11) {
                        var33 += 6.283185307179586D;
                    }

                    double var35 = (new Vector2D(var1.method_693(), var32)).getAngle();
                    if(var35 < var11) {
                        var35 += 6.283185307179586D;
                    }

                    if(var33 >= var11 && var33 <= var13 && var35 >= var11 && var35 <= var13) {
                        if(var9 > var5 - this.field_212) {
                            return new class_71(var1, var2, var30, (new Vector2D(var2.method_693(), var1.method_693())).normalize(), var5 + var7 - var9, this.field_212);
                        }

                        return new class_71(var1, var2, var30, (new Vector2D(var1.method_693(), var2.method_693())).normalize(), var9 + var7 - var5, this.field_212);
                    }
                }

                return null;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, double, double, double, double, double) com.a.a.b.b.f
    private class_71 method_378(class_106 var1, class_106 var2, double var3, double var5, double var7, double var9, double var11) {
        Point2D var13 = var1.method_693().copy().add((new Vector2D(var3, 0.0D)).setAngle(var9));
        Point2D var14 = var1.method_693().copy().add((new Vector2D(var3, 0.0D)).setAngle(var11));
        double var15 = var2.method_715(var13);
        double var17 = var2.method_715(var14);
        if(var15 <= var5 && var17 <= var5) {
            Point2D var19 = new Point2D((var13.getX() + var14.getX()) / 2.0D, (var13.getY() + var14.getY()) / 2.0D);
            Vector2D var20;
            Line2D var21;
            if(var2.method_715(var19) >= this.field_212) {
                var20 = (new Vector2D(var2.method_693(), var19)).normalize();
                var21 = Line2D.getLineByTwoPoints(var2.method_693(), var19);
            } else {
                var20 = (new Vector2D(var2.method_693(), var1.method_693())).normalize();
                var21 = Line2D.getLineByTwoPoints(var2.method_693(), var1.method_693());
            }

            Point2D var22 = var21.getProjectionOf(var13, this.field_212);
            double var23 = var21.getDistanceFrom(var13);
            double var25 = Math.sqrt(Math.sqr(var5) - Math.sqr(var23)) - var2.method_715(var22);
            Point2D var27 = var21.getProjectionOf(var14, this.field_212);
            double var28 = var21.getDistanceFrom(var14);
            double var30 = Math.sqrt(Math.sqr(var5) - Math.sqr(var28)) - var2.method_715(var27);
            return new class_71(var1, var2, var19, var20, Math.max(var25, var30), this.field_212);
        } else {
            return var15 <= var5?(var15 >= this.field_212?new class_71(var1, var2, var13, (new Vector2D(var2.method_693(), var13)).normalize(), var5 - var15, this.field_212):new class_71(var1, var2, var13, (new Vector2D(var2.method_693(), var1.method_693())).normalize(), var3 + var5 - var7, this.field_212)):(var17 <= var5?(var17 >= this.field_212?new class_71(var1, var2, var14, (new Vector2D(var2.method_693(), var14)).normalize(), var5 - var17, this.field_212):new class_71(var1, var2, var14, (new Vector2D(var2.method_693(), var1.method_693())).normalize(), var3 + var5 - var7, this.field_212)):null);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.a.a.b.c.a, double, double, double, double) com.a.a.b.b.f
    private class_71 method_379(class_106 var1, class_106 var2, class_117 var3, double var4, double var6, double var8, double var10) {
        if(var10 < var4) {
            return null;
        } else {
            Vector2D var12 = var1.method_699().copy().subtract(var2.method_699());
            Vector2D var13;
            if(var12.getLength() >= this.field_212 && class_183.method_986(var12.getAngle(), var6, var8)) {
                var13 = var12.normalize();
            } else if(var1.method_699().getLength() >= this.field_212 && class_183.method_986(var1.method_699().getAngle(), var6, var8)) {
                var13 = var1.method_699().copy().normalize();
            } else {
                var13 = (new Vector2D(1.0D, 0.0D)).setAngle(var2.method_707() + var3.method_777() + var3.method_778() / 2.0D);
            }

            return new class_71(var2, var1, var1.method_693().copy(), var13, var10 - var4, this.field_212);
        }
    }
}
