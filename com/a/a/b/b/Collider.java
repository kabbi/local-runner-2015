package com.a.a.b.b;

import com.a.a.b.Body;

// $FF: renamed from: com.a.a.b.b.d
public interface Collider {
    // $FF: renamed from: c (com.a.a.b.a, com.a.a.b.a) boolean
    boolean matches(Body bodyA, Body bodyB);

    // $FF: renamed from: d (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    CollisionInfo collide(Body bodyA, Body bodyB);
}
