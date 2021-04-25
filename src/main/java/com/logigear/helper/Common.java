package com.logigear.helper;

import com.github.javafaker.Faker;

import java.io.File;

public class Common {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static File readFile(String fileName) {
        File file = new File(Common.getProjectPath() + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static String generateRandomEmailString() {
        Faker faker = new Faker();
        return faker.bothify("email####@gmail.com");
    }

}
