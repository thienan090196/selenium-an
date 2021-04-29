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
    //Ticket data
    private String departStation = "Phan Thiết";
    private String arriveStation = "Đà Nẵng";
    private String seatType = "Hard bed";
    private int pricePerOneTicket = 340000;

    @Test(description = "Book one ticket successfully with valid data")
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

        Ticket expectedTicket = new Ticket();
        expectedTicket.setDepartFrom(departStation);
        expectedTicket.setArriveAt(arriveStation);
        expectedTicket.setSeatType(seatType);
        expectedTicket.setDepartDate(DataHelper.getDateFromToday(4));
        expectedTicket.setBookDate(DataHelper.getDateToday());
        expectedTicket.setExpiredDate(DataHelper.getDateFromToday(3));
        expectedTicket.setTicketAmount(1);
        expectedTicket.setTotalPrice(pricePerOneTicket * expectedTicket.getTicketAmount());

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
