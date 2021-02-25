package com.netflix.api.enums;

public enum Company {
  LUCAS_FILM("1"),
  DISNEY("2"),
  PIXAR("3"),
  NEW_LINE_CINEMA("12"),
  WARNER_BROS_ENTERTAINMENT_US("17");

  private final String id;

  private Company(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
