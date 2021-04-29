package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
import com.logigear.helpers.ErrorMessage;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test(description = "Login successfully with valid email and password")
    public void TC01() {
        LoggerHelper.info("Login successfully with valid email and password");

        homePage.goToLoginPage();
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = "Welcome " + account.getEmail();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(description = "Login unsuccessfully with blank data")
    public void TC02() {
        LoggerHelper.info("Login unsuccessfully with blank data");
        Account account = new Account(Constant.BLANK_STRING, Constant.BLANK_STRING);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualGeneralMessage = loginPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.LOGIN_GENERAL_MESSAGE;
        String actualEmailMessage = loginPage.getEmailErrorMessage();
        String expectedEmailMessage = ErrorMessage.BLANK_EMAIL;
        String actualPasswordMessage = loginPage.getPasswordErrorMessage();
        String expectedPasswordMessage = ErrorMessage.BLANK_PASSWORD;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
    }

    @Test(dataProvider = "invalidLoginData", description = "Login unsuccessfully with invalid data")
    public void TC03(Account account) {
        LoggerHelper.info("Login unsuccessfully with blank data");
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualGeneralMessage = loginPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.INVALID_EMAIL_OR_PASSWORD;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
    }

    @Test(description = "Login unsuccessfully with blank username")
    public void TC04() {
        LoggerHelper.info("Login unsuccessfully with blank data");
        Account account = new Account(Constant.BLANK_STRING, Constant.PASSWORD);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualGeneralMessage = loginPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.LOGIN_GENERAL_MESSAGE;
        String actualEmailMessage = loginPage.getEmailErrorMessage();
        String expectedEmailMessage = ErrorMessage.BLANK_EMAIL;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
    }

    @Test(description = "Login unsuccessfully with blank password")
    public void TC05() {
        LoggerHelper.info("Login unsuccessfully with blank data");
        Account account = new Account(Constant.USERNAME, Constant.BLANK_STRING);
        homePage.goToLoginPage();
        loginPage.login(account);

        String actualGeneralMessage = loginPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.LOGIN_GENERAL_MESSAGE;
        String actualPasswordMessage = loginPage.getPasswordErrorMessage();
        String expectedPasswordMessage = ErrorMessage.BLANK_PASSWORD;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[] getInvalidLoginsData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Account> accounts = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-login-data.json"), new TypeReference<List<Account>>() {
        });
        return accounts.toArray();
    }
}
