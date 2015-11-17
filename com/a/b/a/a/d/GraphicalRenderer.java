package com.a.b.a.a.d;

import com.a.a.a.a.Colors;
import com.a.a.a.a.class_123;
import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.d.b.a.a.class_57;
import com.a.b.a.a.b.d.b.a.b.class_54;
import com.a.b.a.a.b.d.b.b.class_52;
import com.a.b.a.a.b.e.PlayerUtils;
import com.a.b.a.a.b.e.class_79;
import com.a.b.a.a.b.e.class_84;
import com.a.b.a.a.b.e.class_85;
import com.a.b.a.a.c.OilSlick;
import com.a.b.a.a.c.Projectile;
import com.a.b.a.a.c.Bonus;
import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.DecoratedWorld;
import com.a.b.a.a.c.class_141;
import com.a.b.a.a.c.class_142;
import com.a.b.a.a.c.Player;
import com.a.b.a.a.c.Game;
import com.a.b.a.a.c.class_151;
import com.a.b.a.a.e.a.class_179;
import com.a.c.a.class_126;
import com.a.c.a.class_127;
import com.a.c.a.class_128;
import com.a.c.a.class_129;
import com.codeforces.commons.concurrent.AtomicUtil;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.geometry.Vector2D;
import com.codeforces.commons.io.FileUtil;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.math.NumberUtil;
import com.codeforces.commons.process.ThreadUtil;
import com.codeforces.commons.reflection.MethodSignature;
import com.codeforces.commons.reflection.ReflectionUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.d.a
public class GraphicalRenderer implements Renderer {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(GraphicalRenderer.class);
    // $FF: renamed from: b long[]
    private static final long[] field_338 = new long[]{8L, 10L, 13L, 17L, 34L, 67L, 134L};
    // $FF: renamed from: c java.awt.Color
    private static final Color field_339 = new Color(0, 0, 0, 17);
    // $FF: renamed from: d java.awt.Color
    private static final Color field_340 = new Color(255, 153, 32, 255);
    // $FF: renamed from: e com.a.b.a.a.a.b
    private final GameProperties gameProperties;
    // $FF: renamed from: f int
    private final int field_342;
    // $FF: renamed from: g java.util.concurrent.atomic.AtomicLong
    private final AtomicLong field_343 = new AtomicLong(Long.MIN_VALUE);
    // $FF: renamed from: h java.util.concurrent.ConcurrentMap
    private final ConcurrentMap field_344 = new ConcurrentHashMap();
    // $FF: renamed from: i double
    private volatile double field_345 = 5120.0D;
    // $FF: renamed from: j double
    private volatile double field_346;
    // $FF: renamed from: k double
    private volatile double field_347;
    // $FF: renamed from: l double
    private volatile double field_348;
    // $FF: renamed from: m java.util.concurrent.locks.Lock
    private final Lock field_349 = new ReentrantLock();
    // $FF: renamed from: n java.awt.image.BufferedImage
    private BufferedImage field_350;
    // $FF: renamed from: o java.awt.image.BufferedImage
    private BufferedImage field_351;
    // $FF: renamed from: p java.awt.image.BufferedImage
    private BufferedImage field_352;
    // $FF: renamed from: q java.awt.Panel
    private Panel field_353;
    // $FF: renamed from: r java.util.concurrent.BlockingQueue
    private final BlockingQueue field_354;
    // $FF: renamed from: s com.a.b.a.a.d.a$e
    private final GraphicalRenderer.class_219 field_355;
    // $FF: renamed from: t java.util.concurrent.atomic.AtomicLong
    private final AtomicLong field_356 = new AtomicLong(17L);
    // $FF: renamed from: u java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_357 = new AtomicBoolean();
    // $FF: renamed from: v java.util.concurrent.atomic.AtomicInteger
    private final AtomicInteger field_358 = new AtomicInteger();
    // $FF: renamed from: w java.util.concurrent.atomic.AtomicInteger
    private final AtomicInteger field_359 = new AtomicInteger(2);
    // $FF: renamed from: x java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_360 = new AtomicBoolean();
    // $FF: renamed from: y java.util.concurrent.atomic.AtomicBoolean
    private final AtomicBoolean field_361 = new AtomicBoolean(true);
    // $FF: renamed from: z java.util.concurrent.atomic.AtomicInteger
    private final AtomicInteger field_362 = new AtomicInteger();
    // $FF: renamed from: A com.a.b.a.a.e.a.c$a
    private final class_179.class_209 field_363 = new class_179.class_209();
    // $FF: renamed from: B java.util.concurrent.ConcurrentMap
    private final ConcurrentMap field_364 = new ConcurrentHashMap();

    public GraphicalRenderer(final GameProperties var1) {
        this.gameProperties = var1;
        this.field_342 = var1.getPsychoLevel();
        this.field_346 = this.field_345 * (double)var1.getScreenHeight() / (double)var1.getScreenWidth();
        this.field_355 = method_520(var1);
        this.method_522(var1.getScreenWidth(), var1.getScreenHeight());
        this.field_354 = new LinkedBlockingQueue(var1.shouldRenderSync()?1:32767);
        (new Thread(new Runnable() {
            public void run() {
                long var1x = System.currentTimeMillis();
                long var3 = var1x;

                try {
                    DecoratedWorld var5 = null;

                    GraphicalRenderer.class_216 var7;
                    for(int var6 = 0; (var7 = this.method_518()) != null && var7.method_859() != null; var5 = var7.method_859()) {
                        var1x = this.method_519(var1x, GraphicalRenderer.this.field_356.get());
                        long var8 = System.currentTimeMillis();
                        if(var8 - var3 > 1000L) {
                            var3 = System.currentTimeMillis();
                            GraphicalRenderer.this.field_362.set(var6);
                            var6 = 0;
                        }

                        GraphicalRenderer.this.method_525(var7);
                        ++var6;
                    }

                    if(var5 != null) {
                        GraphicalRenderer.this.method_537(var5);
                    }

                    Thread.sleep(TimeUnit.SECONDS.toMillis(30L));
                } catch (InterruptedException var10) {
                    ;
                } catch (RuntimeException var11) {
                    GraphicalRenderer.logger.error("Got unexpected runtime exception in rendering thread.", var11);
                    throw var11;
                }

                System.exit(0);
            }

            // $FF: renamed from: a () com.a.b.a.a.d.a$f
            private GraphicalRenderer.class_216 method_518() throws InterruptedException {
                return var1.isDebug()?(GraphicalRenderer.class_216)GraphicalRenderer.this.field_354.poll(20L, TimeUnit.MINUTES):(GraphicalRenderer.class_216)GraphicalRenderer.this.field_354.poll(30L, TimeUnit.SECONDS);
            }

            // $FF: renamed from: a (long, long) long
            private long method_519(long var1x, long var3) {
                long var5 = System.currentTimeMillis();
                if(var5 - var1x < var3) {
                    ThreadUtil.sleep(var3 - var5 + var1x);
                }

                return System.currentTimeMillis();
            }
        })).start();
    }

    // $FF: renamed from: a (com.a.b.a.a.a.b) com.a.b.a.a.d.a$e
    private static GraphicalRenderer.class_219 method_520(GameProperties var0) {
        File var1 = var0.getPluginsDirectory();
        if(FileUtil.isDirectory(var1)) {
            ArrayList var2 = new ArrayList();

            try {
                var2.add(new URLClassLoader(new URL[]{var1.toURI().toURL()}));
            } catch (MalformedURLException var4) {
                logger.error("Can\'t convert plugins directory to URL.", var4);
            }

            var2.add(GraphicalRenderer.class.getClassLoader());
            Object var3 = method_521("LocalTestRendererListener", var2);
            return new GraphicalRenderer.class_217(var3, null);
        } else {
            return new GraphicalRenderer.class_217((Object)null, null);
        }
    }

    // $FF: renamed from: a (java.lang.String, java.util.List) java.lang.Object
    private static Object method_521(String var0, List var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            ClassLoader var3 = (ClassLoader)var2.next();

            try {
                Class var4 = var3.loadClass("LocalTestRendererListener");
                return var4.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException var5) {
                logger.error(String.format("Can\'t create an instance of %s using %s.", new Object[]{var0, var3}), var5);
            }
        }

        return null;
    }

    // $FF: renamed from: a (int, int) void
    private void method_522(int var1, int var2) {
        this.field_350 = new BufferedImage(var1, var2, 1);
        this.field_353 = new Panel() {
            public void paint(Graphics var1) {
                super.paint(var1);
                var1.drawImage(GraphicalRenderer.this.field_350, 0, 0, (ImageObserver)null);
            }
        };
        KeyAdapter var3 = new KeyAdapter() {
            public void keyPressed(KeyEvent var1) {
                if(!var1.isConsumed()) {
                    boolean var2 = true;
                    if(var1.getKeyChar() == 32) {
                        AtomicUtil.invert(GraphicalRenderer.this.field_357);
                    } else if(var1.getKeyCode() == 9) {
                        AtomicUtil.invert(GraphicalRenderer.this.field_361);
                    } else if(var1.getKeyCode() == 39) {
                        if(GraphicalRenderer.this.field_358.incrementAndGet() > 32767) {
                            GraphicalRenderer.this.field_358.decrementAndGet();
                        }
                    } else if(var1.getKeyCode() == 72) {
                        AtomicUtil.decrement(GraphicalRenderer.this.field_359, 2);
                    } else {
                        long var3;
                        int var5;
                        if(var1.getKeyCode() == 38) {
                            var3 = GraphicalRenderer.this.field_356.get();
                            var5 = Arrays.binarySearch(GraphicalRenderer.field_338, var3);
                            if(var5 > 0) {
                                GraphicalRenderer.this.field_356.compareAndSet(var3, GraphicalRenderer.field_338[var5 - 1]);
                            }
                        } else if(var1.getKeyCode() == 40) {
                            var3 = GraphicalRenderer.this.field_356.get();
                            var5 = Arrays.binarySearch(GraphicalRenderer.field_338, var3);
                            if(var5 < GraphicalRenderer.field_338.length - 1) {
                                GraphicalRenderer.this.field_356.compareAndSet(var3, GraphicalRenderer.field_338[var5 + 1]);
                            }
                        } else if(var1.getKeyCode() == 18) {
                            GraphicalRenderer.this.field_360.set(true);
                        } else if((var1.getKeyCode() == 521 || var1.getKeyCode() == 61) && var1.isControlDown()) {
                            GraphicalRenderer.this.field_349.lock();

                            try {
                                double var23 = GraphicalRenderer.this.field_345 / 2.0D;
                                double var24 = GraphicalRenderer.this.field_346 / 2.0D;
                                if(GraphicalRenderer.this.field_345 > 1280.0D && NumberUtil.equals(Double.valueOf(var23), Double.valueOf(Math.round(var23))) && NumberUtil.equals(Double.valueOf(var24), Double.valueOf(Math.round(var24)))) {
                                    GraphicalRenderer.this.field_345 = var23;
                                    GraphicalRenderer.this.field_346 = var24;
                                }
                            } finally {
                                GraphicalRenderer.this.field_349.unlock();
                            }
                        } else if(var1.getKeyCode() == 45 && var1.isControlDown()) {
                            GraphicalRenderer.this.field_349.lock();

                            try {
                                if(GraphicalRenderer.this.field_345 < 20480.0D) {
                                    GraphicalRenderer.this.field_345 = GraphicalRenderer.this.field_345 * 2.0D;
                                    GraphicalRenderer.this.field_346 = GraphicalRenderer.this.field_346 * 2.0D;
                                }
                            } finally {
                                GraphicalRenderer.this.field_349.unlock();
                            }
                        } else if(var1.getKeyCode() == 48 && var1.isControlDown()) {
                            GraphicalRenderer.this.field_349.lock();

                            try {
                                GraphicalRenderer.this.field_345 = 5120.0D;
                                GraphicalRenderer.this.field_346 = GraphicalRenderer.this.field_345 * (double)GraphicalRenderer.this.gameProperties.getScreenHeight() / (double)GraphicalRenderer.this.gameProperties.getScreenWidth();
                            } finally {
                                GraphicalRenderer.this.field_349.unlock();
                            }
                        } else {
                            Long var22;
                            if(var1.getKeyCode() == 49) {
                                var22 = (Long)GraphicalRenderer.this.field_344.get(Integer.valueOf(0));
                                if(var22 != null) {
                                    GraphicalRenderer.this.field_343.set(var22.longValue());
                                }
                            } else if(var1.getKeyCode() == 50) {
                                var22 = (Long)GraphicalRenderer.this.field_344.get(Integer.valueOf(1));
                                if(var22 != null) {
                                    GraphicalRenderer.this.field_343.set(var22.longValue());
                                }
                            } else if(var1.getKeyCode() == 51) {
                                var22 = (Long)GraphicalRenderer.this.field_344.get(Integer.valueOf(2));
                                if(var22 != null) {
                                    GraphicalRenderer.this.field_343.set(var22.longValue());
                                }
                            } else if(var1.getKeyCode() == 52) {
                                var22 = (Long)GraphicalRenderer.this.field_344.get(Integer.valueOf(3));
                                if(var22 != null) {
                                    GraphicalRenderer.this.field_343.set(var22.longValue());
                                }
                            } else if(var1.getKeyCode() == 87) {
                                GraphicalRenderer.this.field_363.method_246(0, true);
                            } else if(var1.getKeyCode() == 83) {
                                GraphicalRenderer.this.field_363.method_248(0, true);
                            } else if(var1.getKeyCode() == 65) {
                                GraphicalRenderer.this.field_363.method_252(0, true);
                            } else if(var1.getKeyCode() == 68) {
                                GraphicalRenderer.this.field_363.method_254(0, true);
                            } else if(var1.getKeyCode() == 81) {
                                GraphicalRenderer.this.field_363.method_256(0, true);
                            } else if(var1.getKeyCode() == 69) {
                                GraphicalRenderer.this.field_363.method_260(0, true);
                            } else if(var1.getKeyCode() == 67) {
                                GraphicalRenderer.this.field_363.method_250(0, true);
                            } else if(var1.getKeyCode() == 88) {
                                GraphicalRenderer.this.field_363.method_258(0, true);
                            } else if(var1.getKeyCode() == 73) {
                                GraphicalRenderer.this.field_363.method_246(1, true);
                            } else if(var1.getKeyCode() == 75) {
                                GraphicalRenderer.this.field_363.method_248(1, true);
                            } else if(var1.getKeyCode() == 74) {
                                GraphicalRenderer.this.field_363.method_252(1, true);
                            } else if(var1.getKeyCode() == 76) {
                                GraphicalRenderer.this.field_363.method_254(1, true);
                            } else if(var1.getKeyCode() == 85) {
                                GraphicalRenderer.this.field_363.method_256(1, true);
                            } else if(var1.getKeyCode() == 79) {
                                GraphicalRenderer.this.field_363.method_260(1, true);
                            } else if(var1.getKeyCode() != 46 && var1.getKeyCode() != 160) {
                                if(var1.getKeyCode() != 44 && var1.getKeyCode() != 153) {
                                    if(var1.getKeyCode() == 104) {
                                        GraphicalRenderer.this.field_363.method_246(2, true);
                                    } else if(var1.getKeyCode() == 101) {
                                        GraphicalRenderer.this.field_363.method_248(2, true);
                                    } else if(var1.getKeyCode() == 100) {
                                        GraphicalRenderer.this.field_363.method_252(2, true);
                                    } else if(var1.getKeyCode() == 102) {
                                        GraphicalRenderer.this.field_363.method_254(2, true);
                                    } else if(var1.getKeyCode() == 103) {
                                        GraphicalRenderer.this.field_363.method_256(2, true);
                                    } else if(var1.getKeyCode() == 105) {
                                        GraphicalRenderer.this.field_363.method_260(2, true);
                                    } else if(var1.getKeyCode() == 99) {
                                        GraphicalRenderer.this.field_363.method_250(2, true);
                                    } else if(var1.getKeyCode() == 98) {
                                        GraphicalRenderer.this.field_363.method_258(2, true);
                                    } else {
                                        var2 = false;
                                    }
                                } else {
                                    GraphicalRenderer.this.field_363.method_258(1, true);
                                }
                            } else {
                                GraphicalRenderer.this.field_363.method_250(1, true);
                            }
                        }
                    }

                    if(var2) {
                        var1.consume();
                    }

                }
            }

            public void keyReleased(KeyEvent var1) {
                if(!var1.isConsumed()) {
                    boolean var2 = true;
                    if(var1.getKeyCode() == 18) {
                        GraphicalRenderer.this.field_360.set(false);
                    } else if(var1.getKeyCode() == 87) {
                        GraphicalRenderer.this.field_363.method_246(0, false);
                    } else if(var1.getKeyCode() == 83) {
                        GraphicalRenderer.this.field_363.method_248(0, false);
                    } else if(var1.getKeyCode() == 65) {
                        GraphicalRenderer.this.field_363.method_252(0, false);
                    } else if(var1.getKeyCode() == 68) {
                        GraphicalRenderer.this.field_363.method_254(0, false);
                    } else if(var1.getKeyCode() == 81) {
                        GraphicalRenderer.this.field_363.method_256(0, false);
                    } else if(var1.getKeyCode() == 69) {
                        GraphicalRenderer.this.field_363.method_260(0, false);
                    } else if(var1.getKeyCode() == 67) {
                        GraphicalRenderer.this.field_363.method_250(0, false);
                    } else if(var1.getKeyCode() == 88) {
                        GraphicalRenderer.this.field_363.method_258(0, false);
                    } else if(var1.getKeyCode() == 73) {
                        GraphicalRenderer.this.field_363.method_246(1, false);
                    } else if(var1.getKeyCode() == 75) {
                        GraphicalRenderer.this.field_363.method_248(1, false);
                    } else if(var1.getKeyCode() == 74) {
                        GraphicalRenderer.this.field_363.method_252(1, false);
                    } else if(var1.getKeyCode() == 76) {
                        GraphicalRenderer.this.field_363.method_254(1, false);
                    } else if(var1.getKeyCode() == 85) {
                        GraphicalRenderer.this.field_363.method_256(1, false);
                    } else if(var1.getKeyCode() == 79) {
                        GraphicalRenderer.this.field_363.method_260(1, false);
                    } else if(var1.getKeyCode() != 46 && var1.getKeyCode() != 160) {
                        if(var1.getKeyCode() != 44 && var1.getKeyCode() != 153) {
                            if(var1.getKeyCode() == 104) {
                                GraphicalRenderer.this.field_363.method_246(2, false);
                            } else if(var1.getKeyCode() == 101) {
                                GraphicalRenderer.this.field_363.method_248(2, false);
                            } else if(var1.getKeyCode() == 100) {
                                GraphicalRenderer.this.field_363.method_252(2, false);
                            } else if(var1.getKeyCode() == 102) {
                                GraphicalRenderer.this.field_363.method_254(2, false);
                            } else if(var1.getKeyCode() == 103) {
                                GraphicalRenderer.this.field_363.method_256(2, false);
                            } else if(var1.getKeyCode() == 105) {
                                GraphicalRenderer.this.field_363.method_260(2, false);
                            } else if(var1.getKeyCode() == 99) {
                                GraphicalRenderer.this.field_363.method_250(2, false);
                            } else if(var1.getKeyCode() == 98) {
                                GraphicalRenderer.this.field_363.method_258(2, false);
                            } else {
                                var2 = false;
                            }
                        } else {
                            GraphicalRenderer.this.field_363.method_258(1, false);
                        }
                    } else {
                        GraphicalRenderer.this.field_363.method_250(1, false);
                    }

                    if(var2) {
                        var1.consume();
                    }

                }
            }
        };
        this.field_353.setSize(var1, var2);
        this.field_353.setPreferredSize(new Dimension(var1, var2));
        this.field_353.setFocusTraversalKeysEnabled(false);
        this.field_353.addKeyListener(var3);
        Frame var4 = new Frame("CodeRacing 2015");
        var4.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                System.exit(0);
            }
        });
        var4.setFocusTraversalKeysEnabled(false);
        var4.addKeyListener(var3);
        var4.add(this.field_353);
        var4.setResizable(false);
        var4.setVisible(true);
        var4.pack();
        this.method_524();
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h) void
    public void render(DecoratedWorld var1) {
        this.method_523(var1);
    }

    public void close() {
        this.method_523((DecoratedWorld)null);
    }

    // $FF: renamed from: b (com.a.b.a.a.c.h) void
    private void method_523(DecoratedWorld var1) {
        while(true) {
            try {
                this.field_354.put(new GraphicalRenderer.class_216(var1, null));
                return;
            } catch (InterruptedException ignored) {
                ;
            }
        }
    }

    // $FF: renamed from: d () void
    private void method_524() {
        Graphics var1 = method_590(this.field_350.getGraphics());
        var1.setColor(Color.WHITE);
        var1.fillRect(0, 0, this.field_350.getWidth(), this.field_350.getHeight());
        var1.setColor(Color.BLACK);
        var1.setFont(new Font("Times New Roman", 1, this.method_570(0.0D, 30.0D).method_856()));
        FontMetrics var2 = var1.getFontMetrics();
        String var3 = "Waiting for game client to connect...";
        int var4 = var2.stringWidth(var3);
        var1.drawString(var3, (this.field_353.getWidth() - var4) / 2, this.field_353.getHeight() / 2 - var2.getHeight());
        String var5 = "Ожидание подключения стратегии...";
        int var6 = var2.stringWidth(var5);
        var1.drawString(var5, (this.field_353.getWidth() - var6) / 2, this.field_353.getHeight() / 2);
        this.field_353.repaint();
    }

    // $FF: renamed from: a (com.a.b.a.a.d.a$f) void
    private void method_525(GraphicalRenderer.class_216 var1) {
        this.method_526();
        DecoratedWorld var2 = var1.method_859();
        Preconditions.checkNotNull(var2);
        Game var3 = class_84.method_499(0L, var2.getTickCount(), this.gameProperties);
        Graphics var4 = method_590(this.field_350.getGraphics());
        if(this.field_342 > 0) {
            var4.setColor(Colors.method_787(Color.WHITE, 255 - this.field_342));
        } else {
            var4.setColor(Color.WHITE);
        }

        var4.fillRect(0, 0, this.field_350.getWidth(), this.field_350.getHeight());
        var4.setColor(Color.BLACK);
        this.method_533(var2);
        this.method_527(var2);
        this.method_528(var2);
        this.field_355.method_34(var4, var2, var3, this.field_350.getWidth(), this.field_350.getHeight(), this.field_347, this.field_348, this.field_345, this.field_346);
        this.method_534(var2, var4);
        if(this.field_359.get() >= 2) {
            this.method_536(var2, var4);
        }

        this.method_552(var2, var4);
        this.method_554(var2, var4);
        this.method_538(var2, var4);
        this.method_561(var2, var4);
        this.method_563(var2, var4);
        this.method_566(var2, var4);
        this.method_567(var2, var4);
        this.field_355.method_35(var4, var2, var3, this.field_350.getWidth(), this.field_350.getHeight(), this.field_347, this.field_348, this.field_345, this.field_346);
        if(this.field_361.get() && this.field_351 != null) {
            var4.drawImage(this.field_351, 0, this.field_350.getHeight() - this.field_351.getHeight(), (ImageObserver)null);
            var4.drawImage(this.field_352, 0, this.field_350.getHeight() - this.field_352.getHeight(), (ImageObserver)null);
        }

        this.field_353.getGraphics().drawImage(this.field_350, 0, 0, (ImageObserver)null);
    }

    // $FF: renamed from: e () void
    private void method_526() {
        while(this.field_357.get() && this.field_358.getAndDecrement() <= 0) {
            this.field_358.incrementAndGet();
            ThreadUtil.sleep(this.field_356.get());
        }

        this.field_358.set(0);
    }

    // $FF: renamed from: c (com.a.b.a.a.c.h) void
    private void method_527(DecoratedWorld var1) {
        if(this.field_351 == null) {
            List var2 = var1.getSystemData() instanceof List?(List)var1.getSystemData():null;
            if(var2 == null) {
                return;
            }

            GraphicalRenderer.class_218 var3 = this.method_570((double)(Math.min(var1.getWidth(), 8) * 32), (double)(Math.min(var1.getHeight(), 8) * 32));
            this.field_351 = new BufferedImage(var3.method_855(), var3.method_856(), 2);
            Graphics var4 = method_590(this.field_351.getGraphics());
            var4.setColor(new Color(245, 245, 245, 192));
            var4.fillRect(0, 0, this.field_351.getWidth(), this.field_351.getHeight());
            var4.setColor(Color.BLACK);
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
                Object var6 = var5.next();
                method_529(var4, var1, var6, this.field_351.getWidth(), this.field_351.getHeight());
            }
        }

    }

    // $FF: renamed from: d (com.a.b.a.a.c.h) void
    private void method_528(DecoratedWorld var1) {
        if(this.field_352 == null) {
            GraphicalRenderer.class_218 var2 = this.method_570((double)(Math.min(var1.getWidth(), 8) * 32), (double)(Math.min(var1.getHeight(), 8) * 32));
            this.field_352 = new BufferedImage(var2.method_855(), var2.method_856(), 2);
        }

        int var18 = this.field_352.getWidth();
        int var3 = this.field_352.getHeight();
        Graphics var4 = method_590(this.field_352.getGraphics());
        if(var4 instanceof Graphics2D) {
            Graphics2D var5 = (Graphics2D)var4;
            var5.setBackground(new Color(0, 0, 0, 0));
            var4.clearRect(0, 0, var18, var3);
        }

        double var19 = (double)var1.getWidth() * 800.0D;
        double var7 = (double)var1.getHeight() * 800.0D;
        Car[] var9 = var1.getCars();
        Arrays.sort(var9, new Comparator() {
            // $FF: renamed from: a (com.a.b.a.a.c.c, com.a.b.a.a.c.c) int
            public int method_517(Car var1, Car var2) {
                if(Math.abs(var1.getX() - var2.getX()) < Math.abs(var1.getY() - var2.getY())) {
                    if(var1.getY() > var2.getY()) {
                        return 1;
                    }

                    if(var1.getY() < var2.getY()) {
                        return -1;
                    }
                } else {
                    if(var1.getX() > var2.getX()) {
                        return 1;
                    }

                    if(var1.getX() < var2.getX()) {
                        return -1;
                    }
                }

                return Long.compare(var1.getId(), var2.getId());
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_517((Car)var1, (Car)var2);
            }
        });
        Car[] var10 = var9;
        int var11 = var9.length;

        for(int var12 = 0; var12 < var11; ++var12) {
            Car var13 = var10[var12];
            var4.setColor(method_591(var13.getPlayerId()));
            double var14 = class_85.method_500(new class_128(var13.getWidth(), var13.getHeight())) * 1.5D;
            GraphicalRenderer.class_218 var16 = method_574(var13.getX() - var14, var13.getY() - var14, 0.0D, 0.0D, var19, var7, var18, var3);
            GraphicalRenderer.class_218 var17 = method_572(2.0D * var14, 2.0D * var14, var19, var7, var18, var3);
            var4.fillOval(var16.method_855(), var16.method_856(), var17.method_855(), var17.method_856());
        }

    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.h, java.lang.Object, int, int) void
    private static void method_529(Graphics var0, DecoratedWorld var1, Object var2, int var3, int var4) {
        double var5 = (double)var1.getWidth() * 800.0D;
        double var7 = (double)var1.getHeight() * 800.0D;
        if(var2 instanceof class_52) {
            class_52 var14 = (class_52)var2;
            class_127 var12 = (class_127)var14.method_279().getForm();
            method_530(var0, var12, var5, var7, var3, var4);
        } else if(var2 instanceof class_54) {
            class_54 var13 = (class_54)var2;
            class_126 var11 = (class_126)var13.method_279().getForm();
            method_531(var0, var13, var11, var5, var7, var3, var4);
        } else {
            if(var2 instanceof class_57) {
                class_57 var9 = (class_57)var2;
                if(var9.method_360() != null) {
                    method_529(var0, var1, var9.method_360(), var3, var4);
                    return;
                }

                class_129 var10 = (class_129)var9.method_279().getForm();
                method_532(var0, var9, var10, var5, var7, var3, var4);
            }

        }
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.c.a.d, double, double, int, int) void
    private static void method_530(Graphics var0, class_127 var1, double var2, double var4, int var6, int var7) {
        GraphicalRenderer.class_218 var8 = method_574(var1.method_823(), var1.method_824(), 0.0D, 0.0D, var2, var4, var6, var7);
        GraphicalRenderer.class_218 var9 = method_574(var1.method_825(), var1.method_826(), 0.0D, 0.0D, var2, var4, var6, var7);
        var0.drawLine(var8.method_855(), var8.method_856(), var9.method_855(), var9.method_856());
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.b.d.b.a.b.a, com.a.c.a.a, double, double, int, int) void
    private static void method_531(Graphics var0, class_54 var1, class_126 var2, double var3, double var5, int var7, int var8) {
        double var9 = var1.method_279().getX();
        double var11 = var1.method_279().getY();
        double var13 = -var1.method_279().getAngle() - var2.method_821();
        double var15 = -var2.method_822();
        Vector2D var17 = (new Vector2D(var2.method_820(), 0.0D)).rotate(-var13);
        Vector2D var18 = (new Vector2D(var2.method_820(), 0.0D)).rotate(-var13 - var15);
        GraphicalRenderer.class_218 var19 = method_574(var9 + var17.getX(), var11 + var17.getY(), 0.0D, 0.0D, var3, var5, var7, var8);
        GraphicalRenderer.class_218 var20 = method_574(var9 + var18.getX(), var11 + var18.getY(), 0.0D, 0.0D, var3, var5, var7, var8);
        var0.drawLine(var19.method_855(), var19.method_856(), var20.method_855(), var20.method_856());
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.b.d.b.a.a.b, com.a.c.a.b, double, double, int, int) void
    private static void method_532(Graphics var0, class_57 var1, class_129 var2, double var3, double var5, int var7, int var8) {
        double var9 = var1.method_279().getX();
        double var11 = var1.method_279().getY();
        double var13 = var2.method_829();
        GraphicalRenderer.class_218 var15 = method_574(var9 - var13, var11 - var13, 0.0D, 0.0D, var3, var5, var7, var8);
        GraphicalRenderer.class_218 var16 = method_572(2.0D * var13, 2.0D * var13, var3, var5, var7, var8);
        var0.drawOval(var15.method_855(), var15.method_856(), var16.method_855(), var16.method_856());
    }

    // $FF: renamed from: e (com.a.b.a.a.c.h) void
    private void method_533(DecoratedWorld var1) {
        Car[] var2 = var1.getCars();
        int var3 = var2.length;
        if(this.field_343.get() == Long.MIN_VALUE) {
            Arrays.sort(var2, new Comparator() {
                // $FF: renamed from: a (com.a.b.a.a.c.c, com.a.b.a.a.c.c) int
                public int method_643(Car var1, Car var2) {
                    return Long.compare(var1.getId(), var2.getId());
                }

                // $FF: synthetic method
                public int compare(Object var1, Object var2) {
                    return this.method_643((Car)var1, (Car)var2);
                }
            });

            for(int var4 = 0; var4 < var3; ++var4) {
                this.field_344.putIfAbsent(var4, var2[var4].getId());
            }

            Player var14 = null;
            Map var5 = var1.getDecoratedPlayerById();
            if(var5 != null) {
                Player[] var6 = var1.getPlayersUnsafe();
                int var7 = var6.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    Player var9 = var6[var8];
                    class_141 var10 = (class_141)var5.get(var9.getId());
                    if(var10 != null && var10.isKeyboardPlayer()) {
                        var14 = var9;
                        break;
                    }
                }
            }

            if(var14 == null) {
                if(var3 > 0) {
                    this.field_343.set(var2[0].getId());
                }
            } else {
                for(int var17 = 0; var17 < var3; ++var17) {
                    Car var19 = var2[var17];
                    if(var19.getPlayerId() == var14.getId() && var19.getTeammateIndex() == 0) {
                        this.field_343.set(var19.getId());
                        break;
                    }
                }
            }
        }

        if(this.field_343.get() != Long.MIN_VALUE) {
            Car var16 = null;

            for(int var15 = 0; var15 < var3; ++var15) {
                Car var18 = var2[var15];
                if(var18.getId() == this.field_343.get()) {
                    var16 = var18;
                    break;
                }
            }

            if(var16 != null) {
                this.field_349.lock();

                try {
                    this.field_347 = var16.getX() - this.field_345 * 0.5D;
                    if(this.field_347 >= 0.0D && this.field_345 < (double)var1.getWidth() * 800.0D) {
                        if(this.field_347 + this.field_345 > (double)var1.getWidth() * 800.0D) {
                            this.field_347 = (double)var1.getWidth() * 800.0D - this.field_345;
                        }
                    } else {
                        this.field_347 = 0.0D;
                    }

                    this.field_348 = var16.getY() - this.field_346 * 0.5D;
                    if(this.field_348 >= 0.0D && this.field_346 < (double)var1.getHeight() * 800.0D) {
                        if(this.field_348 + this.field_346 > (double)var1.getHeight() * 800.0D) {
                            this.field_348 = (double)var1.getHeight() * 800.0D - this.field_346;
                        }
                    } else {
                        this.field_348 = 0.0D;
                    }
                } finally {
                    this.field_349.unlock();
                }

            }
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_534(DecoratedWorld var1, Graphics var2) {
        List var3 = var1.getSystemData() instanceof List?(List)var1.getSystemData():null;
        if(var3 != null) {
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
                Object var5 = var4.next();
                this.method_535(var2, var5);
            }
        }

    }

    // $FF: renamed from: a (java.awt.Graphics, java.lang.Object) void
    private void method_535(Graphics var1, Object var2) {
        if(var2 instanceof class_52) {
            class_52 var6 = (class_52)var2;
            class_127 var8 = (class_127)var6.method_279().getForm();
            this.method_577(var1, var8.method_823(), var8.method_824(), var8.method_825(), var8.method_826());
        } else if(var2 instanceof class_54) {
            class_54 var5 = (class_54)var2;
            class_126 var7 = (class_126)var5.method_279().getForm();
            this.method_583(var1, var5.method_279().getX(), var5.method_279().getY(), var7.method_820(), -var5.method_279().getAngle() - var7.method_821(), -var7.method_822());
        } else {
            if(var2 instanceof class_57) {
                class_57 var3 = (class_57)var2;
                if(var3.method_360() == null) {
                    class_129 var4 = (class_129)var3.method_279().getForm();
                    this.method_581(var1, var3.method_279().getX(), var3.method_279().getY(), var4.method_829());
                } else {
                    this.method_535(var1, var3.method_360());
                }
            }

        }
    }

    // $FF: renamed from: b (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_536(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        var2.setColor(field_339);

        int var4;
        double var5;
        for(var4 = 0; var4 <= var1.getWidth(); ++var4) {
            var5 = 800.0D * (double)var4;
            this.method_577(var2, var5, 0.0D, var5, 800.0D * (double)var1.getHeight());
        }

        for(var4 = 0; var4 <= var1.getHeight(); ++var4) {
            var5 = 800.0D * (double)var4;
            this.method_577(var2, 0.0D, var5, 800.0D * (double)var1.getWidth(), var5);
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: f (com.a.b.a.a.c.h) void
    private void method_537(DecoratedWorld var1) {
        Graphics var2 = method_590(this.field_350.getGraphics());
        Font var3 = new Font("Courier New", 1, this.method_570(0.0D, 48.0D).method_856());
        Player[] var4 = var1.getPlayers();
        Arrays.sort(var4, PlayerUtils.method_456());
        int var5 = 1;
        GraphicalRenderer.class_218 var6 = this.method_570(200.0D, 400.0D - 37.5D * (double)var4.length);
        int var7 = this.method_570(0.0D, 75.0D).method_856();
        Color var8 = var2.getColor();
        int var9 = 0;

        for(int var10 = var4.length; var9 < var10; ++var9) {
            Player var11 = var4[var9];
            int var12;
            if(var9 != 0 && var11.getScore() == var4[var9 - 1].getScore()) {
                var12 = var5;
            } else {
                var12 = var9 + 1;
                var5 = var12;
            }

            String var13 = String.format("%d. %-20s: %d", var12, var11.getName(), var11.getScore());
            int var14 = var6.method_855();
            int var15 = var6.method_856() + var7 * var9;
            var2.setColor(new Color(255, 255, 255, 64));
            var2.setFont(var3);

            for(int var16 = -2; var16 <= 2; ++var16) {
                for(int var17 = -2; var17 <= 2; ++var17) {
                    if((Math.abs(var16) != 2 || Math.abs(var17) != 2) && (var16 != 0 || var17 != 0)) {
                        var2.drawString(var13, var14 + var16, var15 + var17);
                    }
                }
            }

            var2.setColor(method_591(var11.getId()));
            var2.setFont(var3);
            var2.drawString(var13, var14, var15);
        }

        var2.setColor(var8);
        this.field_353.repaint();
    }

    // $FF: renamed from: c (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_538(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        Car[] var4 = var1.getCarsUnsafe();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Car var7 = var4[var6];
            this.method_539(var1, var7);
            if(var7.getRemainingNitroTicks() > 0) {
                ConcurrentMap var8 = (ConcurrentMap)this.field_364.get(var7.getId());

                for(int var9 = Math.max(var1.getTick() - Math.min(10, 120 - var7.getRemainingNitroTicks()), 0); var9 < var1.getTick(); ++var9) {
                    this.method_540(var1, var2, var7, (GraphicalRenderer.class_221)var8.get(var9), 110 - (var1.getTick() - var9) * 10);
                }
            }

            this.method_540(var1, var2, var7, (GraphicalRenderer.class_221)null, (Integer)null);
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, com.a.b.a.a.c.c) void
    private void method_539(DecoratedWorld var1, Car var2) {
        ConcurrentMap var3 = (ConcurrentMap)this.field_364.get(var2.getId());
        if(var3 == null) {
            this.field_364.putIfAbsent(var2.getId(), new ConcurrentHashMap());
            var3 = (ConcurrentMap)this.field_364.get(var2.getId());
        }

        var3.put(var1.getTick(), new GraphicalRenderer.class_221(new Point2D(var2.getX(), var2.getY()), var2.getAngle(), null));
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, java.awt.Graphics, com.a.b.a.a.c.c, com.a.b.a.a.d.a$b, java.lang.Integer) void
    private void method_540(DecoratedWorld var1, Graphics var2, Car var3, GraphicalRenderer.class_221 var4, Integer var5) {
        Color var6 = method_591(var3.getPlayerId());
        if(var4 != null && var5 != null) {
            var6 = Colors.method_787(var6, var5.intValue());
        }

        if(var3.isFinishedTrack() || class_79.method_482(var3)) {
            var6 = Colors.method_787(var6, var6.getAlpha() / 2);
        }

        var2.setColor(var6);
        Point2D var7 = var4 == null?new Point2D(var3.getX(), var3.getY()):var4.method_853();
        double var8 = var4 == null?var3.getAngle():var4.method_854();
        this.method_585(var2, class_85.method_501(var7, new Vector2D(var3.getWidth(), var3.getHeight()), var8));
        Vector2D var10 = (new Vector2D(1.0D, 0.0D)).rotate(var8);
        switch(var3.getType()) {
        case BUGGY:
            this.method_585(var2, class_85.method_501(var7.copy().add(var10.copy().multiply(-0.15D * var3.getWidth())), new Vector2D(0.5D * var3.getWidth(), 0.5D * var3.getHeight()), var8));
            break;
        case JEEP:
            this.method_585(var2, class_85.method_501(var7.copy().add(var10.copy().multiply(-0.3D * var3.getWidth())), new Vector2D(0.2D * var3.getWidth(), 0.8D * var3.getHeight()), var8));
            this.method_585(var2, class_85.method_501(var7.copy().add(var10.copy().multiply(-0.0D * var3.getWidth())), new Vector2D(0.2D * var3.getWidth(), 0.8D * var3.getHeight()), var8));
            break;
        default:
            throw new IllegalArgumentException("Unsupported car type: " + var3.getType() + '.');
        }

        this.method_548(var2, var3);
        this.method_549(var1, var2, var3);
        this.method_551(var1, var2, var3);
        if(var4 == null && this.field_359.get() >= 2) {
            this.method_541(var1, var2, var3);
        }

        if(var4 == null && this.field_360.get()) {
            this.method_543(var2, var3);
            this.method_544(var2, var3);
        }

    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_541(DecoratedWorld var1, Graphics var2, Car var3) {
        double var4 = 0.5D * Math.hypot(var3.getWidth(), var3.getHeight());
        double var6 = 0.5D * Math.min(var3.getWidth(), var3.getHeight());
        double var8 = var3.getDurability();
        GraphicalRenderer.class_218 var10 = this.method_573(var3.getX() - var6, var3.getY() - var4 - 2.0D);
        var2.setColor(var8 > 0.7D?Color.GREEN:(var8 > 0.3D?Color.ORANGE:Color.RED));
        this.method_542(var2, var6, var8, var10);
    }

    // $FF: renamed from: a (java.awt.Graphics, double, double, com.a.b.a.a.d.a$c) void
    private void method_542(Graphics var1, double var2, double var4, GraphicalRenderer.class_218 var6) {
        GraphicalRenderer.class_218 var7 = this.method_571(2.0D * var2 * var4, 3.0D);
        var1.fillRect(var6.method_855(), var6.method_856(), var7.method_855(), 3);
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_543(Graphics var1, Car var2) {
        double var3 = 0.5D * Math.hypot(var2.getWidth(), var2.getHeight());
        double var5 = 0.5D * Math.min(var2.getWidth(), var2.getHeight());
        var1.setColor(Color.BLACK);
        var1.setFont(new Font("Times New Roman", 1, this.method_571(0.0D, 0.7D * var5).method_856()));
        String var7 = NumberUtil.toInt(Math.floor(var2.getDurability() * 100.0D)) + "%";
        GraphicalRenderer.class_218 var8 = this.method_573(var2.getX(), var2.getY() - var3 - 10.0D);
        var1.drawString(var7, var8.method_855() - var1.getFontMetrics().stringWidth(var7) / 2, var8.method_856());
    }

    // $FF: renamed from: b (java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_544(Graphics var1, Car var2) {
        double var3 = 0.5D * Math.hypot(var2.getWidth(), var2.getHeight());
        double var5 = 0.5D * Math.min(var2.getWidth(), var2.getHeight());
        double var7 = 0.35D * var5;
        int[] var9 = new int[]{var2.getProjectileCount(), var2.getNitroChargeCount(), var2.getOilCanisterCount()};
        int var10 = var9.length;
        Point2D[] var11 = new Point2D[]{this.method_545(var1, var2, var3, var5, var7), this.method_546(var1, var2, var3, var7), this.method_547(var1, var2, var3, var5, var7)};
        var1.setColor(Color.BLACK);
        var1.setFont(new Font("Times New Roman", 1, this.method_571(0.0D, 2.0D * var7).method_856()));

        for(int var12 = 0; var12 < var10; ++var12) {
            Point2D var13 = var11[var12];
            GraphicalRenderer.class_218 var14 = this.method_573(var13.getX() + var7 + 5.0D, var13.getY() + 0.75D * var7);
            var1.drawString(Integer.toString(var9[var12]), var14.method_855(), var14.method_856());
        }

    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.c, double, double, double) com.codeforces.commons.geometry.Point2D
    private Point2D method_545(Graphics var1, Car var2, double var3, double var5, double var7) {
        Point2D var9 = new Point2D(var2.getX() + var3 + 2.0D + var7, var2.getY() - 0.85D * var5);
        var1.setColor(Color.BLACK);
        this.method_580(var1, var9, var7);
        var1.setColor(Color.WHITE);
        this.method_580(var1, var9, var7 / 2.0D);
        return var9;
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.c, double, double) com.codeforces.commons.geometry.Point2D
    private Point2D method_546(Graphics var1, Car var2, double var3, double var5) {
        Point2D var7 = new Point2D(var2.getX() + var3 + 2.0D + var5, var2.getY());
        var1.setColor(Color.BLACK);
        double var8 = var5 / 2.0D;

        for(int var10 = 0; var10 < 4; ++var10) {
            Point2D var11 = var7.copy().add(-var5 / 2.0D + var8 * (double)var10, 0.0D);
            double var12 = -var5 + var8 * (double)var10;
            this.method_578(var1, var11, var7.copy().add(var12, -var5));
            this.method_578(var1, var11, var7.copy().add(var12, var5));
        }

        return var7;
    }

    // $FF: renamed from: b (java.awt.Graphics, com.a.b.a.a.c.c, double, double, double) com.codeforces.commons.geometry.Point2D
    private Point2D method_547(Graphics var1, Car var2, double var3, double var5, double var7) {
        double var9 = var7 / 2.0D;
        Point2D var11 = new Point2D(var2.getX() + var3 + 2.0D + var7, var2.getY() + 0.85D * var5);
        var1.setColor(Color.BLACK);
        this.method_584(var1, var11.getX() - var7, var11.getY() - var7, 2.0D * var7, 2.0D * var7);
        this.method_584(var1, var11.getX() - var9, var11.getY() - var9, 2.0D * var9, 2.0D * var9);
        this.method_578(var1, var11.copy().add(-var7, var7), var11.copy().add(-var9, var9));
        this.method_578(var1, var11.copy().add(-var7, -var7), var11.copy().add(-var9, -var9));
        this.method_578(var1, var11.copy().add(var7, -var7), var11.copy().add(var9, -var9));
        this.method_578(var1, var11.copy().add(var7, var7), var11.copy().add(var9, var9));
        return var11;
    }

    // $FF: renamed from: c (java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_548(Graphics var1, Car var2) {
        Vector2D var3 = new Vector2D(var2.getWidth() * 0.15D, var2.getHeight() * 0.05D);
        double var4 = var2.getWheelTurn() * 0.5235987755982988D;
        double var6 = 0.5D * var2.getWidth() - 1.5D * var3.getX();
        double var8 = 0.5D * var2.getHeight();
        Point2D[] var10 = class_85.method_501((new Point2D(var2.getX(), var2.getY())).add((new Vector2D(var6, var8)).rotate(var2.getAngle())), var3, var2.getAngle() + var4);
        this.method_585(var1, var10);
        Point2D[] var11 = class_85.method_501((new Point2D(var2.getX(), var2.getY())).add((new Vector2D(var6, -var8)).rotate(var2.getAngle())), var3, var2.getAngle() + var4);
        this.method_585(var1, var11);
        Point2D[] var12 = class_85.method_501((new Point2D(var2.getX(), var2.getY())).add((new Vector2D(-var6, var8)).rotate(var2.getAngle())), var3, var2.getAngle() - 0.0D);
        this.method_585(var1, var12);
        Point2D[] var13 = class_85.method_501((new Point2D(var2.getX(), var2.getY())).add((new Vector2D(-var6, -var8)).rotate(var2.getAngle())), var3, var2.getAngle() - 0.0D);
        this.method_585(var1, var13);
    }

    // $FF: renamed from: b (com.a.b.a.a.c.h, java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_549(DecoratedWorld var1, Graphics var2, Car var3) {
        if(var3.getWidth() > var3.getHeight()) {
            if(var2 instanceof Graphics2D) {
                Graphics2D var4 = (Graphics2D)var2;
                Map var5 = var1.getDecoratedCarById();
                class_142 var6 = var5 == null?null:(class_142)var5.get(var3.getId());
                boolean var7 = var6 != null && var6.getBrakes() != null && var6.getBrakes();
                boolean var8 = var6 != null && var6.getRemainingHitRecoverTicks() != null;
                boolean var9 = ((long)var1.getTick() + var3.getId() * 3L) / 15L % 2L == 0L;
                double var10 = 0.5D + 0.2D * var3.getEnginePower();
                double var12 = var3.getHeight() / 12.0D;
                double var14 = var3.getWidth() * 0.5D - var3.getHeight() * (var8?0.3D:0.2D) - var12;
                double var16 = var3.getHeight() * 0.12D;
                Point2D var18 = (new Point2D(var3.getX(), var3.getY())).add((new Vector2D(var14, var16)).rotate(var3.getAngle()));
                if(var7) {
                    this.method_550(var4, var18, var3.getAngle());
                }

                double var19 = var8?(var9?1.2D:0.8D) * var12:var12;
                this.method_582(var2, var18, var19);
                this.method_580(var2, var18, var10 * var19);
                if(var7) {
                    var4.setTransform(new AffineTransform());
                }

                Point2D var21 = (new Point2D(var3.getX(), var3.getY())).add((new Vector2D(var14, -var16)).rotate(var3.getAngle()));
                if(var7) {
                    this.method_550(var4, var21, var3.getAngle());
                }

                double var22 = var8?(var9?0.8D:1.2D) * var12:var12;
                this.method_582(var2, var21, var22);
                this.method_580(var2, var21, var10 * var22);
                if(var7) {
                    var4.setTransform(new AffineTransform());
                }

            }
        }
    }

    // $FF: renamed from: a (java.awt.Graphics2D, com.codeforces.commons.geometry.Point2D, double) void
    private void method_550(Graphics2D var1, Point2D var2, double var3) {
        Point2D var5 = this.method_575(var2.getX(), var2.getY());
        var1.translate(var5.getX(), var5.getY());
        var1.rotate(var3);
        var1.scale(0.3D, 1.25D);
        var1.translate(-var5.getX(), -var5.getY());
    }

    // $FF: renamed from: c (com.a.b.a.a.c.h, java.awt.Graphics, com.a.b.a.a.c.c) void
    private void method_551(DecoratedWorld var1, Graphics var2, Car var3) {
        if(var3.getWidth() > var3.getHeight()) {
            Map var4 = var1.getDecoratedCarById();
            class_142 var5 = var4 == null?null:(class_142)var4.get(var3.getId());
            boolean var6 = var5 != null && var5.getRemainingHitRecoverTicks() != null;
            double var7 = var3.getHeight() / 6.0D;
            double var9;
            double var11;
            if(var6) {
                var9 = var7;
                var11 = var3.getWidth() * 0.5D - var3.getHeight() * 0.2D + var7;
            } else {
                var9 = var7 + (1.0D - var3.getDurability()) * var3.getHeight() / 2.0D;
                var11 = var3.getWidth() * 0.5D - var3.getHeight() * 0.1D - var9;
            }

            Vector2D var13 = (new Vector2D(var11, 0.0D)).rotate(var3.getAngle()).add(var3.getX(), var3.getY());
            this.method_583(var2, var13.getX(), var13.getY(), var9, (var6?3.141592653589793D:0.0D) - var3.getAngle() - 0.7853981633974483D * var7 / var9, 1.5707963267948966D * var7 / var9);
        }
    }

    // $FF: renamed from: d (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_552(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        OilSlick[] var4 = var1.getOilSlicksUnsafe();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            OilSlick var7 = var4[var6];
            this.method_553(var2, var7);
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.n) void
    private void method_553(Graphics var1, OilSlick var2) {
        var1.setColor(Colors.method_787(Color.BLACK, NumberUtil.toInt(255.0D * ((double) var2.getRemainingLifetime() / 600.0D))));
        this.method_579(var1, var2.getX(), var2.getY(), var2.getRadius());
    }

    // $FF: renamed from: e (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_554(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        Bonus[] var4 = var1.getBonusesUnsafe();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Bonus var7 = var4[var6];
            this.method_555(var2, var7);
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_555(Graphics var1, Bonus var2) {
        switch(var2.getType()) {
        case REPAIR_KIT:
            this.method_556(var1, var2);
            break;
        case AMMO_CRATE:
            this.method_557(var1, var2);
            break;
        case NITRO_BOOST:
            this.method_558(var1, var2);
            break;
        case OIL_CANISTER:
            this.method_559(var1, var2);
            break;
        case PURE_SCORE:
            this.method_560(var1, var2);
            break;
        default:
            throw new IllegalArgumentException("Unsupported bonus type: " + var2.getType() + '.');
        }

        var1.setColor(Color.BLACK);
        this.method_584(var1, var2.getX() - var2.getWidth() / 2.0D, var2.getY() - var2.getHeight() / 2.0D, var2.getWidth(), var2.getHeight());
    }

    // $FF: renamed from: b (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_556(Graphics var1, Bonus var2) {
        var1.setColor(new Color(14487062));
        double var3 = Math.min(var2.getWidth(), var2.getHeight()) * 0.4D;
        double var5 = Math.min(var2.getWidth(), var2.getHeight()) * 0.1D;
        this.method_585(var1, new Point2D(var2.getX() - var3, var2.getY() - var5), new Point2D(var2.getX() - var5, var2.getY() - var5), new Point2D(var2.getX() - var5, var2.getY() - var3), new Point2D(var2.getX() + var5, var2.getY() - var3), new Point2D(var2.getX() + var5, var2.getY() - var5), new Point2D(var2.getX() + var3, var2.getY() - var5), new Point2D(var2.getX() + var3, var2.getY() + var5), new Point2D(var2.getX() + var5, var2.getY() + var5), new Point2D(var2.getX() + var5, var2.getY() + var3), new Point2D(var2.getX() - var5, var2.getY() + var3), new Point2D(var2.getX() - var5, var2.getY() + var5), new Point2D(var2.getX() - var3, var2.getY() + var5));
    }

    // $FF: renamed from: c (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_557(Graphics var1, Bonus var2) {
        var1.setColor(new Color(2367521));
        this.method_579(var1, var2.getX(), var2.getY(), Math.min(var2.getWidth(), var2.getHeight()) / 2.0D);
        var1.setColor(Color.WHITE);
        this.method_579(var1, var2.getX(), var2.getY(), Math.min(var2.getWidth(), var2.getHeight()) / 4.0D);
    }

    // $FF: renamed from: d (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_558(Graphics var1, Bonus var2) {
        var1.setColor(new Color(1066854));
        double var3 = var2.getWidth() / 4.0D;
        double var5 = var2.getHeight() / 2.0D;

        for(int var7 = 0; var7 < 4; ++var7) {
            Point2D var8 = (new Point2D(var2.getX(), var2.getY())).add(-var3 + var3 * (double)var7, 0.0D);
            this.method_578(var1, var8, var8.copy().add(-var3, -var5));
            this.method_578(var1, var8, var8.copy().add(-var3, var5));
        }

    }

    // $FF: renamed from: e (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_559(Graphics var1, Bonus var2) {
        var1.setColor(new Color(12028738));
        this.method_584(var1, var2.getX() - var2.getWidth() / 4.0D, var2.getY() - var2.getHeight() / 4.0D, var2.getWidth() / 2.0D, var2.getHeight() / 2.0D);
        this.method_577(var1, var2.getX() - var2.getWidth() / 2.0D, var2.getY() - var2.getHeight() / 2.0D, var2.getX() - var2.getWidth() / 4.0D, var2.getY() - var2.getHeight() / 4.0D);
        this.method_577(var1, var2.getX() + var2.getWidth() / 2.0D, var2.getY() + var2.getHeight() / 2.0D, var2.getX() + var2.getWidth() / 4.0D, var2.getY() + var2.getHeight() / 4.0D);
        this.method_577(var1, var2.getX() + var2.getWidth() / 2.0D, var2.getY() - var2.getHeight() / 2.0D, var2.getX() + var2.getWidth() / 4.0D, var2.getY() - var2.getHeight() / 4.0D);
        this.method_577(var1, var2.getX() - var2.getWidth() / 2.0D, var2.getY() + var2.getHeight() / 2.0D, var2.getX() - var2.getWidth() / 4.0D, var2.getY() + var2.getHeight() / 4.0D);
    }

    // $FF: renamed from: f (java.awt.Graphics, com.a.b.a.a.c.a) void
    private void method_560(Graphics var1, Bonus var2) {
        var1.setColor(new Color(9526102));
        String var3 = "\u20bd";
        double var4 = var2.getHeight();
        Font var6 = new Font("Times New Roman", 1, this.method_571(0.0D, var4).method_856());
        var1.setFont(var6);
        GraphicalRenderer.class_218 var7 = this.method_573(var2.getX(), var2.getY() + var4 / 3.0D);
        var1.drawString(var3, var7.method_855() - var1.getFontMetrics().stringWidth(var3) / 2, var7.method_856());
    }

    // $FF: renamed from: f (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_561(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        Projectile[] var4 = var1.getProjectilesUnsafe();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Projectile var7 = var4[var6];
            this.method_562(var2, var7);
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.q) void
    private void method_562(Graphics var1, Projectile var2) {
        var1.setColor(Color.BLACK);
        this.method_579(var1, var2.getX(), var2.getY(), var2.getRadius());
        var1.setColor(Color.WHITE);
        this.method_579(var1, var2.getX(), var2.getY(), var2.getRadius() / 2.0D);
    }

    // $FF: renamed from: g (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_563(DecoratedWorld var1, Graphics var2) {
        Color var3 = var2.getColor();
        class_151[] var4 = var1.getEffects();
        Arrays.sort(var4, new Comparator() {
            // $FF: renamed from: a (com.a.b.a.a.c.j, com.a.b.a.a.c.j) int
            public int method_644(class_151 var1, class_151 var2) {
                return Integer.compare(var2.getTick(), var1.getTick());
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_644((class_151)var1, (class_151)var2);
            }
        });
        class_151[] var5 = var4;
        int var6 = var4.length;
        int var7 = 0;

        while(var7 < var6) {
            class_151 var8 = var5[var7];
            switch(var8.getType()) {
            case CAR_CONDITION_CHANGE:
                this.method_564(var1, var2, var8);
            case CAR_AND_BORDER_IMPACT:
            case CAR_AND_CAR_IMPACT:
            case CAR_AND_WASHER_IMPACT:
            case CAR_AND_TIRE_IMPACT:
            case DRIFTING:
                ++var7;
                break;
            default:
                throw new IllegalArgumentException("Unsupported effect type: " + var8.getType() + '.');
            }
        }

        var2.setColor(var3);
    }

    // $FF: renamed from: a (com.a.b.a.a.c.h, java.awt.Graphics, com.a.b.a.a.c.j) void
    private void method_564(DecoratedWorld var1, Graphics var2, class_151 var3) {
        Long var4 = var3.getAffectedUnitId();
        if(var4 != null) {
            Car var5 = method_565(var1, var4);
            if(var5 != null) {
                double var6 = 0.5D * Math.hypot(var5.getWidth(), var5.getHeight());
                double var8 = 0.5D * Math.min(var5.getWidth(), var5.getHeight());
                Font var10 = new Font("Times New Roman", 1, this.method_571(0.0D, (0.7D - 0.35D * (double)var3.getTick() / (double)var3.getType().getDuration()) * var8).method_856());
                var2.setFont(var10);
                Integer var11 = NumberUtil.toInt(var3.getAttribute("durabilityPercentsChange"));
                if(var11 != null && var11 != 0) {
                    GraphicalRenderer.class_218 var12 = this.method_573(var5.getX(), var5.getY() - var6 - 10.0D - (this.field_360.get()?0.7D * var8:0.0D) - 1.5D * (double)var3.getTick());
                    String var13;
                    Color var14;
                    if(var11 > 0) {
                        var13 = "+" + var11 + '%';
                        var14 = Color.GREEN;
                    } else {
                        var13 = var11 + "%";
                        var14 = Color.RED;
                    }

                    var14 = Colors.method_787(var14, NumberUtil.toInt(Math.round(255.0D * (1.0D - 0.75D * (double) var3.getTick() / (double) var3.getType().getDuration()))));
                    var2.setColor(var14);
                    var2.drawString(var13, var12.method_855() - var2.getFontMetrics().stringWidth(var13) / 2, var12.method_856());
                }

            }
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.c.v, long) com.a.b.a.a.c.c
    private static Car method_565(World var0, long var1) {
        Car[] var3 = var0.getCarsUnsafe();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Car var6 = var3[var5];
            if(var6.getId() == var1) {
                return var6;
            }
        }

        return null;
    }

    // $FF: renamed from: h (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_566(DecoratedWorld var1, Graphics var2) {
        if(this.field_359.get() >= 1) {
            var2.setFont(new Font("Courier New", 1, this.method_570(0.0D, 15.0D).method_856()));
            Player[] var3 = var1.getPlayers();
            Arrays.sort(var3, new Comparator() {
                // $FF: renamed from: a (com.a.b.a.a.c.o, com.a.b.a.a.c.o) int
                public int method_622(Player var1, Player var2) {
                    return Long.valueOf(var1.getId()).compareTo(Long.valueOf(var2.getId()));
                }

                // $FF: synthetic method
                public int compare(Object var1, Object var2) {
                    return this.method_622((Player)var1, (Player)var2);
                }
            });
            if(var3.length > 0) {
                this.method_569(var2, 20.0D, 30.0D, var3[0]);
            }

            if(var3.length > 1) {
                this.method_569(var2, 20.0D, 60.0D, var3[1]);
            }

            if(var3.length > 2) {
                this.method_569(var2, 235.0D, 30.0D, var3[2]);
            }

            if(var3.length > 3) {
                this.method_569(var2, 235.0D, 60.0D, var3[3]);
            }

            if(var3.length > 4) {
                this.method_569(var2, 450.0D, 30.0D, var3[4]);
            }

            if(var3.length > 5) {
                this.method_569(var2, 450.0D, 60.0D, var3[5]);
            }

            GraphicalRenderer.class_218 var4 = this.method_570(1070.0D, 770.0D);
            String var5 = var1.getTick() + " / " + (var1.getLastTickIndex() + 1);
            if(var5.length() < 20) {
                var5 = Strings.repeat(" ", 20 - var5.length()) + var5;
            }

            var2.drawString(var5, var4.method_855(), var4.method_856());
            GraphicalRenderer.class_218 var6 = this.method_570(1070.0D, 30.0D);
            String var7 = "Speed: " + this.method_568();
            if(var7.length() < 20) {
                var7 = Strings.repeat(" ", 20 - var7.length()) + var7;
            }

            var2.drawString(var7, var6.method_855(), var6.method_856());
            GraphicalRenderer.class_218 var8 = this.method_570(1070.0D, 55.0D);
            String var9 = "FPS: " + this.field_362.get();
            if(var9.length() < 20) {
                var9 = Strings.repeat(" ", 20 - var9.length()) + var9;
            }

            var2.drawString(var9, var8.method_855(), var8.method_856());
        }
    }

    // $FF: renamed from: i (com.a.b.a.a.c.h, java.awt.Graphics) void
    private void method_567(DecoratedWorld var1, Graphics var2) {
        byte var3 = 60;
        if(var1.getTick() < 4 * var3) {
            int var4 = var3 / 5;
            int var5 = var1.getTick() % var3;
            double var7 = 512.0D;
            String var6;
            if(var1.getTick() < var3) {
                var6 = "3";
            } else if(var1.getTick() < 2 * var3) {
                var6 = "2";
            } else if(var1.getTick() < 3 * var3) {
                var6 = "1";
            } else {
                var6 = "START!";
                var7 = 256.0D;
            }

            double var9;
            if(var5 < var4) {
                var9 = (double)var5 / (double)var4;
            } else if(var5 >= var3 - var4) {
                var9 = 1.0D - (double)(var5 - var3 + var4) / (double)var4;
            } else {
                var9 = 1.0D;
            }

            var2.setColor(Colors.method_787(field_340, NumberUtil.toInt(Math.round(var9 * 255.0D))));
            var2.setFont(new Font("Courier New", 1, this.method_570(0.0D, var7).method_856()));
            FontMetrics var11 = var2.getFontMetrics();
            GraphicalRenderer.class_218 var12 = this.method_570((1280.0D - (double)var11.stringWidth(var6)) / 2.0D, 400.0D + var7 / 4.0D);
            var2.drawString(var6, var12.method_855(), var12.method_856());
        }
    }

    // $FF: renamed from: f () java.lang.String
    private String method_568() {
        long var1 = this.field_356.get();
        int var3 = Arrays.binarySearch(field_338, var1);
        switch(var3) {
        case 0:
            return "fast forward";
        case 1:
            return "very fast";
        case 2:
            return "fast";
        case 3:
            return "normal";
        case 4:
            return "slow";
        case 5:
            return "very slow";
        case 6:
            return "slideshow";
        default:
            throw new IllegalStateException(String.format("Illegal current screen interval index %d for interval %d ms.", new Object[]{Integer.valueOf(var3), Long.valueOf(var1)}));
        }
    }

    // $FF: renamed from: a (java.awt.Graphics, double, double, com.a.b.a.a.c.o) void
    private void method_569(Graphics var1, double var2, double var4, Player var6) {
        Color var7 = var1.getColor();
        var1.setColor(method_591(var6.getId()));
        GraphicalRenderer.class_218 var8 = this.method_570(var2, var4);
        var1.drawString(String.format("%-17s: %d", new Object[]{(var6.isStrategyCrashed()?"? ":"") + var6.getName(), Integer.valueOf(var6.getScore())}), var8.method_855(), var8.method_856());
        var1.setColor(var7);
    }

    // $FF: renamed from: a (double, double) com.a.b.a.a.d.a$c
    private GraphicalRenderer.class_218 method_570(double var1, double var3) {
        return new GraphicalRenderer.class_218(var1 * (double)this.gameProperties.getScreenWidth() / 1280.0D, var3 * (double)this.gameProperties.getScreenHeight() / 800.0D, null);
    }

    // $FF: renamed from: b (double, double) com.a.b.a.a.d.a$c
    private GraphicalRenderer.class_218 method_571(double var1, double var3) {
        return method_574(var1, var3, 0.0D, 0.0D, this.field_345, this.field_346, this.field_353.getWidth(), this.field_353.getHeight());
    }

    // $FF: renamed from: a (double, double, double, double, int, int) com.a.b.a.a.d.a$c
    private static GraphicalRenderer.class_218 method_572(double var0, double var2, double var4, double var6, int var8, int var9) {
        return method_574(var0, var2, 0.0D, 0.0D, var4, var6, var8, var9);
    }

    // $FF: renamed from: c (double, double) com.a.b.a.a.d.a$c
    private GraphicalRenderer.class_218 method_573(double var1, double var3) {
        return method_574(var1, var3, this.field_347, this.field_348, this.field_345, this.field_346, this.field_353.getWidth(), this.field_353.getHeight());
    }

    // $FF: renamed from: a (double, double, double, double, double, double, int, int) com.a.b.a.a.d.a$c
    private static GraphicalRenderer.class_218 method_574(double var0, double var2, double var4, double var6, double var8, double var10, int var12, int var13) {
        return new GraphicalRenderer.class_218((var0 - var4) * (double)var12 / var8, (var2 - var6) * (double)var13 / var10, null);
    }

    // $FF: renamed from: d (double, double) com.codeforces.commons.geometry.Point2D
    private Point2D method_575(double var1, double var3) {
        return method_576(var1, var3, this.field_347, this.field_348, this.field_345, this.field_346, (double)this.field_353.getWidth(), (double)this.field_353.getHeight());
    }

    // $FF: renamed from: a (double, double, double, double, double, double, double, double) com.codeforces.commons.geometry.Point2D
    private static Point2D method_576(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {
        return new Point2D((var0 - var4) * var12 / var8, (var2 - var6) * var14 / var10);
    }

    // $FF: renamed from: a (java.awt.Graphics, double, double, double, double) void
    private void method_577(Graphics var1, double var2, double var4, double var6, double var8) {
        if(this.method_586(method_587(var2, var4, var6, var8))) {
            GraphicalRenderer.class_218 var10 = this.method_573(var2, var4);
            GraphicalRenderer.class_218 var11 = this.method_573(var6, var8);
            var1.drawLine(var10.method_855(), var10.method_856(), var11.method_855(), var11.method_856());
        }
    }

    // $FF: renamed from: a (java.awt.Graphics, com.codeforces.commons.geometry.Point2D, com.codeforces.commons.geometry.Point2D) void
    private void method_578(Graphics var1, Point2D var2, Point2D var3) {
        this.method_577(var1, var2.getX(), var2.getY(), var3.getX(), var3.getY());
    }

    // $FF: renamed from: a (java.awt.Graphics, double, double, double) void
    private void method_579(Graphics var1, double var2, double var4, double var6) {
        if(this.method_586(method_588(var2, var4, var6))) {
            GraphicalRenderer.class_218 var8 = this.method_573(var2 - var6, var4 - var6);
            GraphicalRenderer.class_218 var9 = this.method_571(2.0D * var6, 2.0D * var6);
            var1.fillOval(var8.method_855(), var8.method_856(), var9.method_855(), var9.method_856());
        }
    }

    // $FF: renamed from: a (java.awt.Graphics, com.codeforces.commons.geometry.Point2D, double) void
    private void method_580(Graphics var1, Point2D var2, double var3) {
        this.method_579(var1, var2.getX(), var2.getY(), var3);
    }

    // $FF: renamed from: b (java.awt.Graphics, double, double, double) void
    private void method_581(Graphics var1, double var2, double var4, double var6) {
        if(this.method_586(method_588(var2, var4, var6))) {
            GraphicalRenderer.class_218 var8 = this.method_573(var2 - var6, var4 - var6);
            GraphicalRenderer.class_218 var9 = this.method_571(2.0D * var6, 2.0D * var6);
            var1.drawOval(var8.method_855(), var8.method_856(), var9.method_855(), var9.method_856());
        }
    }

    // $FF: renamed from: b (java.awt.Graphics, com.codeforces.commons.geometry.Point2D, double) void
    private void method_582(Graphics var1, Point2D var2, double var3) {
        this.method_581(var1, var2.getX(), var2.getY(), var3);
    }

    // $FF: renamed from: a (java.awt.Graphics, double, double, double, double, double) void
    private void method_583(Graphics var1, double var2, double var4, double var6, double var8, double var10) {
        if(this.method_586(method_588(var2, var4, var6))) {
            GraphicalRenderer.class_218 var12 = this.method_573(var2 - var6, var4 - var6);
            GraphicalRenderer.class_218 var13 = this.method_571(2.0D * var6, 2.0D * var6);
            var1.drawArc(var12.method_855(), var12.method_856(), var13.method_855(), var13.method_856(), NumberUtil.toInt(Math.round(var8 * 57.29577951308232D)), NumberUtil.toInt(Math.round(var10 * 57.29577951308232D)));
        }
    }

    // $FF: renamed from: b (java.awt.Graphics, double, double, double, double) void
    private void method_584(Graphics var1, double var2, double var4, double var6, double var8) {
        if(this.method_586(method_589(var2, var4, var6, var8))) {
            GraphicalRenderer.class_218 var10 = this.method_573(var2, var4);
            GraphicalRenderer.class_218 var11 = this.method_571(var6, var8);
            var1.drawRect(var10.method_855(), var10.method_856(), var11.method_855(), var11.method_856());
        }
    }

    // $FF: renamed from: a (java.awt.Graphics, com.codeforces.commons.geometry.Point2D[]) void
    private void method_585(Graphics var1, Point2D... var2) {
        int var3 = var2.length;

        Point2D var5;
        for(int var4 = 1; var4 < var3; ++var4) {
            var5 = var2[var4];
            Point2D var6 = var2[var4 - 1];
            this.method_577(var1, var5.getX(), var5.getY(), var6.getX(), var6.getY());
        }

        Point2D var7 = var2[0];
        var5 = var2[var3 - 1];
        this.method_577(var1, var7.getX(), var7.getY(), var5.getX(), var5.getY());
    }

    // $FF: renamed from: a (com.a.b.a.a.d.a$a) boolean
    private boolean method_586(GraphicalRenderer.class_220 var1) {
        return var1.method_851() >= this.field_347 && var1.method_849() <= this.field_347 + this.field_345 && var1.method_852() >= this.field_348 && var1.method_850() <= this.field_348 + this.field_346;
    }

    // $FF: renamed from: a (double, double, double, double) com.a.b.a.a.d.a$a
    private static GraphicalRenderer.class_220 method_587(double var0, double var2, double var4, double var6) {
        return new GraphicalRenderer.class_220(Math.min(var0, var4), Math.min(var2, var6), Math.max(var0, var4), Math.max(var2, var6), null);
    }

    // $FF: renamed from: a (double, double, double) com.a.b.a.a.d.a$a
    private static GraphicalRenderer.class_220 method_588(double var0, double var2, double var4) {
        return new GraphicalRenderer.class_220(var0 - var4, var2 - var4, var0 + var4, var2 + var4, null);
    }

    // $FF: renamed from: b (double, double, double, double) com.a.b.a.a.d.a$a
    private static GraphicalRenderer.class_220 method_589(double var0, double var2, double var4, double var6) {
        return new GraphicalRenderer.class_220(var0, var2, var0 + var4, var2 + var6, null);
    }

    // $FF: renamed from: a (java.awt.Graphics) java.awt.Graphics
    private static Graphics method_590(Graphics var0) {
        if(var0 instanceof Graphics2D) {
            Graphics2D var1 = (Graphics2D)var0;
            var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            var1.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        return var0;
    }

    // $FF: renamed from: a (long) java.awt.Color
    private static Color method_591(long var0) {
        switch(NumberUtil.toInt(var0)) {
        case 1:
            return Colors.method_784();
        case 2:
            return Colors.method_783();
        case 3:
            return Colors.method_785();
        case 4:
            return Colors.method_786();
        default:
            throw new IllegalArgumentException("Can\'t get color for Player {id=" + var0 + "}.");
        }
    }

    // $FF: renamed from: a () com.a.b.a.a.e.a.c$a
    public class_179.class_209 method_592() {
        return this.field_363;
    }

    private static final class class_217 implements GraphicalRenderer.class_219 {
        // $FF: renamed from: a java.lang.Object
        private final Object field_617;
        // $FF: renamed from: b com.codeforces.commons.reflection.MethodSignature
        private volatile MethodSignature field_618;
        // $FF: renamed from: c java.lang.reflect.Method
        private volatile Method field_619;
        // $FF: renamed from: d com.codeforces.commons.reflection.MethodSignature
        private volatile MethodSignature field_620;
        // $FF: renamed from: e java.lang.reflect.Method
        private volatile Method field_621;
        // $FF: renamed from: f com.a.b.a.a.c.v
        private volatile World field_622;
        // $FF: renamed from: g com.a.b.a.a.c.l
        private volatile Game field_623;
        // $FF: renamed from: h java.lang.Object
        private volatile Object field_624;
        // $FF: renamed from: i java.lang.Object
        private volatile Object field_625;

        private class_217(Object var1) {
            this.field_617 = var1;
            if(this.field_617 != null) {
                Map var2 = ReflectionUtil.getPublicMethodBySignatureMap(var1.getClass());
                Iterator var3 = var2.entrySet().iterator();

                while(true) {
                    while(var3.hasNext()) {
                        Entry var4 = (Entry)var3.next();
                        MethodSignature var5 = (MethodSignature)var4.getKey();
                        List var6 = var5.getParameterTypes();
                        if("beforeDrawScene".equals(var5.getName()) && var6.size() == 9 && var6.get(0) == Graphics.class && "World".equals(((Class)var6.get(1)).getSimpleName()) && ((Class)var6.get(1)).getPackage() != null && "model".equals(((Class)var6.get(1)).getPackage().getName()) && "Game".equals(((Class)var6.get(2)).getSimpleName()) && ((Class)var6.get(2)).getPackage() != null && "model".equals(((Class)var6.get(2)).getPackage().getName()) && var6.get(3) == Integer.TYPE && var6.get(4) == Integer.TYPE && var6.get(5) == Double.TYPE && var6.get(6) == Double.TYPE && var6.get(7) == Double.TYPE && var6.get(8) == Double.TYPE) {
                            this.field_618 = var5;
                            this.field_619 = (Method)var4.getValue();
                        } else if("afterDrawScene".equals(var5.getName()) && var6.size() == 9 && var6.get(0) == Graphics.class && "World".equals(((Class)var6.get(1)).getSimpleName()) && ((Class)var6.get(1)).getPackage() != null && "model".equals(((Class)var6.get(1)).getPackage().getName()) && "Game".equals(((Class)var6.get(2)).getSimpleName()) && ((Class)var6.get(2)).getPackage() != null && "model".equals(((Class)var6.get(2)).getPackage().getName()) && var6.get(3) == Integer.TYPE && var6.get(4) == Integer.TYPE && var6.get(5) == Double.TYPE && var6.get(6) == Double.TYPE && var6.get(7) == Double.TYPE && var6.get(8) == Double.TYPE) {
                            this.field_620 = var5;
                            this.field_621 = (Method)var4.getValue();
                        }
                    }

                    return;
                }
            }
        }

        // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.v, com.a.b.a.a.c.l, int, int, double, double, double, double) void
        public void method_34(Graphics var1, World var2, Game var3, int var4, int var5, double var6, double var8, double var10, double var12) {
            if(this.field_619 != null) {
                try {
                    List var14 = this.field_618.getParameterTypes();
                    Object var15 = var2 == this.field_622?this.field_624:method_858(var2, (Class)var14.get(1));
                    Object var16 = var3 == this.field_623?this.field_625:method_858(var3, (Class)var14.get(2));
                    this.field_622 = var2;
                    this.field_623 = var3;
                    this.field_624 = var15;
                    this.field_625 = var16;
                    this.field_619.invoke(this.field_617, var1, var15, var16, Integer.valueOf(var4), Integer.valueOf(var5), Double.valueOf(var6), Double.valueOf(var8), Double.valueOf(var10), Double.valueOf(var12));
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException var17) {
                    GraphicalRenderer.logger.error("Can\'t invoke beforeDrawScene(...) method of custom renderer.", var17);
                }

            }
        }

        // $FF: renamed from: b (java.awt.Graphics, com.a.b.a.a.c.v, com.a.b.a.a.c.l, int, int, double, double, double, double) void
        public void method_35(Graphics var1, World var2, Game var3, int var4, int var5, double var6, double var8, double var10, double var12) {
            if(this.field_621 != null) {
                try {
                    List var14 = this.field_620.getParameterTypes();
                    Object var15 = var2 == this.field_622?this.field_624:method_858(var2, (Class)var14.get(1));
                    Object var16 = var3 == this.field_623?this.field_625:method_858(var3, (Class)var14.get(2));
                    this.field_622 = var2;
                    this.field_623 = var3;
                    this.field_624 = var15;
                    this.field_625 = var16;
                    this.field_621.invoke(this.field_617, var1, var15, var16, Integer.valueOf(var4), Integer.valueOf(var5), Double.valueOf(var6), Double.valueOf(var8), Double.valueOf(var10), Double.valueOf(var12));
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException var17) {
                    GraphicalRenderer.logger.error("Can\'t invoke afterDrawScene(...) method of custom renderer.", var17);
                }

            }
        }

        // $FF: renamed from: a (java.lang.Object, java.lang.Class) java.lang.Object
        private static Object method_858(Object var0, Class var1) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return class_123.method_799(var0, var1);
        }

        // $FF: synthetic method
        class_217(Object var1, Object var2) {
            this(var1);
        }
    }

    private static final class class_218 {
        // $FF: renamed from: a int
        private int field_615;
        // $FF: renamed from: b int
        private int field_616;

        private class_218(double var1, double var3) {
            this.field_615 = method_857(Math.round(var1));
            this.field_616 = method_857(Math.round(var3));
        }

        private class_218() {
        }

        // $FF: renamed from: a () int
        public int method_855() {
            return this.field_615;
        }

        // $FF: renamed from: b () int
        public int method_856() {
            return this.field_616;
        }

        // $FF: renamed from: a (double) int
        private static int method_857(double var0) {
            int var2 = (int)var0;
            if(Math.abs((double)var2 - var0) < 1.0D) {
                return var2;
            } else {
                throw new IllegalArgumentException("Can\'t convert double " + var0 + " to int.");
            }
        }

        // $FF: synthetic method
        class_218(double var1, double var3, Object var5) {
            this(var1, var3);
        }
    }

    private interface class_219 {
        // $FF: renamed from: a (java.awt.Graphics, com.a.b.a.a.c.v, com.a.b.a.a.c.l, int, int, double, double, double, double) void
        void method_34(Graphics var1, World var2, Game var3, int var4, int var5, double var6, double var8, double var10, double var12);

        // $FF: renamed from: b (java.awt.Graphics, com.a.b.a.a.c.v, com.a.b.a.a.c.l, int, int, double, double, double, double) void
        void method_35(Graphics var1, World var2, Game var3, int var4, int var5, double var6, double var8, double var10, double var12);
    }

    private static final class class_216 {
        // $FF: renamed from: a com.a.b.a.a.c.h
        private final DecoratedWorld field_626;

        private class_216(DecoratedWorld var1) {
            this.field_626 = var1;
        }

        // $FF: renamed from: a () com.a.b.a.a.c.h
        public DecoratedWorld method_859() {
            return this.field_626;
        }

        // $FF: synthetic method
        class_216(DecoratedWorld var1, Object var2) {
            this(var1);
        }
    }

    private static final class class_220 {
        // $FF: renamed from: a double
        private final double field_609;
        // $FF: renamed from: b double
        private final double field_610;
        // $FF: renamed from: c double
        private final double field_611;
        // $FF: renamed from: d double
        private final double field_612;

        private class_220(double var1, double var3, double var5, double var7) {
            this.field_609 = var1;
            this.field_610 = var3;
            this.field_611 = var5;
            this.field_612 = var7;
        }

        // $FF: renamed from: a () double
        public double method_849() {
            return this.field_609;
        }

        // $FF: renamed from: b () double
        public double method_850() {
            return this.field_610;
        }

        // $FF: renamed from: c () double
        public double method_851() {
            return this.field_611;
        }

        // $FF: renamed from: d () double
        public double method_852() {
            return this.field_612;
        }

        // $FF: synthetic method
        class_220(double var1, double var3, double var5, double var7, Object var9) {
            this(var1, var3, var5, var7);
        }
    }

    private static final class class_221 {
        // $FF: renamed from: a com.codeforces.commons.geometry.Point2D
        private final Point2D field_613;
        // $FF: renamed from: b double
        private final double field_614;

        private class_221(Point2D var1, double var2) {
            this.field_613 = var1;
            this.field_614 = var2;
        }

        // $FF: renamed from: a () com.codeforces.commons.geometry.Point2D
        public Point2D method_853() {
            return this.field_613;
        }

        // $FF: renamed from: b () double
        public double method_854() {
            return this.field_614;
        }

        // $FF: synthetic method
        class_221(Point2D var1, double var2, Object var4) {
            this(var1, var2);
        }
    }
}
