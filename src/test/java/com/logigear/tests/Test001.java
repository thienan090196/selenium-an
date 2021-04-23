package com.logigear.tests;

import com.logigear.helper.DataProviderHelper;
import com.logigear.models.Login;
import com.logigear.models.Register;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test001 extends BaseTest {

    @Test(dataProvider = "logins", dataProviderClass = DataProviderHelper.class)
    public void TC01(Login login) {
//        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.goToLoginPage();

        loginPage.login(login.getEmail(), login.getPassword());
    }

}
