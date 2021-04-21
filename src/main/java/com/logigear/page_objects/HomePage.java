package com.logigear.page_objects;

import com.logigear.helper.element_helper.Label;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Elements
    private final Label lblWelcomeMessage = new Label(By.xpath("//div[@class = 'account']//strong"));

    //Methods
    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }

}
