package com.a.c.b.a;

import com.a.a.a.a.RandomUtils;
import com.a.a.b.Body;
import com.a.a.b.World;
import com.a.a.b.a.BodyList;
import com.a.a.b.b.CollisionInfo;
import com.a.a.b.d.CollisionListenerAdapter;
import com.a.c.PhysicsManager;
import com.a.c.PhysicalBody;
import com.a.c.PhysicalCollisionInfo;
import com.a.c.PhysicalCollisionListener;
import com.a.c.PhysicalPreCollisionListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.a.c.b.a.b
public class PhysicsManagerImpl implements PhysicsManager {
    // $FF: renamed from: a java.util.concurrent.locks.Lock
    private final Lock guard = new ReentrantLock();
    // $FF: renamed from: b java.util.Map
    private final Map<Long, Body> bodyById = new HashMap<>();
    // $FF: renamed from: c java.util.Map
    private final Map<Long, Long> bodyIdByPhysicalId = new HashMap<>();
    // $FF: renamed from: d java.util.Map
    private final Map<Long, Long> physicalIdByBodyId = new HashMap<>();
    // $FF: renamed from: e com.a.a.b.g
    private final World world;

    public PhysicsManagerImpl() {
        this.world = new World();
    }

    public PhysicsManagerImpl(int iterationCountPerStep, int stepCountPerTimeUnit, double epsilon, BodyList bodyList) {
        this.world = new World(iterationCountPerStep, stepCountPerTimeUnit, epsilon, bodyList);
    }

    // $FF: renamed from: a (com.a.c.c) com.a.c.c
    public PhysicalBody addPhysicalBody(PhysicalBody physicalBody) {
        this.guard.lock();

        try {
            Body body = this.getBodyByPhysicalId(physicalBody.getId());
            if(body == null) {
                body = PhysicsUtils.createBodyForPhysicalBody(physicalBody);
                this.world.addBody(body);
                this.bodyById.put(body.getId(), body);
                this.bodyIdByPhysicalId.put(physicalBody.getId(), body.getId());
                this.physicalIdByBodyId.put(body.getId(), physicalBody.getId());
                PhysicsUtils.syncBodyWithPhysicalBody(body, physicalBody, this);
            }

            return this.getPhysicalById(physicalBody.getId());
        } finally {
            this.guard.unlock();
        }
    }

    // $FF: renamed from: b (com.a.c.c) void
    public void syncPhysicalBody(PhysicalBody physicalBody) {
        this.guard.lock();

        try {
            Body body = this.getBodyByPhysicalId(physicalBody.getId());
            if(body == null) {
                throw new IllegalArgumentException("No body with ID " + physicalBody.getId() + '.');
            }

            PhysicsUtils.syncBodyWithPhysicalBody(body, physicalBody, this);
        } finally {
            this.guard.unlock();
        }

    }

    // $FF: renamed from: c (com.a.c.c) void
    public void safeSyncPhysicalBody(PhysicalBody physicalBody) {
        this.guard.lock();

        try {
            Body body = this.getBodyByPhysicalId(physicalBody.getId());
            if(body != null) {
                PhysicsUtils.syncBodyWithPhysicalBody(body, physicalBody, this);
            }
        } finally {
            this.guard.unlock();
        }

    }

    // $FF: renamed from: d (com.a.c.c) com.a.c.c
    public PhysicalBody removePhysicalBody(PhysicalBody physicalBody) {
        this.guard.lock();

        try {
            Long id = this.getBodyIdByPhysicalId(physicalBody.getId());
            if(id == null) {
                return null;
            }

            Body body = this.bodyById.remove(id);
            if(body == null) {
                return null;
            }

            PhysicalBody removedBody = PhysicsUtils.createPhysicalBodyForBody(body, this);
            this.world.removeBody(body);
            this.bodyIdByPhysicalId.remove(physicalBody.getId());
            this.physicalIdByBodyId.remove(id);
            return removedBody;
        } finally {
            this.guard.unlock();
        }
    }

    // $FF: renamed from: a () void
    public void proceed() {
        this.guard.lock();

        try {
            this.world.proceed();
        } finally {
            this.guard.unlock();
        }

    }

    // $FF: renamed from: a (com.a.c.b) void
    public void registerCollisionListener(final PhysicalCollisionListener listener) {
        this.guard.lock();

        try {
            String collisionListenerName;
            do {
                collisionListenerName = RandomUtils.randomHexString();
            } while(this.world.hasCollisionListener(collisionListenerName));

            if(listener instanceof PhysicalPreCollisionListener) {
                final PhysicalPreCollisionListener preCollisionListener = (PhysicalPreCollisionListener)listener;
                this.world.registerCollisionListener(new CollisionListenerAdapter() {
                    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a) boolean
                    public boolean beforeStartingCollision(Body bodyA, Body bodyB) {
                        return preCollisionListener.beforeStartingCollision(PhysicsManagerImpl.this.getPhysicalByBodyId(bodyA.getId()), PhysicsManagerImpl.this.getPhysicalByBodyId(bodyB.getId()));
                    }

                    // $FF: renamed from: a (com.a.a.b.b.f) boolean
                    public boolean beforeResolvingCollision(CollisionInfo collisionInfo) {
                        return preCollisionListener.beforeResolvingCollision(new PhysicalCollisionInfo(PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyA().getId()), PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }

                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void afterResolvingCollision(CollisionInfo collisionInfo) {
                        preCollisionListener.afterResolvingCollision(new PhysicalCollisionInfo(PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyA().getId()), PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }
                }, collisionListenerName);
            } else {
                this.world.registerCollisionListener(new CollisionListenerAdapter() {
                    // $FF: renamed from: b (com.a.a.b.b.f) void
                    public void afterResolvingCollision(CollisionInfo collisionInfo) {
                        listener.afterResolvingCollision(new PhysicalCollisionInfo(PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyA().getId()), PhysicsManagerImpl.this.getPhysicalByBodyId(collisionInfo.getBodyB().getId()), collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                    }
                }, collisionListenerName);
            }
        } finally {
            this.guard.unlock();
        }

    }

    // $FF: renamed from: b () int
    public int getStepCountPerTimeUnit() {
        return this.world.getStepCountPerTimeUnit();
    }

    // $FF: renamed from: c () com.a.a.b.g
    World getWorld() {
        return this.world;
    }

    // $FF: renamed from: a (long) java.lang.Long
    Long getBodyIdByPhysicalId(long id) {
        return this.bodyIdByPhysicalId.get(id);
    }

    // $FF: renamed from: b (long) java.lang.Long
    Long getPhysicalIdByBodyId(long id) {
        return this.physicalIdByBodyId.get(id);
    }

    // $FF: renamed from: c (long) com.a.a.b.a
    Body getBodyByPhysicalId(long var1) {
        Long var3 = this.getBodyIdByPhysicalId(var1);
        return var3 == null ? null : this.bodyById.get(var3);
    }

    // $FF: renamed from: d (long) com.a.c.c
    PhysicalBody getPhysicalByBodyId(long var1) {
        Body body = this.bodyById.get(var1);
        return body == null ? null : PhysicsUtils.createPhysicalBodyForBody(body, this);
    }

    // $FF: renamed from: e (long) com.a.c.c
    PhysicalBody getPhysicalById(long id) {
        Long var3 = this.getBodyIdByPhysicalId(id);
        return var3 == null ? null : this.getPhysicalByBodyId(var3);
    }
}
