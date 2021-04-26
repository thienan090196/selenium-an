package com.logigear.tests;

import com.logigear.helper.Common;
import com.logigear.helper.DataProviderHelper;
import com.logigear.models.Register;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterConfirmPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "valid-register", dataProviderClass = DataProviderHelper.class, description = "Register successfully with valid data")
    public void TC01(Register register) {
        homePage.goToRegisterPage();
        register.setEmail(Common.generateRandomEmailString());
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualResult = registerConfirmPage.getMessages();
        String expectedResult = register.getMessage();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }

    @Test(dataProvider = "invalid-registers", dataProviderClass = DataProviderHelper.class, description = "Register unsuccessfully with invalid data")
    public void TC02(Register register) {
        homePage.goToRegisterPage();
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        String actualResult = registerPage.getMessages();
        String expectedResult = register.getMessage();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }
}
