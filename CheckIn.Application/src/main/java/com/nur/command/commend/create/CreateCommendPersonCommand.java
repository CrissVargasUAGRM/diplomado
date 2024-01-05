package com.nur.command.commend.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendPersonDTO;

public class CreateCommendPersonCommand implements Command<CommendPersonDTO> {
  CommendPersonDTO commendPersonDTO;

  public CreateCommendPersonCommand(CommendPersonDTO commendPersonDTO) {
    this.commendPersonDTO = commendPersonDTO;
  }
}
