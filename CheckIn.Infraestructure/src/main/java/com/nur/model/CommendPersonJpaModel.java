package com.nur.model;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "CommendPerson")
public class CommendPersonJpaModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_COMMEND")
  private UUID id;

  @Column(nullable = false, name = "VALORATION")
  private String valoration;

  @Column(nullable = false, name = "COMMENT")
  private String comment;

  @Column(nullable = false, name = "PERSON")
  private String person;

  @Column(nullable = false, name = "POINTS")
  private Integer points;

  @Column(nullable = false, name = "USER_ID")
  private UUID userId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getValoration() {
    return valoration;
  }

  public void setValoration(String valoration) {
    this.valoration = valoration;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }
}
