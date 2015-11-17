package com.a.a.b.a;

import com.a.a.b.Body;
import com.a.a.b.d.PositionListenerAdapter;
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

import javax.annotation.Nonnull;

// $FF: renamed from: com.a.a.b.a.c
public class CellSpaceBodyList extends BodyListBase {
    private static final int MIN_FAST_X = -1000;
    private static final int MAX_FAST_X = 1000;
    private static final int MIN_FAST_Y = -1000;
    private static final int MAX_FAST_Y = 1000;

    public static final int MAX_FAST_CELL_BODY_ID = 9999;

    // $FF: renamed from: a java.util.Set
    private final Set<Body> bodies = new HashSet<>();
    // $FF: renamed from: b java.util.Map
    private final Map<Long, Body> bodyById = new HashMap<>();

    // $FF: renamed from: c int[]
    private final int[] fastCellXByBodyId = new int[MAX_FAST_CELL_BODY_ID + 1];
    // $FF: renamed from: d int[]
    private final int[] fastCellYByBodyId = new int[MAX_FAST_CELL_BODY_ID + 1];
    // $FF: renamed from: e com.codeforces.commons.geometry.Point2D[]
    private final Point2D[] fastCellLeftTopByBodyId = new Point2D[MAX_FAST_CELL_BODY_ID + 1];
    // $FF: renamed from: f com.codeforces.commons.geometry.Point2D[]
    private final Point2D[] fastCellRightBottomByBodyId = new Point2D[MAX_FAST_CELL_BODY_ID + 1];

    // $FF: renamed from: g com.a.a.b.a[][][]
    private final Body[][][] bodiesByCellXY = new Body[MAX_FAST_X - MIN_FAST_X + 1][MAX_FAST_Y - MIN_FAST_Y + 1][];
    // $FF: renamed from: h java.util.Map
    private final Map<IntPair, Body[]> bodiesByCell = new HashMap<>();
    // $FF: renamed from: i java.util.Set
    private final Set<Body> cellExceedingBodies = new HashSet<>();

    // $FF: renamed from: j double
    private double cellSize;
    // $FF: renamed from: k double
    private final double maxCellSize;

    public CellSpaceBodyList(double initialCellSize, double maxCellSize) {
        this.cellSize = initialCellSize;
        this.maxCellSize = maxCellSize;
    }

    // $FF: renamed from: a (com.a.a.b.a) void
    public void addBody(final Body body) {
        validateBody(body);

        if(this.bodies.contains(body)) {
            throw new IllegalStateException(body + " is already added.");
        } else {
            double radius = body.getForm().getCircumcircleRadius();
            final double diameter = 2.0D * radius;

            if(diameter > this.cellSize && diameter <= this.maxCellSize) {
                this.cellSize = diameter;
                this.rebuildIndexes();
            }

            this.bodies.add(body);
            this.bodyById.put(body.getId(), body);
            this.addBodyToIndexes(body);
            body.getCurrentState().registerPositionListener(new PositionListenerAdapter() {
                // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) void
                public void afterChangePosition(Point2D oldPosition, Point2D newPosition) {
                    if (diameter <= cellSize) {
                        int oldCellX;
                        int oldCellY;
                        int newCellX;
                        int newCellY;
                        if (body.getId() >= 0L && body.getId() <= 9999L) {
                            int bodyId = (int) body.getId();
                            Point2D cellLeftTop = fastCellLeftTopByBodyId[bodyId];
                            Point2D cellRightBottom = fastCellRightBottomByBodyId[bodyId];

                            Point2D position = body.getPosition();

                            if (position.getX() >= cellLeftTop.getX() && position.getY() >= cellLeftTop.getY() && position.getX() < cellRightBottom.getX() && position.getY() < cellRightBottom.getY()) {
                                return;
                            }

                            oldCellX = getCellX(oldPosition.getX());
                            oldCellY = getCellY(oldPosition.getY());

                            newCellX = getCellX(newPosition.getX());
                            newCellY = getCellY(newPosition.getY());
                        } else {
                            oldCellX = getCellX(oldPosition.getX());
                            oldCellY = getCellY(oldPosition.getY());

                            newCellX = getCellX(newPosition.getX());
                            newCellY = getCellY(newPosition.getY());

                            if (oldCellX == newCellX && oldCellY == newCellY) {
                                return;
                            }
                        }

                        removeBodyFromIndexes(body, oldCellX, oldCellY);
                        addBodyToIndexes(body, newCellX, newCellY);
                    }
                }
            }, this.getClass().getSimpleName() + "Listener");
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void removeBody(Body body) {
        if(body != null) {
            if(this.bodyById.remove(body.getId()) != null) {
                this.bodies.remove(body);
                this.removeBodyFromIndexes(body);
            }
        }
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean hasBody(Body body) {
        validateBody(body);
        return this.bodies.contains(body);
    }

    // $FF: renamed from: a () java.util.List
    public List<Body> getBodies() {
        return new UnmodifiableCollectionWrapperList<>(this.bodies);
    }

    // $FF: renamed from: d (com.a.a.b.a) java.util.List
    public List<Body> getPotentialIntersections(Body body) {
        validateBody(body);
        if(!this.bodies.contains(body)) {
            throw new IllegalStateException("Can\'t find " + body + '.');
        } else {
            List<Body> potentialIntersections = new ArrayList<>();
            if(!this.cellExceedingBodies.isEmpty()) {
                for (Body otherBody : this.cellExceedingBodies) {
                    addPotentialIntersection(body, otherBody, potentialIntersections);
                }
            }

            int bodyId;
            int cellX;
            int cellY;
            if(body.getId() >= 0L && body.getId() <= 9999L) {
                bodyId = (int) body.getId();
                cellX = this.fastCellXByBodyId[bodyId];
                cellY = this.fastCellYByBodyId[bodyId];
            } else {
                cellX = this.getCellX(body.getX());
                cellY = this.getCellY(body.getY());
            }

            for(int cellOffsetX = -1; cellOffsetX <= 1; ++cellOffsetX) {
                for(int cellOffsetY = -1; cellOffsetY <= 1; ++cellOffsetY) {
                    Body[] cellBodies = this.getCellBodies(cellX + cellOffsetX, cellY + cellOffsetY);
                    addPotentialIntersections(body, cellBodies, potentialIntersections);
                }
            }

            return Collections.unmodifiableList(potentialIntersections);
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a[], java.util.List) void
    private static void addPotentialIntersections(Body body, Body[] bodies, List<Body> potentialIntersections) {
        if(bodies != null) {
            for(int bodyIndex = 0, bodyCount = bodies.length; bodyIndex < bodyCount; ++bodyIndex) {
                addPotentialIntersection(body, bodies[bodyIndex], potentialIntersections);
            }
        }
    }

    // $FF: renamed from: a (com.a.a.b.a, com.a.a.b.a, java.util.List) void
    private static void addPotentialIntersection(Body body, Body otherBody, List<Body> potentialIntersections) {
        if(!otherBody.equals(body)) {
            if(!body.isStatic() || !otherBody.isStatic()) {
                if(Math.sqr(otherBody.getForm().getCircumcircleRadius() + body.getForm().getCircumcircleRadius()) >= otherBody.getSquaredDistanceTo(body)) {
                    potentialIntersections.add(otherBody);
                }
            }
        }
    }

    // $FF: renamed from: b () void
    private void rebuildIndexes() {
        for(int cellX = MIN_FAST_X; cellX <= MAX_FAST_X; ++cellX) {
            for(int cellY = MIN_FAST_Y; cellY <= MAX_FAST_Y; ++cellY) {
                this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y] = null;
            }
        }

        this.bodiesByCell.clear();
        this.cellExceedingBodies.clear();

        for (Body body : this.bodies) {
            this.addBodyToIndexes(body);
        }

    }

    // $FF: renamed from: f (com.a.a.b.a) void
    private void addBodyToIndexes(Body body) {
        double radius = body.getForm().getCircumcircleRadius();
        double diameter = 2.0D * radius;

        if(diameter > this.cellSize) {
            if(!this.cellExceedingBodies.add(body)) {
                throw new IllegalStateException("Can\'t add Body {id=" + body.getId() + "} to index.");
            }
        } else {
            this.addBodyToIndexes(body, this.getCellX(body.getX()), this.getCellY(body.getY()));
        }

    }

    // $FF: renamed from: a (com.a.a.b.a, int, int) void
    private void addBodyToIndexes(Body body, int cellX, int cellY) {
        if(cellX >= MIN_FAST_X && cellX <= MAX_FAST_X && cellY >= MIN_FAST_Y && cellY <= MAX_FAST_Y) {
            Body[] cellBodies = this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y];
            cellBodies = addBodyToCell(cellBodies, body);
            this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y] = cellBodies;
        } else {
            IntPair cell = new IntPair(cellX, cellY);
            Body[] cellBodies = (Body[])this.bodiesByCell.get(cell);
            cellBodies = addBodyToCell(cellBodies, body);
            this.bodiesByCell.put(cell, cellBodies);
        }

        if(body.getId() >= 0L && body.getId() <= MAX_FAST_CELL_BODY_ID) {
            int bodyId = (int)body.getId();
            this.fastCellXByBodyId[bodyId] = cellX;
            this.fastCellYByBodyId[bodyId] = cellY;
            this.fastCellLeftTopByBodyId[bodyId] = new Point2D((double)cellX * this.cellSize, (double)cellY * this.cellSize);
            this.fastCellRightBottomByBodyId[bodyId] = this.fastCellLeftTopByBodyId[bodyId].copy().add(this.cellSize, this.cellSize);
        }

    }

    // $FF: renamed from: g (com.a.a.b.a) void
    private void removeBodyFromIndexes(Body body) {
        double radius = body.getForm().getCircumcircleRadius();
        double diameter = 2.0D * radius;

        if(diameter > this.cellSize) {
            if(!this.cellExceedingBodies.remove(body)) {
                throw new IllegalStateException("Can\'t remove Body {id=" + body.getId() + "} from index.");
            }
        } else {
            this.removeBodyFromIndexes(body, this.getCellX(body.getX()), this.getCellY(body.getY()));
        }

    }

    // $FF: renamed from: b (com.a.a.b.a, int, int) void
    private void removeBodyFromIndexes(Body body, int cellX, int cellY) {
        if(cellX >= MIN_FAST_X && cellX <= MAX_FAST_X && cellY >= MIN_FAST_Y && cellY <= MAX_FAST_Y) {
            Body[] cellBodies = this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y];
            cellBodies = removeBodyFromCell(cellBodies, body);
            this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y] = cellBodies;
        } else {
            IntPair cell = new IntPair(cellX, cellY);
            Body[] cellBodies = this.bodiesByCell.get(cell);
            cellBodies = removeBodyFromCell(cellBodies, body);

            if(cellBodies == null) {
                this.bodiesByCell.remove(cell);
            } else {
                this.bodiesByCell.put(cell, cellBodies);
            }
        }

    }

    // $FF: renamed from: a (com.a.a.b.a[], com.a.a.b.a) com.a.a.b.a[]
    private static Body[] addBodyToCell(Body[] cellBodies, Body body) {
        if(cellBodies == null) {
            return new Body[]{body};
        } else {
            int bodyIndex = ArrayUtils.indexOf(cellBodies, body);
            if(bodyIndex != -1) {
                throw new IllegalStateException("Can\'t add Body {id=" + body.getId() + "} to index.");
            } else {
                int bodyCount = cellBodies.length;
                Body[] newCellBodies = new Body[bodyCount + 1];
                System.arraycopy(cellBodies, 0, newCellBodies, 0, bodyCount);
                newCellBodies[bodyCount] = body;
                return newCellBodies;
            }
        }
    }

    // $FF: renamed from: b (com.a.a.b.a[], com.a.a.b.a) com.a.a.b.a[]
    private static Body[] removeBodyFromCell(Body[] cellBodies, Body body) {
        int bodyIndex = ArrayUtils.indexOf(cellBodies, body);
        if(bodyIndex == -1) {
            throw new IllegalStateException("Can\'t remove Body {id=" + body.getId() + "} from index.");
        } else {
            int bodyCount = cellBodies.length;
            if(bodyCount == 1) {
                return null;
            } else {
                Body[] newCellBodies = new Body[bodyCount - 1];
                System.arraycopy(cellBodies, 0, newCellBodies, 0, bodyIndex);
                System.arraycopy(cellBodies, bodyIndex + 1, newCellBodies, bodyIndex, bodyCount - bodyIndex - 1);
                return newCellBodies;
            }
        }
    }

    // $FF: renamed from: a (int, int) com.a.a.b.a[]
    private Body[] getCellBodies(int cellX, int cellY) {
        return cellX >= MIN_FAST_X && cellX <= MAX_FAST_X && cellY >= MIN_FAST_Y && cellY <= MAX_FAST_Y
                ? this.bodiesByCellXY[cellX - MIN_FAST_X][cellY - MIN_FAST_Y]
                : this.bodiesByCell.get(new IntPair(cellX, cellY));
    }

    // $FF: renamed from: a (double) int
    private int getCellX(double var1) {
        return NumberUtil.toInt(Math.floor(var1 / this.cellSize));
    }

    // $FF: renamed from: b (double) int
    private int getCellY(double var1) {
        return NumberUtil.toInt(Math.floor(var1 / this.cellSize));
    }

    private static final class UnmodifiableCollectionWrapperList<E> implements List<E> {
        // $FF: renamed from: a java.util.Collection
        private final Collection<E> collection;

        private UnmodifiableCollectionWrapperList(Collection<E> collection) {
            this.collection = collection;
        }

        public int size() {
            return this.collection.size();
        }

        public boolean isEmpty() {
            return this.collection.isEmpty();
        }

        public boolean contains(Object var1) {
            return this.collection.contains(var1);
        }

        @Nonnull
        public Iterator<E> iterator() {
            final Iterator<E> iterator = this.collection.iterator();
            return new UnmodifiableIterator<E>() {
                public boolean hasNext() {
                    return iterator.hasNext();
                }

                public E next() {
                    return iterator.next();
                }
            };
        }

        public Object[] toArray() {
            return this.collection.toArray();
        }

        @SuppressWarnings("SuspiciousToArrayCall")
        public <T> T[] toArray(@Nonnull T[] var1) {
            return this.collection.toArray(var1);
        }

        public boolean add(Object element) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object element) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(@Nonnull Collection collection) {
            return this.collection.containsAll(collection);
        }

        public boolean addAll(@Nonnull Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(int index, @Nonnull Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(@Nonnull Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(@Nonnull Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public E get(int index) {
            if(this.collection instanceof List) {
                return ((List<E>)this.collection).get(index);
            } else if(index >= 0 && index < this.collection.size()) {
                Iterator<E> var2 = this.collection.iterator();

                for(int var3 = 0; var3 < index; ++var3) {
                    var2.next();
                }

                return var2.next();
            } else {
                throw new IndexOutOfBoundsException("Illegal index: " + index + ", size: " + this.collection.size() + '.');
            }
        }

        public E set(int var1, E var2) {
            throw new UnsupportedOperationException();
        }

        public void add(int var1, E var2) {
            throw new UnsupportedOperationException();
        }

        public E remove(int var1) {
            throw new UnsupportedOperationException();
        }

        public int indexOf(Object o) {
            Iterator<E> var2 = this.collection.iterator();
            int var3 = 0;
            if(o == null) {
                while(var2.hasNext()) {
                    if(var2.next() == null) {
                        return var3;
                    }

                    ++var3;
                }
            } else {
                while(var2.hasNext()) {
                    if(o.equals(var2.next())) {
                        return var3;
                    }

                    ++var3;
                }
            }

            return -1;
        }

        public int lastIndexOf(Object o) {
            if(this.collection instanceof List) {
                return ((List)this.collection).lastIndexOf(o);
            } else {
                Iterator<E> var2 = this.collection.iterator();
                int var3 = 0;
                int var4 = -1;
                if(o == null) {
                    for(; var2.hasNext(); ++var3) {
                        if(var2.next() == null) {
                            var4 = var3;
                        }
                    }
                } else {
                    for(; var2.hasNext(); ++var3) {
                        if(o.equals(var2.next())) {
                            var4 = var3;
                        }
                    }
                }

                return var4;
            }
        }

        @Nonnull
        public ListIterator<E> listIterator() {
            return this.collection instanceof List
                    ? Collections.unmodifiableList((List<E>)this.collection).listIterator()
                    : Collections.unmodifiableList(new ArrayList<>(this.collection)).listIterator();
        }

        @Nonnull
        public ListIterator<E> listIterator(int index) {
            return this.collection instanceof List
                    ? Collections.unmodifiableList((List<E>)this.collection).listIterator(index)
                    : Collections.unmodifiableList(new ArrayList<>(this.collection)).listIterator(index);
        }

        @Nonnull
        public List<E> subList(int fromIndex, int toIndex) {
            return this.collection instanceof List
                    ? Collections.unmodifiableList(((List<E>)this.collection).subList(fromIndex, toIndex))
                    : Collections.unmodifiableList(new ArrayList<>(this.collection)).subList(fromIndex, toIndex);
        }
    }
}
