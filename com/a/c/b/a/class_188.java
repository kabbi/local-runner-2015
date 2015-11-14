package com.a.c.b.a;

import com.a.a.b.class_106;
import com.a.a.b.c.class_113;
import com.a.a.b.c.class_114;
import com.a.a.b.c.class_115;
import com.a.a.b.c.class_117;
import com.a.a.b.c.class_118;
import com.a.a.b.e.class_184;
import com.a.a.b.e.class_185;
import com.a.c.Body;
import com.a.c.a.Form;
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
    static class_106 method_1001(Body var0) {
        class_106 var1 = new class_106();
        var1.method_667(var0.getName());
        Form var2 = var0.getForm();
        var1.method_669(method_1004(var2));
        if(var2 instanceof class_127) {
            class_127 var3 = (class_127)var2;
            var1.method_694((var3.method_823() + var3.method_825()) / 2.0D, (var3.method_824() + var3.method_826()) / 2.0D);
            var1.method_708((new Vector2D(var3.method_823(), var3.method_824(), var3.method_825(), var3.method_826())).getAngle());
            var0.setX(var1.method_695());
            var0.setY(var1.method_697());
            var0.setAngle(var1.method_707());
        }

        if(var0.getStaticBody()) {
            var1.method_671(Double.POSITIVE_INFINITY);
            var0.setMass(Double.POSITIVE_INFINITY);
        } else {
            var1.method_671(var0.getMass());
        }

        return var1;
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.b.a.b) com.a.c.c
    static Body method_1002(class_106 var0, class_186 var1) {
        double var2 = var1.method_995().method_725();
        return new NonmaterialBodyLikeAGhost(var1.method_997(var0.method_665()).longValue(), var0, var0.method_666(), var0.method_670(), method_1005(var0.method_668(), var0.method_693(), var0.method_707(), var2), var0.method_672());
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.c.c, com.a.c.b.a.b) void
    static void method_1003(class_106 var0, Body var1, class_186 var2) {
        if(!NumberUtil.equals(var2.method_996(var1.getId()), var0.method_665())) {
            throw new IllegalArgumentException("Can\'t update body ID.");
        } else if(!StringUtil.equals(var1.getName(), var0.method_666())) {
            throw new IllegalArgumentException("Can\'t update body name.");
        } else if(!var1.getExcludedBodyIds().isEmpty()) {
            throw new IllegalArgumentException("Excluded (for colliding) body IDs are not supported.");
        } else if(Math.abs(var0.method_670() - var1.getMass()) > 0.0D) {
            throw new IllegalArgumentException("Can\'t update body mass.");
        } else {
            double var3 = var2.method_995().method_725();
            if(!(var1 instanceof NonmaterialBodyLikeAGhost)) {
                if(!var0.method_693().equals(var1.getX(), var1.getY())) {
                    var0.method_694(var1.getX(), var1.getY());
                }

                if(!NumberUtil.equals(var1.getAngle(), var0.method_707())) {
                    var0.method_708(var1.getAngle());
                }

                if(!var0.method_699().equals(var1.getSpeed())) {
                    var0.method_700(var1.getSpeed().copy());
                }

                if(!var0.method_702().equals(var1.setMedianSpeed())) {
                    var0.method_703(var1.setMedianSpeed().copy());
                }

                if(!NumberUtil.equals(var1.angularSpeed(), var0.method_709())) {
                    var0.method_710(var1.angularSpeed());
                }

                if(!NumberUtil.equals(var1.getAngularSpeed(), var0.method_711())) {
                    var0.method_712(var1.getAngularSpeed());
                }

                if(!var0.method_704().equals(var1.getTheForce())) {
                    var0.method_705(var1.getTheForce().copy());
                }

                if(!NumberUtil.equals(var1.getTorque(), var0.method_713())) {
                    var0.method_714(var1.getTorque());
                }

                if(!NumberUtil.equals(var0.method_676(), var1.getMovementAirFrictionFactor())) {
                    var0.method_677(var1.getMovementAirFrictionFactor());
                }

                if(!NumberUtil.equals(var0.method_678(), var1.getRotationAirFrictionFactor())) {
                    var0.method_679(var1.getRotationAirFrictionFactor());
                }

                double var5;
                Double var7;
                if(var0.method_680() instanceof class_184) {
                    class_184 var8 = (class_184)var0.method_680();
                    var5 = var8.method_988();
                    var7 = null;
                } else {
                    if(!(var0.method_680() instanceof class_185)) {
                        throw new IllegalArgumentException(String.format("Unsupported movement friction provider: %s.", new Object[]{var0.method_680()}));
                    }

                    class_185 var10 = (class_185)var0.method_680();
                    var5 = var10.method_989();
                    var7 = var10.method_990();
                }

                if(!NumberUtil.equals(var5, var1.getMovementFrictionFactor()) || !NumberUtil.equals(var7, var1.getCrosswiseMovementFrictionFactor())) {
                    if(var1.getCrosswiseMovementFrictionFactor() == null) {
                        var0.method_682(var1.getMovementFrictionFactor());
                    } else {
                        var0.method_681(new class_185(var1.getMovementFrictionFactor(), var1.getCrosswiseMovementFrictionFactor().doubleValue()));
                    }
                }

                if(!NumberUtil.equals(var0.method_684(), var1.getRotationFrictionFactor())) {
                    var0.method_685(var1.getRotationFrictionFactor());
                }

                if(!NumberUtil.equals(var0.method_686(), var1.getMomentumTransferFactor())) {
                    var0.method_687(var1.getMomentumTransferFactor());
                }

                if(!NumberUtil.equals(var0.method_688(), var1.getSurfaceFriction())) {
                    var0.method_689(var1.getSurfaceFriction());
                }
            }

            Form var9 = var1.getForm();
            if(!var9.method_819(method_1005(var0.method_668(), var0.method_693(), var0.method_707(), var3), var3)) {
                var0.method_669(method_1004(var9));
                if(var9 instanceof class_127) {
                    class_127 var6 = (class_127)var9;
                    var0.method_694((var6.method_823() + var6.method_825()) / 2.0D, (var6.method_824() + var6.method_826()) / 2.0D);
                    var0.method_708((new Vector2D(var6.method_823(), var6.method_824(), var6.method_825(), var6.method_826())).getAngle());
                    var1.setX(var0.method_695());
                    var1.setY(var0.method_697());
                    var1.setAngle(var0.method_707());
                }
            }

        }
    }

    // $FF: renamed from: a (com.a.c.a.c) com.a.a.b.c.c
    private static class_113 method_1004(Form var0) {
        if(var0 == null) {
            return null;
        } else if(var0 instanceof class_129) {
            class_129 var4 = (class_129)var0;
            return new class_114(var4.method_829());
        } else if(var0 instanceof class_128) {
            class_128 var3 = (class_128)var0;
            return new class_115(var3.getCarWidth(), var3.getCarHeight());
        } else if(var0 instanceof class_127) {
            class_127 var2 = (class_127)var0;
            return new class_118(Math.hypot(var2.method_825() - var2.method_823(), var2.method_826() - var2.method_824()), var0.method_816());
        } else if(var0 instanceof class_126) {
            class_126 var1 = (class_126)var0;
            return new class_117(var1.method_820(), var1.method_821(), var1.method_822(), var0.method_816());
        } else {
            throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
        }
    }

    // $FF: renamed from: a (com.a.a.b.c.c, com.codeforces.commons.geometry.Point2D, double, double) com.a.c.a.c
    private static Form method_1005(class_113 var0, Point2D var1, double var2, double var4) {
        if(var0 == null) {
            return null;
        } else {
            switch(var0.method_764().ordinal()) {
            case 1:
                class_114 var7 = (class_114)var0;
                return new class_129(var7.method_771());
            case 2:
                class_115 var8 = (class_115)var0;
                return new class_128(var8.method_772(), var8.method_773());
            case 3:
                class_118 var9 = (class_118)var0;
                class_127 var11 = new class_127(var9.method_779(var1, var2, var4), var9.method_780(var1, var2, var4));
                var11.method_817(var9.method_775());
                return var11;
            case 4:
                class_117 var10 = (class_117)var0;
                class_126 var6 = new class_126(var10.method_776(), var10.method_777(), var10.method_778());
                var6.method_817(var10.method_775());
                return var6;
            default:
                throw new IllegalArgumentException("Unsupported form: " + var0 + '.');
            }
        }
    }
}
