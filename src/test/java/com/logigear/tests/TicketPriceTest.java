package com.logigear.tests;

import com.google.common.collect.Maps;
import com.logigear.helpers.Constant;
import com.logigear.models.Account;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.logigear.page_objects.TicketPricePage;
import com.logigear.page_objects.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TicketPriceTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private TimetablePage timetablePage = new TimetablePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();
    private Account account;

    @Test(description = "Ticket price page displays with ticket details after clicking on 'check price' link in Train timetable page")
    public void TC01() {
        String departStation = "Đà Nẵng";
        String arrivalStation = "Sài Gòn";

        account = new Account(Constant.EMAIL, Constant.PASSWORD);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToTimetablePage();
        timetablePage.checkTicketPrice(departStation, arrivalStation);
        HashMap<String, String> actualTicketPriceData = new HashMap<>();
        actualTicketPriceData.put("HS", "90000");
        actualTicketPriceData.put("SS", "115000");
        actualTicketPriceData.put("SSC", "140000");
        actualTicketPriceData.put("HB", "190000");
        actualTicketPriceData.put("SB", "240000");
        actualTicketPriceData.put("SBC", "290000");

        Assert.assertEquals(actualTicketPriceData, ticketPricePage.getTicketPrice(), "Ticket price displays incorrectly!");
    }
}
