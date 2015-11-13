package com.codeforces.commons.io;

import com.codeforces.commons.io.LimitedByteArrayOutputStream;
import com.codeforces.commons.math.NumberUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class IoUtil {
    public static final int BUFFER_SIZE = NumberUtil.toInt(1048576L);

    public static byte[] toByteArray(InputStream var0) throws IOException {
        return toByteArray(var0, Integer.MAX_VALUE);
    }

    public static byte[] toByteArray(InputStream var0, int var1) throws IOException {
        return toByteArray(var0, var1, true);
    }

    public static byte[] toByteArray(InputStream var0, int var1, boolean var2) throws IOException {
        LimitedByteArrayOutputStream var3 = new LimitedByteArrayOutputStream(var1, var2);
        copy(var0, var3, true, true);
        return var3.toByteArray();
    }

    public static long copy(InputStream var0, OutputStream var1, boolean var2, boolean var3, int var4) throws IOException {
        try {
            long var5 = IOUtils.copyLarge(var0, var1, 0L, (long)var4, new byte[BUFFER_SIZE]);
            if(var2) {
                var0.close();
            }

            if(var3) {
                var1.close();
            }

            return var5;
        } catch (IOException var7) {
            if(var2) {
                closeQuietly((AutoCloseable)var0);
            }

            if(var3) {
                closeQuietly((AutoCloseable)var1);
            }

            throw var7;
        }
    }

    public static long copy(InputStream var0, OutputStream var1, boolean var2, boolean var3) throws IOException {
        return copy(var0, var1, var2, var3, Integer.MAX_VALUE);
    }

    public static long copy(InputStream var0, OutputStream var1) throws IOException {
        return copy(var0, var1, true, false);
    }

    public static void closeQuietly(AutoCloseable var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (Exception var2) {
                ;
            }
        }

    }

    public static void closeQuietly(AutoCloseable... var0) {
        AutoCloseable[] var1 = var0;
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AutoCloseable var4 = var1[var3];
            closeQuietly(var4);
        }

    }
}
