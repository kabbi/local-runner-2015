package com.codeforces.commons.text;

import com.codeforces.commons.holder.Holders;
import com.codeforces.commons.holder.Mutable;
import com.codeforces.commons.holder.SimpleMutable;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.SimplePair;
import com.codeforces.commons.reflection.ReflectionUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public final class StringUtil {
    private static final Pattern FORMAT_COMMENTS_COMMENT_SPLIT_PATTERN = Pattern.compile("\\[pre\\]|\\[/pre\\]");
    private static final Pattern FORMAT_COMMENTS_LINE_BREAK_REPLACE_PATTERN = Pattern.compile("[\n\r][\n\r]+");
    private static final Map toStringConverterByClass = new HashMap();
    private static final ReadWriteLock toStringConverterByClassMapLock = new ReentrantReadWriteLock();

    public static boolean isWhitespace(char var0) {
        return Character.isWhitespace(var0) || var0 == 160 || var0 == 8203;
    }

    public static boolean isEmpty(String var0) {
        return var0 == null || var0.isEmpty();
    }

    public static boolean isBlank(String var0) {
        if(var0 != null && !var0.isEmpty()) {
            for(int var1 = var0.length() - 1; var1 >= 0; --var1) {
                if(!isWhitespace(var0.charAt(var1))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String var0) {
        if(var0 != null && !var0.isEmpty()) {
            for(int var1 = var0.length() - 1; var1 >= 0; --var1) {
                if(!isWhitespace(var0.charAt(var1))) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean equals(String var0, String var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    public static String trim(String var0) {
        if(var0 == null) {
            return null;
        } else {
            int var1 = var0.length() - 1;
            int var2 = 0;

            int var3;
            for(var3 = var1; var2 <= var1 && isWhitespace(var0.charAt(var2)); ++var2) {
                ;
            }

            while(var3 > var2 && isWhitespace(var0.charAt(var3))) {
                --var3;
            }

            return var2 == 0 && var3 == var1?var0:var0.substring(var2, var3 + 1);
        }
    }

    public static String trimToNull(String var0) {
        return var0 == null?null:((var0 = trim(var0)).isEmpty()?null:var0);
    }

    public static String trimToEmpty(String var0) {
        return var0 == null?"":trim(var0);
    }

    public static String[] split(String var0, char var1) {
        int var2 = var0.length();
        int var3 = 0;
        int var4 = 0;
        String[] var5 = null;
        int var6 = 0;

        String[] var7;
        while(var4 < var2) {
            if(var0.charAt(var4) == var1) {
                if(var5 == null) {
                    var5 = new String[8];
                } else if(var6 == var5.length) {
                    var7 = new String[var6 << 1];
                    System.arraycopy(var5, 0, var7, 0, var6);
                    var5 = var7;
                }

                var5[var6++] = var0.substring(var3, var4);
                ++var4;
                var3 = var4;
            } else {
                ++var4;
            }
        }

        if(var5 == null) {
            return new String[]{var0};
        } else {
            if(var6 == var5.length) {
                var7 = new String[var6 + 1];
                System.arraycopy(var5, 0, var7, 0, var6);
                var5 = var7;
            }

            var5[var6++] = var0.substring(var3, var4);
            if(var6 == var5.length) {
                return var5;
            } else {
                var7 = new String[var6];
                System.arraycopy(var5, 0, var7, 0, var6);
                return var7;
            }
        }
    }

    public static String replace(String var0, String var1, String var2) {
        if(!isEmpty(var0) && !isEmpty(var1) && var2 != null) {
            int var3 = var0.indexOf(var1);
            if(var3 == -1) {
                return var0;
            } else {
                int var4 = 0;
                int var5 = var1.length();
                StringBuilder var6 = new StringBuilder(var0.length() + (Math.max(var2.length() - var5, 0) << 4));

                do {
                    if(var3 > var4) {
                        var6.append(var0.substring(var4, var3));
                    }

                    var6.append(var2);
                    var4 = var3 + var5;
                    var3 = var0.indexOf(var1, var4);
                } while(var3 != -1);

                return var6.append(var0.substring(var4)).toString();
            }
        } else {
            return var0;
        }
    }

    public static String toString(Class aClass, Object object, boolean skipNulls, String... fields) {
        StringUtil.ToStringOptions options = new StringUtil.ToStringOptions();
        options.skipNulls = skipNulls;
        return toString(aClass, object, options, fields);
    }

    public static String toString(Class var0, Object var1, StringUtil.ToStringOptions var2, String... var3) {
        return var1 == null?getSimpleName(var0, var2.addEnclosingClassNames) + " {null}":toString(var1, var2, var3);
    }

    public static String toString(Object var0, boolean var1, String... var2) {
        StringUtil.ToStringOptions var3 = new StringUtil.ToStringOptions();
        var3.skipNulls = var1;
        return toString(var0, var3, var2);
    }

    public static String toString(Object var0, StringUtil.ToStringOptions var1, String... var2) {
        Class var3 = var0.getClass();
        if(var2.length == 0) {
            Set var4 = ReflectionUtil.getFieldsByNameMap(var3).keySet();
            var2 = (String[])var4.toArray(new String[var4.size()]);
        }

        StringBuilder var11 = (new StringBuilder(getSimpleName(var3, var1.addEnclosingClassNames))).append(" {");
        boolean var5 = true;
        int var6 = 0;

        for(int var7 = var2.length; var6 < var7; ++var6) {
            String var8 = var2[var6];
            if(isBlank(var8)) {
                throw new IllegalArgumentException("Field name can not be neither \'null\' nor blank.");
            }

            Object var9 = ReflectionUtil.getDeepValue(var0, var8);
            String var10;
            if(var9 == null) {
                if(var1.skipNulls || var1.skipEmptyStrings || var1.skipBlankStrings) {
                    continue;
                }

                var10 = var8 + "=null";
            } else {
                var10 = fieldToString(var9, var8, var1);
                if(var10 == null) {
                    continue;
                }
            }

            if(var5) {
                var5 = false;
            } else {
                var11.append(", ");
            }

            var11.append(var10);
        }

        return var11.append('}').toString();
    }

    public static StringUtil.ToStringConverter getToStringConverter(Class var0, boolean var1) {
        Lock var2 = toStringConverterByClassMapLock.readLock();
        var2.lock();

        StringUtil.ToStringConverter var3;
        try {
            if(var1) {
                StringUtil.ToStringConverter var4;
                for(Class var9 = var0; var9 != null; var9 = var9.getSuperclass()) {
                    var4 = (StringUtil.ToStringConverter)toStringConverterByClass.get(var9);
                    if(var4 != null) {
                        StringUtil.ToStringConverter var5 = var4;
                        return var5;
                    }
                }

                var4 = null;
                return var4;
            }

            var3 = (StringUtil.ToStringConverter)toStringConverterByClass.get(var0);
        } finally {
            var2.unlock();
        }

        return var3;
    }

    private static String getSimpleName(Class var0, boolean var1) {
        String var2 = var0.getSimpleName();
        if(var1) {
            while((var0 = var0.getEnclosingClass()) != null) {
                var2 = String.format("%s.%s", new Object[]{var0.getSimpleName(), var2});
            }
        }

        return var2;
    }

    private static String fieldToString(Object var0, String var1, StringUtil.ToStringOptions var2) {
        if(var0.getClass() != Boolean.class && var0.getClass() != Boolean.TYPE) {
            SimpleMutable var3 = new SimpleMutable();
            String var4 = valueToString(var0, var3);
            return shouldSkipField(var4, var2, var3)?null:var1 + '=' + var4;
        } else {
            return ((Boolean)var0).booleanValue()?var1:'!' + var1;
        }
    }

    private static boolean shouldSkipField(String var0, StringUtil.ToStringOptions var1, Mutable var2) {
        if(var1.skipNulls && var0 == null) {
            return true;
        } else {
            if(var1.skipEmptyStrings) {
                if(var2 != null && var2.get() != null && ((Boolean)var2.get()).booleanValue()) {
                    if("\'\'".equals(var0) || "\"\"".equals(var0)) {
                        return true;
                    }
                } else if(isEmpty(var0)) {
                    return true;
                }
            }

            if(var1.skipBlankStrings) {
                if(var2 != null && var2.get() != null && ((Boolean)var2.get()).booleanValue()) {
                    if(isBlank(var0) || isBlank(var0.substring(1, var0.length() - 1))) {
                        return true;
                    }
                } else if(isBlank(var0)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static String valueToString(Object var0, Mutable var1) {
        if(var0 == null) {
            return null;
        } else {
            Class var2 = var0.getClass();
            if(var2.isArray()) {
                return arrayToString(var0);
            } else {
                StringUtil.ToStringConverter var3;
                if((var3 = getToStringConverter(var2, true)) != null) {
                    return var3.convert(var0);
                } else if(var0 instanceof Collection) {
                    return collectionToString((Collection)var0);
                } else if(var0 instanceof Map) {
                    return mapToString((Map)var0);
                } else if(var0 instanceof Entry) {
                    Entry var5 = (Entry)var0;
                    return valueToString(var5.getKey(), (Mutable)null) + ": " + valueToString(var5.getValue(), (Mutable)null);
                } else if(var0 instanceof SimplePair) {
                    SimplePair var4 = (SimplePair)var0;
                    return '(' + valueToString(var4.getFirst(), (Mutable)null) + ", " + valueToString(var4.getSecond(), (Mutable)null) + ')';
                } else if(var2 == Character.class) {
                    Holders.setQuietly(var1, Boolean.valueOf(true));
                    return "\'" + var0 + '\'';
                } else if(var2 != Boolean.class && var2 != Byte.class && var2 != Short.class && var2 != Integer.class && var2 != Long.class && var2 != Float.class && var2 != Double.class) {
                    if(var2.isEnum()) {
                        return ((Enum)var0).name();
                    } else if(var2 == String.class) {
                        Holders.setQuietly(var1, Boolean.valueOf(true));
                        return '\'' + (String)var0 + '\'';
                    } else {
                        Holders.setQuietly(var1, Boolean.valueOf(true));
                        return '\'' + String.valueOf(var0) + '\'';
                    }
                } else {
                    return var0.toString();
                }
            }
        }
    }

    private static String arrayToString(Object var0) {
        StringBuilder var1 = new StringBuilder("[");
        int var2 = Array.getLength(var0);
        if(var2 > 0) {
            var1.append(valueToString(Array.get(var0, 0), (Mutable)null));

            for(int var3 = 1; var3 < var2; ++var3) {
                var1.append(", ").append(valueToString(Array.get(var0, var3), (Mutable)null));
            }
        }

        return var1.append(']').toString();
    }

    private static String collectionToString(Collection var0) {
        StringBuilder var1 = new StringBuilder("[");
        Iterator var2 = var0.iterator();
        if(var2.hasNext()) {
            var1.append(valueToString(var2.next(), (Mutable)null));

            while(var2.hasNext()) {
                var1.append(", ").append(valueToString(var2.next(), (Mutable)null));
            }
        }

        return var1.append(']').toString();
    }

    private static String mapToString(Map var0) {
        StringBuilder var1 = new StringBuilder("{");
        Iterator var2 = var0.entrySet().iterator();
        if(var2.hasNext()) {
            var1.append(valueToString(var2.next(), (Mutable)null));

            while(var2.hasNext()) {
                var1.append(", ").append(valueToString(var2.next(), (Mutable)null));
            }
        }

        return var1.append('}').toString();
    }

    public static String shrinkTo(String var0, int var1) {
        if(var1 < 8) {
            throw new IllegalArgumentException("Argument maxLength is expected to be at least 8.");
        } else if(var0 != null && var0.length() > var1) {
            int var2 = var1 / 2;
            int var3 = var1 - var2 - 3;
            return var0.substring(0, var2) + "..." + var0.substring(var0.length() - var3);
        } else {
            return var0;
        }
    }

    public static List shrinkLinesTo(List var0, int var1, int var2) {
        if(var2 < 3) {
            throw new IllegalArgumentException("Argument \'maxLineCount\' is expected to be at least 3.");
        } else if(var0 == null) {
            return null;
        } else {
            int var3 = var0.size();
            ArrayList var4 = new ArrayList(Math.min(var2, var3));
            if(var3 <= var2) {
                Iterator var5 = var0.iterator();

                while(var5.hasNext()) {
                    String var6 = (String)var5.next();
                    var4.add(shrinkTo(var6, var1));
                }
            } else {
                int var8 = var2 / 2;
                int var9 = var2 - var8 - 1;

                int var7;
                for(var7 = 0; var7 < var8; ++var7) {
                    var4.add(shrinkTo((String)var0.get(var7), var1));
                }

                var4.add("...");

                for(var7 = var3 - var9; var7 < var3; ++var7) {
                    var4.add(shrinkTo((String)var0.get(var7), var1));
                }
            }

            return var4;
        }
    }

    public static final class ToStringOptions {
        private boolean skipNulls;
        private boolean skipEmptyStrings;
        private boolean skipBlankStrings;
        private boolean addEnclosingClassNames;
    }

    public interface ToStringConverter {
        String convert(Object var1);
    }
}
