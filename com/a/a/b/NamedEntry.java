package com.a.a.b;

import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c
class NamedEntry {
    // $FF: renamed from: a java.lang.String
    public final String name;

    NamedEntry(String name) {
        this.name = name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            NamedEntry namedEntry = (NamedEntry)o;
            return this.name.equals(namedEntry.name);
        } else {
            return false;
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    static void validateName(String name) {
        if(StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("Argument \'name\' is blank.");
        } else if(!StringUtil.trim(name).equals(name)) {
            throw new IllegalArgumentException("Argument \'name\' should not contain neither leading nor trailing whitespace characters.");
        }
    }
}
