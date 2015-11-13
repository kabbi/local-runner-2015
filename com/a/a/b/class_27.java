package com.a.a.b;

import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c
class class_27 {
    // $FF: renamed from: a java.lang.String
    public final String field_109;

    class_27(String var1) {
        this.field_109 = var1;
    }

    public int hashCode() {
        return this.field_109.hashCode();
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(var1 != null && this.getClass() == var1.getClass()) {
            class_27 var2 = (class_27)var1;
            return this.field_109.equals(var2.field_109);
        } else {
            return false;
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    static void method_237(String var0) {
        if(StringUtil.isBlank(var0)) {
            throw new IllegalArgumentException("Argument \'name\' is blank.");
        } else if(!StringUtil.trim(var0).equals(var0)) {
            throw new IllegalArgumentException("Argument \'name\' should not contain neither leading nor trailing whitespace characters.");
        }
    }
}
