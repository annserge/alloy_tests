package com.alloysoftware.spb;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by asergeeva on 21.04.2016.
 */
public class ClickHelper {
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
}
