package com.logigear.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.bothify("email####??@gmail.com");
    }

    public static String getRandomPassword() {
        return faker.regexify("[\\w\\d]{8,64}");
    }

    public static String getRandomPid() {
        return faker.regexify("[0-9]{8,20}");
    }
    
    public static String getDateFromToday(int... plusDays) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime localDateTime;
        if (plusDays.length != 0) {
            localDateTime = LocalDateTime.now().plusDays(plusDays[0]);
        } else {
            localDateTime = LocalDateTime.now();
        }
        return dateTimeFormatter.format(localDateTime);
    }
}
