package com.a.a.b;

import com.codeforces.commons.geometry.Vector2D;

// $FF: renamed from: com.a.a.b.b
public class DynamicState extends StaticState {
    // $FF: renamed from: a com.codeforces.commons.geometry.Vector2D
    private Vector2D velocity;
    // $FF: renamed from: b com.codeforces.commons.geometry.Vector2D
    private Vector2D medianVelocity;
    // $FF: renamed from: c com.codeforces.commons.geometry.Vector2D
    private Vector2D force;
    // $FF: renamed from: d double
    private double angularVelocity;
    // $FF: renamed from: e double
    private double medianAngularVelocity;
    // $FF: renamed from: f double
    private double torque;

    public DynamicState() {
        this.velocity = new Vector2D(0.0D, 0.0D);
        this.medianVelocity = new Vector2D(0.0D, 0.0D);
        this.force = new Vector2D(0.0D, 0.0D);
    }

    public DynamicState(DynamicState state) {
        super(state);
        this.velocity = state.velocity.copy();
        this.force = state.force.copy();
        this.angularVelocity = state.angularVelocity;
        this.torque = state.torque;
    }

    // $FF: renamed from: a () com.codeforces.commons.geometry.Vector2D
    public Vector2D getVelocity() {
        return this.velocity;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Vector2D) void
    public void setVelocity(Vector2D var1) {
        this.velocity = var1.copy();
    }

    // $FF: renamed from: b () com.codeforces.commons.geometry.Vector2D
    public Vector2D getMedianVelocity() {
        return this.medianVelocity;
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Vector2D) void
    public void setMedianVelocity(Vector2D medianVelocity) {
        this.medianVelocity = medianVelocity;
    }

    // $FF: renamed from: c () com.codeforces.commons.geometry.Vector2D
    public Vector2D getForce() {
        return this.force;
    }

    // $FF: renamed from: c (com.codeforces.commons.geometry.Vector2D) void
    public void setForce(Vector2D force) {
        this.force = force.copy();
    }

    // $FF: renamed from: d () double
    public double getAngularVelocity() {
        return this.angularVelocity;
    }

    // $FF: renamed from: a (double) void
    public void setAngularVelocity(double angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    // $FF: renamed from: e () double
    public double getMedianAngularVelocity() {
        return this.medianAngularVelocity;
    }

    // $FF: renamed from: b (double) void
    public void setMedianAngularVelocity(double medianAngularVelocity) {
        this.medianAngularVelocity = medianAngularVelocity;
    }

    // $FF: renamed from: f () double
    public double getTorque() {
        return this.torque;
    }

    // $FF: renamed from: c (double) void
    public void setTorque(double torque) {
        this.torque = torque;
    }
}
