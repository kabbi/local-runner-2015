package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.c.n
public class OilSlick extends CircularUnit {
    private final int remainingLifetime;

    public OilSlick(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("radius") double var17, @Name("remainingLifetime") int var19) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17);
        this.remainingLifetime = var19;
    }

    public int getRemainingLifetime() {
        return this.remainingLifetime;
    }

    public static boolean areFieldEquals(OilSlick a, OilSlick b) {
        return a == b || a != null && b != null && CircularUnit.areFieldEquals(a, b) && a.remainingLifetime == b.remainingLifetime;
    }
}
