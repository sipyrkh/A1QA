package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    private static Properties properties = new Properties();
    private static String propertiesFilePath = System.getProperty("user.dir") + "/config.properties";

    public ReadPropertyFile() {
        try {
            InputStream inputStream = new FileInputStream(propertiesFilePath);
            properties.load(inputStream);
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

    public static String getUrl(){
        return properties.getProperty("url");
    }

    static String getFilename(){
        return properties.getProperty("filename");
    }

    static String getPath(){
        return properties.getProperty("pathname");
    }

    public static String getBrowser(){
        return properties.getProperty("browser");
    }
}
