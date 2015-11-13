package com.a.b.a.a.c;

import com.a.b.a.a.c.class_134;
import com.a.b.a.a.c.class_144;
import com.codeforces.commons.reflection.Name;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.a
public class class_135 extends class_134 {
    @Until(1.0D)
    private final class_144 type;

    public class_135(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("width") double var17, @Name("height") double var19, @Name("type") class_144 var21) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17, var19);
        this.type = var21;
    }

    public class_144 getType() {
        return this.type;
    }

    public static boolean areFieldEquals(class_135 var0, class_135 var1) {
        return var0 == var1 || var0 != null && var1 != null && class_134.areFieldEquals(var0, var1) && var0.type == var1.type;
    }
}
