package com.nur.utils;

import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonsUtilsTest {
    @Test
    void testCheckPersonToJpaEntity() {
        Personas person = new Personas(
                "Cristhian",
                "Vargas",
                "1234567"
        );
        PersonaJpaModel personaJpaModel = PersonsUtils.personToJpaEntity(person);
        assertNotNull(personaJpaModel);
    }

    @Test
    void testCheckJpaToPerson() {
        PersonaJpaModel person = new PersonaJpaModel();
        person.setId(UUID.randomUUID());
        person.setName("Cristhian");
        person.setLastName("Vargas");
        person.setCi("1234567");
        Personas personDomain = PersonsUtils.jpaToPersons(person);
        assertNotNull(personDomain);
    }
}