package com.a.b.a.a.b.c;

import com.a.b.class_34;
import com.a.b.class_58;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.c.CarPhysicalBody;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.b.a.a.b.c.a
public class class_41 extends class_34 {
    public void afterCollision(class_58 var1) {
        CarPhysicalBody var2 = (CarPhysicalBody)var1.method_362();
        class_47 var3 = (class_47)var1.method_363();
        switch(var3.method_349().ordinal()) {
        case 1:
            var2.setDurability(Math.min(1.0D, var2.getDurability() + 1.0D));
            break;
        case 2:
            var2.method_317(var2.getProjectileCount() + 1);
            break;
        case 3:
            var2.method_319(var2.getNitroChangeCount() + 1);
            break;
        case 4:
            var2.method_321(var2.getOildCannisterCount() + 1);
            break;
        case 5:
            var2.getBoringTeamInfo().method_929(100);
            break;
        default:
            throw new IllegalArgumentException("Unsupported bonus type: " + var3.method_349() + '.');
        }

        var1.method_361().method_18(var3);
    }
}
