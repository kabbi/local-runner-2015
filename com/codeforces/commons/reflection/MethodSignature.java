package com.codeforces.commons.reflection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MethodSignature {
    private final String name;
    private final List parameterTypes;
    private final int hashCode;

    public MethodSignature(String var1, Class... var2) {
        this.name = var1;
        this.parameterTypes = Arrays.asList(var2);
        int var3 = this.name.hashCode();
        var3 = 31 * var3 + this.parameterTypes.hashCode();
        this.hashCode = var3;
    }

    public String getName() {
        return this.name;
    }

    public List getParameterTypes() {
        return Collections.unmodifiableList(this.parameterTypes);
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(var1 != null && this.getClass() == var1.getClass()) {
            MethodSignature var2 = (MethodSignature)var1;
            return this.name.equals(var2.name) && this.parameterTypes.equals(var2.parameterTypes);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.hashCode;
    }
}
