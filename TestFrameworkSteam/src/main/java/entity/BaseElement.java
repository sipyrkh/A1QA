package entity;

import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    private static final String LINK = "link=";
    private static final String ID = "id=";
    private static final String XPATH = "xpath=";

    private String name;
    private By locator;
    private WebElement element;

    public WebElement getElement() {
        return element;
    }

    public void setElement(final WebElement elementToSet) {
        element = elementToSet;
    }

    protected BaseElement(final By loc) {
        locator = loc;
    }

    protected BaseElement(final By loc, final String nameOf) {
        locator = loc;
        name = nameOf;

    }

    protected BaseElement(String stringLocator, final String nameOfElement) {
        String clearLoc = null;
        if (stringLocator.contains(XPATH)) {
            clearLoc = stringLocator.replaceFirst(XPATH, "");
            locator = By.cssSelector(clearLoc);
            name = nameOfElement;
        } else if (stringLocator.contains(ID)) {
            clearLoc = stringLocator.replaceFirst(ID, "");
            locator = By.id(clearLoc);
            name = nameOfElement;
        } else if (stringLocator.contains(LINK)) {
            clearLoc = stringLocator.replaceFirst(LINK, "");
            locator = By.linkText(clearLoc);
            name = nameOfElement;
        } else {
            Log.fatal("UNKNOWN LOCATOR's TYPE. Change to 'By'");
        }
    }

    public By getLocator() {
        return locator;
    }

    public void click() {
        element.click();
    }

    public String getText() {
        return element.getText();
    }
}



