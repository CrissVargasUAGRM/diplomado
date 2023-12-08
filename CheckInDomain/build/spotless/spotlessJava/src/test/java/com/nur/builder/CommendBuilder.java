package com.nur.builder;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import java.util.UUID;

public class CommendBuilder {
  public Commend build() throws BusinessRuleValidationException {
    return new Commend(UUID.randomUUID(), "Bueno", "Lo que sea", "Condominio", 3);
  }
}
