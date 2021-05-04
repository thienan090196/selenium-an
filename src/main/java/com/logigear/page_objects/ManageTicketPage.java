package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Dropdown;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import com.logigear.helpers.DriverHelper;
import com.logigear.models.Ticket;
import org.openqa.selenium.By;

public class ManageTicketPage extends BasePage {

    //Elements
    private final Button btnCancel = new Button(By.cssSelector(".MyTable input"));
    private final Dropdown ddlDepartStation = new Dropdown(By.cssSelector("select[name=FilterDpStation]"));
    private final Dropdown ddlArriveStation = new Dropdown(By.cssSelector("select[name=FilterArStation]"));
    private final TextBox txtDepartDate = new TextBox(By.cssSelector("input[name=FilterDpDate]"));
    private final Dropdown ddlStatus = new Dropdown(By.cssSelector("select[name=FilterStatus]"));
    private final Button btnApplyFilter = new Button(By.cssSelector("input[value='Apply Filter']"));
    private final Label lblFilterErrorMessage = new Label(By.cssSelector(".error.message"));

    //Methods
    public void deleteTicket() {
        this.btnCancel.scrollToView();
        this.btnCancel.click();
        this.btnCancel.waitForAlertPresent();
        DriverHelper.acceptAlert();
    }

    public int getFilterResult(Ticket ticket) {
        this.ddlDepartStation.selectDropdownByText(ticket.getDepartFrom());
        this.ddlArriveStation.selectDropdownByText(ticket.getArriveAt());
        this.txtDepartDate.enterText(ticket.getDepartDate());
        this.ddlStatus.selectDropdownByText(ticket.getStatus());
        this.btnApplyFilter.scrollToView();
        this.btnApplyFilter.click();
        return this.btnCancel.getTotalElements();
    }

    public String getFilterErrorMessage() {
        this.lblFilterErrorMessage.waitForElementVisible();
        return this.lblFilterErrorMessage.getText();
    }
}
