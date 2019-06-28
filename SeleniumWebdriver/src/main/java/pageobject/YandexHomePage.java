package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class YandexHomePage extends PageObject {

    @FindBy(xpath = "//div[@class='n-w-tab n-w-tab_type_navigation-menu']")
    private List<WebElement> popularCategories;
    @FindBy(xpath = "//div[@class = 'n-w-tabs__tabs-column']")
    private List<WebElement> allCategories;
    @FindBy(xpath = "//a[@class = 'link user user__logout i-bem user_js_inited']")
    private WebElement buttonLogout;
    @FindBy(xpath = "//div[@class = 'n-w-tab__control-hamburger']")
    private WebElement buttonHamburger;
    @FindBy(xpath = "//div[@class = 'header2-nav__user']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//div[@class = 'notifier__icon notifier__bell']")
    private WebElement userIconLoggedIn;
    @FindBy(xpath = "//a[@class = 'logo logo_type_link logo_part_market']")
    private WebElement homePageLogo;
    @FindBy(xpath = "//div[@class = 'n-region-notification__actions-cell']")
    private WebElement buttonSetRegion;
    private List<WebElement> popularCategoriesFinal = new ArrayList<>();
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public YandexHomePage(WebDriver driver){
        super(driver);
    }

    public boolean userIsLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(userIconLoggedIn));
        return userIconLoggedIn.isDisplayed();
    }

    public boolean userIsLoggedOut(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        return buttonLogin.isDisplayed();
    }

    public boolean homePageIsOpened(){
        return homePageLogo.isDisplayed();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        buttonLogin.click();
        Set<String> handle= driver.getWindowHandles();
        List<String> ex = new ArrayList<>(handle);
        driver.switchTo().window(ex.get(0));

    }

    public void setRegion(){
        wait.until(ExpectedConditions.visibilityOf(buttonSetRegion));
        buttonSetRegion.click();
    }

    public List<WebElement> getPopularCategories(){
        for(WebElement c: popularCategories){
            if(!c.getText().equals("")){
                popularCategoriesFinal.add(c);
            }
        }
        return popularCategoriesFinal;
    }

    public void goToRandomCategory(){
        Collections.shuffle(popularCategoriesFinal);
        Actions actions = new Actions(driver);
        actions.moveToElement(popularCategoriesFinal.get(1)).click().perform();
    }

    public void goToHomePage(){
        driver.get("https://market.yandex.ru/");
    }

    public List<WebElement> getAllCategories(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonHamburger));
        buttonHamburger.click();
        return allCategories;
    }

    public void logoutProfile(){
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement webElement = fluentWait.until(driver -> buttonHamburger);
        webElement.click();
        WebElement logout = driver.findElement(By.cssSelector("span[class = 'user__icon user__icon_loaded_yes']"));
        wait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogout));
        buttonLogout.click();
    }

}
