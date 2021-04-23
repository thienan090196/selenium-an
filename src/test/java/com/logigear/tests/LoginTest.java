package com.logigear.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helper.Common;
import com.logigear.models.General;
import com.logigear.models.Login;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private List<Login> logins;

    @BeforeClass
    public void beforeTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        General general = objectMapper.readValue(Common.readFile("test-data.json"), General.class);
        List<Login> abc = objectMapper.readValue(Common.readFile("te"), new TypeReference<List<Login>>() {});

        logins = general.getLogins();
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.goToLoginPage();
    }

    @AfterClass
    public void afterTest() {
        homePage.logout();
    }

    @Test (dataProvider = "login-data.json")
    @Description("Login unsuccessfully with blank email and password")
    public void TC01() {
        System.out.println(logins.get(0).getDescription());
        loginPage.login(logins.get(0).getEmail(), logins.get(0).getPassword());
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), logins.get(0).getMessages().getGeneralMessage());
        Assert.assertEquals(loginPage.getEmailErrorMessage(), logins.get(0).getMessages().getEmailMessage());
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), logins.get(0).getMessages().getPasswordMessage());
    }

    @Test
    @Description("Login unsuccessfully with invalid email and password")
    public void TC02() {
        System.out.println(logins.get(1).getDescription());
        loginPage.login(logins.get(1).getEmail(), logins.get(1).getPassword());
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), logins.get(1).getMessages().getGeneralMessage());
    }

    @Test
    @Description("Login unsuccessfully with blank password")
    public void TC03() {
        System.out.println(logins.get(2).getDescription());
        loginPage.login(logins.get(2).getEmail(), logins.get(2).getPassword());
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), logins.get(2).getMessages().getGeneralMessage());
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), logins.get(2).getMessages().getPasswordMessage());
    }

    @Test
    @Description("Login unsuccessfully with blank email")
    public void TC04() {
        System.out.println(logins.get(3).getDescription());
        loginPage.login(logins.get(3).getEmail(), logins.get(3).getPassword());
        Assert.assertEquals(loginPage.getGeneralErrorMessage(), logins.get(3).getMessages().getGeneralMessage());
        Assert.assertEquals(loginPage.getEmailErrorMessage(), logins.get(3).getMessages().getEmailMessage());
    }

    @Test
    @Description("Login successfully with valid email and password")
    public void TC05() {
        System.out.println(logins.get(4).getDescription());
        loginPage.login(logins.get(4).getEmail(), logins.get(4).getPassword());
        Assert.assertEquals(homePage.getWelcomeMessage(), logins.get(4).getMessages().getGeneralMessage(), "Welcome message fails to display!");
    }

}
