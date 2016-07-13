package com.alloysoftware.hd.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by asergeeva on 07.07.2016.
 */
public class TicketHelper extends HelperBase {

  public TicketHelper(WebDriver wd) {
    super(wd);
  }

  public void getTicketGridFromDashboard() {
    wd.findElement(By.className("tool-container-inner")).click();
  }
}
