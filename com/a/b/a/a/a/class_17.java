package com.a.b.a.a.a;

import com.a.a.b.a.class_202;
import com.a.b.class_1;
import com.a.b.class_3;
import com.a.b.a.a.b.class_175;
import com.a.b.a.a.b.class_176;
import com.a.c.class_10;
import com.a.c.b.a.class_186;
import com.google.inject.AbstractModule;

// $FF: renamed from: com.a.b.a.a.a.a
public final class class_17 extends AbstractModule {
    protected void configure() {
        this.bind(class_1.class).toInstance(new class_176());
        class_202 var1 = new class_202(100.0D, 1000.0D);
        this.bind(class_10.class).toInstance(new class_186(10, 1, 1.0E-7D, var1));
        this.bind(class_3.class).toInstance(new class_175(false));
    }
}
