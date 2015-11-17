package com.a.c;

// $FF: renamed from: com.a.c.e
public interface PhysicsManager {
    // $FF: renamed from: a (com.a.c.c) com.a.c.c
    PhysicalBody addPhysicalBody(PhysicalBody var1);

    // $FF: renamed from: b (com.a.c.c) void
    void syncPhysicalBody(PhysicalBody var1);

    // $FF: renamed from: c (com.a.c.c) void
    void safeSyncPhysicalBody(PhysicalBody var1);

    // $FF: renamed from: d (com.a.c.c) com.a.c.c
    PhysicalBody removePhysicalBody(PhysicalBody var1);

    // $FF: renamed from: a () void
    void proceed();

    // $FF: renamed from: a (com.a.c.b) void
    void registerCollisionListener(PhysicalCollisionListener var1);

    // $FF: renamed from: b () int
    int getStepCountPerTimeUnit();
}
