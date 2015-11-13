package com.a.b.a.a.b.c;

import com.a.b.class_3;
import com.a.b.class_34;
import com.a.b.class_42;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.b.class_51;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.b.d.e.class_49;
import com.a.b.a.a.b.d.e.class_50;

// $FF: renamed from: com.a.b.a.a.b.c.f
public class class_37 extends class_34 {
    public boolean beforeCollision(class_3 var1, class_42 var2, class_42 var3) {
        return var2 instanceof class_43 && ((class_43)var2).method_345() && !(var3 instanceof class_51)?false:(var3 instanceof class_43 && ((class_43)var3).method_345() && !(var2 instanceof class_51)?false:(var2 instanceof class_46 && !(var3 instanceof class_43)?false:(var3 instanceof class_46 && !(var2 instanceof class_43)?false:(var2 instanceof class_49 && !(var3 instanceof class_43) && !(var3 instanceof class_50)?false:(var3 instanceof class_49 && !(var2 instanceof class_43) && !(var2 instanceof class_50)?false:(var2 instanceof class_50 && var3 instanceof class_47?false:!(var3 instanceof class_50) || !(var2 instanceof class_47)))))));
    }
}
