package com.logigear.elements;

import com.logigear.helpers.Constant;
import com.logigear.helpers.web_driver_helper.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return DriverManagerFactory.getInstance().getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return DriverManagerFactory.getInstance().getDriver().findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        try {
            return findElement().getText();
        } catch (NoSuchElementException e) {
            return Constant.BLANK_STRING;
        }
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled() {
        try {
            return findElement().isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSelected() {
        try {
            return findElement().isSelected();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }
}
