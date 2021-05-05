package com.logigear.page_objects;

import com.logigear.elements.Button;
import org.openqa.selenium.By;

public class BasePage {

    //Elements
    private final Button btnHome = new Button(By.xpath("//span[text() = 'Home']//parent::a"));
    private final Button btnLogin = new Button(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Button btnBookTicket = new Button(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']"));

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
}
