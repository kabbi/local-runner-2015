package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.c.class_43;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.c.a
public class class_41 extends class_34 {
    public void afterCollision(class_58 var1) {
        class_43 var2 = (class_43)var1.method_362();
        class_47 var3 = (class_47)var1.method_363();
        switch(var3.method_349()) {
        case REPAIR_KIT:
            var2.method_301(Math.min(1.0D, var2.method_300() + 1.0D));
            break;
        case AMMO_CRATE:
            var2.method_317(var2.method_316() + 1);
            break;
        case NITRO_BOOST:
            var2.method_319(var2.method_318() + 1);
            break;
        case OIL_CANISTER:
            var2.method_321(var2.method_320() + 1);
            break;
        case PURE_SCORE:
            var2.method_297().method_929(100);
            break;
        default:
            throw new IllegalArgumentException("Unsupported bonus type: " + var3.method_349() + '.');
        }

        var1.method_361().method_18(var3);
    }
}
