package com.logigear.tests;

import com.logigear.helper.DataProviderHelper;
import com.logigear.helper.LoggerHelper;
import com.logigear.models.Login;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.goToLoginPage();
    }

    @Test(dataProvider = "valid-login", dataProviderClass = DataProviderHelper.class, description = "Login successfully with valid email and password")
    public void TC01(Login login) {
        LoggerHelper.info(login.getDescription());

        loginPage.login(login.getEmail(), login.getPassword());

        String actualResult = homePage.getMessages();
        String expectedResult = login.getMessage();
        LoggerHelper.info("Actual result: " + actualResult + "---" + "Expected result: " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalid-logins", dataProviderClass = DataProviderHelper.class, description = "Login unsuccessfully with invalid data")
    public void TC02(Login login) {
        LoggerHelper.info(login.getDescription());

        loginPage.login(login.getEmail(), login.getPassword());

        String actualResult = loginPage.getMessages();
        String expectedResult = login.getMessage();
        LoggerHelper.info("Actual result: " + actualResult + "---" + "Expected result: " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.isTabLogoutExist()) {
            homePage.logout();
        }
    }
}
