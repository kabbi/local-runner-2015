package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.b.d.e.class_48;
import com.a.c.class_159;
import java.util.Iterator;

// $FF: renamed from: com.a.b.a.a.b.b.e
public class class_23 implements class_2 {
    // $FF: renamed from: a double
    private final double field_87 = -4000.0D;
    // $FF: renamed from: b double
    private final double field_88 = -4000.0D;
    // $FF: renamed from: c double
    private final double field_89;
    // $FF: renamed from: d double
    private final double field_90;

    public class_23(int var1, int var2) {
        this.field_89 = (double)(var1 + 5) * 800.0D;
        this.field_90 = (double)(var2 + 5) * 800.0D;
    }

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(true) {
            class_48 var5;
            class_159 var6;
            do {
                class_42 var4;
                do {
                    if(!var3.hasNext()) {
                        return;
                    }

                    var4 = (class_42)var3.next();
                } while(!(var4 instanceof class_48));

                var5 = (class_48)var4;
                var6 = var5.method_279();
            } while(var6.method_870() >= this.field_87 && var6.method_872() >= this.field_88 && var6.method_870() < this.field_89 && var6.method_872() < this.field_90);

            var1.method_18(var5);
        }
    }
}
