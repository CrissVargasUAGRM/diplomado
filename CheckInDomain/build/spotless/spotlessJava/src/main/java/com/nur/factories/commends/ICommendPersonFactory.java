package com.nur.factories.commends;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import java.util.UUID;

public interface ICommendPersonFactory {
  CommendPerson saveCommendPerson(
      UUID userId, String valoration, String comment, String person, int points)
      throws BusinessRuleValidationException;
}
