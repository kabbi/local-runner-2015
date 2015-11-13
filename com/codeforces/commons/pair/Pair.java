package com.codeforces.commons.pair;

import com.codeforces.commons.pair.SimplePair;

public class Pair extends SimplePair implements Comparable<Pair> {
    public Pair() {
    }

    public Pair(Comparable var1, Comparable var2) {
        super(var1, var2);
    }

    public Pair(SimplePair var1) {
        super(var1);
    }

    public int compareTo(Pair var1) {
        int var2;
        if(this.getFirst() != var1.getFirst()) {
            if(this.getFirst() == null) {
                return -1;
            }

            if(var1.getFirst() == null) {
                return 1;
            }

            var2 = ((Comparable)this.getFirst()).compareTo(var1.getFirst());
            if(var2 != 0) {
                return var2;
            }
        }

        if(this.getSecond() != var1.getSecond()) {
            if(this.getSecond() == null) {
                return -1;
            }

            if(var1.getSecond() == null) {
                return 1;
            }

            var2 = ((Comparable)this.getSecond()).compareTo(var1.getSecond());
            if(var2 != 0) {
                return var2;
            }
        }

        return 0;
    }

    public boolean equals(Comparable var1, Comparable var2) {
        boolean var10000;
        label32: {
            label24: {
                if(this.getFirst() == null) {
                    if(var1 != null) {
                        break label24;
                    }
                } else if(!((Comparable)this.getFirst()).equals(var1)) {
                    break label24;
                }

                if(this.getSecond() == null) {
                    if(var2 == null) {
                        break label32;
                    }
                } else if(((Comparable)this.getSecond()).equals(var2)) {
                    break label32;
                }
            }

            var10000 = false;
            return var10000;
        }

        var10000 = true;
        return var10000;
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
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
