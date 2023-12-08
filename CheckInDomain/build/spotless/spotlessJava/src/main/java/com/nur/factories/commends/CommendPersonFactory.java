package com.nur.factories.commends;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import java.util.UUID;

public class CommendPersonFactory implements ICommendPersonFactory {
  @Override
  public CommendPerson saveCommendPerson(
      UUID userId, String valoration, String comment, String person, int points)
      throws BusinessRuleValidationException {
    return new CommendPerson(userId, valoration, comment, person, points);
  }
}
