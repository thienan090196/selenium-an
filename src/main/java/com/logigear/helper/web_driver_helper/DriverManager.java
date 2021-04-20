package com.logigear.helper.web_driver_helper;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebDriver();

    public void quitDriver() {
        if (null != driver) {
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                System.err.println("Unable to gracefully quit WebDriver.");
            }
        }
    }

    public WebDriver getWebDriver() {
        if (null == driver) {
            createWebDriver();
        }
        return driver;
    }

}
