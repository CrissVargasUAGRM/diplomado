package com.nur.command.conversation.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ConversationDTO;
import com.nur.factories.conversation.ConversationFactory;
import com.nur.factories.conversation.IConversationFactory;
import com.nur.model.Conversacion;
import com.nur.repositories.IConversationRepository;
import com.nur.util.ConversationMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateConversationHandler
    implements Command.Handler<CreateConversationCommand, ConversationDTO> {

  private final IConversationRepository conversationRepository;

  private final IConversationFactory conversationFactory;

  public CreateConversationHandler(IConversationRepository conversationRepository) {
    this.conversationRepository = conversationRepository;
    this.conversationFactory = new ConversationFactory();
  }

  @Override
  public ConversationDTO handle(CreateConversationCommand command) {
    Conversacion conversation = null;
    try {
      conversation = conversationFactory.createConversation();
      conversationRepository.update(conversation);
      return ConversationMapper.from(conversation);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
