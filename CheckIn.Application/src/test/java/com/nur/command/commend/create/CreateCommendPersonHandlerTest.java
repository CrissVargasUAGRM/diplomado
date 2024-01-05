package com.nur.command.commend.create;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import builder.CommendPersonDTOBuilder;
import builder.CreateCommendPersonCommandBuilder;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.CommendPersonDTO;
import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreateCommendPersonHandlerTest {
  @Mock private ICommendPersonRepository commendRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCreateHandler() throws BusinessRuleValidationException {
    CommendPerson commendDomain =
        new CommendPerson(UUID.randomUUID(), "Bueno", "Lo que sea", "Cristhian", 3);
    CommendPersonDTO commendJpa = new CommendPersonDTOBuilder().build();
    CreateCommendPersonCommand request = new CreateCommendPersonCommandBuilder().build();

    commendRepository.update(commendDomain);

    CreateCommendPersonHandler handler = new CreateCommendPersonHandler(commendRepository);
    CommendPersonDTO response = handler.handle(request);
    assertNotNull(response);
    assertEquals(commendJpa.getValoration(), response.getValoration());
    assertEquals(commendJpa.getDescription(), response.getDescription());
    assertEquals(commendJpa.getPerson(), response.getPerson());
    assertEquals(commendJpa.getPoints(), response.getPoints());
    assertNotNull(response.getUserId());
  }

  @Test
  void testHandlerException() throws BusinessRuleValidationException {
    CreateCommendPersonCommand request = new CreateCommendPersonCommandBuilder().build();
    when(commendRepository.update(any())).thenThrow(new RuntimeException("ERROR"));
    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              CreateCommendPersonHandler handler =
                  new CreateCommendPersonHandler(commendRepository);
              handler.handle(request);
            });

    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }
}
