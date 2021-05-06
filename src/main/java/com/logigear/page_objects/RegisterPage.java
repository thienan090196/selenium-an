package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import com.logigear.models.Account;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.id("email"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final TextBox txtPid = new TextBox(By.id("pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblSuccessMessage = new Label(By.id("content"));

    //Methods
    public void register(Account account) {
        this.btnRegister.scrollToView();
        this.txtEmail.enterText(account.getEmail());
        this.txtPassword.enterText(account.getPassword());
        this.txtConfirmPassword.enterText(account.getPassword());
        this.txtPid.enterText(account.getPid());
        this.btnRegister.click();
    }

    public String getSuccessMessage() {
        return this.lblSuccessMessage.getText();
    }
}
