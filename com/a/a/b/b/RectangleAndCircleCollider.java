package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.CircularForm;
import com.a.a.b.c.RectangularForm;
import com.a.a.b.c.Shape;
import com.a.a.b.f.GeometryUtil;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.b.m
public class RectangleAndCircleCollider extends ColliderBase {
    public RectangleAndCircleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.RECTANGLE && bodyB.getForm().getShape() == Shape.CIRCLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        RectangularForm rectangularFormA = (RectangularForm) bodyA.getForm();
        CircularForm circularFormB = (CircularForm) bodyB.getForm();

        Point2D[] pointsA = rectangularFormA.getPoints(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);
        int pointACount = pointsA.length;

        if(!GeometryUtil.isPointInsideConvexPolygon(bodyB.getPosition(), pointsA, this.epsilon)) {
            double minDistanceFromB = Double.POSITIVE_INFINITY;
            Line2D nearestLineA = null;

            for(int pointAIndex = 0; pointAIndex < pointACount; ++pointAIndex) {
                Point2D point1A = pointsA[pointAIndex];
                Point2D point2A = pointsA[pointAIndex == pointACount - 1 ? 0 : pointAIndex + 1];

                Line2D lineA = Line2D.getLineByTwoPoints(point1A, point2A);
                double distanceFromB = lineA.getDistanceFrom(bodyB.getPosition());

                if(distanceFromB < minDistanceFromB) {
                    minDistanceFromB = distanceFromB;
                    nearestLineA = lineA;
                }
            }

            if(nearestLineA != null) {
                return new CollisionInfo(bodyA, bodyB, bodyB.getPosition(), nearestLineA.getUnitNormal().negate(), circularFormB.getRadius() - nearestLineA.getSignedDistanceFrom(bodyB.getPosition()), this.epsilon);
            }
        }

        CollisionInfo collisionInfo = null;

        for(int pointAIndex = 0; pointAIndex < pointACount; ++pointAIndex) {
            Point2D point1A = pointsA[pointAIndex];
            Point2D point2A = pointsA[pointAIndex == pointACount - 1?0:pointAIndex + 1];
            CollisionInfo lineCollisionInfo = LineAndCircleCollider.collideOneWay(
                    bodyA, bodyB, point1A, point2A, circularFormB, this.epsilon
            );

            if(lineCollisionInfo != null && (collisionInfo == null || lineCollisionInfo.getDepth() > collisionInfo.getDepth())) {
                collisionInfo = lineCollisionInfo;
            }
        }

        return collisionInfo;
    }
}
