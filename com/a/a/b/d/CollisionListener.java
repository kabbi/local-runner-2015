package com.a.a.b.d;

import com.a.a.b.Body;
import com.a.a.b.b.CollisionInfo;

// $FF: renamed from: com.a.a.b.d.a
public interface CollisionListener {
    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    boolean beforeStartingCollision(Body bodyA, Body bodyB);

    // $FF: renamed from: a (com.a.a.b.b.f) boolean
    boolean beforeResolvingCollision(CollisionInfo collisionInfo);

    // $FF: renamed from: b (com.a.a.b.b.f) void
    void afterResolvingCollision(CollisionInfo collisionInfo);
}
