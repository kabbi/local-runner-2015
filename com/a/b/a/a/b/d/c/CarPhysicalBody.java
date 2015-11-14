package com.a.b.a.a.b.d.c;

import com.a.b.RectangleBody;
import com.a.b.a.a.b.BoringTeamInfo;
import com.a.b.a.a.c.CarClass;
import com.a.c.a.class_128;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.IntPair;
import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.b.a.a.b.d.c.b
public abstract class CarPhysicalBody extends RectangleBody {
    // $FF: renamed from: a com.a.b.a.a.b.n
    @Name("player")
    private final BoringTeamInfo boringTeamInfo;
    // $FF: renamed from: b int
    private final int teammateIndex;
    // $FF: renamed from: c com.a.b.a.a.c.d
    @Name("type")
    private final CarClass carClass;
    // $FF: renamed from: d double
    private double durability;
    // $FF: renamed from: e java.lang.Integer
    private Integer field_161;
    // $FF: renamed from: f double
    private double power;
    // $FF: renamed from: g double
    private double wheelTurn;
    // $FF: renamed from: h double
    private final double frontEnginePower;
    // $FF: renamed from: i double
    private final double rearEnginePower;
    // $FF: renamed from: j com.codeforces.commons.pair.IntPair
    private IntPair actuallyMoreLikeNextWaypoint;
    // $FF: renamed from: k int
    private int field_167;
    // $FF: renamed from: l int
    private int projectileCount;
    // $FF: renamed from: m int
    private int nitroChangeCount;
    // $FF: renamed from: n int
    private int oilCannisterCount;
    // $FF: renamed from: o int
    private int remainingProjectilesCooldowTicks;
    // $FF: renamed from: p int
    private int remainingNitroTicks;
    // $FF: renamed from: q int
    private int remainingOildCooldownTicks;
    // $FF: renamed from: r int
    private int remNitroTicks;
    // $FF: renamed from: s int
    private int remainigOiledTicks;
    // $FF: renamed from: t int
    private int field_176;
    // $FF: renamed from: u boolean
    private boolean field_177;
    // $FF: renamed from: v java.lang.Integer
    private Integer field_178;
    // $FF: renamed from: w int
    private int field_179;
    // $FF: renamed from: x java.lang.Integer
    private Integer field_180;

    protected CarPhysicalBody(BoringTeamInfo var1, int var2, CarClass carClass, double var4, double var6, double var8, double mass, double frontEnginePower, double rearEnginePower, IntPair probablyCoordinates) {
        super(new class_128(210.0D, 140.0D));
        if(!Double.isNaN(mass) && !Double.isInfinite(mass) && mass > 0.0D) {
            this.boringTeamInfo = var1;
            this.teammateIndex = var2;
            this.carClass = carClass;
            this.durability = 1.0D;
            this.power = 0.0D;
            this.wheelTurn = 0.0D;
            this.frontEnginePower = frontEnginePower;
            this.rearEnginePower = rearEnginePower;
            this.actuallyMoreLikeNextWaypoint = new IntPair(probablyCoordinates);
            this.field_167 = 1;
            this.projectileCount = 1;
            this.nitroChangeCount = 1;
            this.oilCannisterCount = 1;
            this.getBody().setX(var4);
            this.getBody().setY(var6);
            this.getBody().setAngle(var8);
            this.getBody().setMass(mass);
            this.getBody().setMovementAirFrictionFactor(0.0075D);
            this.getBody().setRotationAirFrictionFactor(0.0075D);
            this.getBody().setMovementFrictionFactor(0.001D);
            this.getBody().setCrosswiseMovementFrictionFactor(0.25D);
            this.getBody().setRotationFrictionFactor(0.008726646259971648D);
            this.getBody().setMomentumTransferFactor(0.5D);
            this.getBody().setSurfaceFriction(0.25D);
        } else {
            throw new IllegalArgumentException("Argument \'mass\' is not a positive number.");
        }
    }

    // $FF: renamed from: k () com.a.b.a.a.b.n
    public BoringTeamInfo getBoringTeamInfo() {
        return this.boringTeamInfo;
    }

    // $FF: renamed from: l () int
    public int getTeammateIndex() {
        return this.teammateIndex;
    }

    // $FF: renamed from: m () com.a.b.a.a.c.d
    public CarClass type() {
        return this.carClass;
    }

    // $FF: renamed from: n () double
    public double getDurability() {
        return this.durability;
    }

    // $FF: renamed from: a (double) void
    public void setDurability(double var1) {
        this.durability = var1;
    }

    // $FF: renamed from: o () java.lang.Integer
    public Integer method_302() {
        return this.field_161;
    }

    // $FF: renamed from: a (java.lang.Integer) void
    public void method_303(Integer var1) {
        this.field_161 = var1;
    }

    // $FF: renamed from: p () double
    public double getEnginePower() {
        return this.power;
    }

    // $FF: renamed from: a (double, boolean) void
    public void setEnginePower(double enginePower, boolean NITRO_POWR) {
        this.power = Math.min(Math.max(enginePower, -1.0D), NITRO_POWR?2.0D:1.0D);
    }

    // $FF: renamed from: b (double) void
    public void processEnginePowerChangeOneTick(double setEnginePower) {
        this.setEnginePower(this.power, false);
        setEnginePower = Math.min(Math.max(setEnginePower, -1.0D), 1.0D);
        double powerDiff = setEnginePower - this.power;
        if(powerDiff > 0.025D) {
            powerDiff = 0.025D;
        } else if(powerDiff < -0.025D) {
            powerDiff = -0.025D;
        }

        this.setEnginePower(this.power + powerDiff, false);
    }

    // $FF: renamed from: q () double
    public double getWheelTurn() {
        return this.wheelTurn;
    }

    // $FF: renamed from: c (double) void
    public void validateMinMaxWheelTurn(double var1) {
        this.wheelTurn = Math.min(Math.max(var1, -1.0D), 1.0D);
    }

    // $FF: renamed from: d (double) void
    public void setWheelTurn(double var1) {
        this.validateMinMaxWheelTurn(this.wheelTurn);
        var1 = Math.min(Math.max(var1, -1.0D), 1.0D);
        double wheelTurnChange = var1 - this.wheelTurn;
        if(wheelTurnChange > 0.05D) {
            wheelTurnChange = 0.05D;
        } else if(wheelTurnChange < -0.05D) {
            wheelTurnChange = -0.05D;
        }

        this.validateMinMaxWheelTurn(this.wheelTurn + wheelTurnChange);
    }

    // $FF: renamed from: r () double
    public double method_310() {
        return this.frontEnginePower;
    }

    // $FF: renamed from: s () double
    public double method_311() {
        return this.rearEnginePower;
    }

    // $FF: renamed from: t () com.codeforces.commons.pair.IntPair
    public IntPair getNextWaypoint() {
        return new IntPair(this.actuallyMoreLikeNextWaypoint);
    }

    // $FF: renamed from: a (com.codeforces.commons.pair.IntPair) void
    public void method_313(IntPair var1) {
        this.actuallyMoreLikeNextWaypoint = new IntPair(var1);
    }

    // $FF: renamed from: u () int
    public int method_314() {
        return this.field_167;
    }

    // $FF: renamed from: c (int) void
    public void method_315(int var1) {
        this.field_167 = var1;
    }

    // $FF: renamed from: v () int
    public int getProjectileCount() {
        return this.projectileCount;
    }

    // $FF: renamed from: d (int) void
    public void method_317(int var1) {
        this.projectileCount = var1;
    }

    // $FF: renamed from: w () int
    public int getNitroChangeCount() {
        return this.nitroChangeCount;
    }

    // $FF: renamed from: e (int) void
    public void method_319(int var1) {
        this.nitroChangeCount = var1;
    }

    // $FF: renamed from: x () int
    public int getOildCannisterCount() {
        return this.oilCannisterCount;
    }

    // $FF: renamed from: f (int) void
    public void method_321(int var1) {
        this.oilCannisterCount = var1;
    }

    // $FF: renamed from: y () int
    public int getRemainingProjectilesCooldownTicks() {
        return this.remainingProjectilesCooldowTicks;
    }

    // $FF: renamed from: g (int) void
    public void method_323(int var1) {
        this.remainingProjectilesCooldowTicks = var1;
    }

    // $FF: renamed from: z () void
    public void method_324() {
        if(this.remainingProjectilesCooldowTicks > 0) {
            --this.remainingProjectilesCooldowTicks;
        }

    }

    // $FF: renamed from: A () int
    public int getRemainingNitroCooldownTicks() {
        return this.remainingNitroTicks;
    }

    // $FF: renamed from: h (int) void
    public void method_326(int var1) {
        this.remainingNitroTicks = var1;
    }

    // $FF: renamed from: B () void
    public void method_327() {
        if(this.remainingNitroTicks > 0) {
            --this.remainingNitroTicks;
        }

    }

    // $FF: renamed from: C () int
    public int getRemainingOilCooldownTicks() {
        return this.remainingOildCooldownTicks;
    }

    // $FF: renamed from: i (int) void
    public void method_329(int var1) {
        this.remainingOildCooldownTicks = var1;
    }

    // $FF: renamed from: D () void
    public void method_330() {
        if(this.remainingOildCooldownTicks > 0) {
            --this.remainingOildCooldownTicks;
        }

    }

    // $FF: renamed from: E () int
    public int getRemainingNitroTicks() {
        return this.remNitroTicks;
    }

    // $FF: renamed from: j (int) void
    public void method_332(int var1) {
        this.remNitroTicks = var1;
    }

    // $FF: renamed from: F () void
    public void method_333() {
        if(this.remNitroTicks > 0) {
            --this.remNitroTicks;
        }

    }

    // $FF: renamed from: G () int
    public int getRemainingOiledTicks() {
        return this.remainigOiledTicks;
    }

    // $FF: renamed from: k (int) void
    public void method_335(int var1) {
        this.remainigOiledTicks = var1;
    }

    // $FF: renamed from: H () void
    public void method_336() {
        if(this.remainigOiledTicks > 0) {
            --this.remainigOiledTicks;
        }

    }

    // $FF: renamed from: I () int
    public int method_337() {
        return this.field_176;
    }

    // $FF: renamed from: l (int) void
    public void method_338(int var1) {
        this.field_176 = var1;
    }

    // $FF: renamed from: J () void
    public void method_339() {
        if(this.field_176 > 0) {
            --this.field_176;
        }

    }

    // $FF: renamed from: K () boolean
    public boolean method_340() {
        return this.field_177;
    }

    // $FF: renamed from: a (boolean) void
    public void method_341(boolean var1) {
        this.field_177 = var1;
    }

    // $FF: renamed from: L () java.lang.Integer
    public Integer method_342() {
        return this.field_178;
    }

    // $FF: renamed from: b (java.lang.Integer) void
    public void method_343(Integer var1) {
        this.field_178 = var1;
    }

    // $FF: renamed from: M () java.lang.Integer
    public Integer method_344() {
        return this.field_180;
    }

    // $FF: renamed from: N () boolean
    public boolean isFinishedTrack() {
        return this.field_180 != null;
    }

    // $FF: renamed from: m (int) void
    public void probablyStart(int var1) {
        ++this.projectileCount;
        ++this.nitroChangeCount;
        ++this.oilCannisterCount;
        ++this.field_179;
        if(this.field_179 >= 4) {
            this.field_180 = var1;
        }

    }

    public String toString() {
        return StringUtil.toString(this, false, "id", "player.name", "type");
    }
}
