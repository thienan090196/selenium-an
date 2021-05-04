package com.logigear.page_objects;

import com.logigear.elements.Label;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Elements
    public final Label lblWelcomeMessage = new Label(By.cssSelector(".account strong"));

    //Methods
    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }
}
