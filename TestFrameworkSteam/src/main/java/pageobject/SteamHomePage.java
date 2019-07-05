package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ReadPropertyFile;

public class SteamHomePage extends PageObject {

    @FindBy(xpath = "//div[@class = 'header_installsteam_btn header_installsteam_btn_green']")
    WebElement buttonInstallSteam;
    @FindBy(xpath = "//div[@id = 'genre_tab']")
    WebElement buttonSelectGame;
    @FindBy(css = "#genre_flyout > div:nth-child(1) > a:nth-child(9)")
    WebElement buttonActionGame;
    @FindBy(css = "#genre_flyout > div:nth-child(1) > a:nth-child(12)")
    WebElement buttonIndieGame;
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

    public void getHome(){
        driver.get("https://store.steampowered.com/");
    }

    public void selectActionGame(){
        wait.until(ExpectedConditions.visibilityOf(buttonSelectGame));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonSelectGame).build().perform();
        actions.moveToElement(buttonActionGame).build().perform();
        wait.until(ExpectedConditions.visibilityOf(buttonActionGame));
        actions.moveToElement(buttonActionGame).click().perform();
    }

    public void selectIndieGame(){
        wait.until(ExpectedConditions.visibilityOf(buttonSelectGame));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonSelectGame).build().perform();
        actions.moveToElement(buttonIndieGame).build().perform();
        buttonIndieGame.click();
    }

    public void setLanguage(){
        WebElement languageDropdown = driver.findElement(By.xpath("//span[@id = 'language_pulldown']"));
        WebElement rusLanguage = driver.findElement(By.xpath("//a[contains(text(), 'Русский (Russian)')]"));
        String  strCheckCurrentLanguage = driver.findElement(By.xpath("//a[@class = 'menuitem supernav']")).getText();

        if(ReadPropertyFile.getProperty("lang").equals("rus") && !strCheckCurrentLanguage.matches("\\w")){
            Actions actions = new Actions(driver);
            actions.moveToElement(languageDropdown).click().perform();
            actions.moveToElement(rusLanguage).click().perform();
        }
    }
}
