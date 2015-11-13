package com.a.b.a.a.e.a.a;

import com.a.b.a.a.a.class_18;
import com.a.b.a.a.c.class_130;
import com.a.b.a.a.c.class_131;
import com.a.b.a.a.c.class_132;
import com.a.b.a.a.c.class_133;
import com.a.b.a.a.c.class_134;
import com.a.b.a.a.c.class_135;
import com.a.b.a.a.c.class_136;
import com.a.b.a.a.c.class_137;
import com.a.b.a.a.c.class_145;
import com.a.b.a.a.c.class_146;
import com.a.b.a.a.c.class_147;
import com.a.b.a.a.c.class_149;
import com.a.b.a.a.e.a.class_177;
import com.a.b.a.a.e.a.a.class_193;
import java.io.File;

// $FF: renamed from: com.a.b.a.a.e.a.a.g
public class class_194 extends class_193 {
    // $FF: renamed from: a com.a.b.a.a.e.a.a.f$a
    private final class_193.class_210 field_823 = new class_193.class_210<class_145>() {
        // $FF: renamed from: a (com.a.b.a.a.c.o) void
        public void method_12(class_145 var1) {
            class_194.this.method_1040(var1);
        }
    };
    // $FF: renamed from: b com.a.b.a.a.e.a.a.f$a
    private final class_193.class_210 field_824 = new class_193.class_210<class_136>() {
        // $FF: renamed from: a (com.a.b.a.a.c.c) void
        public void method_12(class_136 var1) {
            class_194.this.method_1042(var1);
        }
    };
    // $FF: renamed from: c com.a.b.a.a.e.a.a.f$a
    private final class_193.class_210 field_825 = new class_193.class_210<class_133>() {
        // $FF: renamed from: a (com.a.b.a.a.c.q) void
        public void method_12(class_133 var1) {
            class_194.this.method_1044(var1);
        }
    };
    // $FF: renamed from: d com.a.b.a.a.e.a.a.f$a
    private final class_193.class_210 field_826 = new class_193.class_210<class_135>() {
        // $FF: renamed from: a (com.a.b.a.a.c.a) void
        public void method_12(class_135 var1) {
            class_194.this.method_1046(var1);
        }
    };
    // $FF: renamed from: e com.a.b.a.a.e.a.a.f$a
    private final class_193.class_210 field_827 = new class_193.class_210<class_132>() {
        // $FF: renamed from: a (com.a.b.a.a.c.n) void
        public void method_12(class_132 var1) {
            class_194.this.method_1048(var1);
        }
    };
    // $FF: renamed from: f int
    private int field_828;

    public class_194(class_18 var1, File var2) {
        super(var1, var2);
    }

    // $FF: renamed from: b () java.lang.String
    public String method_58() {
        method_1052((class_194.class_224)this.a(class_194.class_224.class), class_194.class_224.field_773);
        return this.method_1024();
    }

    // $FF: renamed from: b (int) void
    public void method_59(int var1) {
        this.a(class_194.class_224.field_774);
        this.c(var1);
        this.method_1036();
    }

    // $FF: renamed from: c () int
    public int method_60() {
        method_1052((class_194.class_224)this.a(class_194.class_224.class), class_194.class_224.field_775);
        return this.field_828 = this.method_1028();
    }

    // $FF: renamed from: a (com.a.b.a.a.c.l) void
    public void method_61(class_149 var1) {
        this.a(class_194.class_224.field_776);
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.a(var1.getRandomSeed());
            this.c(var1.getTickCount());
            this.c(var1.getWorldWidth());
            this.c(var1.getWorldHeight());
            this.a(var1.getTrackTileSize());
            this.a(var1.getTrackTileMargin());
            this.c(var1.getLapCount());
            this.c(var1.getLapTickCount());
            this.c(var1.getInitialFreezeDurationTicks());
            this.a(var1.getBurningTimeDurationFactor());
            this.a(var1.getFinishTrackScores(), true);
            this.c(var1.getFinishLapScore());
            this.a(var1.getLapWaypointsSummaryScoreFactor());
            this.a(var1.getCarDamageScoreFactor());
            this.c(var1.getCarEliminationScore());
            this.a(var1.getCarWidth());
            this.a(var1.getCarHeight());
            this.a(var1.getCarEnginePowerChangePerTick());
            this.a(var1.getCarWheelTurnChangePerTick());
            this.a(var1.getCarAngularSpeedFactor());
            this.a(var1.getCarMovementAirFrictionFactor());
            this.a(var1.getCarRotationAirFrictionFactor());
            this.a(var1.getCarLengthwiseMovementFrictionFactor());
            this.a(var1.getCarCrosswiseMovementFrictionFactor());
            this.a(var1.getCarRotationFrictionFactor());
            this.c(var1.getThrowProjectileCooldownTicks());
            this.c(var1.getUseNitroCooldownTicks());
            this.c(var1.getSpillOilCooldownTicks());
            this.a(var1.getNitroEnginePowerFactor());
            this.c(var1.getNitroDurationTicks());
            this.c(var1.getCarReactivationTimeTicks());
            this.a(var1.getBuggyMass());
            this.a(var1.getBuggyEngineForwardPower());
            this.a(var1.getBuggyEngineRearPower());
            this.a(var1.getJeepMass());
            this.a(var1.getJeepEngineForwardPower());
            this.a(var1.getJeepEngineRearPower());
            this.a(var1.getBonusSize());
            this.a(var1.getBonusMass());
            this.c(var1.getPureScoreAmount());
            this.a(var1.getWasherRadius());
            this.a(var1.getWasherMass());
            this.a(var1.getWasherInitialSpeed());
            this.a(var1.getWasherDamage());
            this.a(var1.getSideWasherAngle());
            this.a(var1.getTireRadius());
            this.a(var1.getTireMass());
            this.a(var1.getTireInitialSpeed());
            this.a(var1.getTireDamageFactor());
            this.a(var1.getTireDisappearSpeedFactor());
            this.a(var1.getOilSlickInitialRange());
            this.a(var1.getOilSlickRadius());
            this.c(var1.getOilSlickLifetime());
            this.c(var1.getMaxOiledStateDurationTicks());
            this.method_1036();
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.p, boolean) void
    public void method_62(class_146 var1, boolean var2) {
        this.a(class_194.class_224.field_777);
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.method_1041(var1.getCars());
            this.method_1038(var1.getWorld(), var2);
            this.method_1036();
        }
    }

    // $FF: renamed from: d () com.a.b.a.a.c.m[]
    public class_147[] method_63() {
        method_1052((class_194.class_224)this.a(class_194.class_224.class), class_194.class_224.field_778);
        int var1 = this.method_1028();
        if(var1 < 0) {
            return null;
        } else {
            class_147[] var2 = new class_147[var1];

            for(int var3 = 0; var3 < var1; ++var3) {
                if(this.method_1026()) {
                    class_147 var4 = new class_147();
                    var2[var3] = var4;
                    var4.setEnginePower(this.method_1032());
                    var4.setBrake(this.method_1026());
                    var4.setWheelTurn(this.method_1032());
                    var4.setThrowProjectile(this.method_1026());
                    var4.setUseNitro(this.method_1026());
                    var4.setSpillOil(this.method_1026());
                }
            }

            return var2;
        }
    }

    // $FF: renamed from: e () void
    public void method_64() {
        try {
            this.a(class_194.class_224.field_772);
            this.method_1036();
        } catch (RuntimeException var2) {
            ;
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.v, boolean) void
    private void method_1038(class_137 var1, boolean var2) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.c(var1.getTick());
            this.c(var1.getTickCount());
            this.c(var1.getLastTickIndex());
            this.c(var1.getWidth());
            this.c(var1.getHeight());
            this.method_1039(var1.getPlayersUnsafe());
            this.method_1041(var1.getCarsUnsafe());
            this.method_1043(var1.getProjectilesUnsafe());
            this.method_1045(var1.getBonusesUnsafe());
            this.method_1047(var1.getOilSlicksUnsafe());
            if(var2) {
                this.a(var1.getMapName());
                this.a(var1.getTilesXYUnsafe(), true);
                this.a(var1.getWaypointsUnsafe(), true);
                this.a(var1.getStartingDirection());
            }

        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.o[]) void
    private void method_1039(class_145[] var1) {
        this.a(var1, this.field_823);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.o) void
    private void method_1040(class_145 var1) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.a(var1.getId());
            this.a(var1.isMe());
            this.a(var1.getName());
            this.a(var1.isStrategyCrashed());
            this.c(var1.getScore());
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[]) void
    private void method_1041(class_136[] var1) {
        this.a(var1, this.field_824);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c) void
    private void method_1042(class_136 var1) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.method_1050(var1);
            this.a(var1.getPlayerId());
            this.c(var1.getTeammateIndex());
            this.a(var1.isTeammate());
            this.a(var1.getType());
            this.c(var1.getProjectileCount());
            this.c(var1.getNitroChargeCount());
            this.c(var1.getOilCanisterCount());
            this.c(var1.getRemainingProjectileCooldownTicks());
            this.c(var1.getRemainingNitroCooldownTicks());
            this.c(var1.getRemainingOilCooldownTicks());
            this.c(var1.getRemainingNitroTicks());
            this.c(var1.getRemainingOiledTicks());
            this.a(var1.getDurability());
            this.a(var1.getEnginePower());
            this.a(var1.getWheelTurn());
            this.c(var1.getNextWaypointX());
            this.c(var1.getNextWaypointY());
            this.a(var1.isFinishedTrack());
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.q[]) void
    private void method_1043(class_133[] var1) {
        this.a(var1, this.field_825);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.q) void
    private void method_1044(class_133 var1) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.method_1049(var1);
            this.a(var1.getCarId());
            this.a(var1.getPlayerId());
            this.a(var1.getType());
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.a[]) void
    private void method_1045(class_135[] var1) {
        this.a(var1, this.field_826);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.a) void
    private void method_1046(class_135 var1) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.method_1050(var1);
            this.a(var1.getType());
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.n[]) void
    private void method_1047(class_132[] var1) {
        this.a(var1, this.field_827);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.n) void
    private void method_1048(class_132 var1) {
        if(var1 == null) {
            this.a(false);
        } else {
            this.a(true);
            this.method_1049(var1);
            this.c(var1.getRemainingLifetime());
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.e) void
    private void method_1049(class_131 var1) {
        this.method_1051(var1);
        this.a(var1.getRadius());
    }

    // $FF: renamed from: a (com.a.b.a.a.c.s) void
    private void method_1050(class_134 var1) {
        this.method_1051(var1);
        this.a(var1.getWidth());
        this.a(var1.getHeight());
    }

    // $FF: renamed from: a (com.a.b.a.a.c.u) void
    private void method_1051(class_130 var1) {
        this.a(var1.getId());
        this.a(var1.getMass());
        this.a(var1.getX());
        this.a(var1.getY());
        this.a(var1.getSpeedX());
        this.a(var1.getSpeedY());
        this.a(var1.getAngle());
        this.a(var1.getAngularSpeed());
    }

    // $FF: renamed from: a (com.a.b.a.a.e.a.a.g$a, com.a.b.a.a.e.a.a.g$a) void
    private static void method_1052(class_194.class_224 var0, class_194.class_224 var1) {
        if(var0 != var1) {
            throw new class_177(String.format("Received wrong message [actual=%s, expected=%s].", var0, var1));
        }
    }

    private enum class_224 {
        // $FF: renamed from: a com.a.b.a.a.e.a.a.g$a
        field_771,
        // $FF: renamed from: b com.a.b.a.a.e.a.a.g$a
        field_772,
        // $FF: renamed from: c com.a.b.a.a.e.a.a.g$a
        field_773,
        // $FF: renamed from: d com.a.b.a.a.e.a.a.g$a
        field_774,
        // $FF: renamed from: e com.a.b.a.a.e.a.a.g$a
        field_775,
        // $FF: renamed from: f com.a.b.a.a.e.a.a.g$a
        field_776,
        // $FF: renamed from: g com.a.b.a.a.e.a.a.g$a
        field_777,
        // $FF: renamed from: h com.a.b.a.a.e.a.a.g$a
        field_778;
    }
}
