package com.nur.factories.messages;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Conversacion;
import com.nur.model.Messages;
import com.nur.model.Usuario;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageFactoryTest {
  IMessageFactory messageFactory;

  @BeforeEach
  void setUp() {
    messageFactory = new MessageFactory();
  }

  @AfterEach
  void tearDown() {
    messageFactory = null;
  }

  @Test
  void testCreateMessageFactory() throws BusinessRuleValidationException {
    Usuario user =
        new Usuario("Cristhian", "cristhian@gmail.com", "1234567", "Huesped", UUID.randomUUID());
    Conversacion conversacion = new Conversacion();
    Messages messages =
        messageFactory.saveMessage(user.getId(), "un mensaje chido", conversacion.getId());
    assertNotNull(messages);
    assertNotNull(messages.getUserId());
    assertNotNull(messages.getConversacionId());
    assertEquals("un mensaje chido", messages.getDescription());
  }
}
