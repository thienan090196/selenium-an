package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Dropdown;
import com.logigear.elements.Label;
import org.openqa.selenium.By;

public class BookTicketPage extends BasePage {

    //Elements
    private final Dropdown ddlDepartDate = new Dropdown(By.cssSelector("[name=Date]"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.cssSelector("[name=DepartStation]"));
    private final Dropdown ddlArriveAt = new Dropdown(By.cssSelector("[name=ArriveStation]"));
    private final Dropdown ddlSeatType = new Dropdown(By.cssSelector("[name=SeatType]"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.cssSelector("[name=TicketAmount]"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[value='Book ticket']"));
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content h1"));
    private final Label lblReloadMessage = new Label(By.cssSelector("#ArriveStation [href='http://somee.com']"));

    //Methods
    public void bookNewTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.ddlDepartDate.selectDropdownByText(departDate);
        this.ddlDepartFrom.selectDropdownByText(departFrom);
        this.lblReloadMessage.waitForElementVisible();
        this.ddlArriveAt.selectDropdownByText(arriveAt);
        this.ddlSeatType.selectDropdownByText(seatType);
        this.ddlTicketAmount.selectDropdownByText(ticketAmount);
        this.btnBookTicket.scrollToView();
        this.btnBookTicket.click();
    }

    @Override
    public String getGeneralMessage() {
        return lblSuccessfulMessage.getText();
    }
}
