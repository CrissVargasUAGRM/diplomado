package com.nur.builder;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Usuario;
import java.util.UUID;

public class UsersBuilder {
  public Usuario build() throws BusinessRuleValidationException {
    return new Usuario("Criss", "cristhian@gmail.com", "123456", "Huesped", UUID.randomUUID());
  }
}
