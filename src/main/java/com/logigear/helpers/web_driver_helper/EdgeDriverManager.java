package com.logigear.helpers.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager {

    public WebDriver createWebDriver() {
        System.out.println("Initializing Edge Driver");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
