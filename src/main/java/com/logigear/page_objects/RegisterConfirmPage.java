package com.logigear.page_objects;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterConfirmPage extends BasePage {

    //Locators
    private final By lblSuccessfulMessage = By.xpath("//div[@id = 'content']//p");

    //Elements
    protected WebElement getLblSuccessfulMessage() {
        return Constant.WEB_DRIVER.findElement(lblSuccessfulMessage);
    }

    //Methods
    public String getSuccessfulMessage() {
        return this.getLblSuccessfulMessage().getText();
    }

}
