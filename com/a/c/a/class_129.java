package com.a.c.a;

import com.a.c.a.class_125;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.b
public class class_129 extends class_125 {
    // $FF: renamed from: a double
    private double field_565;

    public class_129(double var1) {
        this.field_565 = var1;
    }

    public class_129(class_129 var1) {
        this.field_565 = var1.field_565;
    }

    // $FF: renamed from: a () double
    public double method_829() {
        return this.field_565;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public class_125 method_818() {
        return new class_129(this);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[0]);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean method_819(class_125 var1, double var2) {
        if(var1 != null && this.getClass() == var1.getClass()) {
            class_129 var4 = (class_129)var1;
            return Math.abs(this.field_565 - var4.field_565) < var2;
        } else {
            return false;
        }
    }
}
