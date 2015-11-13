package com.a.b.a.a.b.d.c;

import com.a.b.class_42;
import com.a.b.a.a.b.class_171;
import com.a.b.a.a.c.class_143;
import com.a.c.a.class_128;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.IntPair;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.b.a.a.b.d.c.b
public abstract class class_43 extends class_42 {
    // $FF: renamed from: a com.a.b.a.a.b.n
    @Name("player")
    private final class_171 field_157;
    // $FF: renamed from: b int
    private final int field_158;
    // $FF: renamed from: c com.a.b.a.a.c.d
    @Name("type")
    private final class_143 field_159;
    // $FF: renamed from: d double
    private double field_160;
    // $FF: renamed from: e java.lang.Integer
    private Integer field_161;
    // $FF: renamed from: f double
    private double field_162;
    // $FF: renamed from: g double
    private double field_163;
    // $FF: renamed from: h double
    private final double field_164;
    // $FF: renamed from: i double
    private final double field_165;
    // $FF: renamed from: j com.codeforces.commons.pair.IntPair
    private IntPair field_166;
    // $FF: renamed from: k int
    private int field_167;
    // $FF: renamed from: l int
    private int field_168;
    // $FF: renamed from: m int
    private int field_169;
    // $FF: renamed from: n int
    private int field_170;
    // $FF: renamed from: o int
    private int field_171;
    // $FF: renamed from: p int
    private int field_172;
    // $FF: renamed from: q int
    private int field_173;
    // $FF: renamed from: r int
    private int field_174;
    // $FF: renamed from: s int
    private int field_175;
    // $FF: renamed from: t int
    private int field_176;
    // $FF: renamed from: u boolean
    private boolean field_177;
    // $FF: renamed from: v java.lang.Integer
    private Integer field_178;
    // $FF: renamed from: w int
    private int field_179;
    // $FF: renamed from: x java.lang.Integer
    private Integer field_180;

    protected class_43(class_171 var1, int var2, class_143 var3, double var4, double var6, double var8, double var10, double var12, double var14, IntPair var16) {
        super(new class_128(210.0D, 140.0D));
        if(!Double.isNaN(var10) && !Double.isInfinite(var10) && var10 > 0.0D) {
            this.field_157 = var1;
            this.field_158 = var2;
            this.field_159 = var3;
            this.field_160 = 1.0D;
            this.field_162 = 0.0D;
            this.field_163 = 0.0D;
            this.field_164 = var12;
            this.field_165 = var14;
            this.field_166 = new IntPair(var16);
            this.field_167 = 1;
            this.field_168 = 1;
            this.field_169 = 1;
            this.field_170 = 1;
            this.method_279().method_871(var4);
            this.method_279().method_873(var6);
            this.method_279().method_875(var8);
            this.method_279().method_901(var10);
            this.method_279().method_887(0.0075D);
            this.method_279().method_889(0.0075D);
            this.method_279().method_891(0.001D);
            this.method_279().method_893(0.25D);
            this.method_279().method_895(0.008726646259971648D);
            this.method_279().method_897(0.5D);
            this.method_279().method_899(0.25D);
        } else {
            throw new IllegalArgumentException("Argument \'mass\' is not a positive number.");
        }
    }

    // $FF: renamed from: k () com.a.b.a.a.b.n
    public class_171 method_297() {
        return this.field_157;
    }

    // $FF: renamed from: l () int
    public int method_298() {
        return this.field_158;
    }

    // $FF: renamed from: m () com.a.b.a.a.c.d
    public class_143 method_299() {
        return this.field_159;
    }

    // $FF: renamed from: n () double
    public double method_300() {
        return this.field_160;
    }

    // $FF: renamed from: a (double) void
    public void method_301(double var1) {
        this.field_160 = var1;
    }

    // $FF: renamed from: o () java.lang.Integer
    public Integer method_302() {
        return this.field_161;
    }

    // $FF: renamed from: a (java.lang.Integer) void
    public void method_303(Integer var1) {
        this.field_161 = var1;
    }

    // $FF: renamed from: p () double
    public double method_304() {
        return this.field_162;
    }

    // $FF: renamed from: a (double, boolean) void
    public void method_305(double var1, boolean var3) {
        this.field_162 = Math.min(Math.max(var1, -1.0D), var3?2.0D:1.0D);
    }

    // $FF: renamed from: b (double) void
    public void method_306(double var1) {
        this.method_305(this.field_162, false);
        var1 = Math.min(Math.max(var1, -1.0D), 1.0D);
        double var3 = var1 - this.field_162;
        if(var3 > 0.025D) {
            var3 = 0.025D;
        } else if(var3 < -0.025D) {
            var3 = -0.025D;
        }

        this.method_305(this.field_162 + var3, false);
    }

    // $FF: renamed from: q () double
    public double method_307() {
        return this.field_163;
    }

    // $FF: renamed from: c (double) void
    public void method_308(double var1) {
        this.field_163 = Math.min(Math.max(var1, -1.0D), 1.0D);
    }

    // $FF: renamed from: d (double) void
    public void method_309(double var1) {
        this.method_308(this.field_163);
        var1 = Math.min(Math.max(var1, -1.0D), 1.0D);
        double var3 = var1 - this.field_163;
        if(var3 > 0.05D) {
            var3 = 0.05D;
        } else if(var3 < -0.05D) {
            var3 = -0.05D;
        }

        this.method_308(this.field_163 + var3);
    }

    // $FF: renamed from: r () double
    public double method_310() {
        return this.field_164;
    }

    // $FF: renamed from: s () double
    public double method_311() {
        return this.field_165;
    }

    // $FF: renamed from: t () com.codeforces.commons.pair.IntPair
    public IntPair method_312() {
        return new IntPair(this.field_166);
    }

    // $FF: renamed from: a (com.codeforces.commons.pair.IntPair) void
    public void method_313(IntPair var1) {
        this.field_166 = new IntPair(var1);
    }

    // $FF: renamed from: u () int
    public int method_314() {
        return this.field_167;
    }

    // $FF: renamed from: c (int) void
    public void method_315(int var1) {
        this.field_167 = var1;
    }

    // $FF: renamed from: v () int
    public int method_316() {
        return this.field_168;
    }

    // $FF: renamed from: d (int) void
    public void method_317(int var1) {
        this.field_168 = var1;
    }

    // $FF: renamed from: w () int
    public int method_318() {
        return this.field_169;
    }

    // $FF: renamed from: e (int) void
    public void method_319(int var1) {
        this.field_169 = var1;
    }

    // $FF: renamed from: x () int
    public int method_320() {
        return this.field_170;
    }

    // $FF: renamed from: f (int) void
    public void method_321(int var1) {
        this.field_170 = var1;
    }

    // $FF: renamed from: y () int
    public int method_322() {
        return this.field_171;
    }

    // $FF: renamed from: g (int) void
    public void method_323(int var1) {
        this.field_171 = var1;
    }

    // $FF: renamed from: z () void
    public void method_324() {
        if(this.field_171 > 0) {
            --this.field_171;
        }

    }

    // $FF: renamed from: A () int
    public int method_325() {
        return this.field_172;
    }

    // $FF: renamed from: h (int) void
    public void method_326(int var1) {
        this.field_172 = var1;
    }

    // $FF: renamed from: B () void
    public void method_327() {
        if(this.field_172 > 0) {
            --this.field_172;
        }

    }

    // $FF: renamed from: C () int
    public int method_328() {
        return this.field_173;
    }

    // $FF: renamed from: i (int) void
    public void method_329(int var1) {
        this.field_173 = var1;
    }

    // $FF: renamed from: D () void
    public void method_330() {
        if(this.field_173 > 0) {
            --this.field_173;
        }

    }

    // $FF: renamed from: E () int
    public int method_331() {
        return this.field_174;
    }

    // $FF: renamed from: j (int) void
    public void method_332(int var1) {
        this.field_174 = var1;
    }

    // $FF: renamed from: F () void
    public void method_333() {
        if(this.field_174 > 0) {
            --this.field_174;
        }

    }

    // $FF: renamed from: G () int
    public int method_334() {
        return this.field_175;
    }

    // $FF: renamed from: k (int) void
    public void method_335(int var1) {
        this.field_175 = var1;
    }

    // $FF: renamed from: H () void
    public void method_336() {
        if(this.field_175 > 0) {
            --this.field_175;
        }

    }

    // $FF: renamed from: I () int
    public int method_337() {
        return this.field_176;
    }

    // $FF: renamed from: l (int) void
    public void method_338(int var1) {
        this.field_176 = var1;
    }

    // $FF: renamed from: J () void
    public void method_339() {
        if(this.field_176 > 0) {
            --this.field_176;
        }

    }

    // $FF: renamed from: K () boolean
    public boolean method_340() {
        return this.field_177;
    }

    // $FF: renamed from: a (boolean) void
    public void method_341(boolean var1) {
        this.field_177 = var1;
    }

    // $FF: renamed from: L () java.lang.Integer
    public Integer method_342() {
        return this.field_178;
    }

    // $FF: renamed from: b (java.lang.Integer) void
    public void method_343(Integer var1) {
        this.field_178 = var1;
    }

    // $FF: renamed from: M () java.lang.Integer
    public Integer method_344() {
        return this.field_180;
    }

    // $FF: renamed from: N () boolean
    public boolean method_345() {
        return this.field_180 != null;
    }

    // $FF: renamed from: m (int) void
    public void method_346(int var1) {
        ++this.field_168;
        ++this.field_169;
        ++this.field_170;
        ++this.field_179;
        if(this.field_179 >= 4) {
            this.field_180 = var1;
        }

    }

    public String toString() {
        return StringUtil.toString(this, false, "id", "player.name", "type");
    }
}
