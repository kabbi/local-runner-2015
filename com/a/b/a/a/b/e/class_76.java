package com.a.b.a.a.b.e;

import com.a.b.a.a.c.Unit;
import com.a.b.a.a.c.OilSlick;
import com.a.b.a.a.c.Projectile;
import com.a.b.a.a.c.Bonus;
import com.a.b.a.a.c.Car;

// $FF: renamed from: com.a.b.a.a.b.e.p
public class class_76 {
    // $FF: renamed from: a (com.a.b.a.a.c.u, com.a.b.a.a.c.u) boolean
    public static boolean method_460(Unit var0, Unit var1) {
        if(var0 == null && var1 == null) {
            return true;
        } else if(var0 == null ^ var1 == null) {
            return false;
        } else if(var0 instanceof Car && var1 instanceof Car) {
            return Car.areFieldEquals((Car) var0, (Car) var1);
        } else if(var0 instanceof Projectile && var1 instanceof Projectile) {
            return Projectile.areFieldEquals((Projectile) var0, (Projectile) var1);
        } else if(var0 instanceof Bonus && var1 instanceof Bonus) {
            return Bonus.areFieldEquals((Bonus) var0, (Bonus) var1);
        } else if(var0 instanceof OilSlick && var1 instanceof OilSlick) {
            return OilSlick.areFieldEquals((OilSlick) var0, (OilSlick) var1);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported classes of units %s and %s.", new Object[]{var0, var1}));
        }
    }
}
