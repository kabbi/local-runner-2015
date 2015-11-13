package com.a.b.a.a.b.e;

import com.a.b.a.a.a.class_18;
import com.a.b.a.a.c.*;
import com.codeforces.commons.collection.CollectionUtil;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.reflection.ReflectionUtil;
import com.codeforces.commons.text.StringUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Until;
import com.google.inject.ConfigurationException;
import com.google.inject.spi.Message;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.b.e.d
public final class class_81 {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_300 = LoggerFactory.getLogger(class_81.class);
    // $FF: renamed from: b java.util.concurrent.ConcurrentMap
    private static final ConcurrentMap field_301 = new ConcurrentHashMap();
    // $FF: renamed from: c java.util.concurrent.ConcurrentMap
    private static final ConcurrentMap field_302 = new ConcurrentHashMap();
    // $FF: renamed from: d java.util.Set
    private final Set field_303;
    // $FF: renamed from: e java.util.Set
    private final Set field_304;
    // $FF: renamed from: f java.util.Set
    private final Set field_305;
    // $FF: renamed from: g java.lang.StringBuilder
    private final StringBuilder field_306;
    // $FF: renamed from: h com.a.b.a.a.a.b
    private final class_18 field_307;
    // $FF: renamed from: i boolean
    private final boolean field_308;
    // $FF: renamed from: j com.a.b.a.a.b.e.d$a
    private final class_81.class_223 field_309;
    // $FF: renamed from: k int
    private final int field_310;
    // $FF: renamed from: l int
    private final int field_311;
    // $FF: renamed from: m double
    private double field_312;
    // $FF: renamed from: n float
    private float field_313;
    // $FF: renamed from: o com.a.b.a.a.c.h
    private class_138 field_314;

    public class_81(class_18 var1, boolean var2, class_81.class_223 var3, int var4, int var5) {
        this.field_303 = new HashSet();
        this.field_304 = new HashSet();
        this.field_305 = new HashSet();
        this.field_306 = new StringBuilder(NumberUtil.toInt(262144L));
        if(var1 == null) {
            throw new IllegalArgumentException("Argument \'properties\' is null");
        } else if(var3 == null) {
            throw new IllegalArgumentException("Argument \'specialFloatingPointValueSerializationStrategy\' is null");
        } else if(var4 >= 1 && var4 <= 15) {
            if(var5 >= 1 && var5 <= 5) {
                this.field_307 = var1;
                this.field_308 = var2;
                this.field_309 = var3;
                this.field_310 = var4;
                this.field_311 = var5;
                this.field_312 = 10.0D;

                int var6;
                for(var6 = 1; var6 < var4; ++var6) {
                    this.field_312 *= 10.0D;
                }

                this.field_313 = 10.0F;

                for(var6 = 1; var6 < var5; ++var6) {
                    this.field_313 *= 10.0F;
                }

            } else {
                throw new IllegalArgumentException(String.format("Illegal value %d of argument \'maxFloatFractionalPartDigitCount\'.", var5));
            }
        } else {
            throw new IllegalArgumentException(String.format("Illegal value %d of argument \'maxDoubleFractionalPartDigitCount\'.", var4));
        }
    }

    public class_81(class_18 var1) {
        this(var1, false, class_81.class_223.field_522, 3, 3);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h) java.lang.String
    public String method_485(class_138 var1) {
        this.field_306.setLength(0);

        try {
            this.method_486(var1);
        } catch (IllegalAccessException var3) {
            throw new ConfigurationException(Collections.singletonList(new Message("Got unexpected exception while serializing world.", var3)));
        }

        if(this.field_314 != null) {
            if(var1.getTick() != this.field_314.getTick() + 1) {
                field_300.warn(String.format("Unexpected tick %d of previous world. Current tick is %d.", this.field_314.getTick(), var1.getTick()));
            }

            this.method_493(var1);
            this.method_495(var1);
        }

        this.field_314 = var1;
        return this.field_306.toString();
    }

    // $FF: renamed from: a (java.lang.Object) void
    private void method_486(Object var1) throws IllegalAccessException {
        Class var2 = var1.getClass();
        this.field_306.append('{');
        boolean var3 = this.method_487(var1, var2);
        boolean var4 = false;
        Iterator var5 = ReflectionUtil.getFieldsByNameMap(var2).entrySet().iterator();

        String var7;
        Until var11;
        do {
            while(true) {
                Field var9;
                Expose var10;
                do {
                    if(!var5.hasNext()) {
                        this.field_306.append('}');
                        return;
                    }

                    Entry var6 = (Entry)var5.next();
                    var7 = (String)var6.getKey();
                    List var8 = (List)var6.getValue();
                    if(var8.size() != 1) {
                        throw new ConfigurationException(Collections.singletonList(new Message(String.format("Zero or multiple fields with name \'%s\' in class \'%s\'.", var7, var2.getSimpleName()))));
                    }

                    var9 = (Field)var8.get(0);
                    var10 = var9.getAnnotation(Expose.class);
                } while(var10 != null && !var10.serialize());

                if(!var3) {
                    var11 = var9.getAnnotation(Until.class);
                    if(var11 != null) {
                        break;
                    }
                }

                int var12 = this.field_306.length();
                this.method_488(var1, var9, var4);
                var4 |= this.field_306.length() > var12;
            }
        } while(NumberUtil.equals(var11.value(), 1.0D));

        throw new ConfigurationException(Collections.singletonList(new Message(String.format("Unsupported value %s of @Until annotation on field \'%s\' of class \'%s\'.", var11.value(), var7, var2.getSimpleName()))));
    }

    // $FF: renamed from: a (java.lang.Object, java.lang.Class) boolean
    private boolean method_487(Object var1, Class var2) {
        if(var2 == class_138.class) {
            return ((World)var1).getTick() == 0;
        } else if(var2 == Player.class) {
            return this.field_303.add(((Player) var1).getId());
        } else if(Unit.class.isAssignableFrom(var2)) {
            return this.field_304.add(((Unit) var1).getId());
        } else if(var2 == class_151.class) {
            return this.field_305.add(((class_151) var1).getId());
        } else if(var2 != class_142.class && var2 != class_141.class) {
            throw new IllegalArgumentException("Unsupported class: " + var2 + '.');
        } else {
            return true;
        }
    }

    // $FF: renamed from: a (java.lang.Object, java.lang.reflect.Field, boolean) void
    private void method_488(Object var1, Field var2, boolean var3) throws IllegalAccessException {
        Class var4 = var2.getType();
        if(var4 == Boolean.class) {
            Boolean var21 = (Boolean)var2.get(var1);
            if(this.field_308 || var21 != null) {
                this.method_492(var2, var3).append(var21);
            }
        } else if(var4 == Boolean.TYPE) {
            this.method_492(var2, var3).append(var2.getBoolean(var1));
        } else if(var4 == Integer.class) {
            Integer var18 = (Integer)var2.get(var1);
            if(this.field_308 || var18 != null) {
                this.method_492(var2, var3).append(var18);
            }
        } else if(var4 == Integer.TYPE) {
            this.method_492(var2, var3).append(var2.getInt(var1));
        } else if(var4 == Long.class) {
            Long var17 = (Long)var2.get(var1);
            if(this.field_308 || var17 != null) {
                this.method_492(var2, var3).append(var17);
            }
        } else if(var4 == Long.TYPE) {
            this.method_492(var2, var3).append(var2.getLong(var1));
        } else {
            String var6;
            if(var4 != Float.class && var4 != Float.TYPE) {
                if(var4 != Double.class && var4 != Double.TYPE) {
                    if(var4 == String.class) {
                        String var15 = (String)var2.get(var1);
                        if(var15 == null) {
                            if(this.field_308) {
                                this.method_492(var2, var3).append("null");
                            }
                        } else {
                            this.method_492(var2, var3).append('\"').append(StringEscapeUtils.escapeJson(var15)).append('\"');
                        }
                    } else if(Enum.class.isAssignableFrom(var4)) {
                        Enum var14 = (Enum)var2.get(var1);
                        if(var14 == null) {
                            if(this.field_308) {
                                this.method_492(var2, var3).append("null");
                            }
                        } else {
                            this.method_492(var2, var3).append('\"').append(StringEscapeUtils.escapeJson(var14.name())).append('\"');
                        }
                    } else if(!Map.class.isAssignableFrom(var4)) {
                        Object var13 = var2.get(var1);
                        if(var13 == null) {
                            if(this.field_308) {
                                this.method_492(var2, var3).append("null");
                            }
                        } else if(var4.isArray()) {
                            this.method_492(var2, var3).append('[');
                            int var19 = Array.getLength(var13);
                            if(var19 > 0) {
                                this.method_489(Array.get(var13, 0), var2);

                                for(int var20 = 1; var20 < var19; ++var20) {
                                    this.field_306.append(',');
                                    this.method_489(Array.get(var13, var20), var2);
                                }
                            }

                            this.field_306.append(']');
                        } else {
                            this.method_492(var2, var3);
                            this.method_486(var2.get(var1));
                        }
                    } else {
                        Map var12 = (Map)var2.get(var1);
                        if(var12 == null) {
                            if(this.field_308) {
                                this.method_492(var2, var3).append("null");
                            }
                        } else {
                            this.method_492(var2, var3).append('{');
                            boolean var16 = true;
                            Iterator var7 = var12.entrySet().iterator();

                            while(true) {
                                if(!var7.hasNext()) {
                                    this.field_306.append('}');
                                    break;
                                }

                                Object var8 = var7.next();
                                Entry var9 = (Entry)var8;
                                String var10;
                                if(var9.getKey() == null || StringUtil.isBlank(var10 = var9.getKey().toString()) || StringUtil.trim(var10).length() != var10.length()) {
                                    throw new IllegalArgumentException(String.format("Illegal map key \'%s\' of field \'%s.%s\'.", new Object[]{var9.getKey(), var1.getClass().getSimpleName(), var2.getName()}));
                                }

                                if(this.field_308 || var9.getValue() != null) {
                                    if(var16) {
                                        var16 = false;
                                    } else {
                                        this.field_306.append(',');
                                    }

                                    this.field_306.append('\"').append(StringEscapeUtils.escapeJson(var10)).append("\":");
                                    this.method_489(var9.getValue(), var2);
                                }
                            }
                        }
                    }
                } else {
                    Double var11 = (Double)var2.get(var1);
                    if(var11 == null) {
                        if(this.field_308) {
                            this.method_492(var2, var3).append("null");
                        }
                    } else if(Double.isNaN(var11.doubleValue())) {
                        this.method_490(var1, var2, var11, var3, "NaN");
                    } else if(Double.isInfinite(var11.doubleValue())) {
                        var6 = var11 == Double.NEGATIVE_INFINITY?"-Infinity":"Infinity";
                        this.method_490(var1, var2, var11, var3, var6);
                    } else {
                        this.method_492(var2, var3).append(Math.round(var11 * this.field_312) / this.field_312);
                    }
                }
            } else {
                Float var5 = (Float)var2.get(var1);
                if(var5 == null) {
                    if(this.field_308) {
                        this.method_492(var2, var3).append("null");
                    }
                } else if(Float.isNaN(var5.floatValue())) {
                    this.method_490(var1, var2, var5, var3, "NaN");
                } else if(Float.isInfinite(var5.floatValue())) {
                    var6 = var5 == Float.NEGATIVE_INFINITY?"-Infinity":"Infinity";
                    this.method_490(var1, var2, var5, var3, var6);
                } else {
                    this.method_492(var2, var3).append(Math.round(var5 * this.field_313) / this.field_313);
                }
            }
        }

    }

    // $FF: renamed from: a (java.lang.Object, java.lang.reflect.Field) void
    private void method_489(Object var1, Field var2) throws IllegalAccessException {
        if(var1 == null) {
            this.field_306.append("null");
        } else {
            Class var3 = var1.getClass();
            if(var3 != Boolean.class && var3 != Boolean.TYPE && var3 != Byte.class && var3 != Byte.TYPE && var3 != Short.class && var3 != Short.TYPE && var3 != Integer.class && var3 != Integer.TYPE && var3 != Long.class && var3 != Long.TYPE) {
                String var4;
                if(var3 != Float.class && var3 != Float.TYPE) {
                    if(var3 != Double.class && var3 != Double.TYPE) {
                        if(Enum.class.isAssignableFrom(var3)) {
                            this.field_306.append('\"').append(StringEscapeUtils.escapeJson(((Enum)var1).name())).append('\"');
                        } else if(var3.isArray()) {
                            this.field_306.append('[');
                            int var6 = Array.getLength(var1);
                            if(var6 > 0) {
                                this.method_489(Array.get(var1, 0), var2);

                                for(int var5 = 1; var5 < var6; ++var5) {
                                    this.field_306.append(',');
                                    this.method_489(Array.get(var1, var5), var2);
                                }
                            }

                            this.field_306.append(']');
                        } else {
                            this.method_486(var1);
                        }
                    } else if(Double.isNaN(((Double)var1).doubleValue())) {
                        this.method_491(var2, var1, "NaN");
                    } else if(Double.isInfinite(((Double)var1).doubleValue())) {
                        var4 = var1.equals(Double.NEGATIVE_INFINITY)?"-Infinity":"Infinity";
                        this.method_491(var2, var1, var4);
                    } else {
                        this.field_306.append(Math.round((Double) var1 * this.field_312) / this.field_312);
                    }
                } else if(Float.isNaN(((Float)var1).floatValue())) {
                    this.method_491(var2, var1, "NaN");
                } else if(Float.isInfinite(((Float)var1).floatValue())) {
                    var4 = var1.equals(Float.NEGATIVE_INFINITY)?"-Infinity":"Infinity";
                    this.method_491(var2, var1, var4);
                } else {
                    this.field_306.append(Math.round((Float) var1 * this.field_313) / this.field_313);
                }
            } else {
                this.field_306.append(var1);
            }

        }
    }

    // $FF: renamed from: a (java.lang.Object, java.lang.reflect.Field, java.lang.Object, boolean, java.lang.String) void
    private void method_490(Object var1, Field var2, Object var3, boolean var4, String var5) {
        switch(this.field_309.ordinal()) {
        case 1:
            this.method_492(var2, var4).append(var5);
        case 2:
            break;
        case 3:
            throw new IllegalArgumentException(String.format("Can\'t serialize special floating point value \'%s\' of field \'%s.%s\'.", new Object[]{var3, var1.getClass().getSimpleName(), var2.getName()}));
        case 4:
            this.method_492(var2, var4).append("0.0");
            break;
        default:
            throw new IllegalArgumentException(String.format("Unsupported special floating point value serialization strategy: %s.", new Object[]{this.field_309}));
        }

    }

    // $FF: renamed from: a (java.lang.reflect.Field, java.lang.Object, java.lang.String) void
    private void method_491(Field var1, Object var2, String var3) {
        switch(this.field_309.ordinal()) {
        case 1:
            this.field_306.append(var3);
            break;
        case 2:
        case 3:
            throw new IllegalArgumentException(String.format("Can\'t serialize special floating point value \'%s\' of item of array/collection field \'%s.%s\'.", new Object[]{var2, var1.getDeclaringClass().getSimpleName(), var1.getName()}));
        case 4:
            this.field_306.append("0.0");
            break;
        default:
            throw new IllegalArgumentException(String.format("Unsupported special floating point value serialization strategy: %s.", new Object[]{this.field_309}));
        }

    }

    // $FF: renamed from: a (java.lang.reflect.Field, boolean) java.lang.StringBuilder
    private StringBuilder method_492(Field var1, boolean var2) {
        if(var2) {
            this.field_306.append(',');
        }

        return this.field_306.append('\"').append(var1.getName()).append("\":");
    }

    // $FF: renamed from: a (com.a.b.a.a.c.v) void
    private void method_493(World var1) {
        Map var2 = class_77.method_472(this.field_314);
        List var3 = method_494(var1);
        boolean var4 = this.field_307.method_90();
        Iterator var5 = var3.iterator();

        while(true) {
            Unit var6;
            do {
                if(!var5.hasNext()) {
                    return;
                }

                var6 = (Unit)var5.next();
            } while(!class_76.method_460(var6, (Unit)var2.get(var6.getId())));

            Pattern var7 = method_496(var6.getId());

            int var8;
            Matcher var9;
            for(var8 = 0; (var4 || var8 == 0) && (var9 = var7.matcher(this.field_306)).find(); ++var8) {
                this.field_306.replace(this.field_306.lastIndexOf("{", var9.start()) + 1, this.field_306.indexOf("}", var9.end()), "\"id\":" + var6.getId());
            }

            if(var8 != 1) {
                field_300.warn(String.format("Found %d matches for %s {id=%d} in the world\'s JSON-dump (tick=%d).", var8, var6.getClass().getSimpleName(), var6.getId(), var1.getTick()));
            }
        }
    }

    // $FF: renamed from: b (com.a.b.a.a.c.v) java.util.List
    private static List method_494(World var0) {
        Car[] var1 = var0.getCarsUnsafe();
        Projectile[] var2 = var0.getProjectilesUnsafe();
        Bonus[] var3 = var0.getBonusesUnsafe();
        OilSlick[] var4 = var0.getOilSlicksUnsafe();
        ArrayList var5 = new ArrayList(var1.length + var2.length + var3.length + var4.length);
        CollectionUtil.addAll(var5, var1);
        CollectionUtil.addAll(var5, var2);
        CollectionUtil.addAll(var5, var3);
        CollectionUtil.addAll(var5, var4);
        return var5;
    }

    // $FF: renamed from: c (com.a.b.a.a.c.v) void
    private void method_495(World var1) {
        Map var2 = class_77.method_471(this.field_314);
        boolean var3 = this.field_307.method_90();
        Player[] var4 = var1.getPlayersUnsafe();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Player var7 = var4[var6];
            if(Player.areFieldEquals(var7, (Player) var2.get(var7.getId()))) {
                Pattern var8 = method_497(var7.getId());

                int var9;
                Matcher var10;
                for(var9 = 0; (var3 || var9 == 0) && (var10 = var8.matcher(this.field_306)).find(); ++var9) {
                    this.field_306.replace(this.field_306.lastIndexOf("{", var10.start()) + 1, this.field_306.indexOf("}", var10.end()), "\"id\":" + var7.getId());
                }

                if(var9 != 1) {
                    field_300.warn(String.format("Found %d matches for %s {id=%d} in the world\'s JSON-dump (tick=%d).", var9, var7.getClass().getSimpleName(), var7.getId(), var1.getTick()));
                }
            }
        }

    }

    // $FF: renamed from: a (long) java.util.regex.Pattern
    private static Pattern method_496(long var0) {
        Pattern var2 = (Pattern)field_301.get(var0);
        if(var2 == null) {
            var2 = Pattern.compile("\"id\"\\s*:\\s*" + var0 + "\\s*,\\s*\"x\"\\s*:", 8);
            field_301.putIfAbsent(var0, var2);
        }

        return var2;
    }

    // $FF: renamed from: b (long) java.util.regex.Pattern
    private static Pattern method_497(long var0) {
        Pattern var2 = (Pattern)field_302.get(var0);
        if(var2 == null) {
            var2 = Pattern.compile("\"id\"\\s*:\\s*" + var0 + "\\s*,\\s*\"strategyCrashed\"\\s*:", 8);
            field_302.putIfAbsent(var0, var2);
        }

        return var2;
    }

    public enum class_223 {
        // $FF: renamed from: a com.a.b.a.a.b.e.d$a
        field_521,
        // $FF: renamed from: b com.a.b.a.a.b.e.d$a
        field_522,
        // $FF: renamed from: c com.a.b.a.a.b.e.d$a
        field_523,
        // $FF: renamed from: d com.a.b.a.a.b.e.d$a
        field_524
    }
}
