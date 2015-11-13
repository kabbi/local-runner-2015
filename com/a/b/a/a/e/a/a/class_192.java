package com.a.b.a.a.e.a.a;

import com.codeforces.commons.text.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $FF: renamed from: com.a.b.a.a.e.a.a.d
public class class_192 {
    // $FF: renamed from: a java.util.regex.Pattern
    private static final Pattern field_808 = Pattern.compile("(%[a-zA-Z_1-90]+%)");
    // $FF: renamed from: b java.lang.String
    private final String field_809;
    // $FF: renamed from: c java.util.List
    private final List field_810;
    // $FF: renamed from: d java.util.Set
    private final Set field_811;

    public class_192(String var1, List var2, Set var3) {
        this.field_809 = var1;
        this.field_810 = new ArrayList(var2);
        this.field_811 = new HashSet(var3);
    }

    // $FF: renamed from: a (java.lang.String, java.util.Map) java.lang.String
    public String method_1017(String var1, Map var2) {
        String var3 = this.field_809;
        Matcher var4 = field_808.matcher(this.field_809);

        while(var4.find()) {
            boolean var5 = false;
            int var6 = 0;

            for(int var7 = var4.groupCount(); var6 < var7; ++var6) {
                String var8 = var4.group(var6);
                String var9 = System.getenv(var8.substring(1, var8.length() - 1));
                if(var9 != null) {
                    var3 = StringUtil.replace(var3, var8, var9);
                    var5 = true;
                }
            }

            if(!var5) {
                break;
            }
        }

        Entry var11;
        if(var2 != null) {
            for(Iterator var10 = var2.entrySet().iterator(); var10.hasNext(); var3 = StringUtil.replace(var3, "${" + (String)var11.getKey() + '}', (String)var11.getValue())) {
                var11 = (Entry)var10.next();
            }
        }

        return String.format(var3, var1);
    }

    // $FF: renamed from: a () java.util.List
    public List method_1018() {
        return Collections.unmodifiableList(this.field_810);
    }

    // $FF: renamed from: a (java.lang.String) boolean
    public boolean method_1019(String var1) {
        return this.field_811.contains(var1);
    }
}
