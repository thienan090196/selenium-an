package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.helpers.DriverHelper;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    //Elements
    private final Button btnCancel = new Button(By.cssSelector(".MyTable input"));

    //Methods
    public void deleteTicket() {
        this.btnCancel.scrollToView();
        this.btnCancel.click();
        DriverHelper.waitForAlertPresent();
        DriverHelper.acceptAlert();
    }

    public int getTotalTicket() {
        return this.btnCancel.getElementCount();
    }
}
