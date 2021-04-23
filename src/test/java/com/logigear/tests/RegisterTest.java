package com.logigear.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.helper.Common;
import com.logigear.models.General;
import com.logigear.models.Register;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.RegisterConfirmPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;
    private List<Register> registers;

    @BeforeClass
    public void beforeTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        General general = objectMapper.readValue(Common.readFile("test-data.json"), General.class);
        registers = general.getRegisters();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        homePage.goToRegisterPage();
    }

    @AfterClass
    public void afterTest() {

    }

    @Test
//    @Description("Register successfully with valid data")
    public void TC01() {
        System.out.println(registers.get(0).getDescription());
        registerPage.register(Common.generateRandomEmailString(), registers.get(0).getPassword(), registers.get(0).getPid());
        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        Assert.assertEquals(registerConfirmPage.getSuccessfulMessage(), registers.get(0).getMessages().getGeneralMessage());
    }

}
