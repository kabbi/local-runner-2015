package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.CircularForm;
import com.a.a.b.c.ArcForm;
import com.a.a.b.c.Shape;
import com.a.a.b.f.GeometryUtil;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;

// $FF: renamed from: com.a.a.b.b.b
public class ArcAndCircleCollider extends ColliderBase {
    public ArcAndCircleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.ARC && bodyB.getForm().getShape() == Shape.CIRCLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        ArcForm arcFormA = (ArcForm) bodyA.getForm();
        CircularForm circularFormB = (CircularForm) bodyB.getForm();

        double radiusA = arcFormA.getRadius();
        double radiusB = circularFormB.getRadius();
        double distance = bodyA.getPosition().getDistanceTo(bodyB.getPosition());

        if(distance > radiusA + radiusB) {
            return null;
        } else if(distance < Math.abs(radiusA - radiusB)) {
            return null;
        } else {
            bodyA.normalizeAngle();
            bodyB.normalizeAngle();

            double startAngleA = bodyA.getAngle() + arcFormA.getAngle();
            double finishAngleA = startAngleA + arcFormA.getSector();

            CollisionInfo var15 = this.collideWithEndpoints(
                    bodyA, bodyB, radiusA, radiusB, distance, startAngleA, finishAngleA
            );

            if(var15 != null) {
                return var15;
            } else if(distance < this.epsilon) {
                return this.collideSameCenter(bodyB, bodyA, arcFormA, radiusA, startAngleA, finishAngleA, radiusB);
            } else {
                double var16 = Math.sqrt((distance + radiusA + radiusB) * (distance + radiusA - radiusB) * (distance - radiusA + radiusB) * (-distance + radiusA + radiusB)) / 4.0D;
                double var18 = bodyA.getPosition().getSquaredDistanceTo(bodyB.getPosition());
                double var20 = Math.sqr(radiusA) - Math.sqr(radiusB);
                double var22 = (bodyA.getX() + bodyB.getX()) / 2.0D + (bodyB.getX() - bodyA.getX()) * var20 / (2.0D * var18);
                double var24 = (bodyA.getY() + bodyB.getY()) / 2.0D + (bodyB.getY() - bodyA.getY()) * var20 / (2.0D * var18);
                double var26 = 2.0D * (bodyA.getY() - bodyB.getY()) * var16 / var18;
                double var28 = 2.0D * (bodyA.getX() - bodyB.getX()) * var16 / var18;
                Point2D var30 = new Point2D(var22, var24);
                if(Math.abs(var26) < this.epsilon && Math.abs(var28) < this.epsilon) {
                    double var37 = (new Vector2D(bodyA.getPosition(), var30)).getAngle();
                    if(var37 < startAngleA) {
                        var37 += 6.283185307179586D;
                    }

                    if(var37 >= startAngleA && var37 <= finishAngleA) {
                        return new CollisionInfo(bodyA, bodyB, var30, (new Vector2D(bodyB.getPosition(), var30)).normalize(), radiusB - bodyB.getDistanceTo(var30), this.epsilon);
                    }
                } else {
                    Point2D var31 = var30.copy().add(var26, -var28);
                    Point2D var32 = var30.copy().add(-var26, var28);
                    double var33 = (new Vector2D(bodyA.getPosition(), var31)).getAngle();
                    if(var33 < startAngleA) {
                        var33 += 6.283185307179586D;
                    }

                    double var35 = (new Vector2D(bodyA.getPosition(), var32)).getAngle();
                    if(var35 < startAngleA) {
                        var35 += 6.283185307179586D;
                    }

                    if(var33 >= startAngleA && var33 <= finishAngleA && var35 >= startAngleA && var35 <= finishAngleA) {
                        if(distance > radiusA - this.epsilon) {
                            return new CollisionInfo(bodyA, bodyB, var30, (new Vector2D(bodyB.getPosition(), bodyA.getPosition())).normalize(), radiusA + radiusB - distance, this.epsilon);
                        }

                        return new CollisionInfo(bodyA, bodyB, var30, (new Vector2D(bodyA.getPosition(), bodyB.getPosition())).normalize(), distance + radiusB - radiusA, this.epsilon);
                    }
                }

                return null;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, double, double, double, double, double) com.a.a.b.b.f
    private CollisionInfo collideWithEndpoints(
            Body bodyA, Body bodyB, double radiusA, double radiusB, double distance, double doubleStartAngleA, double finishAngleA) {
        Point2D point1A = bodyA.getPosition().copy().add((new Vector2D(radiusA, 0.0D)).setAngle(doubleStartAngleA));
        Point2D point2A = bodyA.getPosition().copy().add((new Vector2D(radiusA, 0.0D)).setAngle(finishAngleA));

        double distanceToPoint1A = bodyB.getDistanceTo(point1A);
        double distanceToPoint2A = bodyB.getDistanceTo(point2A);

        if(distanceToPoint1A <= radiusB && distanceToPoint2A <= radiusB) {
            Point2D var19 = new Point2D((point1A.getX() + point2A.getX()) / 2.0D, (point1A.getY() + point2A.getY()) / 2.0D);
            Vector2D var20;
            Line2D var21;
            if(bodyB.getDistanceTo(var19) >= this.epsilon) {
                var20 = (new Vector2D(bodyB.getPosition(), var19)).normalize();
                var21 = Line2D.getLineByTwoPoints(bodyB.getPosition(), var19);
            } else {
                var20 = (new Vector2D(bodyB.getPosition(), bodyA.getPosition())).normalize();
                var21 = Line2D.getLineByTwoPoints(bodyB.getPosition(), bodyA.getPosition());
            }

            Point2D var22 = var21.getProjectionOf(point1A, this.epsilon);
            double var23 = var21.getDistanceFrom(point1A);
            double var25 = Math.sqrt(Math.sqr(radiusB) - Math.sqr(var23)) - bodyB.getDistanceTo(var22);
            Point2D var27 = var21.getProjectionOf(point2A, this.epsilon);
            double var28 = var21.getDistanceFrom(point2A);
            double var30 = Math.sqrt(Math.sqr(radiusB) - Math.sqr(var28)) - bodyB.getDistanceTo(var27);
            return new CollisionInfo(bodyA, bodyB, var19, var20, Math.max(var25, var30), this.epsilon);
        } else {
            return distanceToPoint1A <= radiusB?(distanceToPoint1A >= this.epsilon ?new CollisionInfo(bodyA, bodyB, point1A, (new Vector2D(bodyB.getPosition(), point1A)).normalize(), radiusB - distanceToPoint1A, this.epsilon):new CollisionInfo(bodyA, bodyB, point1A, (new Vector2D(bodyB.getPosition(), bodyA.getPosition())).normalize(), radiusA + radiusB - distance, this.epsilon)):(distanceToPoint2A <= radiusB?(distanceToPoint2A >= this.epsilon ?new CollisionInfo(bodyA, bodyB, point2A, (new Vector2D(bodyB.getPosition(), point2A)).normalize(), radiusB - distanceToPoint2A, this.epsilon):new CollisionInfo(bodyA, bodyB, point2A, (new Vector2D(bodyB.getPosition(), bodyA.getPosition())).normalize(), radiusA + radiusB - distance, this.epsilon)):null);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.a.a.b.c.a, double, double, double, double) com.a.a.b.b.f
    private CollisionInfo collideSameCenter(Body bodyA, Body bodyB, ArcForm arcFormA, double radiusA, double startAngleA, double finishAngleA, double radiusB) {
        if(radiusB < radiusA) {
            return null;
        } else {
            Vector2D relativeVelocityB = bodyA.getVelocity().copy().subtract(bodyB.getVelocity());
            Vector2D collisionNormalB;
            if(relativeVelocityB.getLength() >= this.epsilon && GeometryUtil.isAngleBetween(relativeVelocityB.getAngle(), startAngleA, finishAngleA)) {
                collisionNormalB = relativeVelocityB.normalize();
            } else if(bodyA.getVelocity().getLength() >= this.epsilon && GeometryUtil.isAngleBetween(bodyA.getVelocity().getAngle(), startAngleA, finishAngleA)) {
                collisionNormalB = bodyA.getVelocity().copy().normalize();
            } else {
                collisionNormalB = (new Vector2D(1.0D, 0.0D)).setAngle(bodyB.getAngle() + arcFormA.getAngle() + arcFormA.getSector() / 2.0D);
            }

            return new CollisionInfo(bodyB, bodyA, bodyA.getPosition().copy(), collisionNormalB, radiusB - radiusA, this.epsilon);
        }
    }
}
