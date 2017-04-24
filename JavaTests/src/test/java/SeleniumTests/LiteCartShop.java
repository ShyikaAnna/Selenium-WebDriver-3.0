package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiteCartShop extends TestBase {

    @Before
     public void Start() {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
        }

    @Test
        public void MyFirstTest() {
            driver.get("http://localhost/litecart/admin/");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("remember_me")).click();
            driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("sidebar")));
        }

    @After
        public void stop() {
            driver.quit();
            driver = null;
        }
}
