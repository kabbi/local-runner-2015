package com.a.b.a.a.b;

import com.a.a.a.a.RandomUtils;
import com.a.b.GameSimulator;
import com.a.b.class_2;
import com.a.b.class_3;
import com.a.b.class_42;
import com.a.b.a.a.a.class_16;
import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.b.class_19;
import com.a.b.a.a.b.b.class_20;
import com.a.b.a.a.b.b.class_21;
import com.a.b.a.a.b.b.class_22;
import com.a.b.a.a.b.b.class_23;
import com.a.b.a.a.b.b.class_24;
import com.a.b.a.a.b.b.class_25;
import com.a.b.a.a.b.b.class_26;
import com.a.b.a.a.b.c.class_35;
import com.a.b.a.a.b.c.class_36;
import com.a.b.a.a.b.c.class_37;
import com.a.b.a.a.b.c.class_38;
import com.a.b.a.a.b.c.class_39;
import com.a.b.a.a.b.c.class_40;
import com.a.b.a.a.b.c.class_41;
import com.a.b.a.a.b.d.a.class_47;
import com.a.b.a.a.b.d.b.class_51;
import com.a.b.a.a.b.d.b.a.a.class_57;
import com.a.b.a.a.b.d.b.a.b.class_55;
import com.a.b.a.a.b.d.b.b.class_53;
import com.a.b.a.a.b.d.c.class_43;
import com.a.b.a.a.b.d.c.class_44;
import com.a.b.a.a.b.d.c.class_45;
import com.a.b.a.a.b.d.d.class_46;
import com.a.b.a.a.b.d.e.class_48;
import com.a.b.a.a.b.d.e.class_49;
import com.a.b.a.a.b.d.e.class_50;
import com.a.b.a.a.b.e.class_72;
import com.a.b.a.a.b.e.class_77;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.b.e.class_84;
import com.a.b.a.a.b.e.class_85;
import com.a.b.a.a.b.e.MapUtils;
import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.class_138;
import com.a.b.a.a.c.TileType;
import com.a.b.a.a.c.class_143;
import com.a.b.a.a.c.BonusType;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;
import com.a.b.a.a.d.class_101;
import com.a.b.a.a.d.class_5;
import com.a.b.a.a.d.class_96;
import com.a.b.a.a.d.class_97;
import com.a.b.a.a.e.a.class_11;
import com.a.b.a.a.e.a.class_180;
import com.a.c.class_159;
import com.codeforces.commons.compress.ZipUtil;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.holder.Mutable;
import com.codeforces.commons.holder.Readable;
import com.codeforces.commons.holder.SimpleMutable;
import com.codeforces.commons.holder.Writable;
import com.codeforces.commons.io.IoUtil;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.pair.IntPair;
import com.codeforces.commons.text.StringUtil;
import com.google.common.base.Preconditions;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.b.a
public class GameSimulatorImpl implements GameSimulator {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(GameSimulatorImpl.class);
    // $FF: renamed from: b com.a.b.h
    @Inject
    private class_3 field_721;
    // $FF: renamed from: c com.a.b.a.a.a.b
    private GameProperties gameProperties;
    // $FF: renamed from: d com.a.b.a.a.b.e.i$a
    private MapUtils.Map field_723;
    // $FF: renamed from: e com.codeforces.commons.pair.IntPair[]
    private IntPair[] field_724;
    // $FF: renamed from: f java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_725;
    // $FF: renamed from: g java.util.concurrent.atomic.AtomicReference
    private final AtomicReference field_726;
    // $FF: renamed from: h int
    private int field_727;
    // $FF: renamed from: i int
    private int field_728;
    // $FF: renamed from: j int
    private int field_729;
    // $FF: renamed from: k int
    private int field_730;
    // $FF: renamed from: l java.lang.Integer
    private Integer field_731;
    // $FF: renamed from: m int
    private int field_732;
    // $FF: renamed from: n java.util.List
    private final List field_733;
    // $FF: renamed from: o java.util.Map
    private final java.util.Map field_734;
    // $FF: renamed from: p java.util.List
    private final List field_735;
    // $FF: renamed from: q java.util.List
    private final List field_736;
    // $FF: renamed from: r java.util.List
    private final List field_737;
    // $FF: renamed from: s java.util.concurrent.ExecutorService
    private ExecutorService field_738;
    // $FF: renamed from: t long
    private long startTime;
    // $FF: renamed from: u boolean
    private boolean hasReplayFile;
    // $FF: renamed from: v java.io.BufferedReader
    private BufferedReader replayFileReader;
    // $FF: renamed from: w com.a.b.a.a.c.h
    private class_138 field_742;

    public GameSimulatorImpl() {
        this.gameProperties = GameProperties.instance;
        this.field_725 = new AtomicBoolean(false);
        this.field_726 = new AtomicReference(null);
        this.field_733 = new ArrayList();
        this.field_734 = new LinkedHashMap();
        this.field_735 = new ArrayList();
        this.field_736 = new ArrayList();
        this.field_737 = new ArrayList();
    }

    // $FF: renamed from: a (com.a.b.a.a.a.b) void
    public void init(GameProperties gameProperties) {
        logger.info("Game has been started.");
        this.startTime = System.currentTimeMillis();
        this.gameProperties = gameProperties;
        this.hasReplayFile = gameProperties.getReplayFile() != null;
        if(this.hasReplayFile) {
            try {
                this.replayFileReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(gameProperties.getReplayFile())), StandardCharsets.UTF_8));
            } catch (IOException e) {
                this.method_965(String.format("Can\'t open log file: %s", ExceptionUtils.getStackTrace(e)));
                return;
            }

            if((this.field_742 = this.method_966()) != null) {
                this.gameProperties.method_77(this.field_742.getMapName());
            }
        }

        this.method_953();
        this.field_729 = gameProperties.method_82();
        this.field_732 = this.field_729 - 1;
        this.method_954();
        this.method_955();
        if(!this.hasReplayFile) {
            this.method_956();
            this.method_957();
            this.method_958();
            this.method_959();
            this.method_961();
            this.method_962();
        }

        logger.info("Game has been initialized.");
    }

    // $FF: renamed from: a () void
    public void start() {
        for(this.field_730 = 0; (this.hasReplayFile || this.field_730 <= this.field_732) && !this.field_725.get() && (this.hasReplayFile || !this.method_964()); ++this.field_730) {
            this.method_944(false);
            if(this.hasReplayFile) {
                this.field_742 = this.method_966();
                if(this.field_742 == null || this.field_742.isLastTick()) {
                    break;
                }

                this.field_732 = this.field_742.getLastTickIndex();
            } else {
                this.method_945();
                this.method_947();
                this.field_721.method_22(this.field_730);
                this.method_948();
            }
        }

        this.method_944(true);
    }

    // $FF: renamed from: b () void
    public void shutdown() {
        logger.info("Game has been finished in " + (System.currentTimeMillis() - this.startTime) + " ms.");
        Iterator var1;
        if(this.gameProperties.shouldLogMaxSpeed()) {
            var1 = this.field_734.values().iterator();

            while(var1.hasNext()) {
                List var2 = (List)var1.next();

                for (Object aVar2 : var2) {
                    class_43 var4 = (class_43) aVar2;
                    double var5 = this.field_730 > 180 ? var4.method_291() / (double) (this.field_730 - 180) : 0.0D;
                    logger.info(String.format("Average speed of %s is %.2f per tick.", var4, var5));
                    logger.info(String.format("Max speed of %s is %.2f per tick (tick=%d).", var4, var4.method_281(), var4.method_282()));
                    logger.info(String.format("Max angular speed of %s is %.3f/%.1f° per tick (tick=%d).", var4, var4.method_284(), var4.method_284() * 57.29577951308232D, var4.method_285()));
                }
            }
        }

        var1 = this.field_734.keySet().iterator();

        while(var1.hasNext()) {
            class_171 var7 = (class_171)var1.next();
            logger.info("Player \'" + var7.method_918() + "\' scored " + var7.method_928() + " point(s).");
        }

        if(!this.hasReplayFile) {
            this.method_935();
        }

        this.method_936();
        if(!this.hasReplayFile) {
            this.method_937();
            this.method_938();
            this.method_939();
        }

    }

    // $FF: renamed from: c () void
    private void method_935() {
        Iterator var1 = this.field_734.keySet().iterator();

        while(var1.hasNext()) {
            class_171 var2 = (class_171)var1.next();
            IoUtil.closeQuietly(var2.method_920());
        }

    }

    // $FF: renamed from: d () void
    private void method_936() {
        Iterator var1 = this.field_733.iterator();

        while(var1.hasNext()) {
            class_5 var2 = (class_5)var1.next();

            try {
                var2.close();
            } catch (IOException var4) {
                logger.error(String.format("Can\'t close renderer \'%s\'.", new Object[]{var2.getClass().getSimpleName()}), var4);
                this.method_965(String.format("Can\'t close renderer \'%s\': %s", var2.getClass().getSimpleName(), ExceptionUtils.getStackTrace(var4)));
            }
        }

    }

    // $FF: renamed from: e () void
    private void method_937() {
        File var1 = this.gameProperties.getStrategyDescriptionFile();
        if(var1 != null) {
            try {
                StringBuilder var2 = new StringBuilder();
                Iterator var3 = this.field_734.entrySet().iterator();

                while(var3.hasNext()) {
                    Entry var4 = (Entry)var3.next();
                    boolean var5 = true;

                    class_43 var7;
                    for(Iterator var6 = ((List)var4.getValue()).iterator(); var6.hasNext(); var2.append(var7.method_344() == null?-1: var7.method_344())) {
                        var7 = (class_43)var6.next();
                        if(var5) {
                            var5 = false;
                        } else {
                            var2.append(',');
                        }
                    }

                    var2.append('\n');
                }

                FileUtils.writeByteArrayToFile(var1, var2.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException var8) {
                logger.error(String.format("Can\'t write strategy descriptions to file \'%s\'.", new Object[]{var1.getPath()}), var8);
            }

        }
    }

    // $FF: renamed from: f () void
    private void method_938() {
        File var1 = this.gameProperties.getAttributesFile();
        if(var1 != null) {
            try {
                HashMap var2 = new HashMap();
                var2.put("map", this.gameProperties.getMapFilePath());
                if(this.gameProperties.shouldSwapCarTypes()) {
                    var2.put("swap-car-types", Boolean.toString(this.gameProperties.shouldSwapCarTypes()));
                }

                byte[] var3 = (new GsonBuilder()).create().toJson(var2).getBytes(StandardCharsets.UTF_8);
                FileUtils.writeByteArrayToFile(var1, var3);
            } catch (IOException var4) {
                logger.error(String.format("Can\'t write attributes to file \'%s\'.", new Object[]{var1.getPath()}), var4);
            }

        }
    }

    // $FF: renamed from: g () void
    private void method_939() {
        File var1 = this.gameProperties.getResultsFile();
        if(var1 != null) {
            try {
                StringBuilder var2 = new StringBuilder();
                if(this.field_725.get()) {
                    logger.error("Game has failed with the message: " + this.field_726.get());
                    var2.append("FAILED\n").append((String)this.field_726.get()).append('\n');
                } else {
                    var2.append("OK\nSEED ").append(this.gameProperties.getSeed()).append('\n');
                    java.util.Map var3 = this.method_943();

                    for(Iterator var4 = this.field_734.keySet().iterator(); var4.hasNext(); var2.append('\n')) {
                        class_171 var5 = (class_171)var4.next();
                        var2.append(var3.get(var5.method_928())).append(' ').append(var5.method_928()).append(var5.method_922()?" CRASHED":" OK");
                        if(!this.gameProperties.isLocalTestGame()) {
                            String var6 = this.method_940(var5);
                            if(!StringUtil.isBlank(var6)) {
                                var2.append(' ').append(Base64.encodeBase64URLSafeString(ZipUtil.compress(var6.getBytes(StandardCharsets.UTF_8), 9)));
                            }
                        }
                    }
                }

                FileUtils.writeByteArrayToFile(var1, var2.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException var7) {
                logger.error(String.format("Can\'t write results to file \'%s\'.", new Object[]{var1.getPath()}), var7);
            }

        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.n) java.lang.String
    private String method_940(class_171 var1) {
        StringBuilder var2 = new StringBuilder();
        if(!StringUtil.isEmpty(var1.method_923())) {
            var2.append(var1.method_923());
        }

        if(var1.method_920() instanceof class_180) {
            File var3 = ((class_180)var1.method_920()).method_978();
            if(var3 != null) {
                method_941(var2, "Вывод runner\'а в stdout:", var3, "runexe.output");
                method_941(var2, "Вывод runner\'а в stderr:", var3, "runexe.error");
                if(this.gameProperties.isVerificationGame()) {
                    method_941(var2, "Вывод стратегии в stdout:", var3, "process.output");
                    method_941(var2, "Вывод стратегии в stderr:", var3, "process.error");
                }
            }
        }

        return var2.toString();
    }

    // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, java.io.File, java.lang.String) void
    private static void method_941(StringBuilder var0, String var1, File var2, String var3) {
        String var4 = method_942(new File(var2, var3));
        if(!StringUtil.isBlank(var4)) {
            if(var0.length() > 0) {
                var0.append("\r\n\r\n");
            }

            var0.append(var1).append("\r\n").append(var4);
        }

    }

    // $FF: renamed from: a (java.io.File) java.lang.String
    private static String method_942(File var0) {
        if(!var0.isFile()) {
            return "";
        } else {
            List var1;
            try {
                var1 = FileUtils.readLines(var0, Charsets.UTF_8);

                while(!var1.isEmpty() && StringUtil.isBlank((String)var1.get(0))) {
                    var1.remove(0);
                }

                while(!var1.isEmpty() && StringUtil.isBlank((String)var1.get(var1.size() - 1))) {
                    var1.remove(var1.size() - 1);
                }

                if(var1.isEmpty()) {
                    return "";
                }
            } catch (IOException var3) {
                logger.error("Can\'t read file \'" + var0.getAbsolutePath() + "\'.", var3);
                return "";
            }

            return StringUtils.join(StringUtil.shrinkLinesTo(var1, 100, 17), "\r\n");
        }
    }

    // $FF: renamed from: h () java.util.Map
    private java.util.Map method_943() {
        HashMap var1 = new HashMap();
        ArrayList var2 = new ArrayList(this.field_734.keySet());
        Collections.sort(var2, class_72.method_455());

        for(int var3 = var2.size() - 1; var3 >= 0; --var3) {
            var1.put(Integer.valueOf(((class_171)var2.get(var3)).method_928()), Integer.valueOf(var3 + 1));
        }

        return var1;
    }

    // $FF: renamed from: a (boolean) void
    private void method_944(boolean var1) {
        ArrayList var2 = new ArrayList(this.field_734.keySet());
        List var3 = this.field_721.method_19();
        List var4 = this.field_721.method_21();
        double var5 = 1.0D / (double)this.field_721.method_24();
        class_138 var7;
        if(this.field_742 == null) {
            var7 = class_77.method_462(class_77.method_461(this.field_730, this.field_729, this.field_732, this.field_727, this.field_728, var5, var2, this.gameProperties, var3, null), this.gameProperties.getSeed(), var5, var1, var4, var2, var3);
        } else {
            var7 = this.field_742;
        }

        Iterator var8 = this.field_733.iterator();

        while(var8.hasNext()) {
            class_5 var9 = (class_5)var8.next();

            try {
                var9.method_32(var7);
            } catch (IOException var11) {
                logger.error(String.format("Can\'t render world using renderer \'%s\' [tick=%d].", new Object[]{var9.getClass().getSimpleName(), Integer.valueOf(this.field_730)}), var11);
                this.method_965(String.format("Can\'t render world using renderer \'%s\': %s [tick=%d]", var9.getClass().getSimpleName(), ExceptionUtils.getStackTrace(var11), Integer.valueOf(this.field_730)));
            }
        }

    }

    // $FF: renamed from: i () void
    private void method_945() {
        ArrayList var1 = new ArrayList(this.field_734.keySet());
        List var2 = this.field_721.method_19();
        ArrayList var3 = new ArrayList(this.field_734.entrySet());
        ArrayList var4 = new ArrayList();
        Iterator var5 = var3.iterator();

        label94:
        while(true) {
            if(var5.hasNext()) {
                Entry var6 = (Entry)var5.next();
                final class_171 var7 = (class_171)var6.getKey();
                List var8 = (List)var6.getValue();
                int var9 = var8.size();
                Iterator var10 = var8.iterator();

                label89:
                while(true) {
                    class_43 var11;
                    do {
                        if(!var10.hasNext()) {
                            if(var7.method_922()) {
                                continue label94;
                            }

                            final World var19 = class_77.method_461(this.field_730, this.field_729, this.field_732, this.field_727, this.field_728, 1.0D / (double)this.field_721.method_24(), var1, this.gameProperties, var2, var7);
                            final Car[] var20 = new Car[var9];

                            for(int var21 = 0; var21 < var9; ++var21) {
                                var20[var21] = class_79.method_476((class_43)var8.get(var21), 1.0D / (double)this.field_721.method_24(), var7);
                            }

                            Future var22 = this.field_738.submit(new Callable() {
                                // $FF: renamed from: a () com.a.b.a.a.c.m[]
                                public Move[] method_916() throws Exception {
                                    return var7.method_920().method_53(var20, var19);
                                }

                                // $FF: synthetic method
                                public Object call() throws Exception {
                                    return this.method_916();
                                }
                            });
                            SimpleMutable var13 = new SimpleMutable();
                            if(this.method_946(var7, var22, var13)) {
                                Move[] var14 = (Move[])var13.get();
                                if(var14 != null && var14.length == var9) {
                                    int var15 = 0;

                                    while(true) {
                                        if(var15 >= var9) {
                                            continue label94;
                                        }

                                        Move var16 = var14[var15];
                                        if(var16 != null) {
                                            class_43 var17 = (class_43)var8.get(var15);
                                            if(!class_79.method_481(var17) && !var17.method_345()) {
                                                var4.add(new GameSimulatorImpl.class_213(var17, var16, null));
                                            }
                                        }

                                        ++var15;
                                    }
                                }

                                throw new RuntimeException(String.format("Strategy adapter \'%s\' of %s returned %d moves for %d cars at tick %d.", new Object[]{var7.method_920().getClass().getSimpleName(), var7, Integer.valueOf(var14 == null?0:var14.length), Integer.valueOf(var9), Integer.valueOf(this.field_730)}));
                            }
                            break label89;
                        }

                        var11 = (class_43)var10.next();
                        var11.method_341(false);
                    } while(!class_79.method_481(var11) && !var11.method_345() && !var7.method_922());

                    double var12 = var11.method_279().method_876().dotProduct((new Vector2D(1.0D, 0.0D)).rotate(var11.method_279().method_874())) * var11.method_307() * 0.0017453292519943296D;
                    var11.method_279().method_883(var12);
                }
            }

            RandomUtils.randomShuffle(var4);
            var5 = var4.iterator();

            GameSimulatorImpl.class_213 var18;
            while(var5.hasNext()) {
                var18 = (GameSimulatorImpl.class_213)var5.next();
                this.method_949(var18.method_751(), var18.method_752());
            }

            var5 = var4.iterator();

            while(var5.hasNext()) {
                var18 = (GameSimulatorImpl.class_213)var5.next();
                this.method_950(var18.method_751(), var18.method_752());
            }

            return;
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.n, java.util.concurrent.Future, com.codeforces.commons.holder.Mutable) boolean
    private boolean method_946(class_171 var1, Future var2, Mutable var3) {
        long var4 = System.currentTimeMillis();

        try {
            if(this.gameProperties.isDebug()) {
                var3.set(var2.get(20L, TimeUnit.MINUTES));
            } else {
                var3.set(var2.get(5000L, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException var10) {
            logger.error(String.format("Strategy adapter \'%s\' of %s has been interrupted at a tick %d.", new Object[]{var1.method_920().getClass().getSimpleName(), var1, Integer.valueOf(this.field_730)}), var10);
            var2.cancel(true);
            var1.method_924("Ожидание отклика от стратегии было прервано.");
            return false;
        } catch (ExecutionException var11) {
            logger.warn(String.format("Strategy adapter \'%s\' of %s has failed at a tick %d.", new Object[]{var1.method_920().getClass().getSimpleName(), var1, Integer.valueOf(this.field_730)}), var11);
            var2.cancel(true);
            var1.method_924("Процесс стратегии непредвиденно завершился на тике " + this.field_730 + '.');
            return false;
        } catch (TimeoutException var12) {
            logger.warn(String.format("Strategy adapter \'%s\' of %s has timed out at a tick %d.", new Object[]{var1.method_920().getClass().getSimpleName(), var1, Integer.valueOf(this.field_730)}), var12);
            var2.cancel(true);
            var1.method_924("Процесс стратегии превысил ограничение по времени на тик.");
            return false;
        }

        if(!this.gameProperties.isDebug()) {
            long var6 = System.currentTimeMillis() - var4;
            long var8 = var1.method_925();
            if(var8 < var6) {
                logger.warn(String.format("Strategy adapter \'%s\' of %s has consumed all available game time at a tick %d.", var1.method_920().getClass().getSimpleName(), var1, Integer.valueOf(this.field_730)));
                var1.method_924("Процесс стратегии превысил ограничение по времени на игру.");
                return false;
            }

            var1.method_927(var6);
        }

        return true;
    }

    // $FF: renamed from: j () void
    private void method_947() {
        Iterator var1 = this.field_736.iterator();

        while(var1.hasNext()) {
            class_2 var2 = (class_2)var1.next();
            var2.method_16(this.field_721, this.field_730);
        }

    }

    // $FF: renamed from: k () void
    private void method_948() {
        Iterator var1 = this.field_737.iterator();

        while(var1.hasNext()) {
            class_2 var2 = (class_2)var1.next();
            var2.method_16(this.field_721, this.field_730);
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.b.d.c.b, com.a.b.a.a.c.m) void
    private void method_949(class_43 var1, Move var2) {
        if(!class_79.method_481(var1) && !var1.method_345()) {
            class_159 var3;
            Point2D var4;
            if(var2.isThrowProjectile() && var1.method_322() == 0 && var1.method_316() > 0) {
                var3 = var1.method_279();
                var4 = new Point2D(var3.method_870(), var3.method_872());
                switch(var1.method_299().ordinal()) {
                case 1:
                    this.field_721.method_17(new class_49(var1, var1.method_297(), this.field_730, var4.copy(), var3.method_874()));
                    this.field_721.method_17(new class_49(var1, var1.method_297(), this.field_730, var4.copy(), var3.method_874() + 0.03490658503988659D));
                    this.field_721.method_17(new class_49(var1, var1.method_297(), this.field_730, var4.copy(), var3.method_874() - 0.03490658503988659D));
                    break;
                case 2:
                    this.field_721.method_17(new class_50(var1, var1.method_297(), this.field_730, var4.copy(), var3.method_874()));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported car type: " + var1.method_299() + '.');
                }

                var1.method_323(60);
                var1.method_317(var1.method_316() - 1);
            }

            if(var2.isUseNitro() && var1.method_325() == 0 && var1.method_318() > 0) {
                var1.method_332(120);
                var1.method_326(120);
                var1.method_319(var1.method_318() - 1);
            }

            if(var2.isSpillOil() && var1.method_328() == 0 && var1.method_320() > 0) {
                var3 = var1.method_279();
                var4 = (new Point2D(var3.method_870(), var3.method_872())).add((new Vector2D(265.0D, 0.0D)).rotate(var3.method_874() + 3.141592653589793D));
                this.field_721.method_17(new class_46(var4.copy()));
                var1.method_329(120);
                var1.method_321(var1.method_320() - 1);
            }

        }
    }

    // $FF: renamed from: b (com.a.b.a.a.b.d.c.b, com.a.b.a.a.c.m) void
    private void method_950(class_43 var1, Move var2) {
        if(!class_79.method_481(var1) && !var1.method_345()) {
            this.method_951(var1, var2);
            method_952(var1, var2);
        }
    }

    // $FF: renamed from: c (com.a.b.a.a.b.d.c.b, com.a.b.a.a.c.m) void
    private void method_951(class_43 var1, Move var2) {
        double var3 = var2.getEnginePower();
        if(!Double.isNaN(var3) && !Double.isInfinite(var3)) {
            if(var1.method_331() > 0) {
                var1.method_305(2.0D, true);
                var3 = 2.0D;
            } else {
                var1.method_306(var3);
                var3 = var1.method_304();
            }

            if(var2.isBrake()) {
                var1.method_341(true);
                var1.method_279().method_891(var1.method_334() > 0 ? 0.001D : 0.25D);
            } else {
                var1.method_279().method_891(0.001D);
                double var5 = var3 * (var3 >= 0.0D?var1.method_310():var1.method_311());
                if(this.field_730 >= 180) {
                    var1.method_279().method_884().add((new Vector2D(var5, 0.0D)).rotate(var1.method_279().method_874()));
                }
            }

        } else {
            logger.warn(String.format("Received unexpected \'enginePower\' value (%s) for %s.", var3, var1));
        }
    }

    // $FF: renamed from: d (com.a.b.a.a.b.d.c.b, com.a.b.a.a.c.m) void
    private static void method_952(class_43 var0, Move var1) {
        double var2 = var1.getWheelTurn();
        if(!Double.isNaN(var2) && !Double.isInfinite(var2)) {
            var0.method_309(var2);
            var2 = var0.method_307();
            double var4 = var0.method_279().method_876().dotProduct((new Vector2D(1.0D, 0.0D)).rotate(var0.method_279().method_874())) * var2 * 0.0017453292519943296D;
            double var6 = var4 - var0.method_279().method_882();
            var0.method_279().method_883(var4);
            var0.method_279().method_881(var0.method_279().method_880() + var6);
        } else {
            logger.warn(String.format("Received unexpected \'wheelTurn\' value (%s) for %s.", var2, var0));
        }
    }

    // $FF: renamed from: l () void
    private void method_953() {
        String var1 = this.gameProperties.getMapFilePath();
        logger.debug("Started to load \'" + var1 + "\' map.");
        this.field_723 = this.gameProperties.method_78(var1);
        this.field_727 = this.gameProperties.method_80();
        this.field_728 = this.gameProperties.method_81();
        TileType[][] var2 = this.field_723.getTilesXY();
        ArrayList var3 = new ArrayList();

        for(int var4 = 0; var4 < this.field_727; ++var4) {
            for(int var5 = 0; var5 < this.field_728; ++var5) {
                TileType var6 = var2[var4][var5];
                if(var6 != TileType.EMPTY) {
                    var3.add(new IntPair(Integer.valueOf(var4), Integer.valueOf(var5)));
                }
            }
        }

        this.field_724 = (IntPair[])var3.toArray(new IntPair[var3.size()]);
        logger.debug("Finished to load \'" + var1 + "\' map.");
    }

    // $FF: renamed from: m () void
    private void method_954() {
        logger.debug("Started to add renderers.");
        if(this.gameProperties.shouldRenderToScreen()) {
            logger.debug("Adding " + class_96.class.getSimpleName() + '.');
            this.field_733.add(new class_96(this.gameProperties));
        }

        File var1 = this.gameProperties.getSomeTextFile();
        if(var1 != null) {
            try {
                logger.debug("Adding " + class_97.class.getSimpleName() + '.');
                this.field_733.add(new class_97(var1, this.gameProperties));
            } catch (IOException var5) {
                logger.error(String.format("Can\'t create renderer \'%s\'.", class_97.class.getSimpleName()), var5);
                this.method_965(String.format("Can\'t create renderer \'%s\': %s", class_97.class.getSimpleName(), ExceptionUtils.getStackTrace(var5)));
            }
        }

        String var2 = this.gameProperties.shouldWriteToRemoteStorage();
        if(StringUtils.isNotBlank(var2)) {
            try {
                logger.debug("Adding " + class_101.class.getSimpleName() + '.');
                this.field_733.add(new class_101(var2, this.gameProperties));
            } catch (RuntimeException var4) {
                logger.error(String.format("Can\'t create renderer \'%s\'.", new Object[]{class_101.class.getSimpleName()}), var4);
                this.method_965(String.format("Can\'t create renderer \'%s\': %s", class_101.class.getSimpleName(), ExceptionUtils.getStackTrace(var4)));
            }
        }

        logger.debug("Finished to add renderers.");
    }

    // $FF: renamed from: n () void
    private void method_955() {
        logger.debug("Started to create static objects.");
        TileType[][] var1 = this.field_723.getTilesXY();

        for(int var2 = 0; var2 < this.field_727; ++var2) {
            for(int var3 = 0; var3 < this.field_728; ++var3) {
                TileType var4 = var1[var2][var3];
                double var5 = 800.0D * (double)var2;
                double var7 = 800.0D * (double)var3;
                double var9 = var5 + 800.0D;
                double var11 = var7 + 800.0D;
                double var13 = (var5 + var9) / 2.0D;
                double var15 = (var7 + var11) / 2.0D;
                switch(var4.ordinal()) {
                case 1:
                    break;
                case 2:
                    this.field_721.method_17(new class_53(var5 + 80.0D, var7, var5 + 80.0D, var11));
                    this.field_721.method_17(new class_53(var9 - 80.0D, var7, var9 - 80.0D, var11));
                    break;
                case 3:
                    this.field_721.method_17(new class_53(var5, var7 + 80.0D, var9, var7 + 80.0D));
                    this.field_721.method_17(new class_53(var5, var11 - 80.0D, var9, var11 - 80.0D));
                    break;
                case 4:
                    this.field_721.method_17(new class_53(var5 + 80.0D, var7 + 160.0D, var5 + 80.0D, var11));
                    this.field_721.method_17(new class_53(var5 + 160.0D, var7 + 80.0D, var9, var7 + 80.0D));
                    this.field_721.method_17(new class_55(var5 + 160.0D, var7 + 160.0D, 3.141592653589793D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var11, 3.141592653589793D, 1.5707963267948966D));
                    break;
                case 5:
                    this.field_721.method_17(new class_53(var9 - 80.0D, var7 + 160.0D, var9 - 80.0D, var11));
                    this.field_721.method_17(new class_53(var5, var7 + 80.0D, var9 - 160.0D, var7 + 80.0D));
                    this.field_721.method_17(new class_55(var9 - 160.0D, var7 + 160.0D, -1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var5, var11, -1.5707963267948966D, 1.5707963267948966D));
                    break;
                case 6:
                    this.field_721.method_17(new class_53(var5 + 80.0D, var7, var5 + 80.0D, var11 - 160.0D));
                    this.field_721.method_17(new class_53(var5 + 160.0D, var11 - 80.0D, var9, var11 - 80.0D));
                    this.field_721.method_17(new class_55(var5 + 160.0D, var11 - 160.0D, 1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var7, 1.5707963267948966D, 1.5707963267948966D));
                    break;
                case 7:
                    this.field_721.method_17(new class_53(var9 - 80.0D, var7, var9 - 80.0D, var11 - 160.0D));
                    this.field_721.method_17(new class_53(var5, var11 - 80.0D, var9 - 160.0D, var11 - 80.0D));
                    this.field_721.method_17(new class_55(var9 - 160.0D, var11 - 160.0D, 0.0D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var5, var7, 0.0D, 1.5707963267948966D));
                    break;
                case 8:
                    this.field_721.method_17(new class_53(var9 - 80.0D, var7, var9 - 80.0D, var11));
                    this.field_721.method_17(new class_57(var5, var7, 0.0D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var5, var11, -1.5707963267948966D, 1.5707963267948966D));
                    break;
                case 9:
                    this.field_721.method_17(new class_53(var5 + 80.0D, var7, var5 + 80.0D, var11));
                    this.field_721.method_17(new class_57(var9, var7, 1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var11, 3.141592653589793D, 1.5707963267948966D));
                    break;
                case 10:
                    this.field_721.method_17(new class_53(var5, var11 - 80.0D, var9, var11 - 80.0D));
                    this.field_721.method_17(new class_57(var5, var7, 0.0D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var7, 1.5707963267948966D, 1.5707963267948966D));
                    break;
                case 11:
                    this.field_721.method_17(new class_53(var5, var7 + 80.0D, var9, var7 + 80.0D));
                    this.field_721.method_17(new class_57(var5, var11, -1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var11, 3.141592653589793D, 1.5707963267948966D));
                    break;
                case 12:
                    this.field_721.method_17(new class_57(var5, var7, 0.0D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var5, var11, -1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var7, 1.5707963267948966D, 1.5707963267948966D));
                    this.field_721.method_17(new class_57(var9, var11, 3.141592653589793D, 1.5707963267948966D));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported tile type: " + var4 + '.');
                }
            }
        }

        logger.debug("Finished to create static objects.");
    }

    // $FF: renamed from: o () void
    private void method_956() {
        logger.debug("Started to add players.");
        List var1 = this.gameProperties.getPositionalArguments();
        int var2 = var1.size();
        if(var2 != 2 && var2 != 4) {
            throw new IllegalArgumentException("Unexpected player count: " + var2 + '.');
        } else {
            if(this.field_738 != null) {
                this.field_738.shutdown();
            }

            this.field_738 = Executors.newFixedThreadPool(var2, new ThreadFactory() {
                // $FF: renamed from: b java.util.concurrent.atomic.AtomicInteger
                private final AtomicInteger field_689 = new AtomicInteger();

                public Thread newThread(Runnable var1) {
                    Thread var2 = new Thread(var1);
                    var2.setDaemon(true);
                    var2.setName(String.format("%s#StrategyThread-%d", GameSimulatorImpl.class.getSimpleName(), this.field_689.incrementAndGet()));
                    return var2;
                }
            });

            for(int var3 = 0; var3 < var2; ++var3) {
                int var4 = this.gameProperties.getTeamSizeForPlayer(var3);
                class_171 var5 = class_72.method_450(this.gameProperties, var3, this.gameProperties.getPlayerName(var3), (String)var1.get(var3), var4, this.field_733);
                var5.method_926((long)(var4 * (this.field_729 + 1)) * 50L + 5000L);
                if(var5.method_921()) {
                    if(this.field_735.size() >= 1) {
                        throw new IllegalArgumentException(String.format("Can only add %d keyboard player(s).", 1));
                    }

                    this.field_735.add(var5);
                }

                this.field_734.put(var5, new ArrayList());
            }

            logger.debug("Finished to add players.");
        }
    }

    // $FF: renamed from: p () void
    private void method_957() {
        logger.debug("Sending game contexts.");
        Iterator var1 = this.field_734.keySet().iterator();

        while(var1.hasNext()) {
            final class_171 var2 = (class_171)var1.next();
            final Game var3 = class_84.method_499(var2.method_919(), this.field_729, this.gameProperties);
            Future var4 = this.field_738.submit(new Callable() {
                // $FF: renamed from: a () java.lang.Integer
                public Integer method_914() throws Exception {
                    class_11 var1 = var2.method_920();
                    int var2x = var1.method_51();
                    var1.method_52(var3);
                    return var2x;
                }

                // $FF: synthetic method
                public Object call() throws Exception {
                    return this.method_914();
                }
            });
            SimpleMutable var5 = new SimpleMutable();
            if(this.method_946(var2, var4, var5)) {
                Integer var6 = (Integer)var5.get();
                if(!var2.method_922() && !class_16.method_71(var6)) {
                    logger.warn(String.format("Strategy adapter \'%s\' returned unsupported protocol version %d.", var2.method_920().getClass().getSimpleName(), var6));
                    var2.method_924("Процесс стратегии использует устаревшую версию протокола.");
                }
            }
        }

    }

    // $FF: renamed from: q () void
    private void method_958() {
        logger.debug("Adding player units.");
        int var1 = this.field_734.size();
        int var2 = 0;

        for(Iterator var3 = this.field_734.entrySet().iterator(); var3.hasNext(); ++var2) {
            Entry var4 = (Entry)var3.next();
            class_171 var5 = (class_171)var4.getKey();
            int var6 = this.gameProperties.getTeamSizeForPlayer(var2);
            class_143[] var7 = method_963(var6, this.gameProperties.shouldSwapCarTypes());
            if(var7 == null || var7.length != var6) {
                throw new RuntimeException(String.format("Got %d car types, while %d expected.", ArrayUtils.getLength(var7), var6));
            }

            for(int var8 = 0; var8 < var6; ++var8) {
                Point2D var9 = class_79.method_477(this.field_723, var2, var1, var6, var8);
                double var10 = class_79.method_478(this.field_723, var2, var1, var6, var8);
                Object var12;
                switch(var7[var8].ordinal()) {
                case 1:
                    var12 = new class_45(var5, var8, var9.getX(), var9.getY(), var10, this.field_723.method_414()[1]);
                    break;
                case 2:
                    var12 = new class_44(var5, var8, var9.getX(), var9.getY(), var10, this.field_723.method_414()[1]);
                    break;
                default:
                    throw new IllegalArgumentException("Car type is unsupported: " + var7[var8] + '.');
                }

                this.field_721.method_17((class_42) var12);
                ((List)var4.getValue()).add(var12);
            }
        }

    }

    // $FF: renamed from: r () void
    private void method_959() {
        logger.debug("Adding bonuses.");
        int var1 = NumberUtil.toInt(Math.floor(0.25D * (double)this.field_724.length));

        for(int var2 = 0; var2 < var1; ++var2) {
            this.method_960();
        }

    }

    // $FF: renamed from: s () void
    private void method_960() {
        BonusType var1 = class_16.field_4[RandomUtils.randomInteger(0, class_16.field_4.length - 1)];
        double var2 = 570.0D;
        double var4 = 70.0D / Math.SQRT_2;

        for(int var6 = 0; var6 < 100; ++var6) {
            int var7 = RandomUtils.randomInteger(0, this.field_724.length - 1);
            double var8 = RandomUtils.randomDouble() * var2 + 80.0D + 35.0D;
            double var10 = RandomUtils.randomDouble() * var2 + 80.0D + 35.0D;
            IntPair var12 = this.field_724[var7];
            Preconditions.checkNotNull(var12.getFirst());
            Preconditions.checkNotNull(var12.getSecond());
            double var13 = (double) var12.getFirst() * 800.0D + var8;
            double var15 = (double) var12.getSecond() * 800.0D + var10;
            boolean var17 = false;
            Iterator var18 = this.field_721.method_19().iterator();

            while(var18.hasNext()) {
                class_42 var19 = (class_42)var18.next();
                if(var19 instanceof class_47) {
                    if(Math.abs(var13 - var19.method_279().method_870()) <= 70.0D && Math.abs(var15 - var19.method_279().method_872()) <= 70.0D) {
                        var17 = true;
                        break;
                    }
                } else if(var19 instanceof class_43) {
                    if(class_85.method_500(var19.method_279().method_902()) + var4 >= var19.method_295(var13, var15)) {
                        var17 = true;
                        break;
                    }
                } else if(!(var19 instanceof class_48) && !(var19 instanceof class_51) && !(var19 instanceof class_46)) {
                    throw new IllegalArgumentException("Unsupported unit class: " + var19.getClass() + '.');
                }
            }

            if(!var17) {
                this.field_721.method_17(new class_47(var1, var13, var15));
                return;
            }
        }

    }

    // $FF: renamed from: t () void
    private void method_961() {
        logger.debug("Adding collision listeners.");
        Readable var1 = new Readable() {
            // $FF: renamed from: a () java.lang.Integer
            public Integer method_915() {
                return GameSimulatorImpl.this.field_730;
            }

            // $FF: synthetic method
            public Object get() {
                return this.method_915();
            }
        };
        this.field_721.method_23(class_42.class, class_42.class, new class_37());
        this.field_721.method_23(class_48.class, class_43.class, new class_36(var1));
        this.field_721.method_23(class_43.class, class_47.class, new class_41());
        this.field_721.method_23(class_43.class, class_43.class, new class_39(var1));
        this.field_721.method_23(class_43.class, class_51.class, new class_40(var1));
        this.field_721.method_23(class_48.class, class_42.class, new class_35());
        this.field_721.method_23(class_43.class, class_46.class, new class_38());
    }

    // $FF: renamed from: u () void
    private void method_962() {
        logger.debug("Adding game events.");
        this.field_736.add(new class_25(this.gameProperties));
        this.field_737.add(new class_25(this.gameProperties));
        this.field_737.add(new class_22(new Readable() {
            // $FF: renamed from: a () java.lang.Integer
            public Integer method_912() {
                return GameSimulatorImpl.this.field_730;
            }

            // $FF: synthetic method
            public Object get() {
                return this.method_912();
            }
        }, this.gameProperties));
        this.field_737.add(new class_26(this.gameProperties, new Readable() {
            // $FF: renamed from: a () java.lang.Integer
            public Integer method_913() {
                return GameSimulatorImpl.this.field_730;
            }

            // $FF: synthetic method
            public Object get() {
                return this.method_913();
            }
        }, new Writable() {
            // $FF: renamed from: a (java.lang.Integer) java.lang.Integer
            public Integer method_911(Integer var1) {
                Preconditions.checkNotNull(var1);
                if(GameSimulatorImpl.this.field_731 != null && var1 < GameSimulatorImpl.this.field_731) {
                    throw new IllegalArgumentException("Argument \'value\' is less than \'lastFinishTrackTick\'.");
                } else {
                    GameSimulatorImpl.this.field_732 = Math.min(GameSimulatorImpl.this.field_729 - 1, var1 + Math.max(NumberUtil.toInt(0.5D * (double)GameSimulatorImpl.this.field_723.method_416()), 1));
                    return GameSimulatorImpl.this.field_731 = var1;
                }
            }

            // $FF: synthetic method
            public Object set(Object var1) {
                return this.method_911((Integer)var1);
            }
        }));
        this.field_737.add(new class_24());
        this.field_737.add(new class_19(this.field_724, new Runnable() {
            public void run() {
                GameSimulatorImpl.this.method_960();
            }
        }));
        this.field_737.add(new class_21());
        this.field_737.add(new class_20());
        this.field_737.add(new class_23(this.field_727, this.field_728));
    }

    // $FF: renamed from: a (int, boolean) com.a.b.a.a.c.d[]
    private static class_143[] method_963(int var0, boolean var1) {
        switch(var0) {
        case 1:
            return new class_143[]{var1?class_143.JEEP:class_143.BUGGY};
        case 2:
            return var1?new class_143[]{class_143.JEEP, class_143.BUGGY}:new class_143[]{class_143.BUGGY, class_143.JEEP};
        default:
            throw new IllegalArgumentException("Unsupported team size: " + var0 + '.');
        }
    }

    // $FF: renamed from: v () boolean
    private boolean method_964() {
        Iterator var1 = this.field_734.entrySet().iterator();

        while(true) {
            Entry var2;
            do {
                if(!var1.hasNext()) {
                    return true;
                }

                var2 = (Entry)var1.next();
            } while(((class_171)var2.getKey()).method_922());

            Iterator var3 = ((List)var2.getValue()).iterator();

            while(var3.hasNext()) {
                class_43 var4 = (class_43)var3.next();
                if(!var4.method_345()) {
                    return false;
                }
            }
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    private void method_965(String var1) {
        if(!this.field_725.getAndSet(true)) {
            this.field_726.set(var1);
        }

    }

    // $FF: renamed from: w () com.a.b.a.a.c.h
    private class_138 method_966() {
        try {
            return class_77.method_463(this.replayFileReader.readLine(), this.field_742, this.field_721.method_19());
        } catch (IOException var2) {
            this.method_965(String.format("Can\'t read world from log file: %s", ExceptionUtils.getStackTrace(var2)));
            return null;
        }
    }

    private static final class class_213 {
        // $FF: renamed from: a com.a.b.a.a.b.d.c.b
        private final class_43 field_429;
        // $FF: renamed from: b com.a.b.a.a.c.m
        private final Move field_430;

        private class_213(class_43 var1, Move var2) {
            this.field_429 = var1;
            this.field_430 = var2;
        }

        // $FF: renamed from: a () com.a.b.a.a.b.d.c.b
        private class_43 method_751() {
            return this.field_429;
        }

        // $FF: renamed from: b () com.a.b.a.a.c.m
        private Move method_752() {
            return this.field_430;
        }

        // $FF: synthetic method
        class_213(class_43 var1, Move var2, Object var3) {
            this(var1, var2);
        }
    }
}
