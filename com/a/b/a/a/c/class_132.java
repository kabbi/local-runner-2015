package com.a.b.a.a.c;

import com.a.b.a.a.c.class_131;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.c.n
public class class_132 extends class_131 {
    private final int remainingLifetime;

    public class_132(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("radius") double var17, @Name("remainingLifetime") int var19) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17);
        this.remainingLifetime = var19;
    }

    public int getRemainingLifetime() {
        return this.remainingLifetime;
    }

    public static boolean areFieldEquals(class_132 var0, class_132 var1) {
        return var0 == var1 || var0 != null && var1 != null && class_131.areFieldEquals(var0, var1) && var0.remainingLifetime == var1.remainingLifetime;
    }
}
