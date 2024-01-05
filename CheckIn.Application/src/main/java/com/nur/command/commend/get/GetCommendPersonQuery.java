package com.nur.command.commend.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendPersonDTO;

public class GetCommendPersonQuery implements Command<CommendPersonDTO> {
  String commandPersonId;

  public GetCommendPersonQuery(String commandPersonId) {
    this.commandPersonId = commandPersonId;
  }
}
