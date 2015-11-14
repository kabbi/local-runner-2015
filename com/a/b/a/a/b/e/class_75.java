package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.e.Car;
import com.a.b.a.a.c.Projectile;
import com.a.c.a.Form;
import com.a.c.a.class_129;

// $FF: renamed from: com.a.b.a.a.b.e.o
public final class class_75 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.e.a, double) com.a.b.a.a.c.q
    public static Projectile method_459(Car var0, double var1) {
        Form var3 = var0.getBody().getForm();
        if(!(var3 instanceof class_129)) {
            throw new IllegalArgumentException("Unsupported projectile form: " + var3 + '.');
        } else {
            class_129 var4 = (class_129)var3;
            return new Projectile(var0.getId(), var0.getBody().getMass(), var0.getBody().getX(), var0.getBody().getY(), var0.getBody().getSpeed().getX() * var1, var0.getBody().getSpeed().getY() * var1, var0.getBody().getAngle(), var0.getBody().angularSpeed() * var1, var4.method_829(), var0.method_352().getId(), var0.method_353().getPlayerId(), var0.method_354());
        }
    }
}
