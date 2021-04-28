package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
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

    @DataProvider(name = "invalidLoginData")
    public static Object[] getInvalidLoginsData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Account> accounts = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-login-data.json"), new TypeReference<List<Account>>() {
        });
        return accounts.toArray();
    }

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

    @Test(dataProvider = "invalidLoginData", description = "Login unsuccessfully with invalid data")
    public void TC02(Account account) {
        LoggerHelper.info(account.getDescription());

        homePage.goToLoginPage();
        loginPage.login(account);

        String actualGeneralMessage = loginPage.getGeneralErrorMessage();
        String expectedGeneralMessage = account.getMessages().getGeneralMessage();
        String actualEmailMessage = loginPage.getEmailErrorMessage();
        String expectedEmailMessage = account.getMessages().getEmailMessage();
        String actualPasswordMessage = loginPage.getPasswordErrorMessage();
        String expectedPasswordMessage = account.getMessages().getPasswordMessage();

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
    }
}
