package com.a.b.a.a.b.c;

import com.a.a.a.a.RandomUtils;
import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.b.e.class_85;
import com.a.c.class_159;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.c.e
public class class_38 extends class_34 {
    public boolean beforeResolvingCollision(class_58 var1) {
        class_43 var2 = (class_43)var1.method_362();
        class_46 var3 = (class_46)var1.method_363();
        if(!var2.method_345() && var2.method_334() <= 0 && var3.method_347() > 0 && var2.method_296(var3) <= class_85.method_500(var3.method_279().method_902())) {
            class_159 var4 = var2.method_279();
            int var5 = Math.min(var3.method_347(), 60);
            var2.method_335(var5);
            var3.method_348(var3.method_347() - var5);
            var4.method_893(0.001D);
            var4.method_895(0.0017453292519943296D);
            var4.method_881(var4.method_880() + (RandomUtils.randomBoolean()?0.0023271056693257726D:-0.0023271056693257726D) * var4.method_876().getLength());
            return false;
        } else {
            return false;
        }
    }
}
