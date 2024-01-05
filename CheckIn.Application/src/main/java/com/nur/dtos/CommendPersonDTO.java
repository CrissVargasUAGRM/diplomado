package com.nur.dtos;

import com.nur.annotations.Generated;

@Generated
public class CommendPersonDTO {
  public String id;
  public String userId;
  public String valoration;
  public String description;
  public String person;
  public Integer points;

  public CommendPersonDTO() {}

  public CommendPersonDTO(
      String id,
      String userId,
      String valoration,
      String description,
      String person,
      Integer points) {
    this.id = id;
    this.userId = userId;
    this.valoration = valoration;
    this.description = description;
    this.person = person;
    this.points = points;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getValoration() {
    return valoration;
  }

  public void setValoration(String valoration) {
    this.valoration = valoration;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPerson() {
    return person;
  }

  public void setPerson(String person) {
    this.person = person;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }
}
