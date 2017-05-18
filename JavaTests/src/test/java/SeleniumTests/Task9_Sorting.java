package SeleniumTests;

import OnlineShop.Countries;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Task9_Sorting {
    protected WebDriver driver;
    protected Countries countries;
    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void CountrySorting()
    {
        countries = new Countries(driver);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        Assert.assertTrue(countries.ListOfCountries());
    }
    @Test
    public void CountryZoneSorting()
    {
        countries = new Countries(driver);
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
