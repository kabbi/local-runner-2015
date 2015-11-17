package com.a.c.a;

// $FF: renamed from: com.a.c.a.c
public abstract class PhysicalForm {
    // $FF: renamed from: a boolean
    private boolean endpointCollisionEnabled = true;

    // $FF: renamed from: e () boolean
    public boolean isEndpointCollisionEnabled() {
        return this.endpointCollisionEnabled;
    }

    // $FF: renamed from: a (boolean) void
    public void setEndpointCollisionEnabled(boolean endpointCollisionEnabled) {
        this.endpointCollisionEnabled = endpointCollisionEnabled;
    }

    // $FF: renamed from: d () com.a.c.a.c
    public abstract PhysicalForm copy();

    // $FF: renamed from: a (com.a.c.a.c, double) boolean
    public abstract boolean equals(PhysicalForm other, double epsilon);
}
