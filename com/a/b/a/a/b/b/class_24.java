package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.d.d.class_46;
import java.util.Iterator;

// $FF: renamed from: com.a.b.a.a.b.b.f
public class class_24 implements class_2 {
    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(var3.hasNext()) {
            class_42 var4 = (class_42)var3.next();
            if(var4 instanceof class_43) {
                class_43 var5 = (class_43)var4;
                var5.method_324();
                var5.method_327();
                var5.method_330();
                var5.method_333();
                if(var5.method_334() > 0) {
                    var5.method_336();
                    if(var5.method_334() <= 0) {
                        var5.method_279().setSomeOtherMovementFrictionFactor(0.25D);
                        var5.method_279().setRotationFrictionFactor(0.008726646259971648D);
                    }
                }

                var5.method_339();
            } else if(var4 instanceof class_47) {
                class_47 var6 = (class_47)var4;
                if(var6.method_350() > 1) {
                    var6.method_351(var6.method_350() - 1);
                } else {
                    var6.method_351(0);
                    var1.method_18(var6);
                }
            } else if(var4 instanceof class_46) {
                class_46 var7 = (class_46)var4;
                if(var7.method_347() > 1) {
                    var7.method_348(var7.method_347() - 1);
                } else {
                    var7.method_348(0);
                    var1.method_18(var7);
                }
            }
        }

    }
}
