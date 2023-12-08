package com.nur.factories.persons;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.Personas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaFactoryTest {
  IPersonaFactory personaFactory;

  @BeforeEach
  void setUp() {
    personaFactory = new PersonaFactory();
  }

  @AfterEach
  void tearDown() {
    personaFactory = null;
  }

  @Test
  void testCreatePersonFactory() {
    Personas person = personaFactory.createPerson("Cristhian", "Vargas", "1234567");
    assertNotNull(person);
    assertEquals("Cristhian", person.getName());
    assertEquals("Vargas", person.getLastName());
    assertEquals("1234567", person.getCi());
  }
}
