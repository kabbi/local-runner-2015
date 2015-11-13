package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_59;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_113;
import com.a.a.b.c.class_115;
import com.a.a.b.c.class_117;
import com.a.a.b.c.class_119;
import com.a.a.b.f.class_183;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.holder.Mutable;
import com.codeforces.commons.holder.SimpleMutable;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.SimplePair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.a.a.b.b.k
public class class_67 extends class_59 {
    public class_67(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean method_376(class_106 var1, class_106 var2) {
        return var1.method_668().method_764() == class_119.field_487 && var2.method_668().method_764() == class_119.field_489;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected class_71 method_377(class_106 var1, class_106 var2) {
        class_115 var3 = (class_115)var1.method_668();
        class_117 var4 = (class_117)var2.method_668();
        double var5 = var3.method_765();
        double var7 = var4.method_776();
        double var9 = var1.method_693().getDistanceTo(var2.method_693());
        if(var9 > var5 + var7) {
            return null;
        } else if(var9 < Math.abs(var5 - var7)) {
            return null;
        } else {
            Point2D[] var11 = var3.method_774(var1.method_693(), var1.method_707(), this.field_212);
            int var12 = var11.length;
            double var13 = var7 * var7;
            double var15 = var2.method_707() + var4.method_777();
            double var17 = var15 + var4.method_778();
            Point2D var19 = var2.method_693().copy().add((new Vector2D(var7, 0.0D)).setAngle(var15));
            Point2D var20 = var2.method_693().copy().add((new Vector2D(var7, 0.0D)).setAngle(var17));
            ArrayList var21 = new ArrayList();

            int var22;
            Line2D var25;
            double var26;
            double var28;
            for(var22 = 0; var22 < var12; ++var22) {
                Point2D var23 = var11[var22];
                Point2D var24 = var11[var22 == var12 - 1?0:var22 + 1];
                var25 = Line2D.getLineByTwoPoints(var23, var24);
                if(var25.getSignedDistanceFrom(var1.method_693()) > -this.field_212) {
                    throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{class_113.method_769(var1.method_668()), var1}));
                }

                var26 = var25.getSignedDistanceFrom(var2.method_693());
                if(var26 <= var7) {
                    var28 = Math.min(var23.getX(), var24.getX());
                    double var30 = Math.min(var23.getY(), var24.getY());
                    double var32 = Math.max(var23.getX(), var24.getX());
                    double var34 = Math.max(var23.getY(), var24.getY());
                    Point2D var36 = var25.getProjectionOf(var2.method_693());
                    double var37 = Math.sqrt(var13 - var26 * var26);
                    Vector2D var39 = (new Vector2D(var23, var24)).copy().setLength(var37);
                    Point2D var40 = var36.copy().add(var39);
                    if(this.method_383(var40, var28, var30, var32, var34, var2, var15, var17)) {
                        this.method_384(var40, var23, var24, var25, var21);
                    }

                    Point2D var41 = var36.copy().add(var39.copy().negate());
                    if(this.method_383(var41, var28, var30, var32, var34, var2, var15, var17)) {
                        this.method_384(var41, var23, var24, var25, var21);
                    }
                }
            }

            var22 = var21.size();
            if(var22 == 0) {
                return null;
                // FIXME
            } else if(var22 != 1 /*|| !var4.f()*/ || class_183.method_987(var19, var11, this.field_212) && class_183.method_987(var20, var11, this.field_212)) {
                Vector2D var43 = new Vector2D(((class_67.class_222)var21.get(0)).field_518, var2.method_693());
                Vector2D var45 = new Vector2D(((class_67.class_222)var21.get(0)).field_518, var1.method_693());
                Iterator var27;
                Iterator var29;
                SimpleMutable var46;
                SimpleMutable var47;
                class_67.class_222 var48;
                SimplePair var50;
                if(var9 > var7 - this.field_212 && var43.dotProduct(var45) < 0.0D) {
                    var46 = new SimpleMutable();
                    var47 = new SimpleMutable();
                    var27 = var21.iterator();

                    while(var27.hasNext()) {
                        var48 = (class_67.class_222)var27.next();
                        this.method_381(var2, var48.field_518, var46, var47);
                        var29 = var48.field_520.iterator();

                        while(var29.hasNext()) {
                            var50 = (SimplePair)var29.next();
                            this.method_381(var2, (Point2D)var50.getFirst(), var46, var47);
                            this.method_381(var2, (Point2D)var50.getSecond(), var46, var47);
                        }
                    }

                    return var46.get() == null?null:new class_71(var1, var2, (Point2D)var46.get(), (new Vector2D(var2.method_693(), (Point2D)var46.get())).normalize(), var7 - (Double) var47.get(), this.field_212);
                } else {
                    var46 = new SimpleMutable();
                    var47 = new SimpleMutable();
                    var27 = var21.iterator();

                    while(var27.hasNext()) {
                        var48 = (class_67.class_222)var27.next();
                        method_382(var2, var48.field_518, var46, var47, var15, var17);
                        var29 = var48.field_520.iterator();

                        while(var29.hasNext()) {
                            var50 = (SimplePair)var29.next();
                            method_382(var2, (Point2D)var50.getFirst(), var46, var47, var15, var17);
                            method_382(var2, (Point2D)var50.getSecond(), var46, var47, var15, var17);
                        }
                    }

                    return var46.get() == null?null:new class_71(var1, var2, (Point2D)var46.get(), (new Vector2D((Point2D)var46.get(), var2.method_693())).normalize(), (Double) var47.get() - var7, this.field_212);
                }
            } else {
                class_67.class_222 var42 = (class_67.class_222)var21.get(0);
                int var44 = var42.field_519.size();
                if(var44 != 1 && var44 != 2) {
                    throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{class_113.method_769(var1.method_668()), var1}));
                } else {
                    var25 = (Line2D)var42.field_519.get(0);
                    var26 = var25.getSignedDistanceFrom(var19);
                    var28 = var25.getSignedDistanceFrom(var20);

                    for(int var49 = 0; var49 < var12; ++var49) {
                        Point2D var31 = var11[var49];
                        Point2D var51 = var11[var49 == var12 - 1?0:var49 + 1];
                        Line2D var33 = Line2D.getLineByTwoPoints(var31, var51);
                        if(var33.getSignedDistanceFrom(var19) >= this.field_212) {
                            return new class_71(var1, var2, var20, var25.getUnitNormal().negate(), -var28, this.field_212);
                        }

                        if(var33.getSignedDistanceFrom(var20) >= this.field_212) {
                            return new class_71(var1, var2, var19, var25.getUnitNormal().negate(), -var26, this.field_212);
                        }
                    }

                    if(var26 < var28) {
                        return new class_71(var1, var2, var19, var25.getUnitNormal().negate(), -var26, this.field_212);
                    } else {
                        return new class_71(var1, var2, var20, var25.getUnitNormal().negate(), -var28, this.field_212);
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.holder.Mutable, com.codeforces.commons.holder.Mutable) void
    private void method_381(class_106 var1, Point2D var2, Mutable var3, Mutable var4) {
        double var5 = var1.method_715(var2);
        if(var5 >= this.field_212 && (var3.get() == null || var5 < (Double) var4.get())) {
            var3.set(var2);
            var4.set(var5);
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.holder.Mutable, com.codeforces.commons.holder.Mutable, double, double) void
    private static void method_382(class_106 var0, Point2D var1, Mutable var2, Mutable var3, double var4, double var6) {
        double var8 = var0.method_715(var1);
        if(class_183.method_986((new Vector2D(var0.method_693(), var1)).getAngle(), var4, var6) && (var2.get() == null || var8 > (Double) var3.get())) {
            var2.set(var1);
            var3.set(var8);
        }

    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double, double, double, com.a.a.b.a, double, double) boolean
    private boolean method_383(Point2D var1, double var2, double var4, double var6, double var8, class_106 var10, double var11, double var13) {
        boolean var15 = var1.getX() > var2 - this.field_212 && var1.getX() < var6 + this.field_212 && var1.getY() > var4 - this.field_212 && var1.getY() < var8 + this.field_212;
        double var16 = (new Vector2D(var10.method_693(), var1)).getAngle();
        if(var16 < var11) {
            var16 += 6.283185307179586D;
        }

        boolean var18 = var16 >= var11 && var16 <= var13;
        return var15 && var18;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Line2D, java.util.List) void
    private void method_384(Point2D var1, Point2D var2, Point2D var3, Line2D var4, List var5) {
        boolean var6 = false;
        Iterator var7 = var5.iterator();

        while(var7.hasNext()) {
            class_67.class_222 var8 = (class_67.class_222)var7.next();
            if(var8.field_518.nearlyEquals(var1, this.field_212)) {
                var8.field_519.add(var4);
                var8.field_520.add(new SimplePair(var2, var3));
                var6 = true;
                break;
            }
        }

        if(!var6) {
            class_67.class_222 var9 = new class_67.class_222(var1, null);
            var9.field_519.add(var4);
            var9.field_520.add(new SimplePair(var2, var3));
            var5.add(var9);
        }

    }

    private static final class class_222 {
        // $FF: renamed from: a com.codeforces.commons.geometry.Point2D
        public final Point2D field_518;
        // $FF: renamed from: b java.util.List
        public final List field_519;
        // $FF: renamed from: c java.util.List
        public final List field_520;

        private class_222(Point2D var1) {
            this.field_519 = new ArrayList();
            this.field_520 = new ArrayList();
            this.field_518 = var1;
        }

        // $FF: synthetic method
        class_222(Point2D var1, Object var2) {
            this(var1);
        }
    }
}
