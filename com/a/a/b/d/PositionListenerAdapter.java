package com.a.a.b.d;

import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.d.d
public class PositionListenerAdapter implements PositionListener {
    // $FF: renamed from: b (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) boolean
    public boolean beforeChangePosition(Point2D oldPosition, Point2D newPosition) {
        return true;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) void
    public void afterChangePosition(Point2D oldPosition, Point2D newPosition) {
        // No operations.
    }
}
