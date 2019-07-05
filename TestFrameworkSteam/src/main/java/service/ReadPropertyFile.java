package service;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ReadPropertyFile {

    private static Properties properties;

    static {
        properties = new Properties();
        URL props = ClassLoader.getSystemResource("config.properties");
        try {
            properties.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}