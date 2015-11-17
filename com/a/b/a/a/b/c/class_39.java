package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.c.EffectType;
import com.a.c.PhysicalBody;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.holder.Readable;

// $FF: renamed from: com.a.b.a.a.b.c.d
public class class_39 extends class_34 {
    // $FF: renamed from: a com.codeforces.commons.holder.Readable
    private final Readable field_144;

    public class_39(Readable var1) {
        this.field_144 = var1;
    }

    public boolean beforeResolvingCollision(class_58 var1) {
        class_43 var2 = (class_43)var1.method_362();
        class_43 var3 = (class_43)var1.method_363();
        PhysicalBody var4 = var2.method_279();
        PhysicalBody var5 = var3.method_279();
        Vector2D var6 = var4.getVelocity();
        Vector2D var7 = var5.getVelocity();
        double var8 = var1.method_365().copyNegate().dotProduct(var6);
        double var10 = var1.method_365().dotProduct(var7);
        double var12 = var8 + var10;
        if(var12 > 0.0D) {
            double var14 = var12 * var5.getMass() / var4.getMass() * 0.003D;
            double var16 = var12 * var4.getMass() / var5.getMass() * 0.003D;
            if(var14 > 0.01D || var16 > 0.01D) {
                if(var14 > 0.01D) {
                    class_79.method_480(var2, var3.method_297(), var14, 2.0D);
                }

                if(var16 > 0.01D) {
                    class_79.method_480(var3, var2.method_297(), var16, 2.0D);
                }

                var1.method_361().method_20(new class_124(EffectType.CAR_AND_CAR_IMPACT, ((Integer)this.field_144.get()).intValue(), var1.method_364().getX(), var1.method_364().getY(), 0.0D));
            }
        }

        return true;
    }
}
