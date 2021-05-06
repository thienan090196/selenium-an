package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.ErrorMessage;
import com.logigear.models.Account;
import com.logigear.page_objects.BookTicketPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
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
        account = new Account("", Constant.PASSWORD);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult, ErrorMessage.LOGIN_FORM_ERROR, "Error message fails to display!");
    }

    @Test(description = "User cannot log into Railway with invalid password ")
    public void TC03() {
        account = new Account(Constant.EMAIL, "abc@123");
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult, ErrorMessage.INVALID_EMAIL_OR_PASSWORD, "Error message fails to display!");
    }

    @Test(description = "User is redirected to Book ticket page after logging in")
    public void TC04() {
        account = new Account(Constant.EMAIL, Constant.PASSWORD);
        homePage.goToBookTicketPage();
        loginPage.login(account);

        String actualResult = bookTicketPage.getPageHeader();
        String expectedResult = "Book ticket";
        Assert.assertEquals(actualResult, expectedResult, "Book ticket page fails to display!");
    }
}
