package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamHomePage extends PageObject {

    @FindBy(xpath = "//div[@class = 'header_installsteam_btn header_installsteam_btn_green']")
    WebElement buttonInstallSteam;
    @FindBy(xpath = "//div[@id = 'genre_tab']")
    WebElement buttonSelectGames;
    @FindBy(xpath = "//a[@class = 'popup_menu_item'][contains(.,'Action')]")
    WebElement buttonAction;
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public SteamHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickInstallSteam(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonInstallSteam));
        buttonInstallSteam.click();
    }

    public boolean homePageIsOpened(){
        return driver.getTitle().equals("Welcome to Steam");
    }

    public void selectGames(){
        wait.until(ExpectedConditions.visibilityOf(buttonSelectGames));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonSelectGames).build().perform();
        actions.moveToElement(buttonAction).build().perform();
        buttonAction.click();
    }

}
