package com.logigear.helper.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        System.out.println("Initializing Firefox Driver");
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
    }

}
