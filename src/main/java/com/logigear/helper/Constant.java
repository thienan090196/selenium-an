package com.logigear.helper;

import com.logigear.helper.web_driver_helper.DriverManager;
import org.openqa.selenium.WebDriver;

public class Constant {

    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/";
    public static final String EMAIL = "testrailway01@gmail.com";
    public static final String PASSWORD = "abc@1234";
    public static final String BLANK_STRING = "";
    public static final String PREFIX_WELCOME_STRING = "Welcome ";
    public static final String LOGIN_GENERAL_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
    public static final String LOGIN_BLANK_EMAIL_ERROR_MESSAGE = "You must specify a username.";
    public static final String LOGIN_BLANK_PASSWORD_ERROR_MESSAGE = "You must specify a password.";
    public static DriverManager DRIVER_MANAGER;
    public static WebDriver WEB_DRIVER;

}
