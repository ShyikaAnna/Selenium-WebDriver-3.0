package SeleniumTests;

import OnlineShop.AdminPanel;
import OnlineShop.Countries;
import OnlineShop.EditCountriesBlock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Task14New_Window {
    protected WebDriver driver;
    protected AdminPanel adminPanelLogin;
    protected AdminPanel adminPanel;
    protected EditCountriesBlock editCountriesBlock;
    protected Countries countries;
    protected WebDriverWait wait;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanel(driver);
        adminPanel = new AdminPanel(driver);
        editCountriesBlock = new EditCountriesBlock(driver);
        countries = new Countries(driver);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("sidebar")));
    }

    @Test
    public void checkWindows()
    {
//        Assert Assert = new Assert();
//        driver.get("http://localhost/litecart/admin/");
//        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("remember_me")).click();
//        driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("sidebar")));
        adminPanel.isAdminPanel();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countries.isCountryTab();
        countries.goToSomeCountry();
        editCountriesBlock.isEditCountriesBlock();
        for (int i = 0; i < editCountriesBlock.countLinks(); i++)
        {
            Assert.assertTrue(editCountriesBlock.checkWindow(i));
        }
//        Assert.assertAll();
    }

    @After
    public void afterClass()
    {
        driver.quit();
    }
}
