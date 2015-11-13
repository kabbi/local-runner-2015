package com.a.b.a.a.c;

import java.util.Arrays;

// $FF: renamed from: com.a.b.a.a.c.p
public final class class_146 {
    private final Car[] cars;
    private final World world;

    public class_146(Car[] var1, World var2) {
        this.cars = (Car[])Arrays.copyOf(var1, var1.length);
        this.world = var2;
    }

    public Car[] getCars() {
        return (Car[])Arrays.copyOf(this.cars, this.cars.length);
    }

    public World getWorld() {
        return this.world;
    }
}
