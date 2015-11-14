package com.a.c;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.c.a
public final class maybeCollisionInfo {
    // $FF: renamed from: a com.a.c.c
    private final Body field_673;
    // $FF: renamed from: b com.a.c.c
    private final Body field_674;
    // $FF: renamed from: c com.codeforces.commons.geometry.Point2D
    private final Point2D field_675;
    // $FF: renamed from: d com.codeforces.commons.geometry.Vector2D
    private final Vector2D field_676;

    public maybeCollisionInfo(Body var1, Body var2, Point2D var3, Vector2D var4) {
        this.field_673 = var1;
        this.field_674 = var2;
        this.field_675 = var3;
        this.field_676 = var4;
    }

    // $FF: renamed from: a () com.a.c.c
    public Body method_907() {
        return this.field_673;
    }

    // $FF: renamed from: b () com.a.c.c
    public Body method_908() {
        return this.field_674;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Point2D
    public Point2D method_909() {
        return this.field_675;
    }

    // $FF: renamed from: d () com.codeforces.commons.geometry.Vector2D
    public Vector2D method_910() {
        return this.field_676;
    }
}
