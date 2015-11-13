package com.a.b.a.a.d;

import com.a.b.a.a.a.class_18;
import com.a.b.a.a.b.e.class_81;
import com.a.b.a.a.c.class_138;
import com.a.b.a.a.d.class_5;
import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.math.NumberUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.a.b.a.a.d.o
public class class_97 implements class_5 {
    // $FF: renamed from: a java.util.concurrent.ExecutorService
    private final ExecutorService field_365 = Executors.newSingleThreadExecutor();
    // $FF: renamed from: b java.util.concurrent.atomic.AtomicReference
    private final AtomicReference field_366 = new AtomicReference();
    // $FF: renamed from: c java.io.Writer
    private final Writer field_367;
    // $FF: renamed from: d com.a.b.a.a.b.e.d
    private final class_81 field_368;

    public class_97(File var1, class_18 var2) throws IOException {
        FileUtil.ensureParentDirectoryExists(var1);
        this.field_367 = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(var1, false), NumberUtil.toInt(262144L)), StandardCharsets.UTF_8);
        this.field_368 = new class_81(var2);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h) void
    public void method_32(final class_138 var1) throws IOException {
        this.method_616();
        this.field_365.execute(new Runnable() {
            public void run() {
                if(class_97.this.field_366.get() == null) {
                    try {
                        class_97.this.field_367.write(class_97.this.field_368.method_485(var1));
                        class_97.this.field_367.write(10);
                    } catch (RuntimeException | Error | IOException var2) {
                        class_97.this.method_615(var2);
                    }

                }
            }
        });
    }

    public void close() throws IOException {
        try {
            this.field_365.shutdown();

            try {
                if(!this.field_365.awaitTermination(1L, TimeUnit.MINUTES)) {
                    this.method_615(new IOException("Can\'t write game log file in the allotted time."));
                }
            } catch (InterruptedException var2) {
                this.method_615(new IOException("Unexpectedly interrupted while writing game log file.", var2));
            }

            this.method_616();
            this.field_367.close();
        } catch (RuntimeException | Error | IOException var3) {
            IoUtil.closeQuietly((AutoCloseable)this.field_367);
            throw var3;
        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    private void method_615(Throwable var1) {
        this.field_366.compareAndSet((Object)null, var1);
    }

    // $FF: renamed from: a () void
    private void method_616() throws IOException {
        Throwable var1 = (Throwable)this.field_366.get();
        if(var1 != null) {
            if(var1 instanceof IOException) {
                throw (IOException)var1;
            } else if(var1 instanceof RuntimeException) {
                throw (RuntimeException)var1;
            } else if(var1 instanceof Error) {
                throw (Error)var1;
            } else {
                throw new IllegalStateException("Got unexpected async. throwable.", var1);
            }
        }
    }
}
