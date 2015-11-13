package com.codeforces.commons.resource;

public class CantReadResourceException extends RuntimeException {
    public CantReadResourceException(String var1) {
        super(var1);
    }

    public CantReadResourceException(String var1, Throwable var2) {
        super(var1, var2);
    }
}
