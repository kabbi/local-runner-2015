package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.c.Bonus;
import com.a.c.a.PhysicalForm;
import com.a.c.a.RectangularPhysicalForm;

// $FF: renamed from: com.a.b.a.a.b.e.a
public final class class_78 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.a.a) com.a.b.a.a.c.a
    public static Bonus method_475(class_47 var0) {
        PhysicalForm var1 = var0.method_279().getForm();
        if(!(var1 instanceof RectangularPhysicalForm)) {
            throw new IllegalArgumentException("Unsupported bonus form: " + var1 + '.');
        } else {
            RectangularPhysicalForm var2 = (RectangularPhysicalForm)var1;
            return new Bonus(var0.method_278(), var0.method_279().getMass(), var0.method_279().getX(),
                    var0.method_279().getY(), var0.method_279().getVelocity().getX(), var0.method_279().getVelocity().getY(),
                    var0.method_279().getAngle(), var0.method_279().getAngularVelocity(), var2.getWidth(), var2.getHeight(), var0.method_349());
        }
    }
}
