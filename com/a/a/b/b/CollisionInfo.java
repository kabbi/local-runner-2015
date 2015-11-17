package com.a.a.b.b;

import com.a.a.b.Body;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.text.StringUtil;
import org.apache.log4j.Logger;

// $FF: renamed from: com.a.a.b.b.f
public class CollisionInfo {
    // $FF: renamed from: a org.apache.log4j.Logger
    private static final Logger logger = Logger.getLogger(CollisionInfo.class);

    // $FF: renamed from: b com.a.a.b.a
    private final Body bodyA;
    // $FF: renamed from: c com.a.a.b.a
    private final Body bodyB;

    // $FF: renamed from: d com.codeforces.commons.geometry.Point2D
    private final Point2D point;
    // $FF: renamed from: e com.codeforces.commons.geometry.Vector2D
    private final Vector2D normalB;
    // $FF: renamed from: f double
    private final double depth;

    public CollisionInfo(Body bodyA, Body bodyB, Point2D point, Vector2D normalB, double depth, double epsilon) {
        this.bodyA = bodyA;
        this.bodyB = bodyB;
        this.point = point;
        this.normalB = normalB;
        if(depth < 0.0D && depth > -epsilon) {
            this.depth = 0.0D;
        } else {
            this.depth = depth;
        }

        if(Double.isNaN(this.depth) || Double.isInfinite(this.depth) || this.depth < 0.0D) {
            logger.error(String.format("Argument \'depth\' should be non-negative number but got %s (%s and %s).", this.depth, bodyA, bodyB));
        }

    }

    // $FF: renamed from: a () com.a.a.b.a
    public Body getBodyA() {
        return this.bodyA;
    }

    // $FF: renamed from: b () com.a.a.b.a
    public Body getBodyB() {
        return this.bodyB;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Point2D
    public Point2D getPoint() {
        return this.point.copy();
    }

    // $FF: renamed from: d () com.codeforces.commons.geometry.Vector2D
    public Vector2D getNormalB() {
        return this.normalB.copy();
    }

    // $FF: renamed from: e () double
    public double getDepth() {
        return this.depth;
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }
}
