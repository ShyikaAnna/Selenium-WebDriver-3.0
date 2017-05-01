package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class FirstTest  extends TestBase {



//    @Before
//    public void Start() {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
//    }

    @Test
    public void MyFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}