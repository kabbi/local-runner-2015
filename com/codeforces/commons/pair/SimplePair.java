package com.codeforces.commons.pair;

import com.codeforces.commons.text.StringUtil;

public class SimplePair {
    private Object first;
    private Object second;

    public SimplePair() {
    }

    public SimplePair(Object var1, Object var2) {
        this.first = var1;
        this.second = var2;
    }

    public SimplePair(SimplePair var1) {
        this.first = var1.first;
        this.second = var1.second;
    }

    public Object getFirst() {
        return this.first;
    }

    public void setFirst(Object var1) {
        this.first = var1;
    }

    public Object getSecond() {
        return this.second;
    }

    public void setSecond(Object var1) {
        this.second = var1;
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(!(var1 instanceof SimplePair)) {
            return false;
        } else {
            boolean var10000;
            label43: {
                label29: {
                    SimplePair var2 = (SimplePair)var1;
                    if(this.first == null) {
                        if(var2.first != null) {
                            break label29;
                        }
                    } else if(!this.first.equals(var2.first)) {
                        break label29;
                    }

                    if(this.second == null) {
                        if(var2.second == null) {
                            break label43;
                        }
                    } else if(this.second.equals(var2.second)) {
                        break label43;
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        }
    }

    public int hashCode() {
        int var1 = this.first == null?0:this.first.hashCode();
        var1 = 31 * var1 + (this.second == null?0:this.second.hashCode());
        return var1;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(SimplePair var0) {
        return toString(SimplePair.class, var0);
    }

    public static String toString(Class var0, SimplePair var1) {
        return StringUtil.toString(var0, var1, false, new String[]{"first", "second"});
    }
}
