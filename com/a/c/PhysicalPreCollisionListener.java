package com.a.c;

// $FF: renamed from: com.a.c.d
public interface PhysicalPreCollisionListener extends PhysicalCollisionListener {
    // $FF: renamed from: a (com.a.c.c, com.a.c.c) boolean
    boolean beforeStartingCollision(PhysicalBody bodyA, PhysicalBody bodyB);

    // $FF: renamed from: b (com.a.c.a) boolean
    boolean beforeResolvingCollision(PhysicalCollisionInfo collisionInfo);
}
