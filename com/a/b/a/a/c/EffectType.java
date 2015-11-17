package com.a.b.a.a.c;

// $FF: renamed from: com.a.b.a.a.c.k
public enum EffectType {
    CAR_AND_BORDER_IMPACT(10),
    CAR_AND_CAR_IMPACT(10),
    CAR_AND_WASHER_IMPACT(10),
    CAR_AND_TIRE_IMPACT(10),
    DRIFTING(60),
    CAR_CONDITION_CHANGE(60);

    private static final int DEFAULT_EFFECT_DURATION = 1;
    private final int duration;

    EffectType(int duration) {
        if(duration < 1) {
            throw new IllegalArgumentException("Argument \'duration\' is less than 1.");
        } else if(duration > 32767) {
            throw new IllegalArgumentException("Argument \'duration\' is greater than 32767.");
        } else {
            this.duration = duration;
        }
    }

    EffectType() {
        this(DEFAULT_EFFECT_DURATION);
    }

    public int getDuration() {
        return this.duration;
    }
}
