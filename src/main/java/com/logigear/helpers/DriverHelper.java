package com.logigear.helpers;

import com.logigear.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static final DriverHelper instance = new DriverHelper();

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverHelper() {

    }

    public static DriverHelper getInstance() {
        return instance;
    }

    public static void navigateToUrl(String url) {
        getInstance().getDriver().get(url);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void createDriver(DriverType driverType) {
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
                webDriver = new EdgeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(Constant.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
        driver.set(webDriver);
    }

    public static void setWindowSize(int width, int height) {
        getInstance().getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void maximizeWindow() {
        getInstance().getDriver().manage().window().maximize();
    }

    public void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

    public static void acceptAlert() {
        getInstance().getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        getInstance().getDriver().switchTo().alert().dismiss();
    }

    public static void sendTextToAlert(String text) {
        getInstance().getDriver().switchTo().alert().sendKeys(text);
    }

    public static String getAlertText() {
        return getInstance().getDriver().switchTo().alert().getText();
    }
}
