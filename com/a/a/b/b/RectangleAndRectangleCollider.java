package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Form;
import com.a.a.b.c.RectangularForm;
import com.a.a.b.c.Shape;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b.n
public class RectangleAndRectangleCollider extends ColliderBase {
    public RectangleAndRectangleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.RECTANGLE && bodyB.getForm().getShape() == Shape.RECTANGLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        RectangularForm rectangularFormA = (RectangularForm) bodyA.getForm();
        RectangularForm rectangularFormB = (RectangularForm) bodyB.getForm();

        Point2D[] pointsA = rectangularFormA.getPoints(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);
        Point2D[] pointsB = rectangularFormB.getPoints(bodyB.getPosition(), bodyB.getAngle(), this.epsilon);

        CollisionInfo collisionInfoA = this.collideOneWay(bodyA, bodyB, pointsA, pointsB);
        if(collisionInfoA == null) {
            return null;
        } else {
            CollisionInfo collisionInfoB = this.collideOneWay(bodyB, bodyA, pointsB, pointsA);
            return collisionInfoB == null ? null
                    : (collisionInfoB.getDepth() < collisionInfoA.getDepth() ?
                        new CollisionInfo(bodyA, bodyB, collisionInfoB.getPoint(), collisionInfoB.getNormalB().negate(), collisionInfoB.getDepth(), this.epsilon)
                        : collisionInfoA);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.codeforces.commons.geometry.Point2D[], com.codeforces.commons.geometry.Point2D[]) com.a.a.b.b.f
    private CollisionInfo collideOneWay(Body bodyA, Body bodyB, Point2D[] pointsA, Point2D[] pointsB) {
        int pointACount = pointsA.length;
        int pointBCount = pointsB.length;

        double minDepth = Double.POSITIVE_INFINITY;
        Point2D bestIntersectionPoint = null;
        Vector2D bestCollisionNormalB = null;

        for(int pointAIndex = 0; pointAIndex < pointACount; ++pointAIndex) {
            Point2D point1A = pointsA[pointAIndex];
            Point2D point2A = pointsA[pointAIndex == pointACount - 1 ? 0 : pointAIndex + 1];

            Line2D lineA = Line2D.getLineByTwoPoints(point1A, point2A);
            if(lineA.getSignedDistanceFrom(bodyA.getPosition()) > -this.epsilon) {
                throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{Form.toString(bodyA.getForm()), bodyA}));
            }

            double minDistanceFromB = Double.POSITIVE_INFINITY;
            Point2D intersectionPoint = null;
            Vector2D collisionNormalB = null;

            for(int pointBIndex = 0; pointBIndex < pointBCount; ++pointBIndex) {
                Point2D pointB = pointsB[pointBIndex];
                double distanceFromPointB = lineA.getSignedDistanceFrom(pointB);

                if(distanceFromPointB < minDistanceFromB) {
                    minDistanceFromB = distanceFromPointB;
                    intersectionPoint = pointB;
                    collisionNormalB = lineA.getUnitNormalFrom(bodyA.getPosition(), this.epsilon).negate();
                }
            }

            if(minDistanceFromB > 0.0D) {
                return null;
            }

            double depth = -minDistanceFromB;
            if(depth < minDepth) {
                minDepth = depth;
                bestIntersectionPoint = intersectionPoint;
                bestCollisionNormalB = collisionNormalB;
            }
        }

        if(bestIntersectionPoint != null && bestCollisionNormalB != null) {
            return new CollisionInfo(bodyA, bodyB, bestIntersectionPoint, bestCollisionNormalB, minDepth, this.epsilon);
        } else {
            return null;
        }
    }
}
