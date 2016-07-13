package com.alloysoftware.hd.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Created by asergeeva on 08.07.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void find(By locator) {
    wd.findElement(locator);
  }

  protected String getPageTitle() {
    return wd.getTitle();
  }


  public void abWait() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
