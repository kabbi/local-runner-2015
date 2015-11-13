package com.a.c.a;

import com.a.c.a.class_125;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.e
public class class_128 extends class_125 {
    // $FF: renamed from: a double
    private double field_563;
    // $FF: renamed from: b double
    private double field_564;

    public class_128(double var1, double var3) {
        this.field_563 = var1;
        this.field_564 = var3;
    }

    public class_128(class_128 var1) {
        this.field_563 = var1.field_563;
        this.field_564 = var1.field_564;
    }

    // $FF: renamed from: a () double
    public double method_827() {
        return this.field_563;
    }

    // $FF: renamed from: b () double
    public double method_828() {
        return this.field_564;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public class_125 method_818() {
        return new class_128(this);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[0]);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean method_819(class_125 var1, double var2) {
        if(var1 != null && this.getClass() == var1.getClass()) {
            class_128 var4 = (class_128)var1;
            return Math.abs(this.field_563 - var4.field_563) < var2 && Math.abs(this.field_564 - var4.field_564) < var2;
        } else {
            return false;
        }
    }
}
