package com.a.b.a.a.c;

import java.util.Arrays;

// $FF: renamed from: com.a.b.a.a.c.l
public class Game {
    private final long randomSeed;
    private final int tickCount;
    private final int worldWidth;
    private final int worldHeight;
    private final double trackTileSize;
    private final double trackTileMargin;
    private final int lapCount;
    private final int lapTickCount;
    private final int initialFreezeDurationTicks;
    private final double burningTimeDurationFactor;
    private final int[] finishTrackScores;
    private final int finishLapScore;
    private final double lapWaypointsSummaryScoreFactor;
    private final double carDamageScoreFactor;
    private final int carEliminationScore;
    private final double carWidth;
    private final double carHeight;
    private final double carEnginePowerChangePerTick;
    private final double carWheelTurnChangePerTick;
    private final double carAngularSpeedFactor;
    private final double carMovementAirFrictionFactor;
    private final double carRotationAirFrictionFactor;
    private final double carLengthwiseMovementFrictionFactor;
    private final double carCrosswiseMovementFrictionFactor;
    private final double carRotationFrictionFactor;
    private final int throwProjectileCooldownTicks;
    private final int useNitroCooldownTicks;
    private final int spillOilCooldownTicks;
    private final double nitroEnginePowerFactor;
    private final int nitroDurationTicks;
    private final int carReactivationTimeTicks;
    private final double buggyMass;
    private final double buggyEngineForwardPower;
    private final double buggyEngineRearPower;
    private final double jeepMass;
    private final double jeepEngineForwardPower;
    private final double jeepEngineRearPower;
    private final double bonusSize;
    private final double bonusMass;
    private final int pureScoreAmount;
    private final double washerRadius;
    private final double washerMass;
    private final double washerInitialSpeed;
    private final double washerDamage;
    private final double sideWasherAngle;
    private final double tireRadius;
    private final double tireMass;
    private final double tireInitialSpeed;
    private final double tireDamageFactor;
    private final double tireDisappearSpeedFactor;
    private final double oilSlickInitialRange;
    private final double oilSlickRadius;
    private final int oilSlickLifetime;
    private final int maxOiledStateDurationTicks;

    public Game(long var1, int var3, int var4, int var5, double var6, double var8, int var10, int var11, int var12, double var13, int[] var15, int var16, double var17, double var19, int var21, double var22, double var24, double var26, double var28, double var30, double var32, double var34, double var36, double var38, double var40, int var42, int var43, int var44, double var45, int var47, int var48, double var49, double var51, double var53, double var55, double var57, double var59, double var61, double var63, int var65, double var66, double var68, double var70, double var72, double var74, double var76, double var78, double var80, double var82, double var84, double var86, double var88, int var90, int var91) {
        this.randomSeed = var1;
        this.tickCount = var3;
        this.worldWidth = var4;
        this.worldHeight = var5;
        this.trackTileSize = var6;
        this.trackTileMargin = var8;
        this.lapCount = var10;
        this.lapTickCount = var11;
        this.initialFreezeDurationTicks = var12;
        this.burningTimeDurationFactor = var13;
        this.carRotationFrictionFactor = var40;
        this.throwProjectileCooldownTicks = var42;
        this.useNitroCooldownTicks = var43;
        this.spillOilCooldownTicks = var44;
        this.nitroEnginePowerFactor = var45;
        this.nitroDurationTicks = var47;
        this.carReactivationTimeTicks = var48;
        this.buggyMass = var49;
        this.buggyEngineForwardPower = var51;
        this.buggyEngineRearPower = var53;
        this.jeepMass = var55;
        this.jeepEngineForwardPower = var57;
        this.jeepEngineRearPower = var59;
        this.bonusSize = var61;
        this.bonusMass = var63;
        this.pureScoreAmount = var65;
        this.washerRadius = var66;
        this.washerMass = var68;
        this.washerInitialSpeed = var70;
        this.washerDamage = var72;
        this.sideWasherAngle = var74;
        this.tireRadius = var76;
        this.tireMass = var78;
        this.tireInitialSpeed = var80;
        this.tireDamageFactor = var82;
        this.tireDisappearSpeedFactor = var84;
        this.oilSlickInitialRange = var86;
        this.oilSlickRadius = var88;
        this.oilSlickLifetime = var90;
        this.maxOiledStateDurationTicks = var91;
        this.finishTrackScores = Arrays.copyOf(var15, var15.length);
        this.finishLapScore = var16;
        this.lapWaypointsSummaryScoreFactor = var17;
        this.carDamageScoreFactor = var19;
        this.carEliminationScore = var21;
        this.carWidth = var22;
        this.carHeight = var24;
        this.carEnginePowerChangePerTick = var26;
        this.carWheelTurnChangePerTick = var28;
        this.carAngularSpeedFactor = var30;
        this.carMovementAirFrictionFactor = var32;
        this.carRotationAirFrictionFactor = var34;
        this.carLengthwiseMovementFrictionFactor = var36;
        this.carCrosswiseMovementFrictionFactor = var38;
    }

    public long getRandomSeed() {
        return this.randomSeed;
    }

    public int getTickCount() {
        return this.tickCount;
    }

    public int getWorldWidth() {
        return this.worldWidth;
    }

    public int getWorldHeight() {
        return this.worldHeight;
    }

    public double getTrackTileSize() {
        return this.trackTileSize;
    }

    public double getTrackTileMargin() {
        return this.trackTileMargin;
    }

    public int getLapCount() {
        return this.lapCount;
    }

    public int getLapTickCount() {
        return this.lapTickCount;
    }

    public int getInitialFreezeDurationTicks() {
        return this.initialFreezeDurationTicks;
    }

    public double getBurningTimeDurationFactor() {
        return this.burningTimeDurationFactor;
    }

    public int[] getFinishTrackScores() {
        return Arrays.copyOf(this.finishTrackScores, this.finishTrackScores.length);
    }

    public int getFinishLapScore() {
        return this.finishLapScore;
    }

    public double getLapWaypointsSummaryScoreFactor() {
        return this.lapWaypointsSummaryScoreFactor;
    }

    public double getCarDamageScoreFactor() {
        return this.carDamageScoreFactor;
    }

    public int getCarEliminationScore() {
        return this.carEliminationScore;
    }

    public double getCarWidth() {
        return this.carWidth;
    }

    public double getCarHeight() {
        return this.carHeight;
    }

    public double getCarEnginePowerChangePerTick() {
        return this.carEnginePowerChangePerTick;
    }

    public double getCarWheelTurnChangePerTick() {
        return this.carWheelTurnChangePerTick;
    }

    public double getCarAngularSpeedFactor() {
        return this.carAngularSpeedFactor;
    }

    public double getCarMovementAirFrictionFactor() {
        return this.carMovementAirFrictionFactor;
    }

    public double getCarRotationAirFrictionFactor() {
        return this.carRotationAirFrictionFactor;
    }

    public double getCarLengthwiseMovementFrictionFactor() {
        return this.carLengthwiseMovementFrictionFactor;
    }

    public double getCarCrosswiseMovementFrictionFactor() {
        return this.carCrosswiseMovementFrictionFactor;
    }

    public double getCarRotationFrictionFactor() {
        return this.carRotationFrictionFactor;
    }

    public int getThrowProjectileCooldownTicks() {
        return this.throwProjectileCooldownTicks;
    }

    public int getUseNitroCooldownTicks() {
        return this.useNitroCooldownTicks;
    }

    public int getSpillOilCooldownTicks() {
        return this.spillOilCooldownTicks;
    }

    public double getNitroEnginePowerFactor() {
        return this.nitroEnginePowerFactor;
    }

    public int getNitroDurationTicks() {
        return this.nitroDurationTicks;
    }

    public int getCarReactivationTimeTicks() {
        return this.carReactivationTimeTicks;
    }

    public double getBuggyMass() {
        return this.buggyMass;
    }

    public double getBuggyEngineForwardPower() {
        return this.buggyEngineForwardPower;
    }

    public double getBuggyEngineRearPower() {
        return this.buggyEngineRearPower;
    }

    public double getJeepMass() {
        return this.jeepMass;
    }

    public double getJeepEngineForwardPower() {
        return this.jeepEngineForwardPower;
    }

    public double getJeepEngineRearPower() {
        return this.jeepEngineRearPower;
    }

    public double getBonusSize() {
        return this.bonusSize;
    }

    public double getBonusMass() {
        return this.bonusMass;
    }

    public int getPureScoreAmount() {
        return this.pureScoreAmount;
    }

    public double getWasherRadius() {
        return this.washerRadius;
    }

    public double getWasherMass() {
        return this.washerMass;
    }

    public double getWasherInitialSpeed() {
        return this.washerInitialSpeed;
    }

    public double getWasherDamage() {
        return this.washerDamage;
    }

    public double getSideWasherAngle() {
        return this.sideWasherAngle;
    }

    public double getTireRadius() {
        return this.tireRadius;
    }

    public double getTireMass() {
        return this.tireMass;
    }

    public double getTireInitialSpeed() {
        return this.tireInitialSpeed;
    }

    public double getTireDamageFactor() {
        return this.tireDamageFactor;
    }

    public double getTireDisappearSpeedFactor() {
        return this.tireDisappearSpeedFactor;
    }

    public double getOilSlickInitialRange() {
        return this.oilSlickInitialRange;
    }

    public double getOilSlickRadius() {
        return this.oilSlickRadius;
    }

    public int getOilSlickLifetime() {
        return this.oilSlickLifetime;
    }

    public int getMaxOiledStateDurationTicks() {
        return this.maxOiledStateDurationTicks;
    }
}
