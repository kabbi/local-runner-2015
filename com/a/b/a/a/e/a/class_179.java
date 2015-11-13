package com.a.b.a.a.e.a;

import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;

import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.b.a.a.e.a.c
public class class_179 implements class_11 {
    // $FF: renamed from: a int
    private final int field_753;
    // $FF: renamed from: b com.a.b.a.a.e.a.c$a
    private final class_179.class_209 field_754;

    public class_179(int var1, class_179.class_209 var2) {
        this.field_753 = var1;
        this.field_754 = var2;
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
        if(var1.length != this.field_753) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", new Object[]{this.getClass().getSimpleName(), Integer.valueOf(var1.length), Integer.valueOf(this.field_753)}));
        } else {
            Move[] var3 = new Move[this.field_753];

            for(int var4 = 0; var4 < this.field_753; ++var4) {
                Car var5 = var1[var4];
                Move var6 = new Move();
                this.method_974(var5, var6);
                var3[var4] = var6;
            }

            return var3;
        }
    }

    public void close() {
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c, com.a.b.a.a.c.m) void
    private void method_974(Car var1, Move var2) {
        if(this.field_754.method_249(var1.getTeammateIndex())) {
            var2.setBrake(true);
        }

        if(this.field_754.method_245(var1.getTeammateIndex())) {
            var2.setEnginePower(1.0D);
        } else if(this.field_754.method_247(var1.getTeammateIndex())) {
            var2.setEnginePower(-1.0D);
        }

        if(this.field_754.method_251(var1.getTeammateIndex())) {
            var2.setWheelTurn(-1.0D);
        } else if(this.field_754.method_253(var1.getTeammateIndex())) {
            var2.setWheelTurn(1.0D);
        }

        if(this.field_754.method_255(var1.getTeammateIndex())) {
            var2.setThrowProjectile(true);
        }

        if(this.field_754.method_257(var1.getTeammateIndex())) {
            var2.setUseNitro(true);
        }

        if(this.field_754.method_259(var1.getTeammateIndex())) {
            var2.setSpillOil(true);
        }

    }

    public static final class class_209 {
        // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
        private final AtomicLong field_126 = new AtomicLong();

        // $FF: renamed from: a () long
        public long method_244() {
            return this.field_126.get();
        }

        // $FF: renamed from: a (int) boolean
        public boolean method_245(int var1) {
            return this.method_261(var1, 0);
        }

        // $FF: renamed from: a (int, boolean) void
        public void method_246(int var1, boolean var2) {
            this.method_262(var1, 0, var2);
        }

        // $FF: renamed from: b (int) boolean
        public boolean method_247(int var1) {
            return this.method_261(var1, 1);
        }

        // $FF: renamed from: b (int, boolean) void
        public void method_248(int var1, boolean var2) {
            this.method_262(var1, 1, var2);
        }

        // $FF: renamed from: c (int) boolean
        public boolean method_249(int var1) {
            return this.method_261(var1, 2);
        }

        // $FF: renamed from: c (int, boolean) void
        public void method_250(int var1, boolean var2) {
            this.method_262(var1, 2, var2);
        }

        // $FF: renamed from: d (int) boolean
        public boolean method_251(int var1) {
            return this.method_261(var1, 3);
        }

        // $FF: renamed from: d (int, boolean) void
        public void method_252(int var1, boolean var2) {
            this.method_262(var1, 3, var2);
        }

        // $FF: renamed from: e (int) boolean
        public boolean method_253(int var1) {
            return this.method_261(var1, 4);
        }

        // $FF: renamed from: e (int, boolean) void
        public void method_254(int var1, boolean var2) {
            this.method_262(var1, 4, var2);
        }

        // $FF: renamed from: f (int) boolean
        public boolean method_255(int var1) {
            return this.method_261(var1, 5);
        }

        // $FF: renamed from: f (int, boolean) void
        public void method_256(int var1, boolean var2) {
            this.method_262(var1, 5, var2);
        }

        // $FF: renamed from: g (int) boolean
        public boolean method_257(int var1) {
            return this.method_261(var1, 6);
        }

        // $FF: renamed from: g (int, boolean) void
        public void method_258(int var1, boolean var2) {
            this.method_262(var1, 6, var2);
        }

        // $FF: renamed from: h (int) boolean
        public boolean method_259(int var1) {
            return this.method_261(var1, 7);
        }

        // $FF: renamed from: h (int, boolean) void
        public void method_260(int var1, boolean var2) {
            this.method_262(var1, 7, var2);
        }

        // $FF: renamed from: a (int, int) boolean
        private boolean method_261(int var1, int var2) {
            method_265(var1);
            return this.method_263(var2 + var1 * 8);
        }

        // $FF: renamed from: a (int, int, boolean) void
        private void method_262(int var1, int var2, boolean var3) {
            method_265(var1);
            this.method_264(var2 + var1 * 8, var3);
        }

        // $FF: renamed from: i (int) boolean
        private boolean method_263(int var1) {
            return (this.method_244() & 1L << var1) != 0L;
        }

        // $FF: renamed from: i (int, boolean) void
        private void method_264(int var1, boolean var2) {
            long var3;
            long var5;
            do {
                var3 = this.method_244();
                var5 = var2?var3 | 1L << var1:var3 & ~(1L << var1);
            } while(!this.field_126.compareAndSet(var3, var5));

        }

        // $FF: renamed from: j (int) void
        private static void method_265(int var0) {
            if(var0 < 0 || var0 > 8) {
                throw new IllegalArgumentException("Unsupported teammate index: " + var0 + '.');
            }
        }
    }
}
