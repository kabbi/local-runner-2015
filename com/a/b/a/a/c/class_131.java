package com.a.b.a.a.c;

import com.a.b.a.a.c.class_130;
import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.e
public abstract class class_131 extends class_130 {
    @Until(1.0D)
    private final double radius;

    protected class_131(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("radius") double var17) {
        super(var1, var3, var5, var7, var9, var11, var13, var15);
        this.radius = var17;
    }

    public double getRadius() {
        return this.radius;
    }

    protected static boolean areFieldEquals(class_131 var0, class_131 var1) {
        return class_130.areFieldEquals(var0, var1) && Double.compare(var0.radius, var1.radius) == 0;
    }
}
