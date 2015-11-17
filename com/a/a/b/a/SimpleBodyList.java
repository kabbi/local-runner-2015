package com.a.a.b.a;

import com.a.a.b.Body;
import com.codeforces.commons.math.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// $FF: renamed from: com.a.a.b.a.f
public class SimpleBodyList extends BodyListBase {
    // $FF: renamed from: a java.util.List
    private final List<Body> bodies = new LinkedList<>();

    // $FF: renamed from: a (com.a.a.b.a) void
    public void addBody(Body body) {
        validateBody(body);

        if(this.bodies.contains(body)) {
            throw new IllegalStateException(body + " is already added.");
        } else {
            this.bodies.add(body);
        }
    }

    // $FF: renamed from: b (com.a.a.b.a) void
    public void removeBody(Body body) {
        if(body != null) {
            Iterator it = this.bodies.iterator();

            do {
                if(!it.hasNext()) {
                    return;
                }
            } while(!((Body)it.next()).equals(body));

            it.remove();
        }
    }

    // $FF: renamed from: c (com.a.a.b.a) boolean
    public boolean hasBody(Body body) {
        validateBody(body);
        return this.bodies.contains(body);
    }

    // $FF: renamed from: a () java.util.List
    public List<Body> getBodies() {
        return Collections.unmodifiableList(this.bodies);
    }

    // $FF: renamed from: d (com.a.a.b.a) java.util.List
    public List<Body> getPotentialIntersections(Body body) {
        validateBody(body);

        List<Body> potentialIntersections = new ArrayList<>();
        boolean exists = false;

        for (Body b : this.bodies) {
            if (b.equals(body)) {
                exists = true;
            } else if ((!body.isStatic() || !b.isStatic()) && Math.sqr(b.getForm().getCircumcircleRadius() + body.getForm().getCircumcircleRadius()) >= b.getSquaredDistanceTo(body)) {
                potentialIntersections.add(b);
            }
        }

        if(!exists) {
            throw new IllegalStateException("Can\'t find " + body + '.');
        }

        return Collections.unmodifiableList(potentialIntersections);
    }
}
