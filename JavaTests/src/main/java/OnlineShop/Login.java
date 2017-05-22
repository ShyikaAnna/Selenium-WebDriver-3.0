package OnlineShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Login(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String newUserCreate = "//div[@id='box-account-login']//p/a";
    private String formEmail = "//div[@id='box-account-login']//input[@name='email']";
    private String formPassword = "//div[@id='box-account-login']//input[@name='password']";
    private String logOut = "//div[@id='box-account']//a[text()='Logout']";
    private String signIn = "//div[@id='box-account-login']//button[@name='login']";

    public void clickNewUserCreate()
    {
        By NewUserCreate = By.xpath(newUserCreate);
        driver.findElement(NewUserCreate).click();
    }

    public void logOut()
    {
        By lLogOut = By.xpath(logOut);
        driver.findElement(lLogOut).click();
    }

    public void enterEmail(String email)
    {
        By lFormEmail = By.xpath(formEmail);
        driver.findElement(lFormEmail).sendKeys(email);
    }

    public void enterPassword(String pass)
    {
        By lFormPassword = By.xpath(formPassword);
        driver.findElement(lFormPassword).sendKeys(pass);
    }

    public void SignIn()
    {
        By lSignIn = By.xpath(signIn);
        driver.findElement(lSignIn).click();
    }
}
