package com.logigear.page_objects;

import com.logigear.elements.Table;
import org.openqa.selenium.By;

import java.util.HashMap;

public class TicketPricePage extends BasePage {

    //Elements
    private final String dynamicTicketPriceLocator = "//td[text()='%1$s']//..//following-sibling::tr/td[position()=count(//td[text()='%1$s']/preceding-sibling::td)+1]";
    private final Table tblTicketPrice = new Table(By.cssSelector(".MyTable.MedTable"));

    //Methods
    public HashMap<String, String> getTicketPrice() {
        HashMap<String, String> ticketPriceMap = new HashMap<>();
        ticketPriceMap.put("HS", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "HS"));
        ticketPriceMap.put("SS", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "SS"));
        ticketPriceMap.put("SSC", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "SSC"));
        ticketPriceMap.put("HB", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "HB"));
        ticketPriceMap.put("SB", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "SB"));
        ticketPriceMap.put("SBC", this.tblTicketPrice.getCellValueByHeader(dynamicTicketPriceLocator, "SBC"));
        return ticketPriceMap;
    }
}
