package com.nur.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nur.annotations.Generated;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Generated
public class ConversationDTO {
  private String id;
  private LocalDate initDate;
  private LocalDate endDate;
  private String status;

  public ConversationDTO() {}

  public ConversationDTO(String id, LocalDate initDate, LocalDate endDate, String status) {
    this.id = id;
    this.initDate = initDate;
    this.endDate = endDate;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getInitDate() {
    return initDate;
  }

  public void setInitDate(LocalDate initDate) {
    this.initDate = initDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
