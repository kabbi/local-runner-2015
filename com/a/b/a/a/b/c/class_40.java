package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.class_171;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.c.class_148;
import com.codeforces.commons.holder.Readable;

// $FF: renamed from: com.a.b.a.a.b.c.c
public class class_40 extends class_34 {
    // $FF: renamed from: a com.codeforces.commons.holder.Readable
    private final Readable field_145;

    public class_40(Readable var1) {
        this.field_145 = var1;
    }

    public boolean beforeResolvingCollision(class_58 var1) {
        class_43 var2 = (class_43)var1.method_362();
        double var3 = var1.method_365().copyNegate().dotProduct(var2.method_279().method_876());
        if(var3 > 0.0D) {
            double var5 = var3 * 0.003D;
            if(var5 > 0.01D) {
                class_79.method_480(var2, (class_171)null, var5, 2.0D);
                var1.method_361().method_20(new class_124(class_148.CAR_AND_BORDER_IMPACT, ((Integer)this.field_145.get()).intValue(), var1.method_364().getX(), var1.method_364().getY(), 0.0D));
            }
        }

        return true;
    }
}
