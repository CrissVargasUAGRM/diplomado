package com.nur.factories.commends;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import com.nur.model.Usuario;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentFactoryTest {
  ICommendFactory commendFactory;

  @BeforeEach
  void setUp() {
    commendFactory = new CommentFactory();
  }

  @AfterEach
  void tearDown() {
    commendFactory = null;
  }

  @Test
  void testCreateCommendFactory() throws BusinessRuleValidationException {
    Usuario user =
        new Usuario(
            "Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", UUID.randomUUID());
    Commend commend =
        commendFactory.saveCommend(user.getId(), "lo que sea", "Bueno", "Condominio", 3);
    assertEquals("lo que sea", commend.getComentario());
    assertEquals("Bueno", commend.getValoracion());
    assertEquals("Condominio", commend.getPropiedad());
    assertNotNull(commend.getUserId());
  }
}
