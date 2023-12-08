package com.nur.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import builder.PersonDTOBuilder;
import com.nur.dtos.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PersonsControllerTest {
  @Mock Pipeline pipeline;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testControllerCreatePerson() {
    PersonDTO person = new PersonDTOBuilder().build();

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(person);

    PersonsController personsController = new PersonsController(pipeline);

    PersonDTO personController = personsController.createPerson(person);
    assertNotNull(personController);
  }

  @Test
  void testControllerGetPersonById() {
    PersonDTO person = new PersonDTOBuilder().build();

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(person);

    PersonsController personsController = new PersonsController(pipeline);
    PersonDTO response = personsController.findById(String.valueOf(UUID.randomUUID()));
    assertNotNull(response);
  }

  @Test
  void testControllerGetListPersons() {
    List<PersonDTO> persons = new ArrayList<>();
    persons.add(new PersonDTOBuilder().build());

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(persons);

    PersonsController personController = new PersonsController(pipeline);
    List<PersonDTO> response = personController.getAll();
    assertNotNull(response);
  }
}
