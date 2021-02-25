package com.netflix.api.enums;

public enum Cast {
  TOM_CRUISE("500"),
  ROBERT_DE_NIRO("380"),
  AL_PACINO("1158");

  private final String id;

  private Cast(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
