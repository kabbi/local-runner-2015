package com.codeforces.commons.text;

import com.codeforces.commons.text.StringUtil;
import java.net.URI;
import org.apache.commons.validator.routines.UrlValidator;

public class UrlUtil {
    private static final String[] ALLOWED_SCHEMES = new String[]{"http", "https"};

    public static String appendParameterToUrl(String var0, String var1, String var2) {
        if(isValidUri(var0) && !StringUtil.isBlank(var1)) {
            String var3 = StringUtil.isBlank(var2)?var1:var1 + '=' + var2;
            int var4 = var0.indexOf(63);
            int var5 = var0.indexOf(35);
            if(var4 == -1 && var5 == -1) {
                return var0 + '?' + var3;
            } else if(var4 == -1 || var5 != -1 && var4 > var5) {
                return var0.substring(0, var5) + '?' + var3 + var0.substring(var5);
            } else {
                StringBuilder var6 = (new StringBuilder(var0.substring(0, var4 + 1))).append(var3);
                if(var0.length() > var4 + 1) {
                    var6.append('&').append(var0.substring(var4 + 1));
                }

                return var6.toString();
            }
        } else {
            return var0;
        }
    }

    public static boolean isValidUrl(String var0) {
        return isValidUrl(var0, ALLOWED_SCHEMES);
    }

    public static boolean isValidUrl(String var0, String[] var1) {
        if(StringUtil.isBlank(var0)) {
            return false;
        } else {
            UrlValidator var2 = new UrlValidator(var1, 8L);
            return var2.isValid(var0);
        }
    }

    public static boolean isValidUri(String var0) {
        if(var0 == null) {
            return false;
        } else {
            try {
                URI.create(var0);
                return true;
            } catch (RuntimeException var2) {
                return false;
            }
        }
    }
}
