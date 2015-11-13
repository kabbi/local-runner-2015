package com.codeforces.commons.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class LimitedByteArrayOutputStream extends ByteArrayOutputStream {
    private final int maxSize;
    private final boolean throwIfExceeded;

    public LimitedByteArrayOutputStream(int var1, boolean var2) {
        if(var1 < 0) {
            throw new IllegalArgumentException("Argument \'maxSize\' (" + var1 + " B) is negative.");
        } else {
            this.maxSize = var1;
            this.throwIfExceeded = var2;
        }
    }

    public synchronized void write(int var1) {
        if(this.size() < this.maxSize) {
            super.write(var1);
        } else if(this.throwIfExceeded) {
            throw new IllegalStateException("Buffer size (" + this.maxSize + " B) exceeded.");
        }

    }

    public synchronized void write(byte[] var1, int var2, int var3) {
        if(this.size() + var3 <= this.maxSize) {
            super.write(var1, var2, var3);
        } else {
            if(this.throwIfExceeded) {
                throw new IllegalStateException("Buffer size (" + this.maxSize + " B) exceeded.");
            }

            super.write(var1, var2, this.maxSize - this.size());
        }

    }

    public synchronized void write(byte[] var1) throws IOException {
        if(this.size() + var1.length <= this.maxSize) {
            super.write(var1);
        } else {
            if(this.throwIfExceeded) {
                throw new IllegalStateException("Buffer size (" + this.maxSize + " B) exceeded.");
            }

            super.write(var1, 0, this.maxSize - this.size());
        }

    }
}
