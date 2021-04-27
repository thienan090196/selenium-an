package com.logigear.helpers.element_helper;

import com.logigear.helpers.Constant;
import com.logigear.helpers.web_driver_helper.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        return DriverManagerFactory.getInstance().getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return DriverManagerFactory.getInstance().getDriver().findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        if (isExisted()) {
            return findElement().getText();
        }
        return Constant.BLANK_STRING;
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public boolean isExisted() {
        return !findElements().isEmpty();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isDisplayed();
    }

    public void disableElement() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerFactory.getInstance().getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'display:none')", findElement());
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void waitForElementExist() {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManagerFactory.getInstance().getDriver(), Constant.WAIT_ELEMENT_TIME);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
