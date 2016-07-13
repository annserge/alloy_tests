package com.alloysoftware.hd.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by asergeeva on 07.07.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  protected void switchToFrame(String nameOrId) {
    wd.switchTo().frame(nameOrId);
  }

  protected void gotoPage(String pageURL) {
    wd.get(pageURL);
  }
}
