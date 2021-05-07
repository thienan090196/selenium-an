package com.logigear.page_objects;

import com.logigear.elements.Link;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {

    //Elements
    private String dynamicLnkCheckPriceLocator = "//td[count(//th[text()='%s']/preceding-sibling::th)+1][text()='%s']//..//td[count(//th[text()='%s']/preceding-sibling::th)+1][text()='%s']//..//a[text()='check price']";
    private Link lnkCheckPrice;

    //Methods
    public void checkTicketPrice(String departStation, String arrivalStation) {
        this.dynamicLnkCheckPriceLocator = String.format(dynamicLnkCheckPriceLocator, (Object[]) new String[]{"Depart Station", departStation, "Arrive Station", arrivalStation});
        this.lnkCheckPrice = new Link(By.xpath(dynamicLnkCheckPriceLocator));
        this.lnkCheckPrice.scrollToView();
        this.lnkCheckPrice.click();
    }
}
