package com.nur.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import com.nur.model.CommendJpaModel;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CommendUtilsTest {
  @Test
  void testCheckCommendToJpaEntity() throws BusinessRuleValidationException {
    Commend commend = new Commend(UUID.randomUUID(), "Bueno", "lo que sea", "Condominio", 3);
    CommendJpaModel model = CommendUtils.commendToJpaEntity(commend);
    assertNotNull(model);
  }

  @Test
  void testCheckJpaToCommend() throws BusinessRuleValidationException {
    CommendJpaModel jpaModel = new CommendJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setValoration("Bueno");
    jpaModel.setCommend("Lo que sea");
    jpaModel.setProperty("Condominio");
    jpaModel.setPoints(3);
    Commend commend = CommendUtils.jpaToCommend(jpaModel);
    assertNotNull(commend);
  }
}
