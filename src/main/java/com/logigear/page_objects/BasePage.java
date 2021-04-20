package com.logigear.page_objects;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabHome = By.cssSelector("a[href='../']");
    private final By tabFAQ = By.cssSelector("a[href='/Page/FAQ.cshtml']");
    private final By tabContact = By.cssSelector("a[href='/Page/Contact.cshtml']");
    private final By tabTimetable = By.cssSelector("a[href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.cssSelector("a[href='/Page/TrainPriceListPage.cshtml']");
    private final By tabBookTicket = By.cssSelector("a[href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.cssSelector("a[href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.cssSelector("a[href='/Account/ChangePassword.cshtml']");
    private final By tabRegister = By.cssSelector("a[href='/Account/Register.cshtml']");
    private final By tabLogin = By.cssSelector("a[href='/Account/Login.cshtml']");
    private final By tabLogout = By.cssSelector("a[href='/Account/Logout']");

    //Elements
    protected WebElement getTabHome() {
        return Constant.WEB_DRIVER.findElement(tabHome);
    }

    protected WebElement getTabFAQ() {
        return Constant.WEB_DRIVER.findElement(tabFAQ);
    }

    protected WebElement getTabContact() {
        return Constant.WEB_DRIVER.findElement(tabContact);
    }

    protected WebElement getTabTimetable() {
        return Constant.WEB_DRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEB_DRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEB_DRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEB_DRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEB_DRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabRegister() {
        return Constant.WEB_DRIVER.findElement(tabRegister);
    }

    protected WebElement getTabLogin() {
        return Constant.WEB_DRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEB_DRIVER.findElement(tabLogout);
    }

    //Methods
    public void goToHomePage() {
        this.getTabHome().click();
    }

    public void goToFAQPage() {
        this.getTabFAQ().click();
    }

    public void goToContactPage() {
        this.getTabContact().click();
    }

    public void goToTimetablePage() {
        this.getTabTimetable().click();
    }

    public void goToTicketPricePage() {
        this.getTabTicketPrice().click();
    }

    public void goToBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void goToMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void goToChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();
    }

    public void goToLoginPage() {
        this.getTabLogin().click();
    }

    public void logout() {
        this.getTabLogout().click();
    }

}
