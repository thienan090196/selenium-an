package com.logigear.page_objects;

import com.logigear.helper.element_helper.Button;
import com.logigear.helper.element_helper.Label;
import com.logigear.helper.element_helper.TextBox;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("input#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("input#pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=email].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector("[for=confirmPassword].validation-error"));
    private final Label lblPIDErrorMessage = new Label(By.cssSelector("[for=pid].validation-error"));

    //Methods
    public void register(String email, String password, String pid) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(password);
        this.txtPID.enterText(pid);
        this.btnRegister.scrollToView();
        this.btnRegister.click();
    }

    @Override
    public String getMessages() {
        return this.lblGeneralErrorMessage.getText() +
                this.lblEmailErrorMessage.getText() +
                this.lblPasswordErrorMessage.getText() +
                this.lblConfirmPasswordErrorMessage.getText() +
                this.lblPIDErrorMessage.getText();
    }
}
