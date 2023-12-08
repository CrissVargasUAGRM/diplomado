package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObjects.ValorationValueObject;
import java.util.UUID;

public class CommendPerson extends Entity {
  public UUID userId;
  public String valoration;
  public String commend;
  public String person;
  public ValorationValueObject points;

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getValoration() {
    return valoration;
  }

  public String getCommend() {
    return commend;
  }

  public String getPerson() {
    return person;
  }

  public int getPoints() {
    return points.getPoints();
  }

  public CommendPerson(UUID userId, String valoration, String commend, String person, int points)
      throws BusinessRuleValidationException {
    id = UUID.randomUUID();
    this.userId = userId;
    this.valoration = valoration;
    this.commend = commend;
    this.person = person;
    this.points = new ValorationValueObject(points);
  }

  public CommendPerson(
      UUID idCommend, UUID userId, String valoration, String commend, String person, int points)
      throws BusinessRuleValidationException {
    id = idCommend;
    this.userId = userId;
    this.valoration = valoration;
    this.commend = commend;
    this.person = person;
    this.points = new ValorationValueObject(points);
  }
}
