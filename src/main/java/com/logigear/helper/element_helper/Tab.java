package com.logigear.helper.element_helper;

import org.openqa.selenium.By;

public class Tab extends BaseElement {

    public Tab(By locator) {
        super(locator);
    }

    public void click() {
        findElement().click();
    }
}
