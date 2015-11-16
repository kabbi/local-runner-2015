package com.a.b.a.a.b.b;

import com.a.a.a.a.RandomUtils;
import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.b.d.a.class_47;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import java.util.Iterator;

// $FF: renamed from: com.a.b.a.a.b.b.a
public class class_19 implements class_2 {
    // $FF: renamed from: a com.codeforces.commons.pair.IntPair[]
    private final IntPair[] field_80;
    // $FF: renamed from: b java.lang.Runnable
    private final Runnable field_81;

    public class_19(IntPair[] var1, Runnable var2) {
        this.field_80 = var1;
        this.field_81 = var2;
    }

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        int var3 = 0;
        Iterator var4 = var1.method_19().iterator();

        while(var4.hasNext()) {
            class_42 var5 = (class_42)var4.next();
            if(var5 instanceof class_47) {
                ++var3;
            }
        }

        int var6 = NumberUtil.toInt(Math.floor(0.25D * (double)this.field_80.length));
        if(var3 < var6 && RandomUtils.randomDouble() < 0.0015D) {
            this.field_81.run();
        }

    }
}
