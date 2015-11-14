package com.a.b;

import com.a.b.a.a.a.class_17;
import com.a.b.a.a.a.GameParatemers;
import com.google.inject.Guice;
import com.google.inject.Module;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.c
public final class class_32 implements Runnable {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_140 = LoggerFactory.getLogger(class_32.class);
    // $FF: renamed from: b java.lang.String[]
    private final String[] field_141;

    public class_32(String[] var1) {
        this.field_141 = var1;
    }

    public void run() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread var1, Throwable var2) {
                class_32.field_140.error("Got unexpected exception in thread \'" + var1 + "\'.", var2);
                var2.printStackTrace();
            }
        });
        GameParatemers var1 = null;

        try {
            var1 = new GameParatemers(this.field_141);
            GameParatemers.method_115(var1);
            class_1 var11 = (class_1)Guice.createInjector(new Module[]{new class_17()}).getInstance(class_1.class);

            try {
                var11.method_13(var1);
                var11.method_14();
            } finally {
                var11.method_15();
            }
        } catch (RuntimeException var10) {
            field_140.error("Got unexpected game exception.", var10);
            var10.printStackTrace();
            if(var1 == null) {
                return;
            }

            File var3 = var1.method_86();
            if(var3 == null) {
                return;
            }

            try {
                String var4 = "FAILED\n" + ExceptionUtils.getStackTrace(var10) + '\n';
                FileUtils.writeByteArrayToFile(var3, var4.getBytes(StandardCharsets.UTF_8));
            } catch (IOException var8) {
                field_140.error(String.format("Can\'t write results to file \'%s\'.", new Object[]{var3.getPath()}), var8);
            }
        }

    }
}
