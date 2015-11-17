package com.a.a.b;

import com.a.a.b.d.PositionListener;
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
public class StaticState {
    // $FF: renamed from: a com.a.a.b.d$a
    private ListeningPoint2D position;
    // $FF: renamed from: b double
    private double angle;

    // $FF: renamed from: c java.util.Map
    private Map<String, PositionListenerEntry> positionListenerEntryByName;
    // $FF: renamed from: d java.util.SortedSet
    private SortedSet<PositionListenerEntry> positionListenerEntries;

    public StaticState() {
        this.position = new ListeningPoint2D(0.0D, 0.0D);
    }

    public StaticState(StaticState state) {
        this.position = new ListeningPoint2D(state.position);
        this.angle = state.angle;
    }

    // $FF: renamed from: g () com.codeforces.commons.geometry.Point2D
    public Point2D getPosition() {
        return this.position;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D) void
    public void setPosition(Point2D position) {
        Point2D oldPosition = this.position.copy();
        Point2D newPosition = position.copy();
        Iterator var4;
        PositionListenerEntry var5;

        if(this.positionListenerEntries != null) {
            var4 = this.positionListenerEntries.iterator();

            while(var4.hasNext()) {
                var5 = (PositionListenerEntry)var4.next();
                if(!var5.listener.beforeChangePosition(oldPosition.copy(), newPosition)) {
                    return;
                }
            }
        }

        this.position = new ListeningPoint2D(newPosition);
        if(this.positionListenerEntries != null) {
            var4 = this.positionListenerEntries.iterator();

            while(var4.hasNext()) {
                var5 = (PositionListenerEntry)var4.next();
                var5.listener.afterChangePosition(oldPosition.copy(), newPosition.copy());
            }
        }

    }

    // $FF: renamed from: h () double
    public double getAngle() {
        return this.angle;
    }

    // $FF: renamed from: d (double) void
    public void setAngle(double angle) {
        this.angle = angle;
    }

    // $FF: renamed from: i () void
    public void normalizeAngle() {
        while(this.angle > StrictMath.PI) {
            this.angle -= StrictMath.PI * 2;
        }

        while(this.angle < -StrictMath.PI) {
            this.angle += StrictMath.PI * 2;
        }

    }

    // $FF: renamed from: a (com.a.a.b.d.c, java.lang.String, double) void
    public void registerPositionListener(PositionListener listener, String name, double priority) {
        NamedEntry.validateName(name);
        if(this.positionListenerEntryByName == null) {
            this.positionListenerEntryByName = new HashMap<>(1);
            this.positionListenerEntries = new TreeSet<>(PositionListenerEntry.comparator);
        } else if(this.positionListenerEntryByName.containsKey(name)) {
            throw new IllegalArgumentException("Listener \'" + name + "\' is already registered.");
        }

        PositionListenerEntry positionListenerEntry = new PositionListenerEntry(name, priority, listener);
        this.positionListenerEntryByName.put(name, positionListenerEntry);
        this.positionListenerEntries.add(positionListenerEntry);
    }

    // $FF: renamed from: a (com.a.a.b.d.c, java.lang.String) void
    public void registerPositionListener(PositionListener listener, String name) {
        this.registerPositionListener(listener, name, 0.0D);
    }

    public String toString() {
        return StringUtil.toString(this, false);
    }

    private static final class PositionListenerEntry extends NamedEntry {
        // $FF: renamed from: d java.util.Comparator
        private static final Comparator<PositionListenerEntry> comparator = new Comparator<PositionListenerEntry>() {
            // $FF: synthetic method
            public int compare(PositionListenerEntry a, PositionListenerEntry b) {
                int comparisonResult = Double.compare(b.priority, a.priority);
                return comparisonResult != 0 ? comparisonResult : a.name.compareTo(b.name);
            }
        };
        // $FF: renamed from: b double
        public final double priority;
        // $FF: renamed from: c com.a.a.b.d.c
        public final PositionListener listener;

        private PositionListenerEntry(String name, double priority, PositionListener listener) {
            super(name);
            this.priority = priority;
            this.listener = listener;
        }
    }

    private final class ListeningPoint2D extends Point2D {
        private ListeningPoint2D(double x, double y) {
            super(x, y);
        }

        private ListeningPoint2D(Point2D point) {
            super(point);
        }

        public void setX(double x) {
            this.setFirst(x);
        }

        public void setY(double y) {
            this.setSecond(y);
        }

        public Point2D add(Vector2D vector) {
            Point2D oldPosition = super.copy();
            Point2D newPosition = super.copy().add(vector);
            return this.onChange(oldPosition, newPosition);
        }

        public Point2D add(double x, double y) {
            Point2D oldPosition = super.copy();
            Point2D newPosition = super.copy().add(x, y);
            return this.onChange(oldPosition, newPosition);
        }

        public Point2D subtract(Vector2D vector) {
            Point2D oldPosition = super.copy();
            Point2D newPosition = super.copy().subtract(vector);
            return this.onChange(oldPosition, newPosition);
        }

        // $FF: renamed from: a (java.lang.Double) void
        public void setFirst(Double first) {
            Point2D oldPosition = super.copy();
            Point2D newPosition = super.copy();
            newPosition.setFirst(first);
            this.onChange(oldPosition, newPosition);
        }

        // $FF: renamed from: b (java.lang.Double) void
        public void setSecond(Double second) {
            Point2D oldPosition = super.copy();
            Point2D newPosition = super.copy();
            newPosition.setSecond(second);
            this.onChange(oldPosition, newPosition);
        }

        // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) com.codeforces.commons.geometry.Point2D
        private Point2D onChange(Point2D oldPosition, Point2D newPosition) {
            Iterator var3;
            PositionListenerEntry var4;
            if(positionListenerEntries != null) {
                var3 = positionListenerEntries.iterator();

                while(var3.hasNext()) {
                    var4 = (PositionListenerEntry)var3.next();
                    if(!var4.listener.beforeChangePosition(oldPosition.copy(), newPosition)) {
                        return this;
                    }
                }
            }

            super.setFirst(newPosition.getFirst());
            super.setSecond(newPosition.getSecond());

            if(positionListenerEntries != null) {
                var3 = positionListenerEntries.iterator();

                while(var3.hasNext()) {
                    var4 = (PositionListenerEntry)var3.next();
                    var4.listener.afterChangePosition(oldPosition.copy(), newPosition.copy());
                }
            }

            return this;
        }
    }
}
