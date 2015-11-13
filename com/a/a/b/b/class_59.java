package com.a.a.b.b;

import com.a.a.b.class_106;
import com.a.a.b.b.class_4;
import com.a.a.b.b.class_71;
import com.a.a.b.c.class_113;

// $FF: renamed from: com.a.a.b.b.e
public abstract class class_59 implements class_4 {
    // $FF: renamed from: a double
    protected final double field_212;

    protected class_59(double var1) {
        this.field_212 = var1;
    }

    // $FF: renamed from: c (com.a.a.b.a, com.a.a.b.a) boolean
    public final boolean method_25(class_106 var1, class_106 var2) {
        return this.method_376(var1, var2) || this.method_376(var2, var1);
    }

    // $FF: renamed from: d (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    public final class_71 method_26(class_106 var1, class_106 var2) {
        if(this.method_376(var1, var2)) {
            return this.method_377(var1, var2);
        } else if(this.method_376(var2, var1)) {
            class_71 var3 = this.method_377(var2, var1);
            return var3 == null?null:new class_71(var1, var2, var3.method_388(), var3.method_389().negate(), var3.method_390(), this.field_212);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported %s of %s or %s of %s.", new Object[]{class_113.method_769(var1.method_668()), var1, class_113.method_769(var2.method_668()), var2}));
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected abstract boolean method_376(class_106 var1, class_106 var2);

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected abstract class_71 method_377(class_106 var1, class_106 var2);
}
