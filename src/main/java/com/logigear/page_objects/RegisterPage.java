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
    private final Label lblGeneralErrorMessage = new Label(By.xpath("//p[contains(@class, 'message')]"));
    private final Label lblEmailErrorMessage = new Label(By.xpath("//label[@for='email' and @class = 'validation-error']"));
    private final Label lblPasswordErrorMessage = new Label(By.xpath("//label[@for='password' and @class = 'validation-error']"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.xpath("//label[@for='confirmPassword' and @class = 'validation-error']"));
    private final Label lblPIDErrorMessage = new Label(By.xpath("//label[@for='pid' and @class = 'validation-error']"));

    //Methods
    public void register(String email, String password, String pid) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(password);
        this.txtPID.enterText(pid);
        this.btnRegister.click();
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
