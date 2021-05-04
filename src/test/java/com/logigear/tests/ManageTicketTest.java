package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.helpers.ErrorMessage;
import com.logigear.models.Account;
import com.logigear.models.Ticket;
import com.logigear.page_objects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private ManageTicketPage manageTicketPage = new ManageTicketPage();
    //Ticket data
    private String departStation = "Phan Thiết";
    private String arriveStation = "Đà Nẵng";
    private String seatType = "Hard bed";

    @Test(description = "Delete one ticket successfully")
    public void TC01() {
        homePage.goToRegisterPage();
        Account account = new Account();
        account.setEmail(DataHelper.getRandomEmail());
        account.setPassword(DataHelper.getRandomPassword());
        account.setConfirmPassword(account.getPassword());
        account.setPid(DataHelper.getRandomPid());
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToBookTicketPage();

        Ticket ticket = new Ticket();
        ticket.setDepartFrom(departStation);
        ticket.setArriveAt(arriveStation);
        ticket.setSeatType(seatType);
        ticket.setDepartDate(DataHelper.getDateFromToday(5));
        ticket.setTicketAmount(1);

        bookTicketPage.bookNewTicket(ticket);
        homePage.goToManageTicketPage();
        manageTicketPage.deleteTicket();

        String actualResult = manageTicketPage.getFilterErrorMessage();
        String expectedResult = ErrorMessage.NO_TICKET_FOUND;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Filter ticket successfully with valid data")
    public void TC02() {
        String username = "testfilter01@gmail.com";
        String password = "abc@12345";
        Account account = new Account(username, password);

        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToBookTicketPage();

        Ticket ticket = new Ticket();
        ticket.setDepartFrom(departStation);
        ticket.setArriveAt(arriveStation);
        ticket.setSeatType(seatType);
        ticket.setDepartDate(DataHelper.getDateFromToday(5));
        ticket.setTicketAmount(1);

        bookTicketPage.bookNewTicket(ticket);
        homePage.goToManageTicketPage();

        int actualResult = manageTicketPage.getFilterResult(ticket);
        int expectedResult = 1;

        Assert.assertEquals(actualResult, expectedResult);
    }
}
