package SeleniumTests;

import OnlineShop.AdminPanel;
import OnlineShop.Category1Block;
import OnlineShop.EditProductBlock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Logging {
    protected WebDriver driver;
    protected AdminPanel adminPanel;
    protected Category1Block category1Block;
    protected EditProductBlock editProductBlock;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanel = new AdminPanel(driver);
        category1Block = new Category1Block(driver);
        editProductBlock = new EditProductBlock(driver);
    }

    @Test
    public void checkLogs()
    {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        adminPanel.isAdminPanel();

        driver.get(" http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        category1Block.isCategory1Block();
        category1Block.openAllFolders();
        for (int i = 0; i < category1Block.countLinks(); i++)
        {
            category1Block.goToEditProduct(i);
            editProductBlock.isEditProductBlock();
            Assert.assertFalse(editProductBlock.checkLog());
            driver.navigate().back();
            category1Block.isCategory1Block();
        }
    }

    @After
    public void afterClass()
    {
        driver.quit();
    }
}
