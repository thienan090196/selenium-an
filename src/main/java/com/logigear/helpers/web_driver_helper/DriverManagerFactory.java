package com.logigear.helpers.web_driver_helper;

import com.logigear.helpers.Constant;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManagerFactory {

    private static final DriverManagerFactory instance = new DriverManagerFactory();

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverManagerFactory() {

    }

    public static DriverManagerFactory getInstance() {
        return instance;
    }

    public static void navigateToUrl(String url) {
        getInstance().getDriver().get(url);
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
        webDriver.manage().timeouts().implicitlyWait(Constant.WAIT_IMPLICITLY_TIME, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(Constant.DEFAULT_SCREEN_WIDTH, Constant.DEFAULT_SCREEN_HEIGHT));
        driver.set(webDriver);
    }

    public void quiteDriver() {
        driver.get().quit();
        driver.remove();
    }
}
