package com.logigear.elements;

import com.logigear.helpers.Constant;
import com.logigear.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {

    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return DriverHelper.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return DriverHelper.getDriver().findElements(locator);
    }

    public int getElementCount() {
        return findElements().size();
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) DriverHelper.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void waitForElementInVisible() {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
