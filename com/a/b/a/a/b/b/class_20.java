package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.c.class_148;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.a.b.a.a.b.b.b
public class class_20 implements class_2 {
    // $FF: renamed from: a java.util.Map
    private Map field_82;

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        HashMap var3 = new HashMap();
        Iterator var4 = var1.method_19().iterator();

        while(var4.hasNext()) {
            class_42 var5 = (class_42)var4.next();
            if(var5 instanceof class_43) {
                class_43 var6 = (class_43)var5;
                var3.put(var6.method_278(), var6.method_300());
                if(this.field_82 != null) {
                    Double var7 = (Double)this.field_82.get(var6.method_278());
                    if(var7 != null && !NumberUtil.equals(var6.method_300(), var7)) {
                        int var8 = NumberUtil.toInt(Math.floor(var6.method_300() * 100.0D) - Math.floor(var7 * 100.0D));
                        if(var8 != 0) {
                            HashMap var9 = new HashMap();
                            var9.put("durabilityPercentsChange", var8);
                            var1.method_20(new class_124(class_148.CAR_CONDITION_CHANGE, var2, var6, var9));
                        }
                    }
                }
            }
        }

        this.field_82 = var3;
    }
}
