package com.logigear.tests;

import com.logigear.helpers.DataHelper;
import com.logigear.models.Account;
import com.logigear.page_objects.ChangePasswordPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private RegisterPage registerPage = new RegisterPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private String newPassword = "abc@1234";

    @Test(description = "Change password successfully with valid data")
    public void TC01() {
        homePage.goToRegisterPage();
        Account account = new Account();
        account.setEmail(DataHelper.getRandomEmail());
        account.setPassword(DataHelper.getRandomPassword());
        account.setConfirmPassword(account.getPassword());
        account.setPid(DataHelper.getRandomPid());
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);

        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account.getPassword(), newPassword, newPassword);
        account.setPassword(newPassword);

        String actualResult = changePasswordPage.getSuccessMessage();
        String expectedResult = "Your password has been updated!";

        homePage.logout();
        homePage.goToLoginPage();
        loginPage.login(account);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
