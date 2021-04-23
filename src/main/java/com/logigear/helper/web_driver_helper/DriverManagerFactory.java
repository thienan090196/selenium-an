package com.logigear.helper.web_driver_helper;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    public static WebDriver getDriverManager(DriverType driverType) {
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
        return driverManager.getWebDriver();
    }

    public enum DriverType {
        CHROME, FIREFOX, IE;
    }

}
