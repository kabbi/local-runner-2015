package com.codeforces.commons.math;

import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

public final class NumberUtil {
    public static byte toByte(int var0) {
        byte var1 = (byte)var0;
        if(var1 == var0) {
            return var1;
        } else {
            throw new IllegalArgumentException("Can\'t convert int " + var0 + " to byte.");
        }
    }

    public static Integer toInt(Object var0) {
        return var0 == null?null:(var0 instanceof Byte?Integer.valueOf(((Byte)var0).byteValue()):(var0 instanceof Short?Integer.valueOf(((Short)var0).shortValue()):(var0 instanceof Integer?(Integer)var0:(var0 instanceof Long?Integer.valueOf(toInt(((Long)var0).longValue())):(var0 instanceof Float?Integer.valueOf(toInt(((Float)var0).floatValue())):(var0 instanceof Double?Integer.valueOf(toInt(((Double)var0).doubleValue())):(var0 instanceof Number?Integer.valueOf(toInt(((Number)var0).doubleValue())):Integer.valueOf(toInt(Double.parseDouble(StringUtil.trim(var0.toString())))))))))));
    }

    public static int toInt(long var0) {
        int var2 = (int)var0;
        if((long)var2 == var0) {
            return var2;
        } else {
            throw new IllegalArgumentException("Can\'t convert long " + var0 + " to int.");
        }
    }

    public static int toInt(float var0) {
        int var1 = (int)var0;
        if(Math.abs((float)var1 - var0) < 1.0F) {
            return var1;
        } else {
            throw new IllegalArgumentException("Can\'t convert float " + var0 + " to int.");
        }
    }

    public static int toInt(double var0) {
        int var2 = (int)var0;
        if(Math.abs((double)var2 - var0) < 1.0D) {
            return var2;
        } else {
            throw new IllegalArgumentException("Can\'t convert double " + var0 + " to int.");
        }
    }

    public static boolean equals(Integer var0, Integer var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    public static boolean equals(Long var0, Long var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    public static boolean equals(Double var0, Double var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    public static boolean nearlyEquals(Double var0, Double var1, double var2) {
        return var0 == null?var1 == null:(var0.equals(var1)?true:(!Double.isInfinite(var0.doubleValue()) && !Double.isNaN(var0.doubleValue()) && !Double.isInfinite(var1.doubleValue()) && !Double.isNaN(var1.doubleValue())?Math.abs(var0.doubleValue() - var1.doubleValue()) < var2:false));
    }
}
