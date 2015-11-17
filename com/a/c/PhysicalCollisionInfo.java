package com.a.c;

import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.c.a
public final class PhysicalCollisionInfo {
    // $FF: renamed from: a com.a.c.c
    private final PhysicalBody bodyA;
    // $FF: renamed from: b com.a.c.c
    private final PhysicalBody bodyB;
    // $FF: renamed from: c com.codeforces.commons.geometry.Point2D
    private final Point2D point;
    // $FF: renamed from: d com.codeforces.commons.geometry.Vector2D
    private final Vector2D normalB;

    public PhysicalCollisionInfo(PhysicalBody bodyA, PhysicalBody bodyB, Point2D point, Vector2D normalB) {
        this.bodyA = bodyA;
        this.bodyB = bodyB;
        this.point = point;
        this.normalB = normalB;
    }

    // $FF: renamed from: a () com.a.c.c
    public PhysicalBody getBodyA() {
        return this.bodyA;
    }

    // $FF: renamed from: b () com.a.c.c
    public PhysicalBody getBodyB() {
        return this.bodyB;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Point2D
    public Point2D getPoint() {
        return this.point;
    }

    // $FF: renamed from: d () com.codeforces.commons.geometry.Vector2D
    public Vector2D getNormalB() {
        return this.normalB;
    }
}
