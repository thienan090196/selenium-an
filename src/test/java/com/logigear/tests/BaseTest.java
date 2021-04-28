package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.LoggerHelper;
import com.logigear.helpers.web_driver_helper.DriverManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional String browser) {
        LoggerHelper.beginTest("Beginning...");
        try {
            switch (Constant.DRIVER_TYPE.valueOf(browser)) {
                case CHROME:
                    DriverManagerFactory.getInstance().createDriver(Constant.DRIVER_TYPE.CHROME);
                    break;
                case FIREFOX:
                    DriverManagerFactory.getInstance().createDriver(Constant.DRIVER_TYPE.FIREFOX);
                    break;
                default:
                    DriverManagerFactory.getInstance().createDriver(Constant.DRIVER_TYPE.EDGE);
                    break;
            }
        } catch (NullPointerException e) {
            DriverManagerFactory.getInstance().createDriver(Constant.DRIVER_TYPE.CHROME);
        }
        DriverManagerFactory.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManagerFactory.getInstance().quitDriver();
        LoggerHelper.endTest("Quitting driver...");
    }
}
