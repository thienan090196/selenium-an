package com.logigear.helper.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        System.out.println("Initializing Chrome Driver");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

}
