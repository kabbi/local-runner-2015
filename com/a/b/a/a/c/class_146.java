package com.a.b.a.a.c;

import com.a.b.a.a.c.class_136;
import com.a.b.a.a.c.class_137;
import java.util.Arrays;

// $FF: renamed from: com.a.b.a.a.c.p
public final class class_146 {
    private final class_136[] cars;
    private final class_137 world;

    public class_146(class_136[] var1, class_137 var2) {
        this.cars = (class_136[])Arrays.copyOf(var1, var1.length);
        this.world = var2;
    }

    public class_136[] getCars() {
        return (class_136[])Arrays.copyOf(this.cars, this.cars.length);
    }

    public class_137 getWorld() {
        return this.world;
    }
}
