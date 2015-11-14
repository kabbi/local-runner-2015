package com.a.b.a.a.b.e;

import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.c.Bonus;
import com.a.c.a.Form;
import com.a.c.a.class_128;

// $FF: renamed from: com.a.b.a.a.b.e.a
public final class class_78 {
    // $FF: renamed from: a (com.a.b.a.a.b.d.a.a) com.a.b.a.a.c.a
    public static Bonus method_475(class_47 var0) {
        Form var1 = var0.getBody().getForm();
        if(!(var1 instanceof class_128)) {
            throw new IllegalArgumentException("Unsupported bonus form: " + var1 + '.');
        } else {
            class_128 var2 = (class_128)var1;
            return new Bonus(var0.getId(), var0.getBody().getMass(), var0.getBody().getX(),
                    var0.getBody().getY(), var0.getBody().getSpeed().getX(), var0.getBody().getSpeed().getY(),
                    var0.getBody().getAngle(), var0.getBody().angularSpeed(), var2.getCarWidth(), var2.getCarHeight(), var0.method_349());
        }
    }
}
