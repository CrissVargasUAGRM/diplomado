package com.nur.factories.conversation;

import com.nur.model.Conversacion;

public class ConversationFactory implements IConversationFactory {
  @Override
  public Conversacion createConversation() {
    return new Conversacion();
  }

  @Override
  public void deleteConversation() {
    new Conversacion().deprecatedConversation();
  }
}
