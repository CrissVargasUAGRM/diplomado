package com.nur.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class CommendJpaModelTest {
  @Test
  void testCheckCreateCommendJpa() {
    UserJpaModel user = new UserJpaModel();
    CommendJpaModel jpaCommend = new CommendJpaModel();
    jpaCommend.setId(UUID.randomUUID());
    jpaCommend.setValoration("Bueno");
    jpaCommend.setCommend("lo que sea");
    jpaCommend.setProperty("Condominio");
    jpaCommend.setPoints(3);
    jpaCommend.setUserId(UUID.randomUUID());
    assertEquals("Bueno", jpaCommend.getValoration());
    assertEquals("lo que sea", jpaCommend.getCommend());
    assertEquals("Condominio", jpaCommend.getProperty());
    assertEquals(3, jpaCommend.getPoints());
    assertNotNull(jpaCommend.getId());
    assertNotNull(jpaCommend.getUserId());
  }
}
