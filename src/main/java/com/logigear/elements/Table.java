package com.logigear.elements;

import org.openqa.selenium.By;

public class Table extends BaseElement {

    public Table(By locator) {
        super(locator);
    }

    public String getCellValueByHeader(String childLocator, String headerTitle) {
        return findElement().findElement(By.xpath(String.format(childLocator, headerTitle))).getText();
    }
}
