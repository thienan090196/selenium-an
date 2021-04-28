package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.helpers.DataHelper;
import com.logigear.models.Account;
import com.logigear.models.Ticket;
import com.logigear.page_objects.BookTicketPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "Book ticket successfully with valid data")
    public void TC01() {
        homePage.goToLoginPage();

        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        Ticket expectedTicket = new Ticket();
        expectedTicket.setDepartFrom(Constant.departStation);
        expectedTicket.setArriveAt(Constant.arriveStation);
        expectedTicket.setSeatType(Constant.seatType);
        expectedTicket.setDepartDate(DataHelper.getDateFromToday(4));
        expectedTicket.setBookDate(DataHelper.getDateFromToday());
        expectedTicket.setExpiredDate(DataHelper.getDateFromToday(3));
        expectedTicket.setTicketAmount(1);
        expectedTicket.setTotalPrice(Constant.pricePerOneTicket * expectedTicket.getTicketAmount());

        homePage.goToBookTicketPage();
        bookTicketPage.bookNewTicket(expectedTicket);

        String actualResult = bookTicketPage.getSuccessMessage();
        String expectedResult = "Ticket Booked Successfully!";
        Ticket actualTicket = bookTicketPage.getBookedTicketInformation();

        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
        Assert.assertEquals(actualTicket.getDepartFrom(), expectedTicket.getDepartFrom());
        Assert.assertEquals(actualTicket.getArriveAt(), expectedTicket.getArriveAt());
        Assert.assertEquals(actualTicket.getSeatType(), expectedTicket.getSeatType());
        Assert.assertEquals(actualTicket.getDepartDate(), expectedTicket.getDepartDate());
        Assert.assertEquals(actualTicket.getBookDate(), expectedTicket.getBookDate());
        Assert.assertEquals(actualTicket.getExpiredDate(), expectedTicket.getExpiredDate());
        Assert.assertEquals(actualTicket.getTicketAmount(), expectedTicket.getTicketAmount());
        Assert.assertEquals(actualTicket.getTotalPrice(), expectedTicket.getTotalPrice());
    }
}
