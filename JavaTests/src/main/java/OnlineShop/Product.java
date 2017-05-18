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
    private String compaignPrice ="//strong[@class='campaign-price']";
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
    public String getRegularPrice()
    {
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getText();
        System.out.println(sRegularPrice);
        return sRegularPrice;
    }
    public String getCampaignPrice()
    {
        By CompaignPrice1 = By.xpath(compaignPrice);
        String CompaignPrice = driver.findElement(CompaignPrice1).getText();
        System.out.println(CompaignPrice);
        return CompaignPrice;
    }
    public boolean checkRegularPriceColor()
    {
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getCssValue("color");
        sRegularPrice = sRegularPrice.substring((sRegularPrice.indexOf("(") + 1), sRegularPrice.lastIndexOf(")"));
        System.out.println(sRegularPrice);
        String[] strColor = sRegularPrice.split(",");
        if (strColor[0].equals(strColor[1]) || strColor[1].equals(strColor[2]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkCampaignPriceColor()
    {
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getCssValue("color");
        sCampaignPrice = sCampaignPrice.substring((sCampaignPrice.indexOf("(") + 1), sCampaignPrice.lastIndexOf(")"));
        System.out.println(sCampaignPrice);
        String[] strColor = sCampaignPrice.split(",");
        if (Integer.parseInt(strColor[0]) != 0 || strColor[1].equals("0") || strColor[2].equals("0"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkBoldCampaignPrice()
    {
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getTagName();
        System.out.println(sCampaignPrice);
        if (sCampaignPrice.equals("b") || sCampaignPrice.equals("strong"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
