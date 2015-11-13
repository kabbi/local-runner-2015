package com.codeforces.commons.properties;

import com.codeforces.commons.resource.CantReadResourceException;
import com.codeforces.commons.text.Patterns;
import com.codeforces.commons.text.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.log4j.Logger;

public class PropertiesUtil {
    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);
    private static final ConcurrentMap propertiesByResourceName = new ConcurrentHashMap();

    private PropertiesUtil() {
        throw new UnsupportedOperationException();
    }

    public static String getProperty(boolean var0, String var1, String var2, String... var3) throws CantReadResourceException {
        String[] var4 = var3;
        int var5 = var3.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];

            Properties var8;
            try {
                var8 = ensurePropertiesByResourceName(var7);
            } catch (IOException var11) {
                String var10 = String.format("Can\'t read properties from resource \'%s\'.", new Object[]{var7});
                if(var0) {
                    logger.error(var10, var11);
                    throw new CantReadResourceException(var10, var11);
                }

                logger.warn(var10, var11);
                continue;
            }

            String var9 = var8.getProperty(var1);
            if(var9 != null) {
                return var9;
            }
        }

        return var2;
    }

    public static String getPropertyQuietly(String var0, String var1, String... var2) {
        return getProperty(false, var0, var1, var2);
    }

    public static List getListProperty(boolean var0, String var1, String var2, String... var3) {
        String var4 = getProperty(var0, var1, var2, var3);
        return StringUtil.isBlank(var4)?Collections.emptyList():Collections.unmodifiableList(Arrays.asList(Patterns.SEMICOLON_PATTERN.split(var4)));
    }

    public static List getListPropertyQuietly(String var0, String var1, String... var2) {
        return getListProperty(false, var0, var1, var2);
    }

    private static Properties ensurePropertiesByResourceName(String var0) throws IOException {
        Properties var1 = (Properties)propertiesByResourceName.get(var0);
        if(var1 == null) {
            var1 = new Properties();
            InputStream var2 = PropertiesUtil.class.getResourceAsStream(var0);
            Throwable var3 = null;

            try {
                if(var2 != null) {
                    var1.load(new InputStreamReader(var2, StandardCharsets.UTF_8));
                } else {
                    logger.warn(String.format("Can\'t find resource file \'%s\'.", new Object[]{var0}));
                }
            } catch (Throwable var12) {
                var3 = var12;
                throw var12;
            } finally {
                if(var2 != null) {
                    if(var3 != null) {
                        try {
                            var2.close();
                        } catch (Throwable var11) {
                            var3.addSuppressed(var11);
                        }
                    } else {
                        var2.close();
                    }
                }

            }

            propertiesByResourceName.putIfAbsent(var0, var1);
            var1 = (Properties)propertiesByResourceName.get(var0);
        }

        return var1;
    }
}
