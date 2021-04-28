package com.logigear.page_objects;

import com.logigear.elements.Label;
import com.logigear.elements.Link;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Elements
    public final Label lblWelcomeMessage = new Label(By.cssSelector(".account strong"));
    private final Link lnkCreateAccount = new Link(By.cssSelector("#content a[href='/Account/Register.cshtml']"));

    //Methods
    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }

    public void createAccount() {
        this.lnkCreateAccount.click();
    }
}
