package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Shape;
import org.apache.commons.lang3.NotImplementedException;

// $FF: renamed from: com.a.a.b.b.i
public class LineAndLineCollider extends ColliderBase {
    public LineAndLineCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.LINE && bodyB.getForm().getShape() == Shape.LINE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    public CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        throw new NotImplementedException("Soon, very soon. Maybe...");
    }
}
