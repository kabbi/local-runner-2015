package com.codeforces.commons.math;

import org.apache.commons.math3.util.FastMath;

public final class Math {
    public static final double SQRT_2 = sqrt(2.0D);
    public static final double SQRT_3 = sqrt(3.0D);
    public static final double SQRT_5 = sqrt(5.0D);
    public static final double SQRT_6 = sqrt(6.0D);
    public static final double SQRT_7 = sqrt(7.0D);
    public static final double SQRT_8 = sqrt(8.0D);
    public static final double CBRT_2 = cbrt(2.0D);
    public static final double CBRT_3 = cbrt(3.0D);
    public static final double CBRT_4 = cbrt(4.0D);
    public static final double CBRT_5 = cbrt(5.0D);
    public static final double CBRT_6 = cbrt(6.0D);
    public static final double CBRT_7 = cbrt(7.0D);
    public static final double CBRT_9 = cbrt(9.0D);

    public static double sqr(double var0) {
        return var0 * var0;
    }

    public static double sumSqr(double var0, double var2) {
        return var0 * var0 + var2 * var2;
    }

    public static double pow(double var0, double var2) {
        return StrictMath.pow(var0, var2);
    }

    public static int min(int var0, int var1) {
        return var0 <= var1?var0:var1;
    }

    public static double min(double var0, double var2) {
        return java.lang.Math.min(var0, var2);
    }

    public static int max(int var0, int var1) {
        return var0 >= var1?var0:var1;
    }

    public static long max(long var0, long var2) {
        return var0 >= var2?var0:var2;
    }

    public static double max(double var0, double var2) {
        return java.lang.Math.max(var0, var2);
    }

    public static int abs(int var0) {
        return var0 < 0?-var0:var0;
    }

    public static float abs(float var0) {
        return java.lang.Math.abs(var0);
    }

    public static double abs(double var0) {
        return java.lang.Math.abs(var0);
    }

    public static double sqrt(double var0) {
        return StrictMath.sqrt(var0);
    }

    public static double cbrt(double var0) {
        return StrictMath.cbrt(var0);
    }

    public static float round(float var0) {
        return (float)java.lang.Math.round(var0);
    }

    public static double round(double var0) {
        return (double)java.lang.Math.round(var0);
    }

    public static double floor(double var0) {
        return FastMath.floor(var0);
    }

    public static double hypot(double var0, double var2) {
        return FastMath.hypot(var0, var2);
    }

    public static double sin(double var0) {
        return FastMath.sin(var0);
    }

    public static double cos(double var0) {
        return FastMath.cos(var0);
    }

    public static double atan2(double var0, double var2) {
        return StrictMath.atan2(var0, var2);
    }
}
