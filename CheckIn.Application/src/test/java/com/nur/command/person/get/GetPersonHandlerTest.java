package com.nur.command.person.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import builder.PersonDTOBuilder;
import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GetPersonHandlerTest {
  @Mock private IPersonRepository personRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetHandle() {
    assertDoesNotThrow(
        () -> {
          PersonDTO personJpa = new PersonDTOBuilder().build();
          Personas personDomain = new Personas("Cristhian", "Vargas", "1234567");
          when(personRepository.getById(any())).thenReturn(personDomain);

          GetPersonQuery query = new GetPersonQuery(String.valueOf(UUID.randomUUID()));

          GetPersonHandler handler = new GetPersonHandler(personRepository);
          PersonDTO response = handler.handle(query);

          assertNotNull(response);
          assertEquals(personJpa.getName(), response.getName());
          assertEquals(personJpa.getLastName(), response.getLastName());
          assertEquals(personJpa.getCi(), response.getCi());
          assertNotNull(response.getId());
        });
  }
}
