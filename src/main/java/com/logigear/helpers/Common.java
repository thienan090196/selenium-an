package com.logigear.helper;

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
}
