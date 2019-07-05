import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SteamBrowsingActionPage;
import pageobject.SteamBrowsingIndiePage;
import pageobject.SteamDownloadingPage;
import pageobject.SteamHomePage;
import service.ReadPropertyFile;

import java.util.concurrent.TimeUnit;

public class SteamTest {

    private static WebDriver driver;

    @BeforeTest()
    public static void setUp() {
        DriverInitializer singleton = DriverInitializer.getInstance();
        driver = singleton.initializeDriver(ReadPropertyFile.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(ReadPropertyFile.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@Test()
    public void downloadSteamAppTest() throws InterruptedException {
        SteamHomePage steamHomePage = new SteamHomePage(driver);
        steamHomePage.getHome();
        Assert.assertTrue(steamHomePage.homePageIsOpened(), "Home page isn't opened");
        steamHomePage.clickInstallSteam();

        SteamDownloadingPage steamDownloadingPage = new SteamDownloadingPage(driver);
        Assert.assertTrue(steamDownloadingPage.downloadingPageIsOpened(), "Downloading page isn't opened");
        steamDownloadingPage.clickInstallSteam();
        Thread.sleep(5000);
    }*/

    @Test
    public void checkHighestDiscountCalculationTest(){
        SteamHomePage steamHomePage = new SteamHomePage(driver);
        //steamHomePage.getHome();
        Assert.assertTrue(steamHomePage.homePageIsOpened(), "Home page isn't opened");
        steamHomePage.setLanguage();
        steamHomePage.selectActionGame();

        SteamBrowsingActionPage steamBrowsingActionPage = new SteamBrowsingActionPage(driver);
        Assert.assertTrue(steamBrowsingActionPage.browsingActionPageIsOpened(), "Browsing Action page isn't opened");
        steamBrowsingActionPage.clickTopSelling();
        Assert.assertTrue(steamBrowsingActionPage.tabTopSellingIsOpened(), "Tab with top selling isn't opened");
        steamBrowsingActionPage.clickTheGameWithTheHighestPrice();

        if(steamBrowsingActionPage.ageCheckerIsOpened()){
            steamBrowsingActionPage.selectAgeFromDropdown();
            steamBrowsingActionPage.selectAgeMonthFromDropdown();
            steamBrowsingActionPage.selectAgeYearFromDropdown();
            steamBrowsingActionPage.confirmDateOfBirth();
        }

        steamBrowsingActionPage.getCurrentNameofGame();
        steamBrowsingActionPage.getCurrentDiscountAndPrice();
        Assert.assertTrue(steamBrowsingActionPage.gameIsOpened(), "The page with selected game wasn't opened");
    }

    /*@Test
    public void checkLowestDiscountCalculationTest(){
        SteamHomePage steamHomePage = new SteamHomePage(driver);
        steamHomePage.getHome();
        Assert.assertTrue(steamHomePage.homePageIsOpened(), "Home page isn't opened");
        steamHomePage.selectIndieGame();

        SteamBrowsingIndiePage steamBrowsingIndiePage = new SteamBrowsingIndiePage(driver);
        Assert.assertTrue(steamBrowsingIndiePage.browsingActionPageIsOpened(), "Browsing Action page isn't opened");
        steamBrowsingIndiePage.clickTopSelling();
        Assert.assertTrue(steamBrowsingIndiePage.tabTopSellingIsOpened(), "Tab with top selling isn't opened");
        steamBrowsingIndiePage.clickTheGameWithTheHighestPrice();
        if(steamBrowsingIndiePage.ageCheckerIsOpened()){
            steamBrowsingIndiePage.selectAgeFromDropdown();
            steamBrowsingIndiePage.selectAgeMonthFromDropdown();
            steamBrowsingIndiePage.selectAgeYearFromDropdown();
            steamBrowsingIndiePage.confirmDateOfBirth();
        }
        Assert.assertTrue(steamBrowsingIndiePage.gameIsOpened(), "The page with selected game wasn't opened");
    }*/

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}