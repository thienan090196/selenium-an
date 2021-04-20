package com.logigear.page_objects;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Locators
    private final By txtEmail = By.cssSelector("input#username");
    private final By txtPassword = By.cssSelector("input#password");
    private final By btnLogin = By.cssSelector("input[title='Login']");
    private final By lblGeneralErrorMessage = By.xpath("//p[contains(@class, 'message')]");
    private final By lblEmailErrorMessage = By.xpath("//label[@for='username' and @class = 'validation-error']");
    private final By lblPasswordErrorMessage = By.xpath("//label[@for='password' and @class = 'validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return Constant.WEB_DRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEB_DRIVER.findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEB_DRIVER.findElement(btnLogin);
    }

    protected WebElement getLblGeneralErrorMessage() {
        return Constant.WEB_DRIVER.findElement(lblGeneralErrorMessage);
    }

    protected WebElement getLblEmailErrorMessage() {
        return Constant.WEB_DRIVER.findElement(lblEmailErrorMessage);
    }

    protected WebElement getLblPasswordErrorMessage() {
        return Constant.WEB_DRIVER.findElement(lblPasswordErrorMessage);
    }

    //Methods
    public void login(String email, String password) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public String getGeneralErrorMessage() {
        return this.getLblGeneralErrorMessage().getText();
    }

    public String getEmailErrorMessage() {
        return this.getLblEmailErrorMessage().getText();
    }

    public String getPasswordErrorMessage() {
        return this.getLblPasswordErrorMessage().getText();
    }

}
