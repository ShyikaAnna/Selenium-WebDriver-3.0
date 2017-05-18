package SeleniumTests;

import OnlineShop.MyStorepage;
import OnlineShop.Product;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task10_ProductPage {
    WebDriver driver;
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
        driver.get("http://localhost/litecart");
        //myStorepage.isMainPage();
    }
    @Test
    public void checkTextTest()
    {
        myStorepage = new MyStorepage(driver);
        String textOnMainPage = myStorepage.getProductText();
        myStorepage.goToProductBlock();
        product = new Product(driver);
        product.isProduct();
        Assert.assertEquals(product.getProductName(), textOnMainPage);
    }
    @Test
    public void checkRegularPrice()
    {
        String regularPriceOnMainPage = myStorepage.getRegularPrice();
        myStorepage.goToProductBlock();
        product.isProduct();
        Assert.assertEquals(product.getRegularPrice(), regularPriceOnMainPage);
    }
    @Test
    public void checkCampaignPrice()
    {
        String campaignPriceOnMainPage = myStorepage.getCampaignPrice();
        myStorepage.goToProductBlock();
        product.isProduct();
        Assert.assertEquals(product.getCampaignPrice(), campaignPriceOnMainPage);
    }
    @Test
    public void checkRegularPriceColorOnMainPage()
    {
        Assert.assertTrue(myStorepage.checkRegularPriceColor());
    }
    @Test
    public void checkRegularPriceColorOnProductBlock()
    {
        myStorepage.goToProductBlock();
        Assert.assertTrue(product.checkRegularPriceColor());
    }
    @Test
    public void checkCampaignPriceColorOnMainPage()
    {
        Assert.assertTrue(myStorepage.checkCampaignPriceColor());
    }

    @Test
    public void checkCampaignPriceColorOnProductBlock()
    {
        myStorepage.goToProductBlock();
        Assert.assertTrue(product.checkCampaignPriceColor());
    }
    @Test
    public void checkBoldCampaignPriceOnMainPage()
    {
        Assert.assertTrue(myStorepage.checkBoldCampaignPrice());
    }

    @Test
    public void checkBoldCampaignPriceOnProductBlock()
    {
        myStorepage.goToProductBlock();
        Assert.assertTrue(product.checkBoldCampaignPrice());
    }
    @Test
    public void compareCampaignAndRegularPricesOnMainPage()
    {
        Assert.assertTrue(myStorepage.compareCampaignAndRegularPrices());
    }
    @After
    public void afterClass()
    {
        driver.quit();
    }
}
