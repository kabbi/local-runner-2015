package com.a.a.b;

import com.a.a.b.a.BodyList;
import com.a.a.b.a.SimpleBodyList;
import com.a.a.b.b.Collider;
import com.a.a.b.b.ArcAndArcCollider;
import com.a.a.b.b.ArcAndCircleCollider;
import com.a.a.b.b.CircleAndCircleCollider;
import com.a.a.b.b.LineAndArcCollider;
import com.a.a.b.b.LineAndCircleCollider;
import com.a.a.b.b.LineAndLineCollider;
import com.a.a.b.b.LineAndRectangleCollider;
import com.a.a.b.b.RectangleAndArcCollider;
import com.a.a.b.b.RectangleAndCircleCollider;
import com.a.a.b.b.RectangleAndRectangleCollider;
import com.a.a.b.b.CollisionInfo;
import com.a.a.b.d.CollisionListener;
import com.a.a.b.e.MomentumTransferFactorProvider;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.LongPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

// $FF: renamed from: com.a.a.b.g
public class World {
    // $FF: renamed from: a org.apache.log4j.Logger
    private static final Logger logger = Logger.getLogger(World.class);

    // $FF: renamed from: b com.a.a.b.b.f
    private static final CollisionInfo NULL_COLLISION_INFO = new CollisionInfo((Body)null, (Body)null, (Point2D)null, (Vector2D)null, 0.0D, 0.0D);

    // $FF: renamed from: c int
    private final int iterationCountPerStep;
    // $FF: renamed from: d int
    private final int stepCountPerTimeUnit;
    // $FF: renamed from: e double
    private final double updateFactor;

    // $FF: renamed from: f double
    private final double epsilon;
    // $FF: renamed from: g double
    private final double squaredEpsilon;

    // $FF: renamed from: h com.a.a.b.a.a
    private final BodyList bodyList;
    // $FF: renamed from: i com.a.a.b.e.c
    private final MomentumTransferFactorProvider momentumTransferFactorProvider;

    // $FF: renamed from: j java.util.Map
    private final Map<String, ColliderEntry> colliderEntryByName;
    // $FF: renamed from: k java.util.SortedSet
    private final SortedSet<ColliderEntry> colliderEntries;

    // $FF: renamed from: l java.util.Map
    private final Map<String, CollisionListenerEntry> collisionListenerEntryByName;
    // $FF: renamed from: m java.util.SortedSet
    private final SortedSet<CollisionListenerEntry> collisionListenerEntries;

    public World() {
        this(10);
    }

    public World(int iterationCountPerStep) {
        this(iterationCountPerStep, 60);
    }

    public World(int iterationCountPerStep, int stepCountPerTimeUnit) {
        this(iterationCountPerStep, stepCountPerTimeUnit, 1.0E-7D);
    }

    public World(int iterationCountPerStep, int stepCountPerTimeUnit, double epsilon) {
        this(iterationCountPerStep, stepCountPerTimeUnit, epsilon, new SimpleBodyList());
    }

    public World(int iterationCountPerStep, int stepCountPerTimeUnit, double epsilon, BodyList bodyList) {
        this(iterationCountPerStep, stepCountPerTimeUnit, epsilon, bodyList, null);
    }

    public World(int iterationCountPerStep, int stepCountPerTimeUnit,
                 double epsilon, BodyList bodyList, MomentumTransferFactorProvider momentumTransferFactorProvider) {
        this.colliderEntryByName = new HashMap<>();
        this.colliderEntries = new TreeSet<>(ColliderEntry.comparator);
        this.collisionListenerEntryByName = new HashMap<>();
        this.collisionListenerEntries = new TreeSet<>(CollisionListenerEntry.comparator);

        if(iterationCountPerStep < 1) {
            throw new IllegalArgumentException("Argument \'iterationCountPerStep\' is zero or negative.");
        } else if(stepCountPerTimeUnit < 1) {
            throw new IllegalArgumentException("Argument \'stepCountPerTimeUnit\' is zero or negative.");
        } else if(!Double.isNaN(epsilon) && !Double.isInfinite(epsilon) && epsilon >= 1.0E-100D && epsilon <= 1.0D) {
            if(bodyList == null) {
                throw new IllegalArgumentException("Argument \'bodyList\' is null.");
            } else {
                this.stepCountPerTimeUnit = stepCountPerTimeUnit;
                this.iterationCountPerStep = iterationCountPerStep;
                this.updateFactor = 1.0D / (double)(stepCountPerTimeUnit * iterationCountPerStep);
                this.epsilon = epsilon;
                this.squaredEpsilon = epsilon * epsilon;
                this.bodyList = bodyList;
                this.momentumTransferFactorProvider = momentumTransferFactorProvider;
                this.registerCollider(new ArcAndArcCollider(epsilon));
                this.registerCollider(new ArcAndCircleCollider(epsilon));
                this.registerCollider(new CircleAndCircleCollider(epsilon));
                this.registerCollider(new LineAndArcCollider(epsilon));
                this.registerCollider(new LineAndCircleCollider(epsilon));
                this.registerCollider(new LineAndLineCollider(epsilon));
                this.registerCollider(new LineAndRectangleCollider(epsilon));
                this.registerCollider(new RectangleAndArcCollider(epsilon));
                this.registerCollider(new RectangleAndCircleCollider(epsilon));
                this.registerCollider(new RectangleAndRectangleCollider(epsilon));
            }
        } else {
            throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
        }
    }

    // $FF: renamed from: a () int
    public int getStepCountPerTimeUnit() {
        return this.stepCountPerTimeUnit;
    }

    // $FF: renamed from: b () double
    public double getEpsilon() {
        return this.epsilon;
    }

    // $FF: renamed from: a (com.a.a.b.a) void
    public void addBody(Body body) {
        if(body.getForm() != null && body.getMass() != 0.0D) {
            this.bodyList.addBody(body);
        } else {
            throw new IllegalArgumentException("Specify form and mass of \'body\' before adding to the world.");
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void removeBody(Body body) {
        this.bodyList.removeBody(body);
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean hasBody(Body body) {
        return this.bodyList.hasBody(body);
    }

    // $FF: renamed from: c () java.util.List
    public List<Body> getBodies() {
        return this.bodyList.getBodies();
    }

    // $FF: renamed from: d () void
    public void proceed() {
        List<Body> bodies = new ArrayList<>(this.getBodies());
        Iterator var2 = bodies.iterator();

        Body var3;
        while(var2.hasNext()) {
            var3 = (Body)var2.next();
            if(this.hasBody(var3)) {
                var3.normalizeAngle();
                var3.saveBeforeStepState();
            }
        }

        label71:
        for(int i = 1; i <= this.iterationCountPerStep; ++i) {

            for (Body var4 : bodies) {
                if (this.hasBody(var4)) {
                    var4.saveBeforeIterationState();
                    this.updateState(var4);
                    var4.normalizeAngle();
                }
            }

            Map<LongPair, CollisionInfo> collisionInfoByBodyIdsPair = new HashMap<>();
            Iterator var11 = bodies.iterator();

            while(true) {
                Body var5;
                do {
                    do {
                        if(!var11.hasNext()) {
                            continue label71;
                        }

                        var5 = (Body)var11.next();
                    } while(var5.isStatic());
                } while(!this.hasBody(var5));

                for (Body otherBody : this.bodyList.getPotentialIntersections(var5)) {
                    if (this.hasBody(var5) && this.hasBody(otherBody)) {
                        this.collide(var5, otherBody, collisionInfoByBodyIdsPair);
                    }
                }
            }
        }

        var2 = bodies.iterator();

        while(var2.hasNext()) {
            var3 = (Body)var2.next();
            if(this.hasBody(var3)) {
                var3.setForce(0.0D, 0.0D);
                var3.setTorque(0.0D);
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, java.util.Map) void
    private void collide(Body body, Body otherBody, Map<LongPair, CollisionInfo> collisionInfoByBodyIdsPair) {
        Body bodyA;
        Body bodyB;

        if(body.getId() > otherBody.getId()) {
            bodyA = otherBody;
            bodyB = body;
        } else {
            bodyA = body;
            bodyB = otherBody;
        }

        LongPair bodyIdsPair = new LongPair(bodyA.getId(), bodyB.getId());

        CollisionInfo collisionInfo = collisionInfoByBodyIdsPair.get(bodyIdsPair);
        if(collisionInfo == null) {
            Iterator var8 = this.collisionListenerEntries.iterator();

            while(true) {
                if(var8.hasNext()) {
                    CollisionListenerEntry var10 = (CollisionListenerEntry)var8.next();
                    if(!var10.listener.beforeStartingCollision(bodyA, bodyB)) {
                        collisionInfoByBodyIdsPair.put(bodyIdsPair, NULL_COLLISION_INFO);
                        return;
                    }

                    if(this.hasBody(bodyA) && this.hasBody(bodyB)) {
                        continue;
                    }

                    return;
                }

                var8 = this.colliderEntries.iterator();

                while(var8.hasNext()) {
                    ColliderEntry var9 = (ColliderEntry)var8.next();
                    if(var9.collider.matches(bodyA, bodyB)) {
                        collisionInfo = var9.collider.collide(bodyA, bodyB);
                        break;
                    }
                }

                if(collisionInfo == null) {
                    collisionInfoByBodyIdsPair.put(bodyIdsPair, NULL_COLLISION_INFO);
                } else {
                    collisionInfoByBodyIdsPair.put(bodyIdsPair, collisionInfo);
                    this.resolveCollision(collisionInfo);
                }

                return;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.b.f) void
    private void resolveCollision(CollisionInfo collisionInfo) {
        Body bodyA = collisionInfo.getBodyA();
        Body bodyB = collisionInfo.getBodyB();

        if(bodyA.isStatic() && bodyB.isStatic()) {
            throw new IllegalArgumentException("Both " + bodyA + " and " + bodyB + " are static.");
        } else {
            Iterator var4 = this.collisionListenerEntries.iterator();

            while(true) {
                if(var4.hasNext()) {
                    CollisionListenerEntry var17 = (CollisionListenerEntry)var4.next();
                    if(!var17.listener.beforeResolvingCollision(collisionInfo)) {
                        return;
                    }

                    if(this.hasBody(bodyA) && this.hasBody(bodyB)) {
                        continue;
                    }

                    return;
                }

                logCollision(collisionInfo);

                Vector3D collisionNormalB = toVector3D(collisionInfo.getNormalB());

                Vector3D vectorAC = toVector3D(bodyA.getCenterOfMass(), collisionInfo.getPoint());
                Vector3D vectorBC = toVector3D(bodyB.getCenterOfMass(), collisionInfo.getPoint());

                Vector3D angularVelocityPartAC = toVector3DZ(bodyA.getAngularVelocity()).crossProduct(vectorAC);
                Vector3D angularVelocityPartBC = toVector3DZ(bodyB.getAngularVelocity()).crossProduct(vectorBC);

                Vector3D velocityAC = toVector3D(bodyA.getVelocity()).add(angularVelocityPartAC);
                Vector3D velocityBC = toVector3D(bodyB.getVelocity()).add(angularVelocityPartBC);

                Vector3D relativeVelocityC = velocityAC.subtract(velocityBC);
                double normalRelativeVelocityLengthC = -relativeVelocityC.dotProduct(collisionNormalB);

                if(normalRelativeVelocityLengthC > -this.epsilon) {
                    this.resolveImpact(bodyA, bodyB, collisionNormalB, vectorAC, vectorBC, relativeVelocityC);
                    this.resolveSurfaceFriction(bodyA, bodyB, collisionNormalB, vectorAC, vectorBC, relativeVelocityC);
                }

                if(collisionInfo.getDepth() >= this.epsilon) {
                    this.pushBackBodies(bodyA, bodyB, collisionInfo);
                }

                bodyA.normalizeAngle();
                bodyB.normalizeAngle();

                for (CollisionListenerEntry collisionListenerEntry : this.collisionListenerEntries) {
                    collisionListenerEntry.listener.afterResolvingCollision(collisionInfo);
                }

                return;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D) void
    private void resolveImpact(Body bodyA, Body bodyB, Vector3D collisionNormalB,
                               Vector3D vectorAC, Vector3D vectorBC, Vector3D relativeVelocityC) {
        Double momentumTransferFactor;

        if(this.momentumTransferFactorProvider == null || (momentumTransferFactor = this.momentumTransferFactorProvider.getFactor(bodyA, bodyB)) == null) {
            momentumTransferFactor = bodyA.getMomentumTransferFactor() * bodyB.getMomentumTransferFactor();
        }

        Vector3D denominatorPartA = vectorAC.crossProduct(collisionNormalB)
                .scalarMultiply(bodyA.getInvertedAngularMass()).crossProduct(vectorAC);
        Vector3D denominatorPartB = vectorBC.crossProduct(collisionNormalB)
                .scalarMultiply(bodyB.getInvertedAngularMass()).crossProduct(vectorBC);

        double denominator = bodyA.getInvertedMass() + bodyB.getInvertedMass()
                + collisionNormalB.dotProduct(denominatorPartA.add(denominatorPartB));

        double impulseChange = -1.0D * (1.0D + momentumTransferFactor) * relativeVelocityC.dotProduct(collisionNormalB) / denominator;

        if(Math.abs(impulseChange) >= this.epsilon) {
            Vector3D velocityChange;
            Vector3D newVelocity;
            Vector3D angularVelocityChange;
            Vector3D newAngularVelocity;
            if(!bodyA.isStatic()) {
                velocityChange = collisionNormalB.scalarMultiply(impulseChange * bodyA.getInvertedMass());
                newVelocity = toVector3D(bodyA.getVelocity()).add(velocityChange);
                bodyA.setVelocity(newVelocity.getX(), newVelocity.getY());
                angularVelocityChange = vectorAC.crossProduct(collisionNormalB.scalarMultiply(impulseChange)).scalarMultiply(bodyA.getInvertedAngularMass());
                newAngularVelocity = toVector3DZ(bodyA.getAngularVelocity()).add(angularVelocityChange);
                bodyA.setAngularVelocity(newAngularVelocity.getZ());
            }

            if(!bodyB.isStatic()) {
                velocityChange = collisionNormalB.scalarMultiply(impulseChange * bodyB.getInvertedMass());
                newVelocity = toVector3D(bodyB.getVelocity()).subtract(velocityChange);
                bodyB.setVelocity(newVelocity.getX(), newVelocity.getY());
                angularVelocityChange = vectorBC.crossProduct(collisionNormalB.scalarMultiply(impulseChange)).scalarMultiply(bodyB.getInvertedAngularMass());
                newAngularVelocity = toVector3DZ(bodyB.getAngularVelocity()).subtract(angularVelocityChange);
                bodyB.setAngularVelocity(newAngularVelocity.getZ());
            }

        }
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D) void
    private void resolveSurfaceFriction(Body bodyA, Body bodyB, Vector3D collisionNormalB,
                                        Vector3D vectorAC, Vector3D vectorBC, Vector3D relativeVelocityC) {
        Vector3D tangent = relativeVelocityC
                .subtract(collisionNormalB.scalarMultiply(relativeVelocityC.dotProduct(collisionNormalB)));

        if(tangent.getNormSq() >= this.squaredEpsilon) {
            tangent = tangent.normalize();

            double surfaceFriction = Math.sqrt(bodyA.getSurfaceFrictionFactor() * bodyB.getSurfaceFrictionFactor())
                    * Math.SQRT_2 * Math.abs(relativeVelocityC.dotProduct(collisionNormalB)) / relativeVelocityC.getNorm();

            if(surfaceFriction >= this.epsilon) {
                Vector3D denominatorPartA = vectorAC.crossProduct(tangent).scalarMultiply(bodyA.getInvertedAngularMass()).crossProduct(vectorAC);
                Vector3D denominatorPartB = vectorBC.crossProduct(tangent).scalarMultiply(bodyB.getInvertedAngularMass()).crossProduct(vectorBC);

                double denominator = bodyA.getInvertedMass() + bodyB.getInvertedMass()
                        + tangent.dotProduct(denominatorPartA.add(denominatorPartB));

                double impulseChange = -1.0D * surfaceFriction * relativeVelocityC.dotProduct(tangent) / denominator;

                if(Math.abs(impulseChange) >= this.epsilon) {
                    Vector3D velocityChange;
                    Vector3D newVelocity;
                    Vector3D angularVelocityChange;
                    Vector3D newAngularVelocity;
                    if(!bodyA.isStatic()) {
                        velocityChange = tangent.scalarMultiply(impulseChange * bodyA.getInvertedMass());
                        newVelocity = toVector3D(bodyA.getVelocity()).add(velocityChange);
                        bodyA.setVelocity(newVelocity.getX(), newVelocity.getY());
                        angularVelocityChange = vectorAC.crossProduct(tangent.scalarMultiply(impulseChange)).scalarMultiply(bodyA.getInvertedAngularMass());
                        newAngularVelocity = toVector3DZ(bodyA.getAngularVelocity()).add(angularVelocityChange);
                        bodyA.setAngularVelocity(newAngularVelocity.getZ());
                    }

                    if(!bodyB.isStatic()) {
                        velocityChange = tangent.scalarMultiply(impulseChange * bodyB.getInvertedMass());
                        newVelocity = toVector3D(bodyB.getVelocity()).subtract(velocityChange);
                        bodyB.setVelocity(newVelocity.getX(), newVelocity.getY());
                        angularVelocityChange = vectorBC.crossProduct(tangent.scalarMultiply(impulseChange)).scalarMultiply(bodyB.getInvertedAngularMass());
                        newAngularVelocity = toVector3DZ(bodyB.getAngularVelocity()).subtract(angularVelocityChange);
                        bodyB.setAngularVelocity(newAngularVelocity.getZ());
                    }

                }
            }
        }
    }

    // $FF: renamed from: d (com.a.a.b.a) void
    private void updateState(Body body) {
        this.updatePosition(body);
        this.updateAngle(body);
    }

    // $FF: renamed from: e (com.a.a.b.a) void
    private void updatePosition(Body body) {
        if(body.getVelocity().getSquaredLength() > 0.0D) {
            body.getPosition().add(body.getVelocity().copy().multiply(this.updateFactor));
        }

        if(body.getForce().getSquaredLength() > 0.0D) {
            body.getVelocity().add(body.getForce().copy().multiply(body.getInvertedMass()).multiply(this.updateFactor));
        }

        if(body.getMovementAirFrictionFactor() >= 1.0D) {
            body.setVelocity(body.getMedianVelocity().copy());
        } else if(body.getMovementAirFrictionFactor() > 0.0D) {
            body.applyMovementAirFriction(this.updateFactor);
            if(body.getVelocity().nearlyEquals(body.getMedianVelocity(), this.epsilon)) {
                body.setVelocity(body.getMedianVelocity().copy());
            }
        }

        body.getVelocity().subtract(body.getMedianVelocity());
        body.applyFriction(this.updateFactor);
        body.getVelocity().add(body.getMedianVelocity());
    }

    // $FF: renamed from: f (com.a.a.b.a) void
    private void updateAngle(Body body) {
        body.setAngle(body.getAngle() + body.getAngularVelocity() * this.updateFactor);
        body.setAngularVelocity(body.getAngularVelocity() + body.getTorque() * body.getInvertedAngularMass() * this.updateFactor);
        if(body.getRotationAirFrictionFactor() >= 1.0D) {
            body.setAngularVelocity(body.getMedianAngularVelocity());
        } else if(body.getRotationAirFrictionFactor() > 0.0D) {
            body.applyRotationAirFriction(this.updateFactor);
            if(NumberUtil.nearlyEquals(Double.valueOf(body.getAngularVelocity()), Double.valueOf(body.getMedianAngularVelocity()), this.epsilon)) {
                body.setAngularVelocity(body.getMedianAngularVelocity());
            }
        }

        double angularVelocity = body.getAngularVelocity() - body.getMedianAngularVelocity();

        if(Math.abs(angularVelocity) > 0.0D) {
            double var4 = body.getRotationFrictionFactor() * this.updateFactor;
            if(var4 >= Math.abs(angularVelocity)) {
                body.setAngularVelocity(body.getMedianAngularVelocity());
            } else if(var4 > 0.0D) {
                if(angularVelocity > 0.0D) {
                    body.setAngularVelocity(angularVelocity - var4 + body.getMedianAngularVelocity());
                } else {
                    body.setAngularVelocity(angularVelocity + var4 + body.getMedianAngularVelocity());
                }
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.a.a.b.b.f) void
    private void pushBackBodies(Body bodyA, Body bodyB, CollisionInfo collisionInfo) {
        if(bodyA.isStatic()) {
            bodyB.getPosition().subtract(collisionInfo.getNormalB().multiply(collisionInfo.getDepth() + this.epsilon));
        } else if(bodyB.isStatic()) {
            bodyA.getPosition().add(collisionInfo.getNormalB().multiply(collisionInfo.getDepth() + this.epsilon));
        } else {
            Vector2D normalOffset = collisionInfo.getNormalB().multiply(0.5D * (collisionInfo.getDepth() + this.epsilon));
            bodyA.getPosition().add(normalOffset);
            bodyB.getPosition().subtract(normalOffset);
        }

    }

    // $FF: renamed from: a (com.a.a.b.b.d, java.lang.String, double) void
    public void registerCollider(Collider collider, String name, double priority) {
        NamedEntry.validateName(name);

        if(this.colliderEntryByName.containsKey(name)) {
            throw new IllegalArgumentException("Collider \'" + name + "\' is already registered.");
        } else {
            ColliderEntry colliderEntry = new ColliderEntry(name, priority, collider);
            this.colliderEntryByName.put(name, colliderEntry);
            this.colliderEntries.add(colliderEntry);
        }
    }

    // $FF: renamed from: a (com.a.a.b.b.d, java.lang.String) void
    public void registerCollider(Collider collider, String name) {
        this.registerCollider(collider, name, 0.0D);
    }

    // $FF: renamed from: a (com.a.a.b.b.d) void
    private void registerCollider(Collider collider) {
        this.registerCollider(collider, collider.getClass().getSimpleName());
    }

    // $FF: renamed from: a (com.a.a.b.d.a, java.lang.String, double) void
    public void registerCollisionListener(CollisionListener listener, String name, double priority) {
        NamedEntry.validateName(name);

        if(this.collisionListenerEntryByName.containsKey(name)) {
            throw new IllegalArgumentException("Listener \'" + name + "\' is already registered.");
        } else {
            CollisionListenerEntry collisionListenerEntry = new CollisionListenerEntry(name, priority, listener);
            this.collisionListenerEntryByName.put(name, collisionListenerEntry);
            this.collisionListenerEntries.add(collisionListenerEntry);
        }
    }

    // $FF: renamed from: a (com.a.a.b.d.a, java.lang.String) void
    public void registerCollisionListener(CollisionListener listener, String name) {
        this.registerCollisionListener(listener, name, 0.0D);
    }

    // $FF: renamed from: a (java.lang.String) boolean
    public boolean hasCollisionListener(String name) {
        NamedEntry.validateName(name);

        return this.collisionListenerEntryByName.containsKey(name);
    }

    // $FF: renamed from: b (com.a.a.b.b.f) void
    private static void logCollision(CollisionInfo collisionInfo) {
        if(collisionInfo.getDepth() < collisionInfo.getBodyA().getForm().getCircumcircleRadius() * 0.25D && collisionInfo.getDepth() < collisionInfo.getBodyB().getForm().getCircumcircleRadius() * 0.25D) {
            if(logger.isDebugEnabled()) {
                logger.debug("Resolving collision " + collisionInfo + '.');
            }
        } else if(logger.isEnabledFor(Level.WARN)) {
            logger.warn("Resolving collision (big depth) " + collisionInfo + '.');
        }

    }

    // $FF: renamed from: a (double) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D toVector3DZ(double z) {
        return new Vector3D(0.0D, 0.0D, z);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D toVector3D(Vector2D vector) {
        return new Vector3D(vector.getX(), vector.getY(), 0.0D);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D toVector3D(Point2D point1, Point2D point2) {
        return toVector3D(new Vector2D(point1, point2));
    }

    private static final class CollisionListenerEntry extends NamedEntry {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator<CollisionListenerEntry> comparator = new Comparator<CollisionListenerEntry>() {
            // $FF: synthetic method
            public int compare(CollisionListenerEntry listenerEntryA, CollisionListenerEntry listenerEntryB) {
                int comparisonResult = Double.compare(listenerEntryB.priority, listenerEntryA.priority);
                return comparisonResult != 0 ? comparisonResult : listenerEntryA.name.compareTo(listenerEntryB.name);
            }
        };

        // $FF: renamed from: b double
        public final double priority;
        // $FF: renamed from: c com.a.a.b.d.a
        public final CollisionListener listener;

        private CollisionListenerEntry(String name, double priority, CollisionListener collider) {
            super(name);

            this.priority = priority;
            this.listener = collider;
        }
    }

    private static final class ColliderEntry extends NamedEntry {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator<ColliderEntry> comparator = new Comparator<ColliderEntry>() {
            // $FF: synthetic method
            public int compare(ColliderEntry colliderEntryA, ColliderEntry colliderEntryB) {
                int comparisonResult = Double.compare(colliderEntryB.priority, colliderEntryA.priority);
                return comparisonResult != 0 ? comparisonResult : colliderEntryA.name.compareTo(colliderEntryB.name);
            }
        };
        // $FF: renamed from: b double
        public final double priority;
        // $FF: renamed from: c com.a.a.b.b.d
        public final Collider collider;

        private ColliderEntry(String name, double priority, Collider colldier) {
            super(name);

            this.priority = priority;
            this.collider = colldier;
        }
    }
}
