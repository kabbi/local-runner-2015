package com.a.a.b.a;

import com.a.a.b.class_106;
import com.a.a.b.a.class_201;
import com.codeforces.commons.math.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// $FF: renamed from: com.a.a.b.a.f
public class class_203 extends class_201 {
    // $FF: renamed from: a java.util.List
    private final List field_847 = new LinkedList();

    // $FF: renamed from: a (com.a.a.b.a) void
    public void method_66(class_106 var1) {
        method_1065(var1);
        if(this.field_847.contains(var1)) {
            throw new IllegalStateException(var1 + " is already added.");
        } else {
            this.field_847.add(var1);
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void method_67(class_106 var1) {
        if(var1 != null) {
            Iterator var2 = this.field_847.iterator();

            do {
                if(!var2.hasNext()) {
                    return;
                }
            } while(!((class_106)var2.next()).method_721(var1));

            var2.remove();
        }
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean method_68(class_106 var1) {
        method_1065(var1);
        return this.field_847.contains(var1);
    }

    // $FF: renamed from: a () java.util.List
    public List method_69() {
        return Collections.unmodifiableList(this.field_847);
    }

    // $FF: renamed from: d (com.a.a.b.a) java.util.List
    public List method_70(class_106 var1) {
        method_1065(var1);
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        Iterator var4 = this.field_847.iterator();

        while(true) {
            while(var4.hasNext()) {
                class_106 var5 = (class_106)var4.next();
                if(var5.method_721(var1)) {
                    var3 = true;
                } else if((!var1.method_672() || !var5.method_672()) && Math.sqr(var5.method_668().method_765() + var1.method_668().method_765()) >= var5.method_716(var1)) {
                    var2.add(var5);
                }
            }

            if(!var3) {
                throw new IllegalStateException("Can\'t find " + var1 + '.');
            }

            return Collections.unmodifiableList(var2);
        }
    }
}
