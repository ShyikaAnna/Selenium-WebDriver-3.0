package SeleniumTests;


import OnlineShop.PageInitialization;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BaseTests {
    protected WebDriver driver;
    protected PageInitialization liteCartShop;
   // Assert assert;


    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        liteCartShop = new PageInitialization(driver);
        //softAssert = new SoftAssert();
    }

    @After
    public void afterClass()
    {
        driver.quit();
    }
}
