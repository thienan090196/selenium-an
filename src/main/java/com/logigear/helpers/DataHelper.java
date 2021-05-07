package com.logigear.helpers;

import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    public static String getRandomEmail() {
        return new Faker().bothify("email####@gmail.com");
    }

    public static String getRandomPassword() {
        return new Faker().regexify("[A-Za-z0-9]{8,64}");
    }

    public static String getRandomPid() {
        return new Faker().regexify("[0-9]{8,20}");
    }

    public static String getDateFromToday(int days) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
        return dateTimeFormatter.format(LocalDateTime.now().plusDays(days));
    }
}
