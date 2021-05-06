package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.ErrorMessage;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private Account account;

    @Test(description = "User can create new account")
    public void TC01() {
        account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPid());
        homePage.goToRegisterPage();
        registerPage.register(account);

        String actualSuccessMessage = registerPage.getSuccessMessage();
        String expectedSuccessMessage = "You're here";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message fails to display!");
    }

    @Test(description = "User cannot create account with an already in-use email")
    public void TC02() {
        account = new Account(Constant.EMAIL, Constant.PASSWORD, DataHelper.getRandomPid());
        homePage.goToRegisterPage();
        registerPage.register(account);

        String actualErrorMessage = registerPage.getFormErrorMessage();
        Assert.assertEquals(actualErrorMessage, ErrorMessage.EMAIL_IS_EXISTED, "Error message fails to display!");
    }

    @Test(description = "User cannot create account while password and PID fields are empty")
    public void TC03() {
        account = new Account(DataHelper.getRandomEmail(), "", "");
        homePage.goToRegisterPage();
        registerPage.register(account);

        String actualFormErrorMessage = registerPage.getFormErrorMessage();
        String actualPasswordErrorMessage = registerPage.getPasswordErrorMessage();
        String actualPidErrorMessage = registerPage.getPidErrorMessage();
        Assert.assertEquals(actualFormErrorMessage, ErrorMessage.REGISTER_FORM_ERROR, "Form error fails to display!");
        Assert.assertEquals(actualPasswordErrorMessage, ErrorMessage.INVALID_PASSWORD_LENGTH, "Password error fails to display!");
        Assert.assertEquals(actualPidErrorMessage, ErrorMessage.INVALID_PID_LENGTH, "Pid error fails to display!");
    }
}
