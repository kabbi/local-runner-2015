package com.codeforces.commons.holder;

import com.codeforces.commons.holder.Mutable;

public class SimpleMutable extends Mutable {
    private Object value;

    public Object get() {
        return this.value;
    }

    public Object set(Object var1) {
        return this.value = var1;
    }
}
