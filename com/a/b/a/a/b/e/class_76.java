package com.a.b.a.a.b.e;

import com.a.b.a.a.c.class_130;
import com.a.b.a.a.c.class_132;
import com.a.b.a.a.c.class_133;
import com.a.b.a.a.c.class_135;
import com.a.b.a.a.c.class_136;

// $FF: renamed from: com.a.b.a.a.b.e.p
public class class_76 {
    // $FF: renamed from: a (com.a.b.a.a.c.u, com.a.b.a.a.c.u) boolean
    public static boolean method_460(class_130 var0, class_130 var1) {
        if(var0 == null && var1 == null) {
            return true;
        } else if(var0 == null ^ var1 == null) {
            return false;
        } else if(var0 instanceof class_136 && var1 instanceof class_136) {
            return class_136.areFieldEquals((class_136)var0, (class_136)var1);
        } else if(var0 instanceof class_133 && var1 instanceof class_133) {
            return class_133.areFieldEquals((class_133)var0, (class_133)var1);
        } else if(var0 instanceof class_135 && var1 instanceof class_135) {
            return class_135.areFieldEquals((class_135)var0, (class_135)var1);
        } else if(var0 instanceof class_132 && var1 instanceof class_132) {
            return class_132.areFieldEquals((class_132)var0, (class_132)var1);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported classes of units %s and %s.", new Object[]{var0, var1}));
        }
    }
}
