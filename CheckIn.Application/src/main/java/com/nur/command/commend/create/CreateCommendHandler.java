package com.nur.command.commend.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendDTO;
import com.nur.factories.commends.CommentFactory;
import com.nur.factories.commends.ICommendFactory;
import com.nur.model.Commend;
import com.nur.repositories.ICommendRepository;
import com.nur.util.CommendMapper;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreateCommendHandler implements Command.Handler<CreateCommendCommand, CommendDTO> {

  private final ICommendRepository commendRepository;
  private final ICommendFactory commendFactory;

  public CreateCommendHandler(ICommendRepository commendRepository) {
    this.commendRepository = commendRepository;
    this.commendFactory = new CommentFactory();
  }

  @Override
  public CommendDTO handle(CreateCommendCommand command) {
    Commend commend = null;
    try {
      commend =
          commendFactory.saveCommend(
              UUID.fromString(command.commendDTO.getUserId()),
              command.commendDTO.getDescription(),
              command.commendDTO.getValoration(),
              command.commendDTO.getProperty(),
              command.commendDTO.getPoints());
      commendRepository.update(commend);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return CommendMapper.from(commend);
  }
}
