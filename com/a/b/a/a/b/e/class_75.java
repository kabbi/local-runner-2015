package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.e.class_48;
import com.a.b.a.a.c.Projectile;
import com.a.c.a.class_125;
import com.a.c.a.class_129;

// $FF: renamed from: com.a.b.a.a.b.e.o
public final class class_75 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.e.a, double) com.a.b.a.a.c.q
    public static Projectile method_459(class_48 var0, double var1) {
        class_125 var3 = var0.method_279().getForm();
        if(!(var3 instanceof class_129)) {
            throw new IllegalArgumentException("Unsupported projectile form: " + var3 + '.');
        } else {
            class_129 var4 = (class_129)var3;
            return new Projectile(var0.method_278(), var0.method_279().getMass(), var0.method_279().getX(), var0.method_279().getY(), var0.method_279().getVelocity().getX() * var1, var0.method_279().getVelocity().getY() * var1, var0.method_279().getAngle(), var0.method_279().getAngularVelocity() * var1, var4.method_829(), var0.method_352().method_278(), var0.method_353().method_917(), var0.method_354());
        }
    }
}
