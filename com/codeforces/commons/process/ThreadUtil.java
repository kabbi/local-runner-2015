package com.codeforces.commons.process;

import org.apache.log4j.Logger;

public class ThreadUtil {
    private static final Logger logger = Logger.getLogger(ThreadUtil.class);

    private ThreadUtil() {
        throw new UnsupportedOperationException();
    }

    public static void sleep(long var0) {
        try {
            Thread.sleep(var0);
        } catch (InterruptedException var3) {
            ;
        }

    }

    public static Object execute(ThreadUtil.Operation var0, int var1, ThreadUtil.ExecutionStrategy var2) throws Throwable {
        ensureArguments(var0, var1, var2);
        int var3 = 1;

        while(var3 <= var1) {
            try {
                return var0.run();
            } catch (Throwable var5) {
                if(var2.getUnsuccessHandler() != null) {
                    var2.getUnsuccessHandler().handle(var3, var5);
                }

                if(var3 >= var1) {
                    logger.error("Iteration #" + var3 + " has been failed: " + var5.getMessage(), var5);
                    throw var5;
                }

                if(var3 == 1) {
                    logger.info("Iteration #1 has been failed: " + var5.getMessage(), var5);
                } else {
                    logger.warn("Iteration #" + var3 + " has been failed: " + var5.getMessage(), var5);
                }

                sleep(var2.getDelayTimeMillis(var3));
                ++var3;
            }
        }

        throw new RuntimeException("This line shouldn\'t be executed.");
    }

    private static void ensureArguments(ThreadUtil.Operation var0, int var1, ThreadUtil.ExecutionStrategy var2) {
        if(var0 == null) {
            throw new IllegalArgumentException("Argument \'operation\' can\'t be \'null\'.");
        } else if(var1 < 1) {
            throw new IllegalArgumentException("Argument \'attemptCount\' should be positive.");
        } else if(var2 == null) {
            throw new IllegalArgumentException("Argument \'strategy\' can\'t be \'null\'.");
        }
    }

    public static class ExecutionStrategy {
        private final long delayTimeMillis;
        private final ThreadUtil.ExecutionStrategy.Type type;
        private final ThreadUtil.UnsuccessHandler unsuccessHandler;

        public ExecutionStrategy(long var1, ThreadUtil.ExecutionStrategy.Type var3) {
            this(var1, var3, (ThreadUtil.UnsuccessHandler)null);
        }

        public ExecutionStrategy(long var1, ThreadUtil.ExecutionStrategy.Type var3, ThreadUtil.UnsuccessHandler var4) {
            ensureArguments(var1, var3);
            this.delayTimeMillis = var1;
            this.type = var3;
            this.unsuccessHandler = var4;
        }

        private static void ensureArguments(long var0, ThreadUtil.ExecutionStrategy.Type var2) {
            if(var0 < 1L) {
                throw new IllegalArgumentException("Argument \'delayTimeMillis\' should be positive.");
            } else if(var2 == null) {
                throw new IllegalArgumentException("Argument \'type\' can\'t be \'null\'.");
            }
        }

        public long getDelayTimeMillis(int var1) {
            if(var1 < 1) {
                throw new IllegalArgumentException("Argument \'attemptNumber\' should be positive.");
            } else {
                switch(this.type.ordinal()) {
                case 1:
                    return this.delayTimeMillis;
                case 2:
                    return this.delayTimeMillis * (long)var1;
                case 3:
                    return this.delayTimeMillis * (long)var1 * (long)var1;
                default:
                    throw new IllegalArgumentException("Unknown strategy type \'" + this.type + "\'.");
                }
            }
        }

        public ThreadUtil.UnsuccessHandler getUnsuccessHandler() {
            return this.unsuccessHandler;
        }

        public static enum Type {
            CONSTANT,
            LINEAR,
            SQUARE;
        }
    }

    public interface UnsuccessHandler {
        void handle(int var1, Throwable var2);
    }

    public interface Operation {
        Object run() throws Throwable;
    }
}
