package SeleniumTests;


import OnlineShop.MyStorepage;
import OnlineShop.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task10_ProductPage {
    protected WebDriver driver;
    protected MyStorepage myStorepage;
    protected Product product;
    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @Test
    public void checkTextTest()
    {
        String textOnMainPage = myStorepage.getProductText();
        myStorepage.goToProductBlock();
        product.isProduct();
        Assert.assertEquals(product.getProductName(), textOnMainPage);
    }
}
