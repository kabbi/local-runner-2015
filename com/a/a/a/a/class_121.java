package com.a.a.a.a;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.a.a.a.c
public class class_121 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_513 = LoggerFactory.getLogger(class_121.class);
    // $FF: renamed from: b java.util.concurrent.locks.Lock
    private static final Lock field_514 = new ReentrantLock();
    // $FF: renamed from: c java.util.Random
    private static Random field_515 = new Random(method_789());

    private class_121() {
        throw new UnsupportedOperationException();
    }

    // $FF: renamed from: f () java.security.SecureRandom
    private static SecureRandom method_788() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException var1) {
            field_513.error(String.format("Can\'t create \'SHA1PRNG\' instance of %s. Switching to use a default instance.", new Object[]{SecureRandom.class.getSimpleName()}), var1);
            return new SecureRandom();
        }
    }

    // $FF: renamed from: a () long
    public static long method_789() {
        return System.nanoTime() ^ Thread.currentThread().getId() + Runtime.getRuntime().maxMemory() * Runtime.getRuntime().freeMemory() & Runtime.getRuntime().totalMemory();
    }

    // $FF: renamed from: a (boolean, long) void
    public static void method_790(boolean var0, long var1) {
        field_514.lock();

        try {
            field_515 = (Random)(var0?method_788():new Random());
            field_515.setSeed(var1);
        } finally {
            field_514.unlock();
        }

    }

    // $FF: renamed from: a (int, int) int
    public static int method_791(int var0, int var1) {
        field_514.lock();

        int var2;
        try {
            var2 = var0 + field_515.nextInt(var1 - var0 + 1);
        } finally {
            field_514.unlock();
        }

        return var2;
    }

    // $FF: renamed from: b () long
    public static long method_792() {
        field_514.lock();

        long var0;
        try {
            var0 = field_515.nextLong();
        } finally {
            field_514.unlock();
        }

        return var0;
    }

    // $FF: renamed from: c () boolean
    public static boolean method_793() {
        field_514.lock();

        boolean var0;
        try {
            var0 = field_515.nextBoolean();
        } finally {
            field_514.unlock();
        }

        return var0;
    }

    // $FF: renamed from: d () double
    public static double method_794() {
        field_514.lock();

        double var0;
        try {
            var0 = field_515.nextDouble();
        } finally {
            field_514.unlock();
        }

        return var0;
    }

    // $FF: renamed from: e () java.lang.String
    public static String method_795() {
        return Hex.encodeHexString(method_796(16));
    }

    // $FF: renamed from: a (int) byte[]
    public static byte[] method_796(int var0) {
        if(var0 < 0) {
            throw new IllegalArgumentException("Argument \'length\' must be a non-negative integer.");
        } else if(var0 == 0) {
            return ArrayUtils.EMPTY_BYTE_ARRAY;
        } else {
            byte[] var1 = new byte[var0];
            field_514.lock();

            try {
                field_515.nextBytes(var1);
            } finally {
                field_514.unlock();
            }

            return var1;
        }
    }

    // $FF: renamed from: a (java.util.List) void
    public static void method_797(List var0) {
        field_514.lock();

        try {
            Collections.shuffle(var0, field_515);
        } finally {
            field_514.unlock();
        }

    }
}
