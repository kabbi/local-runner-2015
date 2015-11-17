package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.CircularForm;
import com.a.a.b.c.LinearForm;
import com.a.a.b.c.Shape;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.b.h
public class LineAndCircleCollider extends ColliderBase {
    public LineAndCircleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.LINE && bodyB.getForm().getShape() == Shape.CIRCLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        LinearForm linearFormA = (LinearForm) bodyA.getForm();
        CircularForm circularFormB = (CircularForm) bodyB.getForm();

        Point2D point1A = linearFormA.getPoint1(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);
        Point2D point2A = linearFormA.getPoint2(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);

        return collideOneWay(bodyA, bodyB, point1A, point2A, circularFormB, this.epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.a.a.b.c.b, double) com.a.a.b.b.f
    static CollisionInfo collideOneWay(Body bodyA, Body bodyB,
                                       Point2D point1A, Point2D point2A,
                                       CircularForm circularFormB, double epsilon) {
        Line2D lineA = Line2D.getLineByTwoPoints(point1A, point2A);

        double distanceFromB = lineA.getDistanceFrom(bodyB.getPosition());
        double radiusB = circularFormB.getRadius();

        if(distanceFromB > radiusB) {
            return null;
        } else {
            double leftA = Math.min(point1A.getX(), point2A.getX());
            double topA = Math.min(point1A.getY(), point2A.getY());
            double rightA = Math.max(point1A.getX(), point2A.getX());
            double bottomA = Math.max(point1A.getY(), point2A.getY());

            Point2D projectionOfB = lineA.getProjectionOf(bodyB.getPosition());

            boolean var21 = projectionOfB.getX() > leftA - epsilon && projectionOfB.getX() < rightA + epsilon && projectionOfB.getY() > topA - epsilon && projectionOfB.getY() < bottomA + epsilon;
            if(var21) {
                Vector2D collisionNormalB;
                if(distanceFromB >= epsilon) {
                    collisionNormalB = (new Vector2D(bodyB.getPosition(), projectionOfB)).normalize();
                } else {
                    Vector2D unitNormalA = lineA.getUnitNormal();
                    Vector2D relativeVelocityB = bodyB.getVelocity().copy().subtract(bodyA.getVelocity());

                    if(relativeVelocityB.getLength() >= epsilon) {
                        collisionNormalB = relativeVelocityB.dotProduct(unitNormalA) >= epsilon?unitNormalA:unitNormalA.negate();
                    } else if(bodyB.getVelocity().getLength() >= epsilon) {
                        collisionNormalB = bodyB.getVelocity().dotProduct(unitNormalA) >= epsilon?unitNormalA:unitNormalA.negate();
                    } else {
                        collisionNormalB = unitNormalA;
                    }
                }

                return new CollisionInfo(bodyA, bodyB, projectionOfB, collisionNormalB, radiusB - distanceFromB, epsilon);
            } else {
                double distanceToPoint1A = bodyB.getDistanceTo(point1A);
                double distanceToPoint2A = bodyB.getDistanceTo(point2A);

                Point2D nearestPointA;
                double distanceToNearestPointA;

                if(distanceToPoint1A < distanceToPoint2A) {
                    nearestPointA = point1A;
                    distanceToNearestPointA = distanceToPoint1A;
                } else {
                    nearestPointA = point2A;
                    distanceToNearestPointA = distanceToPoint2A;
                }

                return distanceToNearestPointA > radiusB ? null : new CollisionInfo(
                        bodyA, bodyB, nearestPointA, (new Vector2D(bodyB.getPosition(), nearestPointA)).normalize(),
                        radiusB - distanceToNearestPointA, epsilon);
            }
        }
    }
}
