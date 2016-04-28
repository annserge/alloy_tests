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

public class qqqqq000 {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void q000() {
        wd.get("http://vmasw8.spb.alloy-software.com:81/wp/Login.aspx?ReturnUrl=%2fwp");
        wd.findElement(By.id("tbStdUserName_I")).click();
        wd.findElement(By.id("tbStdUserName_I")).clear();
        wd.findElement(By.id("tbStdUserName_I")).sendKeys("admin");
        wd.findElement(By.id("tbStdPwd_I")).click();
        wd.findElement(By.xpath("//div[@id='btnLogin_CD']//span[.='Sign in']")).click();
        wd.findElement(By.name("btnLogin")).click();
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
