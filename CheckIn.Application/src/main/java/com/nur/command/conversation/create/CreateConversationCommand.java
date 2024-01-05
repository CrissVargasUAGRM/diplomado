package com.nur.command.conversation.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ConversationDTO;

public class CreateConversationCommand implements Command<ConversationDTO> {

  ConversationDTO conversationDTO;

  public CreateConversationCommand() {
    this.conversationDTO = new ConversationDTO();
  }
}
