package com.nur.repositories.persons;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nur.builder.PersonsBuilder;
import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;
import com.nur.utils.PersonsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PersonsCrudRepositoryImplTest {
  @Mock IPersonsCrudRepository personsCrudRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testUpdate() {
    assertDoesNotThrow(
        () -> {
          Personas person = new PersonsBuilder().build();

          PersonaJpaModel personaJpaModel = new PersonaJpaModel();
          personaJpaModel.setId(UUID.randomUUID());
          personaJpaModel.setName(person.getName());
          personaJpaModel.setLastName(person.getLastName());
          personaJpaModel.setCi(person.getCi());

          PersonsCrudRepositoryImpl personsRepository = new PersonsCrudRepositoryImpl();
          personsRepository.setPersonsCrudRepository(personsCrudRepository);

          when(personsCrudRepository.findById(any())).thenReturn(Optional.of(personaJpaModel));
          when(personsCrudRepository.save(any())).thenReturn(personaJpaModel);

          try (MockedStatic<PersonsUtils> theMock = Mockito.mockStatic(PersonsUtils.class)) {
            theMock.when(() -> PersonsUtils.personToJpaEntity(any())).thenReturn(personaJpaModel);
            UUID result = personsRepository.update(person);
            assertNotNull(result);
          }
        });
  }

  @Test
  void testGetById() {
    Personas person = new PersonsBuilder().build();
    PersonaJpaModel personaJpaModel = new PersonaJpaModel();
    personaJpaModel.setId(UUID.randomUUID());
    personaJpaModel.setName(person.getName());
    personaJpaModel.setLastName(person.getLastName());
    personaJpaModel.setCi(person.getCi());

    PersonsCrudRepositoryImpl personsRepository = new PersonsCrudRepositoryImpl();
    personsRepository.setPersonsCrudRepository(personsCrudRepository);

    when(personsCrudRepository.findById(any())).thenReturn(Optional.of(personaJpaModel));

    Personas personas = personsRepository.getById(personaJpaModel.getId());
    assertNotNull(personas);
    assertEquals("Cristhian", personas.getName());
    assertEquals("Vargas", personas.getLastName());
    assertEquals("123456", personas.getCi());
    assertNotNull(personas.getId());
  }

  @Test
  void testGetByIdException() {
    PersonsCrudRepositoryImpl personsRepository = new PersonsCrudRepositoryImpl();
    personsRepository.setPersonsCrudRepository(personsCrudRepository);

    when(personsCrudRepository.findById(any())).thenThrow(new RuntimeException("ERROR"));

    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              personsRepository.getById(UUID.randomUUID());
            });
    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }

  @Test
  void testGetAll() {
    Personas person = new PersonsBuilder().build();
    PersonaJpaModel personaJpaModel = new PersonaJpaModel();
    personaJpaModel.setId(UUID.randomUUID());
    personaJpaModel.setName(person.getName());
    personaJpaModel.setLastName(person.getLastName());
    personaJpaModel.setCi(person.getCi());

    List<PersonaJpaModel> list = new ArrayList<>();
    list.add(personaJpaModel);

    PersonsCrudRepositoryImpl personsRepository = new PersonsCrudRepositoryImpl();
    personsRepository.setPersonsCrudRepository(personsCrudRepository);

    when(personsCrudRepository.findAll()).thenReturn(list);

    List<Personas> persons = personsRepository.getAll();

    assertNotNull(persons);
    assertEquals(1, persons.size());
    assertEquals("Cristhian", persons.get(0).getName());
    assertEquals("Vargas", persons.get(0).getLastName());
    assertEquals("123456", persons.get(0).getCi());
  }
}
