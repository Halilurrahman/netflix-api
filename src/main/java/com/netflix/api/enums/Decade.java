package com.netflix.api.enums;

public enum Decade {
  EIGHTIES("1980-01-01", "1989-12-31"),
  NINETIES("1990-01-01", "1999-12-31"),
  NOUGHTIES("2000-01-01", "2009-12-31");

  private final String earliestDate;
  private final String latestDate;

  private Decade(String earliestDate, String latestDate) {
    this.earliestDate = earliestDate;
    this.latestDate = latestDate;
  }

  public String getEarliestDate() {
    return earliestDate;
  }

  public String getLatestDate() {
    return latestDate;
  }
}



