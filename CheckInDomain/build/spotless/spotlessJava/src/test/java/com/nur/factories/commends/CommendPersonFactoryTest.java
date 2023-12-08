package com.nur.factories.commends;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import com.nur.model.Usuario;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommendPersonFactoryTest {
  ICommendPersonFactory commendFactory;

  @BeforeEach
  void setUp() {
    commendFactory = new CommendPersonFactory();
  }

  @AfterEach
  void tearDown() {
    commendFactory = null;
  }

  @Test
  void testCreateCommendPersonFactory() throws BusinessRuleValidationException {
    Usuario user =
        new Usuario(
            "Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", UUID.randomUUID());
    CommendPerson commend =
        commendFactory.saveCommendPerson(user.getId(), "Bueno", "lo que sea", "Cristhian", 3);
    assertEquals("lo que sea", commend.getCommend());
    assertEquals("Bueno", commend.getValoration());
    assertEquals("Cristhian", commend.getPerson());
    assertNotNull(commend.getUserId());
  }
}
