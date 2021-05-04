package com.logigear.tests;

import com.logigear.enums.DriverType;
import com.logigear.helpers.Constant;
import com.logigear.helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional String browser) {
        if (browser != null) {
            DriverHelper.getInstance().createDriver(DriverType.valueOf(browser.toUpperCase()));
        } else {
            DriverHelper.getInstance().createDriver(DriverType.CHROME);
        }
        DriverHelper.setWindowSize(Constant.DEFAULT_SCREEN_WIDTH, Constant.DEFAULT_SCREEN_HEIGHT);
        DriverHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.getInstance().quitDriver();
    }
}
