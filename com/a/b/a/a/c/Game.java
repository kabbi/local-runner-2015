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

    public Game(long randomSeed, int tickCount, int worldWidth, int worldHeight, double trackTileSize, double trackTileMargin, int lapCount, int lapTickCount, int initialFreezeDurationTicks, double burningTimeDurationFactor, int[] finishTrackScores, int finishLapScore, double lapWaypointsSummaryScoreFacctor, double carDamageScoreFactor, int carEliminationScore, double carWidth, double carHeigh, double carEnginePowerChangePerTick, double carWheelTurnChangePerTicks, double carAngularSpeedFactor, double carMovementAirFrictionFactor, double carRotationAirFrictionFactor, double carLengthwiseMovementFrictionFactor, double carCrosswiseMovementFrictionFactor, double carRotationFrictionFactor, int throwProjectileCooldownTicks, int useNitroCooldownTicks, int spillOilCooldownTicks, double nitroEnginePowerFactor, int nitroDurationTicks, int carReactivationTimeTicks, double buggyMass, double buggyEngineForwardPower, double buggyEngineRearPower, double jeepMass, double jeepEngineForwardPower, double jeepEngineRearPower, double bonusSize, double bonusMass, int pureScoreAmount, double washerRadius, double washerMass, double washerInitialSpeed, double washerDamage, double sideWasherAngle, double tireRadius, double tireMass, double tireInitialSpeed, double tireDamageFactor, double tireDissapaearSpeedFactor, double oildSlickInitialRange, double oilSlickRadius, int oilSlickLifetime, int maxOiledStateDurationTicks) {
        this.randomSeed = randomSeed;
        this.tickCount = tickCount;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.trackTileSize = trackTileSize;
        this.trackTileMargin = trackTileMargin;
        this.lapCount = lapCount;
        this.lapTickCount = lapTickCount;
        this.initialFreezeDurationTicks = initialFreezeDurationTicks;
        this.burningTimeDurationFactor = burningTimeDurationFactor;
        this.carRotationFrictionFactor = carRotationFrictionFactor;
        this.throwProjectileCooldownTicks = throwProjectileCooldownTicks;
        this.useNitroCooldownTicks = useNitroCooldownTicks;
        this.spillOilCooldownTicks = spillOilCooldownTicks;
        this.nitroEnginePowerFactor = nitroEnginePowerFactor;
        this.nitroDurationTicks = nitroDurationTicks;
        this.carReactivationTimeTicks = carReactivationTimeTicks;
        this.buggyMass = buggyMass;
        this.buggyEngineForwardPower = buggyEngineForwardPower;
        this.buggyEngineRearPower = buggyEngineRearPower;
        this.jeepMass = jeepMass;
        this.jeepEngineForwardPower = jeepEngineForwardPower;
        this.jeepEngineRearPower = jeepEngineRearPower;
        this.bonusSize = bonusSize;
        this.bonusMass = bonusMass;
        this.pureScoreAmount = pureScoreAmount;
        this.washerRadius = washerRadius;
        this.washerMass = washerMass;
        this.washerInitialSpeed = washerInitialSpeed;
        this.washerDamage = washerDamage;
        this.sideWasherAngle = sideWasherAngle;
        this.tireRadius = tireRadius;
        this.tireMass = tireMass;
        this.tireInitialSpeed = tireInitialSpeed;
        this.tireDamageFactor = tireDamageFactor;
        this.tireDisappearSpeedFactor = tireDissapaearSpeedFactor;
        this.oilSlickInitialRange = oildSlickInitialRange;
        this.oilSlickRadius = oilSlickRadius;
        this.oilSlickLifetime = oilSlickLifetime;
        this.maxOiledStateDurationTicks = maxOiledStateDurationTicks;
        this.finishTrackScores = Arrays.copyOf(finishTrackScores, finishTrackScores.length);
        this.finishLapScore = finishLapScore;
        this.lapWaypointsSummaryScoreFactor = lapWaypointsSummaryScoreFacctor;
        this.carDamageScoreFactor = carDamageScoreFactor;
        this.carEliminationScore = carEliminationScore;
        this.carWidth = carWidth;
        this.carHeight = carHeigh;
        this.carEnginePowerChangePerTick = carEnginePowerChangePerTick;
        this.carWheelTurnChangePerTick = carWheelTurnChangePerTicks;
        this.carAngularSpeedFactor = carAngularSpeedFactor;
        this.carMovementAirFrictionFactor = carMovementAirFrictionFactor;
        this.carRotationAirFrictionFactor = carRotationAirFrictionFactor;
        this.carLengthwiseMovementFrictionFactor = carLengthwiseMovementFrictionFactor;
        this.carCrosswiseMovementFrictionFactor = carCrosswiseMovementFrictionFactor;
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
