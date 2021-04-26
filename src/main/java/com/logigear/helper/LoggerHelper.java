package com.logigear.helper;

import org.apache.log4j.Logger;

public class LoggerHelper {

    private static Logger LoggerHelper = Logger.getLogger(LoggerHelper.class.getName());

    public static void startTestCase(String testCaseName) {
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("----" + testCaseName + " starts" + "----");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
    }

    public static void endTestCase(String testCaseName) {
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("----" + testCaseName + " ends" + "----");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
    }

    public static void info(String message) {
        LoggerHelper.info(message);
    }

    public static void warn(String message) {
        LoggerHelper.warn(message);
    }

    public static void error(String message) {
        LoggerHelper.error(message);
    }

    public static void fatal(String message) {
        LoggerHelper.fatal(message);
    }

    public static void debug(String message) {
        LoggerHelper.debug(message);
    }
}
