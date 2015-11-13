package com.a.c;

import com.a.c.a.class_125;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.util.Collections;
import java.util.Set;

// $FF: renamed from: com.a.c.c
public abstract class class_159 {
    // $FF: renamed from: a long
    @Name("id")
    private final long field_650;
    // $FF: renamed from: b java.lang.String
    @Name("name")
    private String field_651;
    // $FF: renamed from: c double
    @Name("mass")
    private double field_652;
    // $FF: renamed from: d com.a.c.a.c
    @Name("form")
    private class_125 field_653;
    // $FF: renamed from: e boolean
    @Name("staticBody")
    private boolean field_654;
    // $FF: renamed from: f java.util.Set
    @Name("excludedBodyIds")
    private Set field_655;

    protected class_159(long var1) {
        this.field_650 = var1;
    }

    // $FF: renamed from: a () long
    public final long method_867() {
        return this.field_650;
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_868() {
        return this.field_651;
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_869(String var1) {
        this.field_651 = var1;
    }

    // $FF: renamed from: c () double
    public abstract double method_870();

    // $FF: renamed from: a (double) void
    public abstract void method_871(double var1);

    // $FF: renamed from: d () double
    public abstract double method_872();

    // $FF: renamed from: b (double) void
    public abstract void method_873(double var1);

    // $FF: renamed from: e () double
    public abstract double method_874();

    // $FF: renamed from: c (double) void
    public abstract void method_875(double var1);

    // $FF: renamed from: f () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D method_876();

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public abstract void method_877(Vector2D var1);

    // $FF: renamed from: g () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D method_878();

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public abstract void method_879(Vector2D var1);

    // $FF: renamed from: h () double
    public abstract double method_880();

    // $FF: renamed from: d (double) void
    public abstract void method_881(double var1);

    // $FF: renamed from: i () double
    public abstract double method_882();

    // $FF: renamed from: e (double) void
    public abstract void method_883(double var1);

    // $FF: renamed from: j () com.codeforces.commons.geometry.Vector2D
    public abstract Vector2D method_884();

    // $FF: renamed from: k () double
    public abstract double method_885();

    // $FF: renamed from: l () double
    public abstract double method_886();

    // $FF: renamed from: f (double) void
    public abstract void method_887(double var1);

    // $FF: renamed from: m () double
    public abstract double method_888();

    // $FF: renamed from: g (double) void
    public abstract void method_889(double var1);

    // $FF: renamed from: n () double
    public abstract double method_890();

    // $FF: renamed from: h (double) void
    public abstract void method_891(double var1);

    // $FF: renamed from: o () java.lang.Double
    public abstract Double method_892();

    // $FF: renamed from: a (java.lang.Double) void
    public abstract void method_893(Double var1);

    // $FF: renamed from: p () double
    public abstract double method_894();

    // $FF: renamed from: i (double) void
    public abstract void method_895(double var1);

    // $FF: renamed from: q () double
    public abstract double method_896();

    // $FF: renamed from: j (double) void
    public abstract void method_897(double var1);

    // $FF: renamed from: r () double
    public abstract double method_898();

    // $FF: renamed from: k (double) void
    public abstract void method_899(double var1);

    // $FF: renamed from: s () double
    public double method_900() {
        return this.field_652;
    }

    // $FF: renamed from: l (double) void
    public void method_901(double var1) {
        this.field_652 = var1;
    }

    // $FF: renamed from: t () com.a.c.a.c
    public class_125 method_902() {
        return this.field_653;
    }

    // $FF: renamed from: a (com.a.c.a.c) void
    public void method_903(class_125 var1) {
        this.field_653 = var1;
    }

    // $FF: renamed from: u () boolean
    public boolean method_904() {
        return this.field_654;
    }

    // $FF: renamed from: a (boolean) void
    public void method_905(boolean var1) {
        this.field_654 = var1;
    }

    // $FF: renamed from: v () java.util.Set
    public Set method_906() {
        return this.field_655 == null?Collections.emptySet():Collections.unmodifiableSet(this.field_655);
    }

    public String toString() {
        return StringUtil.toString(this, false, new String[]{"id", "name", "x", "y"});
    }
}
