package com.logigear.tests;

import com.logigear.helpers.DataHelper;
import com.logigear.models.Account;
import com.logigear.models.Ticket;
import com.logigear.page_objects.BookTicketPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import com.logigear.page_objects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private Account account;

    @Test(description = "User can book many tickets at a time")
    public void TC01() {
        account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPid());
        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToBookTicketPage();
        Ticket ticket = new Ticket(DataHelper.getDateFromToday(5), "Nha Trang", "Sài Gòn", "Soft seat", 5);
        bookTicketPage.bookTicket(ticket);

        String actualSuccessMessage = bookTicketPage.getSuccessMessage();
        String expectedSuccessMessage = "Ticket Booked Successfully!";
        Ticket actualTicket = bookTicketPage.getBookedTicketInformation();

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message fails to displays!");
        Assert.assertEquals(actualTicket.getDepartDate(), ticket.getDepartDate(), "Depart Date displays incorrectly!");
        Assert.assertEquals(actualTicket.getDepartFrom(), ticket.getDepartFrom(), "Depart Station displays incorrectly!");
        Assert.assertEquals(actualTicket.getArriveAt(), ticket.getArriveAt(), "Arrival Station displays incorrectly!");
        Assert.assertEquals(actualTicket.getSeatType(), ticket.getSeatType(), "Seat Type displays incorrectly!");
        Assert.assertEquals(actualTicket.getTicketAmount(), ticket.getTicketAmount(), "Amount of ticket displays incorrectly!");
    }
}
