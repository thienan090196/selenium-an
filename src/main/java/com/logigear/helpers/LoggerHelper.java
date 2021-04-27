package com.logigear.helpers;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerHelper {

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    private static Logger LoggerHelper = Logger.getLogger(LoggerHelper.class.getName());

    public static void beginTest(String testName) {
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("----" + testName + " starts" + "----");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
    }

    public static void endTest(String testName) {
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("--------------------------------");
        LoggerHelper.info("----" + testName + " ends" + "----");
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
