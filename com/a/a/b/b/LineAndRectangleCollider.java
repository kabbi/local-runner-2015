package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.RectangularForm;
import com.a.a.b.c.LinearForm;
import com.a.a.b.c.Shape;
import com.a.a.b.f.GeometryUtil;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.a.a.b.b.j
public class LineAndRectangleCollider extends ColliderBase {
    public LineAndRectangleCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.LINE && bodyB.getForm().getShape() == Shape.RECTANGLE;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        LinearForm linearFormA = (LinearForm) bodyA.getForm();
        RectangularForm rectangularFormB = (RectangularForm) bodyB.getForm();

        Point2D point1A = linearFormA.getPoint1(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);
        Point2D point2A = linearFormA.getPoint2(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);

        Line2D lineA = Line2D.getLineByTwoPoints(point1A, point2A);

        if(lineA.getDistanceFrom(bodyB.getPosition()) > rectangularFormB.getCircumcircleRadius()) {
            return null;
        } else {
            Point2D[] pointsB = rectangularFormB.getPoints(bodyB.getPosition(), bodyB.getAngle(), this.epsilon);
            int pointBCount = pointsB.length;

            Line2D intersectionLineB = null;
            List<Point2D> intersectionPoints = new ArrayList<>(pointBCount);
            int intersectionCount = 0;

            double left;
            double top;
            double right;
            double bottom;

            for(int var13 = 0; var13 < pointBCount; ++var13) {
                Point2D point1B = pointsB[var13];
                Point2D point2B = pointsB[var13 == pointBCount - 1?0:var13 + 1];

                Line2D lineB = Line2D.getLineByTwoPoints(point1B, point2B);

                Point2D potentialIntersectionPoint = lineA.getIntersectionPoint(lineB, this.epsilon);

                if(potentialIntersectionPoint != null) {
                    left = Math.max(Math.min(point1A.getX(), point2A.getX()), Math.min(point1B.getX(), point2B.getX()));
                    top = Math.max(Math.min(point1A.getY(), point2A.getY()), Math.min(point1B.getY(), point2B.getY()));
                    right = Math.min(Math.max(point1A.getX(), point2A.getX()), Math.max(point1B.getX(), point2B.getX()));
                    bottom = Math.min(Math.max(point1A.getY(), point2A.getY()), Math.max(point1B.getY(), point2B.getY()));

                    if(potentialIntersectionPoint.getX() > left - this.epsilon && potentialIntersectionPoint.getX() < right + this.epsilon && potentialIntersectionPoint.getY() > top - this.epsilon && potentialIntersectionPoint.getY() < bottom + this.epsilon) {
                        intersectionLineB = lineB;
                        boolean alreadyAdded = false;

                        for (Point2D intersectionPoint : intersectionPoints) {
                            if (intersectionPoint.nearlyEquals(potentialIntersectionPoint, this.epsilon)) {
                                alreadyAdded = true;
                                break;
                            }
                        }

                        if(!alreadyAdded) {
                            intersectionPoints.add(potentialIntersectionPoint);
                        }

                        ++intersectionCount;
                    }
                }
            }

            // FIXME
            if(intersectionCount != 1 || !linearFormA.isEndpointCollisionEnabled() || GeometryUtil.isPointInsideConvexPolygon(point1A, pointsB, this.epsilon) && GeometryUtil.isPointInsideConvexPolygon(point2A, pointsB, this.epsilon)) {
                Point2D pointBWithMinDistanceFromA = pointsB[0];
                double minDistanceBFromA = lineA.getSignedDistanceFrom(pointBWithMinDistanceFromA);

                Point2D pointBWithMaxDistanceFromA = pointBWithMinDistanceFromA;
                double maxDistanceBFromA = minDistanceBFromA;

                for(int pointBIndex = 1; pointBIndex < pointBCount; ++pointBIndex) {
                    Point2D pointB = pointsB[pointBIndex];
                    double distanceBFromA = lineA.getSignedDistanceFrom(pointB);

                    if(distanceBFromA < minDistanceBFromA) {
                        minDistanceBFromA = distanceBFromA;
                        pointBWithMinDistanceFromA = pointB;
                    }

                    if(distanceBFromA > maxDistanceBFromA) {
                        maxDistanceBFromA = distanceBFromA;
                        pointBWithMaxDistanceFromA = pointB;
                    }
                }

                if((minDistanceBFromA >= 0.0D || maxDistanceBFromA >= 0.0D) && (minDistanceBFromA <= 0.0D || maxDistanceBFromA <= 0.0D)) {
                    if(intersectionPoints.isEmpty()) { // TODO check line inside rectangle
                        return null;
                    } else {
                        Vector2D collisionNormalB;
                        if(lineA.getSignedDistanceFrom(bodyB.getPosition()) > 0.0D) {
                            collisionNormalB = lineA.getParallelLine(pointBWithMinDistanceFromA).getUnitNormalFrom(pointBWithMaxDistanceFromA);
                            top = Math.abs(minDistanceBFromA);
                        } else {
                            collisionNormalB = lineA.getParallelLine(pointBWithMaxDistanceFromA).getUnitNormalFrom(pointBWithMinDistanceFromA);
                            top = maxDistanceBFromA;
                        }

                        right = 0.0D;
                        bottom = 0.0D;

                        Point2D var40;
                        for(Iterator var39 = intersectionPoints.iterator(); var39.hasNext(); bottom += var40.getY() / (double)intersectionPoints.size()) {
                            var40 = (Point2D)var39.next();
                            right += var40.getX() / (double)intersectionPoints.size();
                        }

                        return new CollisionInfo(bodyA, bodyB, new Point2D(right, bottom), collisionNormalB, top, this.epsilon);
                    }
                } else {
                    return null;
                }
            } else {
                Vector2D collisionNormalB = new Vector2D(
                        bodyB.getPosition(), intersectionLineB.getProjectionOf(bodyB.getPosition())
                ).normalize();

                Line2D parallelLine1A = intersectionLineB.getParallelLine(point1A);
                double distance1AFromB = parallelLine1A.getDistanceFrom(bodyB.getPosition());

                Line2D parallelLine2A = intersectionLineB.getParallelLine(point2A);
                left = parallelLine2A.getDistanceFrom(bodyB.getPosition());
                top = (distance1AFromB < left?parallelLine1A:parallelLine2A).getDistanceFrom(intersectionLineB, this.epsilon);

                return new CollisionInfo(bodyA, bodyB, intersectionPoints.get(0), collisionNormalB, top, this.epsilon);
            }
        }
    }
}
