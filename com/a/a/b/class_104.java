package com.a.a.b;

import com.a.a.b.class_27;
import com.a.a.b.d.class_6;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.text.StringUtil;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

// $FF: renamed from: com.a.a.b.d
public class class_104 {
    // $FF: renamed from: a com.a.a.b.d$a
    private class_104.class_215 field_385;
    // $FF: renamed from: b double
    private double field_386;
    // $FF: renamed from: c java.util.Map
    private Map field_387;
    // $FF: renamed from: d java.util.SortedSet
    private SortedSet field_388;

    public class_104() {
        this.field_385 = new class_104.class_215(0.0D, 0.0D);
    }

    public class_104(class_104 var1) {
        this.field_385 = new class_104.class_215(var1.field_385);
        this.field_386 = var1.field_386;
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Point2D
    public Point2D method_645() {
        return this.field_385;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D) void
    public void method_646(Point2D var1) {
        Point2D var2 = this.field_385.copy();
        Point2D var3 = var1.copy();
        Iterator var4;
        class_104.class_214 var5;
        if(this.field_388 != null) {
            var4 = this.field_388.iterator();

            while(var4.hasNext()) {
                var5 = (class_104.class_214)var4.next();
                if(!var5.field_112.method_36(var2.copy(), var3)) {
                    return;
                }
            }
        }

        this.field_385 = new class_104.class_215(var3);
        if(this.field_388 != null) {
            var4 = this.field_388.iterator();

            while(var4.hasNext()) {
                var5 = (class_104.class_214)var4.next();
                var5.field_112.method_37(var2.copy(), var3.copy());
            }
        }

    }

    // $FF: renamed from: h () double
    public double method_647() {
        return this.field_386;
    }

    // $FF: renamed from: d (double) void
    public void method_648(double var1) {
        this.field_386 = var1;
    }

    // $FF: renamed from: i () void
    public void method_649() {
        while(this.field_386 > 3.141592653589793D) {
            this.field_386 -= 6.283185307179586D;
        }

        while(this.field_386 < -3.141592653589793D) {
            this.field_386 += 6.283185307179586D;
        }

    }

    // $FF: renamed from: a (com.a.a.b.d.c, java.lang.String, double) void
    public void method_650(class_6 var1, String var2, double var3) {
        class_27.method_237(var2);
        if(this.field_387 == null) {
            this.field_387 = new HashMap(1);
            this.field_388 = new TreeSet(class_104.class_214.field_110);
        } else if(this.field_387.containsKey(var2)) {
            throw new IllegalArgumentException("Listener \'" + var2 + "\' is already registered.");
        }

        class_104.class_214 var5 = new class_104.class_214(var2, var3, var1, null);
        this.field_387.put(var2, var5);
        this.field_388.add(var5);
    }

    // $FF: renamed from: a (com.a.a.b.d.c, java.lang.String) void
    public void method_651(class_6 var1, String var2) {
        this.method_650(var1, var2, 0.0D);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    private static final class class_214 extends class_27 {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator field_110 = new Comparator() {
            // $FF: renamed from: a (com.a.a.b.d$b, com.a.a.b.d$b) int
            public int method_723(class_104.class_214 var1, class_104.class_214 var2) {
                int var3 = Double.compare(var2.field_111, var1.field_111);
                return var3 != 0?var3:var1.field_109.compareTo(var2.field_109);
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_723((class_104.class_214)var1, (class_104.class_214)var2);
            }
        };
        // $FF: renamed from: b double
        public final double field_111;
        // $FF: renamed from: c com.a.a.b.d.c
        public final class_6 field_112;

        private class_214(String var1, double var2, class_6 var4) {
            super(var1);
            this.field_111 = var2;
            this.field_112 = var4;
        }

        // $FF: synthetic method
        class_214(String var1, double var2, class_6 var4, Object var5) {
            this(var1, var2, var4);
        }
    }

    private final class class_215 extends Point2D {
        private class_215(double var2, double var4) {
            super(var2, var4);
        }

        private class_215(Point2D var2) {
            super(var2);
        }

        public void setX(double var1) {
            this.method_241(var1);
        }

        public void setY(double var1) {
            this.method_242(var1);
        }

        public Point2D add(Vector2D var1) {
            Point2D var2 = super.copy();
            Point2D var3 = super.copy().add(var1);
            return this.method_243(var2, var3);
        }

        public Point2D add(double var1, double var3) {
            Point2D var5 = super.copy();
            Point2D var6 = super.copy().add(var1, var3);
            return this.method_243(var5, var6);
        }

        public Point2D subtract(Vector2D var1) {
            Point2D var2 = super.copy();
            Point2D var3 = super.copy().subtract(var1);
            return this.method_243(var2, var3);
        }

        // $FF: renamed from: a (java.lang.Double) void
        public void method_241(Double var1) {
            Point2D var2 = super.copy();
            Point2D var3 = super.copy();
            var3.setFirst(var1);
            this.method_243(var2, var3);
        }

        // $FF: renamed from: b (java.lang.Double) void
        public void method_242(Double var1) {
            Point2D var2 = super.copy();
            Point2D var3 = super.copy();
            var3.setSecond(var1);
            this.method_243(var2, var3);
        }

        // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) com.codeforces.commons.geometry.Point2D
        private Point2D method_243(Point2D var1, Point2D var2) {
            Iterator var3;
            class_104.class_214 var4;
            if(class_104.this.field_388 != null) {
                var3 = class_104.this.field_388.iterator();

                while(var3.hasNext()) {
                    var4 = (class_104.class_214)var3.next();
                    if(!var4.field_112.method_36(var1.copy(), var2)) {
                        return this;
                    }
                }
            }

            super.setFirst(var2.getFirst());
            super.setSecond(var2.getSecond());
            if(class_104.this.field_388 != null) {
                var3 = class_104.this.field_388.iterator();

                while(var3.hasNext()) {
                    var4 = (class_104.class_214)var3.next();
                    var4.field_112.method_37(var1.copy(), var2.copy());
                }
            }

            return this;
        }

        // $FF: synthetic method
        public void setSecond(Object var1) {
            this.method_242((Double) var1);
        }

        // $FF: synthetic method
        public void setFirst(Object var1) {
            this.method_241((Double) var1);
        }
    }
}
