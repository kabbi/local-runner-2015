package com.a.c.b.a;

import com.a.a.a.a.class_121;
import com.a.a.b.class_106;
import com.a.a.b.class_110;
import com.a.a.b.a.class_15;
import com.a.a.b.b.class_71;
import com.a.a.b.d.class_154;
import com.a.c.class_10;
import com.a.c.class_159;
import com.a.c.class_162;
import com.a.c.class_8;
import com.a.c.class_9;
import com.a.c.b.a.class_188;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.a.c.b.a.b
public class class_186 implements class_10 {
    // $FF: renamed from: a java.util.concurrent.locks.Lock
    private final Lock field_790 = new ReentrantLock();
    // $FF: renamed from: b java.util.Map
    private final Map field_791 = new HashMap();
    // $FF: renamed from: c java.util.Map
    private final Map field_792 = new HashMap();
    // $FF: renamed from: d java.util.Map
    private final Map field_793 = new HashMap();
    // $FF: renamed from: e com.a.a.b.g
    private final class_110 field_794;

    public class_186() {
        this.field_794 = new class_110();
    }

    public class_186(int var1, int var2, double var3, class_15 var5) {
        this.field_794 = new class_110(var1, var2, var3, var5);
    }

    // $FF: renamed from: a (com.a.c.c) com.a.c.c
    public class_159 method_44(class_159 var1) {
        this.field_790.lock();

        class_159 var3;
        try {
            class_106 var2 = this.method_998(var1.method_867());
            if(var2 == null) {
                var2 = class_188.method_1001(var1);
                this.field_794.method_726(var2);
                this.field_791.put(Long.valueOf(var2.method_665()), var2);
                this.field_792.put(Long.valueOf(var1.method_867()), Long.valueOf(var2.method_665()));
                this.field_793.put(Long.valueOf(var2.method_665()), Long.valueOf(var1.method_867()));
                class_188.method_1003(var2, var1, this);
            }

            var3 = this.method_1000(var1.method_867());
        } finally {
            this.field_790.unlock();
        }

        return var3;
    }

    // $FF: renamed from: b (com.a.c.c) void
    public void method_45(class_159 var1) {
        this.field_790.lock();

        try {
            class_106 var2 = this.method_998(var1.method_867());
            if(var2 == null) {
                throw new IllegalArgumentException("No body with ID " + var1.method_867() + '.');
            }

            class_188.method_1003(var2, var1, this);
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: c (com.a.c.c) void
    public void method_46(class_159 var1) {
        this.field_790.lock();

        try {
            class_106 var2 = this.method_998(var1.method_867());
            if(var2 != null) {
                class_188.method_1003(var2, var1, this);
            }
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: d (com.a.c.c) com.a.c.c
    public class_159 method_47(class_159 var1) {
        this.field_790.lock();

        class_159 var5;
        try {
            Long var2 = this.method_996(var1.method_867());
            class_106 var3;
            if(var2 == null) {
                return null;
            }

            var3 = (class_106)this.field_791.remove(var2);
            class_159 var4;
            if(var3 == null) {
                return null;
            }

            var4 = class_188.method_1002(var3, this);
            this.field_794.method_727(var3);
            this.field_792.remove(var1.method_867());
            this.field_793.remove(var2);
            var5 = var4;
        } finally {
            this.field_790.unlock();
        }

        return var5;
    }

    // $FF: renamed from: a () void
    public void method_48() {
        this.field_790.lock();

        try {
            this.field_794.method_730();
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: a (com.a.c.b) void
    public void method_49(final class_8 var1) {
        this.field_790.lock();

        try {
            String var2;
            do {
                var2 = class_121.method_795();
            } while(this.field_794.method_744(var2));

            if(var1 instanceof class_9) {
                final class_9 var3 = (class_9)var1;
                this.field_794.method_743(new class_154() {
                    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
                    public boolean method_38(class_106 var1, class_106 var2) {
                        return var3.method_42(class_186.this.method_999(var1.method_665()), class_186.this.method_999(var2.method_665()));
                    }

                    // $FF: renamed from: a (com.a.a.b.b.f) boolean
                    public boolean method_39(class_71 var1) {
                        return var3.method_43(new class_162(class_186.this.method_999(var1.method_386().method_665()), class_186.this.method_999(var1.method_387().method_665()), var1.method_388().copy(), var1.method_389().copy()));
                    }

                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void method_40(class_71 var1) {
                        var3.method_41(new class_162(class_186.this.method_999(var1.method_386().method_665()), class_186.this.method_999(var1.method_387().method_665()), var1.method_388().copy(), var1.method_389().copy()));
                    }
                }, var2);
            } else {
                this.field_794.method_743(new class_154() {
                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void method_40(class_71 var1x) {
                        var1.method_41(new class_162(class_186.this.method_999(var1x.method_386().method_665()), class_186.this.method_999(var1x.method_387().method_665()), var1x.method_388().copy(), var1x.method_389().copy()));
                    }
                }, var2);
            }
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: b () int
    public int method_50() {
        return this.field_794.method_724();
    }

    // $FF: renamed from: c () com.a.a.b.g
    class_110 method_995() {
        return this.field_794;
    }

    // $FF: renamed from: a (long) java.lang.Long
    Long method_996(long var1) {
        return (Long)this.field_792.get(Long.valueOf(var1));
    }

    // $FF: renamed from: b (long) java.lang.Long
    Long method_997(long var1) {
        return (Long)this.field_793.get(Long.valueOf(var1));
    }

    // $FF: renamed from: c (long) com.a.a.b.a
    class_106 method_998(long var1) {
        Long var3 = this.method_996(var1);
        return var3 == null?null:(class_106)this.field_791.get(var3);
    }

    // $FF: renamed from: d (long) com.a.c.c
    class_159 method_999(long var1) {
        class_106 var3 = (class_106)this.field_791.get(Long.valueOf(var1));
        return var3 == null?null:class_188.method_1002(var3, this);
    }

    // $FF: renamed from: e (long) com.a.c.c
    class_159 method_1000(long var1) {
        Long var3 = this.method_996(var1);
        return var3 == null?null:this.method_999(var3.longValue());
    }
}
