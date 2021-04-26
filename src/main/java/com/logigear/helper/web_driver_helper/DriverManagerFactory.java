package com.logigear.helper.web_driver_helper;

import com.logigear.helper.Constant;
import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    private DriverManagerFactory() {

    }

    private static DriverManagerFactory instance  = new DriverManagerFactory();

    public static DriverManagerFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(Constant.DriverType driverType) {
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
        driver.set(driverManager.getWebDriver());
    }

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}
