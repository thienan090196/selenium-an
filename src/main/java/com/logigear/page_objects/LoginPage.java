package com.logigear.page_objects;

import com.logigear.helper.element_helper.Button;
import com.logigear.helper.element_helper.Label;
import com.logigear.helper.element_helper.TextBox;
import org.openqa.selenium.By;

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
    public String getMessages() {
        return this.lblGeneralErrorMessage.getText() +
                this.lblEmailErrorMessage.getText() +
                this.lblPasswordErrorMessage.getText();
    }
}
