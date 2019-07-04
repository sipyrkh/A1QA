package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void gameIsOpened(){

    }

}
