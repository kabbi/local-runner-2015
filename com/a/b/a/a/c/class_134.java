package com.a.b.a.a.c;

import com.a.b.a.a.c.class_130;
import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.s
public abstract class class_134 extends class_130 {
    @Until(1.0D)
    private final double width;
    @Until(1.0D)
    private final double height;

    protected class_134(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("width") double var17, @Name("height") double var19) {
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

    protected static boolean areFieldEquals(class_134 var0, class_134 var1) {
        return class_130.areFieldEquals(var0, var1) && Double.compare(var0.width, var1.width) == 0 && Double.compare(var0.height, var1.height) == 0;
    }
}
