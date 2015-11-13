package com.a.b.a.a.c;

import com.codeforces.commons.reflection.Name;
import com.codeforces.commons.text.StringUtil;
import com.google.gson.annotations.Until;

// $FF: renamed from: com.a.b.a.a.c.o
public class Player {
    // $FF: renamed from: id long
    private final long id;
    // $FF: renamed from: me boolean
    @Until(1.0D)
    private final boolean me;
    @Until(1.0D)
    private final String name;
    private final boolean strategyCrashed;
    private final int score;

    public Player(@Name("id") long var1, @Name("me") boolean var3, @Name("name") String var4, @Name("strategyCrashed") boolean var5, @Name("score") int var6) {
        this.id = var1;
        this.me = var3;
        this.name = var4;
        this.strategyCrashed = var5;
        this.score = var6;
    }

    public long getId() {
        return this.id;
    }

    public boolean isMe() {
        return this.me;
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

    public static boolean areFieldEquals(Player a, Player b) {
        return a == b || a != null && b != null && a.id == b.id && a.me == b.me && StringUtil.equals(a.name, b.name) && a.strategyCrashed == b.strategyCrashed && a.score == b.score;
    }
}
