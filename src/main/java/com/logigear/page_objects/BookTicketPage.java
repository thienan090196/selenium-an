package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Dropdown;
import com.logigear.elements.Label;
import com.logigear.elements.Table;
import com.logigear.models.Ticket;
import org.openqa.selenium.By;

import java.util.HashMap;

public class BookTicketPage extends BasePage {

    //Elements
    private final Dropdown ddlDepartDate = new Dropdown(By.cssSelector("[name=Date]"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.cssSelector("[name=DepartStation]"));
    private final Dropdown ddlArriveAt = new Dropdown(By.cssSelector("[name=ArriveStation]"));
    private final Dropdown ddlSeatType = new Dropdown(By.cssSelector("[name=SeatType]"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.cssSelector("[name=TicketAmount]"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[value='Book ticket']"));
    private final Label lblSuccessMessage = new Label(By.cssSelector("#content h1"));
    private final Table tblTicketInformation = new Table(By.cssSelector(".MyTable.WideTable"));
    private final String cellLocator = "//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

    //Methods
    public void bookNewTicket(Ticket ticket) {
        this.ddlDepartFrom.selectDropdownByText(ticket.getDepartFrom());
        this.ddlDepartDate.selectDropdownByText(ticket.getDepartDate().toString());
        this.ddlSeatType.selectDropdownByText(ticket.getSeatType());
        this.ddlTicketAmount.selectDropdownByText(String.valueOf(ticket.getTicketAmount()));
        this.ddlArriveAt.selectDropdownByText(ticket.getArriveAt());
        this.btnBookTicket.submit();
    }

    public String getSuccessMessage() {
        return this.lblSuccessMessage.getText();
    }

    public Ticket getBookedTicketInformation() {
        Ticket ticket = new Ticket();
        ticket.setDepartFrom(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Depart Station"));
        ticket.setArriveAt(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Arrive Station"));
        ticket.setSeatType(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Seat Type"));
        ticket.setDepartDate(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Depart Date"));
        ticket.setBookDate(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Book Date"));
        ticket.setExpiredDate(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Expired Date"));
        ticket.setTicketAmount(Integer.parseInt(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Amount")));
        ticket.setTotalPrice(Integer.parseInt(this.tblTicketInformation.getCellValueByColumnTitle(this.cellLocator, "Total Price")));
        return ticket;
    }
}
