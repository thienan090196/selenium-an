package com.logigear.helpers;

import com.github.javafaker.Faker;

public class DataHelper {

    private static Faker faker = new Faker();

    public static String getRandomPassword() {
        return faker.regexify("[A-Za-z0-9]{8,64}");
    }
}
