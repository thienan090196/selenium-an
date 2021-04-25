package com.logigear.helper;

import com.logigear.helper.web_driver_helper.DriverManager;
import org.openqa.selenium.WebDriver;

public class Constant {

    public enum DriverType {
        CHROME, FIREFOX, EDGE;
    }

    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/";
    public static final String TEST_DATA_FOLDER_PATH = "/src/test/resources/test-data/";
    public static final String BLANK_STRING = "";
    public static final String SLASH = "/";
    public static final int DEFAULT_SCREEN_WIDTH = 1024;
    public static final int DEFAULT_SCREEN_HEIGHT = 768;
    public static final int WAIT_ELEMENT_TIME = 5;
    public static final int WAIT_IMPLICITLY_TIME = 10;
    public static DriverManager DRIVER_MANAGER;
    public static WebDriver WEB_DRIVER;

}
