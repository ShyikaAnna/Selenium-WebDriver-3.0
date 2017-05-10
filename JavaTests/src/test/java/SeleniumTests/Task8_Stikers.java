package SeleniumTests;

import OnlineShop.MyStorepage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
public class Task8_Stikers extends  TestBase {
    protected WebDriver driver;
    protected MyStorepage myStorepage;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
       // ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        //myStorepage = new MyStorepage(driver);


    }


    @Test
    public void LoginAndCheckStikers() {
        myStorepage = new MyStorepage(driver);
        driver.get("http://localhost/litecart/en/");
        myStorepage.goToCampaignProducts();
        int QuantityProductsInCampaign = myStorepage.QuantityProductsInCampaign();

        for (int i = 1; i <= QuantityProductsInCampaign; i++)
        {
            assertTrue(myStorepage.checkStikerInCampaign(i));
        }

    }
    @After
    public void afterClass()
    {
        driver.quit();
    }
}
