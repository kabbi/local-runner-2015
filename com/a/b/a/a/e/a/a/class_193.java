package com.a.b.a.a.e.a.a;

import com.a.b.a.a.a.GameParatemers;
import com.a.b.a.a.e.a.class_177;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.IOUtils;

// $FF: renamed from: com.a.b.a.a.e.a.a.f
public abstract class class_193 implements class_14 {
    // $FF: renamed from: a int
    private static final int field_812;
    // $FF: renamed from: b java.nio.ByteOrder
    private static final ByteOrder field_813;
    // $FF: renamed from: c java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_814 = new AtomicBoolean();
    // $FF: renamed from: d int
    private final int field_815;
    // $FF: renamed from: e java.net.ServerSocket
    private ServerSocket field_816;
    // $FF: renamed from: f java.net.Socket
    private Socket field_817;
    // $FF: renamed from: g java.io.InputStream
    private InputStream field_818;
    // $FF: renamed from: h java.io.OutputStream
    private OutputStream field_819;
    // $FF: renamed from: i java.io.ByteArrayOutputStream
    private final ByteArrayOutputStream field_820;
    // $FF: renamed from: j java.io.File
    private final File field_821;
    // $FF: renamed from: k java.io.OutputStream
    private OutputStream field_822;

    protected class_193(GameParatemers var1, File var2) {
        if(var1.method_90()) {
            this.field_815 = NumberUtil.toInt(TimeUnit.MINUTES.toMillis(20L));
        } else {
            this.field_815 = NumberUtil.toInt(Math.max(TimeUnit.SECONDS.toMillis(10L), 10000L));
        }

        this.field_820 = new ByteArrayOutputStream(field_812);
        this.field_821 = var2;
    }

    // $FF: renamed from: a (int) void
    public void method_56(int var1) {
        try {
            this.field_816 = new ServerSocket(var1);
            this.field_816.setSoTimeout(this.field_815);
            this.field_816.setReceiveBufferSize(field_812);
        } catch (IOException var3) {
            throw new class_177(String.format("Can\'t start %s.", this.getClass()), var3);
        }
    }

    // $FF: renamed from: a () void
    public void method_57() {
        IoUtil.closeQuietly((AutoCloseable)this.field_817);

        try {
            this.field_817 = this.field_816.accept();
            this.field_817.setSoTimeout(this.field_815);
            this.field_817.setSendBufferSize(field_812);
            this.field_817.setReceiveBufferSize(field_812);
            this.field_817.setTcpNoDelay(true);
            this.field_818 = this.field_817.getInputStream();
            this.field_819 = this.field_817.getOutputStream();
            if(this.field_821 != null) {
                this.field_822 = new FileOutputStream(this.field_821);
            }

        } catch (IOException var2) {
            throw new class_177("Can\'t accept remote process connection.", var2);
        }
    }

    // $FF: renamed from: a (java.lang.Object[], com.a.b.a.a.e.a.a.f$a) void
    protected final void a(Object[] var1, class_193.class_210 var2) {
        if(var1 == null) {
            this.c(-1);
        } else {
            int var3 = var1.length;
            this.c(var3);

            for(int var4 = 0; var4 < var3; ++var4) {
                var2.method_12(var1[var4]);
            }
        }

    }

    // $FF: renamed from: a (java.lang.Object, boolean) void
    protected final void a(Object var1, boolean var2) {
        if(var1 == null) {
            if(var2) {
                this.c(-1);
            }
        } else {
            int var3 = Array.getLength(var1);
            if(var2) {
                this.c(var3);
            }

            Class var4 = var1.getClass().getComponentType();

            for(int var5 = 0; var5 < var3; ++var5) {
                Object var6 = Array.get(var1, var5);
                if(var4.isArray()) {
                    this.a(var6, var2);
                } else if(var4.isEnum()) {
                    this.a((Enum) var6);
                } else if(var4 == String.class) {
                    this.a((String) var6);
                } else if(var6 == null) {
                    this.a(false);
                } else if(var4 != Boolean.class && var4 != Boolean.TYPE) {
                    if(var4 != Integer.class && var4 != Integer.TYPE) {
                        if(var4 != Long.class && var4 != Long.TYPE) {
                            if(var4 != Double.class && var4 != Double.TYPE) {
                                throw new IllegalArgumentException("Unsupported array item class: " + var4 + '.');
                            }

                            this.a((Double) var6);
                        } else {
                            this.a((Long) var6);
                        }
                    } else {
                        this.c((Integer) var6);
                    }
                } else {
                    this.a((Boolean) var6);
                }
            }
        }

    }

    // $FF: renamed from: a (java.lang.Class) java.lang.Enum
    protected final Enum a(Class var1) {
        byte var2 = this.method_1034(1)[0];
        Enum[] var3 = (Enum[])var1.getEnumConstants();
        int var4 = 0;

        for(int var5 = var3.length; var4 < var5; ++var4) {
            Enum var6 = var3[var4];
            if(var6.ordinal() == var2) {
                return var6;
            }
        }

        return null;
    }

    // $FF: renamed from: a (java.lang.Enum) void
    protected final void a(Enum var1) {
        this.method_1035(new byte[]{var1 == null?-1:NumberUtil.toByte(var1.ordinal())});
    }

    // $FF: renamed from: g () java.lang.String
    protected final String method_1024() {
        int var1 = this.method_1028();
        return var1 < 0?null:new String(this.method_1034(var1), StandardCharsets.UTF_8);
    }

    // $FF: renamed from: a (java.lang.String) void
    protected final void a(String var1) {
        if(var1 == null) {
            this.c(-1);
        } else {
            byte[] var2 = var1.getBytes(StandardCharsets.UTF_8);
            this.c(var2.length);
            this.method_1035(var2);
        }
    }

    // $FF: renamed from: h () boolean
    protected final boolean method_1026() {
        return this.method_1034(1)[0] != 0;
    }

    // $FF: renamed from: a (boolean) void
    protected final void a(boolean var1) {
        this.method_1035(new byte[]{(byte)(var1?1:0)});
    }

    // $FF: renamed from: i () int
    protected final int method_1028() {
        return ByteBuffer.wrap(this.method_1034(4)).order(field_813).getInt();
    }

    // $FF: renamed from: c (int) void
    protected final void c(int var1) {
        this.method_1035(ByteBuffer.allocate(4).order(field_813).putInt(var1).array());
    }

    // $FF: renamed from: j () long
    protected final long method_1030() {
        return ByteBuffer.wrap(this.method_1034(8)).order(field_813).getLong();
    }

    // $FF: renamed from: a (long) void
    protected final void a(long var1) {
        this.method_1035(ByteBuffer.allocate(8).order(field_813).putLong(var1).array());
    }

    // $FF: renamed from: k () double
    protected final double method_1032() {
        return Double.longBitsToDouble(this.method_1030());
    }

    // $FF: renamed from: a (double) void
    protected final void a(double var1) {
        this.a(Double.doubleToLongBits(var1));
    }

    // $FF: renamed from: d (int) byte[]
    protected final byte[] method_1034(int var1) {
        this.method_1037();

        try {
            return IOUtils.toByteArray(this.field_818, var1);
        } catch (IOException var3) {
            throw new class_177(String.format("Can\'t read %d bytes from input stream.", var1), var3);
        }
    }

    // $FF: renamed from: a (byte[]) void
    protected final void method_1035(byte[] var1) {
        this.method_1037();

        try {
            this.field_820.write(var1);
        } catch (IOException var3) {
            throw new class_177(String.format("Can\'t write %d bytes into output stream.", var1.length), var3);
        }
    }

    // $FF: renamed from: l () void
    protected final void method_1036() {
        this.method_1037();

        try {
            byte[] var1 = this.field_820.toByteArray();
            this.field_820.reset();
            this.field_819.write(var1);
            this.field_819.flush();
            if(this.field_822 != null) {
                this.field_822.write(var1);
            }

        } catch (IOException var2) {
            throw new class_177("Can\'t flush output stream.", var2);
        }
    }

    // $FF: renamed from: m () void
    private void method_1037() {
        if(this.field_814.get()) {
            throw new IllegalStateException(String.format("%s is stopped.", new Object[]{this.getClass()}));
        }
    }

    // $FF: renamed from: f () void
    public void method_65() {
        if(this.field_814.compareAndSet(false, true)) {
            IoUtil.closeQuietly(this.field_822, this.field_817, this.field_816);
        }
    }

    static {
        field_812 = IoUtil.BUFFER_SIZE;
        field_813 = ByteOrder.LITTLE_ENDIAN;
    }

    protected interface class_210<T> {
        // $FF: renamed from: a (java.lang.Object) void
        void method_12(T var1);
    }
}
