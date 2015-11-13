package com.codeforces.commons.compress;

import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.math.Math;
import com.google.common.primitives.Ints;
import de.schlichtherle.truezip.file.TFile;
import de.schlichtherle.truezip.file.TFileInputStream;
import de.schlichtherle.truezip.file.TVFS;
import de.schlichtherle.truezip.fs.FsSyncException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.zip.Deflater;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public final class ZipUtil {
    private static final int DEFAULT_BUFFER_SIZE = Ints.checkedCast(1048576L);

    public static byte[] compress(byte[] var0, int var1) {
        if(var0.length == 0) {
            return var0;
        } else {
            Deflater var2 = new Deflater();
            var2.setLevel(var1);
            var2.setInput(var0);
            var2.finish();
            ByteArrayOutputStream var3 = new ByteArrayOutputStream(var0.length);
            byte[] var4 = new byte[DEFAULT_BUFFER_SIZE];

            while(!var2.finished()) {
                var3.write(var4, 0, var2.deflate(var4));
            }

            IoUtil.closeQuietly((AutoCloseable)var3);
            return var3.toByteArray();
        }
    }

    public static void unzip(File var0, File var1) throws IOException {
        unzip(var0, var1, (FileFilter)null);
    }

    public static void unzip(File var0, File var1, FileFilter var2) throws IOException {
        try {
            FileUtil.ensureDirectoryExists(var1);
            ZipFile var3 = new ZipFile(var0);
            int var4 = 0;
            Iterator var5 = var3.getFileHeaders().iterator();

            while(true) {
                if(var5.hasNext()) {
                    Object var6 = var5.next();
                    if((long)var4 < 50000L) {
                        FileHeader var7 = (FileHeader)var6;
                        File var8 = new File(var1, var7.getFileName());
                        if(var2 != null && var2.accept(var8)) {
                            continue;
                        }

                        if(var7.isDirectory()) {
                            FileUtil.ensureDirectoryExists(var8);
                        } else {
                            if(var7.getUncompressedSize() > 536870912L || var7.getCompressedSize() > 536870912L) {
                                long var9 = Math.max(var7.getUncompressedSize(), var7.getCompressedSize());
                                throw new IOException("Entry \'" + var7.getFileName() + "\' is larger than " + var9 + " B.");
                            }

                            FileUtil.ensureDirectoryExists(var8.getParentFile());
                            var3.extractFile(var7, var1.getAbsolutePath());
                        }

                        ++var4;
                        continue;
                    }
                }

                return;
            }
        } catch (ZipException var11) {
            throw new IOException("Can\'t extract ZIP-file to directory.", var11);
        }
    }

    public static byte[] getZipEntryBytes(File var0, String var1) throws IOException {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        writeZipEntryBytes(var0, var1, var2);
        return var2.toByteArray();
    }

    public static void writeZipEntryBytes(File var0, String var1, OutputStream var2) throws IOException {
        TFile var3 = new TFile(new File(var0, var1));

        try {
            Object var4;
            if(var3.isArchive()) {
                synchronizeQuietly(var3);
                ZipFile var5 = new ZipFile(var0);
                var4 = var5.getInputStream(var5.getFileHeader(var1));
            } else {
                var4 = new TFileInputStream(var3);
            }

            IoUtil.copy((InputStream)var4, var2);
        } catch (ZipException var9) {
            throw new IOException("Can\'t write ZIP-entry bytes.", var9);
        } finally {
            IoUtil.closeQuietly((AutoCloseable)var2);
            synchronizeQuietly(var3);
        }

    }

    public static void synchronizeQuietly(TFile var0) {
        if(var0 != null) {
            TFile var1 = var0.getTopLevelArchive();

            try {
                if(var1 == null) {
                    TVFS.umount(var0);
                } else {
                    TVFS.umount(var1);
                }
            } catch (FsSyncException var3) {
                ;
            }
        }

    }
}
