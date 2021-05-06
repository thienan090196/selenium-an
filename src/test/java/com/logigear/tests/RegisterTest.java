package com.logigear.tests;

import com.logigear.helpers.DataHelper;
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

        String actualResult = registerPage.getSuccessMessage();
        String expectedResult = "You're here";
        Assert.assertEquals(actualResult, expectedResult, "Success message fails to display!");
    }
}
