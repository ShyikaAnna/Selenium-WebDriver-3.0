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
    private String pageFlag = "//h1[contains(.,'Countries')]";
    private String numberOfZones = "//*[@id='content']/form/table/tbody/tr/td[6]";
    private String countriesRef = "//*[@id='content']/form/table/tbody//td[5]";
    private String countryRefTemplate = ".//*[@id='content']/form/table/tbody/tr[%s]/td[5]/a";
    private String zonesRef = "//main[@id='main']//td[3]/input";


    public Countries(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

public boolean isCountriesBlock()
{
    driver.findElement(By.xpath("//span[contains(.,'Countries')]")).click();
    By lPageFlag = By.xpath(pageFlag);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Countries"));
    return driver.findElement(lPageFlag).isDisplayed();
}

    public Boolean checkSortCountries()
    {
        By lCountriesRef = By.xpath(countriesRef);
        List<WebElement> elements = driver.findElements(lCountriesRef);
        return checkSortByAlfabet(elements);
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

    private Boolean checkSortByAlfabet(List<WebElement> elements)
    {
        for (int i = 1; i < elements.size(); i++)
        {
            if (elements.get(i - 1).getText().compareTo(elements.get(i).getText()) > 0)
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
