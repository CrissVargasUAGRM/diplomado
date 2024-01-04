package com.nur.command.commend.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendPersonDTO;
import com.nur.factories.commends.CommendPersonFactory;
import com.nur.factories.commends.ICommendPersonFactory;
import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import com.nur.util.CommendPersonMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCommendPersonHandler implements Command.Handler<CreateCommendPersonCommand, CommendPersonDTO> {
    private final ICommendPersonRepository commendPersonRepository;
    private final ICommendPersonFactory commendPersonFactory;

    public CreateCommendPersonHandler(ICommendPersonRepository commendPersonRepository) {
        this.commendPersonRepository = commendPersonRepository;
        this.commendPersonFactory = new CommendPersonFactory();
    }

    @Override
    public CommendPersonDTO handle(CreateCommendPersonCommand command) {
        CommendPerson commend = null;
        try {
            commend = commendPersonFactory.saveCommendPerson(UUID.fromString(command.commendPersonDTO.getUserId()), command.commendPersonDTO.getValoration(), command.commendPersonDTO.getDescription(), command.commendPersonDTO.getPerson(), command.commendPersonDTO.getPoints());
            if(commend == null) return null;
            commendPersonRepository.update(commend);
            return CommendPersonMapper.from(commend);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
