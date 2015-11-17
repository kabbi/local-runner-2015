package com.a.c.b.a;

import com.a.a.b.Body;
import com.a.a.b.c.Form;
import com.a.a.b.c.CircularForm;
import com.a.a.b.c.RectangularForm;
import com.a.a.b.c.ArcForm;
import com.a.a.b.c.LinearForm;
import com.a.a.b.e.ConstantMovementFrictionProvider;
import com.a.a.b.e.BidirectionalMovementFrictionProvider;
import com.a.c.PhysicalBody;
import com.a.c.a.PhysicalForm;
import com.a.c.a.ArcPhysicalForm;
import com.a.c.a.LinearPhysicalForm;
import com.a.c.a.RectangularPhysicalForm;
import com.a.c.a.CircularPhysicalForm;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.b.a.e
class PhysicsUtils {
    // $FF: renamed from: a (com.a.c.c) com.a.a.b.a
    static Body createBodyForPhysicalBody(PhysicalBody physicalBody) {
        Body body = new Body();
        body.setName(physicalBody.getName());
        PhysicalForm form = physicalBody.getForm();
        body.setForm(convertPhysicalFormToForm(form));
        if(form instanceof LinearPhysicalForm) {
            LinearPhysicalForm linearPhysicalForm = (LinearPhysicalForm)form;
            body.setPosition((linearPhysicalForm.getX1() + linearPhysicalForm.getX2()) / 2.0D, (linearPhysicalForm.getY1() + linearPhysicalForm.getY2()) / 2.0D);
            body.setAngle((new Vector2D(linearPhysicalForm.getX1(), linearPhysicalForm.getY1(), linearPhysicalForm.getX2(), linearPhysicalForm.getY2())).getAngle());
            physicalBody.setX(body.getX());
            physicalBody.setY(body.getY());
            physicalBody.setAngle(body.getAngle());
        }

        if(physicalBody.isStationary()) {
            body.setMass(Double.POSITIVE_INFINITY);
            physicalBody.setMass(Double.POSITIVE_INFINITY);
        } else {
            body.setMass(physicalBody.getMass());
        }

        return body;
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.b.a.b) com.a.c.c
    static PhysicalBody createPhysicalBodyForBody(Body body, PhysicsManagerImpl manager) {
        double epsilon = manager.getWorld().getEpsilon();
        return new RealPhysicalBody(manager.getPhysicalIdByBodyId(body.getId()).longValue(),
                body, body.getName(), body.getMass(),
                convertFormToPhysicalForm(body.getForm(), body.getPosition(), body.getAngle(), epsilon),
                body.isStatic());
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.c, com.a.c.b.a.b) void
    static void syncBodyWithPhysicalBody(Body body, PhysicalBody physicalBody, PhysicsManagerImpl manager) {
        if(!NumberUtil.equals(manager.getBodyIdByPhysicalId(physicalBody.getId()), body.getId())) {
            throw new IllegalArgumentException("Can\'t update body ID.");
        } else if(!StringUtil.equals(physicalBody.getName(), body.getName())) {
            throw new IllegalArgumentException("Can\'t update body name.");
        } else if(!physicalBody.getExcludedBodyIds().isEmpty()) {
            throw new IllegalArgumentException("Excluded (for colliding) body IDs are not supported.");
        } else if(Math.abs(body.getMass() - physicalBody.getMass()) > 0.0D) {
            throw new IllegalArgumentException("Can\'t update body mass.");
        } else {
            double epsilon = manager.getWorld().getEpsilon();
            if(!(physicalBody instanceof RealPhysicalBody)) {
                if(!body.getPosition().equals(physicalBody.getX(), physicalBody.getY())) {
                    body.setPosition(physicalBody.getX(), physicalBody.getY());
                }

                if(!NumberUtil.equals(physicalBody.getAngle(), body.getAngle())) {
                    body.setAngle(physicalBody.getAngle());
                }

                if(!body.getVelocity().equals(physicalBody.getVelocity())) {
                    body.setVelocity(physicalBody.getVelocity().copy());
                }

                if(!body.getMedianVelocity().equals(physicalBody.getMedianVelocity())) {
                    body.setMedianVelocity(physicalBody.getMedianVelocity().copy());
                }

                if(!NumberUtil.equals(physicalBody.getAngularVelocity(), body.getAngularVelocity())) {
                    body.setAngularVelocity(physicalBody.getAngularVelocity());
                }

                if(!NumberUtil.equals(physicalBody.getMedianAngularVelocity(), body.getMedianAngularVelocity())) {
                    body.setMedianAngularVelocity(physicalBody.getMedianAngularVelocity());
                }

                if(!body.getForce().equals(physicalBody.getForce())) {
                    body.setForce(physicalBody.getForce().copy());
                }

                if(!NumberUtil.equals(physicalBody.getTorque(), body.getTorque())) {
                    body.setTorque(physicalBody.getTorque());
                }

                if(!NumberUtil.equals(body.getMovementAirFrictionFactor(), physicalBody.getMovementAirFrictionFactor())) {
                    body.setMovementAirFrictionFactor(physicalBody.getMovementAirFrictionFactor());
                }

                if(!NumberUtil.equals(body.getRotationAirFrictionFactor(), physicalBody.getRotationAirFrictionFactor())) {
                    body.setRotationAirFrictionFactor(physicalBody.getRotationAirFrictionFactor());
                }

                double frictionFactor;
                Double anotherFrictionFactor;
                if(body.getMovementFrictionProvider() instanceof ConstantMovementFrictionProvider) {
                    ConstantMovementFrictionProvider frictionProvider = (ConstantMovementFrictionProvider)body.getMovementFrictionProvider();
                    frictionFactor = frictionProvider.getMovementFrictionFactor();
                    anotherFrictionFactor = null;
                } else {
                    if(!(body.getMovementFrictionProvider() instanceof BidirectionalMovementFrictionProvider)) {
                        throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{body.getMovementFrictionProvider()}));
                    }

                    BidirectionalMovementFrictionProvider frictionProvider = (BidirectionalMovementFrictionProvider)body.getMovementFrictionProvider();
                    frictionFactor = frictionProvider.getLengthwiseMovementFrictionFactor();
                    anotherFrictionFactor = frictionProvider.getCrosswiseMovementFrictionFactor();
                }

                if(!NumberUtil.equals(frictionFactor, physicalBody.getMovementFrictionFactor()) || !NumberUtil.equals(anotherFrictionFactor, physicalBody.getCrosswiseMovementFrictionFactor())) {
                    if(physicalBody.getCrosswiseMovementFrictionFactor() == null) {
                        body.setMovementFrictionFactor(physicalBody.getMovementFrictionFactor());
                    } else {
                        body.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(physicalBody.getMovementFrictionFactor(), physicalBody.getCrosswiseMovementFrictionFactor().doubleValue()));
                    }
                }

                if(!NumberUtil.equals(body.getRotationFrictionFactor(), physicalBody.getRotationFrictionFactor())) {
                    body.setRotationFrictionFactor(physicalBody.getRotationFrictionFactor());
                }

                if(!NumberUtil.equals(body.getMomentumTransferFactor(), physicalBody.getMomentumTransferFactor())) {
                    body.setMomentumTransferFactor(physicalBody.getMomentumTransferFactor());
                }

                if(!NumberUtil.equals(body.getSurfaceFrictionFactor(), physicalBody.getSurfaceFrictionFactor())) {
                    body.setSurfaceFrictionFactor(physicalBody.getSurfaceFrictionFactor());
                }
            }

            PhysicalForm physicalForm = physicalBody.getForm();
            if(!physicalForm.equals(convertFormToPhysicalForm(
                    body.getForm(), body.getPosition(), body.getAngle(), epsilon), epsilon
            )) {
                body.setForm(convertPhysicalFormToForm(physicalForm));
                if(physicalForm instanceof LinearPhysicalForm) {
                    LinearPhysicalForm linearPhysicalForm = (LinearPhysicalForm)physicalForm;
                    body.setPosition((linearPhysicalForm.getX1() + linearPhysicalForm.getX2()) / 2.0D, (linearPhysicalForm.getY1() + linearPhysicalForm.getY2()) / 2.0D);
                    body.setAngle((new Vector2D(linearPhysicalForm.getX1(), linearPhysicalForm.getY1(), linearPhysicalForm.getX2(), linearPhysicalForm.getY2())).getAngle());
                    physicalBody.setX(body.getX());
                    physicalBody.setY(body.getY());
                    physicalBody.setAngle(body.getAngle());
                }
            }

        }
    }

    // $FF: renamed from: a (com.a.c.a.c) com.a.a.b.c.c
    private static Form convertPhysicalFormToForm(PhysicalForm physicalForm) {
        if(physicalForm == null) {
            return null;
        } else if(physicalForm instanceof CircularPhysicalForm) {
            CircularPhysicalForm circularPhysicalForm = (CircularPhysicalForm)physicalForm;
            return new CircularForm(circularPhysicalForm.getRadius());
        } else if(physicalForm instanceof RectangularPhysicalForm) {
            RectangularPhysicalForm rectangularPhysicalForm = (RectangularPhysicalForm)physicalForm;
            return new RectangularForm(rectangularPhysicalForm.getWidth(), rectangularPhysicalForm.getHeight());
        } else if(physicalForm instanceof LinearPhysicalForm) {
            LinearPhysicalForm linearPhysicalForm = (LinearPhysicalForm)physicalForm;
            return new LinearForm(Math.hypot(linearPhysicalForm.getX2() - linearPhysicalForm.getX1(), linearPhysicalForm.getY2() - linearPhysicalForm.getY1()), physicalForm.isEndpointCollisionEnabled());
        } else if(physicalForm instanceof ArcPhysicalForm) {
            ArcPhysicalForm arcPhysicalForm = (ArcPhysicalForm)physicalForm;
            return new ArcForm(arcPhysicalForm.getRadius(), arcPhysicalForm.getAngle(), arcPhysicalForm.getSector(), physicalForm.isEndpointCollisionEnabled());
        } else {
            throw new IllegalArgumentException("Unsupported form: " + physicalForm + '.');
        }
    }

    // $FF: renamed from: a (com.a.a.b.c.c, com.codeforces.commons.geometry.Point2D, double, double) com.a.c.a.c
    private static PhysicalForm convertFormToPhysicalForm(Form form, Point2D position, double angle, double epsilon) {
        if(form == null) {
            return null;
        } else {
            switch(form.getShape()) {
            case CIRCLE:
                CircularForm circularForm = (CircularForm)form;
                return new CircularPhysicalForm(circularForm.getRadius());
            case RECTANGLE:
                RectangularForm rectangularForm = (RectangularForm)form;
                return new RectangularPhysicalForm(rectangularForm.getWidth(), rectangularForm.getHeight());
            case LINE:
                LinearForm linearForm = (LinearForm)form;
                LinearPhysicalForm physicalForm = new LinearPhysicalForm(linearForm.getPoint1(position, angle, epsilon), linearForm.getPoint2(position, angle, epsilon));
                physicalForm.setEndpointCollisionEnabled(linearForm.isEndpointCollisionEnabled());
                return physicalForm;
            case ARC:
                ArcForm arcForm = (ArcForm)form;
                ArcPhysicalForm physicalForm1 = new ArcPhysicalForm(arcForm.getRadius(), arcForm.getAngle(), arcForm.getSector());
                physicalForm1.setEndpointCollisionEnabled(arcForm.isEndpointCollisionEnabled());
                return physicalForm1;
            default:
                throw new IllegalArgumentException("Unsupported form: " + form + '.');
            }
        }
    }
}
