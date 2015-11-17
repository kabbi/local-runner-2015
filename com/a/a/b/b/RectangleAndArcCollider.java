package com.a.a.b.b;

import com.a.a.b.Body;
import com.a.a.b.c.Form;
import com.a.a.b.c.RectangularForm;
import com.a.a.b.c.ArcForm;
import com.a.a.b.c.Shape;
import com.a.a.b.f.GeometryUtil;
import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.holder.Mutable;
import com.codeforces.commons.holder.SimpleMutable;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.SimplePair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.a.a.b.b.k
public class RectangleAndArcCollider extends ColliderBase {
    public RectangleAndArcCollider(double epsilon) {
        super(epsilon);
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
    protected boolean matchesOneWay(Body bodyA, Body bodyB) {
        return bodyA.getForm().getShape() == Shape.RECTANGLE && bodyB.getForm().getShape() == Shape.ARC;
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a) com.a.a.b.b.f
    protected CollisionInfo collideOneWay(Body bodyA, Body bodyB) {
        RectangularForm var3 = (RectangularForm) bodyA.getForm();
        ArcForm var4 = (ArcForm) bodyB.getForm();
        double var5 = var3.getCircumcircleRadius();
        double var7 = var4.getRadius();
        double var9 = bodyA.getPosition().getDistanceTo(bodyB.getPosition());
        if(var9 > var5 + var7) {
            return null;
        } else if(var9 < Math.abs(var5 - var7)) {
            return null;
        } else {
            Point2D[] var11 = var3.getPoints(bodyA.getPosition(), bodyA.getAngle(), this.epsilon);
            int var12 = var11.length;
            double var13 = var7 * var7;
            double var15 = bodyB.getAngle() + var4.getAngle();
            double var17 = var15 + var4.getSector();
            Point2D var19 = bodyB.getPosition().copy().add((new Vector2D(var7, 0.0D)).setAngle(var15));
            Point2D var20 = bodyB.getPosition().copy().add((new Vector2D(var7, 0.0D)).setAngle(var17));
            ArrayList var21 = new ArrayList();

            int var22;
            Line2D var25;
            double var26;
            double var28;
            for(var22 = 0; var22 < var12; ++var22) {
                Point2D var23 = var11[var22];
                Point2D var24 = var11[var22 == var12 - 1?0:var22 + 1];
                var25 = Line2D.getLineByTwoPoints(var23, var24);
                if(var25.getSignedDistanceFrom(bodyA.getPosition()) > -this.epsilon) {
                    throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{Form.toString(bodyA.getForm()), bodyA}));
                }

                var26 = var25.getSignedDistanceFrom(bodyB.getPosition());
                if(var26 <= var7) {
                    var28 = Math.min(var23.getX(), var24.getX());
                    double var30 = Math.min(var23.getY(), var24.getY());
                    double var32 = Math.max(var23.getX(), var24.getX());
                    double var34 = Math.max(var23.getY(), var24.getY());
                    Point2D var36 = var25.getProjectionOf(bodyB.getPosition());
                    double var37 = Math.sqrt(var13 - var26 * var26);
                    Vector2D var39 = (new Vector2D(var23, var24)).copy().setLength(var37);
                    Point2D var40 = var36.copy().add(var39);
                    if(this.doesPointBelongToAAndB(var40, var28, var30, var32, var34, bodyB, var15, var17)) {
                        this.addIntersectionInfo(var40, var23, var24, var25, var21);
                    }

                    Point2D var41 = var36.copy().add(var39.copy().negate());
                    if(this.doesPointBelongToAAndB(var41, var28, var30, var32, var34, bodyB, var15, var17)) {
                        this.addIntersectionInfo(var41, var23, var24, var25, var21);
                    }
                }
            }

            var22 = var21.size();
            if(var22 == 0) {
                return null;
                // FIXME
            } else if(var22 != 1 || !var4.isEndpointCollisionEnabled() || GeometryUtil.isPointInsideConvexPolygon(var19, var11, this.epsilon) && GeometryUtil.isPointInsideConvexPolygon(var20, var11, this.epsilon)) {
                Vector2D var43 = new Vector2D(((IntersectionInfo)var21.get(0)).intersectionPoint, bodyB.getPosition());
                Vector2D var45 = new Vector2D(((IntersectionInfo)var21.get(0)).intersectionPoint, bodyA.getPosition());
                Iterator var27;
                Iterator var29;
                SimpleMutable var46;
                SimpleMutable var47;
                IntersectionInfo var48;
                SimplePair var50;
                if(var9 > var7 - this.epsilon && var43.dotProduct(var45) < 0.0D) {
                    var46 = new SimpleMutable();
                    var47 = new SimpleMutable();
                    var27 = var21.iterator();

                    while(var27.hasNext()) {
                        var48 = (IntersectionInfo)var27.next();
                        this.updateNearestPoint(bodyB, var48.intersectionPoint, var46, var47);
                        var29 = var48.intersectionLinePointPairs.iterator();

                        while(var29.hasNext()) {
                            var50 = (SimplePair)var29.next();
                            this.updateNearestPoint(bodyB, (Point2D) var50.getFirst(), var46, var47);
                            this.updateNearestPoint(bodyB, (Point2D) var50.getSecond(), var46, var47);
                        }
                    }

                    return var46.get() == null?null:new CollisionInfo(bodyA, bodyB, (Point2D)var46.get(), (new Vector2D(bodyB.getPosition(), (Point2D)var46.get())).normalize(), var7 - (Double) var47.get(), this.epsilon);
                } else {
                    var46 = new SimpleMutable();
                    var47 = new SimpleMutable();
                    var27 = var21.iterator();

                    while(var27.hasNext()) {
                        var48 = (IntersectionInfo)var27.next();
                        updateFarthestPoint(bodyB, var48.intersectionPoint, var46, var47, var15, var17);
                        var29 = var48.intersectionLinePointPairs.iterator();

                        while(var29.hasNext()) {
                            var50 = (SimplePair)var29.next();
                            updateFarthestPoint(bodyB, (Point2D) var50.getFirst(), var46, var47, var15, var17);
                            updateFarthestPoint(bodyB, (Point2D) var50.getSecond(), var46, var47, var15, var17);
                        }
                    }

                    return var46.get() == null?null:new CollisionInfo(bodyA, bodyB, (Point2D)var46.get(), (new Vector2D((Point2D)var46.get(), bodyB.getPosition())).normalize(), (Double) var47.get() - var7, this.epsilon);
                }
            } else {
                IntersectionInfo var42 = (IntersectionInfo)var21.get(0);
                int var44 = var42.intersectionLines.size();
                if(var44 != 1 && var44 != 2) {
                    throw new IllegalStateException(String.format("%s of %s is too small, does not represent a convex polygon, or its points are going in wrong order.", new Object[]{Form.toString(bodyA.getForm()), bodyA}));
                } else {
                    var25 = (Line2D)var42.intersectionLines.get(0);
                    var26 = var25.getSignedDistanceFrom(var19);
                    var28 = var25.getSignedDistanceFrom(var20);

                    for(int var49 = 0; var49 < var12; ++var49) {
                        Point2D var31 = var11[var49];
                        Point2D var51 = var11[var49 == var12 - 1?0:var49 + 1];
                        Line2D var33 = Line2D.getLineByTwoPoints(var31, var51);
                        if(var33.getSignedDistanceFrom(var19) >= this.epsilon) {
                            return new CollisionInfo(bodyA, bodyB, var20, var25.getUnitNormal().negate(), -var28, this.epsilon);
                        }

                        if(var33.getSignedDistanceFrom(var20) >= this.epsilon) {
                            return new CollisionInfo(bodyA, bodyB, var19, var25.getUnitNormal().negate(), -var26, this.epsilon);
                        }
                    }

                    if(var26 < var28) {
                        return new CollisionInfo(bodyA, bodyB, var19, var25.getUnitNormal().negate(), -var26, this.epsilon);
                    } else {
                        return new CollisionInfo(bodyA, bodyB, var20, var25.getUnitNormal().negate(), -var28, this.epsilon);
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.holder.Mutable, com.codeforces.commons.holder.Mutable) void
    private void updateNearestPoint(Body var1, Point2D var2, Mutable var3, Mutable var4) {
        double var5 = var1.getDistanceTo(var2);
        if(var5 >= this.epsilon && (var3.get() == null || var5 < (Double) var4.get())) {
            var3.set(var2);
            var4.set(var5);
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.holder.Mutable, com.codeforces.commons.holder.Mutable, double, double) void
    private static void updateFarthestPoint(Body var0, Point2D var1, Mutable var2, Mutable var3, double var4, double var6) {
        double var8 = var0.getDistanceTo(var1);
        if(GeometryUtil.isAngleBetween((new Vector2D(var0.getPosition(), var1)).getAngle(), var4, var6) && (var2.get() == null || var8 > (Double) var3.get())) {
            var2.set(var1);
            var3.set(var8);
        }

    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double, double, double, com.a.a.b.a, double, double) boolean
    private boolean doesPointBelongToAAndB(Point2D var1, double var2, double var4, double var6, double var8, Body var10, double var11, double var13) {
        boolean var15 = var1.getX() > var2 - this.epsilon && var1.getX() < var6 + this.epsilon && var1.getY() > var4 - this.epsilon && var1.getY() < var8 + this.epsilon;
        double var16 = (new Vector2D(var10.getPosition(), var1)).getAngle();
        if(var16 < var11) {
            var16 += 6.283185307179586D;
        }

        boolean var18 = var16 >= var11 && var16 <= var13;
        return var15 && var18;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Line2D, java.util.List) void
    private void addIntersectionInfo(Point2D point, Point2D point1A, Point2D point2A, Line2D lineA, List<IntersectionInfo> intersectionInfos) {
        boolean alreadyAdded = false;

        for (IntersectionInfo intersectionInfo : intersectionInfos) {
            if (intersectionInfo.intersectionPoint.nearlyEquals(point, this.epsilon)) {
                intersectionInfo.intersectionLines.add(lineA);
                intersectionInfo.intersectionLinePointPairs.add(new SimplePair<>(point1A, point2A));
                alreadyAdded = true;
                break;
            }
        }

        if(!alreadyAdded) {
            IntersectionInfo intersectionInfo = new IntersectionInfo(point);
            intersectionInfo.intersectionLines.add(lineA);
            intersectionInfo.intersectionLinePointPairs.add(new SimplePair<>(point1A, point2A));
            intersectionInfos.add(intersectionInfo);
        }

    }

    private static final class IntersectionInfo {
        // $FF: renamed from: a com.codeforces.commons.geometry.Point2D
        public final Point2D intersectionPoint;
        // $FF: renamed from: b java.util.List
        public final List<Line2D> intersectionLines = new ArrayList<>();
        // $FF: renamed from: c java.util.List
        public final List<SimplePair<Point2D, Point2D>> intersectionLinePointPairs = new ArrayList<>();

        private IntersectionInfo(Point2D intersectionPoint) {
            this.intersectionPoint = intersectionPoint;
        }
    }
}
