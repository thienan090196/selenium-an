package com.logigear.tests;

import com.logigear.helpers.Constant;
import com.logigear.page_objects.BookTicketPage;
import com.logigear.page_objects.HomePage;
import com.logigear.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private String departDate = "5/1/2021";
    private String departFrom = "Huế";
    private String arriveAt = "Đà Nẵng";
    private String seatType = "Hard seat";
    private String ticketAmount = "1";

    @Test(description = "Book ticket successfully with valid data")
    public void TC01() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.goToBookTicketPage();
        bookTicketPage.bookNewTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        String actualResult = bookTicketPage.getGeneralMessage();
        String expectedResult = "Ticket Booked Successfully!";

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);
    }
}
