package com.nur.command.commend.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendPersonDTO;
import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import com.nur.util.CommendPersonMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetListCommendPersonHandler
    implements Command.Handler<GetListCommendPersonQuery, List<CommendPersonDTO>> {

  private final ICommendPersonRepository commendPersonRepository;

  public GetListCommendPersonHandler(ICommendPersonRepository commendPersonRepository) {
    this.commendPersonRepository = commendPersonRepository;
  }

  @Override
  public List<CommendPersonDTO> handle(GetListCommendPersonQuery command) {
    try {
      List<CommendPerson> commends = this.commendPersonRepository.getAll();
      return commends.stream().map(CommendPersonMapper::from).toList();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
