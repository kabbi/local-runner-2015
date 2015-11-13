package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.s
public abstract class RectangularUnit extends Unit {
    @Until(1.0D)
    private final double width;
    @Until(1.0D)
    private final double height;

    protected RectangularUnit(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("width") double var17, @Name("height") double var19) {
        super(var1, var3, var5, var7, var9, var11, var13, var15);
        this.width = var17;
        this.height = var19;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    protected static boolean areFieldEquals(RectangularUnit a, RectangularUnit b) {
        return Unit.areFieldEquals(a, b) && Double.compare(a.width, b.width) == 0 && Double.compare(a.height, b.height) == 0;
    }
}
