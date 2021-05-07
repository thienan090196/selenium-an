package com.logigear.tests;

import com.logigear.helpers.DataHelper;
import com.logigear.models.Account;
import com.logigear.models.Ticket;
import com.logigear.page_objects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private Account account;

    @Test(description = "User can cancel a ticket")
    public void TC01() {
        account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPid());
        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToBookTicketPage();
        Ticket ticket = new Ticket(DataHelper.getDateFromToday(5), "Phan Thiết", "Đà Nẵng", "Soft seat", 1);
        bookTicketPage.bookTicket(ticket);
        homePage.goToMyTicketPage();
        int getTicketCount = myTicketPage.getTicketCount();
        myTicketPage.deleteTicket();
        int actualTicketAmount = myTicketPage.getTicketCount();
        int expectedTicketAmount = getTicketCount - 1;

        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket deleted unsuccessfully!");
    }
}
