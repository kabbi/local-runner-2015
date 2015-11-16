package com.a.b.a.a.b.b;

import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.a.class_16;
import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.d.c.class_43;
import com.codeforces.commons.holder.Readable;
import com.codeforces.commons.holder.Writable;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

// $FF: renamed from: com.a.b.a.a.b.b.h
public class class_26 implements class_2 {
    // $FF: renamed from: a com.codeforces.commons.pair.IntPair[]
    private final IntPair[] field_92;
    // $FF: renamed from: b int
    private final int field_93;
    // $FF: renamed from: c int
    private final int field_94;
    // $FF: renamed from: d com.codeforces.commons.holder.Readable
    private final Readable field_95;
    // $FF: renamed from: e com.codeforces.commons.holder.Writable
    private final Writable field_96;
    // $FF: renamed from: f java.util.concurrent.atomic.AtomicInteger
    private final AtomicInteger field_97 = new AtomicInteger();

    public class_26(GameProperties var1, Readable var2, Writable var3) {
        this.field_92 = var1.method_79().method_414();
        this.field_93 = this.field_92.length;
        this.field_94 = NumberUtil.toInt(Math.floor(500.0D / (double)(this.field_93 - 1)));
        this.field_95 = var2;
        this.field_96 = var3;
    }

    // $FF: renamed from: a (com.a.b.h, int) void
    public void method_16(class_3 var1, int var2) {
        Iterator var3 = var1.method_19().iterator();

        while(var3.hasNext()) {
            class_42 var4 = (class_42)var3.next();
            if(var4 instanceof class_43) {
                class_43 var5 = (class_43)var4;
                if(!var5.method_345()) {
                    double var6 = var5.method_279().method_870();
                    double var8 = var5.method_279().method_872();
                    double var10 = 800.0D * (double) (Integer) var5.method_312().getFirst();
                    double var12 = 800.0D * (double) (Integer) var5.method_312().getSecond();
                    double var14 = var10 + 800.0D;
                    double var16 = var12 + 800.0D;
                    if(var6 >= var10 && var6 <= var14 && var8 >= var12 && var8 <= var16) {
                        var5.method_315((var5.method_314() + 1) % this.field_93);
                        var5.method_313(this.field_92[var5.method_314()]);
                        if(var5.method_314() == 1) {
                            var5.method_297().method_929(1000 - (this.field_93 - 1) * this.field_94);
                            var5.method_346((Integer) this.field_95.get());
                            if(var5.method_345()) {
                                var5.method_297().method_929(class_16.field_5[this.field_97.getAndIncrement()]);
                                this.field_96.set(var2);
                            }
                        } else {
                            var5.method_297().method_929(this.field_94);
                        }
                    }
                }
            }
        }

    }
}
