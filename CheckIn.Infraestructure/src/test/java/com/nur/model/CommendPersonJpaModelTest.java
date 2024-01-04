package com.nur.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class CommendPersonJpaModelTest {
  @Test
  void testCheckCreateCommendPersonJpa() {
    UserJpaModel user = new UserJpaModel();
    CommendPersonJpaModel jpaCommend = new CommendPersonJpaModel();
    jpaCommend.setId(UUID.randomUUID());
    jpaCommend.setValoration("Bueno");
    jpaCommend.setComment("lo que sea");
    jpaCommend.setPerson("Cristhian");
    jpaCommend.setPoints(3);
    jpaCommend.setUserId(UUID.randomUUID());
    assertEquals("Bueno", jpaCommend.getValoration());
    assertEquals("lo que sea", jpaCommend.getComment());
    assertEquals("Cristhian", jpaCommend.getPerson());
    assertEquals(3, jpaCommend.getPoints());
    assertNotNull(jpaCommend.getId());
    assertNotNull(jpaCommend.getUserId());
  }
}
