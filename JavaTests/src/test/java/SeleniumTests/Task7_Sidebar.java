package SeleniumTests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.*;

public class Task7_Sidebar extends  TestBase {
    @Test
    public void MyFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(id("sidebar")));
    }

    @Test
    public  void SidebarClick() {
        String itemsMenu = "//ul[@id='box-apps-menu']/li";
        String itemMenuLinkTemplate = "//ul[@id='box-apps-menu']/li[%s]/a";
        String itemMenuTemplate = "//ul[@id='box-apps-menu']/li[%s]";
        String subItemsMenu = "//ul[@class='docs']/li";
        String subItemMenuTemplate = "//ul[@class='docs']/li[%s]";
        String Title = "//main[@id='main']/h1";
        int itemsCount = driver.findElements(By.xpath(itemsMenu)).size();
        //int i=0;
        List<WebElement> itemMenu = driver.findElements(By.xpath(itemsMenu));
        java.util.Iterator<WebElement> k = itemMenu.iterator();
        while(k.hasNext()) {
            WebElement item = k.next();
            item.click();
            System.out.println(item.getText());
            List<WebElement> subItem = driver.findElements(By.xpath(subItemsMenu));
            java.util.Iterator<WebElement> i = subItem.iterator();
            while (i.hasNext()) {
                WebElement subitems = i.next();
                subitems.click();
                System.out.println(subitems.getText());
            }
        }

      



    }
}



