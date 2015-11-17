package com.a.b.a.a.b.d.a;

import com.a.b.class_42;
import com.a.b.a.a.c.BonusType;
import com.a.c.a.class_128;

// $FF: renamed from: com.a.b.a.a.b.d.a.a
public class class_47 extends class_42 {
    // $FF: renamed from: a com.a.b.a.a.c.b
    private final BonusType field_184;
    // $FF: renamed from: b int
    private final int field_185;
    // $FF: renamed from: c int
    private int field_186;

    public class_47(BonusType var1, double var2, double var4) {
        super(new class_128(70.0D, 70.0D));
        this.field_184 = var1;
        this.field_185 = Integer.MAX_VALUE;
        this.field_186 = Integer.MAX_VALUE;
        this.method_279().setX(var2);
        this.method_279().setY(var4);
        this.method_279().setMass(100.0D);
        this.method_279().setMomentumTransferFactor(1.0D);
        this.method_279().setSurfaceFrictionFactor(1.0D);
    }

    // $FF: renamed from: k () com.a.b.a.a.c.b
    public BonusType method_349() {
        return this.field_184;
    }

    // $FF: renamed from: l () int
    public int method_350() {
        return this.field_186;
    }

    // $FF: renamed from: c (int) void
    public void method_351(int var1) {
        this.field_186 = var1;
    }
}
