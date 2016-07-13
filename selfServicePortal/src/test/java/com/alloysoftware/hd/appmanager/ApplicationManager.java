package com.alloysoftware.hd.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by asergeeva on 07.07.2016.
 */
public class ApplicationManager {

  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private TicketHelper ticketHelper;

  public String getPageTitle() {
    return wd.getTitle();
  }

  public void init(String startURL, String login, String password) {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    ticketHelper = new TicketHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);

    navigationHelper.gotoPage(startURL);
    navigationHelper.switchToFrame("iframe-login");
    sessionHelper.loginSSP(login, password);
    sessionHelper.checkForSessions();
  }

  public void stop() {
    wd.quit();
  }

  public TicketHelper getTicketHelper() {
    return ticketHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
