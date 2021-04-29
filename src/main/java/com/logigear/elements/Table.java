package com.logigear.elements;

import org.openqa.selenium.By;

public class Table extends BaseElement {

    public Table(By locator) {
        super(locator);
    }

    public String getCellValueByColumnTitle(String childLocator, String title) {
        return findElement().findElement(By.xpath(String.format(childLocator, title))).getText();
    }
}
