package SeleniumTests;

import OnlineShop.Cart;
import OnlineShop.MyStorepage;
import OnlineShop.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;

public class Task13_Add_Delete_In_Cart {
    protected WebDriver driver;
    protected MyStorepage myStorepage;
    protected Product product;
    protected Cart cart;
    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        myStorepage = new MyStorepage(driver);
        product = new Product(driver);
        cart = new Cart(driver);
        driver.get("http://localhost/litecart");
    }

    @Test
    public void putFirstDuckTest()
    {
        for (int i = 0; i < 3; i++)
        {
            driver.get("http://localhost/litecart");
            myStorepage.isMainPage();
            myStorepage.goToProductBlock();
            product.isProduct();
            product.selectSize();
            int ducksInCart = product.getDucksInCart();
            product.addToCart();
            assertTrue(product.isIncreasingDucks(ducksInCart));
        }
    }

    @Test
    public void deleteFirstDuck()
    {
        product.goToCart();
        cart.isCartBlock();
        int ducksInCart = cart.getDucksInCart();
        cart.deleteOneDuck();
        assertTrue(cart.isDecreasingDucks(ducksInCart));
    }

    @Test
    public void deleteSecondDuck()
    {
        for (int i = 0; i < 2; i++)
        {
            int ducksInCart = cart.getDucksInCart();
            cart.deleteOneDuck();
            assertTrue(cart.isDecreasingDucks(ducksInCart));
        }
    }
    @Test
    public void addToCartDeleteFromCartTest()
    {
        myStorepage.isMainPage();
        myStorepage.goToProductBlock();
        product.isProduct();
        product.selectSize();
        int ducksIn = product.getDucksInCart();
        product.addToCart();
        assertTrue(product.isIncreasingDucks(ducksIn));

        driver.get("http://localhost/litecart");
        myStorepage.clickPopularProducts();
        myStorepage.goToProductBlockPopular();
        product.isProduct();
        product.selectSize();
        ducksIn = product.getDucksInCart();
        product.addToCart();
        product.isIncreasingDucks(ducksIn);
        assertTrue(product.isIncreasingDucks(ducksIn));

        driver.get("http://localhost/litecart");
        myStorepage.clickLatestProducts();
        myStorepage.goToProductBlockLatest();
        product.isProduct();
        product.selectSize();
        ducksIn = product.getDucksInCart();
        product.addToCart();
        product.isIncreasingDucks(ducksIn);
        assertTrue(product.isIncreasingDucks(ducksIn));

        product.goToCart();
        cart.isCartBlock();
        for (int i = 0; i < cart.getNumberOfDuckKind() - 1; i++)
        {
            assertTrue(cart.deleteOneKindDuck());
        }
        assertTrue(cart.deleteLastKindDuck());
    }


    @After
    public void afterClass()
    {
        driver.quit();
    }
}
