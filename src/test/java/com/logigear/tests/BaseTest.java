package com.logigear.tests;

import com.logigear.helper.Constant;
import com.logigear.helper.LoggerHelper;
import com.logigear.helper.web_driver_helper.DriverManagerFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(Constant.DriverType browser) {
        LoggerHelper.info("Start " + browser + "...");
        switch (browser) {
            case CHROME:
                DriverManagerFactory.getInstance().setDriver(Constant.DriverType.CHROME);
                break;
            case FIREFOX:
                DriverManagerFactory.getInstance().setDriver(Constant.DriverType.FIREFOX);
                break;
            default:
                DriverManagerFactory.getInstance().setDriver(Constant.DriverType.EDGE);
                break;
        }
        webDriver = DriverManagerFactory.getInstance().getDriver();
        webDriver.manage().timeouts().implicitlyWait(Constant.WAIT_IMPLICITLY_TIME, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(Constant.DEFAULT_SCREEN_WIDTH, Constant.DEFAULT_SCREEN_HEIGHT));
        webDriver.get(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void tearDown() {
        DriverManagerFactory.getInstance().closeBrowser();
        LoggerHelper.info("Quitting driver...");
    }

}
