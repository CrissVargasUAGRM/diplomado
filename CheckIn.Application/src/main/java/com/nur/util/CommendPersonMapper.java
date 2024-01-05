package com.nur.util;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.CommendPersonDTO;
import com.nur.model.CommendPerson;
import java.util.UUID;

public class CommendPersonMapper {
  public static CommendPersonDTO from(CommendPerson commends) {
    if (commends == null) return new CommendPersonDTO();
    return new CommendPersonDTO(
        String.valueOf(commends.getId()),
        String.valueOf(commends.getUserId()),
        commends.getValoration(),
        commends.getCommend(),
        commends.getPerson(),
        commends.getPoints());
  }

  public static CommendPerson from(CommendPersonDTO commends)
      throws BusinessRuleValidationException {
    return new CommendPerson(
        UUID.fromString(commends.getId()),
        UUID.fromString(commends.getUserId()),
        commends.getValoration(),
        commends.getDescription(),
        commends.getPerson(),
        commends.getPoints());
  }
}
