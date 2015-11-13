package com.a.a.a.a;

import com.codeforces.commons.reflection.ReflectionUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Primitives;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.a.a.a.a.d
public class class_123 {
    // $FF: renamed from: a java.util.Set
    private static final Set field_516 = ImmutableSet.of(Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, new Class[]{Float.TYPE, Double.TYPE});
    // $FF: renamed from: b java.util.Set
    private static final Set field_517 = ImmutableSet.of(Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, new Class[]{Float.class, Double.class});

    // $FF: renamed from: a (java.lang.Object, java.lang.Class) java.lang.Object
    public static Object method_799(Object var0, Class var1) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if(var0 == null) {
            if(field_516.contains(var1)) {
                throw new IllegalArgumentException("Can\'t get null object as primitive class.");
            } else {
                return null;
            }
        } else {
            Class var2 = var0.getClass();
            boolean var3 = field_516.contains(var2);
            boolean var4 = field_517.contains(var2);
            if((var3 || var4 || var2 == String.class) && (var2 == var1 || var3 && Primitives.wrap(var2) == var1 || var4 && Primitives.unwrap(var2) == var1)) {
                return var0;
            } else if(var2.isEnum() && var1.isEnum()) {
                return method_800(var0, var1, var2);
            } else if(var2.isArray() && var1.isArray()) {
                return method_801(var0, var1);
            } else {
                Constructor[] var5 = var1.getConstructors();
                if(var5.length != 1) {
                    throw new IllegalArgumentException("Too many constructors in target class \'" + var1 + "\'.");
                } else {
                    Constructor var6 = var5[0];
                    Class[] var7 = var6.getParameterTypes();
                    int var8 = var7.length;
                    Map var9 = ReflectionUtil.getFieldsByNameMap(var2);
                    int var10 = var9.size();
                    if(var10 != var8) {
                        while(var10 > var8 && (var2 = var2.getSuperclass()) != null) {
                            var9 = ReflectionUtil.getFieldsByNameMap(var2);
                            var10 = var9.size();
                        }

                        if(var10 != var8) {
                            throw new IllegalArgumentException(String.format("Source object %s and target class %s aren\'t compatible.", new Object[]{var0, var1}));
                        }
                    }

                    Object[] var11 = new Object[var10];
                    Iterator var12 = var9.values().iterator();
                    int var13 = 0;

                    Field var15;
                    while(true) {
                        if(var13 >= var10) {
                            return var6.newInstance(var11);
                        }

                        List var14 = (List)var12.next();
                        if(var14.size() != 1) {
                            throw new IllegalArgumentException(String.format("There are multiple fields with name \'%s\' in class \'%s\'.", new Object[]{((Field)var14.get(0)).getName(), var2.getName()}));
                        }

                        var15 = (Field)var14.get(0);
                        Class var16 = var15.getType();
                        Class var17 = var7[var13];
                        boolean var18 = field_516.contains(var16);
                        boolean var19 = field_517.contains(var16);
                        if(!var18 && !var19 && var16 != String.class) {
                            if(var16.isEnum() && var17.isEnum()) {
                                var11[var13] = method_800(var15.get(var0), var17, var16);
                            } else {
                                if(!var16.isArray() || !var17.isArray()) {
                                    break;
                                }

                                var11[var13] = method_801(var15.get(var0), var17);
                            }
                        } else {
                            if(var16 != var17 && (!var18 || Primitives.wrap(var16) != var17) && (!var19 || Primitives.unwrap(var16) != var17)) {
                                break;
                            }

                            var11[var13] = var15.get(var0);
                        }

                        ++var13;
                    }

                    throw new IllegalArgumentException(String.format("Field \'%s\' of source object and constructor parameter of target class \'%s\' aren\'t compatible.", new Object[]{var15.getName(), var1.getName()}));
                }
            }
        }
    }

    // $FF: renamed from: a (java.lang.Object, java.lang.Class, java.lang.Class) java.lang.Object
    private static Object method_800(Object var0, Class var1, Class var2) {
        return var0 != null && var2 != var1?Enum.valueOf(var1, ((Enum)var0).name()):var0;
    }

    // $FF: renamed from: b (java.lang.Object, java.lang.Class) java.lang.Object
    private static Object method_801(Object var0, Class var1) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if(var0 == null) {
            return null;
        } else {
            Class var2 = var1.getComponentType();
            int var3 = Array.getLength(var0);
            Object var4 = Array.newInstance(var2, var3);

            for(int var5 = 0; var5 < var3; ++var5) {
                Array.set(var4, var5, method_799(Array.get(var0, var5), var2));
            }

            return var4;
        }
    }
}
