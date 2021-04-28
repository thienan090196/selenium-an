package com.logigear.page_objects;

import com.logigear.elements.Button;
import com.logigear.elements.Table;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    //Elements
    private final Table tblManageTicket = new Table(By.cssSelector(".MyTable"));
    private final Button btnCancel = new Button(By.cssSelector("[value=Cancel]"));
//    private final Label label = new Label(By.xpath("count(//th[text()='No.'])"));

    //Methods
//    public void deleteTicket() {
//        System.out.println(this.btnCancel.findElements().size());
//        for (int i = 0; i < this.btnCancel.findElements().size() - 1; i++) {
//            this.btnCancel.scrollToView();
//            this.btnCancel.click();
//            DriverManagerFactory.doActionOnPopup(DriverManagerFactory.PopupAction.ACCEPT);
//            System.out.println(i);
//        }
//    }
}
