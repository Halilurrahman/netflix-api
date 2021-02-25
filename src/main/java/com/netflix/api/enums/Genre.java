package com.netflix.api.enums;

public enum Genre {
  COMEDY("35"),
  FAMILY("10751"),
  ACTION("28"),
  THRILLER("53"),
  FANTASY("14"),
  CRIME("80"),
  ADVENTURE("12");

  private final String id;

  private Genre(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
