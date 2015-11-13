package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.e.class_79;
import java.util.Iterator;

// $FF: renamed from: com.a.b.a.a.b.b.c
public class class_21 implements class_2 {
    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(var3.hasNext()) {
            class_42 var4 = (class_42)var3.next();
            if(var4 instanceof class_43) {
                class_43 var5 = (class_43)var4;
                if(class_79.method_481(var5)) {
                    if(var5.method_302() == null) {
                        var5.method_303(var2 + 300);
                    }

                    if(var2 >= var5.method_302()) {
                        var5.method_303((Integer)null);
                        var5.method_301(1.0D);
                    }
                }
            }
        }

    }
}
