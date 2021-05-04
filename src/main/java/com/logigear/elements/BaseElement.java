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
        return DriverHelper.getInstance().getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return DriverHelper.getInstance().getDriver().findElements(locator);
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
        JavascriptExecutor js = (JavascriptExecutor) DriverHelper.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getInstance().getDriver(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForElementVisible() {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getInstance().getDriver(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(findElement()));
    }
}
