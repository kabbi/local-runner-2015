package com.codeforces.commons.io.internal;

import com.codeforces.commons.compress.ZipUtil;
import com.codeforces.commons.io.IoUtil;
import com.google.common.primitives.Ints;
import de.schlichtherle.truezip.file.TFile;
import de.schlichtherle.truezip.file.TFileInputStream;
import de.schlichtherle.truezip.file.TVFS;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class UnsafeFileUtil {
    private static final Logger logger = Logger.getLogger(UnsafeFileUtil.class);

    private UnsafeFileUtil() {
        throw new UnsupportedOperationException();
    }

    public static void copyFile(File var0, File var1) throws IOException {
        internalCopyFile(var0, var1, true);
    }

    private static void internalCopyFile(File var0, File var1, boolean var2) throws IOException {
        if(var1 instanceof TFile) {
            throw new UnsupportedOperationException("Can\'t copy file into archive file.");
        } else {
            deleteTotally(var1);
            File var3 = var1.getParentFile();
            if(var3 != null) {
                ensureDirectoryExists(var3);
            }

            if(var0 instanceof TFile) {
                try {
                    writeFile(var1, getBytes(var0));
                } finally {
                    if(var2) {
                        ZipUtil.synchronizeQuietly((TFile)var0);
                    }

                }
            } else {
                if(!var0.isFile()) {
                    throw new IOException("\'" + var0 + "\' is not a file.");
                }

                FileInputStream var4 = null;
                FileOutputStream var5 = null;

                try {
                    var4 = new FileInputStream(var0);
                    var5 = new FileOutputStream(var1);
                    FileChannel var6 = var4.getChannel();
                    FileChannel var7 = var5.getChannel();
                    var6.transferTo(0L, var6.size(), var7);
                } finally {
                    IoUtil.closeQuietly(new AutoCloseable[]{var4, var5});
                }
            }

        }
    }

    public static void copyDirectory(File var0, File var1) throws IOException {
        internalCopyDirectory(var0, var1, true);
    }

    private static void internalCopyDirectory(File var0, File var1, boolean var2) throws IOException {
        if(var1 instanceof TFile) {
            throw new UnsupportedOperationException("Can\'t copy directory into archive file.");
        } else if(!var0.isDirectory()) {
            throw new IOException("\'" + var0 + "\' is not a directory.");
        } else if(var1.isFile()) {
            throw new IOException("\'" + var1 + "\' is a file.");
        } else {
            ensureDirectoryExists(var1);

            try {
                String[] var3 = var0.list();
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    Object var7 = var0 instanceof TFile?new TFile(var0, var6):new File(var0, var6);
                    File var8 = new File(var1, var6);
                    if(((File)var7).isDirectory()) {
                        TFile var9;
                        TFile var10;
                        if(var7 instanceof TFile && (var9 = (TFile)var7).isArchive() && (var10 = var9.getEnclArchive()) != null && (new File(var10.getAbsolutePath())).isFile()) {
                            deleteTotally(var8);
                            ZipUtil.synchronizeQuietly(var9);
                            ZipUtil.writeZipEntryBytes(var10, var9.getEnclEntryName(), new FileOutputStream(var8));
                        } else {
                            internalCopyDirectory((File)var7, var8, false);
                        }
                    } else {
                        internalCopyFile((File)var7, var8, false);
                    }
                }
            } finally {
                if(var2 && var0 instanceof TFile) {
                    ZipUtil.synchronizeQuietly((TFile)var0);
                }

            }

        }
    }

    public static File ensureDirectoryExists(File var0) throws IOException {
        if(!var0.isDirectory() && !var0.mkdirs() && !var0.isDirectory()) {
            throw new IOException("Can\'t create directory \'" + var0 + "\'.");
        } else {
            return var0;
        }
    }

    public static void deleteTotally(File var0) throws IOException {
        if(var0 != null) {
            Path var1 = Paths.get(var0.toURI());
            if(Files.exists(var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                if(Files.isSymbolicLink(var1)) {
                    if(!var0.delete() && Files.exists(var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                        throw new IOException("Can\'t delete symbolic link \'" + var0 + "\'.");
                    }
                } else if(var0.isFile()) {
                    if(!var0.delete() && var0.exists()) {
                        throw new IOException("Can\'t delete file \'" + var0 + "\'.");
                    }
                } else if(var0.isDirectory()) {
                    cleanDirectory(var0, (FileFilter)null);
                    if(!var0.delete() && var0.exists()) {
                        throw new IOException("Can\'t delete directory \'" + var0 + "\'.");
                    }
                } else if(Files.exists(var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                    throw new IllegalArgumentException("Unsupported file system item \'" + var0 + "\'.");
                }
            }

        }
    }

    private static void ensureParentDirectoryExists(File var0) throws IOException {
        File var1 = var0.getParentFile();
        if(var1 != null) {
            ensureDirectoryExists(var1);
        }

    }

    public static void cleanDirectory(File var0, FileFilter var1) throws IOException {
        if(!var0.isDirectory()) {
            throw new IllegalArgumentException("\'" + var0 + "\' is not a directory.");
        } else {
            File[] var2 = var0.listFiles();
            if(var2 == null) {
                throw new IOException("Failed to list files of \'" + var0 + "\'.");
            } else {
                int var3 = 0;

                for(int var4 = var2.length; var3 < var4; ++var3) {
                    File var5 = var2[var3];
                    if(var1 != null && !var1.accept(var5)) {
                        if(var5.isDirectory() && !Files.isSymbolicLink(Paths.get(var5.toURI()))) {
                            cleanDirectory(var5, var1);
                        }
                    } else {
                        deleteTotally(var5);
                    }
                }

            }
        }
    }

    public static void writeFile(File var0, byte[] var1) throws IOException {
        ensureParentDirectoryExists(var0);
        FileOutputStream var2 = null;

        try {
            var2 = new FileOutputStream(var0);
            var2.write(var1);
        } finally {
            IoUtil.closeQuietly((AutoCloseable)var2);
        }

    }

    public static byte[] getBytes(File var0) throws IOException {
        if(var0 instanceof TFile) {
            TFile var1 = (TFile)var0;

            byte[] var6;
            try {
                if(!var1.isFile()) {
                    if(!var1.isArchive()) {
                        throw new FileNotFoundException("\'" + var0 + "\' is not file.");
                    }

                    TVFS.umount(var1);
                    var0 = new File(var0.getAbsolutePath());
                    if(var0.isFile()) {
                        byte[] var11 = forceGetBytesFromExistingRegularFile(var0);
                        return var11;
                    }

                    TFile var10 = var1.getEnclArchive();
                    if(var10 == null || !(new File(var10.getAbsolutePath())).isFile()) {
                        throw new FileNotFoundException("\'" + var0 + "\' is not file.");
                    }

                    byte[] var3 = ZipUtil.getZipEntryBytes(var10, var1.getEnclEntryName());
                    return var3;
                }

                long var2 = var0.length();
                TFileInputStream var4 = new TFileInputStream(var0);
                byte[] var5 = new byte[Ints.checkedCast(var2)];
                IOUtils.read(var4, var5);
                var4.close();
                var6 = var5;
            } finally {
                TVFS.umount(var1);
            }

            return var6;
        } else if(var0.isFile()) {
            return forceGetBytesFromExistingRegularFile(var0);
        } else {
            throw new FileNotFoundException("\'" + var0 + "\' is not file.");
        }
    }

    private static byte[] forceGetBytesFromExistingRegularFile(File var0) throws IOException {
        long var1 = var0.length();
        FileInputStream var3 = new FileInputStream(var0);
        FileChannel var4 = var3.getChannel();
        ByteBuffer var5 = ByteBuffer.allocate(Ints.checkedCast(var1));
        var4.read(var5);
        var4.close();
        var3.close();
        return var5.array();
    }
}
