import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.YandexAuthorizationPage;
import pageobject.YandexHomePage;
import service.FileService;
import service.ReadPropertyFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexHomePageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ReadPropertyFile readPropertyFile = new ReadPropertyFile();
        Singleton singleton = Singleton.getInstance();
        driver = singleton.initializeDriver(ReadPropertyFile.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws IOException{

        YandexHomePage yandexHomePage = new YandexHomePage(driver);
        YandexAuthorizationPage yandexAuthorizationPage = new YandexAuthorizationPage(driver);

        yandexHomePage.goToHomePage();
        Assert.assertTrue(yandexHomePage.homePageIsOpened(), "Home page isn't opened");
        yandexHomePage.clickLogin();
        yandexAuthorizationPage.enterUsername(ReadPropertyFile.getUsername());
        yandexAuthorizationPage.enterPassword(ReadPropertyFile.getPassword());
        yandexAuthorizationPage.submit();
        Assert.assertTrue(yandexHomePage.userIsLoggedIn(), "User isn't logged in");

        yandexHomePage.setRegion();
        List<WebElement> popularCategory = yandexHomePage.getPopularCategories();
        yandexHomePage.goToRandomCategory();
        yandexHomePage.goToHomePage();
        List<WebElement> allCategories = yandexHomePage.getAllCategories();
        Assert.assertTrue(popularCategory.retainAll(allCategories), "Popular categories are not included in all categories");
        FileService.writeToCsvFileAllCategories(allCategories);
        yandexHomePage.logoutProfile();
        Assert.assertTrue(yandexHomePage.userIsLoggedOut(), "User couldn't be logged out");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
