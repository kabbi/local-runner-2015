package com.a.a.b.a;

import com.a.a.b.Body;
import java.util.List;

// $FF: renamed from: com.a.a.b.a.a
public interface BodyList {
    // $FF: renamed from: a (com.a.a.b.a) void
    void addBody(Body body);

    // $FF: renamed from: b (com.a.a.b.a) void
    void removeBody(Body body);

    // $FF: renamed from: c (com.a.a.b.a) boolean
    boolean hasBody(Body body);

    // $FF: renamed from: a () java.util.List
    List<Body> getBodies();

    // $FF: renamed from: d (com.a.a.b.a) java.util.List
    List<Body> getPotentialIntersections(Body body);
}
