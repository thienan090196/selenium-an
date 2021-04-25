package com.logigear.helper.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EdgeDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        System.out.println("Initializing Edge Driver");
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
    }

}
