package com.a.b.a.a.e.a;

import com.a.b.a.a.c.class_136;
import com.a.b.a.a.c.class_137;
import com.a.b.a.a.c.class_147;
import com.a.b.a.a.c.class_149;
import com.a.b.a.a.e.a.class_11;

// $FF: renamed from: com.a.b.a.a.e.a.b
public class class_182 implements class_11 {
    // $FF: renamed from: a int
    private final int field_770;

    public class_182(int var1) {
        this.field_770 = var1;
    }

    // $FF: renamed from: a () int
    public int method_51() {
        return 1;
    }

    // $FF: renamed from: a (com.a.b.a.a.c.l) void
    public void method_52(class_149 var1) {
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[], com.a.b.a.a.c.v) com.a.b.a.a.c.m[]
    public class_147[] method_53(class_136[] var1, class_137 var2) {
        if(var1.length != this.field_770) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", this.getClass().getSimpleName(), var1.length, this.field_770));
        } else {
            return new class_147[this.field_770];
        }
    }

    public void close() {
    }
}
