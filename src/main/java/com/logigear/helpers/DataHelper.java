package com.logigear.helpers;

import com.github.javafaker.Faker;

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
}
