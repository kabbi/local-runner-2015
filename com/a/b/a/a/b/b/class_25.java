package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.a.GameProperties;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import java.util.Iterator;

// $FF: renamed from: com.a.b.a.a.b.b.g
public class class_25 implements class_2 {
    // $FF: renamed from: a boolean
    private final boolean field_91;

    public class_25(GameProperties var1) {
        this.field_91 = var1.shouldLogMaxSpeed();
    }

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(var3.hasNext()) {
            class_42 var4 = (class_42)var3.next();
            double var5 = var4.method_279().getX();
            double var7 = var4.method_279().getY();
            if(var4.method_291() == null) {
                var4.method_292(0.0D);
                var4.method_294(new Vector2D(0.0D, 0.0D));
            } else {
                double var9 = Math.hypot(var5 - var4.method_287(), var7 - var4.method_289());
                var4.method_292(var4.method_291() + var9);
                var4.method_294(new Vector2D(var4.method_287().doubleValue(), var4.method_289().doubleValue(), var5, var7));
            }

            var4.method_288(var5);
            var4.method_290(var7);
            if(this.field_91) {
                var4.method_283(var2);
                var4.method_286(var2);
            }
        }

    }
}
