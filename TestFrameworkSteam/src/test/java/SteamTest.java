import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.SteamBrowsingActionPage;
import pageobject.SteamDownloadingPage;
import pageobject.SteamHomePage;
import service.ReadPropertyFile;

import java.util.concurrent.TimeUnit;

public class SteamTest {

    private static WebDriver driver;

    @BeforeClass()
    public static void setUp() {
        ReadPropertyFile readPropertyFile = new ReadPropertyFile();
        Singleton singleton = Singleton.getInstance();
        driver = singleton.initializeDriver(ReadPropertyFile.getBrowser());
        driver.manage().window().maximize();
        driver.get(ReadPropertyFile.getUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@Test()
    public void downloadSteamAppTest(){
        SteamHomePage steamHomePage = new SteamHomePage(driver);
        Assert.assertTrue(steamHomePage.homePageIsOpened(), "Home page isn't opened");
        steamHomePage.clickInstallSteam();

        SteamDownloadingPage steamDownloadingPage = new SteamDownloadingPage(driver);
        Assert.assertTrue(steamDownloadingPage.downloadingPageIsOpened(), "Downloading page isn't opened");
        steamDownloadingPage.clickInstallSteam();

    }*/

    @Test
    public void checkHighestDiscountCalculationTest() throws InterruptedException {
        SteamHomePage steamHomePage = new SteamHomePage(driver);
        Assert.assertTrue(steamHomePage.homePageIsOpened(), "Home page isn't opened");
        steamHomePage.selectGames();

        SteamBrowsingActionPage steamBrowsingActionPage = new SteamBrowsingActionPage(driver);
        Assert.assertTrue(steamBrowsingActionPage.browsingActionPageIsOpened(), "Browsing Action page isn't opened");
        steamBrowsingActionPage.clickTopSelling();
        Assert.assertTrue(steamBrowsingActionPage.tabTopSellingIsOpened(), "Tab with top selling isn't opened");
        steamBrowsingActionPage.clickTheGameWithTheHighestPrice();
        Thread.sleep(5000);
    }

    @Test
    public void checkLowestDiscountCalculationTest(){

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}