package com.logigear.tests;

import com.logigear.helper.Constant;
import com.logigear.helper.web_driver_helper.DriverFactory;
import com.logigear.helper.web_driver_helper.DriverManagerFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.nio.file.Watchable;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(Constant.DriverType browser) {
        if (browser == Constant.DriverType.CHROME) {
            DriverFactory.getInstance().setDriver(DriverManagerFactory.getDriverManager(Constant.DriverType.CHROME));
        } else {
            DriverFactory.getInstance().setDriver(DriverManagerFactory.getDriverManager(Constant.DriverType.FIREFOX));
        }
        webDriver = DriverFactory.getInstance().getDriver();
        webDriver.manage().timeouts().implicitlyWait(Constant.WAIT_IMPLICITLY_TIME, TimeUnit.SECONDS);
        webDriver.get(Constant.RAILWAY_URL);
        webDriver.manage().window().setSize(new Dimension(Constant.DEFAULT_SCREEN_WIDTH, Constant.DEFAULT_SCREEN_HEIGHT));
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

}
