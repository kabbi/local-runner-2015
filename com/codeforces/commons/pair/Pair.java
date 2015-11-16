package com.codeforces.commons.pair;

import com.codeforces.commons.pair.SimplePair;

public class Pair<A extends Comparable<A>, B extends Comparable<B>> extends SimplePair<A, B> implements Comparable<Pair<A, B>> {
    public Pair() {
    }

    public Pair(A var1, B var2) {
        super(var1, var2);
    }

    public Pair(SimplePair<A, B> var1) {
        super(var1);
    }

    public int compareTo(Pair<A, B> other) {
        int var2;
        if(this.getFirst() != other.getFirst()) {
            if(this.getFirst() == null) {
                return -1;
            }

            if(other.getFirst() == null) {
                return 1;
            }

            var2 = this.getFirst().compareTo(other.getFirst());
            if(var2 != 0) {
                return var2;
            }
        }

        if(this.getSecond() != other.getSecond()) {
            if(this.getSecond() == null) {
                return -1;
            }

            if(other.getSecond() == null) {
                return 1;
            }

            var2 = this.getSecond().compareTo(other.getSecond());
            if(var2 != 0) {
                return var2;
            }
        }

        return 0;
    }

    public boolean equals(Comparable var1, Comparable var2) {
        label32: {
            label24: {
                if(this.getFirst() == null) {
                    if(var1 != null) {
                        break label24;
                    }
                } else if(!this.getFirst().equals(var1)) {
                    break label24;
                }

                if(this.getSecond() == null) {
                    if(var2 == null) {
                        break label32;
                    }
                } else if(this.getSecond().equals(var2)) {
                    break label32;
                }
            }
            return false;
        }
        return true;
    }

    public boolean equals(Object other) {
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(Pair var0) {
        return toString(Pair.class, var0);
    }
}
