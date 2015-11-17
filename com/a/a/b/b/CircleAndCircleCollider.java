package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.CircularForm;
import com.a.a.b.c.Shape;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b.c
public class CircleAndCircleCollider extends ColliderBase {
    public CircleAndCircleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.CIRCLE && bodyB.getForm().getShape() == Shape.CIRCLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        CircularForm circularFormA = (CircularForm) bodyA.getForm();
        CircularForm circularFormB = (CircularForm) bodyB.getForm();

        double radiusA = circularFormA.getRadius();
        double radiusB = circularFormB.getRadius();
        double distance = bodyA.getPosition().getDistanceTo(bodyB.getPosition());

        if(distance > radiusA + radiusB) {
            return null;
        } else {
            Vector2D collisionNormalB;
            Point2D collisionPoint;
            Vector2D vectorBA;
            if(distance >= this.epsilon) {
                vectorBA = new Vector2D(bodyB.getPosition(), bodyA.getPosition());
                collisionNormalB = vectorBA.copy().normalize();
                collisionPoint = bodyB.getPosition().copy().add(vectorBA.copy().multiply(radiusB / (radiusA + radiusB)));
            } else {
                vectorBA = bodyB.getVelocity().copy().subtract(bodyA.getVelocity());
                if(vectorBA.getLength() >= this.epsilon) {
                    collisionNormalB = vectorBA.normalize();
                } else if(bodyB.getVelocity().getLength() >= this.epsilon) {
                    collisionNormalB = bodyB.getVelocity().copy().normalize();
                } else {
                    collisionNormalB = new Vector2D(1.0D, 0.0D);
                }

                collisionPoint = bodyB.getPosition().copy();
            }

            return new CollisionInfo(bodyA, bodyB, collisionPoint, collisionNormalB, radiusA + radiusB - distance, this.epsilon);
        }
    }
}
