package com.a.b.a.a.b.d.b.a.a;

import com.a.b.RectangleBody;
import com.a.b.a.a.b.d.b.a.b.class_55;

// $FF: renamed from: com.a.b.a.a.b.d.b.a.a.b
public class ProbablyProjectileOfSomeSort extends class_56 {
    // $FF: renamed from: a com.a.b.e
    private final RectangleBody field_192;

    public ProbablyProjectileOfSomeSort(double var1, double var3, double var5, double var7) {
        super(var1, var3, 80.0D);
        this.getBody().setMomentumTransferFactor(0.5D);
        this.getBody().setSurfaceFriction(0.25D);
        this.field_192 = new class_55(var1, var3, 80.0D, var5, var7);
    }

    // $FF: renamed from: k () com.a.b.e
    public RectangleBody method_360() {
        return this.field_192;
    }
}
