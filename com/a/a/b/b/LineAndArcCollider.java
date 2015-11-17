package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Shape;

// $FF: renamed from: com.a.a.b.b.g
public class LineAndArcCollider extends ColliderBase {
    public LineAndArcCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.LINE && bodyB.getForm().getShape() == Shape.ARC;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        return null; // TODO
    }
}
