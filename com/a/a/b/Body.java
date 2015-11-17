package com.a.a.b;

import com.a.a.b.c.Form;
import com.a.a.b.e.MovementFrictionProvider;
import com.a.a.b.e.ConstantMovementFrictionProvider;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.text.StringUtil;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.a.a.b.a
public class Body {
    // $FF: renamed from: a java.util.concurrent.atomic.AtomicLong
    private static final AtomicLong idGenerator = new AtomicLong();
    // $FF: renamed from: b long
    private final long id;
    // $FF: renamed from: c java.lang.String
    private String name;
    // $FF: renamed from: d com.a.a.b.c.c
    private Form form;
    // $FF: renamed from: e double
    private double mass;
    // $FF: renamed from: f double
    private double invertedMass;
    // $FF: renamed from: g double
    private double movementAirFrictionFactor;
    // $FF: renamed from: h double
    private double rotationAirFrictionFactor;
    // $FF: renamed from: i com.a.a.b.e.d
    private MovementFrictionProvider movementFrictionProvider;
    // $FF: renamed from: j double
    private double rotationFrictionFactor;
    // $FF: renamed from: k double
    private double momentumTransferFactor;
    // $FF: renamed from: l double
    private double surfaceFrictionFactor;
    // $FF: renamed from: m com.a.a.b.b

    private final DynamicState currentState;
    // $FF: renamed from: n com.a.a.b.b
    private DynamicState beforeStepState;
    // $FF: renamed from: o com.a.a.b.b
    private DynamicState beforeIterationState;

    // $FF: renamed from: p double
    private double lastMovementAirFrictionFactor;
    // $FF: renamed from: q double
    private double lastMovementUpdateFactor;
    // $FF: renamed from: r java.lang.Double
    private Double lastMovementTransferFactor;

    // $FF: renamed from: s double
    private double lastRotationAirFrictionFactor;
    // $FF: renamed from: t double
    private double lastRotationUpdateFactor;
    // $FF: renamed from: u java.lang.Double
    private Double lastRotationTransferFactor;

    public Body() {
        this.id = idGenerator.incrementAndGet();
        this.movementFrictionProvider = new ConstantMovementFrictionProvider(0.0D);
        this.momentumTransferFactor = 1.0D;
        this.currentState = new DynamicState();
    }

    // $FF: renamed from: a () long
    public long getId() {
        return this.id;
    }

    // $FF: renamed from: b () java.lang.String
    public String getName() {
        return this.name;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void setName(String name) {
        this.name = name;
    }

    // $FF: renamed from: c () com.a.a.b.c.c
    public Form getForm() {
        return this.form;
    }

    // $FF: renamed from: a (com.a.a.b.c.c) void
    public void setForm(Form form) {
        this.form = form;
    }

    // $FF: renamed from: d () double
    public double getMass() {
        return this.mass;
    }

    // $FF: renamed from: a (double) void
    public void setMass(double mass) {
        if(!Double.isNaN(mass) && mass != Double.NEGATIVE_INFINITY && mass > 0.0D) {
            this.mass = mass;
            if(Double.isInfinite(mass)) {
                this.invertedMass = 0.0D;
            } else {
                this.invertedMass = 1.0D / mass;
            }
        } else {
            throw new IllegalArgumentException(this + ": argument \'mass\' should be positive.");
        }
    }

    // $FF: renamed from: e () boolean
    public boolean isStatic() {
        return Double.isInfinite(this.mass);
    }

    // $FF: renamed from: f () double
    public double getInvertedMass() {
        return this.invertedMass;
    }

    // $FF: renamed from: g () double
    public double getAngularMass() {
        if(!Double.isNaN(this.mass) && this.mass != Double.NEGATIVE_INFINITY && this.mass > 0.0D) {
            return Double.isInfinite(this.mass)?Double.POSITIVE_INFINITY:this.form.getAngularMass(this.mass);
        } else {
            throw new IllegalStateException(this + ": field \'mass\' should be positive.");
        }
    }

    // $FF: renamed from: h () double
    public double getInvertedAngularMass() {
        double angularMass = this.getAngularMass();
        return Double.isInfinite(angularMass) ? 0.0D : 1.0D / angularMass;
    }

    // $FF: renamed from: i () double
    public double getMovementAirFrictionFactor() {
        return this.movementAirFrictionFactor;
    }

    // $FF: renamed from: b (double) void
    public void setMovementAirFrictionFactor(double movementAirFrictionFactor) {
        if(!Double.isNaN(movementAirFrictionFactor) && !Double.isInfinite(movementAirFrictionFactor) && movementAirFrictionFactor >= 0.0D && movementAirFrictionFactor <= 1.0D) {
            this.movementAirFrictionFactor = movementAirFrictionFactor;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'movementAirFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(movementAirFrictionFactor)}));
        }
    }

    // $FF: renamed from: j () double
    public double getRotationAirFrictionFactor() {
        return this.rotationAirFrictionFactor;
    }

    // $FF: renamed from: c (double) void
    public void setRotationAirFrictionFactor(double rotationAirFrictionFactor) {
        if(!Double.isNaN(rotationAirFrictionFactor) && !Double.isInfinite(rotationAirFrictionFactor) && rotationAirFrictionFactor >= 0.0D && rotationAirFrictionFactor <= 1.0D) {
            this.rotationAirFrictionFactor = rotationAirFrictionFactor;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'rotationAirFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(rotationAirFrictionFactor)}));
        }
    }

    // $FF: renamed from: k () com.a.a.b.e.d
    public MovementFrictionProvider getMovementFrictionProvider() {
        return this.movementFrictionProvider;
    }

    // $FF: renamed from: a (com.a.a.b.e.d) void
    public void setMovementFrictionProvider(MovementFrictionProvider movementFrictionProvider) {
        if(movementFrictionProvider == null) {
            throw new IllegalArgumentException(String.format("%s: argument \'movementFrictionProvider\' is null.", new Object[]{this}));
        } else {
            this.movementFrictionProvider = movementFrictionProvider;
        }
    }

    // $FF: renamed from: d (double) void
    public void setMovementFrictionFactor(double movementFrictionFactor) {
        this.setMovementFrictionProvider(new ConstantMovementFrictionProvider(movementFrictionFactor));
    }

    // $FF: renamed from: e (double) void
    public void applyFriction(double updateFactor) {
        this.movementFrictionProvider.applyFriction(this, updateFactor);
    }

    // $FF: renamed from: l () double
    public double getRotationFrictionFactor() {
        return this.rotationFrictionFactor;
    }

    // $FF: renamed from: f (double) void
    public void setRotationFrictionFactor(double rotationFrictionFactor) {
        if(!Double.isNaN(rotationFrictionFactor) && rotationFrictionFactor >= 0.0D) {
            this.rotationFrictionFactor = rotationFrictionFactor;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'rotationFrictionFactor\' should be zero or positive but got %s.", new Object[]{this, Double.valueOf(rotationFrictionFactor)}));
        }
    }

    // $FF: renamed from: m () double
    public double getMomentumTransferFactor() {
        return this.momentumTransferFactor;
    }

    // $FF: renamed from: g (double) void
    public void setMomentumTransferFactor(double momentumTransferFactor) {
        if(!Double.isNaN(momentumTransferFactor) && !Double.isInfinite(momentumTransferFactor) && momentumTransferFactor >= 0.0D && momentumTransferFactor <= 1.0D) {
            this.momentumTransferFactor = momentumTransferFactor;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'momentumTransferFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(momentumTransferFactor)}));
        }
    }

    // $FF: renamed from: n () double
    public double getSurfaceFrictionFactor() {
        return this.surfaceFrictionFactor;
    }

    // $FF: renamed from: h (double) void
    public void setSurfaceFrictionFactor(double surfaceFrictionFactor) {
        if(!Double.isNaN(surfaceFrictionFactor) && !Double.isInfinite(surfaceFrictionFactor) && surfaceFrictionFactor >= 0.0D && surfaceFrictionFactor <= 1.0D) {
            this.surfaceFrictionFactor = surfaceFrictionFactor;
        } else {
            throw new IllegalArgumentException(String.format("%s: argument \'surfaceFrictionFactor\' should be between 0.0 and 1.0 both inclusive but got %s.", new Object[]{this, Double.valueOf(surfaceFrictionFactor)}));
        }
    }

    // $FF: renamed from: o () com.a.a.b.b
    public DynamicState getCurrentState() {
        return this.currentState;
    }

    // $FF: renamed from: p () void
    public void saveBeforeStepState() {
        this.beforeStepState = new DynamicState(this.currentState);
    }

    // $FF: renamed from: q () void
    public void saveBeforeIterationState() {
        this.beforeIterationState = new DynamicState(this.currentState);
    }

    // $FF: renamed from: r () com.codeforces.commons.geometry.Point2D
    public Point2D getPosition() {
        return this.currentState.getPosition();
    }

    // $FF: renamed from: a (double, double) void
    public void setPosition(double x, double y) {
        Point2D position = this.currentState.getPosition();
        if(position == null) {
            this.currentState.setPosition(new Point2D(x, y));
        } else {
            position.setX(x);
            position.setY(y);
        }

    }

    // $FF: renamed from: s () double
    public double getX() {
        Point2D position = this.currentState.getPosition();
        return position == null ? 0.0D : position.getX();
    }

    // $FF: renamed from: i (double) void
    public void setX(double x) {
        Point2D position = this.currentState.getPosition();
        if(position == null) {
            this.currentState.setPosition(new Point2D(x, 0.0D));
        } else {
            position.setX(x);
        }

    }

    // $FF: renamed from: t () double
    public double getY() {
        Point2D position = this.currentState.getPosition();
        return position == null?0.0D:position.getY();
    }

    // $FF: renamed from: j (double) void
    public void setY(double y) {
        Point2D position = this.currentState.getPosition();
        if(position == null) {
            this.currentState.setPosition(new Point2D(0.0D, y));
        } else {
            position.setY(y);
        }

    }

    // $FF: renamed from: u () com.codeforces.commons.geometry.Vector2D
    public Vector2D getVelocity() {
        return this.currentState.getVelocity();
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setVelocity(Vector2D velocity) {
        this.currentState.setVelocity(velocity);
    }

    // $FF: renamed from: b (double, double) void
    public void setVelocity(double x, double y) {
        Vector2D velocity = this.currentState.getVelocity();
        if(velocity == null) {
            this.currentState.setVelocity(new Vector2D(x, y));
        } else {
            velocity.setX(x);
            velocity.setY(y);
        }

    }

    // $FF: renamed from: v () com.codeforces.commons.geometry.Vector2D
    public Vector2D getMedianVelocity() {
        return this.currentState.getMedianVelocity();
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void setMedianVelocity(Vector2D medianVelocity) {
        this.currentState.setMedianVelocity(medianVelocity);
    }

    // $FF: renamed from: w () com.codeforces.commons.geometry.Vector2D
    public Vector2D getForce() {
        return this.currentState.getForce();
    }

    // $FF: renamed from: c (com.codeforces.commons.geometry.Vector2D) void
    public void setForce(Vector2D force) {
        this.currentState.setForce(force);
    }

    // $FF: renamed from: c (double, double) void
    public void setForce(double x, double y) {
        Vector2D force = this.currentState.getForce();
        if(force == null) {
            this.currentState.setForce(new Vector2D(x, y));
        } else {
            force.setX(x);
            force.setY(y);
        }

    }

    // $FF: renamed from: x () double
    public double getAngle() {
        return this.currentState.getAngle();
    }

    // $FF: renamed from: k (double) void
    public void setAngle(double angle) {
        this.currentState.setAngle(angle);
    }

    // $FF: renamed from: y () double
    public double getAngularVelocity() {
        return this.currentState.getAngularVelocity();
    }

    // $FF: renamed from: l (double) void
    public void setAngularVelocity(double angularVelocity) {
        this.currentState.setAngularVelocity(angularVelocity);
    }

    // $FF: renamed from: z () double
    public double getMedianAngularVelocity() {
        return this.currentState.getMedianAngularVelocity();
    }

    // $FF: renamed from: m (double) void
    public void setMedianAngularVelocity(double medianAngularVelocity) {
        this.currentState.setMedianAngularVelocity(medianAngularVelocity);
    }

    // $FF: renamed from: A () double
    public double getTorque() {
        return this.currentState.getTorque();
    }

    // $FF: renamed from: n (double) void
    public void setTorque(double torque) {
        this.currentState.setTorque(torque);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D) double
    public double getDistanceTo(Point2D point) {
        return this.currentState.getPosition().getDistanceTo(point);
    }

    // $FF: renamed from: a (com.a.a.b.a) double
    public double getSquaredDistanceTo(Body body) {
        return this.currentState.getPosition().getSquaredDistanceTo(body.currentState.getPosition());
    }

    // $FF: renamed from: B () com.codeforces.commons.geometry.Point2D
    public Point2D getCenterOfMass() {
        return this.form == null ? null : this.form.getCenterOfMass(this);
    }

    // $FF: renamed from: C () void
    public void normalizeAngle() {
        this.currentState.normalizeAngle();
    }

    // $FF: renamed from: o (double) void
    void applyMovementAirFriction(double updateFactor) {
        if(this.lastMovementTransferFactor == null || !NumberUtil.equals(this.movementAirFrictionFactor, this.lastMovementAirFrictionFactor) || !NumberUtil.equals(updateFactor, this.lastMovementUpdateFactor)) {
            this.lastMovementAirFrictionFactor = this.movementAirFrictionFactor;
            this.lastMovementUpdateFactor = updateFactor;
            this.lastMovementTransferFactor = Math.pow(1.0D - this.movementAirFrictionFactor, updateFactor);
        }

        this.getVelocity().subtract(this.getMedianVelocity()).multiply(this.lastMovementTransferFactor).add(this.getMedianVelocity());
    }

    // $FF: renamed from: p (double) void
    void applyRotationAirFriction(double updateFactor) {
        if(this.lastRotationTransferFactor == null || !NumberUtil.equals(this.rotationAirFrictionFactor, this.lastRotationAirFrictionFactor) || !NumberUtil.equals(updateFactor, this.lastRotationUpdateFactor)) {
            this.lastRotationAirFrictionFactor = this.rotationAirFrictionFactor;
            this.lastRotationUpdateFactor = updateFactor;
            this.lastRotationTransferFactor = Math.pow(1.0D - this.rotationAirFrictionFactor, updateFactor);
        }

        this.setAngularVelocity((this.getAngularVelocity() - this.getMedianAngularVelocity()) * this.lastRotationTransferFactor + this.getMedianAngularVelocity());
    }

    // $FF: renamed from: b (com.a.a.b.a) boolean
    public boolean equals(Body body) {
        return body != null && this.id == body.id;
    }

    public int hashCode() {
        return (int)(this.id ^ this.id >>> 32);
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            Body var2 = (Body)o;
            return this.id == var2.id;
        } else {
            return false;
        }
    }

    public String toString() {
        return toString(this);
    }

    // $FF: renamed from: c (com.a.a.b.a) java.lang.String
    public static String toString(Body body) {
        return StringUtil.toString(Body.class, body, true, "id", "name", "position", "angle", "velocity", "angularVelocity");
    }
}
