package com.logigear.page_objects;

import com.logigear.helper.element_helper.Label;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Elements
    private final Label lblWelcomeMessage = new Label(By.cssSelector(".account strong"));

    //Methods
    @Override
    public String getMessages() {
        return this.lblWelcomeMessage.getText();
    }
}
