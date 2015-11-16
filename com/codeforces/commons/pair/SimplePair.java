package com.codeforces.commons.pair;

import com.codeforces.commons.text.StringUtil;

public class SimplePair<A, B> {
    private A first;
    private B second;

    public SimplePair() {
    }

    public SimplePair(A var1, B var2) {
        this.first = var1;
        this.second = var2;
    }

    public SimplePair(SimplePair<A, B> other) {
        this.first = other.first;
        this.second = other.second;
    }

    public A getFirst() {
        return this.first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return this.second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        } else if(!(other instanceof SimplePair)) {
            return false;
        } else {
            SimplePair otherPair = (SimplePair)other;
            if (this.first == null && otherPair.first != null) {
                return false;
            } else if (this.first != null && !this.first.equals(otherPair.first)) {
                return false;
            }
            if (this.second == null && otherPair.second == null) {
                return true;
            } else if (this.second != null && this.second.equals(otherPair.second)) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        hashCode = 31 * hashCode + (this.second == null ? 0 : this.second.hashCode());
        return hashCode;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(SimplePair pair) {
        return toString(SimplePair.class, pair);
    }

    public static String toString(Class aClass, SimplePair pair) {
        return StringUtil.toString(aClass, pair, false, "first", "second");
    }
}
