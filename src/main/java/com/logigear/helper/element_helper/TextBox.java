package com.logigear.helper.element_helper;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By locator) {
        super(locator);
    }

    public void enterText(CharSequence text) {
        findElement().sendKeys(text);
    }
}
