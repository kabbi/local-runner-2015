package com.codeforces.commons.reflection;

import com.codeforces.commons.reflection.MethodSignature;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.StringUtils;

public class ReflectionUtil {
    private static final ConcurrentMap fieldsByNameByClass = new ConcurrentHashMap();
    private static final ConcurrentMap publicMethodBySignatureByClass = new ConcurrentHashMap();

    public static Object getDeepValue(Object var0, String var1) {
        return getDeepValue(var0, var1, false, false, false);
    }

    public static Object getDeepValue(Object var0, String var1, boolean var2, boolean var3, boolean var4) {
        Object var5 = null;
        Object var6 = var0;
        String[] var7 = StringUtil.split(var1, '.');
        int var8 = 0;
        int var9 = var7.length;

        while(true) {
            if(var8 < var9) {
                String var10 = var7[var8];
                if(StringUtil.isBlank(var10)) {
                    throw new IllegalArgumentException("Field name can not be neither \'null\' nor blank.");
                }

                boolean var11 = false;
                List var12 = (List)getFieldsByNameMap(var6.getClass()).get(var10);
                if(var12 != null && !var12.isEmpty()) {
                    var5 = getFieldValue((Field)var12.get(0), var6);
                    var11 = true;
                }

                if(!var11 && !var2) {
                    Method var13 = findPublicGetter(var10, var6.getClass());

                    try {
                        if(var13 != null) {
                            var5 = var13.invoke(var6, new Object[0]);
                            var11 = true;
                        }
                    } catch (IllegalAccessException var17) {
                        throw new IllegalStateException("This exception is unexpected because method should be public.", var17);
                    } catch (InvocationTargetException var18) {
                        if(var18.getTargetException() instanceof RuntimeException) {
                            throw (RuntimeException)var18.getTargetException();
                        }

                        throw new IllegalStateException("This type of exception is unexpected.", var18);
                    }
                }

                if(!var11 && !var3 && var6 instanceof Map) {
                    var5 = ((Map)var6).get(var10);
                    var11 = true;
                }

                if(!var11 && !var4) {
                    try {
                        int var20 = Integer.parseInt(var10);
                        if(var6 instanceof List) {
                            List var21 = (List)var6;
                            var5 = var21.get(var20 < 0?var21.size() + var20:var20);
                            var11 = true;
                        } else if(var6 instanceof Collection) {
                            Collection var14 = (Collection)var6;
                            Iterator var15 = var14.iterator();
                            if(var20 < 0) {
                                var20 += var14.size();
                            }

                            for(int var16 = 0; var16 <= var20; ++var16) {
                                var5 = var15.next();
                            }

                            var11 = true;
                        }
                    } catch (NumberFormatException var19) {
                        ;
                    }
                }

                if(!var11) {
                    throw new IllegalArgumentException(String.format("Can\'t find \'%s\' in %s.", new Object[]{var10, var6.getClass()}));
                }

                if(var5 != null) {
                    var6 = var5;
                    ++var8;
                    continue;
                }
            }

            return var5;
        }
    }

    public static Method findPublicGetter(String var0, Class var1) {
        Map var2 = getPublicMethodBySignatureMap(var1);
        String var3 = StringUtils.capitalize(var0);
        Method var4 = (Method)var2.get(new MethodSignature("is" + var3, new Class[0]));
        if(var4 != null && var4.getReturnType() == Boolean.TYPE && throwsOnlyRuntimeExceptions(var4)) {
            return var4;
        } else {
            var4 = (Method)var2.get(new MethodSignature("get" + var3, new Class[0]));
            if(var4 != null && var4.getReturnType() != Void.TYPE && var4.getReturnType() != Void.class && throwsOnlyRuntimeExceptions(var4)) {
                return var4;
            } else {
                var4 = (Method)var2.get(new MethodSignature(var0, new Class[0]));
                return var4 != null && var4.getReturnType() != Void.TYPE && var4.getReturnType() != Void.class && throwsOnlyRuntimeExceptions(var4)?var4:null;
            }
        }
    }

    public static Map getFieldsByNameMap(Class var0) {
        Map var1 = (Map)fieldsByNameByClass.get(var0);
        if(var1 == null) {
            LinkedHashMap var11 = new LinkedHashMap();
            Class var2 = var0.getSuperclass();
            if(var2 != null) {
                var11.putAll(getFieldsByNameMap(var2));
            }

            Field[] var3 = var0.getDeclaredFields();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Field var6 = var3[var5];
                if(!var6.isEnumConstant() && !Modifier.isStatic(var6.getModifiers()) && !var6.isSynthetic()) {
                    var6.setAccessible(true);
                    Name var7 = (Name)var6.getAnnotation(Name.class);
                    String var8 = var7 == null?var6.getName():var7.value();
                    List var9 = (List)var11.get(var8);
                    ArrayList var12;
                    if(var9 == null) {
                        var12 = new ArrayList(1);
                        var12.add(var6);
                    } else {
                        var12 = new ArrayList(var9.size() + 1);
                        var12.add(var6);
                        var12.addAll(var9);
                    }

                    var11.put(var8, Collections.unmodifiableList(var12));
                }
            }

            fieldsByNameByClass.putIfAbsent(var0, Collections.unmodifiableMap(var11));
            return (Map)fieldsByNameByClass.get(var0);
        } else {
            return var1;
        }
    }

    private static boolean throwsOnlyRuntimeExceptions(Method var0) {
        Class[] var1 = var0.getExceptionTypes();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Class var4 = var1[var3];
            if(!RuntimeException.class.isAssignableFrom(var4)) {
                return false;
            }
        }

        return true;
    }

    public static Map getPublicMethodBySignatureMap(Class var0) {
        Map var1 = (Map)publicMethodBySignatureByClass.get(var0);
        if(var1 == null) {
            Method[] var2 = var0.getMethods();
            int var3 = var2.length;
            LinkedHashMap var8 = new LinkedHashMap(var3);

            for(int var4 = 0; var4 < var3; ++var4) {
                Method var5 = var2[var4];
                Name var6 = (Name)var5.getAnnotation(Name.class);
                String var7 = var6 == null?var5.getName():var6.value();
                var5.setAccessible(true);
                var8.put(new MethodSignature(var7, var5.getParameterTypes()), var5);
            }

            publicMethodBySignatureByClass.putIfAbsent(var0, Collections.unmodifiableMap(var8));
            return (Map)publicMethodBySignatureByClass.get(var0);
        } else {
            return var1;
        }
    }

    private static Object getFieldValue(Field var0, Object var1) {
        try {
            return var0.get(var1);
        } catch (IllegalAccessException var5) {
            Name var3 = (Name)var0.getAnnotation(Name.class);
            String var4 = var3 == null?var0.getName():var3.value();
            throw new IllegalArgumentException("Can\'t get value of inaccessible field \'" + var4 + "\'.", var5);
        }
    }
}
