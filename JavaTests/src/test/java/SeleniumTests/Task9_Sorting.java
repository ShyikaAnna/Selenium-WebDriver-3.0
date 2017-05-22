package SeleniumTests;

import OnlineShop.Countries;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task9_Sorting {
    protected WebDriver driver;
    protected Countries countries;
    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        countries = new Countries(driver);
    }
    @Test
    public void CountrySorting()
    {
       // countries = new Countries(driver);
        countries.isCountryTab();
        Assert.assertTrue(countries.ListOfCountries());
    }
    @Test
    public void CountryZoneSorting()
    {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countries.isCountryTab();
        ArrayList<Integer> countriesWithZone = countries.getCountriesWithZone();
        for (int i = 0; i < countriesWithZone.size(); i++)
        {
            countries.goToCountry(countriesWithZone.get(i));
            countries.isEditCountry();
            Assert.assertTrue(countries.checkSortZones());
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            countries.isCountryTab();
        }
        Assert.assertTrue(countries.checkSortZones());
    }
    @After
    public void afterClass()
    {
        driver.quit();
    }
}
