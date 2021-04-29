package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.ErrorMessage;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();

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

    @Test(description = "Register unsuccessfully with blank data")
    public void TC02() {
        LoggerHelper.info("Register unsuccessfully with blank data");

        homePage.goToRegisterPage();

        Account account = new Account(Constant.BLANK_STRING, Constant.BLANK_STRING, Constant.BLANK_STRING, Constant.BLANK_STRING);
        registerPage.register(account);

        String actualGeneralMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.REGISTER_GENERAL_MESSAGE;
        String actualEmailMessage = registerPage.getEmailErrorMessage();
        String expectedEmailMessage = ErrorMessage.INVALID_EMAIL_LENGTH;
        String actualPasswordMessage = registerPage.getPasswordErrorMessage();
        String expectedPasswordMessage = ErrorMessage.INVALID_PASSWORD_LENGTH;
        String actualPIDMessage = registerPage.getPIDErrorMessage();
        String expectedPIDMessage = ErrorMessage.INVALID_PID_LENGTH;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
        Assert.assertEquals(actualPIDMessage, expectedPIDMessage, actualPIDMessage + " is not matched with " + expectedPIDMessage);
    }

    @Test(description = "Register unsuccessfully with confirm password not match with password")
    public void TC03() {
        LoggerHelper.info("Register unsuccessfully with confirm password not match with password");

        homePage.goToRegisterPage();

        Account account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPassword(), DataHelper.getRandomPid());
        registerPage.register(account);

        String actualGeneralMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.REGISTER_GENERAL_MESSAGE;
        String actualPasswordMessage = registerPage.getConfirmPasswordErrorMessage();
        String expectedPasswordMessage = ErrorMessage.CONFIRM_PASSWORD_NOT_MATCH_PASSWORD;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
    }

    @Test(description = "Register unsuccessfully with exist email")
    public void TC04() {
        LoggerHelper.info("Register unsuccessfully with exist email");

        homePage.goToRegisterPage();

        Account account = new Account(Constant.USERNAME, DataHelper.getRandomPassword());
        account.setConfirmPassword(account.getPassword());
        account.setPid(DataHelper.getRandomPid());
        registerPage.register(account);

        String actualGeneralMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.EMAIL_IS_EXISTED;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
    }

    @Test(description = "Register unsuccessfully with invalid email format")
    public void TC05() {
        LoggerHelper.info("Register unsuccessfully with invalid email format");

        homePage.goToRegisterPage();

        Account account = new Account();
        account.setEmail(DataHelper.getRandomPid());
        account.setPassword(DataHelper.getRandomPassword());
        account.setConfirmPassword(account.getPassword());
        account.setPid(DataHelper.getRandomPid());
        registerPage.register(account);

        String actualGeneralMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralMessage = ErrorMessage.REGISTER_GENERAL_MESSAGE;
        String actualEmailMessage = registerPage.getEmailErrorMessage();
        String expectedEmailMessage = ErrorMessage.INVALID_EMAIL_FORMAT;

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
    }
}
