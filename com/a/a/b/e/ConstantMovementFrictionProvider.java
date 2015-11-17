package com.a.a.b.e;

import com.a.a.b.Body;

// $FF: renamed from: com.a.a.b.e.b
public class ConstantMovementFrictionProvider implements MovementFrictionProvider {
    // $FF: renamed from: a double
    private final double movementFrictionFactor;

    public ConstantMovementFrictionProvider(double movementFrictionFactor) {
        if(movementFrictionFactor < 0.0D) {
            throw new IllegalArgumentException("Argument \'movementFrictionFactor\' should be zero or positive.");
        } else {
            this.movementFrictionFactor = movementFrictionFactor;
        }
    }

    // $FF: renamed from: a () double
    public double getMovementFrictionFactor() {
        return this.movementFrictionFactor;
    }

    // $FF: renamed from: a (com.a.a.b.a, double) void
    public void applyFriction(Body body, double updateFactor) {
        if(this.movementFrictionFactor > 0.0D) {
            double velocityLength = body.getVelocity().getLength();
            if(velocityLength > 0.0D) {
                double velocityChange = this.movementFrictionFactor * updateFactor;
                if(velocityChange >= velocityLength) {
                    body.setVelocity(0.0D, 0.0D);
                } else if(velocityChange > 0.0D) {
                    body.getVelocity().multiply(1.0D - velocityChange / velocityLength);
                }

            }
        }
    }
}
