package com.a.b.a.a.b.e;

import com.a.b.a.a.b.BoringTeamInfo;
import com.a.b.a.a.b.d.c.CarPhysicalBody;
import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.Direction;
import com.a.c.a.Form;
import com.a.c.a.class_128;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import com.google.common.base.Preconditions;

// $FF: renamed from: com.a.b.a.a.b.e.b
public final class class_79 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, double, com.a.b.a.a.b.n) com.a.b.a.a.c.c
    public static Car carNextTick(CarPhysicalBody var0, double secondsPerTick, BoringTeamInfo team) {
        Form var4 = var0.getBody().getForm();
        if(!(var4 instanceof class_128)) {
            throw new IllegalArgumentException("Unsupported car form: " + var4 + '.');
        } else {
            class_128 var5 = (class_128)var4;
            IntPair nextWaypoint = var0.getNextWaypoint();
            Preconditions.checkNotNull(nextWaypoint.getFirst());
            Preconditions.checkNotNull(nextWaypoint.getSecond());
            return new Car(var0.getId(), var0.getBody().getMass(), var0.getBody().getX(),
                    var0.getBody().getY(), var0.getBody().getSpeed().getX() * secondsPerTick,
                    var0.getBody().getSpeed().getY() * secondsPerTick, var0.getBody().getAngle(),
                    var0.getBody().angularSpeed() * secondsPerTick, var5.getCarWidth(), var5.getCarHeight(),
                    var0.getBoringTeamInfo().getPlayerId(), var0.getTeammateIndex(),
                    var0.getBoringTeamInfo().equals(team), var0.type(),
                    var0.getProjectileCount(), var0.getNitroChangeCount(), var0.getOildCannisterCount(),
                    var0.getRemainingProjectilesCooldownTicks(), var0.getRemainingNitroCooldownTicks(), var0.getRemainingOilCooldownTicks(),
                    var0.getRemainingNitroTicks(), var0.getRemainingOiledTicks(), var0.getDurability(),
                    var0.getEnginePower(), var0.getWheelTurn(),
                    ((Integer)nextWaypoint.getFirst()).intValue(),
                    ((Integer)nextWaypoint.getSecond()).intValue(),
                    var0.isFinishedTrack());
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.e.i$a, int, int, int, int) com.codeforces.commons.geometry.Point2D
    public static Point2D getStartingDirectionLocation(class_86.class_206 var0, int var1, int var2, int var3, int var4) {
        method_484(var1, var2, var3, var4);
        Direction direction = var0.getDirection();
        IntPair var6 = var0.method_414()[0];
        double var7 = 16.0D;
        double var9 = 80.0D + var7 + 70.0D;
        double var11 = (140.0D + var7) * (double)(var4 * var2 + var1);
        Preconditions.checkNotNull(var6.getFirst());
        Preconditions.checkNotNull(var6.getSecond());
        switch(direction.ordinal()) {
        case 1:
            return new Point2D(800.0D * ((double) (Integer) var6.getFirst() + 0.5D), 800.0D * (double)((Integer) var6.getSecond() + 1) - var9 - var11);
        case 2:
            return new Point2D(800.0D * ((double) (Integer) var6.getFirst() + 0.5D), 800.0D * (double) (Integer) var6.getSecond() + var9 + var11);
        case 3:
            return new Point2D(800.0D * (double) (Integer) var6.getFirst() + var9 + var11, 800.0D * ((double) (Integer) var6.getSecond() + 0.5D));
        case 4:
            return new Point2D(800.0D * (double)((Integer) var6.getFirst() + 1) - var9 - var11, 800.0D * ((double) (Integer) var6.getSecond() + 0.5D));
        default:
            throw new IllegalArgumentException("Unsupported starting direction: " + var0.getDirection() + '.');
        }
    }

    // $FF: renamed from: b (com.a.b.a.a.b.e.i$a, int, int, int, int) double
    public static double getStartingDirectionAngle(class_86.class_206 var0, int var1, int var2, int var3, int var4) {
        method_484(var1, var2, var3, var4);
        switch(var0.getDirection().ordinal()) {
        case 1:
            return 3.141592653589793D;
        case 2:
            return 0.0D;
        case 3:
            return -1.5707963267948966D;
        case 4:
            return 1.5707963267948966D;
        default:
            throw new IllegalArgumentException("Unsupported starting direction: " + var0.getDirection() + '.');
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, com.a.b.a.a.b.n, double) void
    public static void method_479(CarPhysicalBody var0, BoringTeamInfo var1, double var2) {
        method_480(var0, var1, var2, 1.0D);
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, com.a.b.a.a.b.n, double, double) void
    public static void method_480(CarPhysicalBody var0, BoringTeamInfo var1, double var2, double var4) {
        if(!method_481(var0) && !var0.isFinishedTrack() && var2 > 0.0D) {
            byte var6 = 0;
            var2 = Math.min(var0.getDurability(), var2);
            int var7 = (int)((double)var6 + var2 * 100.0D);
            var0.setDurability(var0.getDurability() - var2);
            if(method_481(var0)) {
                var0.setDurability(0.0D);
                var0.setEnginePower(0.0D, false);
                var0.method_332(0);
                var0.method_338(0);
                var0.getBody().getMedianSpeed(new Vector2D(0.0D, 0.0D));
                var0.getBody().setMoreAngularSpeed(0.0D);
                var7 += 100;
            } else {
                var0.method_338(var0.method_337() + NumberUtil.toInt(var2 * 300.0D * var4));
            }

            if(var1 != null && var1.getPlayerId() != var0.getBoringTeamInfo().getPlayerId()) {
                var1.method_929(var7);
            }

        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b) boolean
    public static boolean method_481(CarPhysicalBody var0) {
        return method_483(var0.getDurability());
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c) boolean
    public static boolean method_482(Car var0) {
        return method_483(var0.getDurability());
    }

    // $FF: renamed from: a (double) boolean
    public static boolean method_483(double var0) {
        return var0 <= 1.0E-7D;
    }

    // $FF: renamed from: a (int, int, int, int) void
    private static void method_484(int var0, int var1, int var2, int var3) {
        if(var1 != 2 && var1 != 4) {
            throw new IllegalArgumentException(String.format("Argument \'teamCount\' should be either 2 or 4, but got %d.", var1));
        } else if(var0 >= 0 && var0 < var1) {
            if(var2 >= 1 && var2 <= 2) {
                if(var1 * var2 != 4) {
                    throw new IllegalArgumentException(String.format("Expected exactly 4 cars on the track, but got %d.", var1 * var2));
                } else if(var3 < 0 || var3 >= var2) {
                    throw new IllegalArgumentException(String.format("Argument \'carIndex\' should be non-negative and less than \'teamSize\', but got %d.", var3));
                }
            } else {
                throw new IllegalArgumentException(String.format("Argument \'teamSize\' should be in range of 1 to 2, but got %d.", var2));
            }
        } else {
            throw new IllegalArgumentException(String.format("Argument \'teamIndex\' should be non-negative and less than \'teamCount\', but got %d.", var0));
        }
    }
}
