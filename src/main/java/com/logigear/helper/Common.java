package com.logigear.helper;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Common {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static String getMessageValue(String key) {
        String result;
        try (InputStream inputStream = new FileInputStream(Common.getProjectPath() + Constant.TEST_RESOURCES_PATH + "message.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            result = properties.getProperty(key);
        } catch (Exception e) {
            return "File not found!";
        }
        return result;
    }

    public static String getTestDataValue(String key) {
        String result;
        try (InputStream inputStream = new FileInputStream(Common.getProjectPath() + Constant.TEST_RESOURCES_PATH + "test-data.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            result = properties.getProperty(key);
        } catch (Exception e) {
            return "File not found!";
        }
        return result;
    }

    public static File readFile(String fileName) {
        File file = new File(Common.getProjectPath() + Constant.TEST_RESOURCES_PATH + fileName);
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
