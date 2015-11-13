package com.codeforces.commons.holder;

import com.codeforces.commons.holder.Readable;
import com.codeforces.commons.holder.Writable;

public abstract class Mutable implements Readable, Writable {
    public boolean equals(Object var1) {
        boolean var10000;
        if(this != var1) {
            label31: {
                if(var1 instanceof Mutable) {
                    if(this.get() == null) {
                        if(((Readable)var1).get() == null) {
                            break label31;
                        }
                    } else if(this.get().equals(((Readable)var1).get())) {
                        break label31;
                    }
                }

                var10000 = false;
                return var10000;
            }
        }

        var10000 = true;
        return var10000;
    }

    public int hashCode() {
        return this.get() == null?0:this.get().hashCode();
    }

    public String toString() {
        return String.valueOf(this.get());
    }
}
