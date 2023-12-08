package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.conversation.create.CreateConversationCommand;
import com.nur.dtos.ConversationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ConversationsController {
  Logger logger = LoggerFactory.getLogger(ConversationsController.class);

  final Pipeline pipeline;

  public ConversationsController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/conversation/create")
  public ConversationDTO createConversation() {
    CreateConversationCommand command = new CreateConversationCommand();
    return command.execute(pipeline);
  }
}
