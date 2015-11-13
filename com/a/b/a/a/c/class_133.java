package com.a.b.a.a.c;

import com.a.b.a.a.c.class_131;
import com.a.b.a.a.c.class_140;
import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.c.q
public class class_133 extends class_131 {
    private final long carId;
    private final long playerId;
    private final class_140 type;

    public class_133(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("radius") double var17, @Name("carId") long var19, @Name("playerId") long var21, @Name("type") class_140 var23) {
        super(var1, var3, var5, var7, var9, var11, var13, var15, var17);
        this.carId = var19;
        this.playerId = var21;
        this.type = var23;
    }

    public long getCarId() {
        return this.carId;
    }

    public long getPlayerId() {
        return this.playerId;
    }

    public class_140 getType() {
        return this.type;
    }

    public static boolean areFieldEquals(class_133 var0, class_133 var1) {
        return var0 == var1 || var0 != null && var1 != null && class_131.areFieldEquals(var0, var1) && var0.type == var1.type;
    }
}
