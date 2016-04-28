package com.alloysoftware.spb;

import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class SspLoginTest {
  FirefoxDriver wd;
  public      String _SSP_BASE_URL_ = "http://vmasw8.spb.alloy-software.com:81/hd/";


  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    gotoPage(_SSP_BASE_URL_);
    //from recorder: wd = (FirefoxDriver) wd.switchTo().frame("iframe-login");
    login("demo", "");
  }

  private void login(String username, String password) {
    switchToFrame("iframe-login");
    type(By.name("UserName"), username);
    type(By.name("Password"), password);
    click(By.id("auth-submit"));
      }

  private void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }


  private void switchToFrame(String nameOrId) {
    wd.switchTo().frame(nameOrId);
  }

  private void gotoPage (String url) {
    wd.get(url);
  }

  @Test

  public void formalTest() {
    /******* если юзер залогинился, то видна кнопка разлогина *******/
    Object loggedUser = wd.findElement(By.linkText("Sign Out"));
    Verify.verify(loggedUser !=null);

   // testViewTickets(); ---WORKS!
    testSubmitTicket();
  }

  public void testViewTickets () {

    gotoPage(_SSP_BASE_URL_);
    click(By.cssSelector("p.tool-instructions"));

    String check = wd.findElement(By.cssSelector("td.main-grids-title")).getText();
    Assert.assertEquals(check,"My Tickets and Requests");
  }

  public void testSubmitTicket () {
    //click(By.xpath("//div[@id='TicketsConstructors']//p[.='Submit a Ticket']"));
    click(By.id("TicketsConstructors"));
    //wd = new FirefoxDriver();
type(By.xpath("//input[@id='textactionfield-1157-inputEl']"), "ticket's summary");
//type(By.xpath("//div[@id='actionform-1014']//id[.='textactionfield-1157-inputEl']"), "ticket's summary");
    /*wd.switchTo().activeElement(); // (wd.findElement(By.cssSelector("div.constructor-container")));

    */
    //wd.switchTo().alert();//"actionform-1014");
    //wd.switchTo().window("winId");


    /*type(By.id("textactionfield-1157-inputEl"), "ticket's summary");
    type(By.id("memoactionfield-1164-inputEl"), "ticket's description");
    click(By.id("button-1151-btnIconEl"));

    Assert.assertEquals(wd.findElement(By.tagName("h1")),"T0*");*/
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
