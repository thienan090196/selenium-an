package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Dropdown;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import com.logigear.helpers.DriverHelper;
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

    public void applyFilter(String departStation, String arriveStation, String departDate, String status) {
        this.ddlDepartStation.selectDropdownByText(departStation);
        this.ddlArriveStation.selectDropdownByText(arriveStation);
        this.txtDepartDate.enterText(departDate);
        this.ddlStatus.selectDropdownByText(status);
        this.btnApplyFilter.scrollToView();
        this.btnApplyFilter.click();
    }

    public String getFilterErrorMessage() {
        this.lblFilterErrorMessage.waitForElementVisible();
        return this.lblFilterErrorMessage.getText();
    }
}
