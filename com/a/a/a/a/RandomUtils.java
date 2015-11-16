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
public class RandomUtils {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(RandomUtils.class);
    // $FF: renamed from: b java.util.concurrent.locks.Lock
    private static final Lock guard = new ReentrantLock();
    // $FF: renamed from: c java.util.Random
    private static Random random = new Random(generateSeed());

    private RandomUtils() {
        throw new UnsupportedOperationException();
    }

    // $FF: renamed from: f () java.security.SecureRandom
    private static SecureRandom createSecureRandomInstance() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            logger.error(String.format("Can\'t create \'SHA1PRNG\' instance of %s. Switching to use a default instance.", SecureRandom.class.getSimpleName()), e);
            return new SecureRandom();
        }
    }

    // $FF: renamed from: a () long
    public static long generateSeed() {
        return System.nanoTime() ^ Thread.currentThread().getId() + Runtime.getRuntime().maxMemory() * Runtime.getRuntime().freeMemory() & Runtime.getRuntime().totalMemory();
    }

    // $FF: renamed from: a (boolean, long) void
    public static void initRandomInstance(boolean secure, long seed) {
        guard.lock();

        try {
            random = secure ? createSecureRandomInstance() : new Random();
            random.setSeed(seed);
        } finally {
            guard.unlock();
        }

    }

    // $FF: renamed from: a (int, int) int
    public static int randomInteger(int min, int max) {
        guard.lock();

        try {
            return min + random.nextInt(max - min + 1);
        } finally {
            guard.unlock();
        }
    }

    // $FF: renamed from: b () long
    public static long randomLong() {
        guard.lock();

        try {
            return random.nextLong();
        } finally {
            guard.unlock();
        }
    }

    // $FF: renamed from: c () boolean
    public static boolean randomBoolean() {
        guard.lock();

        try {
            return random.nextBoolean();
        } finally {
            guard.unlock();
        }
    }

    // $FF: renamed from: d () double
    public static double randomDouble() {
        guard.lock();

        try {
            return random.nextDouble();
        } finally {
            guard.unlock();
        }
    }

    // $FF: renamed from: e () java.lang.String
    public static String randomHexString() {
        return Hex.encodeHexString(randomByteArray(16));
    }

    // $FF: renamed from: a (int) byte[]
    public static byte[] randomByteArray(int length) {
        if(length < 0) {
            throw new IllegalArgumentException("Argument \'length\' must be a non-negative integer.");
        } else if(length == 0) {
            return ArrayUtils.EMPTY_BYTE_ARRAY;
        } else {
            byte[] array = new byte[length];
            guard.lock();

            try {
                random.nextBytes(array);
            } finally {
                guard.unlock();
            }

            return array;
        }
    }

    // $FF: renamed from: a (java.util.List) void
    public static void randomShuffle(List list) {
        guard.lock();

        try {
            Collections.shuffle(list, random);
        } finally {
            guard.unlock();
        }

    }
}
