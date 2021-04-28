package com.logigear.page_objects;

import com.logigear.elements.Button;
import org.openqa.selenium.By;

public class BasePage {

    //Elements
    private final Button btnHome = new Button(By.xpath("//span[text() = 'Home']//parent::a"));
    private final Button btnFAQ = new Button(By.cssSelector("a[href='/Page/FAQ.cshtml']"));
    private final Button btnContact = new Button(By.cssSelector("a[href='/Page/Contact.cshtml']"));
    private final Button btnTimetable = new Button(By.cssSelector("a[href='TrainTimeListPage.cshtml']"));
    private final Button btnTicketPrice = new Button(By.cssSelector("a[href='/Page/TrainPriceListPage.cshtml']"));
    private final Button btnBookTicket = new Button(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']"));
    private final Button btnMyTicket = new Button(By.cssSelector("a[href='/Page/ManageTicket.cshtml']"));
    private final Button btnChangePassword = new Button(By.cssSelector("a[href='/Account/ChangePassword.cshtml']"));
    private final Button btnRegister = new Button(By.cssSelector("#menu a[href='/Account/Register.cshtml']"));
    private final Button btnLogin = new Button(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Button btnLogout = new Button(By.cssSelector("a[href='/Account/Logout']"));

    //Methods
    public void goToHomePage() {
        this.btnHome.click();
    }

    public void goToFAQPage() {
        this.btnFAQ.click();
    }

    public void goToContactPage() {
        this.btnContact.click();
    }

    public void goToTimetablePage() {
        this.btnTimetable.click();
    }

    public void goToTicketPricePage() {
        this.btnTicketPrice.click();
    }

    public void goToBookTicketPage() {
        this.btnBookTicket.click();
    }

    public void goToMyTicketPage() {
        this.btnMyTicket.click();
    }

    public void goToChangePasswordPage() {
        this.btnChangePassword.click();
    }

    public void goToRegisterPage() {
        this.btnRegister.click();
    }

    public void goToLoginPage() {
        this.btnLogin.click();
    }

    public void logout() {
        this.btnLogout.click();
    }
}
