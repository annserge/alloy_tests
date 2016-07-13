package com.alloysoftware.hd.model;

import java.io.File;

/**
 * Created by asergeeva on 13.07.2016.
 */
public class TicketData {
  private final String summary;
  private final String description;
  /*private final String category;
  private final String urgency;
  private final String impact;
  private final String relatedTo;
  private final File attach;*/

  public TicketData (String summary, String description) {
    this.summary = summary;
    this.description = description;
  }

  public String getSummary() {
    return summary;
  }

  public String getDescription() {
    return description;
  }
}
