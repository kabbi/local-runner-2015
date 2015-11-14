package com.a.b.a.a.a;

import com.a.a.a.a.class_121;
import com.a.b.a.a.b.e.class_86;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.pair.SimplePair;
import com.codeforces.commons.text.StringUtil;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.a.b
public class GameParatemers {
    // $FF: renamed from: b org.slf4j.Logger
    private static final Logger field_6 = LoggerFactory.getLogger(GameParatemers.class);
    // $FF: renamed from: a com.a.b.a.a.a.b
    public static final GameParatemers field_7 = new GameParatemers();
    // $FF: renamed from: c java.util.regex.Pattern
    private static final Pattern field_8 = Pattern.compile("[1-5][\\d]{4}");
    // $FF: renamed from: d java.util.regex.Pattern
    private static final Pattern field_9 = Pattern.compile("[1-9][0-9]{0,7}");
    // $FF: renamed from: e java.util.regex.Pattern
    private static final Pattern field_10 = Pattern.compile("[1-2]");
    // $FF: renamed from: f java.util.regex.Pattern
    private static final Pattern field_11 = Pattern.compile("[1-9][0-9]{0,3}x[1-9][0-9]{0,3}");
    // $FF: renamed from: g java.util.Map
    private final Map field_12;
    // $FF: renamed from: h java.util.List
    private final List field_13;
    // $FF: renamed from: i int
    private int field_14;
    // $FF: renamed from: j int
    private int field_15;
    // $FF: renamed from: k java.lang.Integer
    private Integer field_16;

    private GameParatemers() {
        this.field_12 = Collections.emptyMap();
        this.field_13 = Collections.emptyList();
    }

    public GameParatemers(String[] var1) {
        this(method_111(var1), method_112(var1));
    }

    public GameParatemers(Map var1, List var2) {
        this.field_12 = new HashMap(var1);
        this.field_13 = new ArrayList(var2);
        this.method_114();
        this.field_14 = method_108(this.field_12, true);
        this.field_15 = method_108(this.field_12, false);
        this.field_16 = method_109(this.field_12);
    }

    // $FF: renamed from: a () java.util.List
    public List method_73() {
        return Collections.unmodifiableList(this.field_13);
    }

    // $FF: renamed from: b () int
    public int method_74() {
        return this.field_14;
    }

    // $FF: renamed from: c () int
    public int method_75() {
        return this.field_15;
    }

    // $FF: renamed from: d () java.lang.String
    public String method_76() {
        String var1 = StringUtil.trimToNull((String)this.field_12.get("map"));
        return var1 == null?"default":var1;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_77(String var1) {
        var1 = StringUtil.trimToNull(var1);
        if(var1 == null) {
            this.field_12.remove("map");
        } else {
            this.field_12.put("map", FilenameUtils.getBaseName(var1));
        }

    }

    // $FF: renamed from: b (java.lang.String) com.a.b.a.a.b.e.i$a
    public class_86.class_206 method_78(String var1) {
        return class_86.method_502(var1, this.method_106());
    }

    // $FF: renamed from: e () com.a.b.a.a.b.e.i$a
    public class_86.class_206 method_79() {
        return this.method_78(this.method_76());
    }

    // $FF: renamed from: f () int
    public int method_80() {
        return this.method_79().method_413().length;
    }

    // $FF: renamed from: g () int
    public int method_81() {
        return this.method_79().method_413()[0].length;
    }

    // $FF: renamed from: h () int
    public int method_82() {
        return this.field_16 == null?180 + this.method_79().method_416() * 4: this.field_16;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_83(int var1) {
        String var2 = (String)this.field_12.get("p" + (var1 + 1) + "-name");
        return StringUtils.isBlank(var2)?"Player #" + (var1 + 1):var2;
    }

    // $FF: renamed from: b (int) int
    public int method_84(int var1) {
        field_6.debug("Parsing team size for player #" + (var1 + 1) + '.');
        String var2 = (String)this.field_12.get("p" + (var1 + 1) + "-team-size");
        if(StringUtils.isBlank(var2)) {
            return 2;
        } else if(!field_10.matcher(var2).matches()) {
            throw new IllegalArgumentException("Illegal team size value: \'" + var2 + "\'.");
        } else {
            return Integer.parseInt(var2);
        }
    }

    // $FF: renamed from: i () java.io.File
    public File method_85() {
        String var1 = (String)this.field_12.get("replay-file");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: j () java.io.File
    public File method_86() {
        String var1 = (String)this.field_12.get("results-file");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: k () java.io.File
    public File method_87() {
        String var1 = (String)this.field_12.get("strategy-description-file");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: l () java.io.File
    public File method_88() {
        String var1 = (String)this.field_12.get("attributes-file");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: m () java.io.File
    public File method_89() {
        String var1 = (String)this.field_12.get("plugins-directory");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: n () boolean
    public boolean method_90() {
        return method_110((String)this.field_12.get("debug"));
    }

    // $FF: renamed from: o () boolean
    public boolean method_91() {
        return method_110((String)this.field_12.get("render-to-screen"));
    }

    // $FF: renamed from: p () boolean
    public boolean method_92() {
        return method_110((String)this.field_12.get("render-to-screen-sync"));
    }

    // $FF: renamed from: q () boolean
    public boolean method_93() {
        return method_110((String)this.field_12.get("local-test"));
    }

    // $FF: renamed from: r () boolean
    public boolean method_94() {
        return method_110((String)this.field_12.get("verification-game"));
    }

    // $FF: renamed from: s () java.io.File
    public File method_95() {
        String var1 = (String)this.field_12.get("write-to-text-file");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: t () java.lang.String
    public String method_96() {
        return (String)this.field_12.get("write-to-remote-storage");
    }

    // $FF: renamed from: u () java.lang.String
    public String method_97() {
        return (String)this.field_12.get("system-user-login");
    }

    // $FF: renamed from: v () java.lang.String
    public String method_98() {
        return (String)this.field_12.get("system-user-password");
    }

    // $FF: renamed from: w () int
    public int method_99() {
        String var1 = (String)this.field_12.get("base-adapter-port");
        Preconditions.checkArgument(!StringUtils.isBlank(var1) && field_8.matcher(var1).matches(), "Argument \'base-adapter-port\' is expected to be an integer between 10000 and 59999 inclusive.");
        return Integer.parseInt(var1);
    }

    // $FF: renamed from: c (int) java.io.File
    public File method_100(int var1) {
        boolean var2 = method_110((String)this.field_12.get("dump-tcp-data"));
        return var2?new File("p" + (var1 + 1) + "-tcp-dump.bin"):null;
    }

    // $FF: renamed from: x () java.lang.Long
    public Long method_101() {
        String var1 = (String)this.field_12.get("seed");
        return StringUtils.isBlank(var1)?null: Long.parseLong(var1);
    }

    // $FF: renamed from: y () java.io.File
    public File method_102() {
        String var1 = (String)this.field_12.get("cache-directory");
        return StringUtil.isBlank(var1)?null:new File(var1);
    }

    // $FF: renamed from: z () boolean
    public boolean method_103() {
        return method_110((String)this.field_12.get("log-drifting"));
    }

    // $FF: renamed from: A () boolean
    public boolean method_104() {
        return method_110((String)this.field_12.get("log-max-speed"));
    }

    // $FF: renamed from: B () boolean
    public boolean method_105() {
        return method_110((String)this.field_12.get("swap-car-types"));
    }

    // $FF: renamed from: C () boolean
    public boolean method_106() {
        return method_110((String)this.field_12.get("loose-map-check"));
    }

    // $FF: renamed from: D () int
    public int method_107() {
        try {
            return Math.max(Math.min(Integer.parseInt((String)this.field_12.get("psycho-level")), 255), 0);
        } catch (NumberFormatException var2) {
            return 0;
        }
    }

    // $FF: renamed from: a (java.util.Map, boolean) int
    private static int method_108(Map var0, boolean var1) {
        String var2 = StringUtil.trimToNull((String)var0.get("render-to-screen-size"));
        if(var2 == null) {
            var2 = "1280x800";
        }

        int var3 = var2.indexOf(120);
        if(var3 > 0 && var3 != var2.length() - 1 && field_11.matcher(var2).matches()) {
            int var4 = Integer.parseInt(var1?var2.substring(0, var3):var2.substring(var3 + 1));
            if(var4 >= 100 && var4 <= 100000) {
                return var4;
            } else {
                throw new IllegalArgumentException(String.format("Illegal screen size dimension (%s): \'%d\'.", new Object[]{var1?"first":"second", Integer.valueOf(var4)}));
            }
        } else {
            throw new IllegalArgumentException("Illegal screen size value: \'" + var2 + "\'.");
        }
    }

    // $FF: renamed from: a (java.util.Map) java.lang.Integer
    private static Integer method_109(Map var0) {
        field_6.debug("Parsing tick count.");
        String var1 = StringUtil.trimToNull((String)var0.get("tick-count"));
        if(var1 != null && !"0".equals(var1) && !var1.startsWith("-")) {
            if(!field_9.matcher(var1).matches()) {
                throw new IllegalArgumentException("Illegal tick count value: \'" + var1 + "\'.");
            } else {
                return Integer.parseInt(var1);
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: c (java.lang.String) boolean
    private static boolean method_110(String var0) {
        return Boolean.parseBoolean(var0) || BooleanUtils.toBoolean(var0) || "1".equals(var0);
    }

    // $FF: renamed from: a (java.lang.String[]) java.util.Map
    private static Map method_111(String[] var0) {
        HashMap var1 = new HashMap();
        String[] var2 = var0;
        int var3 = var0.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            if(var5.startsWith("-")) {
                SimplePair var6 = method_113(var5.substring("-".length()));
                var1.put(var6.getFirst(), var6.getSecond());
            }
        }

        return var1;
    }

    // $FF: renamed from: b (java.lang.String[]) java.util.List
    private static List method_112(String[] var0) {
        ArrayList var1 = new ArrayList();
        String[] var2 = var0;
        int var3 = var0.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            if(!var5.startsWith("-")) {
                var1.add(var5);
            }
        }

        return var1;
    }

    // $FF: renamed from: d (java.lang.String) com.codeforces.commons.pair.SimplePair
    private static SimplePair method_113(String var0) {
        int var1 = var0.indexOf(61);
        if(var1 <= 0) {
            throw new IllegalArgumentException("Illegal property string: \'" + var0 + "\'.");
        } else {
            return new SimplePair(var0.substring(0, var1), var0.substring(var1 + 1));
        }
    }

    // $FF: renamed from: E () void
    private void method_114() {
        Iterator var1 = this.field_13.iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            if("#KeyboardPlayer".equals(var2)) {
                this.field_12.put("debug", "true");
                this.field_12.put("keyboard-player", "true");
                this.field_12.put("render-to-screen", "true");
                this.field_12.put("render-to-screen-sync", "true");
            } else if("#LocalTestPlayer".equals(var2)) {
                this.field_12.put("debug", "true");
                this.field_12.put("local-test", "true");
            }
        }

        if(StringUtils.isBlank((CharSequence)this.field_12.get("map"))) {
            this.field_12.put("map", "default.map");
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.a.b) void
    public static void method_115(GameParatemers var0) {
        Long var1 = var0.method_101();
        if(var1 == null) {
            var0.field_12.put("seed", String.valueOf(class_121.method_789()));
            var1 = var0.method_101();
        }

        class_121.method_790(true, var1.longValue());
        field_6.info("Starting game with seed \'" + var1 + "\'.");
    }
}
