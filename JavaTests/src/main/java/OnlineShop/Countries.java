package OnlineShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Countries {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String country = "//span[contains(.,'Countries')]";
    private String countryPage = ".//h1[contains(.,'Countries')]";
    private String numberOfZones = "//main[@id='main']//td[6]";
    private String countriesRef = "//*[@id='content']/form/table/tbody//td[5]";
    private String countryRefTemplate = ".//*[@id='content']/form/table/tbody/tr[%s]/td[5]/a";
    private String zonesRef = "//main[@id='main']//td[3]/input";


    public Countries(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public boolean isCountryTab()
    {
        By CountryPage = By.xpath(countryPage);
        return driver.findElement(CountryPage).isDisplayed();
    }
    public Boolean ListOfCountries() {
        By CountryLink = By.xpath(country);
        List<WebElement> countries = driver.findElements(CountryLink);
        return SortingByAlphabet(countries);
    }
    private Boolean SortingByAlphabet(List<WebElement> countries)
    {
        for (int i = 1; i < countries.size(); i++)
        {
            if (countries.get(i).getText().compareTo(countries.get(i+1).getText()) > 0)
            {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> getCountriesWithZone()
    {
        ArrayList<Integer> countNumbersOfCountry = new ArrayList<Integer>();
        By lNumberOfZones = By.xpath(numberOfZones);
        List<WebElement> elements = driver.findElements(lNumberOfZones);
        for(int i=0;i<elements.size();i++){
            if(elements.get(i).getText().equals("0")){}else{
                countNumbersOfCountry.add(i+1);}
        }
        return countNumbersOfCountry;
    }

    public void goToCountry(int x){
        By lCountryRefTemplate = By.xpath(String.format(countryRefTemplate, "" + x));
        driver.findElement(lCountryRefTemplate).click();
    }
    public boolean isEditCountry()
    {
        By lPageFlag = By.xpath(countryPage);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Edit Country"));
        return driver.findElement(lPageFlag).isDisplayed();
    }
    public Boolean checkSortZones()
    {
        By ZoneLink = By.xpath(zonesRef);
        List<WebElement> zones = driver.findElements(ZoneLink);
        return checkZonesByAlphabet(zones);
    }
    private Boolean checkZonesByAlphabet(List<WebElement> elements)
    {
        for (int i = 1; i < elements.size(); i++)
        {
            if (elements.get(i - 1).getAttribute("value").compareTo(elements.get(i).getAttribute("value")) > 0)
            {
                return false;
            }
        }
        return true;
    }
    public void goToSomeCountry()
    {
        By lCountriesRef = By.xpath(countriesRef);
        goToCountry(new Random().nextInt(driver.findElements(lCountriesRef).size()));
    }
}
