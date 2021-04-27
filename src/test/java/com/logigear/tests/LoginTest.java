package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Login;
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
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualResult = homePage.getMessage();
        String expectedResult = "Welcome " + Constant.USERNAME;
        LoggerHelper.info("Actual result: " + actualResult + "---" + "Expected result: " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalid-login-data", description = "Login unsuccessfully with invalid data")
    public void TC02(Login login) {
        LoggerHelper.info(login.getDescription());

        homePage.goToLoginPage();
        loginPage.login(login.getEmail(), login.getPassword());

        String actualResult = loginPage.getMessage();
        String expectedResult = login.getMessage();
        LoggerHelper.info("Actual result: " + actualResult + "---" + "Expected result: " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @DataProvider(name = "invalid-login-data")
    public static Object[] getInvalidLoginsData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> login = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-login-data.json"), new TypeReference<List<Login>>() {
        });
        return login.toArray();
    }

}
