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

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "valid-register", dataProviderClass = DataProviderHelper.class, description = "Register successfully with valid data")
    public void TC01(Register register) {
        homePage.goToRegisterPage();
        register.setEmail(Common.generateRandomEmailString());
        registerPage.register(register.getEmail(), register.getPassword(), register.getPid());

        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualResult = registerConfirmPage.getMessages();
        String expectedResult = register.getMessage();
        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }
}
