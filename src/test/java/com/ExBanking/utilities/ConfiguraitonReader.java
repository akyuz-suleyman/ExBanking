package com.ExBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfiguraitonReader {
    private static Properties properties;

    static{

        try {

            String path="configuration.properties";
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        }catch (Exception e){
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }



}
