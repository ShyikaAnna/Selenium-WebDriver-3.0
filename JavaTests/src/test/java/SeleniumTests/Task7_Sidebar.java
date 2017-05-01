package SeleniumTests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.*;

public class Task7_Sidebar extends  TestBase {
    @Test
    public void MyFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("remember_me")).click();
        driver.findElement(xpath(".//*[@id='box-login']/form/div[2]/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(id("sidebar")));
    }

    @Test
    public void SidebarClick() {
        driver.findElement(By.xpath(".//*[@id='app-']/a/span[2]")).click();
        driver.findElement(By.xpath(".//*[@id='doc-logotype']/a/span")).click();
    }
}



