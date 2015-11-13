package com.a.a.b.a;

import com.a.a.b.class_106;
import com.a.a.b.a.class_201;
import com.a.a.b.d.class_152;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

// $FF: renamed from: com.a.a.b.a.c
public class class_202 extends class_201 {
    // $FF: renamed from: a java.util.Set
    private final Set field_836 = new HashSet();
    // $FF: renamed from: b java.util.Map
    private final Map field_837 = new HashMap();
    // $FF: renamed from: c int[]
    private final int[] field_838 = new int[10000];
    // $FF: renamed from: d int[]
    private final int[] field_839 = new int[10000];
    // $FF: renamed from: e com.codeforces.commons.geometry.Point2D[]
    private final Point2D[] field_840 = new Point2D[10000];
    // $FF: renamed from: f com.codeforces.commons.geometry.Point2D[]
    private final Point2D[] field_841 = new Point2D[10000];
    // $FF: renamed from: g com.a.a.b.a[][][]
    private final class_106[][][] field_842 = new class_106[2001][2001][];
    // $FF: renamed from: h java.util.Map
    private final Map field_843 = new HashMap();
    // $FF: renamed from: i java.util.Set
    private final Set field_844 = new HashSet();
    // $FF: renamed from: j double
    private double field_845;
    // $FF: renamed from: k double
    private final double field_846;

    public class_202(double var1, double var3) {
        this.field_845 = var1;
        this.field_846 = var3;
    }

    // $FF: renamed from: a (com.a.a.b.a) void
    public void method_66(final class_106 var1) {
        method_1065(var1);
        if(this.field_836.contains(var1)) {
            throw new IllegalStateException(var1 + " is already added.");
        } else {
            double var2 = var1.method_668().method_765();
            final double var4 = 2.0D * var2;
            if(var4 > this.field_845 && var4 <= this.field_846) {
                this.field_845 = var4;
                this.method_1068();
            }

            this.field_836.add(var1);
            this.field_837.put(var1.method_665(), var1);
            this.method_1069(var1);
            var1.method_690().method_651(new class_152() {
                // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) void
                public void method_37(Point2D var1x, Point2D var2) {
                    if(var4 <= class_202.this.field_845) {
                        int var3;
                        int var4x;
                        int var5;
                        int var6;
                        if(var1.method_665() >= 0L && var1.method_665() <= 9999L) {
                            int var7 = (int)var1.method_665();
                            Point2D var8 = class_202.this.field_840[var7];
                            Point2D var9 = class_202.this.field_841[var7];
                            Point2D var10 = var1.method_693();
                            if(var10.getX() >= var8.getX() && var10.getY() >= var8.getY() && var10.getX() < var9.getX() && var10.getY() < var9.getY()) {
                                return;
                            }

                            var3 = class_202.this.method_1076(var1x.getX());
                            var4x = class_202.this.method_1077(var1x.getY());
                            var5 = class_202.this.method_1076(var2.getX());
                            var6 = class_202.this.method_1077(var2.getY());
                        } else {
                            var3 = class_202.this.method_1076(var1x.getX());
                            var4x = class_202.this.method_1077(var1x.getY());
                            var5 = class_202.this.method_1076(var2.getX());
                            var6 = class_202.this.method_1077(var2.getY());
                            if(var3 == var5 && var4x == var6) {
                                return;
                            }
                        }

                        class_202.this.method_1072(var1, var3, var4x);
                        class_202.this.method_1070(var1, var5, var6);
                    }
                }
            }, this.getClass().getSimpleName() + "Listener");
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void method_67(class_106 var1) {
        if(var1 != null) {
            if(this.field_837.remove(var1.method_665()) != null) {
                this.field_836.remove(var1);
                this.method_1071(var1);
            }
        }
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean method_68(class_106 var1) {
        method_1065(var1);
        return this.field_836.contains(var1);
    }

    // $FF: renamed from: a () java.util.List
    public List method_69() {
        return new class_202.class_204(this.field_836, null);
    }

    // $FF: renamed from: d (com.a.a.b.a) java.util.List
    public List method_70(class_106 var1) {
        method_1065(var1);
        if(!this.field_836.contains(var1)) {
            throw new IllegalStateException("Can\'t find " + var1 + '.');
        } else {
            ArrayList var2 = new ArrayList();
            if(!this.field_844.isEmpty()) {
                Iterator var3 = this.field_844.iterator();

                while(var3.hasNext()) {
                    class_106 var4 = (class_106)var3.next();
                    method_1067(var1, var4, var2);
                }
            }

            int var5;
            int var8;
            int var9;
            if(var1.method_665() >= 0L && var1.method_665() <= 9999L) {
                var5 = (int)var1.method_665();
                var8 = this.field_838[var5];
                var9 = this.field_839[var5];
            } else {
                var8 = this.method_1076(var1.method_695());
                var9 = this.method_1077(var1.method_697());
            }

            for(var5 = -1; var5 <= 1; ++var5) {
                for(int var6 = -1; var6 <= 1; ++var6) {
                    class_106[] var7 = this.method_1075(var8 + var5, var9 + var6);
                    method_1066(var1, var7, var2);
                }
            }

            return Collections.unmodifiableList(var2);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a[], java.util.List) void
    private static void method_1066(class_106 var0, class_106[] var1, List var2) {
        if(var1 != null) {
            int var3 = 0;

            for(int var4 = var1.length; var3 < var4; ++var3) {
                method_1067(var0, var1[var3], var2);
            }

        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, java.util.List) void
    private static void method_1067(class_106 var0, class_106 var1, List var2) {
        if(!var1.method_721(var0)) {
            if(!var0.method_672() || !var1.method_672()) {
                if(Math.sqr(var1.method_668().method_765() + var0.method_668().method_765()) >= var1.method_716(var0)) {
                    var2.add(var1);
                }
            }
        }
    }

    // $FF: renamed from: b () void
    private void method_1068() {
        for(int var1 = -1000; var1 <= 1000; ++var1) {
            for(int var2 = -1000; var2 <= 1000; ++var2) {
                this.field_842[var1 - -1000][var2 - -1000] = null;
            }
        }

        this.field_843.clear();
        this.field_844.clear();
        Iterator var3 = this.field_836.iterator();

        while(var3.hasNext()) {
            class_106 var4 = (class_106)var3.next();
            this.method_1069(var4);
        }

    }

    // $FF: renamed from: f (com.a.a.b.a) void
    private void method_1069(class_106 var1) {
        double var2 = var1.method_668().method_765();
        double var4 = 2.0D * var2;
        if(var4 > this.field_845) {
            if(!this.field_844.add(var1)) {
                throw new IllegalStateException("Can\'t add Body {id=" + var1.method_665() + "} to index.");
            }
        } else {
            this.method_1070(var1, this.method_1076(var1.method_695()), this.method_1077(var1.method_697()));
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, int, int) void
    private void method_1070(class_106 var1, int var2, int var3) {
        if(var2 >= -1000 && var2 <= 1000 && var3 >= -1000 && var3 <= 1000) {
            class_106[] var6 = this.field_842[var2 - -1000][var3 - -1000];
            var6 = method_1073(var6, var1);
            this.field_842[var2 - -1000][var3 - -1000] = var6;
        } else {
            IntPair var4 = new IntPair(Integer.valueOf(var2), Integer.valueOf(var3));
            class_106[] var5 = (class_106[])this.field_843.get(var4);
            var5 = method_1073(var5, var1);
            this.field_843.put(var4, var5);
        }

        if(var1.method_665() >= 0L && var1.method_665() <= 9999L) {
            int var7 = (int)var1.method_665();
            this.field_838[var7] = var2;
            this.field_839[var7] = var3;
            this.field_840[var7] = new Point2D((double)var2 * this.field_845, (double)var3 * this.field_845);
            this.field_841[var7] = this.field_840[var7].copy().add(this.field_845, this.field_845);
        }

    }

    // $FF: renamed from: g (com.a.a.b.a) void
    private void method_1071(class_106 var1) {
        double var2 = var1.method_668().method_765();
        double var4 = 2.0D * var2;
        if(var4 > this.field_845) {
            if(!this.field_844.remove(var1)) {
                throw new IllegalStateException("Can\'t remove Body {id=" + var1.method_665() + "} from index.");
            }
        } else {
            this.method_1072(var1, this.method_1076(var1.method_695()), this.method_1077(var1.method_697()));
        }

    }

    // $FF: renamed from: b (com.a.a.b.a, int, int) void
    private void method_1072(class_106 var1, int var2, int var3) {
        if(var2 >= -1000 && var2 <= 1000 && var3 >= -1000 && var3 <= 1000) {
            class_106[] var6 = this.field_842[var2 - -1000][var3 - -1000];
            var6 = method_1074(var6, var1);
            this.field_842[var2 - -1000][var3 - -1000] = var6;
        } else {
            IntPair var4 = new IntPair(Integer.valueOf(var2), Integer.valueOf(var3));
            class_106[] var5 = (class_106[])this.field_843.get(var4);
            var5 = method_1074(var5, var1);
            if(var5 == null) {
                this.field_843.remove(var4);
            } else {
                this.field_843.put(var4, var5);
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a[], com.a.a.b.a) com.a.a.b.a[]
    private static class_106[] method_1073(class_106[] var0, class_106 var1) {
        if(var0 == null) {
            return new class_106[]{var1};
        } else {
            int var2 = ArrayUtils.indexOf(var0, var1);
            if(var2 != -1) {
                throw new IllegalStateException("Can\'t add Body {id=" + var1.method_665() + "} to index.");
            } else {
                int var3 = var0.length;
                class_106[] var4 = new class_106[var3 + 1];
                System.arraycopy(var0, 0, var4, 0, var3);
                var4[var3] = var1;
                return var4;
            }
        }
    }

    // $FF: renamed from: b (com.a.a.b.a[], com.a.a.b.a) com.a.a.b.a[]
    private static class_106[] method_1074(class_106[] var0, class_106 var1) {
        int var2 = ArrayUtils.indexOf(var0, var1);
        if(var2 == -1) {
            throw new IllegalStateException("Can\'t remove Body {id=" + var1.method_665() + "} from index.");
        } else {
            int var3 = var0.length;
            if(var3 == 1) {
                return null;
            } else {
                class_106[] var4 = new class_106[var3 - 1];
                System.arraycopy(var0, 0, var4, 0, var2);
                System.arraycopy(var0, var2 + 1, var4, var2, var3 - var2 - 1);
                return var4;
            }
        }
    }

    // $FF: renamed from: a (int, int) com.a.a.b.a[]
    private class_106[] method_1075(int var1, int var2) {
        return var1 >= -1000 && var1 <= 1000 && var2 >= -1000 && var2 <= 1000?this.field_842[var1 - -1000][var2 - -1000]:(class_106[])this.field_843.get(new IntPair(Integer.valueOf(var1), Integer.valueOf(var2)));
    }

    // $FF: renamed from: a (double) int
    private int method_1076(double var1) {
        return NumberUtil.toInt(Math.floor(var1 / this.field_845));
    }

    // $FF: renamed from: b (double) int
    private int method_1077(double var1) {
        return NumberUtil.toInt(Math.floor(var1 / this.field_845));
    }

    private static final class class_204 implements List {
        // $FF: renamed from: a java.util.Collection
        private final Collection field_260;

        private class_204(Collection var1) {
            this.field_260 = var1;
        }

        public int size() {
            return this.field_260.size();
        }

        public boolean isEmpty() {
            return this.field_260.isEmpty();
        }

        public boolean contains(Object var1) {
            return this.field_260.contains(var1);
        }

        public Iterator iterator() {
            final Iterator var1 = this.field_260.iterator();
            return new UnmodifiableIterator() {
                public boolean hasNext() {
                    return var1.hasNext();
                }

                public Object next() {
                    return var1.next();
                }
            };
        }

        public Object[] toArray() {
            return this.field_260.toArray();
        }

        public Object[] toArray(Object[] var1) {
            return this.field_260.toArray(var1);
        }

        public boolean add(Object var1) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object var1) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection var1) {
            return this.field_260.containsAll(var1);
        }

        public boolean addAll(Collection var1) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(int var1, Collection var2) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection var1) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection var1) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Object get(int var1) {
            if(this.field_260 instanceof List) {
                return ((List)this.field_260).get(var1);
            } else if(var1 >= 0 && var1 < this.field_260.size()) {
                Iterator var2 = this.field_260.iterator();

                for(int var3 = 0; var3 < var1; ++var3) {
                    var2.next();
                }

                return var2.next();
            } else {
                throw new IndexOutOfBoundsException("Illegal index: " + var1 + ", size: " + this.field_260.size() + '.');
            }
        }

        public Object set(int var1, Object var2) {
            throw new UnsupportedOperationException();
        }

        public void add(int var1, Object var2) {
            throw new UnsupportedOperationException();
        }

        public Object remove(int var1) {
            throw new UnsupportedOperationException();
        }

        public int indexOf(Object var1) {
            Iterator var2 = this.field_260.iterator();
            int var3 = 0;
            if(var1 == null) {
                while(var2.hasNext()) {
                    if(var2.next() == null) {
                        return var3;
                    }

                    ++var3;
                }
            } else {
                while(var2.hasNext()) {
                    if(var1.equals(var2.next())) {
                        return var3;
                    }

                    ++var3;
                }
            }

            return -1;
        }

        public int lastIndexOf(Object var1) {
            if(this.field_260 instanceof List) {
                return ((List)this.field_260).lastIndexOf(var1);
            } else {
                Iterator var2 = this.field_260.iterator();
                int var3 = 0;
                int var4 = -1;
                if(var1 == null) {
                    for(; var2.hasNext(); ++var3) {
                        if(var2.next() == null) {
                            var4 = var3;
                        }
                    }
                } else {
                    for(; var2.hasNext(); ++var3) {
                        if(var1.equals(var2.next())) {
                            var4 = var3;
                        }
                    }
                }

                return var4;
            }
        }

        public ListIterator listIterator() {
            return this.field_260 instanceof List?Collections.unmodifiableList((List)this.field_260).listIterator():Collections.unmodifiableList(new ArrayList(this.field_260)).listIterator();
        }

        public ListIterator listIterator(int var1) {
            return this.field_260 instanceof List?Collections.unmodifiableList((List)this.field_260).listIterator(var1):Collections.unmodifiableList(new ArrayList(this.field_260)).listIterator(var1);
        }

        public List subList(int var1, int var2) {
            return this.field_260 instanceof List?Collections.unmodifiableList(((List)this.field_260).subList(var1, var2)):Collections.unmodifiableList(new ArrayList(this.field_260)).subList(var1, var2);
        }

        // $FF: synthetic method
        class_204(Collection var1, Object var2) {
            this(var1);
        }
    }
}
