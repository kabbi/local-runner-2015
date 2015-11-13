package com.a.b.a.a.e.a;

import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;

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
    public void method_52(Game var1) {
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[], com.a.b.a.a.c.v) com.a.b.a.a.c.m[]
    public Move[] method_53(Car[] var1, World var2) {
        if(var1.length != this.field_770) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", this.getClass().getSimpleName(), var1.length, this.field_770));
        } else {
            return new Move[this.field_770];
        }
    }

    public void close() {
    }
}
