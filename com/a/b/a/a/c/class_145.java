package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.o
public class class_145 {
    // $FF: renamed from: id long
    private final long field_583;
    // $FF: renamed from: me boolean
    @Until(1.0D)
    private final boolean field_584;
    @Until(1.0D)
    private final String name;
    private final boolean strategyCrashed;
    private final int score;

    public class_145(@Name("id") long var1, @Name("me") boolean var3, @Name("name") String var4, @Name("strategyCrashed") boolean var5, @Name("score") int var6) {
        this.field_583 = var1;
        this.field_584 = var3;
        this.name = var4;
        this.strategyCrashed = var5;
        this.score = var6;
    }

    public long getId() {
        return this.field_583;
    }

    public boolean isMe() {
        return this.field_584;
    }

    public String getName() {
        return this.name;
    }

    public boolean isStrategyCrashed() {
        return this.strategyCrashed;
    }

    public int getScore() {
        return this.score;
    }

    public static boolean areFieldEquals(class_145 var0, class_145 var1) {
        return var0 == var1 || var0 != null && var1 != null && var0.field_583 == var1.field_583 && var0.field_584 == var1.field_584 && StringUtil.equals(var0.name, var1.name) && var0.strategyCrashed == var1.strategyCrashed && var0.score == var1.score;
    }
}
