package com.logigear.page_objects;

import com.logigear.elements.Label;
import org.openqa.selenium.By;

public class RegisterConfirmPage extends BasePage {

    //Elements
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content p"));

    //Methods
    @Override
    public String getMessage() {
        return this.lblSuccessfulMessage.getText();
    }
}
