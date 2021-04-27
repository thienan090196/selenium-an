package com.logigear.helpers.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager {

    public WebDriver createWebDriver() {
        System.out.println("Initializing Firefox Driver");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
