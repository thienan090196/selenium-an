package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import com.logigear.models.Account;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("input#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("input#pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblSuccessMessage = new Label(By.cssSelector("#content p"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=email].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector("[for=confirmPassword].validation-error"));
    private final Label lblPIDErrorMessage = new Label(By.cssSelector("[for=pid].validation-error"));

    //Methods
    public void register(Account account) {
        this.txtEmail.enterText(account.getEmail());
        this.txtPassword.enterText(account.getPassword());
        this.txtConfirmPassword.enterText(account.getConfirmPassword());
        this.txtPID.enterText(account.getPid());
        this.btnRegister.scrollToView();
        this.btnRegister.click();
    }

    public String getSuccessMessage() {
        return this.lblSuccessMessage.getText();
    }

    public String getGeneralErrorMessage() {
        return this.lblGeneralErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return this.lblEmailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblPasswordErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return this.lblConfirmPasswordErrorMessage.getText();
    }

    public String getPIDErrorMessage() {
        return this.lblPIDErrorMessage.getText();
    }

}
