package com.alloysoftware.hd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewTicketListTests extends TestBase {

  @Test
  public void testViewTicketList() {
    viewTickets();
  }

  private void viewTickets() {
    app.getTicketHelper().getTicketGridFromDashboard();
    Assert.assertEquals("My Tickets and Requests", app.getPageTitle());
  }


}
