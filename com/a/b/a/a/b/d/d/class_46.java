package com.a.b.a.a.b.d.d;

import com.a.b.class_42;
import com.a.c.a.class_129;
import com.codeforces.commons.geometry.Point2D;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.a.b.a.a.b.d.d.a
public class class_46 extends class_42 {
    // $FF: renamed from: a int
    private final int field_181;
    // $FF: renamed from: b int
    private int field_182;
    // $FF: renamed from: c java.util.Set
    private final Set field_183;

    public class_46(double var1, double var3) {
        super(new class_129(150.0D));
        this.field_183 = new HashSet();
        this.field_181 = 600;
        this.field_182 = 600;
        this.method_279().method_871(var1);
        this.method_279().method_873(var3);
        this.method_279().method_905(true);
    }

    public class_46(Point2D var1) {
        this(var1.getX(), var1.getY());
    }

    // $FF: renamed from: k () int
    public int method_347() {
        return this.field_182;
    }

    // $FF: renamed from: c (int) void
    public void method_348(int var1) {
        this.field_182 = var1;
    }
}
