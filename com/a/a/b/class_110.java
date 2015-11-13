package com.a.a.b;

import com.a.a.b.a.class_15;
import com.a.a.b.a.class_203;
import com.a.a.b.b.class_4;
import com.a.a.b.b.class_60;
import com.a.a.b.b.class_61;
import com.a.a.b.b.class_62;
import com.a.a.b.b.class_63;
import com.a.a.b.b.class_64;
import com.a.a.b.b.class_65;
import com.a.a.b.b.class_66;
import com.a.a.b.b.class_67;
import com.a.a.b.b.class_68;
import com.a.a.b.b.class_69;
import com.a.a.b.b.class_71;
import com.a.a.b.d.class_7;
import com.a.a.b.e.class_13;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.LongPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

// $FF: renamed from: com.a.a.b.g
public class class_110 {
    // $FF: renamed from: a org.apache.log4j.Logger
    private static final Logger field_416 = Logger.getLogger(class_110.class);
    // $FF: renamed from: b com.a.a.b.b.f
    private static final class_71 field_417 = new class_71((class_106)null, (class_106)null, (Point2D)null, (Vector2D)null, 0.0D, 0.0D);
    // $FF: renamed from: c int
    private final int field_418;
    // $FF: renamed from: d int
    private final int field_419;
    // $FF: renamed from: e double
    private final double field_420;
    // $FF: renamed from: f double
    private final double field_421;
    // $FF: renamed from: g double
    private final double field_422;
    // $FF: renamed from: h com.a.a.b.a.a
    private final class_15 field_423;
    // $FF: renamed from: i com.a.a.b.e.c
    private final class_13 field_424;
    // $FF: renamed from: j java.util.Map
    private final Map field_425;
    // $FF: renamed from: k java.util.SortedSet
    private final SortedSet field_426;
    // $FF: renamed from: l java.util.Map
    private final Map field_427;
    // $FF: renamed from: m java.util.SortedSet
    private final SortedSet field_428;

    public class_110() {
        this(10);
    }

    public class_110(int var1) {
        this(var1, 60);
    }

    public class_110(int var1, int var2) {
        this(var1, var2, 1.0E-7D);
    }

    public class_110(int var1, int var2, double var3) {
        this(var1, var2, var3, new class_203());
    }

    public class_110(int var1, int var2, double var3, class_15 var5) {
        this(var1, var2, var3, var5, (class_13)null);
    }

    public class_110(int var1, int var2, double var3, class_15 var5, class_13 var6) {
        this.field_425 = new HashMap();
        this.field_426 = new TreeSet(class_110.class_208.field_113);
        this.field_427 = new HashMap();
        this.field_428 = new TreeSet(class_110.class_207.field_116);
        if(var1 < 1) {
            throw new IllegalArgumentException("Argument \'iterationCountPerStep\' is zero or negative.");
        } else if(var2 < 1) {
            throw new IllegalArgumentException("Argument \'stepCountPerTimeUnit\' is zero or negative.");
        } else if(!Double.isNaN(var3) && !Double.isInfinite(var3) && var3 >= 1.0E-100D && var3 <= 1.0D) {
            if(var5 == null) {
                throw new IllegalArgumentException("Argument \'bodyList\' is null.");
            } else {
                this.field_419 = var2;
                this.field_418 = var1;
                this.field_420 = 1.0D / (double)(var2 * var1);
                this.field_421 = var3;
                this.field_422 = var3 * var3;
                this.field_423 = var5;
                this.field_424 = var6;
                this.method_741(new class_60(var3));
                this.method_741(new class_61(var3));
                this.method_741(new class_62(var3));
                this.method_741(new class_63(var3));
                this.method_741(new class_64(var3));
                this.method_741(new class_65(var3));
                this.method_741(new class_66(var3));
                this.method_741(new class_67(var3));
                this.method_741(new class_68(var3));
                this.method_741(new class_69(var3));
            }
        } else {
            throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
        }
    }

    // $FF: renamed from: a () int
    public int method_724() {
        return this.field_419;
    }

    // $FF: renamed from: b () double
    public double method_725() {
        return this.field_421;
    }

    // $FF: renamed from: a (com.a.a.b.a) void
    public void method_726(class_106 var1) {
        if(var1.method_668() != null && var1.method_670() != 0.0D) {
            this.field_423.method_66(var1);
        } else {
            throw new IllegalArgumentException("Specify form and mass of \'body\' before adding to the world.");
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void method_727(class_106 var1) {
        this.field_423.method_67(var1);
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean method_728(class_106 var1) {
        return this.field_423.method_68(var1);
    }

    // $FF: renamed from: c () java.util.List
    public List method_729() {
        return this.field_423.method_69();
    }

    // $FF: renamed from: d () void
    public void method_730() {
        ArrayList var1 = new ArrayList(this.method_729());
        Iterator var2 = var1.iterator();

        class_106 var3;
        while(var2.hasNext()) {
            var3 = (class_106)var2.next();
            if(this.method_728(var3)) {
                var3.method_718();
                var3.method_691();
            }
        }

        label71:
        for(int var8 = 1; var8 <= this.field_418; ++var8) {
            Iterator var9 = var1.iterator();

            while(var9.hasNext()) {
                class_106 var4 = (class_106)var9.next();
                if(this.method_728(var4)) {
                    var4.method_692();
                    this.method_735(var4);
                    var4.method_718();
                }
            }

            HashMap var10 = new HashMap();
            Iterator var11 = var1.iterator();

            while(true) {
                class_106 var5;
                do {
                    do {
                        if(!var11.hasNext()) {
                            continue label71;
                        }

                        var5 = (class_106)var11.next();
                    } while(var5.method_672());
                } while(!this.method_728(var5));

                Iterator var6 = this.field_423.method_70(var5).iterator();

                while(var6.hasNext()) {
                    class_106 var7 = (class_106)var6.next();
                    if(this.method_728(var5) && this.method_728(var7)) {
                        this.method_731(var5, var7, var10);
                    }
                }
            }
        }

        var2 = var1.iterator();

        while(var2.hasNext()) {
            var3 = (class_106)var2.next();
            if(this.method_728(var3)) {
                var3.method_706(0.0D, 0.0D);
                var3.method_714(0.0D);
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, java.util.Map) void
    private void method_731(class_106 var1, class_106 var2, Map var3) {
        class_106 var4;
        class_106 var5;
        if(var1.method_665() > var2.method_665()) {
            var4 = var2;
            var5 = var1;
        } else {
            var4 = var1;
            var5 = var2;
        }

        LongPair var6 = new LongPair(Long.valueOf(var4.method_665()), Long.valueOf(var5.method_665()));
        class_71 var7 = (class_71)var3.get(var6);
        if(var7 == null) {
            Iterator var8 = this.field_428.iterator();

            while(true) {
                if(var8.hasNext()) {
                    class_110.class_207 var10 = (class_110.class_207)var8.next();
                    if(!var10.field_118.method_38(var4, var5)) {
                        var3.put(var6, field_417);
                        return;
                    }

                    if(this.method_728(var4) && this.method_728(var5)) {
                        continue;
                    }

                    return;
                }

                var8 = this.field_426.iterator();

                while(var8.hasNext()) {
                    class_110.class_208 var9 = (class_110.class_208)var8.next();
                    if(var9.field_115.method_25(var4, var5)) {
                        var7 = var9.field_115.method_26(var4, var5);
                        break;
                    }
                }

                if(var7 == null) {
                    var3.put(var6, field_417);
                } else {
                    var3.put(var6, var7);
                    this.method_732(var7);
                }

                return;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.b.f) void
    private void method_732(class_71 var1) {
        class_106 var2 = var1.method_386();
        class_106 var3 = var1.method_387();
        if(var2.method_672() && var3.method_672()) {
            throw new IllegalArgumentException("Both " + var2 + " and " + var3 + " are static.");
        } else {
            Iterator var4 = this.field_428.iterator();

            while(true) {
                if(var4.hasNext()) {
                    class_110.class_207 var17 = (class_110.class_207)var4.next();
                    if(!var17.field_118.method_39(var1)) {
                        return;
                    }

                    if(this.method_728(var2) && this.method_728(var3)) {
                        continue;
                    }

                    return;
                }

                method_745(var1);
                Vector3D var16 = method_747(var1.method_389());
                Vector3D var5 = method_748(var2.method_717(), var1.method_388());
                Vector3D var6 = method_748(var3.method_717(), var1.method_388());
                Vector3D var7 = method_746(var2.method_709()).crossProduct(var5);
                Vector3D var8 = method_746(var3.method_709()).crossProduct(var6);
                Vector3D var9 = method_747(var2.method_699()).add(var7);
                Vector3D var10 = method_747(var3.method_699()).add(var8);
                Vector3D var11 = var9.subtract(var10);
                double var12 = -var11.dotProduct(var16);
                if(var12 > -this.field_421) {
                    this.method_733(var2, var3, var16, var5, var6, var11);
                    this.method_734(var2, var3, var16, var5, var6, var11);
                }

                if(var1.method_390() >= this.field_421) {
                    this.method_738(var2, var3, var1);
                }

                var2.method_718();
                var3.method_718();
                Iterator var14 = this.field_428.iterator();

                while(var14.hasNext()) {
                    class_110.class_207 var15 = (class_110.class_207)var14.next();
                    var15.field_118.method_40(var1);
                }

                return;
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D) void
    private void method_733(class_106 var1, class_106 var2, Vector3D var3, Vector3D var4, Vector3D var5, Vector3D var6) {
        Double var7;
        if(this.field_424 == null || (var7 = this.field_424.method_55(var1, var2)) == null) {
            var7 = Double.valueOf(var1.method_686() * var2.method_686());
        }

        Vector3D var8 = var4.crossProduct(var3).scalarMultiply(var1.method_675()).crossProduct(var4);
        Vector3D var9 = var5.crossProduct(var3).scalarMultiply(var2.method_675()).crossProduct(var5);
        double var10 = var1.method_673() + var2.method_673() + var3.dotProduct(var8.add(var9));
        double var12 = -1.0D * (1.0D + var7.doubleValue()) * var6.dotProduct(var3) / var10;
        if(Math.abs(var12) >= this.field_421) {
            Vector3D var14;
            Vector3D var15;
            Vector3D var16;
            Vector3D var17;
            if(!var1.method_672()) {
                var14 = var3.scalarMultiply(var12 * var1.method_673());
                var15 = method_747(var1.method_699()).add(var14);
                var1.method_701(var15.getX(), var15.getY());
                var16 = var4.crossProduct(var3.scalarMultiply(var12)).scalarMultiply(var1.method_675());
                var17 = method_746(var1.method_709()).add(var16);
                var1.method_710(var17.getZ());
            }

            if(!var2.method_672()) {
                var14 = var3.scalarMultiply(var12 * var2.method_673());
                var15 = method_747(var2.method_699()).subtract(var14);
                var2.method_701(var15.getX(), var15.getY());
                var16 = var5.crossProduct(var3.scalarMultiply(var12)).scalarMultiply(var2.method_675());
                var17 = method_746(var2.method_709()).subtract(var16);
                var2.method_710(var17.getZ());
            }

        }
    }

    // $FF: renamed from: b (com.a.a.b.a, com.a.a.b.a, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D, org.apache.commons.math3.geometry.euclidean.threed.Vector3D) void
    private void method_734(class_106 var1, class_106 var2, Vector3D var3, Vector3D var4, Vector3D var5, Vector3D var6) {
        Vector3D var7 = var6.subtract(var3.scalarMultiply(var6.dotProduct(var3)));
        if(var7.getNormSq() >= this.field_422) {
            var7 = var7.normalize();
            double var8 = Math.sqrt(var1.method_688() * var2.method_688()) * Math.SQRT_2 * Math.abs(var6.dotProduct(var3)) / var6.getNorm();
            if(var8 >= this.field_421) {
                Vector3D var10 = var4.crossProduct(var7).scalarMultiply(var1.method_675()).crossProduct(var4);
                Vector3D var11 = var5.crossProduct(var7).scalarMultiply(var2.method_675()).crossProduct(var5);
                double var12 = var1.method_673() + var2.method_673() + var7.dotProduct(var10.add(var11));
                double var14 = -1.0D * var8 * var6.dotProduct(var7) / var12;
                if(Math.abs(var14) >= this.field_421) {
                    Vector3D var16;
                    Vector3D var17;
                    Vector3D var18;
                    Vector3D var19;
                    if(!var1.method_672()) {
                        var16 = var7.scalarMultiply(var14 * var1.method_673());
                        var17 = method_747(var1.method_699()).add(var16);
                        var1.method_701(var17.getX(), var17.getY());
                        var18 = var4.crossProduct(var7.scalarMultiply(var14)).scalarMultiply(var1.method_675());
                        var19 = method_746(var1.method_709()).add(var18);
                        var1.method_710(var19.getZ());
                    }

                    if(!var2.method_672()) {
                        var16 = var7.scalarMultiply(var14 * var2.method_673());
                        var17 = method_747(var2.method_699()).subtract(var16);
                        var2.method_701(var17.getX(), var17.getY());
                        var18 = var5.crossProduct(var7.scalarMultiply(var14)).scalarMultiply(var2.method_675());
                        var19 = method_746(var2.method_709()).subtract(var18);
                        var2.method_710(var19.getZ());
                    }

                }
            }
        }
    }

    // $FF: renamed from: d (com.a.a.b.a) void
    private void method_735(class_106 var1) {
        this.method_736(var1);
        this.method_737(var1);
    }

    // $FF: renamed from: e (com.a.a.b.a) void
    private void method_736(class_106 var1) {
        if(var1.method_699().getSquaredLength() > 0.0D) {
            var1.method_693().add(var1.method_699().copy().multiply(this.field_420));
        }

        if(var1.method_704().getSquaredLength() > 0.0D) {
            var1.method_699().add(var1.method_704().copy().multiply(var1.method_673()).multiply(this.field_420));
        }

        if(var1.method_676() >= 1.0D) {
            var1.method_700(var1.method_702().copy());
        } else if(var1.method_676() > 0.0D) {
            var1.method_719(this.field_420);
            if(var1.method_699().nearlyEquals(var1.method_702(), this.field_421)) {
                var1.method_700(var1.method_702().copy());
            }
        }

        var1.method_699().subtract(var1.method_702());
        var1.method_683(this.field_420);
        var1.method_699().add(var1.method_702());
    }

    // $FF: renamed from: f (com.a.a.b.a) void
    private void method_737(class_106 var1) {
        var1.method_708(var1.method_707() + var1.method_709() * this.field_420);
        var1.method_710(var1.method_709() + var1.method_713() * var1.method_675() * this.field_420);
        if(var1.method_678() >= 1.0D) {
            var1.method_710(var1.method_711());
        } else if(var1.method_678() > 0.0D) {
            var1.method_720(this.field_420);
            if(NumberUtil.nearlyEquals(Double.valueOf(var1.method_709()), Double.valueOf(var1.method_711()), this.field_421)) {
                var1.method_710(var1.method_711());
            }
        }

        double var2 = var1.method_709() - var1.method_711();
        if(Math.abs(var2) > 0.0D) {
            double var4 = var1.method_684() * this.field_420;
            if(var4 >= Math.abs(var2)) {
                var1.method_710(var1.method_711());
            } else if(var4 > 0.0D) {
                if(var2 > 0.0D) {
                    var1.method_710(var2 - var4 + var1.method_711());
                } else {
                    var1.method_710(var2 + var4 + var1.method_711());
                }
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, com.a.a.b.b.f) void
    private void method_738(class_106 var1, class_106 var2, class_71 var3) {
        if(var1.method_672()) {
            var2.method_693().subtract(var3.method_389().multiply(var3.method_390() + this.field_421));
        } else if(var2.method_672()) {
            var1.method_693().add(var3.method_389().multiply(var3.method_390() + this.field_421));
        } else {
            Vector2D var4 = var3.method_389().multiply(0.5D * (var3.method_390() + this.field_421));
            var1.method_693().add(var4);
            var2.method_693().subtract(var4);
        }

    }

    // $FF: renamed from: a (com.a.a.b.b.d, java.lang.String, double) void
    public void method_739(class_4 var1, String var2, double var3) {
        class_27.method_237(var2);
        if(this.field_425.containsKey(var2)) {
            throw new IllegalArgumentException("Collider \'" + var2 + "\' is already registered.");
        } else {
            class_110.class_208 var5 = new class_110.class_208(var2, var3, var1, null);
            this.field_425.put(var2, var5);
            this.field_426.add(var5);
        }
    }

    // $FF: renamed from: a (com.a.a.b.b.d, java.lang.String) void
    public void method_740(class_4 var1, String var2) {
        this.method_739(var1, var2, 0.0D);
    }

    // $FF: renamed from: a (com.a.a.b.b.d) void
    private void method_741(class_4 var1) {
        this.method_740(var1, var1.getClass().getSimpleName());
    }

    // $FF: renamed from: a (com.a.a.b.d.a, java.lang.String, double) void
    public void method_742(class_7 var1, String var2, double var3) {
        class_27.method_237(var2);
        if(this.field_427.containsKey(var2)) {
            throw new IllegalArgumentException("Listener \'" + var2 + "\' is already registered.");
        } else {
            class_110.class_207 var5 = new class_110.class_207(var2, var3, var1, null);
            this.field_427.put(var2, var5);
            this.field_428.add(var5);
        }
    }

    // $FF: renamed from: a (com.a.a.b.d.a, java.lang.String) void
    public void method_743(class_7 var1, String var2) {
        this.method_742(var1, var2, 0.0D);
    }

    // $FF: renamed from: a (java.lang.String) boolean
    public boolean method_744(String var1) {
        class_27.method_237(var1);
        return this.field_427.containsKey(var1);
    }

    // $FF: renamed from: b (com.a.a.b.b.f) void
    private static void method_745(class_71 var0) {
        if(var0.method_390() < var0.method_386().method_668().method_765() * 0.25D && var0.method_390() < var0.method_387().method_668().method_765() * 0.25D) {
            if(field_416.isDebugEnabled()) {
                field_416.debug("Resolving collision " + var0 + '.');
            }
        } else if(field_416.isEnabledFor(Level.WARN)) {
            field_416.warn("Resolving collision (big depth) " + var0 + '.');
        }

    }

    // $FF: renamed from: a (double) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D method_746(double var0) {
        return new Vector3D(0.0D, 0.0D, var0);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D method_747(Vector2D var0) {
        return new Vector3D(var0.getX(), var0.getY(), 0.0D);
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) org.apache.commons.math3.geometry.euclidean.threed.Vector3D
    private static Vector3D method_748(Point2D var0, Point2D var1) {
        return method_747(new Vector2D(var0, var1));
    }

    private static final class class_207 extends class_27 {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator field_116 = new Comparator() {
            // $FF: renamed from: a (com.a.a.b.g$b, com.a.a.b.g$b) int
            public int method_749(class_110.class_207 var1, class_110.class_207 var2) {
                int var3 = Double.compare(var2.field_117, var1.field_117);
                return var3 != 0?var3:var1.field_109.compareTo(var2.field_109);
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_749((class_110.class_207)var1, (class_110.class_207)var2);
            }
        };
        // $FF: renamed from: b double
        public final double field_117;
        // $FF: renamed from: c com.a.a.b.d.a
        public final class_7 field_118;

        private class_207(String var1, double var2, class_7 var4) {
            super(var1);
            this.field_117 = var2;
            this.field_118 = var4;
        }

        // $FF: synthetic method
        class_207(String var1, double var2, class_7 var4, Object var5) {
            this(var1, var2, var4);
        }
    }

    private static final class class_208 extends class_27 {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator field_113 = new Comparator() {
            // $FF: renamed from: a (com.a.a.b.g$a, com.a.a.b.g$a) int
            public int method_750(class_110.class_208 var1, class_110.class_208 var2) {
                int var3 = Double.compare(var2.field_114, var1.field_114);
                return var3 != 0?var3:var1.field_109.compareTo(var2.field_109);
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_750((class_110.class_208)var1, (class_110.class_208)var2);
            }
        };
        // $FF: renamed from: b double
        public final double field_114;
        // $FF: renamed from: c com.a.a.b.b.d
        public final class_4 field_115;

        private class_208(String var1, double var2, class_4 var4) {
            super(var1);
            this.field_114 = var2;
            this.field_115 = var4;
        }

        // $FF: synthetic method
        class_208(String var1, double var2, class_4 var4, Object var5) {
            this(var1, var2, var4);
        }
    }
}
