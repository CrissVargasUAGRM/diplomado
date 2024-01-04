package com.nur.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Conversation")
public class ConversationJpaModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_CONVERSATION")
  private UUID id;

  @Column(name = "INIT_DATE", nullable = false)
  private LocalDate initDate;

  @Column(name = "END_DATE")
  private LocalDate endDate;

  @Column(name = "STATUS", nullable = false)
  private String statusConversation;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
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

  public String getStatusConversation() {
    return statusConversation;
  }

  public void setStatusConversation(String statusConversation) {
    this.statusConversation = statusConversation;
  }
}
