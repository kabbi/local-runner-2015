package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.d.e.class_48;
import com.a.b.a.a.b.d.e.class_50;
import com.a.b.a.a.c.class_140;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.c.i
public class class_35 extends class_34 {
    public void afterCollision(class_58 var1) {
        class_48 var2 = (class_48)var1.method_362();
        var2.method_357(false);
        if(var2.method_354() == class_140.TIRE) {
            if(method_276(var2)) {
                var1.method_361().method_18(var2);
            }

            if(var1.method_363() instanceof class_48) {
                class_48 var3 = (class_48)var1.method_363();
                var3.method_357(false);
                if(var3.method_354() == class_140.TIRE) {
                    if(method_276(var3)) {
                        var1.method_361().method_18(var3);
                    }
                } else if(var3.method_354() == class_140.WASHER) {
                    var1.method_361().method_18(var3);
                }
            }
        } else if(var2.method_354() == class_140.WASHER && var1.method_363() instanceof class_50) {
            class_50 var4 = (class_50)var1.method_363();
            var4.method_357(false);
            var1.method_361().method_18(var2);
            if(method_276(var4)) {
                var1.method_361().method_18(var4);
            }
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.e.a) boolean
    private static boolean method_276(class_48 var0) {
        return var0.method_279().method_876().getSquaredLength() <= Math.sqr(15.0D);
    }
}
