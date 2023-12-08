package com.nur.factories.conversation;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.Conversacion;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConversationFactoryTest {
  IConversationFactory conversationFactory;

  @BeforeEach
  void setUp() {
    conversationFactory = new ConversationFactory();
  }

  @AfterEach
  void tearDown() {
    conversationFactory = null;
  }

  @Test
  void testCreateConversationFactory() {
    Conversacion conversacion = conversationFactory.createConversation();
    assertNotNull(conversacion);
    assertNotNull(conversacion.getId());
    assertNotNull(conversacion.getStatus());
    assertNotNull(conversacion.getFechaInicio());
    assertEquals(LocalDate.now(), conversacion.getFechaInicio());
  }
}
