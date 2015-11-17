package com.a.a.b.c;

// $FF: renamed from: com.a.a.b.c.g
public abstract class ThinForm extends Form {
    // $FF: renamed from: a boolean
    private final boolean endpointCollisionEnabled;

    protected ThinForm(Shape shape, boolean endpointCollisionEnabled) {
        super(shape);
        this.endpointCollisionEnabled = endpointCollisionEnabled;
    }

    // $FF: renamed from: f () boolean
    public boolean isEndpointCollisionEnabled() {
        return this.endpointCollisionEnabled;
    }
}
