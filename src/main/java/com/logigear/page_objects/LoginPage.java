package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.TextBox;
import com.logigear.models.Account;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector("input[title='Login']"));

    //Methods
    public void login(Account account) {
        this.btnLogin.scrollToView();
        this.txtEmail.enterText(account.getEmail());
        this.txtPassword.enterText(account.getPassword());
        this.btnLogin.click();
    }
}
