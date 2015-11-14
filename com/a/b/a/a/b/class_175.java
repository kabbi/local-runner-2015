package com.a.b.a.a.b;

import com.a.b.class_3;
import com.a.b.class_34;
import com.a.b.RectangleBody;
import com.a.b.class_58;
import com.a.b.a.a.b.a.class_124;
import com.a.c.class_10;
import com.a.c.Body;
import com.a.c.maybeCollisionInfo;
import com.a.c.class_8;
import com.a.c.class_9;
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
    private class_10 field_715;
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
    public RectangleBody method_17(RectangleBody var1) {
        Body var2 = this.field_715.method_44(var1.getBody());
        this.field_715.method_45(var2);
        this.field_716.put(var1.getId(), var1);
        this.field_717.put(var2.getId(), var1);
        var1.setBody(var2);
        return var1;
    }

    // $FF: renamed from: b (com.a.b.e) void
    public void method_18(RectangleBody var1) {
        this.field_715.method_47(var1.getBody());
        this.field_716.remove(var1.getId());
        this.field_717.remove(var1.getBody().getId());
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

        RectangleBody var4;
        Iterator var5;
        if(this.field_719) {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (RectangleBody)var5.next();
                this.field_715.method_45(var4.getBody());
            }
        } else {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (RectangleBody)var5.next();
                if(!var4.getBody().getStaticBody()) {
                    this.field_715.method_45(var4.getBody());
                }
            }
        }

        this.field_715.method_48();
        if(this.field_719) {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (RectangleBody)var5.next();
                var4.setBody(this.field_715.method_44(var4.getBody()));
            }
        } else {
            var5 = this.field_716.values().iterator();

            while(var5.hasNext()) {
                var4 = (RectangleBody)var5.next();
                if(!var4.getBody().getStaticBody()) {
                    var4.setBody(this.field_715.method_44(var4.getBody()));
                }
            }
        }

    }

    // $FF: renamed from: a (java.lang.Class, java.lang.Class, com.a.b.g) void
    public void colllisionSetListener(final Class var1, final Class var2, final class_34 var3) {
        final Method var4;
        try {
            var4 = var3.getClass().getMethod("beforeCollision", class_3.class, RectangleBody.class, RectangleBody.class);
        } catch (NoSuchMethodException var10) {
            throw new IllegalArgumentException(String.format("Listener %s doesn\'t implement beforeCollision(...) method.", new Object[]{var3.getClass().getSimpleName()}), var10);
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

        final class_8 var7 = new class_8() {
            // $FF: renamed from: a (com.a.c.a) void
            public void method_41(maybeCollisionInfo var1x) {
                if(var6.getDeclaringClass() != class_34.class) {
                    RectangleBody var2x = var1x.method_907() == null?null:(RectangleBody)class_175.this.field_717.get(var1x.method_907().getId());
                    RectangleBody var3x = var1x.method_908() == null?null:(RectangleBody)class_175.this.field_717.get(var1x.method_908().getId());
                    if(var1.isInstance(var2x) && var2.isInstance(var3x)) {
                        class_175.this.method_930(var2x, var3x);
                        var3.afterCollision(new class_58(class_175.this, var2x, var3x, var1x.method_909().copy(), var1x.method_910().copy()));
                        class_175.this.method_931(var2x, var3x);
                    } else if(var1.isInstance(var3x) && var2.isInstance(var2x)) {
                        class_175.this.method_930(var2x, var3x);
                        var3.afterCollision(new class_58(class_175.this, var3x, var2x, var1x.method_909().copy(), var1x.method_910().copyNegate()));
                        class_175.this.method_931(var2x, var3x);
                    }

                }
            }
        };
        if(var4.getDeclaringClass() == class_34.class && var5.getDeclaringClass() == class_34.class) {
            this.field_715.method_49(var7);
        } else {
            this.field_715.method_49(new class_9() {
                // $FF: renamed from: a (com.a.c.c, com.a.c.c) boolean
                public boolean method_42(Body var1x, Body var2x) {
                    if(var4.getDeclaringClass() == class_34.class) {
                        return true;
                    } else {
                        RectangleBody var3x = var1x == null?null:(RectangleBody)class_175.this.field_717.get(var1x.getId());
                        RectangleBody var4x = var2x == null?null:(RectangleBody)class_175.this.field_717.get(var2x.getId());
                        boolean var5x;
                        if(var1.isInstance(var3x) && var2.isInstance(var4x)) {
                            class_175.this.method_930(var3x, var4x);
                            var5x = var3.beforeCollision(class_175.this, var3x, var4x);
                            class_175.this.method_931(var3x, var4x);
                            return var5x;
                        } else if(var1.isInstance(var4x) && var2.isInstance(var3x)) {
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
                public boolean method_43(maybeCollisionInfo var1x) {
                    if(var5.getDeclaringClass() == class_34.class) {
                        return true;
                    } else {
                        RectangleBody var2x = var1x.method_907() == null?null:(RectangleBody)class_175.this.field_717.get(var1x.method_907().getId());
                        RectangleBody var3x = var1x.method_908() == null?null:(RectangleBody)class_175.this.field_717.get(var1x.method_908().getId());
                        boolean var4x;
                        if(var1.isInstance(var2x) && var2.isInstance(var3x)) {
                            class_175.this.method_930(var2x, var3x);
                            var4x = var3.beforeResolvingCollision(new class_58(class_175.this, var2x, var3x, var1x.method_909().copy(), var1x.method_910().copy()));
                            class_175.this.method_931(var2x, var3x);
                            return var4x;
                        } else if(var1.isInstance(var3x) && var2.isInstance(var2x)) {
                            class_175.this.method_930(var2x, var3x);
                            var4x = var3.beforeResolvingCollision(new class_58(class_175.this, var3x, var2x, var1x.method_909().copy(), var1x.method_910().copyNegate()));
                            class_175.this.method_931(var2x, var3x);
                            return var4x;
                        } else {
                            return true;
                        }
                    }
                }

                // $FF: renamed from: a (com.a.c.a) void
                public void method_41(maybeCollisionInfo var1x) {
                    var7.method_41(var1x);
                }
            });
        }

    }

    // $FF: renamed from: c () int
    public int method_24() {
        return this.field_715.method_50();
    }

    // $FF: renamed from: a (com.a.b.e, com.a.b.e) void
    private void method_930(RectangleBody var1, RectangleBody var2) {
        if(this.field_719) {
            var1.setBody(this.field_715.method_44(var1.getBody()));
            var2.setBody(this.field_715.method_44(var2.getBody()));
        } else {
            if(!var1.getBody().getStaticBody()) {
                var1.setBody(this.field_715.method_44(var1.getBody()));
            }

            if(!var2.getBody().getStaticBody()) {
                var2.setBody(this.field_715.method_44(var2.getBody()));
            }
        }

    }

    // $FF: renamed from: b (com.a.b.e, com.a.b.e) void
    private void method_931(RectangleBody var1, RectangleBody var2) {
        if(this.field_719) {
            this.field_715.method_46(var1.getBody());
            this.field_715.method_46(var2.getBody());
        } else {
            if(!var1.getBody().getStaticBody()) {
                this.field_715.method_46(var1.getBody());
            }

            if(!var2.getBody().getStaticBody()) {
                this.field_715.method_46(var2.getBody());
            }
        }

    }
}
