package com.logigear.tests;

import com.logigear.helpers.Constant;
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
        Assert.assertEquals(actualResult, expectedResult, "Invalid email or password!");
    }
}
