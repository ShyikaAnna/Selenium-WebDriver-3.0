package OnlineShop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseBlock {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageInitialization pageInitialization;

    // Конструктор
    public BaseBlock(PageInitialization pageInitialization)
    {
        this.pageInitialization = pageInitialization;
        driver = pageInitialization.getWebDriver();
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    // Конструктор
    public BaseBlock(WebDriver driver)
    {
        this.pageInitialization = null;
        this.driver =driver;
        wait = new WebDriverWait(driver, 5);
    }
}
