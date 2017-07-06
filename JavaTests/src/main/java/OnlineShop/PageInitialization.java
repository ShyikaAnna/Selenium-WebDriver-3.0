package OnlineShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageInitialization {
    public WebDriver driver;
    public MyStorepage myStorepage;
    public Product product;
    public Cart cart;
    int ducksIn;

    public PageInitialization(WebDriver driver) {
        this.driver = driver;
        myStorepage = initElements(new MyStorepage(this));
        product = initElements(new Product(this));
        cart = initElements(new Cart(this));
    }

    /**
     * Метод инициализирующий страницы (block)
     *
     * @param block
     */
    private <T extends Base> T initElements(T block) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), block);

        return block;
    }

    /**
     * @return the driver
     */
    public WebDriver getWebDriver() {
        return driver;
    }


    public void addDuckFromProductBlockToCart()
    {
        goToMainPage();
        myStorepage.goToProductBlock();
        addOneDuck();
    }

    public void addDuckFromPopularBlockToCart()
    {
        goToMainPage();
        myStorepage.clickPopularProducts();
        myStorepage.goToProductBlockPopular();
        addOneDuck();
    }

    public void addDuckFromLatestBlockToCart()
    {
        goToMainPage();
        myStorepage.clickLatestProducts();
        myStorepage.goToProductBlockLatest();
        addOneDuck();
    }

    private void goToMainPage()
    {
        driver.get("http://localhost/litecart");
        myStorepage.isMainPage();
    }

    private void addOneDuck()
    {
        product.isProduct();
        product.selectSize();
        ducksIn = product.getDucksInCart();
        product.addToCart();
    }

    public boolean checkIncreasingDucksInCart()
    {
        return product.isIncreasingDucks(ducksIn);
    }

    public boolean deleteOneKindDuck()
    {
        return cart.deleteOneKindDuck();
    }

    public void goToCart()
    {
        product.goToCart();
        cart.isCartBlock();
    }

    public int getNumberOfDuckKind()
    {
        return cart.getNumberOfDuckKind();
    }

    public boolean deleteLastKindDuck()
    {
        return cart.deleteLastKindDuck();
    }
}
