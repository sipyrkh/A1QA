package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexAuthorizationPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement fieldUsername;
    @FindBy(id = "passp-field-passwd")
    private WebElement fieldPassword;
    @FindBy(xpath = "//div[@class = 'passp-button passp-sign-in-button']")
    private WebElement buttonEntering;
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public YandexAuthorizationPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        this.wait.until(ExpectedConditions.elementToBeClickable(fieldUsername));
        this.fieldUsername.clear();
        this.fieldUsername.sendKeys(username);
        this.wait.until(ExpectedConditions.visibilityOf(buttonEntering));
        this.buttonEntering.click();
    }

    public void enterPassword(String password){
        this.wait.until(ExpectedConditions.elementToBeClickable(fieldPassword));
        this.fieldPassword.clear();
        this.fieldPassword.sendKeys(password);
    }

    public YandexHomePage submit(){
        this.wait.until(ExpectedConditions.elementToBeClickable(fieldPassword));
        this.fieldPassword.submit();
        return new YandexHomePage(driver);
    }

}
