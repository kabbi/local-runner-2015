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
import com.a.c.a.class_125;
import com.a.c.a.class_126;
import com.a.c.a.class_127;
import com.a.c.a.class_128;
import com.a.c.a.class_129;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.c.b.a.e
class class_188 {
    // $FF: renamed from: a (com.a.c.c) com.a.a.b.a
    static Body method_1001(PhysicalBody var0) {
        Body var1 = new Body();
        var1.setName(var0.getName());
        class_125 var2 = var0.getForm();
        var1.setForm(method_1004(var2));
        if(var2 instanceof class_127) {
            class_127 var3 = (class_127)var2;
            var1.setPosition((var3.method_823() + var3.method_825()) / 2.0D, (var3.method_824() + var3.method_826()) / 2.0D);
            var1.setAngle((new Vector2D(var3.method_823(), var3.method_824(), var3.method_825(), var3.method_826())).getAngle());
            var0.setX(var1.getX());
            var0.setY(var1.getY());
            var0.setAngle(var1.getAngle());
        }

        if(var0.method_904()) {
            var1.setMass(Double.POSITIVE_INFINITY);
            var0.setMass(Double.POSITIVE_INFINITY);
        } else {
            var1.setMass(var0.getMass());
        }

        return var1;
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.b.a.b) com.a.c.c
    static PhysicalBody method_1002(Body var0, class_186 var1) {
        double var2 = var1.method_995().getEpsilon();
        return new RealPhysicalBody(var1.method_997(var0.getId()).longValue(), var0, var0.getName(), var0.getMass(), method_1005(var0.getForm(), var0.getPosition(), var0.getAngle(), var2), var0.isStatic());
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.c, com.a.c.b.a.b) void
    static void method_1003(Body var0, PhysicalBody var1, class_186 var2) {
        if(!NumberUtil.equals(var2.method_996(var1.getId()), var0.getId())) {
            throw new IllegalArgumentException("Can\'t update body ID.");
        } else if(!StringUtil.equals(var1.getName(), var0.getName())) {
            throw new IllegalArgumentException("Can\'t update body name.");
        } else if(!var1.getExcludedBodyIds().isEmpty()) {
            throw new IllegalArgumentException("Excluded (for colliding) body IDs are not supported.");
        } else if(Math.abs(var0.getMass() - var1.getMass()) > 0.0D) {
            throw new IllegalArgumentException("Can\'t update body mass.");
        } else {
            double var3 = var2.method_995().getEpsilon();
            if(!(var1 instanceof RealPhysicalBody)) {
                if(!var0.getPosition().equals(var1.getX(), var1.getY())) {
                    var0.setPosition(var1.getX(), var1.getY());
                }

                if(!NumberUtil.equals(var1.getAngle(), var0.getAngle())) {
                    var0.setAngle(var1.getAngle());
                }

                if(!var0.getVelocity().equals(var1.getVelocity())) {
                    var0.setVelocity(var1.getVelocity().copy());
                }

                if(!var0.getMedianVelocity().equals(var1.getMedianVelocity())) {
                    var0.setMedianVelocity(var1.getMedianVelocity().copy());
                }

                if(!NumberUtil.equals(var1.getAngularVelocity(), var0.getAngularVelocity())) {
                    var0.setAngularVelocity(var1.getAngularVelocity());
                }

                if(!NumberUtil.equals(var1.getMedianAngularVelocity(), var0.getMedianAngularVelocity())) {
                    var0.setMedianAngularVelocity(var1.getMedianAngularVelocity());
                }

                if(!var0.getForce().equals(var1.getForce())) {
                    var0.setForce(var1.getForce().copy());
                }

                if(!NumberUtil.equals(var1.getTorque(), var0.getTorque())) {
                    var0.setTorque(var1.getTorque());
                }

                if(!NumberUtil.equals(var0.getMovementAirFrictionFactor(), var1.getMovementAirFrictionFactor())) {
                    var0.setMovementAirFrictionFactor(var1.getMovementAirFrictionFactor());
                }

                if(!NumberUtil.equals(var0.getRotationAirFrictionFactor(), var1.getRotationAirFrictionFactor())) {
                    var0.setRotationAirFrictionFactor(var1.getRotationAirFrictionFactor());
                }

                double var5;
                Double var7;
                if(var0.getMovementFrictionProvider() instanceof ConstantMovementFrictionProvider) {
                    ConstantMovementFrictionProvider var8 = (ConstantMovementFrictionProvider)var0.getMovementFrictionProvider();
                    var5 = var8.getMovementFrictionFactor();
                    var7 = null;
                } else {
                    if(!(var0.getMovementFrictionProvider() instanceof BidirectionalMovementFrictionProvider)) {
                        throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var0.getMovementFrictionProvider()}));
                    }

                    BidirectionalMovementFrictionProvider var10 = (BidirectionalMovementFrictionProvider)var0.getMovementFrictionProvider();
                    var5 = var10.getLengthwiseMovementFrictionFactor();
                    var7 = var10.getCrosswiseMovementFrictionFactor();
                }

                if(!NumberUtil.equals(var5, var1.getMovementFrictionFactor()) || !NumberUtil.equals(var7, var1.getCrosswiseMovementFrictionFactor())) {
                    if(var1.getCrosswiseMovementFrictionFactor() == null) {
                        var0.setMovementFrictionFactor(var1.getMovementFrictionFactor());
                    } else {
                        var0.setMovementFrictionProvider(new BidirectionalMovementFrictionProvider(var1.getMovementFrictionFactor(), var1.getCrosswiseMovementFrictionFactor().doubleValue()));
                    }
                }

                if(!NumberUtil.equals(var0.getRotationFrictionFactor(), var1.getRotationFrictionFactor())) {
                    var0.setRotationFrictionFactor(var1.getRotationFrictionFactor());
                }

                if(!NumberUtil.equals(var0.getMomentumTransferFactor(), var1.getMomentumTransferFactor())) {
                    var0.setMomentumTransferFactor(var1.getMomentumTransferFactor());
                }

                if(!NumberUtil.equals(var0.getSurfaceFrictionFactor(), var1.getSurfaceFrictionFactor())) {
                    var0.setSurfaceFrictionFactor(var1.getSurfaceFrictionFactor());
                }
            }

            class_125 var9 = var1.getForm();
            if(!var9.method_819(method_1005(var0.getForm(), var0.getPosition(), var0.getAngle(), var3), var3)) {
                var0.setForm(method_1004(var9));
                if(var9 instanceof class_127) {
                    class_127 var6 = (class_127)var9;
                    var0.setPosition((var6.method_823() + var6.method_825()) / 2.0D, (var6.method_824() + var6.method_826()) / 2.0D);
                    var0.setAngle((new Vector2D(var6.method_823(), var6.method_824(), var6.method_825(), var6.method_826())).getAngle());
                    var1.setX(var0.getX());
                    var1.setY(var0.getY());
                    var1.setAngle(var0.getAngle());
                }
            }

        }
    }

    // $FF: renamed from: a (com.a.c.a.c) com.a.a.b.c.c
    private static Form method_1004(class_125 var0) {
        if(var0 == null) {
            return null;
        } else if(var0 instanceof class_129) {
            class_129 var4 = (class_129)var0;
            return new CircularForm(var4.method_829());
        } else if(var0 instanceof class_128) {
            class_128 var3 = (class_128)var0;
            return new RectangularForm(var3.method_827(), var3.method_828());
        } else if(var0 instanceof class_127) {
            class_127 var2 = (class_127)var0;
            return new LinearForm(Math.hypot(var2.method_825() - var2.method_823(), var2.method_826() - var2.method_824()), var0.method_816());
        } else if(var0 instanceof class_126) {
            class_126 var1 = (class_126)var0;
            return new ArcForm(var1.method_820(), var1.method_821(), var1.method_822(), var0.method_816());
        } else {
            throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
        }
    }

    // $FF: renamed from: a (com.a.a.b.c.c, com.codeforces.commons.geometry.Point2D, double, double) com.a.c.a.c
    private static class_125 method_1005(Form var0, Point2D var1, double var2, double var4) {
        if(var0 == null) {
            return null;
        } else {
            switch(var0.getShape()) {
            case CIRCLE:
                CircularForm var7 = (CircularForm)var0;
                return new class_129(var7.getRadius());
            case RECTANGLE:
                RectangularForm var8 = (RectangularForm)var0;
                return new class_128(var8.getWidth(), var8.getHeight());
            case LINE:
                LinearForm var9 = (LinearForm)var0;
                class_127 var11 = new class_127(var9.getPoint1(var1, var2, var4), var9.getPoint2(var1, var2, var4));
                var11.method_817(var9.isEndpointCollisionEnabled());
                return var11;
            case ARC:
                ArcForm var10 = (ArcForm)var0;
                class_126 var6 = new class_126(var10.getRadius(), var10.getAngle(), var10.getSector());
                var6.method_817(var10.isEndpointCollisionEnabled());
                return var6;
            default:
                throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
            }
        }
    }
}
