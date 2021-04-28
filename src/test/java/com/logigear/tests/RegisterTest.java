package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();

    @DataProvider(name = "invalidRegisterData")
    public static Object[] getInvalidRegistersData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Account> accounts = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-register-data.json"), new TypeReference<List<Account>>() {
        });
        return accounts.toArray();
    }

    @Test(description = "Register successfully with valid data")
    public void TC01() {
        LoggerHelper.info("Register successfully with valid data");

        homePage.goToRegisterPage();

        Account account = new Account();
        account.setEmail(DataHelper.getRandomEmail());
        account.setPassword(DataHelper.getRandomPassword());
        account.setConfirmPassword(account.getPassword());
        account.setPid(DataHelper.getRandomPid());
        registerPage.register(account);

        String actualResult = registerPage.getSuccessMessage();
        String expectedResult = "You're here";
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalidRegisterData", description = "Register unsuccessfully with invalid data")
    public void TC02(Account account) {
        LoggerHelper.info(account.getDescription());

        homePage.goToRegisterPage();
        registerPage.register(account);

        String actualGeneralMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralMessage = account.getMessages().getGeneralMessage();
        String actualEmailMessage = registerPage.getEmailErrorMessage();
        String expectedEmailMessage = account.getMessages().getEmailMessage();
        String actualPasswordMessage = registerPage.getPasswordErrorMessage();
        String expectedPasswordMessage = account.getMessages().getPasswordMessage();
        String actualConfirmPasswordMessage = registerPage.getConfirmPasswordErrorMessage();
        String expectedConfirmPasswordMessage = account.getMessages().getConfirmPasswordMessage();
        String actualPIDMessage = registerPage.getPIDErrorMessage();
        String expectedPIDMessage = account.getMessages().getPidMessage();

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
        Assert.assertEquals(actualConfirmPasswordMessage, expectedConfirmPasswordMessage, actualConfirmPasswordMessage + " is not matched with " + expectedConfirmPasswordMessage);
        Assert.assertEquals(actualPIDMessage, expectedPIDMessage, actualPIDMessage + " is not matched with " + expectedPIDMessage);
    }
}
