package com.nur.command.person.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GetListPersonsHandlerTest {
  @Mock private IPersonRepository personRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetAllPersonsHandler() {
    assertDoesNotThrow(
        () -> {
          List<Personas> persons = new ArrayList<>();
          persons.add(new Personas("Cristhian", "Vargas", "1234567"));

          when(personRepository.getAll()).thenReturn(persons);

          GetListPersonsQuery query = new GetListPersonsQuery();
          GetListPersonsHandler handler = new GetListPersonsHandler(personRepository);

          List<PersonDTO> response = handler.handle(query);
          assertNotNull(response);
        });
  }

  @Test
  void testGetAllException() {
    when(personRepository.getAll()).thenThrow(new RuntimeException("ERROR"));
    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              GetListPersonsQuery query = new GetListPersonsQuery();
              GetListPersonsHandler handler = new GetListPersonsHandler(personRepository);
              List<PersonDTO> response = handler.handle(query);
            });
    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }
}
