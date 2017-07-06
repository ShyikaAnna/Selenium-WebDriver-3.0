package OnlineShop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageInitialization pageInitialization;

    // Конструктор
    public Base(PageInitialization pageInitialization)
    {
        this.pageInitialization = pageInitialization;
        driver = pageInitialization.getWebDriver();
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    // Конструктор
    public Base(WebDriver driver)
    {
        this.pageInitialization = null;
        this.driver =driver;
        wait = new WebDriverWait(driver, 5);
    }
}

