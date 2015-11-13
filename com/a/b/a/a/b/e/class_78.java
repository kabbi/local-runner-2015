package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.c.class_135;
import com.a.c.a.class_125;
import com.a.c.a.class_128;

// $FF: renamed from: com.a.b.a.a.b.e.a
public final class class_78 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.a.a) com.a.b.a.a.c.a
    public static class_135 method_475(class_47 var0) {
        class_125 var1 = var0.method_279().method_902();
        if(!(var1 instanceof class_128)) {
            throw new IllegalArgumentException("Unsupported bonus form: " + var1 + '.');
        } else {
            class_128 var2 = (class_128)var1;
            return new class_135(var0.method_278(), var0.method_279().method_900(), var0.method_279().method_870(),
                    var0.method_279().method_872(), var0.method_279().method_876().getX(), var0.method_279().method_876().getY(),
                    var0.method_279().method_874(), var0.method_279().method_880(), var2.method_827(), var2.method_828(), var0.method_349());
        }
    }
}
