package driverInitializing;

import exception.InvalidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {

    private static DriverInitializer instanceDriver = null;
    private WebDriver driver;

    private DriverInitializer(){}

    public WebDriver initializeDriver(String browser){

        try {
            switch (browser.toLowerCase()){
                case "firefox": WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome": WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default: throw new InvalidBrowserException("Incorrect name of browser!");
            }
        } catch (InvalidBrowserException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public static DriverInitializer getInstance(){
        if(instanceDriver == null){
            instanceDriver = new DriverInitializer();
        }
        return instanceDriver;
    }

}