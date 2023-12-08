package com.nur.builder;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import java.util.UUID;

public class CommendPersonBuilder {
  public CommendPerson build() throws BusinessRuleValidationException {
    return new CommendPerson(UUID.randomUUID(), "Bueno", "Lo que sea", "Cristhian", 3);
  }
}
