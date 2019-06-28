package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    private static Properties properties = new Properties();
    public static String propertiesFilePath = "/home/ITRANSITION.CORP/a4.zayats/IdeaProjects/SeleniumWebdriver/config.properties";

    public ReadPropertyFile() {
        try {
            InputStream inputStream = new FileInputStream(propertiesFilePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUsername(){
        return properties.getProperty("username");
    }

    public static String getPassword(){
        return properties.getProperty("password");
    }

    public static String getFilename(){
        return properties.getProperty("filename");
    }

    public static String getPath(){
        return properties.getProperty("pathname");
    }

    public static String getBrowser(){
        return properties.getProperty("browser");
    }
}
