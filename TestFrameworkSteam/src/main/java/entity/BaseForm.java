package entity;

import driverInitializing.DriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseForm{

    protected By titleLocator;
    protected String title;
    protected String name;

    protected BaseForm(final By locator, final String formTitle) {
        init(locator, formTitle);
    }

    protected String formatLogMsg(final String message) {
        return message;
    }

    private void init(final By locator, final String formTitle) {
        titleLocator = locator;
        title = formTitle;
    }

    public List<WebElement> findElementsByXpath(String xpathString){
        List<WebElement> resultsList = DriverInitializer.getInstance().initializeDriver("broser").findElements(By.xpath(xpathString));
        return resultsList;
    }
}
