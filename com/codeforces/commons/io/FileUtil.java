package com.codeforces.commons.io;

import com.codeforces.commons.io.internal.UnsafeFileUtil;
import com.codeforces.commons.process.ThreadUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

public class FileUtil {
    private FileUtil() {
        throw new UnsupportedOperationException();
    }

    public static Object executeIoOperation(ThreadUtil.Operation var0) throws IOException {
        return executeIoOperation(var0, 9);
    }

    public static Object executeIoOperation(ThreadUtil.Operation var0, int var1) throws IOException {
        return executeIoOperation(var0, var1, 50L, ThreadUtil.ExecutionStrategy.Type.SQUARE);
    }

    public static Object executeIoOperation(ThreadUtil.Operation var0, int var1, long var2, ThreadUtil.ExecutionStrategy.Type var4) throws IOException {
        try {
            return ThreadUtil.execute(var0, var1, new ThreadUtil.ExecutionStrategy(var2, var4));
        } catch (Error | RuntimeException var6) {
            throw var6;
        } catch (Throwable var7) {
            throw new IOException(var7);
        }
    }

    public static File ensureDirectoryExists(final File var0) throws IOException {
        return (File)executeIoOperation(new ThreadUtil.Operation() {
            public File run() throws IOException {
                return UnsafeFileUtil.ensureDirectoryExists(var0);
            }
        });
    }

    public static File ensureParentDirectoryExists(File var0) throws IOException {
        final File var1 = var0.getParentFile();
        return var1 == null?null:(File)executeIoOperation(new ThreadUtil.Operation() {
            public File run() throws IOException {
                return UnsafeFileUtil.ensureDirectoryExists(var1);
            }
        });
    }

    public static void deleteTotally(final File var0) throws IOException {
        executeIoOperation(new ThreadUtil.Operation() {
            public Void run() throws IOException {
                UnsafeFileUtil.deleteTotally(var0);
                return null;
            }
        });
    }

    public static void writeFile(final File var0, final byte[] var1) throws IOException {
        executeIoOperation(new ThreadUtil.Operation() {
            public Void run() throws IOException {
                UnsafeFileUtil.writeFile(var0, var1);
                return null;
            }
        });
    }

    public static boolean isFile(File var0) {
        return var0 != null && var0.isFile();
    }

    public static boolean isDirectory(File var0) {
        return var0 != null && var0.isDirectory();
    }

    public static void createSymbolicLinkOrCopy(File var0, File var1) throws IOException {
        if(!var0.exists()) {
            throw new IOException("Source \'" + var0 + "\' doesn\'t exist.");
        } else {
            deleteTotally(var1);
            ensureParentDirectoryExists(var1);

            try {
                Files.createSymbolicLink(FileSystems.getDefault().getPath(var1.getAbsolutePath(), new String[0]), FileSystems.getDefault().getPath(var0.getAbsolutePath(), new String[0]), new FileAttribute[0]);
            } catch (UnsupportedOperationException var3) {
                if(isFile(var0)) {
                    UnsafeFileUtil.copyFile(var0, var1);
                } else {
                    if(!isDirectory(var0)) {
                        throw new IOException("Unexpected source \'" + var0 + "\'.");
                    }

                    UnsafeFileUtil.copyDirectory(var0, var1);
                }
            }

        }
    }
}
