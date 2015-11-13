package com.a.b.a.a.e.a.a;

import com.a.b.a.a.e.a.a.class_192;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

// $FF: renamed from: com.a.b.a.a.e.a.a.m
public class class_200 {
    // $FF: renamed from: a java.util.regex.Pattern
    private static final Pattern field_834 = Pattern.compile(";");
    // $FF: renamed from: b java.util.concurrent.ConcurrentMap
    private static final ConcurrentMap field_835 = new ConcurrentHashMap();

    private class_200() {
        throw new UnsupportedOperationException();
    }

    // $FF: renamed from: a (java.lang.String) com.a.b.a.a.e.a.a.d
    public static class_192 method_1063(String var0) {
        if(var0 != null) {
            if(var0.endsWith(".zip")) {
                var0 = var0.substring(0, var0.length() - ".zip".length());
            }

            Iterator var1 = field_835.entrySet().iterator();

            while(var1.hasNext()) {
                Entry var2 = (Entry)var1.next();
                if(var0.endsWith('.' + (String)var2.getKey())) {
                    return (class_192)var2.getValue();
                }
            }
        }

        throw new IllegalArgumentException(String.format("Can\'t find run script for \'%s\'.", new Object[]{var0}));
    }

    // $FF: renamed from: a () void
    private static void method_1064() {
        String var0 = "/remote-process.properties";
        Properties var1 = new Properties();

        try {
            var1.load(class_200.class.getResourceAsStream(var0));
        } catch (IOException var20) {
            throw new IllegalArgumentException(String.format("Can\'t read property file \'%s\'.", var0), var20);
        }

        String[] var2 = field_834.split(var1.getProperty("remote-process.supported-postfixes"));
        String[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            String var7 = "remote-process.postfix-command-line." + var6;
            String var8 = var1.getProperty(var7);
            if(StringUtils.isBlank(var8)) {
                throw new IllegalArgumentException(String.format("Expected property \'%s\' in \'%s\'.", new Object[]{var7, var0}));
            }

            String var9 = var8.trim();
            String var10 = "remote-process.resources-to-copy." + var6;
            String var11 = var1.getProperty(var10);
            ArrayList var12 = new ArrayList();
            if(!StringUtils.isBlank(var11)) {
                String[] var13 = field_834.split(var11);
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    String var16 = var13[var15];
                    var12.add(var16.trim());
                }
            }

            String var21 = "remote-process.resources-to-filter." + var6;
            String var22 = var1.getProperty(var21);
            HashSet var23 = new HashSet();
            if(!StringUtils.isBlank(var22)) {
                String[] var24 = field_834.split(var22);
                int var17 = var24.length;

                for(int var18 = 0; var18 < var17; ++var18) {
                    String var19 = var24[var18];
                    var23.add(var19.trim());
                }
            }

            field_835.put(var6, new class_192(var9, var12, var23));
        }

    }

    static {
        method_1064();
    }
}
