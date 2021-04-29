package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Label;
import com.logigear.elements.TextBox;
import com.logigear.models.Account;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {

    //Elements
    private final TextBox txtCurrentPassword = new TextBox(By.cssSelector("#currentPassword"));
    private final TextBox txtNewPassword = new TextBox(By.cssSelector("#newPassword"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("#confirmPassword"));
    private final Button btnChangePassword = new Button(By.cssSelector("[title='Change password']"));
    private final Label lblSuccessMessage = new Label(By.cssSelector(".message.success"));

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.txtCurrentPassword.enterText(currentPassword);
        this.txtNewPassword.enterText(newPassword);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.btnChangePassword.scrollToView();
        this.btnChangePassword.click();
    }

    public String getSuccessMessage() {
        return this.lblSuccessMessage.getText();
    }
}
