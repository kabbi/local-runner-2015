package com.a.a.b.f;

import com.codeforces.commons.geometry.Line2D;
import com.codeforces.commons.geometry.Point2D;

// $FF: renamed from: com.a.a.b.f.a
public final class GeometryUtil {
    // $FF: renamed from: a (double) double
    public static double normalizeAngle(double angle) {
        while(angle > StrictMath.PI) {
            angle -= StrictMath.PI * 2;
        }

        while(angle < -StrictMath.PI) {
            angle += StrictMath.PI * 2;
        }

        return angle;
    }

    // $FF: renamed from: a (double, double, double) boolean
    public static boolean isAngleBetween(double angle, double startAngle, double finishAngle) {
        while(finishAngle < startAngle) {
            finishAngle += StrictMath.PI * 2;
        }

        while(finishAngle - StrictMath.PI * 2 > startAngle) {
            finishAngle -= StrictMath.PI * 2;
        }

        while(angle < startAngle) {
            angle += StrictMath.PI * 2;
        }

        while(angle - StrictMath.PI * 2 > startAngle) {
            angle -= StrictMath.PI * 2;
        }

        return angle >= startAngle && angle <= finishAngle;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D[], double) boolean
    public static boolean isPointInsideConvexPolygon(Point2D point, Point2D[] polygonVertexes, double epsilon) {
        for(int i = 0, vertexCount = polygonVertexes.length; i < vertexCount; i++) {
            Point2D vertex1 = polygonVertexes[i];
            Point2D vertex2 = polygonVertexes[i == vertexCount - 1 ? 0 : i + 1];
            Line2D polygonEdge = Line2D.getLineByTwoPoints(vertex1, vertex2);
            if(polygonEdge.getSignedDistanceFrom(point) >= epsilon) {
                return true;
            }
        }

        return false;
    }
}
