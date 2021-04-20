package com.logigear.page_objects;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //Locators
    private final By lblWelcomeMessage = By.xpath("//div[@class = 'account']//strong");

    //Elements
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEB_DRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

}
