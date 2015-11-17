package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Shape;

// $FF: renamed from: com.a.a.b.b.a
public class ArcAndArcCollider extends ColliderBase {
    public ArcAndArcCollider(double var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.ARC && bodyB.getForm().getShape() == Shape.ARC;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        return null;
    }
}
