package com.logigear.tests;

import com.logigear.helper.Common;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterConfirmPage;
import com.logigear.page_objects.RegisterPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    @Description("Register successfully with valid data")
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.goToRegisterPage();
        homePage.disableFooterBanner();

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(Common.generateRandomEmailString(), Common.getTestDataValue("register.valid.password"), Common.getTestDataValue("register.valid.pid"));

        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();

        Assert.assertEquals(registerConfirmPage.getSuccessfulMessage(), Common.getMessageValue("register.successful.message"));
    }

}
