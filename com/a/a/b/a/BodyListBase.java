package com.a.a.b.a;

import com.a.a.b.Body;

// $FF: renamed from: com.a.a.b.a.b
public abstract class BodyListBase implements BodyList {
    // $FF: renamed from: e (com.a.a.b.a) void
    protected static void validateBody(Body body) {
        if(body == null) {
            throw new IllegalArgumentException("Argument \'body\' is null.");
        }
    }
}
