package com.logigear.tests;

import com.logigear.helper.Constant;
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
        if (browser == Constant.DriverType.CHROME) {
            DriverManagerFactory.getInstance().setDriver(Constant.DriverType.CHROME);
        } else {
            DriverManagerFactory.getInstance().setDriver(Constant.DriverType.FIREFOX);
        }
        webDriver = DriverManagerFactory.getInstance().getDriver();
        webDriver.manage().timeouts().implicitlyWait(Constant.WAIT_IMPLICITLY_TIME, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(Constant.DEFAULT_SCREEN_WIDTH, Constant.DEFAULT_SCREEN_HEIGHT));
        webDriver.get(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void tearDown() {
        DriverManagerFactory.getInstance().closeBrowser();
    }

}
