package com.a.b.a.a.a;

import com.a.a.b.a.CellSpaceBodyList;
import com.a.b.GameSimulator;
import com.a.b.class_3;
import com.a.b.a.a.b.class_175;
import com.a.b.a.a.b.GameSimulatorImpl;
import com.a.c.class_10;
import com.a.c.b.a.class_186;
import com.google.inject.AbstractModule;

// $FF: renamed from: com.a.b.a.a.a.a
public final class GameModule extends AbstractModule {
    protected void configure() {
        this.bind(GameSimulator.class).toInstance(new GameSimulatorImpl());
        CellSpaceBodyList var1 = new CellSpaceBodyList(100.0D, 1000.0D);
        this.bind(class_10.class).toInstance(new class_186(10, 1, 1.0E-7D, var1));
        this.bind(class_3.class).toInstance(new class_175(false));
    }
}
