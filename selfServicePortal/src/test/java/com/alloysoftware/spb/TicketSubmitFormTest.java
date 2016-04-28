package com.alloysoftware.spb;

import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class TicketSubmitFormTest {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    login("admin", "");
  }

  private void login(String username, String password) {
    wd.get("http://vmasw8.spb.alloy-software.com:81/hd/Account/LogOn?ReturnUrl=%2fhd%2f");
    wd = (FirefoxDriver) wd.switchTo().frame("iframe-login");
    wd.findElement(By.name("UserName")).click();
    wd.findElement(By.name("UserName")).clear();
    wd.findElement(By.name("UserName")).sendKeys(username);
    wd.findElement(By.name("Password")).click();
    wd.findElement(By.name("Password")).click();
    wd.findElement(By.name("Password")).sendKeys(password);
    ////Assert.assertTrue(wd.By.xpath("//td[@class='ProfileHeaderUserName']//b[.='Maxwell Newcomb']")));
            //"//div[2]/div[1]/div/table/tbody/tr/td[3]/div/div[1]/table/tbody/tr/td[1]/b");
    wd.findElement(By.xpath("//td[@class='ProfileHeaderUserName']//b[.='Maxwell Newcomb']")).click();
  }

  @Test
  public void testTicketSubmitForm() {
    wd.get("http://vmasw8.spb.alloy-software.com:81/hd/");

    //submit ticket
    wd.findElement(By.xpath("//div[@id='TicketsConstructors']//p[.='Submit a Ticket']")).click();

    wd.switchTo().frame("actionform-1015-body");
    //submit form:
    //Assert.assertEquals("Report a Technical Issue", "actionwindow-1011_header_hd-textEl");
    //wd.findElement(By.id("actionwindow-1011_header_hd-textEl")).click();
    //summary
    wd.findElement(By.id("textactionfield-1019-inputEl")).click();
    wd.findElement(By.id("textactionfield-1019-inputEl")).clear();
    wd.findElement(By.id("textactionfield-1019-inputEl")).sendKeys("summary333");
    //description
    wd.findElement(By.id("memoactionfield-1026-inputEl")).click();
    wd.findElement(By.id("memoactionfield-1026-inputEl")).clear();
    wd.findElement(By.id("memoactionfield-1026-inputEl")).sendKeys("description");
    //category
    wd.findElement(By.id("ext-gen1198")).click();
    wd.findElement(By.xpath("//div[@id='boundlist-1151-listEl']//td[.='E-mail']")).click();
    //urgency
    wd.findElement(By.id("ext-gen1205")).click();
    wd.findElement(By.xpath("//div[@id='boundlist-1153-listEl']//td[.='3 - No Rush']")).click();
    //impact
    wd.findElement(By.id("ext-gen1210")).click();
    wd.findElement(By.xpath("//div[@id='boundlist-1155-listEl']//td[.='3 - Single Person']")).click();
    //ok
    wd.findElement(By.id("button-1013-btnIconEl")).click();

        /* old locators
        wd.findElement(By.id("ext-gen1198")).click();
        wd.findElement(By.cssSelector("td.x-boundlist-item.x-boundlist-item-over")).click();
        wd.findElement(By.id("ext-gen1205")).click();
        wd.findElement(By.cssSelector("td.x-boundlist-item.x-boundlist-item-over")).click();
        wd.findElement(By.id("ext-gen1210")).click();
        wd.findElement(By.xpath("//div[@id='boundlist-1155-listEl']//td[.='3 - Single Person']")).click();
        */

    wd.get("http://vmasw8.spb.alloy-software.com:81/hd/Tickets");

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
