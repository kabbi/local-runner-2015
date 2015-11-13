package com.a.a.b.c;

import com.a.a.b.class_106;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.c.c
public abstract class class_113 {
    // $FF: renamed from: a com.a.a.b.c.f
    private final class_119 field_466;

    protected class_113(class_119 var1) {
        if(var1 == null) {
            throw new IllegalArgumentException("Argument \'shape\' is null.");
        } else {
            this.field_466 = var1;
        }
    }

    // $FF: renamed from: e () com.a.a.b.c.f
    public class_119 method_764() {
        return this.field_466;
    }

    // $FF: renamed from: d () double
    public abstract double method_765();

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public abstract Point2D method_766(Point2D var1, double var2);

    // $FF: renamed from: a (com.a.a.b.a) com.codeforces.commons.geometry.Point2D
    public final Point2D method_767(class_106 var1) {
        return this.method_766(var1.method_693(), var1.method_707());
    }

    // $FF: renamed from: a (double) double
    public abstract double method_768(double var1);

    public abstract String toString();

    // $FF: renamed from: a (com.a.a.b.c.c) java.lang.String
    public static String method_769(class_113 var0) {
        return var0 == null?"Form {null}":var0.toString();
    }

    // $FF: renamed from: a (double, double) double
    protected static double method_770(double var0, double var2) {
        return Math.abs(var0) < var2?0.0D:(Math.abs(1.0D - var0) < var2?1.0D:(Math.abs(-1.0D - var0) < var2?-1.0D:var0));
    }
}
