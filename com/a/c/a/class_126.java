package com.a.c.a;

import com.a.c.a.class_125;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.a
public class class_126 extends class_125 {
    // $FF: renamed from: a double
    private double field_556;
    // $FF: renamed from: b double
    private double field_557;
    // $FF: renamed from: c double
    private double field_558;

    public class_126(double var1, double var3, double var5) {
        this.field_556 = var1;
        this.field_557 = var3;
        this.field_558 = var5;
    }

    public class_126(class_126 var1) {
        this.field_556 = var1.field_556;
        this.field_557 = var1.field_557;
        this.field_558 = var1.field_558;
    }

    // $FF: renamed from: a () double
    public double method_820() {
        return this.field_556;
    }

    // $FF: renamed from: b () double
    public double method_821() {
        return this.field_557;
    }

    // $FF: renamed from: c () double
    public double method_822() {
        return this.field_558;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public class_125 method_818() {
        return new class_126(this);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[0]);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean method_819(class_125 var1, double var2) {
        if(var1 != null && this.getClass() == var1.getClass()) {
            class_126 var4 = (class_126)var1;
            return Math.abs(this.field_556 - var4.field_556) < var2 && Math.abs(this.field_558 - var4.field_558) < var2;
        } else {
            return false;
        }
    }
}
