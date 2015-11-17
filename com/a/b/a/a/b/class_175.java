package com.a.b.a.a.b;

import com.a.b.class_3;
import com.a.b.class_34;
import com.a.b.class_42;
import com.a.b.class_58;
import com.a.b.a.a.b.a.class_124;
import com.a.c.PhysicsManager;
import com.a.c.PhysicalBody;
import com.a.c.PhysicalCollisionInfo;
import com.a.c.PhysicalCollisionListener;
import com.a.c.PhysicalPreCollisionListener;
import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.a.b.a.a.b.k
public class class_175 implements class_3 {
    // $FF: renamed from: a com.a.c.e
    @Inject
    private PhysicsManager field_715;
    // $FF: renamed from: b java.util.Map
    private final Map field_716 = new HashMap();
    // $FF: renamed from: c java.util.Map
    private final Map field_717 = new HashMap();
    // $FF: renamed from: d java.util.List
    private final List field_718 = new ArrayList();
    // $FF: renamed from: e boolean
    private final boolean field_719;

    public class_175(boolean var1) {
        this.field_719 = var1;
    }

    // $FF: renamed from: a (com.a.b.e) com.a.b.e
    public class_42 method_17(class_42 var1) {
        PhysicalBody var2 = this.field_715.addPhysicalBody(var1.method_279());
        this.field_715.syncPhysicalBody(var2);
        this.field_716.put(var1.method_278(), var1);
        this.field_717.put(var2.getId(), var1);
        var1.method_280(var2);
        return var1;
    }

    // $FF: renamed from: b (com.a.b.e) void
    public void method_18(class_42 var1) {
        this.field_715.removePhysicalBody(var1.method_279());
        this.field_716.remove(var1.method_278());
        this.field_717.remove(var1.method_279().getId());
    }

    // $FF: renamed from: a () java.util.List
    public List method_19() {
        return Collections.unmodifiableList(new ArrayList(this.field_716.values()));
    }

    // $FF: renamed from: a (com.a.b.a.a.b.a.a) com.a.b.a.a.b.a.a
    public class_124 method_20(class_124 var1) {
        this.field_718.add(var1);
        return var1;
    }

    // $FF: renamed from: b () java.util.List
    public List method_21() {
        return Collections.unmodifiableList(this.field_718);
    }

    // $FF: renamed from: a (int) void
    public void method_22(int var1) {
        Iterator var2 = this.field_718.iterator();

        while(var2.hasNext()) {
            class_124 var3 = (class_124)var2.next();
            if(var1 > var3.method_805()) {
                var3.method_807();
                if(var3.method_808()) {
                    var2.remove();
                }
            }
        }

        class_42 var4;
        Iterator var5;
        if(this.field_719) {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (class_42)var5.next();
                this.field_715.syncPhysicalBody(var4.method_279());
            }
        } else {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (class_42)var5.next();
                if(!var4.method_279().isStationary()) {
                    this.field_715.syncPhysicalBody(var4.method_279());
                }
            }
        }

        this.field_715.proceed();
        if(this.field_719) {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (class_42)var5.next();
                var4.method_280(this.field_715.addPhysicalBody(var4.method_279()));
            }
        } else {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (class_42)var5.next();
                if(!var4.method_279().isStationary()) {
                    var4.method_280(this.field_715.addPhysicalBody(var4.method_279()));
                }
            }
        }

    }

    // $FF: renamed from: a (java.lang.Class, java.lang.Class, com.a.b.g) void
    public void method_23(final Class var1, final Class var2, final class_34 var3) {
        final Method var4;
        try {
            var4 = var3.getClass().getMethod("beforeCollision", class_3.class, class_42.class, class_42.class);
        } catch (NoSuchMethodException var10) {
            throw new IllegalArgumentException(String.format("Listener %s doesn\'t implement beforeCollision(...) method.", var3.getClass().getSimpleName()), var10);
        }

        final Method var5;
        try {
            var5 = var3.getClass().getMethod("beforeResolvingCollision", class_58.class);
        } catch (NoSuchMethodException var9) {
            throw new IllegalArgumentException(String.format("Listener %s doesn\'t implement beforeResolvingCollision(...) method.", var3.getClass().getSimpleName()), var9);
        }

        final Method var6;
        try {
            var6 = var3.getClass().getMethod("afterCollision", class_58.class);
        } catch (NoSuchMethodException var8) {
            throw new IllegalArgumentException(String.format("Listener %s doesn\'t implement afterCollision(...) method.", var3.getClass().getSimpleName()), var8);
        }

        final PhysicalCollisionListener var7 = new PhysicalCollisionListener() {
            // $FF: renamed from: a (com.a.c.a) void
            public void afterResolvingCollision(PhysicalCollisionInfo physicalCollisionInfo) {
                if(var6.getDeclaringClass() != class_34.class) {
                    class_42 var2x = physicalCollisionInfo.getBodyA() == null?null:(class_42)class_175.this.field_717.get(physicalCollisionInfo.getBodyA().getId());
                    class_42 var3x = physicalCollisionInfo.getBodyB() == null?null:(class_42)class_175.this.field_717.get(physicalCollisionInfo.getBodyB().getId());
                    if(var1.isInstance(var2x) && var2.isInstance(var3x)) {
                        class_175.this.method_930(var2x, var3x);
                        var3.afterCollision(new class_58(class_175.this, var2x, var3x, physicalCollisionInfo.getPoint().copy(), physicalCollisionInfo.getNormalB().copy()));
                        class_175.this.method_931(var2x, var3x);
                    } else if(var1.isInstance(var3x) && var2.isInstance(var2x)) {
                        class_175.this.method_930(var2x, var3x);
                        var3.afterCollision(new class_58(class_175.this, var3x, var2x, physicalCollisionInfo.getPoint().copy(), physicalCollisionInfo.getNormalB().copyNegate()));
                        class_175.this.method_931(var2x, var3x);
                    }

                }
            }
        };
        if(var4.getDeclaringClass() == class_34.class && var5.getDeclaringClass() == class_34.class) {
            this.field_715.registerCollisionListener(var7);
        } else {
            this.field_715.registerCollisionListener(new PhysicalPreCollisionListener() {
                // $FF: renamed from: a (com.a.c.c, com.a.c.c) boolean
                public boolean beforeStartingCollision(PhysicalBody bodyA, PhysicalBody bodyB) {
                    if (var4.getDeclaringClass() == class_34.class) {
                        return true;
                    } else {
                        class_42 var3x = bodyA == null ? null : (class_42) class_175.this.field_717.get(bodyA.getId());
                        class_42 var4x = bodyB == null ? null : (class_42) class_175.this.field_717.get(bodyB.getId());
                        boolean var5x;
                        if (var1.isInstance(var3x) && var2.isInstance(var4x)) {
                            class_175.this.method_930(var3x, var4x);
                            var5x = var3.beforeCollision(class_175.this, var3x, var4x);
                            class_175.this.method_931(var3x, var4x);
                            return var5x;
                        } else if (var1.isInstance(var4x) && var2.isInstance(var3x)) {
                            class_175.this.method_930(var3x, var4x);
                            var5x = var3.beforeCollision(class_175.this, var4x, var3x);
                            class_175.this.method_931(var3x, var4x);
                            return var5x;
                        } else {
                            return true;
                        }
                    }
                }

                // $FF: renamed from: b (com.a.c.a) boolean
                public boolean beforeResolvingCollision(PhysicalCollisionInfo collisionInfo) {
                    if (var5.getDeclaringClass() == class_34.class) {
                        return true;
                    } else {
                        class_42 var2x = collisionInfo.getBodyA() == null ? null : (class_42) class_175.this.field_717.get(collisionInfo.getBodyA().getId());
                        class_42 var3x = collisionInfo.getBodyB() == null ? null : (class_42) class_175.this.field_717.get(collisionInfo.getBodyB().getId());
                        boolean var4x;
                        if (var1.isInstance(var2x) && var2.isInstance(var3x)) {
                            class_175.this.method_930(var2x, var3x);
                            var4x = var3.beforeResolvingCollision(new class_58(class_175.this, var2x, var3x, collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copy()));
                            class_175.this.method_931(var2x, var3x);
                            return var4x;
                        } else if (var1.isInstance(var3x) && var2.isInstance(var2x)) {
                            class_175.this.method_930(var2x, var3x);
                            var4x = var3.beforeResolvingCollision(new class_58(class_175.this, var3x, var2x, collisionInfo.getPoint().copy(), collisionInfo.getNormalB().copyNegate()));
                            class_175.this.method_931(var2x, var3x);
                            return var4x;
                        } else {
                            return true;
                        }
                    }
                }

                // $FF: renamed from: a (com.a.c.a) void
                public void afterResolvingCollision(PhysicalCollisionInfo physicalCollisionInfo) {
                    var7.afterResolvingCollision(physicalCollisionInfo);
                }
            });
        }

    }

    // $FF: renamed from: c () int
    public int method_24() {
        return this.field_715.getStepCountPerTimeUnit();
    }

    // $FF: renamed from: a (com.a.b.e, com.a.b.e) void
    private void method_930(class_42 var1, class_42 var2) {
        if(this.field_719) {
            var1.method_280(this.field_715.addPhysicalBody(var1.method_279()));
            var2.method_280(this.field_715.addPhysicalBody(var2.method_279()));
        } else {
            if(!var1.method_279().isStationary()) {
                var1.method_280(this.field_715.addPhysicalBody(var1.method_279()));
            }

            if(!var2.method_279().isStationary()) {
                var2.method_280(this.field_715.addPhysicalBody(var2.method_279()));
            }
        }

    }

    // $FF: renamed from: b (com.a.b.e, com.a.b.e) void
    private void method_931(class_42 var1, class_42 var2) {
        if(this.field_719) {
            this.field_715.safeSyncPhysicalBody(var1.method_279());
            this.field_715.safeSyncPhysicalBody(var2.method_279());
        } else {
            if(!var1.method_279().isStationary()) {
                this.field_715.safeSyncPhysicalBody(var1.method_279());
            }

            if(!var2.method_279().isStationary()) {
                this.field_715.safeSyncPhysicalBody(var2.method_279());
            }
        }

    }
}
