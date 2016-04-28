package com.alloysoftware.spb;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by asergeeva on 21.04.2016.
 */
public class WPlogin {
  FirefoxDriver wd;

  private void clickByLink(String linkText) {
    wd.findElement(By.linkText(linkText)).click();
  }

  protected void clickByXpath(String locatorXpath) {
    wd.findElement(By.id(locatorXpath)).click();
  }

  protected void clickById(String locatorId) {
    wd.findElement(By.id(locatorId)).click();
  }

  protected void typeByName(String locatorName, String textValue) {
    wd.findElement(By.name(locatorName)).click();
    wd.findElement(By.name(locatorName)).clear();
    wd.findElement(By.name(locatorName)).sendKeys(textValue);
  }

  protected void typeById(String locatorId, String textValue) {
    wd.findElement(By.name(locatorId)).click();
    wd.findElement(By.name(locatorId)).clear();
    wd.findElement(By.name(locatorId)).sendKeys(textValue);
  }

  /*************************/


  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testTicketSubmit() {
    loginWP("admin", "");
    checkForSessions();
    gotoPage();
    callNew();
  }

  private void checkForSessions() {
    if (wd.findElement(By.tagName("html")).getText().contains("Log off other sessions")) {
      System.out.println("[Concurrent session detected...");
      wd.findElement(By.id("ctl06_bYesKill_CD")).click();
      System.out.println("...and killed]");
    }
  }

  private void callNew() {
    wd.findElement(By.id("ctl00_M_ctl00_CbpMain_ASPxMenuActions_DXI0_T")).click();
    wd.findElement(By.linkText("Technical Issue")).click();

    //popup
    /*wd = (FirefoxDriver)*/ wd.switchTo().frame("ctl00_popUpWindow_CIF-1");
    //Assert.assertEquals("Submit a new Technical Issue", );


   /* wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Description$Description")).click();
    wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Description$Description")).clear();
    wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Description$Description")).sendKeys("g");
    /*
    wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Summary")).click();
    wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Summary")).clear();
    wd.findElement(By.name("ctl00$M$afcMain$cbpFormFields$ActionFieldsID$Summary")).sendKeys("g");
/*
    wd.findElement(By.id("ctl00_M_afcMain_cbpFormFields_ActionFieldsID_Summary_I")).click();
    wd.findElement(By.id("ctl00_M_afcMain_cbpFormFields_ActionFieldsID_Summary_I")).clear();
    wd.findElement(By.id("ctl00_M_afcMain_cbpFormFields_ActionFieldsID_Summary_I")).sendKeys("g");*/
/*    wd.findElement(By.id("Description")).click();
    wd.findElement(By.id("Description")).clear();
    wd.findElement(By.id("Description")).sendKeys("g");*/

    wd.findElement(By.id("ctl00_M_afcMain_cbpFormFields_PanelSave_btnSave_CD")).click();

  }

  private void gotoPage() {
    wd.findElement(By.xpath("//a[@id='ctl00_uMainNav_navBar_nb_I0i4_T']//span[.='Incidents']")).click();
    Assert.assertEquals("Incidents", wd.getTitle());

  }

  private void loginWP(String username, String password) {

    wd.get("http://vmasw8.spb.alloy-software.com:81/wp/Login.aspx?ReturnUrl=%2fwp");
    wd.findElement(By.id("tbStdUserName_I")).click();
    wd.findElement(By.id("tbStdUserName_I")).clear();
    wd.findElement(By.id("tbStdUserName_I")).sendKeys(username);
    wd.findElement(By.id("tbStdPwd_I")).click();
    wd.findElement(By.id("tbStdPwd_I")).clear();
    wd.findElement(By.id("tbStdPwd_I")).sendKeys(password);

    wd.findElement(By.id("btnLogin_CD")).click();
    //dublicate from selenium: ...   wd.findElement(By.name("btnLogin")).click();
    wd.findElement(By.tagName("a href=\"/hd/KnowledgeBase/\"")).getText();
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
