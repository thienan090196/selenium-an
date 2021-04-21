package com.logigear.helper.element_helper;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return Constant.WEB_DRIVER.findElement(locator);
    }

    public List<WebElement> findElements() {
        return Constant.WEB_DRIVER.findElements(locator);
    }
}
