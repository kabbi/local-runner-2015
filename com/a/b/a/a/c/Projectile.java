package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;

// $FF: renamed from: com.a.b.a.a.c.q
public class Projectile extends CircularUnit {
    private final long carId;
    private final long playerId;
    private final ProjectileType type;

    public Projectile(@Name("id") long var1, @Name("mass") double var3, @Name("x") double var5, @Name("y") double var7, @Name("speedX") double var9, @Name("speedY") double var11, @Name("angle") double var13, @Name("angularSpeed") double var15, @Name("radius") double var17, @Name("carId") long var19, @Name("playerId") long var21, @Name("type") ProjectileType var23) {
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

    public ProjectileType getType() {
        return this.type;
    }

    public static boolean areFieldEquals(Projectile a, Projectile b) {
        return a == b || a != null && b != null && CircularUnit.areFieldEquals(a, b) && a.type == b.type;
    }
}
