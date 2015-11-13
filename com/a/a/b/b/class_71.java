package com.a.a.b.b;

import com.a.a.b.class_106;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.text.StringUtil;
import org.apache.log4j.Logger;

// $FF: renamed from: com.a.a.b.b.f
public class class_71 {
    // $FF: renamed from: a org.apache.log4j.Logger
    private static final Logger field_213 = Logger.getLogger(class_71.class);
    // $FF: renamed from: b com.a.a.b.a
    private final class_106 field_214;
    // $FF: renamed from: c com.a.a.b.a
    private final class_106 field_215;
    // $FF: renamed from: d com.codeforces.commons.geometry.Point2D
    private final Point2D field_216;
    // $FF: renamed from: e com.codeforces.commons.geometry.Vector2D
    private final Vector2D field_217;
    // $FF: renamed from: f double
    private final double field_218;

    public class_71(class_106 var1, class_106 var2, Point2D var3, Vector2D var4, double var5, double var7) {
        this.field_214 = var1;
        this.field_215 = var2;
        this.field_216 = var3;
        this.field_217 = var4;
        if(var5 < 0.0D && var5 > -var7) {
            this.field_218 = 0.0D;
        } else {
            this.field_218 = var5;
        }

        if(Double.isNaN(this.field_218) || Double.isInfinite(this.field_218) || this.field_218 < 0.0D) {
            field_213.error(String.format("Argument \'depth\' should be non-negative number but got %s (%s and %s).", this.field_218, var1, var2));
        }

    }

    // $FF: renamed from: a () com.a.a.b.a
    public class_106 method_386() {
        return this.field_214;
    }

    // $FF: renamed from: b () com.a.a.b.a
    public class_106 method_387() {
        return this.field_215;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Point2D
    public Point2D method_388() {
        return this.field_216.copy();
    }

    // $FF: renamed from: d () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_389() {
        return this.field_217.copy();
    }

    // $FF: renamed from: e () double
    public double method_390() {
        return this.field_218;
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }
}
