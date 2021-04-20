package com.logigear.helper.web_driver_helper;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType driverType) {
        DriverManager driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new IEDriverManager();
                break;
        }
        return driverManager;
    }

    public enum DriverType {
        CHROME, FIREFOX, IE;
    }

}
