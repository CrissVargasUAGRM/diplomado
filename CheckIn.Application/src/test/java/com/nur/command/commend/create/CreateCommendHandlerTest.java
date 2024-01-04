package com.nur.command.commend.create;

import builder.CommendDTOBuilder;
import builder.CreateCommendCommandBuilder;
import builder.CreatePersonCommandBuilder;
import com.nur.command.person.create.CreatePersonCommand;
import com.nur.command.person.create.CreatePersonHandler;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.CommendDTO;
import com.nur.model.Commend;
import com.nur.repositories.ICommendRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class CreateCommendHandlerTest {
    @Mock
    private ICommendRepository commendRepository;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.initMocks(this);
    }

    /*@Test
    void testCreateHandler() throws BusinessRuleValidationException {
        Commend commendDomain = new Commend(UUID.randomUUID(), "Bueno", "Lo que sea", "Condominio", 3);
        CommendDTO commendJpa = new CommendDTOBuilder().build();
        CreateCommendCommand request = new CreateCommendCommandBuilder().build();

        commendRepository.update(commendDomain);

        CreateCommendHandler handler = new CreateCommendHandler(commendRepository);

        CommendDTO response = handler.handle(request);
        assertNotNull(response);
        assertEquals(commendJpa.getValoration(), response.getValoration());
        assertEquals(commendJpa.getDescription(), response.getDescription());
        assertEquals(commendJpa.getProperty(), response.getProperty());
        assertEquals(commendJpa.getPoints(), response.getPoints());
        assertNotNull(response.getUserId());
    }*/

    /*@Test
    void testHandlerException() throws BusinessRuleValidationException {
        CreateCommendCommand request = new CreateCommendCommandBuilder().build();
        when(commendRepository.update(any())).thenThrow(new RuntimeException("ERROR"));
        RuntimeException actual = assertThrows(RuntimeException.class, () -> {
            CreateCommendHandler handler = new CreateCommendHandler(commendRepository);
            handler.handle(request);
        });

        assertNotNull(actual);
        assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
    }*/
}