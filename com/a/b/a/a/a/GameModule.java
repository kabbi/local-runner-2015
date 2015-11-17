package com.a.b.a.a.a;

import com.a.a.b.a.CellSpaceBodyList;
import com.a.b.GameSimulator;
import com.a.b.class_3;
import com.a.b.a.a.b.class_175;
import com.a.b.a.a.b.GameSimulatorImpl;
import com.a.c.PhysicsManager;
import com.a.c.b.a.PhysicsManagerImpl;
import com.google.inject.AbstractModule;

// $FF: renamed from: com.a.b.a.a.a.a
public final class GameModule extends AbstractModule {
    protected void configure() {
        this.bind(GameSimulator.class).toInstance(new GameSimulatorImpl());
        CellSpaceBodyList fastBodyList = new CellSpaceBodyList(100.0D, 1000.0D);
        this.bind(PhysicsManager.class).toInstance(new PhysicsManagerImpl(10, 1, 1.0E-7D, fastBodyList));
        this.bind(class_3.class).toInstance(new class_175(false));
    }
}
