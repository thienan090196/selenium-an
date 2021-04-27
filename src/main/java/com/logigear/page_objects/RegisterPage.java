package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("input#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("input#pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content p"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=email].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector("[for=confirmPassword].validation-error"));
    private final Label lblPIDErrorMessage = new Label(By.cssSelector("[for=pid].validation-error"));

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.txtPID.enterText(pid);
        this.btnRegister.scrollToView();
        this.btnRegister.click();
    }

    @Override
    public String getGeneralMessage() {
        return this.lblGeneralErrorMessage.isExisted() ? this.lblGeneralErrorMessage.getText() : this.lblSuccessfulMessage.getText();
    }

    public String getEmailMessage() {
        return this.lblEmailErrorMessage.getText();
    }

    public String getPasswordMessage() {
        return this.lblPasswordErrorMessage.getText();
    }

    public String getConfirmPasswordMessage() {
        return this.lblConfirmPasswordErrorMessage.getText();
    }

    public String getPIDMessage() {
        return this.lblPIDErrorMessage.getText();
    }

}
