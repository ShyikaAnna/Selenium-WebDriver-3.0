package SeleniumTests;

import com.google.common.base.Verify;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.*;

public class Task7_Sidebar extends  TestBase {
    String itemsMenu = "//ul[@id='box-apps-menu']/li";
    String subItemsMenu = "//ul[@class='docs']/li";
    String Title = "//main[@id='main']/h1";

    @Test
    public void MyFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
    }

    @Test
    public void SidebarClick() {
        // Calculate number of menu items
        int itemMenuCount = driver.findElements(By.xpath(itemsMenu)).size();
        System.out.println("Number of sub menu items = " + itemMenuCount);
        // Open menu items one by one
        for (int x = 1; x <= itemMenuCount; x++) {
            WebElement item = driver.findElement(By.xpath(itemsMenu + "[" + x + "]"));
            System.out.println("\nOpen item menu: " + item.getText());
            item.click();
            // Calculate number of sub menu items
            int itemSubMenuCount = driver.findElements(By.xpath(itemsMenu + subItemsMenu)).size();
            System.out.println("Number of sub menu items = " + itemSubMenuCount);
            // Open sub menu items one by one
            for (int y = 1; y <= itemSubMenuCount; y++) {
                  WebElement subItem = driver.findElement(By.xpath(itemsMenu + "[" + x + "]" + subItemsMenu + "[" + y + "]"));
                  System.out.println("\tOpen sub menu item: " + subItem.getText());
                  subItem.click();
            }
        }

    }
}



