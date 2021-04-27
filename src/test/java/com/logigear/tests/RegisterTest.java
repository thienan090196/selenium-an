package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helpers.Common;
import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.LoggerHelper;
import com.logigear.models.Register;
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

        String actualResult = registerPage.getGeneralMessage();
        String expectedResult = "You're here";
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalid-register-data", description = "Register unsuccessfully with invalid data")
    public void TC02(Register register) {
        LoggerHelper.info(register.getDescription());

        homePage.goToRegisterPage();
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        String actualGeneralMessage = registerPage.getGeneralMessage();
        String expectedGeneralMessage = register.getMessages().getGeneralMessage();
        String actualEmailMessage = registerPage.getEmailMessage();
        String expectedEmailMessage = register.getMessages().getEmailMessage();
        String actualPasswordMessage = registerPage.getPasswordMessage();
        String expectedPasswordMessage = register.getMessages().getPasswordMessage();
        String actualConfirmPasswordMessage = registerPage.getConfirmPasswordMessage();
        String expectedConfirmPasswordMessage = register.getMessages().getConfirmPasswordMessage();
        String actualPIDMessage = registerPage.getPIDMessage();
        String expectedPIDMessage = register.getMessages().getPidMessage();

        Assert.assertEquals(actualGeneralMessage, expectedGeneralMessage, actualGeneralMessage + " is not matched with " + expectedGeneralMessage);
        Assert.assertEquals(actualEmailMessage, expectedEmailMessage, actualEmailMessage + " is not matched with " + expectedEmailMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, actualPasswordMessage + " is not matched with " + expectedPasswordMessage);
        Assert.assertEquals(actualConfirmPasswordMessage, expectedConfirmPasswordMessage, actualConfirmPasswordMessage + " is not matched with " + expectedConfirmPasswordMessage);
        Assert.assertEquals(actualPIDMessage, expectedPIDMessage, actualPIDMessage + " is not matched with " + expectedPIDMessage);
    }

    @DataProvider(name = "invalid-register-data")
    public static Object[] getInvalidRegistersData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "invalid-register-data.json"), new TypeReference<List<Register>>() {
        });
        return registers.toArray();
    }
}
