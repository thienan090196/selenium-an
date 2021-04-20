package com.logigear.helper.element_helper;

import com.logigear.helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Element {

    public WebElement getElementById(String id) {
        return Constant.WEB_DRIVER.findElement(By.id(id));
    }

    public WebElement getElementByName(String name) {
        return Constant.WEB_DRIVER.findElement(By.name(name));
    }

    public WebElement getElementByClassname(String className) {
        return Constant.WEB_DRIVER.findElement(By.className(className));
    }

    public WebElement getElementByTagName(String tagName) {
        return Constant.WEB_DRIVER.findElement(By.tagName(tagName));
    }

    public WebElement getElementByLinkText(String linkText) {
        return Constant.WEB_DRIVER.findElement(By.linkText(linkText));
    }

    public WebElement getElementByPartialLinkText(String partialLinkText) {
        return Constant.WEB_DRIVER.findElement(By.partialLinkText(partialLinkText));
    }

    public WebElement getElementByCssSelector(String cssSelector) {
        return Constant.WEB_DRIVER.findElement(By.cssSelector(cssSelector));
    }

    public WebElement getElementByXpath(String xpath) {
        return Constant.WEB_DRIVER.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElementsById(String id) {
        return Constant.WEB_DRIVER.findElements(By.id(id));
    }

    public List<WebElement> getElementsByName(String name) {
        return Constant.WEB_DRIVER.findElements(By.name(name));
    }

    public List<WebElement> getElementsByClassname(String className) {
        return Constant.WEB_DRIVER.findElements(By.className(className));
    }

    public List<WebElement> getElementsByTagName(String tagName) {
        return Constant.WEB_DRIVER.findElements(By.tagName(tagName));
    }

    public List<WebElement> getElementsByLinkText(String linkText) {
        return Constant.WEB_DRIVER.findElements(By.linkText(linkText));
    }

    public List<WebElement> getElementsByPartialLinkText(String partialLinkText) {
        return Constant.WEB_DRIVER.findElements(By.partialLinkText(partialLinkText));
    }

    public List<WebElement> getElementsByCssSelector(String cssSelector) {
        return Constant.WEB_DRIVER.findElements(By.cssSelector(cssSelector));
    }

    public List<WebElement> getElementsByXpath(String xpath) {
        return Constant.WEB_DRIVER.findElements(By.xpath(xpath));
    }
}
