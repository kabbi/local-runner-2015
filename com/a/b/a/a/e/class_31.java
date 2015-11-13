package com.a.b.a.a.e;

import com.a.b.a.a.c.class_136;
import com.a.b.a.a.c.class_137;
import com.a.b.a.a.c.class_147;
import com.a.b.a.a.c.class_149;
import com.a.b.a.a.e.class_0;

// $FF: renamed from: com.a.b.a.a.e.b
public class class_31 implements class_0 {
    // $FF: renamed from: a (com.a.b.a.a.c.c, com.a.b.a.a.c.v, com.a.b.a.a.c.l, com.a.b.a.a.c.m) void
    public void method_11(class_136 var1, class_137 var2, class_149 var3, class_147 var4) {
        double var5 = ((double)var1.getNextWaypointX() + 0.5D) * var3.getTrackTileSize();
        double var7 = ((double)var1.getNextWaypointY() + 0.5D) * var3.getTrackTileSize();
        double var9 = 0.25D * var3.getTrackTileSize();
        switch(var2.getTilesXY()[var1.getNextWaypointX()][var1.getNextWaypointY()].ordinal()) {
        case 1:
            var5 += var9;
            var7 += var9;
            break;
        case 2:
            var5 -= var9;
            var7 += var9;
            break;
        case 3:
            var5 += var9;
            var7 -= var9;
            break;
        case 4:
            var5 -= var9;
            var7 -= var9;
        }

        double var11 = var1.getAngleTo(var5, var7);
        double var13 = StrictMath.hypot(var1.getSpeedX(), var1.getSpeedY());
        if(var13 * var13 * StrictMath.abs(var11) > 19.634954084936208D) {
            var4.setBrake(true);
        }

        var4.setWheelTurn(var11 * 32.0D / 3.141592653589793D);
        var4.setEnginePower(0.75D);
    }
}
