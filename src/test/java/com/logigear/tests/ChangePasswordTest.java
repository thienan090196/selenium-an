package com.logigear.tests;

import com.logigear.helpers.DataHelper;
import com.logigear.helpers.ErrorMessage;
import com.logigear.models.Account;
import com.logigear.page_objects.ChangePasswordPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private Account account;

    @Test(description = "User cannot change password when 'New Password' and 'Confirm Password' are different")
    public void TC01() {
        account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPid());
        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account.getPassword(), "a123:\"/{}!@$\\", "b456:\"/{}!@$\\");

        String actualFormErrorMessage = changePasswordPage.getFormErrorMessage();
        String actualConfirmPasswordErrorMessage = changePasswordPage.getConfirmPasswordErrorMessage();
        Assert.assertEquals(actualFormErrorMessage, ErrorMessage.CHANGE_PASSWORD_FORM_ERROR, "Form error fails to display!");
        Assert.assertEquals(actualConfirmPasswordErrorMessage, ErrorMessage.CHANGE_PASSWORD_TWO_PASSWORDS_NOT_MATCH, "Password error fails to display!");
    }
}
