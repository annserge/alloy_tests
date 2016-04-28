package com.alloysoftware.spb;

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

public class TicketSubmitResult {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void TicketSubmitResult() {
        wd.get("http://vmasw8.spb.alloy-software.com:81/hd/Tickets/TicketView/94785a9b-c513-4609-910c-816ed2d3a71e");
        wd.findElement(By.id("labelactionfield-1027-inputEl")).click();
        new Actions(wd).doubleClick(wd.findElement(By.cssSelector("pre"))).build().perform();
        new Actions(wd).doubleClick(wd.findElement(By.cssSelector("pre"))).build().perform();
        new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@id='InformationTitle']//td[.='Ticket T000028']"))).build().perform();
        new Actions(wd).doubleClick(wd.findElement(By.xpath("//div[@id='InformationTitle']//td[.='Ticket T000028']"))).build().perform();
        wd.findElement(By.cssSelector("p.header-company-title")).click();
        wd.findElement(By.cssSelector("div.ttlActivity")).click();
        new Actions(wd).doubleClick(wd.findElement(By.id("labelactionfield-1027-inputEl"))).build().perform();
        new Actions(wd).doubleClick(wd.findElement(By.id("labelactionfield-1027-inputEl"))).build().perform();
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
