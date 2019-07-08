package element;

import driverInitializing.DriverInitializer;
import entity.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ReadPropertyFile;

public class Button extends BaseElement {

    protected Button(By loc) {
        super(loc);
    }

    protected Button(By loc, String nameOf) {
        super(loc, nameOf);
    }

    public Button(String stringLocator, String nameOfElement) {
        super(stringLocator, nameOfElement);
    }

    public static void clickAndWait(String locatorOfElement, String nameOfElement, int waitOfElement){
        WebDriver driver = DriverInitializer.getInstance().initializeDriver(ReadPropertyFile.getProperty("browser"));
        WebDriverWait wait = new WebDriverWait(driver, waitOfElement);
    }

}
