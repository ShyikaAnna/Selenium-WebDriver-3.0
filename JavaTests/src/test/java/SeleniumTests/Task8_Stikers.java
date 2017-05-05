package SeleniumTests;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task8_Stikers extends  TestBase {
    private String stiker = "//div[contains(@class,'sticker')]";
    private String compaignProducts = "//a[@href='#campaign-products']";
    private String productInCampaign ="//div[@id='box-campaigns']/div/div";
    private String popularProducts = "//a[@href='#popular-products']";
    private String productInPopular = "//*[@id='box-most-popular']/div/div";
    private String latestProducts = "//a[@href='#latest-products']";
    private String mainPage = "//img[@src='/litecart/images/slides/1-flying-cart.jpg']";

    public boolean MainPage() {
        By mPage = By.xpath(mainPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mPage));
        return driver.findElement(mPage).isDisplayed();
    }
    public void goToCampaignProducts()
    {
        By CampProducts = By.xpath(compaignProducts);
        driver.findElement(CampProducts).click();
        wait.until(ExpectedConditions.attributeContains(CampProducts, "class", "active"));
    }
    public int QuantityProductsInCampaign()
    {
        By lProductsInCampaign = By.xpath(productInCampaign);
        return driver.findElements(lProductsInCampaign).size();
    }
    public boolean checkStikerInCampaign(int i)
    {
        By ProductInCamp = By.xpath(String.format(productInCampaign, "" + i));
        WebElement product = driver.findElement(ProductInCamp);
        By Stikers = By.xpath(stiker);
        return (product.findElements(Stikers).size() == 1);
    }

    /*public boolean checkStikerInPopular(int j)
    {
        By lProductInCampaignTemplate = By.xpath(String.format(productInCampaignTemplate, "" + j));
        WebElement element = driver.findElement(lProductInCampaignTemplate);
        By Stiker = By.xpath(stiker);
        return (element.findElements(Stiker).size() == 1);
    }*/

    @Test
    public void LoginAndCheckStikers() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        driver.get("http://localhost/litecart/en/");
        driver.get(goToCampaignProducts());
        int QuantityProductsInCampaign = QuantityProductsInCampaign();

        for (int i = 1; i <= QuantityProductsInCampaign; i++)
        {
            assertTrue(checkStikerInCampaign(i));
        }

    }

}
