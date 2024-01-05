package com.nur.command.person.create;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import builder.CreatePersonCommandBuilder;
import builder.PersonDTOBuilder;
import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreatePersonHandlerTest {
  @Mock private IPersonRepository personRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCreateHandle() {
    Personas personDomain = new Personas("Cristhian", "Vargas", "123456");
    PersonDTO person = new PersonDTOBuilder().build();

    CreatePersonCommand request = new CreatePersonCommandBuilder().build();

    personRepository.update(personDomain);

    CreatePersonHandler handler = new CreatePersonHandler(personRepository);
    PersonDTO response = handler.handle(request);
    assertNotNull(response);
    assertEquals(person.getCi(), response.getCi());
    assertEquals(person.getName(), response.getName());
    assertEquals(person.getLastName(), response.getLastName());
    assertNotNull(response.getId());
    assertNotNull(person.getId());
  }

  @Test
  void testCreateHandleException() {
    CreatePersonCommand request = new CreatePersonCommandBuilder().build();
    when(personRepository.update(any())).thenThrow(new RuntimeException("ERROR"));
    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              CreatePersonHandler handler = new CreatePersonHandler(personRepository);
              handler.handle(request);
            });

    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }
}
