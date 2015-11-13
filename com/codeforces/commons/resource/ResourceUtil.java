package com.codeforces.commons.resource;

import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.resource.CantReadResourceException;
import com.google.common.io.Resources;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class ResourceUtil {
    private static final Logger logger = Logger.getLogger(ResourceUtil.class);
    private static final ConcurrentMap cacheLockByDirectory = new ConcurrentHashMap();
    private static final ConcurrentMap validationResultByCacheKey = new ConcurrentHashMap();

    public static byte[] getResource(Class var0, String var1) {
        InputStream var2 = var0.getResourceAsStream(var1);
        if(var2 == null) {
            throw new CantReadResourceException("Can\'t find resource \'" + var1 + "\' for " + var0 + '.');
        } else {
            try {
                return IoUtil.toByteArray(var2);
            } catch (IOException var4) {
                throw new CantReadResourceException("Can\'t read resource \'" + var1 + "\' for " + var0 + '.', var4);
            }
        }
    }

    public static byte[] getResourceOrNull(Class var0, String var1) {
        try {
            return getResource(var0, var1);
        } catch (CantReadResourceException var3) {
            return null;
        }
    }

    public static void copyResourceToDir(File var0, File var1, String var2, byte[] var3, Class var4, boolean var5) throws IOException {
        File var6 = new File(var0, (new File(var2)).getName());
        if(var1 == null) {
            saveResourceToFile(var6, var2, var3, var4);
        } else {
            File var7 = new File(var1, toRelativePath(var2));
            ReadWriteLock var8 = (ReadWriteLock)cacheLockByDirectory.get(var1);
            if(var8 == null) {
                cacheLockByDirectory.putIfAbsent(var1, new ReentrantReadWriteLock());
                var8 = (ReadWriteLock)cacheLockByDirectory.get(var1);
            }

            Lock var10 = var8.readLock();
            var10.lock();

            boolean var9;
            try {
                var9 = isCacheEntryValid(var7, var2, var3, var4, var5);
            } finally {
                var10.unlock();
            }

            if(!var9) {
                Lock var11 = var8.writeLock();
                var11.lock();

                try {
                    if(!isCacheEntryValid(var7, var2, var3, var4, var5)) {
                        writeCacheEntry(var7, var2, var3, var4);
                    }
                } finally {
                    var11.unlock();
                }
            }

            try {
                FileUtil.createSymbolicLinkOrCopy(var7, var6);
            } catch (IOException var19) {
                throw new IOException(String.format("Can\'t create symbolic link or copy resource \'%s\' into the directory \'%s\'.", new Object[]{var2, var0}), var19);
            }
        }

    }

    private static boolean isCacheEntryValid(File var0, String var1, byte[] var2, Class var3, boolean var4) throws IOException {
        if(!var0.isFile()) {
            return false;
        } else {
            Class var5 = var3 == null?ResourceUtil.class:var3;
            ResourceUtil.CacheKey var6 = new ResourceUtil.CacheKey(var1, var2, var3, null);
            Boolean var7;
            if(var4) {
                var7 = (Boolean)validationResultByCacheKey.get(var6);
                if(var7 != null && var7) {
                    long var8 = Resources.asByteSource(var5.getResource(var1)).size();
                    if(var0.length() == var8) {
                        return true;
                    }
                }
            }

            var7 = null;
            BufferedInputStream var12 = null;

            try {
                Object var11 = var2 == null?new BufferedInputStream(var5.getResourceAsStream(var1), IoUtil.BUFFER_SIZE):new ByteArrayInputStream(var2);
                var12 = new BufferedInputStream(new FileInputStream(var0), IoUtil.BUFFER_SIZE);
                boolean var9 = IOUtils.contentEquals((InputStream)var11, var12);
                if(var9) {
                    validationResultByCacheKey.putIfAbsent(var6, true);
                }

                ((InputStream)var11).close();
                var12.close();
                return var9;
            } catch (IOException var10) {
                IoUtil.closeQuietly(var12);
                throw new IOException(String.format("Can\'t compare resource \'%s\' and cache file \'%s\'.", var1, var0), var10);
            }
        }
    }

    private static void writeCacheEntry(File var0, String var1, byte[] var2, Class var3) throws IOException {
        logger.info(String.format("Saving resource \'%s\' to the cache file \'%s\'.", var1, var0));

        try {
            FileUtil.deleteTotally(var0);
        } catch (IOException var6) {
            throw new IOException(String.format("Can\'t delete invalid cache file \'%s\'.", var0), var6);
        }

        try {
            FileUtil.ensureParentDirectoryExists(var0);
        } catch (IOException var5) {
            throw new IOException(String.format("Can\'t create cache directory \'%s\'.", new Object[]{var0.getParentFile()}), var5);
        }

        saveResourceToFile(var0, var1, var2, var3);
    }

    public static void saveResourceToFile(File var0, String var1, byte[] var2, Class var3) throws IOException {
        InputStream var4 = null;
        BufferedOutputStream var5 = null;

        try {
            if(var2 == null) {
                var4 = (var3 == null?FileUtil.class:var3).getResourceAsStream(var1);
                if(var4 == null) {
                    throw new IOException("Can\'t find resource \'" + var1 + "\'.");
                }

                var5 = new BufferedOutputStream(new FileOutputStream(var0));
                IoUtil.copy(var4, var5);
                var4.close();
                var5.close();
            } else {
                FileUtil.writeFile(var0, var2);
            }
        } catch (IOException var10) {
            IoUtil.closeQuietly(var4, var5);
            throw new IOException(String.format("Can\'t save resource \'%s\' to the file \'%s\'.", var1, var0), var10);
        } finally {
            if(var1 != null) {
                validationResultByCacheKey.putIfAbsent(new ResourceUtil.CacheKey(var1, var2, var3, null), true);
            }

        }

    }

    private static String toRelativePath(String var0) {
        while(var0.startsWith(File.separator)) {
            var0 = var0.substring(File.separator.length());
        }

        while(ResourceUtil.SeparatorHolder.SEPARATOR != null && var0.startsWith(ResourceUtil.SeparatorHolder.SEPARATOR)) {
            var0 = var0.substring(ResourceUtil.SeparatorHolder.SEPARATOR.length());
        }

        while(var0.startsWith("/")) {
            var0 = var0.substring("/".length());
        }

        while(var0.startsWith("\\")) {
            var0 = var0.substring("\\".length());
        }

        return var0;
    }

    private static final class SeparatorHolder {
        private static final String SEPARATOR;

        static {
            String var0;
            try {
                FileSystem var1 = FileSystems.getDefault();
                var0 = var1 == null?null:var1.getSeparator();
            } catch (RuntimeException var2) {
                ResourceUtil.logger.fatal("Can\'t get path separator.", var2);
                var0 = null;
            }

            SEPARATOR = var0;
        }
    }

    private static final class CacheKey {
        private final String sha1;

        private CacheKey(String var1, byte[] var2, Class var3) {
            String var4 = var2 == null?"":DigestUtils.sha1Hex(var2);
            String var5 = var3 == null?"":var3.getCanonicalName();
            this.sha1 = DigestUtils.sha1Hex(var1 + '\u0001' + var4 + '\u0002' + var5);
        }

        public boolean equals(Object var1) {
            if(this == var1) {
                return true;
            } else if(var1 != null && this.getClass() == var1.getClass()) {
                ResourceUtil.CacheKey var2 = (ResourceUtil.CacheKey)var1;
                return this.sha1.equals(var2.sha1);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.sha1.hashCode();
        }

        // $FF: synthetic method
        CacheKey(String var1, byte[] var2, Class var3, Object var4) {
            this(var1, var2, var3);
        }
    }
}
