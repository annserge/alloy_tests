package com.alloysoftware.hd.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by asergeeva on 08.07.2016.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void checkForSessions() {
    if (wd.findElement(By.tagName("html")).getText().contains("Log off other sessions")) {
      System.out.println("[Concurrent session detected...");
      click(By.id("ctl06_bYesKill_CD"));
      System.out.println("...and killed]");
    }
  }

  public void loginSSP(String username, String password) {
    type(By.name("UserName"), username);
    type(By.name("Password"), password);

    click(By.id("auth-submit"));
    find(By.className("ProfileHeaderUserName"));
    Assert.assertEquals("Self Service Portal", getPageTitle());
  }

}
