package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.ErrorMessage;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private Account account;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        account = new Account(Constant.EMAIL, Constant.PASSWORD);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = "Welcome " + account.getEmail();
        Assert.assertEquals(actualResult, expectedResult, "Welcome message fails to display!");
    }

    @Test(description = "User cannot login with blank 'Username' text box")
    public void TC02() {
        account = new Account(Constant.BLANK_STRING, Constant.PASSWORD);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualResult = loginPage.getErrorMessage();
        String expectedResult = ErrorMessage.LOGIN_ERROR;
        Assert.assertEquals(actualResult, expectedResult, "Error message fails to display!");
    }
}
