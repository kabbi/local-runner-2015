package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.c.OilSlick;
import com.a.c.a.PhysicalForm;
import com.a.c.a.CircularPhysicalForm;

// $FF: renamed from: com.a.b.a.a.b.e.k
public final class class_88 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.d.a) com.a.b.a.a.c.n
    public static OilSlick method_516(class_46 var0) {
        PhysicalForm var1 = var0.method_279().getForm();
        if(!(var1 instanceof CircularPhysicalForm)) {
            throw new IllegalArgumentException("Unsupported oil slick form: " + var1 + '.');
        } else {
            CircularPhysicalForm var2 = (CircularPhysicalForm)var1;
            return new OilSlick(var0.method_278(), var0.method_279().getMass(),
                    var0.method_279().getX(), var0.method_279().getY(),
                    var0.method_279().getVelocity().getX(), var0.method_279().getVelocity().getY(),
                    var0.method_279().getAngle(), var0.method_279().getAngularVelocity(), var2.getRadius(), var0.method_347());
        }
    }
}
