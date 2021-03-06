package com.logigear.helpers;

import com.logigear.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void createDriver(DriverType driverType) {
        WebDriver webDriver;
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(Constant.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
        driver.set(webDriver);
    }

    public static void setWindowSize(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static String getTitle() {
        return getDriver().getTitle().trim();
    }

    public static void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}
