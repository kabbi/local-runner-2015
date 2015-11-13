package com.codeforces.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public final class CountingInputStream extends InputStream {
    private static final CountingInputStream.ReadEvent EMPTY_READ_EVENT = new CountingInputStream.ReadEvent() {
        public void onRead(long var1, long var3) {
        }
    };
    private final ReentrantLock lock = new ReentrantLock();
    private final AtomicLong totalReadByteCount = new AtomicLong();
    private final InputStream inputStream;
    private final CountingInputStream.ReadEvent readEvent;

    public CountingInputStream(InputStream var1, CountingInputStream.ReadEvent var2) {
        this.inputStream = var1;
        this.readEvent = var2;
    }

    public int read() throws IOException {
        if(this.lock.isHeldByCurrentThread()) {
            return this.inputStream.read();
        } else {
            this.lock.lock();

            int var2;
            try {
                int var1 = this.inputStream.read();
                if(var1 != -1) {
                    this.readEvent.onRead(1L, this.totalReadByteCount.incrementAndGet());
                }

                var2 = var1;
            } finally {
                this.lock.unlock();
            }

            return var2;
        }
    }

    public int read(byte[] var1) throws IOException {
        if(this.lock.isHeldByCurrentThread()) {
            return this.inputStream.read(var1);
        } else {
            this.lock.lock();

            int var3;
            try {
                int var2 = this.inputStream.read(var1);
                if(var2 > 0) {
                    this.readEvent.onRead((long)var2, this.totalReadByteCount.addAndGet((long)var2));
                }

                var3 = var2;
            } finally {
                this.lock.unlock();
            }

            return var3;
        }
    }

    public int read(byte[] var1, int var2, int var3) throws IOException {
        if(this.lock.isHeldByCurrentThread()) {
            return this.inputStream.read(var1, var2, var3);
        } else {
            this.lock.lock();

            int var5;
            try {
                int var4 = this.inputStream.read(var1, var2, var3);
                if(var4 > 0) {
                    this.readEvent.onRead((long)var4, this.totalReadByteCount.addAndGet((long)var4));
                }

                var5 = var4;
            } finally {
                this.lock.unlock();
            }

            return var5;
        }
    }

    public long skip(long var1) throws IOException {
        if(this.lock.isHeldByCurrentThread()) {
            return this.inputStream.skip(var1);
        } else {
            this.lock.lock();

            long var5;
            try {
                long var3 = this.inputStream.skip(var1);
                if(var3 > 0L) {
                    this.readEvent.onRead(var3, this.totalReadByteCount.addAndGet(var1));
                }

                var5 = var3;
            } finally {
                this.lock.unlock();
            }

            return var5;
        }
    }

    public int available() throws IOException {
        this.lock.lock();

        int var1;
        try {
            var1 = this.inputStream.available();
        } finally {
            this.lock.unlock();
        }

        return var1;
    }

    public void close() throws IOException {
        this.lock.lock();

        try {
            this.inputStream.close();
        } finally {
            this.lock.unlock();
        }

    }

    public interface ReadEvent {
        void onRead(long var1, long var3) throws IOException;
    }
}
