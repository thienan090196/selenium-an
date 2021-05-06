package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import org.openqa.selenium.By;

public class BasePage {

    //Elements
    private final Button btnHome = new Button(By.xpath("//span[text() = 'Home']//parent::a"));
    private final Button btnLogin = new Button(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Button btnBookTicket = new Button(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']"));
    private final Label lblPageHeader = new Label(By.cssSelector("#content h1"));

    //Methods
    public void goToHomePage() {
        this.btnHome.click();
    }

    public void goToLoginPage() {
        this.btnLogin.click();
    }

    public void goToBookTicketPage() {
        this.btnBookTicket.click();
    }

    public String getPageHeader() {
        return this.lblPageHeader.getText();
    }
}
