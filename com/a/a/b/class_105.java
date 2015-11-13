package com.a.a.b;

import com.a.a.b.class_104;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b
public class class_105 extends class_104 {
    // $FF: renamed from: a com.codeforces.commons.geometry.Vector2D
    private Vector2D field_389;
    // $FF: renamed from: b com.codeforces.commons.geometry.Vector2D
    private Vector2D field_390;
    // $FF: renamed from: c com.codeforces.commons.geometry.Vector2D
    private Vector2D field_391;
    // $FF: renamed from: d double
    private double field_392;
    // $FF: renamed from: e double
    private double field_393;
    // $FF: renamed from: f double
    private double field_394;

    public class_105() {
        this.field_389 = new Vector2D(0.0D, 0.0D);
        this.field_390 = new Vector2D(0.0D, 0.0D);
        this.field_391 = new Vector2D(0.0D, 0.0D);
    }

    public class_105(class_105 var1) {
        super(var1);
        this.field_389 = var1.field_389.copy();
        this.field_391 = var1.field_391.copy();
        this.field_392 = var1.field_392;
        this.field_394 = var1.field_394;
    }

    // $FF: renamed from: a () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_653() {
        return this.field_389;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void method_654(Vector2D var1) {
        this.field_389 = var1.copy();
    }

    // $FF: renamed from: b () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_655() {
        return this.field_390;
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void method_656(Vector2D var1) {
        this.field_390 = var1;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_657() {
        return this.field_391;
    }

    // $FF: renamed from: c (com.codeforces.commons.geometry.Vector2D) void
    public void method_658(Vector2D var1) {
        this.field_391 = var1.copy();
    }

    // $FF: renamed from: d () double
    public double method_659() {
        return this.field_392;
    }

    // $FF: renamed from: a (double) void
    public void method_660(double var1) {
        this.field_392 = var1;
    }

    // $FF: renamed from: e () double
    public double method_661() {
        return this.field_393;
    }

    // $FF: renamed from: b (double) void
    public void method_662(double var1) {
        this.field_393 = var1;
    }

    // $FF: renamed from: f () double
    public double method_663() {
        return this.field_394;
    }

    // $FF: renamed from: c (double) void
    public void method_664(double var1) {
        this.field_394 = var1;
    }
}
