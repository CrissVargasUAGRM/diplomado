package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import java.util.List;
import java.util.UUID;

public interface ICommendPersonRepository {
  UUID update(CommendPerson commend) throws BusinessRuleValidationException;

  CommendPerson getById(UUID id);

  List<CommendPerson> getAll();
}
