package SeleniumTests;

import OnlineShop.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task12_ProductAdding {
    protected WebDriver driver;
    protected AdminPanel adminPanel;
    protected Catalog catalog;
    protected CatalogInformTab catalogInformTab;
    protected CatalogPricesTab catalogPricesTab;
    private ProductAttributes productAttributes;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        adminPanel = new AdminPanel(driver);
        catalog = new Catalog(driver);
        catalogInformTab = new CatalogInformTab(driver);
        catalogPricesTab = new CatalogPricesTab(driver);
        String[] massive = {"[Root]", "Rubber Ducks"};
        productAttributes = new ProductAttributes(true, massive, "Root", "Unisex", "2017-05-05", "2018-05-05", "code", "Ducks Family", "DF00543",
                "GTIN00543", "TARIC00543", "30", "pcs", "0.3", "kg", "20", "20", "30", "cm", "3-5 days", "Sold out", "ducks.jpg",
                "ACME Corp.", "-- Select --", "Duck", "Duck", "Ducks famely", "Instructions", "Ducks Family", "Buy duck",
                "30", "US Dollars", "-- Select --", "30", "33");
        System.out.println(productAttributes.toString());
    }
    @Test
    public void addingOfProduct()
    {
        adminPanel.goToCatalog();
        adminPanel.pressAddNewProduct();
        catalog.isCatalog();
        catalog.fillStatus(productAttributes.isStatus());
        catalog.fillDefaultCategory(productAttributes.getDefaultCategory());
        catalog.fillProductGroups(productAttributes.getProductGroups());
        catalog.fillDateValidFrom(productAttributes.getDateValidFrom());
        catalog.fillDateValidTo(productAttributes.getDateValidTo());
        catalog.fillCode(productAttributes.getCode());
        catalog.fillName(productAttributes.getName());
        catalog.fillSku(productAttributes.getSku());
        catalog.fillGtin(productAttributes.getGtin());
        catalog.fillTaric(productAttributes.getTaric());
        catalog.fillCategories(productAttributes.getCategories());
        catalog.fillQuantity(productAttributes.getQuantity());
        catalog.fillQuantityMeasure(productAttributes.getQuantityMeasure());
        catalog.fillWeight(productAttributes.getWeight());
        catalog.fillWeightMeasure(productAttributes.getWeightMeasure());
        catalog.fillWidth(productAttributes.getWidth());
        catalog.fillHeight(productAttributes.getHeight());
        catalog.fillLength(productAttributes.getLength());
        catalog.fillSizeMeasure(productAttributes.getSizeMeasure());
        catalog.fillDeliveryStatus(productAttributes.getDeliveryStatus());
        catalog.fillSoldOutStatus(productAttributes.getSoldOutStatus());
        catalog.fillPathOfImage(productAttributes.getPathOfImage());
        catalog.goToInformationBlock();
        catalogInformTab.isInformationBlock();
        catalogInformTab.fillManufacturer(productAttributes.getManufacturer());
        catalogInformTab.fillSupplier(productAttributes.getSupplier());
        catalogInformTab.fillKeywords(productAttributes.getKeywords());
        catalogInformTab.fillShortDescription(productAttributes.getShortDescription());
        catalogInformTab.fillDescription(productAttributes.getDescription());
        catalogInformTab.fillAttributes(productAttributes.getAttributes());
        catalogInformTab.fillHeadTitle(productAttributes.getHeadTitle());
        catalogInformTab.fillMetaDescription(productAttributes.getMetaDescription());
        catalogInformTab.goToPricesBlock();
        catalogPricesTab.isPricesBlock();
        catalogPricesTab.fillPurchasePrice(productAttributes.getPurchasePrice());
        catalogPricesTab.fillVal(productAttributes.getVal());
        catalogPricesTab.fillTaxClass(productAttributes.getTaxClass());
        catalogPricesTab.fillPriceUSD(productAttributes.getPriceUSD());
        catalogPricesTab.fillPriceEUR(productAttributes.getPriceEUR());
        catalogPricesTab.savePricesInformation();
        adminPanel.goToCatalog();
        Assert.assertTrue(adminPanel.isDuckPresent(productAttributes.getName()));
    }

    @After
    public void afterClass()
    {
        driver.quit();
    }
}
