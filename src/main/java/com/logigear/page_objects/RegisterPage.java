package com.logigear.page_objects;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    //Locators
    private final By txtEmail = By.cssSelector("input#email");
    private final By txtPassword = By.cssSelector("input#password");
    private final By txtConfirmPassword = By.cssSelector("input#confirmPassword");
    private final By txtPID = By.cssSelector("input#pid");
    private final By btnRegister = By.cssSelector("input[title='Register']");

//    private final By lblGeneralErrorMessage = By.xpath("//p[contains(@class, 'message')]");
//    private final By lblEmailErrorMessage = By.xpath("//label[@for='username' and @class = 'validation-error']");
//    private final By lblPasswordErrorMessage = By.xpath("//label[@for='password' and @class = 'validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return Constant.WEB_DRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEB_DRIVER.findElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEB_DRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return Constant.WEB_DRIVER.findElement(txtPID);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEB_DRIVER.findElement(btnRegister);
    }

//    protected WebElement getLblGeneralErrorMessage() {
//        return Constant.WEB_DRIVER.findElement(lblGeneralErrorMessage);
//    }
//
//    protected WebElement getLblEmailErrorMessage() {
//        return Constant.WEB_DRIVER.findElement(lblEmailErrorMessage);
//    }
//
//    protected WebElement getLblPasswordErrorMessage() {
//        return Constant.WEB_DRIVER.findElement(lblPasswordErrorMessage);
//    }

    //Methods
    public void register(String email, String password, String pid) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(password);
        this.getTxtPID().sendKeys(pid);
        this.getBtnRegister().click();
    }

//    public String getGeneralErrorMessage() {
//        return this.getLblGeneralErrorMessage().getText();
//    }
//
//    public String getEmailErrorMessage() {
//        return this.getLblEmailErrorMessage().getText();
//    }
//
//    public String getPasswordErrorMessage() {
//        return this.getLblPasswordErrorMessage().getText();
//    }

}
