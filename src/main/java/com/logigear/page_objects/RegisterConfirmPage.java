package com.logigear.page_objects;

import com.logigear.helper.Constant;
import com.logigear.helper.element_helper.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterConfirmPage extends BasePage {

    //Elements
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content p"));

    //Methods
    @Override
    public String getMessages() {
        return this.lblSuccessfulMessage.getText();
    }
}
