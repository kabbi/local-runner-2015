package com.a.a.b.e;

import com.a.a.b.Body;
import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.e.a
public class BidirectionalMovementFrictionProvider implements MovementFrictionProvider {
    // $FF: renamed from: a double
    private final double lengthwiseMovementFrictionFactor;
    // $FF: renamed from: b double
    private final double crosswiseMovementFrictionFactor;

    public BidirectionalMovementFrictionProvider(double lengthwiseMovementFrictionFactor, double crosswiseMovementFrictionFactor) {
        if(lengthwiseMovementFrictionFactor < 0.0D) {
            throw new IllegalArgumentException("Argument \'lengthwiseMovementFrictionFactor\' should be zero or positive.");
        } else if(crosswiseMovementFrictionFactor < 0.0D) {
            throw new IllegalArgumentException("Argument \'crosswiseMovementFrictionFactor\' should be zero or positive.");
        } else {
            this.lengthwiseMovementFrictionFactor = lengthwiseMovementFrictionFactor;
            this.crosswiseMovementFrictionFactor = crosswiseMovementFrictionFactor;
        }
    }

    // $FF: renamed from: a () double
    public double getLengthwiseMovementFrictionFactor() {
        return this.lengthwiseMovementFrictionFactor;
    }

    // $FF: renamed from: b () double
    public double getCrosswiseMovementFrictionFactor() {
        return this.crosswiseMovementFrictionFactor;
    }

    // $FF: renamed from: a (com.a.a.b.a, double) void
    public void applyFriction(Body body, double updateFactor) {
        double velocityLength = body.getVelocity().getLength();
        if(velocityLength > 0.0D) {

            double lengthwiseVelocityChange = this.lengthwiseMovementFrictionFactor * updateFactor;
            double crosswiseVelocityChange = this.crosswiseMovementFrictionFactor * updateFactor;

            Vector2D lengthwiseUnitVector = (new Vector2D(1.0D, 0.0D)).rotate(body.getAngle());
            Vector2D crosswiseUnitVector = (new Vector2D(0.0D, 1.0D)).rotate(body.getAngle());

            double lengthwiseVelocityPart = body.getVelocity().dotProduct(lengthwiseUnitVector);

            if(lengthwiseVelocityPart >= 0.0D) {
                lengthwiseVelocityPart -= lengthwiseVelocityChange;
                if(lengthwiseVelocityPart < 0.0D) {
                    lengthwiseVelocityPart = 0.0D;
                }
            } else {
                lengthwiseVelocityPart += lengthwiseVelocityChange;
                if(lengthwiseVelocityPart > 0.0D) {
                    lengthwiseVelocityPart = 0.0D;
                }
            }

            double crosswiseVelocityPart = body.getVelocity().dotProduct(crosswiseUnitVector);

            if(crosswiseVelocityPart >= 0.0D) {
                crosswiseVelocityPart -= crosswiseVelocityChange;
                if(crosswiseVelocityPart < 0.0D) {
                    crosswiseVelocityPart = 0.0D;
                }
            } else {
                crosswiseVelocityPart += crosswiseVelocityChange;
                if(crosswiseVelocityPart > 0.0D) {
                    crosswiseVelocityPart = 0.0D;
                }
            }

            body.setVelocity(lengthwiseUnitVector.copy().multiply(lengthwiseVelocityPart).add(crosswiseUnitVector.copy().multiply(crosswiseVelocityPart)));
        }
    }
}
