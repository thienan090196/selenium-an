package com.logigear.helper.web_driver_helper;

import com.logigear.helper.Constant;
import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    public static WebDriver getDriverManager(Constant.DriverType driverType) {
        DriverManager driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new EdgeDriverManager();
                break;
        }
        return driverManager.getWebDriver();
    }
}
