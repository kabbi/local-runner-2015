package com.a.b;

import com.a.b.a.a.a.GameModule;
import com.a.b.a.a.a.GameProperties;
import com.google.inject.Guice;
import com.google.inject.Module;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $FF: renamed from: com.a.b.c
public final class GameRunner implements Runnable {
    // $FF: renamed from: a org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(GameRunner.class);
    // $FF: renamed from: b java.lang.String[]
    private final String[] args;

    public GameRunner(String[] args) {
        this.args = args;
    }

    public void run() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable throwable) {
                logger.error("Got unexpected exception in thread \'" + thread + "\'.", throwable);
                throwable.printStackTrace();
            }
        });
        GameProperties gameProperties = null;

        try {
            gameProperties = new GameProperties(this.args);
            GameProperties.initRandomAndSeed(gameProperties);
            GameSimulator gameSimulator = Guice.createInjector(new Module[]{new GameModule()})
                    .getInstance(GameSimulator.class);

            try {
                gameSimulator.init(gameProperties);
                gameSimulator.start();
            } finally {
                gameSimulator.shutdown();
            }
        } catch (RuntimeException e) {
            logger.error("Got unexpected game exception.", e);
            e.printStackTrace();
            if(gameProperties == null) {
                return;
            }

            File resultsFile = gameProperties.getResultsFile();
            if(resultsFile == null) {
                return;
            }

            try {
                String stackTrace = "FAILED\n" + ExceptionUtils.getStackTrace(e) + '\n';
                FileUtils.writeByteArrayToFile(resultsFile, stackTrace.getBytes(StandardCharsets.UTF_8));
            } catch (IOException exception) {
                logger.error(String.format("Can\'t write results to file \'%s\'.", resultsFile.getPath()), exception);
            }
        }

    }
}
