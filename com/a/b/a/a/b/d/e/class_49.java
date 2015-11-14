package com.a.b.a.a.b.d.e;

import com.a.b.class_58;
import com.a.b.a.a.b.BoringTeamInfo;
import com.a.b.a.a.b.d.c.CarPhysicalBody;
import com.a.b.a.a.c.ProjectileType;
import com.a.c.a.class_129;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.b.a.a.b.d.e.c
public class class_49 extends Car {
    public class_49(CarPhysicalBody var1, BoringTeamInfo var2, int var3, Point2D var4, double var5) {
        super(new class_129(20.0D), var1, var2, ProjectileType.WASHER, var3, var4, (new Vector2D(60.0D, 0.0D)).rotate(var5), var5, 10.0D);
    }

    // $FF: renamed from: a (com.a.b.f, int) double
    public double method_358(class_58 var1, int var2) {
        return 0.1D;
    }
}
