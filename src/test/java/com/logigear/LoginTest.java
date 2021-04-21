package com.logigear;

import com.logigear.helper.Constant;
import com.logigear.helper.ErrorMessage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private String invalidEmail = "testrailway01";
    private String invalidPassword = "abc";

    @Test
    @Description("Login successfully with valid email and password")
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);

        Assert.assertEquals(homePage.getWelcomeMessage(), Constant.PREFIX_WELCOME_STRING + Constant.EMAIL, "Welcome message fails to display!");
        homePage.logout();
    }

    @Test
    @Description("Login unsuccessfully with blank email and password")
    public void TC02() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();

        loginPage.login(Constant.BLANK_STRING, Constant.BLANK_STRING);
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), ErrorMessage.LOGIN_GENERAL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getEmailErrorMessage(), ErrorMessage.LOGIN_BLANK_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), ErrorMessage.LOGIN_BLANK_PASSWORD_ERROR_MESSAGE);
    }

    @Test
    @Description("Login unsuccessfully with invalid email and password")
    public void TC03() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();

        loginPage.login(invalidEmail, invalidPassword);
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), ErrorMessage.LOGIN_INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
    }

    @Test
    @Description("Login unsuccessfully with blank password")
    public void TC04() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();

        loginPage.login(Constant.EMAIL, Constant.BLANK_STRING);
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), ErrorMessage.LOGIN_GENERAL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), ErrorMessage.LOGIN_BLANK_PASSWORD_ERROR_MESSAGE);
    }

    @Test
    @Description("Login unsuccessfully with blank email")
    public void TC05() {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();

        loginPage.login(Constant.BLANK_STRING, Constant.PASSWORD);
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), ErrorMessage.LOGIN_GENERAL_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getEmailErrorMessage(), ErrorMessage.LOGIN_BLANK_EMAIL_ERROR_MESSAGE);
    }

}
