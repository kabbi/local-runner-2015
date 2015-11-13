package com.codeforces.commons.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUtil {
    public static void invert(AtomicBoolean var0) {
        boolean var1;
        do {
            var1 = var0.get();
        } while(!var0.compareAndSet(var1, !var1));

    }

    public static void decrement(AtomicInteger var0, int var1) {
        int var2;
        int var3;
        do {
            var2 = var0.get();
            var3 = normalizeValue(var2 - 1, var1);
        } while(!var0.compareAndSet(var2, var3));

    }

    private static int normalizeValue(int var0, int var1) {
        while(var0 > var1) {
            var0 -= var1 + 1;
        }

        while(var0 < 0) {
            var0 += var1 + 1;
        }

        return var0;
    }
}
