import exception.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Singleton {

    private static Singleton instanceDriver = null;
    private WebDriver driver;

    private Singleton(){}

    WebDriver initializeDriver(String browser){
        try {
            switch (browser){
                case "firefox": driver = new FirefoxDriver(); break;
                case "chrome": driver = new ChromeDriver(); break;
                default: throw new InvalidBrowserException("Incorrect name of browser!");
            }
        } catch (InvalidBrowserException e) {
            e.printStackTrace();
        }

        return driver;
    }

    static Singleton getInstance(){
        if(instanceDriver == null){
            instanceDriver = new Singleton();
        }
        return instanceDriver;
    }

}
