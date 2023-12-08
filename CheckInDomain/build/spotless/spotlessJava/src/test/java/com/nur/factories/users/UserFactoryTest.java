package com.nur.factories.users;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Personas;
import com.nur.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserFactoryTest {
  IUserFactory userFactory;

  @BeforeEach
  void setUp() {
    userFactory = new UserFactory();
  }

  @AfterEach
  void tearDown() {
    userFactory = null;
  }

  @Test
  void testCreateUSerFactory() throws BusinessRuleValidationException {
    Personas person = new Personas("Cristhian", "Vargas", "1234567");
    Usuario user =
        userFactory.createUser(
            "Criss", "cristhian_086@gmail.com", "123456", "Huesped", person.getId());
    assertNotNull(user);
    assertNotNull(user.getPersonId());
    assertEquals("Criss", user.getUsername());
    assertEquals("cristhian_086@gmail.com", user.getEmail());
    assertEquals("123456", user.getPass());
    assertEquals("Huesped", user.getAccountType());
    assertNotNull(user.getPersonId());
  }

  @Test
  void testException() {}
}
