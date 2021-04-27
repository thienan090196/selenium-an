package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.LoggerHelper;
import com.logigear.helpers.web_driver_helper.DriverManagerFactory;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeTest
    @Parameters("browser")
    public void setUp(Constant.DriverType browser) {
        LoggerHelper.beginTest(browser.name());
        switch (browser) {
            case CHROME:
                DriverManagerFactory.getInstance().createDriver(Constant.DriverType.CHROME);
                break;
            case FIREFOX:
                DriverManagerFactory.getInstance().createDriver(Constant.DriverType.FIREFOX);
                break;
            default:
                DriverManagerFactory.getInstance().createDriver(Constant.DriverType.EDGE);
                break;
        }
        DriverManagerFactory.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void tearDown() {
        DriverManagerFactory.getInstance().quiteDriver();
        LoggerHelper.endTest("Quitting driver...");
    }
}
