package com.nur.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.UserJpaModel;
import com.nur.model.Usuario;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UsersUtilsTest {
  @Test
  void testCheckPersonToJpaEntity() throws BusinessRuleValidationException {
    Usuario user =
        new Usuario("Cristhian", "cristhian@gmail.com", "1234567", "Huesped", UUID.randomUUID());
    UserJpaModel userJpa = UsersUtils.userToJpaEntity(user);
    assertNotNull(userJpa);
  }

  @Test
  void testCheckJpaToUser() throws BusinessRuleValidationException {
    UserJpaModel user = new UserJpaModel();
    user.setId(UUID.randomUUID());
    user.setUsername("Cristhian");
    user.setEmail("cristhian@gmail.com");
    user.setPassword("1234567");
    user.setAccountType("Huesped");
    user.setPersonId(UUID.randomUUID());
    Usuario userDomain = UsersUtils.jpaToUser(user);
    assertNotNull(userDomain);
  }
}
