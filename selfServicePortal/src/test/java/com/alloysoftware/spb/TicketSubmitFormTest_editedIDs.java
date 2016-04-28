import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class TicketSubmitFormTest_editedIDs {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void TicketSubmitFormTest_editedIDs() {
        wd.get("http://vmasw8.spb.alloy-software.com:81/hd/");
        wd.findElement(By.xpath("//div[@id='TicketsConstructors']/table/tbody/tr/td[2]/p[2]")).click();
        wd.findElement(By.id("textactionfield-1019-inputEl")).click();
        wd.findElement(By.id("textactionfield-1019-inputEl")).clear();
        wd.findElement(By.id("textactionfield-1019-inputEl")).sendKeys("summary");
        wd.findElement(By.id("memoactionfield-1026-inputEl")).click();
        wd.findElement(By.id("memoactionfield-1026-inputEl")).clear();
        wd.findElement(By.id("memoactionfield-1026-inputEl")).sendKeys("description");
        wd.findElement(By.id("ext-gen1198")).click();
        wd.findElement(By.xpath("//div[@id='boundlist-1151-listEl']//td[.='E-mail']")).click();
        wd.findElement(By.id("ext-gen1205")).click();
        wd.findElement(By.xpath("//div[@id='boundlist-1153-listEl']//td[.='3 - No Rush']")).click();
        wd.findElement(By.id("ext-gen1210")).click();
        wd.findElement(By.xpath("//div[@id='boundlist-1155-listEl']//td[.='3 - Single Person']")).click();
        wd.findElement(By.id("button-1013-btnIconEl")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
