package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.LoggerHelper;
import com.logigear.helpers.web_driver_helper.DriverManagerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional String browser) {
        LoggerHelper.beginTest("Beginning...");
        try {
            switch (Constant.DriverType.valueOf(browser)) {
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
        } catch (NullPointerException e) {
            DriverManagerFactory.getInstance().createDriver(Constant.DriverType.CHROME);
        }
        DriverManagerFactory.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void tearDown() {
        DriverManagerFactory.getInstance().quiteDriver();
        LoggerHelper.endTest("Quitting driver...");
    }
}
