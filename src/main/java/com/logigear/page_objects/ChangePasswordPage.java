package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {

    //Elements
    private final TextBox txtCurrentPassword = new TextBox(By.id("currentPassword"));
    private final TextBox txtNewPassword = new TextBox(By.id("newPassword"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final Button btnChangePassword = new Button(By.cssSelector("input[title='Change password']"));
    private final Label lblFormErrorMessage = new Label(By.className("message"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector("[for='confirmPassword'].validation-error"));

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.btnChangePassword.scrollToView();
        this.txtCurrentPassword.enterText(currentPassword);
        this.txtNewPassword.enterText(newPassword);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.btnChangePassword.click();
    }

    public String getFormErrorMessage() {
        return this.lblFormErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return this.lblConfirmPasswordErrorMessage.getText();
    }
}
