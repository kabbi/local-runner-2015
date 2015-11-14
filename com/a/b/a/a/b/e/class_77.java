package com.a.b.a.a.b.e;

import com.a.a.a.a.class_121;
import com.a.b.RectangleBody;
import com.a.b.a.a.a.GameParatemers;
import com.a.b.a.a.b.BoringTeamInfo;
import com.a.b.a.a.b.a.class_124;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.b.class_51;
import com.a.b.a.a.b.d.c.CarPhysicalBody;
import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.b.d.e.Car;
import com.a.b.a.a.c.Unit;
import com.a.b.a.a.c.OilSlick;
import com.a.b.a.a.c.Projectile;
import com.a.b.a.a.c.Bonus;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.class_138;
import com.a.b.a.a.c.class_141;
import com.a.b.a.a.c.class_142;
import com.a.b.a.a.c.Player;
import com.a.b.a.a.c.class_151;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.pair.IntPair;
import com.codeforces.commons.reflection.ReflectionUtil;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.b.e.q
public final class class_77 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_296 = LoggerFactory.getLogger(class_77.class);
    // $FF: renamed from: b com.google.gson.Gson
    private static final Gson field_297 = (new GsonBuilder()).serializeSpecialFloatingPointValues().create();
    // $FF: renamed from: c java.util.concurrent.locks.Lock
    private static final Lock field_298 = new ReentrantLock();

    private class_77() {
        throw new UnsupportedOperationException();
    }

    // $FF: renamed from: a (int, int, int, int, int, double, java.util.List, com.a.b.a.a.a.b, java.util.List, com.a.b.a.a.b.n) com.a.b.a.a.c.v
    public static World method_461(int var0, int var1, int var2, int var3, int var4, double var5, List var7, GameParatemers var8, List var9, BoringTeamInfo var10) {
        ArrayList var11 = new ArrayList(4);
        ArrayList var12 = new ArrayList();
        ArrayList var13 = new ArrayList();
        ArrayList var14 = new ArrayList();
        Iterator var15 = var9.iterator();

        while(var15.hasNext()) {
            RectangleBody var16 = (RectangleBody)var15.next();
            if(var16 instanceof CarPhysicalBody) {
                var11.add(class_79.carNextTick((CarPhysicalBody) var16, var5, var10));
            } else if(var16 instanceof Car) {
                var12.add(class_75.method_459((Car)var16, var5));
            } else if(var16 instanceof class_47) {
                var13.add(class_78.method_475((class_47)var16));
            } else if(var16 instanceof class_46) {
                var14.add(class_88.method_516((class_46)var16));
            } else if(!(var16 instanceof class_51)) {
                throw new IllegalArgumentException("Unsupported unit class: " + var16.getClass() + '.');
            }
        }

        class_121.method_797(var11);
        class_121.method_797(var12);
        class_121.method_797(var13);
        class_121.method_797(var14);
        class_86.class_206 var21 = var8.method_79();
        IntPair[] var22 = var21.method_414();
        int var17 = var22.length;
        int[][] var18 = new int[var17][2];

        for(int var19 = 0; var19 < var17; ++var19) {
            IntPair var20 = var22[var19];
            Preconditions.checkNotNull(var20.getFirst());
            Preconditions.checkNotNull(var20.getSecond());
            var18[var19][0] = (Integer) var20.getFirst();
            var18[var19][1] = (Integer) var20.getSecond();
        }

        return new World(var0, var1, var2, var3, var4, class_72.method_454(var7, var10), (com.a.b.a.a.c.Car[])var11.toArray(new com.a.b.a.a.c.Car[var11.size()]), (Projectile[])var12.toArray(new Projectile[var12.size()]), (Bonus[])var13.toArray(new Bonus[var13.size()]), (OilSlick[])var14.toArray(new OilSlick[var14.size()]), var21.method_412(), var21.method_413(), var18, var21.getDirection());
    }

    // $FF: renamed from: a (com.a.b.a.a.c.v, java.lang.Long, double, boolean, java.util.List, java.util.List, java.util.List) com.a.b.a.a.c.h
    public static class_138 method_462(World var0, Long var1, double var2, boolean var4, List var5, List var6, List var7) {
        int var8 = var5.size();
        class_151[] var9 = new class_151[var8];

        for(int var10 = 0; var10 < var8; ++var10) {
            var9[var10] = class_83.method_498((class_124)var5.get(var10));
        }

        HashMap var17 = new HashMap();
        Iterator var11 = var7.iterator();

        while(var11.hasNext()) {
            RectangleBody var12 = (RectangleBody)var11.next();
            if(var12 instanceof CarPhysicalBody) {
                CarPhysicalBody var13 = (CarPhysicalBody)var12;
                Vector2D var14 = (new Vector2D(1.0D, 0.0D)).rotate(var13.getBody().getAngle());
                double var15 = var13.method_293().dotProduct(var14);
                var17.put(var13.getId(), new class_142(var13.method_291() == null?0.0D: var13.method_291(), var13.method_337() > 0? var13.method_337() :null, var13.method_340()? true :null, var15));
            }
        }

        HashMap var18 = null;
        Iterator var19 = var6.iterator();

        while(var19.hasNext()) {
            BoringTeamInfo var20 = (BoringTeamInfo)var19.next();
            if(var20.method_921()) {
                if(var18 == null) {
                    var18 = new HashMap();
                }

                var18.put(var20.getPlayerId(), new class_141(true));
            }
        }

        return new class_138(var0, var1, var2, var4, var9, var17, var18, var7);
    }

    // $FF: renamed from: a (java.lang.String, com.a.b.a.a.c.h, java.lang.Object) com.a.b.a.a.c.h
    public static class_138 method_463(String var0, class_138 var1, Object var2) {
        field_298.lock();

        class_138 var3;
        try {
            if(var1 != null) {
                JsonObject var11 = (JsonObject)field_297.fromJson(var0, JsonObject.class);
                method_464(field_297, var11, var1);
                method_465(field_297, var11, var1);
                method_466(field_297, var11, var1);
                method_467(field_297, var11, var1);
                method_468(field_297, var11, var1);
                method_469(field_297, var11, var1);
                class_138 var4 = (class_138)field_297.fromJson((JsonElement)var11, (Class)class_138.class);
                method_474(var4, var2);
                class_138 var5 = var4;
                return var5;
            }

            var3 = (class_138)field_297.fromJson(var0, class_138.class);
        } catch (RuntimeException var9) {
            field_296.error(String.format("Can\'t de-serialize decorated world. Input string: %s.", var0));
            throw var9;
        } finally {
            field_298.unlock();
        }

        return var3;
    }

    // $FF: renamed from: a (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_464(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = ReflectionUtil.getFieldsByNameMap(class_138.class);
        Iterator var4 = var3.entrySet().iterator();

        while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            String var6 = (String)var5.getKey();
            if(var1.get(var6) == null && !"systemData".equals(var6)) {
                method_470(var0, var1, var2, (Field)((List)var5.getValue()).get(0));
            }
        }

    }

    // $FF: renamed from: b (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_465(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = method_471(var2);
        Map var4 = ReflectionUtil.getFieldsByNameMap(Player.class);
        Iterator var5 = var1.getAsJsonArray("players").iterator();

        while(true) {
            JsonObject var7;
            Player var10;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                JsonElement var6 = (JsonElement)var5.next();
                var7 = var6.getAsJsonObject();
                long var8 = var7.get("id").getAsLong();
                var10 = (Player)var3.get(var8);
            } while(var10 == null);

            Iterator var11 = var4.entrySet().iterator();

            while(var11.hasNext()) {
                Entry var12 = (Entry)var11.next();
                if(var7.get((String)var12.getKey()) == null) {
                    method_470(var0, var7, var10, (Field)((List)var12.getValue()).get(0));
                }
            }
        }
    }

    // $FF: renamed from: c (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_466(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = method_473(var2.getCarsUnsafe());
        Map var4 = ReflectionUtil.getFieldsByNameMap(com.a.b.a.a.c.Car.class);
        Iterator var5 = var1.getAsJsonArray("cars").iterator();

        while(true) {
            JsonObject var7;
            com.a.b.a.a.c.Car var10;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                JsonElement var6 = (JsonElement)var5.next();
                var7 = var6.getAsJsonObject();
                long var8 = var7.get("id").getAsLong();
                var10 = (com.a.b.a.a.c.Car)var3.get(var8);
            } while(var10 == null);

            Iterator var11 = var4.entrySet().iterator();

            while(var11.hasNext()) {
                Entry var12 = (Entry)var11.next();
                if(var7.get((String)var12.getKey()) == null) {
                    method_470(var0, var7, var10, (Field)((List)var12.getValue()).get(0));
                }
            }
        }
    }

    // $FF: renamed from: d (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_467(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = method_473(var2.getProjectilesUnsafe());
        Map var4 = ReflectionUtil.getFieldsByNameMap(Projectile.class);
        Iterator var5 = var1.getAsJsonArray("projectiles").iterator();

        while(true) {
            JsonObject var7;
            Projectile var10;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                JsonElement var6 = (JsonElement)var5.next();
                var7 = var6.getAsJsonObject();
                long var8 = var7.get("id").getAsLong();
                var10 = (Projectile)var3.get(var8);
            } while(var10 == null);

            Iterator var11 = var4.entrySet().iterator();

            while(var11.hasNext()) {
                Entry var12 = (Entry)var11.next();
                if(var7.get((String)var12.getKey()) == null) {
                    method_470(var0, var7, var10, (Field)((List)var12.getValue()).get(0));
                }
            }
        }
    }

    // $FF: renamed from: e (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_468(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = method_473(var2.getBonusesUnsafe());
        Map var4 = ReflectionUtil.getFieldsByNameMap(Bonus.class);
        Iterator var5 = var1.getAsJsonArray("bonuses").iterator();

        while(true) {
            JsonObject var7;
            Bonus var10;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                JsonElement var6 = (JsonElement)var5.next();
                var7 = var6.getAsJsonObject();
                long var8 = var7.get("id").getAsLong();
                var10 = (Bonus)var3.get(var8);
            } while(var10 == null);

            Iterator var11 = var4.entrySet().iterator();

            while(var11.hasNext()) {
                Entry var12 = (Entry)var11.next();
                if(var7.get((String)var12.getKey()) == null) {
                    method_470(var0, var7, var10, (Field)((List)var12.getValue()).get(0));
                }
            }
        }
    }

    // $FF: renamed from: f (com.google.gson.Gson, com.google.gson.JsonObject, com.a.b.a.a.c.h) void
    private static void method_469(Gson var0, JsonObject var1, class_138 var2) {
        Map var3 = method_473(var2.getOilSlicksUnsafe());
        Map var4 = ReflectionUtil.getFieldsByNameMap(OilSlick.class);
        Iterator var5 = var1.getAsJsonArray("oilSlicks").iterator();

        while(true) {
            JsonObject var7;
            OilSlick var10;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                JsonElement var6 = (JsonElement)var5.next();
                var7 = var6.getAsJsonObject();
                long var8 = var7.get("id").getAsLong();
                var10 = (OilSlick)var3.get(var8);
            } while(var10 == null);

            Iterator var11 = var4.entrySet().iterator();

            while(var11.hasNext()) {
                Entry var12 = (Entry)var11.next();
                if(var7.get((String)var12.getKey()) == null) {
                    method_470(var0, var7, var10, (Field)((List)var12.getValue()).get(0));
                }
            }
        }
    }

    // $FF: renamed from: a (com.google.gson.Gson, com.google.gson.JsonObject, java.lang.Object, java.lang.reflect.Field) void
    private static void method_470(Gson var0, JsonObject var1, Object var2, Field var3) {
        try {
            var1.add(var3.getName(), var0.toJsonTree(var3.get(var2)));
        } catch (IllegalAccessException var5) {
            field_296.error(String.format("Can\'t read field \'%s\' of previous %s.", var3.getName(), var2.getClass().getSimpleName()), var5);
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.h) java.util.Map
    public static Map method_471(class_138 var0) {
        Player[] var1 = var0.getPlayersUnsafe();
        int var2 = var1.length;
        HashMap var3 = new HashMap();

        for(int var4 = 0; var4 < var2; ++var4) {
            Player var5 = var1[var4];
            var3.put(var5.getId(), var5);
        }

        return Collections.unmodifiableMap(var3);
    }

    // $FF: renamed from: b (com.a.b.a.a.c.h) java.util.Map
    public static Map method_472(class_138 var0) {
        HashMap var1 = new HashMap();
        com.a.b.a.a.c.Car[] var2 = var0.getCarsUnsafe();
        int var3 = var2.length;

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            com.a.b.a.a.c.Car var5 = var2[var4];
            var1.put(var5.getId(), var5);
        }

        Projectile[] var6 = var0.getProjectilesUnsafe();
        var3 = var6.length;

        for(var4 = 0; var4 < var3; ++var4) {
            Projectile var9 = var6[var4];
            var1.put(var9.getId(), var9);
        }

        Bonus[] var7 = var0.getBonusesUnsafe();
        var3 = var7.length;

        for(var4 = 0; var4 < var3; ++var4) {
            Bonus var10 = var7[var4];
            var1.put(var10.getId(), var10);
        }

        OilSlick[] var8 = var0.getOilSlicksUnsafe();
        var3 = var8.length;

        for(var4 = 0; var4 < var3; ++var4) {
            OilSlick var11 = var8[var4];
            var1.put(var11.getId(), var11);
        }

        return Collections.unmodifiableMap(var1);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.u[]) java.util.Map
    private static Map method_473(Unit[] var0) {
        int var1 = var0.length;
        HashMap var2 = new HashMap(var1);

        for(int var3 = 0; var3 < var1; ++var3) {
            Unit var4 = var0[var3];
            var2.put(var4.getId(), var4);
        }

        return Collections.unmodifiableMap(var2);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, java.lang.Object) void
    private static void method_474(class_138 var0, Object var1) {
        if(var1 != null) {
            try {
                ((Field)((List)ReflectionUtil.getFieldsByNameMap(class_138.class).get("systemData")).get(0)).set(var0, var1);
            } catch (IllegalAccessException var3) {
                field_296.error("Can\'t set field \'systemData\' of decorated world.", var3);
            }
        }

    }
}
