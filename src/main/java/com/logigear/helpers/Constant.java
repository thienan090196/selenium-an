package com.logigear.helpers;

import java.util.HashMap;

public class Constant {

    public enum DRIVER_TYPE {
        CHROME, FIREFOX, EDGE;
    }

    public static final String RAILWAY_URL = "http://www.railway2.somee.com/";
    public static final String USERNAME = "testrailway01@gmail.com";
    public static final String PASSWORD = "abc@12345";
    public static final String TEST_DATA_FOLDER_PATH = "src/test/resources/test-data/";
    public static final String BLANK_STRING = "";
    public static final int DEFAULT_SCREEN_WIDTH = 1024;
    public static final int DEFAULT_SCREEN_HEIGHT = 768;
    public static final int EXPLICIT_WAIT_TIME = 5;
    public static final int IMPLICITLY_WAIT_TIME = 10;
    public static final String DATE_FORMAT = "M/d/yyyy";

    public static final String ID_COLUMN_TITLE = "No.";
    public static final String DEPART_STATION_COLUMN_TITLE = "Depart Station";
    public static final String ARRIVE_STATION_COLUMN_TITLE = "Arrive Station";
    public static final String SEAT_TYPE_COLUMN_TITLE = "Seat Type";
    public static final String DEPART_DATE_COLUMN_TITLE = "Depart Date";
    public static final String BOOK_DATE_COLUMN_TITLE = "Book Date";
    public static final String EXPIRED_DATE_COLUMN_TITLE = "Expired Date";
    public static final String STATUS_COLUMN_TITLE = "Status";
    public static final String AMOUNT_COLUMN_TITLE = "Amount";
    public static final String TOTAL_COLUMN_TITLE = "Total Price";












    //Ticket data
    public static final String departStation = "Phan Thiết";
    public static final String arriveStation = "Đà Nẵng";
    public static final String seatType = "Hard bed";
    public static final int pricePerOneTicket = 340000;
}
