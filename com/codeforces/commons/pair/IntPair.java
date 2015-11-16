package com.codeforces.commons.pair;

public class IntPair extends Pair<Integer, Integer> {
    public IntPair() {
    }

    public IntPair(Integer first, Integer second) {
        super(first, second);
    }

    public IntPair(SimplePair<Integer, Integer> pair) {
        super(pair);
    }
}
