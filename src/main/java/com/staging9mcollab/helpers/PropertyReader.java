package com.staging9mcollab.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is a helper class that gives us access to properties
 *
 * @author Zoran Dragovic
 */
public class PropertyReader {

    static private Properties value;

    /**
     * This method returns the value of selected property
     */
    public static String getProperty(String key) throws IOException {
        if (value == null) {
            value = new Properties();
            File file = new File("src/test/resources/properties/stage-9mcollab.properties");
            FileInputStream fileInput = new FileInputStream(file);
            value.load(fileInput);
            fileInput.close();
        }

        return value.getProperty(key);
    }
}