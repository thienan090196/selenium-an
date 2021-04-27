package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Register;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterConfirmPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();

    @DataProvider(name = "invalid-register-data")
    public static Object[] getInvalidRegistersData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-register-data.json"), new TypeReference<List<Register>>() {
        });
        return registers.toArray();
    }

    @Test(description = "Register successfully with valid data")
    public void TC01() {
        LoggerHelper.info("Register successfully with valid data");

        homePage.goToRegisterPage();

        Register register = new Register();
        register.setEmail(DataHelper.getRandomEmail());
        register.setPassword(DataHelper.getRandomPassword());
        register.setConfirmPassword(register.getPassword());
        register.setPid(DataHelper.getRandomPid());
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualResult = registerConfirmPage.getMessage();
        String expectedResult = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalid-register-data", description = "Register unsuccessfully with invalid data")
    public void TC02(Register register) {
        LoggerHelper.info(register.getDescription());

        homePage.goToRegisterPage();
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        String actualResult = registerPage.getMessage();
        String expectedResult = register.getMessage();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }
}
