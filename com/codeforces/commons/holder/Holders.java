package com.codeforces.commons.holder;

import com.codeforces.commons.holder.Writable;

public class Holders {
    public static void setQuietly(Writable var0, Object var1) {
        if(var0 != null) {
            try {
                var0.set(var1);
            } catch (RuntimeException var3) {
                ;
            }
        }

    }
}
