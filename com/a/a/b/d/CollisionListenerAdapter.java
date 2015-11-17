package com.a.a.b.d;

import com.a.a.b.Body;
import com.a.a.b.b.CollisionInfo;

// $FF: renamed from: com.a.a.b.d.b
public class CollisionListenerAdapter implements CollisionListener {
    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    public boolean beforeStartingCollision(Body bodyA, Body bodyB) {
        return true;
    }

    // $FF: renamed from: a (com.a.a.b.b.f) boolean
    public boolean beforeResolvingCollision(CollisionInfo collisionInfo) {
        return true;
    }

    // $FF: renamed from: b (com.a.a.b.b.f) void
    public void afterResolvingCollision(CollisionInfo collisionInfo) {
        // No operations.
    }
}
