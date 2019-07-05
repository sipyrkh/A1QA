package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class SteamBrowsingActionPage extends PageObject {

    @FindBy(xpath = "//div[@id = 'tab_select_TopSellers']")
    WebElement tabTopSelling;
    @FindBy(xpath = "//div[@class = 'discount_final_price']")
    private List<WebElement> listPrices;
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public SteamBrowsingActionPage(WebDriver driver) {
        super(driver);
    }

    public boolean browsingActionPageIsOpened(){
        return driver.getTitle().equals("Browsing Action");
    }

    public void clickTopSelling(){
        wait.until(ExpectedConditions.visibilityOf(tabTopSelling));
        tabTopSelling.click();
    }

    public boolean tabTopSellingIsOpened(){
        return driver.getCurrentUrl().contains("tab=TopSellers");
    }

    public void clickTheGameWithTheHighestPrice(){

        List<WebElement> listDiscounts = driver.findElements(By.cssSelector(".discount_block.tab_item_discount > .discount_pct"));
        List<WebElement> listDiscountsFinal = new ArrayList<>();

        for(WebElement w : listDiscounts){
            if (w.isDisplayed() && w.isEnabled()){
                listDiscountsFinal.add(w);
            }
        }
        List<Integer> integerList = new ArrayList<>();
        for(WebElement w : listDiscountsFinal){
                int rez = Integer.parseInt(w.getText().substring(0,w.getText().lastIndexOf('%')));
                integerList.add(rez);
        }

        int maxDiscount = Collections.min(integerList);
        int indexOfMaxDiscount = integerList.indexOf(maxDiscount);

        listDiscountsFinal.get(indexOfMaxDiscount).click();

    }

    public boolean gameIsOpened(){

        try {
            driver.findElement(By.xpath("//img[@class = 'package_header']"));
        }catch (NoSuchElementException e){
            return false;
        }

        return true;
    }

    public boolean ageCheckerIsOpened(){

        try {
            driver.findElement(By.xpath("//div[@class = 'agegate_text_container']"));
        }catch (NoSuchElementException e){
            return false;
        }

        return true;
    }

    public void selectAgeFromDropdown(){
        Select selectAge = new Select(driver.findElement(By.xpath("//select[@id = 'ageDay']")));
        selectAge.selectByVisibleText("21");
    }

    public void selectAgeMonthFromDropdown(){
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id = 'ageMonth']")));
        selectMonth.selectByVisibleText("May");
    }

    public void selectAgeYearFromDropdown(){
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id = 'ageYear']")));
        selectYear.selectByVisibleText("1993");
    }

    public void confirmDateOfBirth(){
        WebElement buttonConfirmDateOfBirth = driver.findElement(By.xpath("//a[@class = 'btnv6_blue_hoverfade btn_medium']"));
        buttonConfirmDateOfBirth.click();
    }

    public void getCurrentDiscountAndPrice(){
        WebElement currentDiscount = driver.findElement(By.xpath("//div[@class = 'discount_block game_purchase_discount']"));
    }

    public void getCurrentNameofGame(){
        WebElement currentNameOfGame = driver.findElement(By.cssSelector(".game_area_purchase_game.bundle.ds_no_flags > h1"));
    }

}
