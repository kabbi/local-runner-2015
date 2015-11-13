package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.a
public class Bonus extends RectangularUnit {
    @Until(1.0D)
    private final BonusType type;

    public Bonus(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("width") double var17, @Name("height") double var19, @Name("type") BonusType var21) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17, var19);
        this.type = var21;
    }

    public BonusType getType() {
        return this.type;
    }

    public static boolean areFieldEquals(Bonus a, Bonus b) {
        return a == b || a != null && b != null && RectangularUnit.areFieldEquals(a, b) && a.type == b.type;
    }
}
