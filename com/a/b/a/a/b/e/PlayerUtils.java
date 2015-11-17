package com.a.b.a.a.b.e;

import com.a.b.a.a.a.GameProperties;
import com.a.b.a.a.b.class_171;
import com.a.b.a.a.c.Player;
import com.a.b.a.a.d.Renderer;
import com.a.b.a.a.d.GraphicalRenderer;
import com.a.b.a.a.e.a.class_179;
import com.a.b.a.a.e.a.class_180;
import com.a.b.a.a.e.a.class_181;
import com.a.b.a.a.e.a.class_182;
import com.a.b.a.a.e.a.a.class_200;
import com.codeforces.commons.text.StringUtil;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.b.e.l
public final class PlayerUtils {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(PlayerUtils.class);

    private PlayerUtils() {
        throw new UnsupportedOperationException();
    }

    // $FF: renamed from: a (com.a.b.a.a.a.b, int, java.lang.String, java.lang.String, int, java.util.List) com.a.b.a.a.b.n
    public static class_171 instantiatePlayer(GameProperties gameProperties, int playerIndex, String var2, String playerDefinition, int teamSize, List var5) {
        method_452(var2, playerDefinition);

        try {
            if(playerDefinition.endsWith(".class")) {
                return new class_171(var2, new class_181(playerDefinition, teamSize));
            } else {
                if("#KeyboardPlayer".equals(playerDefinition)) {

                    for (Object aVar5 : var5) {
                        Renderer var12 = (Renderer) aVar5;
                        if (var12 instanceof GraphicalRenderer) {
                            return new class_171(var2, new class_179(teamSize, ((GraphicalRenderer) var12).method_592()));
                        }
                    }
                } else {
                    class_180 var11;
                    if("#LocalTestPlayer".equals(playerDefinition)) {
                        var11 = class_180.createRemote(gameProperties, playerIndex, playerDefinition, teamSize);
                        return method_451(var2, var11);
                    }

                    if(class_200.method_1063(playerDefinition) != null) {
                        var11 = class_180.createFromFile(gameProperties, playerIndex, playerDefinition, teamSize);
                        return method_451(var2, var11);
                    }
                }

                String var10 = String.format("Unsupported player definition: \'%s\'.", playerDefinition);
                logger.error(var10);
                throw new IllegalArgumentException(var10);
            }
        } catch (RuntimeException var9) {
            String var7 = String.format("Can\'t load player defined by \'%s\'.", playerDefinition);
            logger.error(var7, var9);
            class_171 var8 = new class_171(var2, new class_182(teamSize));
            var8.method_924("При инициализации игрока возникло непредвиденное исключение.");
            return var8;
        }
    }

    // $FF: renamed from: a (java.lang.String, com.a.b.a.a.e.a.d) com.a.b.a.a.b.n
    private static class_171 method_451(String var0, class_180 var1) {
        try {
            var1.method_979();
            return new class_171(var0, var1);
        } catch (RuntimeException var3) {
            var3.printStackTrace();
            var1.close();
            throw var3;
        }
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) void
    private static void method_452(String var0, String var1) {
        if(StringUtil.isBlank(var0)) {
            throw new IllegalArgumentException("Argument \'name\' is blank.");
        } else if(StringUtil.isBlank(var1)) {
            throw new IllegalArgumentException("Argument \'playerDefinition\' is blank.");
        }
    }

    // $FF: renamed from: a (com.a.b.a.a.b.n, com.a.b.a.a.b.n) com.a.b.a.a.c.o
    public static Player method_453(class_171 var0, class_171 var1) {
        return new Player(var0.method_917(), var0.equals(var1), var0.method_918(), var0.method_922(), var0.method_928());
    }

    // $FF: renamed from: a (java.util.List, com.a.b.a.a.b.n) com.a.b.a.a.c.o[]
    public static Player[] method_454(List var0, class_171 var1) {
        int var2 = var0.size();
        Player[] var3 = new Player[var2];

        for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = method_453((class_171)var0.get(var4), var1);
        }

        return var3;
    }

    // $FF: renamed from: a () java.util.Comparator
    public static Comparator method_455() {
        return new Comparator() {
            // $FF: renamed from: a (com.a.b.a.a.b.n, com.a.b.a.a.b.n) int
            public int method_457(class_171 var1, class_171 var2) {
                return var2.method_928() > var1.method_928()?1:(var2.method_928() < var1.method_928()?-1:(var2.method_917() > var1.method_917()?1:(var2.method_917() < var1.method_917()?-1:0)));
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_457((class_171)var1, (class_171)var2);
            }
        };
    }

    // $FF: renamed from: b () java.util.Comparator
    public static Comparator method_456() {
        return new Comparator() {
            // $FF: renamed from: a (com.a.b.a.a.c.o, com.a.b.a.a.c.o) int
            public int method_458(Player var1, Player var2) {
                return var2.getScore() > var1.getScore()?1:(var2.getScore() < var1.getScore()?-1:(var2.getId() > var1.getId()?1:(var2.getId() < var1.getId()?-1:0)));
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
                return this.method_458((Player)var1, (Player)var2);
            }
        };
    }
}
