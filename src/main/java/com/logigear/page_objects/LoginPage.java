package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import org.openqa.selenium.By;

import java.util.HashMap;

public class LoginPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#username"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final Button btnLogin = new Button(By.cssSelector("input[title='Login']"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error.LoginForm"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=username].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));

    //Methods
    public void login(String email, String password) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.btnLogin.scrollToView();
        this.btnLogin.click();
    }

    @Override
    public String getGeneralMessage() {
        return this.lblGeneralErrorMessage.getText();
    }

    public String getEmailMessage() {
        return this.lblEmailErrorMessage.getText();
    }

    public String getPasswordMessage() {
        return this.lblPasswordErrorMessage.getText();
    }
}
