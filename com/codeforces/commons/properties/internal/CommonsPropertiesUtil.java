package com.codeforces.commons.properties.internal;

import com.codeforces.commons.properties.PropertiesUtil;
import java.util.List;

public class CommonsPropertiesUtil {
    private static final String[] RESOURCE_NAMES = new String[]{"/com/codeforces/commons/properties/commons.properties", "/com/codeforces/commons/properties/commons_default.properties"};

    public static String getProperty(String var0, String var1) {
        return PropertiesUtil.getPropertyQuietly(var0, var1, RESOURCE_NAMES);
    }

    public static List getListProperty(String var0, String var1) {
        return PropertiesUtil.getListPropertyQuietly(var0, var1, RESOURCE_NAMES);
    }

    public static List getSecurePasswords() {
        return CommonsPropertiesUtil.PropertyValuesHolder.SECURE_PASSWORDS;
    }

    public static List getSecureHosts() {
        return CommonsPropertiesUtil.PropertyValuesHolder.SECURE_HOSTS;
    }

    public static boolean isBypassCertificateCheck() {
        return CommonsPropertiesUtil.PropertyValuesHolder.BYPASS_CERTIFICATE_CHECK;
    }

    public static List getPrivateParameters() {
        return CommonsPropertiesUtil.PropertyValuesHolder.PRIVATE_PARAMETERS;
    }

    private static final class PropertyValuesHolder {
        private static final String TEMP_DIR_NAME = CommonsPropertiesUtil.getProperty("temp-dir.name", "temp");
        private static final List SECURE_PASSWORDS = CommonsPropertiesUtil.getListProperty("security.secure-passwords", "");
        private static final List SECURE_HOSTS = CommonsPropertiesUtil.getListProperty("security.secure-hosts", "");
        private static final boolean BYPASS_CERTIFICATE_CHECK = Boolean.parseBoolean(CommonsPropertiesUtil.getProperty("security.secure-hosts.bypass-certificate-check", "false"));
        private static final List PRIVATE_PARAMETERS = CommonsPropertiesUtil.getListProperty("security.private-parameters", "");
        private static final String SUBSCRIPTION_TOKEN = CommonsPropertiesUtil.getProperty("security.subscription-token", "secret");
    }
}
