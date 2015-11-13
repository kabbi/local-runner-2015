package com.codeforces.commons.collection;

import java.util.Collection;

public class CollectionUtil {
    public static boolean addAll(Collection var0, Object[] var1) {
        boolean var2 = false;
        int var3 = 0;

        for(int var4 = var1.length; var3 < var4; ++var3) {
            var2 |= var0.add(var1[var3]);
        }

        return var2;
    }
}
