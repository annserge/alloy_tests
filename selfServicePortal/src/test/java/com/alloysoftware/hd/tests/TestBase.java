package com.alloysoftware.hd.tests;

import com.alloysoftware.hd.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by asergeeva on 07.07.2016.
 */
public class TestBase {


  protected final ApplicationManager app = new ApplicationManager();
  String startURL = "http://vmasw8.spb.alloy-software.com:81/hd/Account/LogOn?ReturnUrl=%2fhd%2f";
  String login    = "admin";
  String password = "";

/*
  String startURL = "http://demo.alloy-software.com/hd/Account/LogOn?ReturnUrl=%2fhd%2f";
  String login    = "client";
  String password = "";
*/


  @BeforeMethod
  public void setUp() throws Exception {
    app.init(startURL, login, password);
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
