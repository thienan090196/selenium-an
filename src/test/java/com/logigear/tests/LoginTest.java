package com.logigear.tests;

import com.logigear.helper.DataProviderHelper;
import com.logigear.models.Login;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "invalid-logins", dataProviderClass = DataProviderHelper.class, description = "Login unsuccessfully with blank email and password")
    public void TC01(Login login) {
        homePage.goToLoginPage();
        loginPage.login(login.getEmail(), login.getPassword());

        String actualResult = loginPage.getMessages();
        String expectedResult = login.getMessage();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "valid-login", dataProviderClass = DataProviderHelper.class, description = "Login successfully with valid email and password")
    public void TC02(Login login) {
        homePage.goToLoginPage();
        loginPage.login(login.getEmail(), login.getPassword());

        String actualResult = homePage.getMessages();
        String expectedResult = login.getMessage();

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }
}
