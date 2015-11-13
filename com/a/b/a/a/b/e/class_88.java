package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.c.class_132;
import com.a.c.a.class_125;
import com.a.c.a.class_129;

// $FF: renamed from: com.a.b.a.a.b.e.k
public final class class_88 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.d.a) com.a.b.a.a.c.n
    public static class_132 method_516(class_46 var0) {
        class_125 var1 = var0.method_279().method_902();
        if(!(var1 instanceof class_129)) {
            throw new IllegalArgumentException("Unsupported oil slick form: " + var1 + '.');
        } else {
            class_129 var2 = (class_129)var1;
            return new class_132(var0.method_278(), var0.method_279().method_900(),
                    var0.method_279().method_870(), var0.method_279().method_872(),
                    var0.method_279().method_876().getX(), var0.method_279().method_876().getY(),
                    var0.method_279().method_874(), var0.method_279().method_880(), var2.method_829(), var0.method_347());
        }
    }
}
