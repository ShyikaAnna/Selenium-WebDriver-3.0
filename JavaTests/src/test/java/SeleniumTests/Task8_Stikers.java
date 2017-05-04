package SeleniumTests;

import com.sun.deploy.trace.Trace;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.font.TrueTypeFont;

import static jdk.nashorn.internal.objects.Global.print;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task8_Stikers extends  TestBase {
    private String stiker = "//div[contains(@class,'sticker')]";
    private String compaignProducts = "//a[@href='#campaign-products']";
    private String productInCampaign ="//div[@id='box-campaigns']/div/div";
    private String popularProducts = "//a[@href='#popular-products']";
    private String latestProducts = "//a[@href='#latest-products']";
    private String mainPage = "//img[@src='/litecart/images/slides/1-flying-cart.jpg']";

    public boolean MainPage() {
        By mPage = By.xpath(mainPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mPage));
        return driver.findElement(mPage).isDisplayed();
    }
    public void clickCampaignProducts()
    {
        By CampProducts = By.xpath(compaignProducts);
        driver.findElement(CampProducts).click();
        wait.until(ExpectedConditions.attributeContains(CampProducts, "class", "active"));
    }
    public boolean checkStikerInCampaign(int i)
    {
        By ProductInCamp = By.xpath(String.format(productInCampaign, "" + i));
        WebElement element = driver.findElement(ProductInCamp);
        By Stikers = By.xpath(stiker);
        if (element.findElements(Stikers).size() == 1){
            print("only one stiker for this product ");
        }
        else {
            print("No one stikers for this product ");
        }

        return false;
    }

    @Test
    public void Login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        driver.get("http://localhost/litecart/en/");

    }

}
