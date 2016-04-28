package com.alloysoftware.spb;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by asergeeva on 21.04.2016.
 */
public class TicketSubmit extends ClickHelper {

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testTicketSubmit() {
    login("admin", "");
    callSubmitAction();
  }

  /**************************   */

  private void callSubmitAction() {
    //wd.switchTo().frame("div.widget-form");
    //clickByXpath("//div[@id='TicketsConstructors']//p[.='Submit a Ticket']");
    //clickByXpath("//div[@class='main-widget-panel']//p[.='My Assets']");
    //clickByXpath("//button[@id='btnSelectClass']");
    //typeByName("//input[@id='searchSolutionformText']", "122");

    //this - works!!
    //clickByLink("How do I tell the Office Assistant to go away?");
    clickByXpath("//div[@class='main-widget-panel']/div[2]/div[2]/div[2]/div[1]/a/p");
  }

  private void login(String username, String password) {
    wd.get("http://vmasw8.spb.alloy-software.com:81/hd/");
    /*wd = (FirefoxDriver)*/
    wd.switchTo().frame("iframe-login");
    typeByName("UserName", username);
    typeByName("Password", password);
    clickById("auth-submit");

    //clickByXpath("//td[@class='ProfileHeaderUserName']//b[.='Maxwell Newcomb']");
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