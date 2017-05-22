package SeleniumTests;

import OnlineShop.Login;
import OnlineShop.MyStorepage;
import OnlineShop.NewAccount;
import OnlineShop.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class Task11_SignUp {
    protected WebDriver driver;
    protected MyStorepage myStorepage;
    protected NewAccount newAccount;
    protected Login login;
    private UserData userData;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart");
        myStorepage = new MyStorepage(driver);
        newAccount = new NewAccount(driver);
        login = new Login(driver);
        userData = new UserData("987456321", "Tesla", "Anna", "Shyika", " Las Vegas, Tropicana ave, 28", "no", "12345",
                "Las Vegas", "United States", "Nevada", "12345678901", "user123");
        System.out.println(userData.toString());
    }
    @Test
    public void registration()
    {
        login.clickNewUserCreate();
        newAccount.isNewUserBlock();
        newAccount.fillTaxID(userData.getTaxID());
        newAccount.fillCompany(userData.getCompany());
        newAccount.fillFirstName(userData.getFirstName());
        newAccount.fillLastName(userData.getLastName());
        newAccount.fillAddress1(userData.getAddress1());
        newAccount.fillAddress2(userData.getAddress2());
        newAccount.fillPostcode(userData.getPostcode());
        newAccount.fillCity(userData.getCity());
        newAccount.fillCountry(userData.getCountry());
        newAccount.fillState(userData.getState());
        newAccount.fillEmail(userData.getEmail());
        newAccount.fillPhone(userData.getPhone());
        newAccount.fillPassword(userData.getPassword());
        newAccount.fillConfirmPassword(userData.getPassword());
        newAccount.createAccount();
        login.logOut();
        login.enterEmail(userData.getEmail());
        login.enterPassword(userData.getPassword());
        login.SignIn();
        login.logOut();
    }
    @After
    public void afterClass()
    {
        driver.quit();
    }
}
