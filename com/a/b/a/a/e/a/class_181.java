package com.a.b.a.a.e.a;

import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;
import com.a.b.a.a.e.Strategy;
import com.a.b.a.a.e.EmptyStrategy;

import java.lang.reflect.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.a.a.e.a.a
public class class_181 implements StrategyAdapter {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger field_765 = LoggerFactory.getLogger(class_181.class);
    // $FF: renamed from: b java.lang.String
    private static final String field_766 = class_181.class.getPackage().getName();
    // $FF: renamed from: c com.a.b.a.a.e.d[]
    private final Strategy[] field_767;
    // $FF: renamed from: d int
    private final int field_768;
    // $FF: renamed from: e com.a.b.a.a.c.l
    private Game field_769;

    public class_181(String var1, int var2) {
        if(!var1.endsWith(".class")) {
            throw new IllegalArgumentException(String.format("Illegal player definition: \'%s\'.", new Object[]{var1}));
        } else {
            var1 = var1.substring(0, var1.length() - ".class".length());
            if(var1.indexOf(46) == -1) {
                var1 = field_766 + '.' + var1;
            }

            Constructor var3;
            String var5;
            try {
                var3 = Class.forName(var1).getConstructor();
            } catch (ClassNotFoundException var8) {
                var5 = String.format("Class \'%s\' does not exist.", var1);
                field_765.error(var5, var8);
                throw new IllegalArgumentException(var5, var8);
            } catch (NoSuchMethodException var9) {
                var5 = String.format("Class \'%s\' hasn\'t default constructor.", var1);
                field_765.error(var5, var9);
                throw new IllegalArgumentException(var5, var9);
            }

            this.field_767 = new Strategy[var2];

            for(int var4 = 0; var4 < var2; ++var4) {
                Object var10;
                try {
                    Object var6 = var3.newInstance();
                    if(var6 instanceof Strategy) {
                        var10 = (Strategy)var6;
                    } else {
                        field_765.error(String.format("Instance of class \'%s\' is not a strategy.", var1));
                        var10 = new EmptyStrategy();
                    }
                } catch (Exception var7) {
                    field_765.error(String.format("Can\'t create instance of class \'%s\'.", new Object[]{var1}), var7);
                    var10 = new EmptyStrategy();
                }

                this.field_767[var4] = (Strategy)var10;
            }

            this.field_768 = var2;
        }
    }

    // $FF: renamed from: a () int
    public int method_51() {
        return 1;
    }

    // $FF: renamed from: a (com.a.b.a.a.c.l) void
    public void method_52(Game var1) {
        this.field_769 = var1;
    }

    // $FF: renamed from: a (com.a.b.a.a.c.c[], com.a.b.a.a.c.v) com.a.b.a.a.c.m[]
    public Move[] method_53(Car[] var1, World var2) {
        if(var1.length != this.field_768) {
            throw new IllegalArgumentException(String.format("Strategy adapter \'%s\' got %d cars while team size is %d.", new Object[]{this.getClass().getSimpleName(), var1.length, this.field_768}));
        } else {
            Move[] var3 = new Move[this.field_768];

            for(int var4 = 0; var4 < this.field_768; ++var4) {
                var3[var4] = new Move();
                this.field_767[var4].move(var1[var4], var2, this.field_769, var3[var4]);
            }

            return var3;
        }
    }

    public void close() {
    }
}
