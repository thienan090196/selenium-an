package com.logigear.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {

    public Dropdown(By locator) {
        super(locator);
    }

    public void selectDropdownValue(String value) {
        Select select = new Select(findElement());
        select.selectByValue(value);
    }
}
