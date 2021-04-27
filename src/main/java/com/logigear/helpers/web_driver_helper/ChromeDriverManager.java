package com.logigear.helpers.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager {

    public WebDriver createWebDriver() {
        System.out.println("Initializing Chrome Driver");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
