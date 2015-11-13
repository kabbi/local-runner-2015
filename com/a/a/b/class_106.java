package com.a.a.b;

import com.a.a.b.class_105;
import com.a.a.b.c.class_113;
import com.a.a.b.e.class_12;
import com.a.a.b.e.class_184;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.text.StringUtil;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.a.b.a
public class class_106 {
    // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
    private static final AtomicLong field_395 = new AtomicLong();
    // $FF: renamed from: b long
    private final long field_396;
    // $FF: renamed from: c java.lang.String
    private String field_397;
    // $FF: renamed from: d com.a.a.b.c.c
    private class_113 field_398;
    // $FF: renamed from: e double
    private double field_399;
    // $FF: renamed from: f double
    private double field_400;
    // $FF: renamed from: g double
    private double field_401;
    // $FF: renamed from: h double
    private double field_402;
    // $FF: renamed from: i com.a.a.b.e.d
    private class_12 field_403;
    // $FF: renamed from: j double
    private double field_404;
    // $FF: renamed from: k double
    private double field_405;
    // $FF: renamed from: l double
    private double field_406;
    // $FF: renamed from: m com.a.a.b.b
    private final class_105 field_407;
    // $FF: renamed from: n com.a.a.b.b
    private class_105 field_408;
    // $FF: renamed from: o com.a.a.b.b
    private class_105 field_409;
    // $FF: renamed from: p double
    private double field_410;
    // $FF: renamed from: q double
    private double field_411;
    // $FF: renamed from: r java.lang.Double
    private Double field_412;
    // $FF: renamed from: s double
    private double field_413;
    // $FF: renamed from: t double
    private double field_414;
    // $FF: renamed from: u java.lang.Double
    private Double field_415;

    public class_106() {
        this.field_396 = field_395.incrementAndGet();
        this.field_403 = new class_184(0.0D);
        this.field_405 = 1.0D;
        this.field_407 = new class_105();
    }

    // $FF: renamed from: a () long
    public long method_665() {
        return this.field_396;
    }

    // $FF: renamed from: b () java.lang.String
    public String method_666() {
        return this.field_397;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_667(String var1) {
        this.field_397 = var1;
    }

    // $FF: renamed from: c () com.a.a.b.c.c
    public class_113 method_668() {
        return this.field_398;
    }

    // $FF: renamed from: a (com.a.a.b.c.c) void
    public void method_669(class_113 var1) {
        this.field_398 = var1;
    }

    // $FF: renamed from: d () double
    public double method_670() {
        return this.field_399;
    }

    // $FF: renamed from: a (double) void
    public void method_671(double var1) {
        if(!Double.isNaN(var1) && var1 != Double.NEGATIVE_INFINITY && var1 > 0.0D) {
            this.field_399 = var1;
            if(Double.isInfinite(var1)) {
                this.field_400 = 0.0D;
            } else {
                this.field_400 = 1.0D / var1;
            }

        } else {
            throw new IllegalArgumentException(this + ": argument \'mass\' should be positive.");
        }
    }

    // $FF: renamed from: e () boolean
    public boolean method_672() {
        return Double.isInfinite(this.field_399);
    }

    // $FF: renamed from: f () double
    public double method_673() {
        return this.field_400;
    }

    // $FF: renamed from: g () double
    public double method_674() {
        if(!Double.isNaN(this.field_399) && this.field_399 != Double.NEGATIVE_INFINITY && this.field_399 > 0.0D) {
            return Double.isInfinite(this.field_399)?Double.POSITIVE_INFINITY:this.field_398.method_768(this.field_399);
        } else {
            throw new IllegalStateException(this + ": field \'mass\' should be positive.");
        }
    }

    // $FF: renamed from: h () double
    public double method_675() {
        double var1 = this.method_674();
        return Double.isInfinite(var1)?0.0D:1.0D / var1;
    }

    // $FF: renamed from: i () double
    public double method_676() {
        return this.field_401;
    }

    // $FF: renamed from: b (double) void
    public void method_677(double var1) {
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 >= 0.0D && var1 <= 1.0D) {
            this.field_401 = var1;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'movementAirFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: j () double
    public double method_678() {
        return this.field_402;
    }

    // $FF: renamed from: c (double) void
    public void method_679(double var1) {
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 >= 0.0D && var1 <= 1.0D) {
            this.field_402 = var1;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'rotationAirFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: k () com.a.a.b.e.d
    public class_12 method_680() {
        return this.field_403;
    }

    // $FF: renamed from: a (com.a.a.b.e.d) void
    public void method_681(class_12 var1) {
        if(var1 == null) {
            throw new IllegalArgumentException(String.format("%s: argument \'movementFrictionProvider\' is null.", new Object[]{this}));
        } else {
            this.field_403 = var1;
        }
    }

    // $FF: renamed from: d (double) void
    public void method_682(double var1) {
        this.method_681(new class_184(var1));
    }

    // $FF: renamed from: e (double) void
    public void method_683(double var1) {
        this.field_403.method_54(this, var1);
    }

    // $FF: renamed from: l () double
    public double method_684() {
        return this.field_404;
    }

    // $FF: renamed from: f (double) void
    public void method_685(double var1) {
        if(!Double.isNaN(var1) && var1 >= 0.0D) {
            this.field_404 = var1;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'rotationFrictionFactor\' should be zero or positive but got %s.", new Object[]{this, Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: m () double
    public double method_686() {
        return this.field_405;
    }

    // $FF: renamed from: g (double) void
    public void method_687(double var1) {
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 >= 0.0D && var1 <= 1.0D) {
            this.field_405 = var1;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'momentumTransferFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: n () double
    public double method_688() {
        return this.field_406;
    }

    // $FF: renamed from: h (double) void
    public void method_689(double var1) {
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 >= 0.0D && var1 <= 1.0D) {
            this.field_406 = var1;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'surfaceFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: o () com.a.a.b.b
    public class_105 method_690() {
        return this.field_407;
    }

    // $FF: renamed from: p () void
    public void method_691() {
        this.field_408 = new class_105(this.field_407);
    }

    // $FF: renamed from: q () void
    public void method_692() {
        this.field_409 = new class_105(this.field_407);
    }

    // $FF: renamed from: r () com.codeforces.commons.geometry.Point2D
    public Point2D method_693() {
        return this.field_407.method_645();
    }

    // $FF: renamed from: a (double, double) void
    public void method_694(double var1, double var3) {
        Point2D var5 = this.field_407.method_645();
        if(var5 == null) {
            this.field_407.method_646(new Point2D(var1, var3));
        } else {
            var5.setX(var1);
            var5.setY(var3);
        }

    }

    // $FF: renamed from: s () double
    public double method_695() {
        Point2D var1 = this.field_407.method_645();
        return var1 == null?0.0D:var1.getX();
    }

    // $FF: renamed from: i (double) void
    public void method_696(double var1) {
        Point2D var3 = this.field_407.method_645();
        if(var3 == null) {
            this.field_407.method_646(new Point2D(var1, 0.0D));
        } else {
            var3.setX(var1);
        }

    }

    // $FF: renamed from: t () double
    public double method_697() {
        Point2D var1 = this.field_407.method_645();
        return var1 == null?0.0D:var1.getY();
    }

    // $FF: renamed from: j (double) void
    public void method_698(double var1) {
        Point2D var3 = this.field_407.method_645();
        if(var3 == null) {
            this.field_407.method_646(new Point2D(0.0D, var1));
        } else {
            var3.setY(var1);
        }

    }

    // $FF: renamed from: u () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_699() {
        return this.field_407.method_653();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_700(Vector2D var1) {
        this.field_407.method_654(var1);
    }

    // $FF: renamed from: b (double, double) void
    public void method_701(double var1, double var3) {
        Vector2D var5 = this.field_407.method_653();
        if(var5 == null) {
            this.field_407.method_654(new Vector2D(var1, var3));
        } else {
            var5.setX(var1);
            var5.setY(var3);
        }

    }

    // $FF: renamed from: v () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_702() {
        return this.field_407.method_655();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void method_703(Vector2D var1) {
        this.field_407.method_656(var1);
    }

    // $FF: renamed from: w () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_704() {
        return this.field_407.method_657();
    }

    // $FF: renamed from: c (com.codeforces.commons.geometry.Vector2D) void
    public void method_705(Vector2D var1) {
        this.field_407.method_658(var1);
    }

    // $FF: renamed from: c (double, double) void
    public void method_706(double var1, double var3) {
        Vector2D var5 = this.field_407.method_657();
        if(var5 == null) {
            this.field_407.method_658(new Vector2D(var1, var3));
        } else {
            var5.setX(var1);
            var5.setY(var3);
        }

    }

    // $FF: renamed from: x () double
    public double method_707() {
        return this.field_407.method_647();
    }

    // $FF: renamed from: k (double) void
    public void method_708(double var1) {
        this.field_407.method_648(var1);
    }

    // $FF: renamed from: y () double
    public double method_709() {
        return this.field_407.method_659();
    }

    // $FF: renamed from: l (double) void
    public void method_710(double var1) {
        this.field_407.method_660(var1);
    }

    // $FF: renamed from: z () double
    public double method_711() {
        return this.field_407.method_661();
    }

    // $FF: renamed from: m (double) void
    public void method_712(double var1) {
        this.field_407.method_662(var1);
    }

    // $FF: renamed from: A () double
    public double method_713() {
        return this.field_407.method_663();
    }

    // $FF: renamed from: n (double) void
    public void method_714(double var1) {
        this.field_407.method_664(var1);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D) double
    public double method_715(Point2D var1) {
        return this.field_407.method_645().getDistanceTo(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a) double
    public double method_716(class_106 var1) {
        return this.field_407.method_645().getSquaredDistanceTo(var1.field_407.method_645());
    }

    // $FF: renamed from: B () com.codeforces.commons.geometry.Point2D
    public Point2D method_717() {
        return this.field_398 == null?null:this.field_398.method_767(this);
    }

    // $FF: renamed from: C () void
    public void method_718() {
        this.field_407.method_649();
    }

    // $FF: renamed from: o (double) void
    void method_719(double var1) {
        if(this.field_412 == null || !NumberUtil.equals(this.field_401, this.field_410) || !NumberUtil.equals(var1, this.field_411)) {
            this.field_410 = this.field_401;
            this.field_411 = var1;
            this.field_412 = Math.pow(1.0D - this.field_401, var1);
        }

        this.method_699().subtract(this.method_702()).multiply(this.field_412).add(this.method_702());
    }

    // $FF: renamed from: p (double) void
    void method_720(double var1) {
        if(this.field_415 == null || !NumberUtil.equals(this.field_402, this.field_413) || !NumberUtil.equals(var1, this.field_414)) {
            this.field_413 = this.field_402;
            this.field_414 = var1;
            this.field_415 = Math.pow(1.0D - this.field_402, var1);
        }

        this.method_710((this.method_709() - this.method_711()) * this.field_415 + this.method_711());
    }

    // $FF: renamed from: b (com.a.a.b.a) boolean
    public boolean method_721(class_106 var1) {
        return var1 != null && this.field_396 == var1.field_396;
    }

    public int hashCode() {
        return (int)(this.field_396 ^ this.field_396 >>> 32);
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(var1 != null && this.getClass() == var1.getClass()) {
            class_106 var2 = (class_106)var1;
            return this.field_396 == var2.field_396;
        } else {
            return false;
        }
    }

    public String toString() {
        return method_722(this);
    }

    // $FF: renamed from: c (com.a.a.b.a) java.lang.String
    public static String method_722(class_106 var0) {
        return StringUtil.toString(class_106.class, var0, true, "id", "name", "position", "angle", "velocity", "angularVelocity");
    }
}
