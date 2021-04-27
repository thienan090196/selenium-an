package com.logigear.helpers;

import java.io.File;

public class Common {

    public static File readFile(String fileName) {
        String path = new File(fileName).getAbsolutePath();
        return new File(path);
    }
}
