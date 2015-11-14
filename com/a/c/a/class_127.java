package com.a.c.a;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.a.d
public class class_127 extends Form {
    // $FF: renamed from: a double
    private double field_559;
    // $FF: renamed from: b double
    private double field_560;
    // $FF: renamed from: c double
    private double field_561;
    // $FF: renamed from: d double
    private double field_562;

    public class_127(double var1, double var3, double var5, double var7) {
        this.field_559 = var1;
        this.field_560 = var3;
        this.field_561 = var5;
        this.field_562 = var7;
    }

    public class_127(Point2D var1, Point2D var2) {
        this.field_559 = var1.getX();
        this.field_560 = var1.getY();
        this.field_561 = var2.getX();
        this.field_562 = var2.getY();
    }

    public class_127(class_127 var1) {
        this.field_559 = var1.field_559;
        this.field_560 = var1.field_560;
        this.field_561 = var1.field_561;
        this.field_562 = var1.field_562;
    }

    // $FF: renamed from: a () double
    public double method_823() {
        return this.field_559;
    }

    // $FF: renamed from: b () double
    public double method_824() {
        return this.field_560;
    }

    // $FF: renamed from: c () double
    public double method_825() {
        return this.field_561;
    }

    // $FF: renamed from: f () double
    public double method_826() {
        return this.field_562;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public Form method_818() {
        return new class_127(this);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[0]);
    }

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public boolean method_819(Form var1, double var2) {
        if(var1 != null && this.getClass() == var1.getClass()) {
            class_127 var4 = (class_127)var1;
            return Math.abs(this.field_559 - var4.field_559) < var2 && Math.abs(this.field_560 - var4.field_560) < var2 && Math.abs(this.field_561 - var4.field_561) < var2 && Math.abs(this.field_562 - var4.field_562) < var2;
        } else {
            return false;
        }
    }
}
