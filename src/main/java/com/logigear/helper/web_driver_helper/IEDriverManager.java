package com.logigear.helper.web_driver_helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        System.out.println("Initializing Internet Explorer Driver");
        WebDriverManager.iedriver().setup();
        this.driver = new InternetExplorerDriver();
    }

}
