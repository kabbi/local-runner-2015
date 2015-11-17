package com.a.c.b.a;

import com.a.a.a.a.RandomUtils;
import com.a.a.b.Body;
import com.a.a.b.World;
import com.a.a.b.a.BodyList;
import com.a.a.b.b.CollisionInfo;
import com.a.a.b.d.CollisionListenerAdapter;
import com.a.c.class_10;
import com.a.c.class_159;
import com.a.c.class_162;
import com.a.c.class_8;
import com.a.c.class_9;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.a.c.b.a.b
public class class_186 implements class_10 {
    // $FF: renamed from: a java.util.concurrent.locks.Lock
    private final Lock field_790 = new ReentrantLock();
    // $FF: renamed from: b java.util.Map
    private final Map field_791 = new HashMap();
    // $FF: renamed from: c java.util.Map
    private final Map field_792 = new HashMap();
    // $FF: renamed from: d java.util.Map
    private final Map field_793 = new HashMap();
    // $FF: renamed from: e com.a.a.b.g
    private final World world;

    public class_186() {
        this.world = new World();
    }

    public class_186(int var1, int var2, double epsilon, BodyList bodyList) {
        this.world = new World(var1, var2, epsilon, bodyList);
    }

    // $FF: renamed from: a (com.a.c.c) com.a.c.c
    public class_159 method_44(class_159 var1) {
        this.field_790.lock();

        class_159 var3;
        try {
            Body var2 = this.method_998(var1.method_867());
            if(var2 == null) {
                var2 = class_188.method_1001(var1);
                this.world.addBody(var2);
                this.field_791.put(Long.valueOf(var2.getId()), var2);
                this.field_792.put(Long.valueOf(var1.method_867()), Long.valueOf(var2.getId()));
                this.field_793.put(Long.valueOf(var2.getId()), Long.valueOf(var1.method_867()));
                class_188.method_1003(var2, var1, this);
            }

            var3 = this.method_1000(var1.method_867());
        } finally {
            this.field_790.unlock();
        }

        return var3;
    }

    // $FF: renamed from: b (com.a.c.c) void
    public void method_45(class_159 var1) {
        this.field_790.lock();

        try {
            Body var2 = this.method_998(var1.method_867());
            if(var2 == null) {
                throw new IllegalArgumentException("No body with ID " + var1.method_867() + '.');
            }

            class_188.method_1003(var2, var1, this);
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: c (com.a.c.c) void
    public void method_46(class_159 var1) {
        this.field_790.lock();

        try {
            Body var2 = this.method_998(var1.method_867());
            if(var2 != null) {
                class_188.method_1003(var2, var1, this);
            }
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: d (com.a.c.c) com.a.c.c
    public class_159 method_47(class_159 var1) {
        this.field_790.lock();

        class_159 var5;
        try {
            Long var2 = this.method_996(var1.method_867());
            Body var3;
            if(var2 == null) {
                return null;
            }

            var3 = (Body)this.field_791.remove(var2);
            class_159 var4;
            if(var3 == null) {
                return null;
            }

            var4 = class_188.method_1002(var3, this);
            this.world.removeBody(var3);
            this.field_792.remove(var1.method_867());
            this.field_793.remove(var2);
            var5 = var4;
        } finally {
            this.field_790.unlock();
        }

        return var5;
    }

    // $FF: renamed from: a () void
    public void method_48() {
        this.field_790.lock();

        try {
            this.world.proceed();
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: a (com.a.c.b) void
    public void method_49(final class_8 var1) {
        this.field_790.lock();

        try {
            String var2;
            do {
                var2 = RandomUtils.randomHexString();
            } while(this.world.hasCollisionListener(var2));

            if(var1 instanceof class_9) {
                final class_9 var3 = (class_9)var1;
                this.world.registerCollisionListener(new CollisionListenerAdapter() {
                    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
                    public boolean beforeStartingCollision(Body bodyA, Body bodyB) {
                        return var3.method_42(class_186.this.method_999(bodyA.getId()), class_186.this.method_999(bodyB.getId()));
                    }

                    // $FF: renamed from: a (com.a.a.b.b.f) boolean
                    public boolean beforeResolvingCollision(CollisionInfo collisionInfo) {
                        return var3.method_43(new class_162(class_186.this.method_999(collisionInfo.getBodyA().getId()), class_186.this.method_999(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }

                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void afterResolvingCollision(CollisionInfo collisionInfo) {
                        var3.method_41(new class_162(class_186.this.method_999(collisionInfo.getBodyA().getId()), class_186.this.method_999(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }
                }, var2);
            } else {
                this.world.registerCollisionListener(new CollisionListenerAdapter() {
                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void afterResolvingCollision(CollisionInfo collisionInfo) {
                        var1.method_41(new class_162(class_186.this.method_999(collisionInfo.getBodyA().getId()), class_186.this.method_999(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }
                }, var2);
            }
        } finally {
            this.field_790.unlock();
        }

    }

    // $FF: renamed from: b () int
    public int method_50() {
        return this.world.getStepCountPerTimeUnit();
    }

    // $FF: renamed from: c () com.a.a.b.g
    World method_995() {
        return this.world;
    }

    // $FF: renamed from: a (long) java.lang.Long
    Long method_996(long var1) {
        return (Long)this.field_792.get(Long.valueOf(var1));
    }

    // $FF: renamed from: b (long) java.lang.Long
    Long method_997(long var1) {
        return (Long)this.field_793.get(Long.valueOf(var1));
    }

    // $FF: renamed from: c (long) com.a.a.b.a
    Body method_998(long var1) {
        Long var3 = this.method_996(var1);
        return var3 == null?null:(Body)this.field_791.get(var3);
    }

    // $FF: renamed from: d (long) com.a.c.c
    class_159 method_999(long var1) {
        Body var3 = (Body)this.field_791.get(Long.valueOf(var1));
        return var3 == null?null:class_188.method_1002(var3, this);
    }

    // $FF: renamed from: e (long) com.a.c.c
    class_159 method_1000(long var1) {
        Long var3 = this.method_996(var1);
        return var3 == null?null:this.method_999(var3.longValue());
    }
}
