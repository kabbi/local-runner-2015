package com.a.b.a.a.b;

import com.a.a.a.a.RandomUtils;
import com.a.b.a.a.e.a.StrategyAdapter;
import com.a.b.a.a.e.a.class_179;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.b.a.a.b.n
public class class_171 {
    // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
    private static final AtomicLong field_691 = new AtomicLong();
    // $FF: renamed from: b long
    @Name("id")
    private final long field_692;
    // $FF: renamed from: c java.lang.String
    @Name("name")
    private final String field_693;
    // $FF: renamed from: d long
    private final long field_694 = RandomUtils.randomLong();
    // $FF: renamed from: e com.a.b.a.a.e.a.f
    private final StrategyAdapter field_695;
    // $FF: renamed from: f boolean
    private boolean field_696;
    // $FF: renamed from: g java.lang.String
    private String field_697;
    // $FF: renamed from: h long
    private long field_698;
    // $FF: renamed from: i long
    private long field_699;
    // $FF: renamed from: j int
    private int field_700;

    public class_171(String var1, StrategyAdapter var2) {
        this.field_692 = field_691.incrementAndGet();
        this.field_693 = var1;
        this.field_695 = var2;
    }

    // $FF: renamed from: a () long
    public final long method_917() {
        return this.field_692;
    }

    // $FF: renamed from: b () java.lang.String
    public String method_918() {
        return this.field_693;
    }

    // $FF: renamed from: c () long
    public long method_919() {
        return this.field_694;
    }

    // $FF: renamed from: d () com.a.b.a.a.e.a.f
    public StrategyAdapter method_920() {
        return this.field_695;
    }

    // $FF: renamed from: e () boolean
    public boolean method_921() {
        return this.field_695 instanceof class_179;
    }

    // $FF: renamed from: f () boolean
    public boolean method_922() {
        return this.field_696;
    }

    // $FF: renamed from: g () java.lang.String
    public String method_923() {
        return this.field_697;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_924(String var1) {
        if(!this.method_921()) {
            this.field_696 = true;
            this.field_697 = var1;
            IoUtil.closeQuietly((AutoCloseable)this.field_695);
        }
    }

    // $FF: renamed from: h () long
    public long method_925() {
        return this.field_698;
    }

    // $FF: renamed from: a (long) void
    public void method_926(long var1) {
        this.field_698 = var1;
    }

    // $FF: renamed from: b (long) void
    public void method_927(long var1) {
        this.field_699 = var1;
        this.field_698 -= var1;
    }

    // $FF: renamed from: i () int
    public int method_928() {
        return this.field_700;
    }

    // $FF: renamed from: a (int) void
    public void method_929(int var1) {
        this.field_700 += var1;
    }

    public final boolean equals(Object var1) {
        return this == var1 || var1 != null && this.getClass() == var1.getClass() && this.field_692 == ((class_171)var1).field_692;
    }

    public final int hashCode() {
        return Long.valueOf(this.field_692).hashCode();
    }

    public String toString() {
        return StringUtil.toString(this, false, "id", "name");
    }
}
