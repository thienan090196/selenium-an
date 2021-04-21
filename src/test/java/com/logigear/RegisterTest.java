package com.logigear;

import com.logigear.helper.Constant;
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

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASSWORD, Constant.PID);

        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();

        Assert.assertEquals(registerConfirmPage.getSuccessfulMessage(), "Registration Confirmed! You can now log in to the site.");
    }

}
