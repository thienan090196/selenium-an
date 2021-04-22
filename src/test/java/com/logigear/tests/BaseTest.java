package com.logigear.tests;

import com.logigear.helper.Constant;
import com.logigear.helper.web_driver_helper.DriverManagerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeSuite
    public void beforeMethod() {
        Constant.DRIVER_MANAGER = DriverManagerFactory.getDriverManager(DriverManagerFactory.DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
//        Constant.WEB_DRIVER.manage().window().setSize(new Dimension(1024, 768));
    }

    @AfterSuite
    public void afterMethod() {
        Constant.WEB_DRIVER.manage().deleteAllCookies();
        Constant.DRIVER_MANAGER.quitDriver();
    }

}
