package OnlineShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStorepage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MyStorepage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    private String stiker = "//div[contains(@class,'sticker')]";
    private String compaignProducts = "//*[@id='content']/ul/li[1]/a";
    private String productInCampaign ="//div[@id='box-campaigns']//div[@class='product column shadow hover-light']";
    private String ProductInCampaignLink=  "//div[@id='box-campaigns']/div/div";
    private String popularProducts = "//a[@href='#popular-products']";
    private String productInPopular = "//*[@id='box-most-popular']/div/div";
    private String latestProducts = "//a[@href='#latest-products']";
    private String mainPage = "//img[@src='/litecart/images/slides/1-flying-cart.jpg']";
    private String nameOfProduct = "//h1[@class='title']";
    private String viewOfProduct = "//div[@id='view-full-page']/a";

    public boolean MainPage() {
        By mPage = By.xpath(mainPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mPage));
        return driver.findElement(mPage).isDisplayed();
    }
    public void goToCampaignProducts()
    {
        By CampProducts = By.xpath(compaignProducts);
        driver.findElement(CampProducts).click();
       // wait.until(ExpectedConditions.attributeContains(CampProducts, "class", "active"));
    }
    public int QuantityProductsInCampaign()
    {
        By lProductsInCampaign = By.xpath(productInCampaign);
        return driver.findElements(lProductsInCampaign).size();
    }
    public boolean checkStikerInCampaign(int k)
    {
        By ProductInCamp = By.xpath(String.format(ProductInCampaignLink, "" + k));
        WebElement product = driver.findElement(ProductInCamp);
        By Stikers = By.xpath(stiker);
        return (product.findElements(Stikers).size() == 1);
    }
    public String getProductText()
    {
        goToCampaignProducts();
        By lNameOfProduct = By.xpath(nameOfProduct);
        String sNameOfProduct = driver.findElement(lNameOfProduct).getText();
        System.out.println(sNameOfProduct);
        return sNameOfProduct;
    }
    public void goToProductBlock()
    {
        By lNameOfProduct = By.xpath(nameOfProduct);
        driver.findElement(lNameOfProduct).click();
        By lViewOfProduct = By.xpath(viewOfProduct);
        String driverName = driver.getClass().getSimpleName();
        System.out.println(driverName);
        if (driverName.equals("FirefoxDriver"))
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(lViewOfProduct));
            }
            catch (Exception e)
            {
            }
        }
        if (driver.getCurrentUrl().equals("http://localhost/litecart/en/"))
        {
            driver.findElement(lViewOfProduct).click();
            wait.until(ExpectedConditions.urlContains("duck"));
        }
    }
}
