package com.logigear;

import com.logigear.helper.Constant;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Description("Login successfully with valid username and password")
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);

        String actualMessage = homePage.getWelcomeMessage();
        String expectedMessage = Constant.PREFIX_WELCOME_STRING + Constant.EMAIL;

        Assert.assertEquals(actualMessage, expectedMessage, "Welcome message fails to display!");
        homePage.logout();
    }

    @Test
    @Description("Login unsuccessfully with blank username and password")
    public void TC02() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.BLANK_STRING, Constant.BLANK_STRING);

        Assert.assertEquals(loginPage.getGeneralErrorMessage(), Constant.LOGIN_GENERAL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getEmailErrorMessage(), Constant.LOGIN_BLANK_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), Constant.LOGIN_BLANK_PASSWORD_ERROR_MESSAGE);
    }

}
