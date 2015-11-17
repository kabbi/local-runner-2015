package com.a.b.a.a.b.c;

import com.a.b.class_3;
import com.a.b.class_34;
import com.a.b.class_42;
import com.a.b.class_58;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.d.e.class_48;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.c.EffectType;
import com.codeforces.commons.holder.Readable;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;

// $FF: renamed from: com.a.b.a.a.b.c.g
public class class_36 extends class_34 {
    // $FF: renamed from: a com.codeforces.commons.holder.Readable
    private final Readable field_143;

    public class_36(Readable var1) {
        this.field_143 = var1;
    }

    // $FF: renamed from: a (com.a.b.h, com.a.b.a.a.b.d.e.a, com.a.b.a.a.b.d.c.b) boolean
    public boolean method_277(class_3 var1, class_48 var2, class_43 var3) {
        return !var2.method_356() || !var2.method_352().equals(var3);
    }

    public boolean beforeResolvingCollision(class_58 var1) {
        class_48 var2 = (class_48)var1.method_362();
        class_43 var3 = (class_43)var1.method_363();
        class_79.method_479(var3, var2.method_353(), var2.method_358(var1, (Integer) this.field_143.get()));
        return true;
    }

    public void afterCollision(class_58 var1) {
        class_48 var2 = (class_48)var1.method_362();
        switch(var2.method_354()) {
        case WASHER:
            var1.method_361().method_20(new class_124(EffectType.CAR_AND_WASHER_IMPACT, ((Integer)this.field_143.get()).intValue(), var1.method_364().getX(), var1.method_364().getY(), var1.method_365().copyNegate().getAngle()));
            var1.method_361().method_18(var2);
            break;
        case TIRE:
            var1.method_361().method_20(new class_124(EffectType.CAR_AND_TIRE_IMPACT, ((Integer)this.field_143.get()).intValue(), var1.method_364().getX(), var1.method_364().getY(), var1.method_365().copyNegate().getAngle()));
            if(var2.method_279().getVelocity().getSquaredLength() <= Math.sqr(15.0D) || NumberUtil.equals((Integer)this.field_143.get(), var2.method_355())) {
                var1.method_361().method_18(var2);
            }
            break;
        default:
            throw new IllegalArgumentException("Unsupported projectile type: " + var2.method_354() + '.');
        }

    }

    // $FF: synthetic method
    public boolean beforeCollision(class_3 var1, class_42 var2, class_42 var3) {
        return this.method_277(var1, (class_48)var2, (class_43)var3);
    }
}
