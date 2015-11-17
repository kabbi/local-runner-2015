package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Form;

// $FF: renamed from: com.a.a.b.b.e
public abstract class ColliderBase implements Collider {
    // $FF: renamed from: a double
    protected final double epsilon;

    protected ColliderBase(double epsilon) {
        this.epsilon = epsilon;
    }

    // $FF: renamed from: c (com.a.a.b.a, com.a.a.b.a) boolean
    public final boolean matches(Body bodyA, Body bodyB) {
        return this.matchesOneWay(bodyA, bodyB) || this.matchesOneWay(bodyB, bodyA);
    }

    // $FF: renamed from: d (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    public final CollisionInfo collide(Body bodyA, Body bodyB) {
        if(this.matchesOneWay(bodyA, bodyB)) {
            return this.collideOneWay(bodyA, bodyB);
        } else if(this.matchesOneWay(bodyB, bodyA)) {
            CollisionInfo collisionInfo = this.collideOneWay(bodyB, bodyA);
            return collisionInfo == null ? null : new CollisionInfo(bodyA, bodyB, collisionInfo.getPoint(), collisionInfo.getNormalB().negate(), collisionInfo.getDepth(), this.epsilon);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported %s of %s or %s of %s.", Form.toString(bodyA.getForm()), bodyA, Form.toString(bodyB.getForm()), bodyB));
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected abstract boolean matchesOneWay(Body bodyA, Body bodyB);

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected abstract CollisionInfo collideOneWay(Body bodyA, Body bodyB);
}
