package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import com.nur.model.CommendPersonJpaModel;

public class CommendPersonUtils {
  public static CommendPersonJpaModel commendToJpaEntity(CommendPerson commendPerson) {
    CommendPersonJpaModel model = new CommendPersonJpaModel();
    model.setId(commendPerson.getId());
    model.setValoration(commendPerson.getValoration());
    model.setComment(commendPerson.getCommend());
    model.setPerson(commendPerson.getPerson());
    model.setPoints(commendPerson.getPoints());
    model.setUserId(commendPerson.getUserId());
    return model;
  }

  public static CommendPerson paToCommendPerson(CommendPersonJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new CommendPerson(
        jpaModel.getId(),
        jpaModel.getUserId(),
        jpaModel.getValoration(),
        jpaModel.getComment(),
        jpaModel.getPerson(),
        jpaModel.getPoints());
  }
}
