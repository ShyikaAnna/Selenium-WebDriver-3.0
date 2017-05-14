package OnlineShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Product(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    private String pageFlag = "//h1[@class='title']";
    private String nameOfProduct = "//h1[@class='title']";
    private String regularPrice = "//del[@class='regular-price']";
    private String campaignPrice = "//strong[@class='campaign-price']";
    private String packageSize = "//select[@name='options[Size]']";
    private String quantityDucksInCart = "//div[@id='cart']//span[@class='quantity']";
    private String btnAddCartProduct = "//button[@name='add_cart_product']";
    private String goToCart = "//div[@id='cart']";

    public boolean isProduct()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }
    public String getProductName()
    {
        By NameOfProduct = By.xpath(nameOfProduct);
        String NameOfProducts = driver.findElement(NameOfProduct).getText();
        System.out.println(NameOfProducts);
        return NameOfProducts;
    }

}
