package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.c.EffectType;
import com.a.c.PhysicalBody;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.holder.Readable;
import com.codeforces.commons.math.Math;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.b.b.d
public class class_22 implements class_2 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_83 = LoggerFactory.getLogger(class_22.class);
    // $FF: renamed from: b java.util.concurrent.atomic.AtomicInteger
    private final AtomicInteger field_84 = new AtomicInteger();
    // $FF: renamed from: c com.codeforces.commons.holder.Readable
    private final Readable field_85;
    // $FF: renamed from: d com.a.b.a.a.a.b
    private final GameProperties field_86;

    public class_22(Readable var1, GameProperties var2) {
        this.field_85 = var1;
        this.field_86 = var2;
    }

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(true) {
            class_42 var4;
            class_43 var5;
            do {
                do {
                    do {
                        do {
                            do {
                                if(!var3.hasNext()) {
                                    return;
                                }

                                var4 = (class_42)var3.next();
                            } while(!(var4 instanceof class_43));

                            var5 = (class_43)var4;
                        } while(class_79.method_481(var5));
                    } while(var5.method_345());
                } while(var5.method_334() > 0);
            } while(var5.method_342() != null && var5.method_342() + EffectType.DRIFTING.getDuration() >= var2);

            PhysicalBody var6 = var5.method_279();
            double var7 = Math.abs(var6.getVelocity().dotProduct((new Vector2D(1.0D, 0.0D)).rotate(var6.getAngle() + 1.5707963267948966D)));
            if(var7 >= 15.0D) {
                int var9 = this.field_84.incrementAndGet();
                if(this.field_86.shouldLogDrifting()) {
                    field_83.debug(String.format("Car {id=%d} drifting %d at tick %d (driftingSpeed=%.2f).", var4.method_278(), var9, this.field_85.get(), var7));
                }

                var5.method_343(var2);
                var1.method_20(new class_124(EffectType.DRIFTING, ((Integer)this.field_85.get()).intValue(), var4));
            }
        }
    }
}
