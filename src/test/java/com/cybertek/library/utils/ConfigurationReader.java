package com.cybertek.library.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static final Properties properties = new Properties();

    static {

        try {

            FileInputStream file =  new FileInputStream("configuation.properties");

            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("Properties file is not a file");

        }
    }

    public static String getProperties(String key){

        return properties.getProperty(key);

    }
}
