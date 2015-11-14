package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.c.OilSlick;
import com.a.c.a.Form;
import com.a.c.a.class_129;

// $FF: renamed from: com.a.b.a.a.b.e.k
public final class class_88 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.d.a) com.a.b.a.a.c.n
    public static OilSlick method_516(class_46 var0) {
        Form var1 = var0.getBody().getForm();
        if(!(var1 instanceof class_129)) {
            throw new IllegalArgumentException("Unsupported oil slick form: " + var1 + '.');
        } else {
            class_129 var2 = (class_129)var1;
            return new OilSlick(var0.getId(), var0.getBody().getMass(),
                    var0.getBody().getX(), var0.getBody().getY(),
                    var0.getBody().getSpeed().getX(), var0.getBody().getSpeed().getY(),
                    var0.getBody().getAngle(), var0.getBody().angularSpeed(), var2.method_829(), var0.method_347());
        }
    }
}
