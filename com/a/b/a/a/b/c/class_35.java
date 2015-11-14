package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.d.e.Car;
import com.a.b.a.a.b.d.e.class_50;
import com.a.b.a.a.c.ProjectileType;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.c.i
public class class_35 extends class_34 {
    public void afterCollision(class_58 var1) {
        Car var2 = (Car)var1.method_362();
        var2.method_357(false);
        if(var2.method_354() == ProjectileType.TIRE) {
            if(method_276(var2)) {
                var1.method_361().method_18(var2);
            }

            if(var1.method_363() instanceof Car) {
                Car var3 = (Car)var1.method_363();
                var3.method_357(false);
                if(var3.method_354() == ProjectileType.TIRE) {
                    if(method_276(var3)) {
                        var1.method_361().method_18(var3);
                    }
                } else if(var3.method_354() == ProjectileType.WASHER) {
                    var1.method_361().method_18(var3);
                }
            }
        } else if(var2.method_354() == ProjectileType.WASHER && var1.method_363() instanceof class_50) {
            class_50 var4 = (class_50)var1.method_363();
            var4.method_357(false);
            var1.method_361().method_18(var2);
            if(method_276(var4)) {
                var1.method_361().method_18(var4);
            }
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.e.a) boolean
    private static boolean method_276(Car var0) {
        return var0.getBody().getSpeed().getSquaredLength() <= Math.sqr(15.0D);
    }
}
