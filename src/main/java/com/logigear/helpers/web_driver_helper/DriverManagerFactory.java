package com.logigear.helpers.web_driver_helper;

import com.logigear.helpers.Constant;
import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    private static final DriverManagerFactory instance = new DriverManagerFactory();

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverManagerFactory() {

    }

    public static DriverManagerFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void createDriver(Constant.DriverType driverType) {
        WebDriver webDriver;
        switch (driverType) {
            case CHROME:
                webDriver = new ChromeDriverManager().createWebDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriverManager().createWebDriver();
                break;
            default:
                webDriver = new EdgeDriverManager().createWebDriver();
                break;
        }
        driver.set(webDriver);
    }

    public void quiteDriver() {
        driver.get().quit();
        driver.remove();
    }
}
