package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamDownloadingPage extends PageObject {

    @FindBy(xpath = "//div[@class = 'about_install linux ']")
    WebElement buttonInstallSteam;
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public SteamDownloadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickInstallSteam(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInstallSteam));
        buttonInstallSteam.click();
    }

    public boolean downloadingPageIsOpened(){
        return driver.getTitle().equals("Steam, The Ultimate Online Game Platform");
    }

}
