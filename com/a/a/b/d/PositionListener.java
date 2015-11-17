package com.a.a.b.d;

import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.d.c
public interface PositionListener {
    // $FF: renamed from: b (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) boolean
    boolean beforeChangePosition(Point2D oldPosition, Point2D newPosition);

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) void
    void afterChangePosition(Point2D oldPosition, Point2D newPosition);
}
