package com.nur.command.users.create;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import builder.CreateUserCommandBuilder;
import builder.UsersDTOBuilder;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.UsersDTO;
import com.nur.model.Usuario;
import com.nur.repositories.IUserRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreateUserHandlerTest {
  @Mock private IUserRepository userRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCreateHandler() throws BusinessRuleValidationException {
    Usuario userDomain =
        new Usuario("Criss", "cristhian@gmail.com", "123456", "Huesped", UUID.randomUUID());
    UsersDTO userJpa = new UsersDTOBuilder().build();
    CreateUserCommand request = new CreateUserCommandBuilder().build();

    userRepository.update(userDomain);

    CreateUserHandler handler = new CreateUserHandler(userRepository);
    UsersDTO response = handler.handle(request);
    assertNotNull(response);
    assertEquals(userJpa.getUserName(), response.getUserName());
    assertEquals(userJpa.getEmail(), response.getEmail());
    assertEquals(userJpa.getSecretPass(), response.getSecretPass());
    assertEquals(userJpa.getAccountType(), response.getAccountType());
    assertNotNull(response.getId());
    assertNotNull(response.getPersonId());
  }

  @Test
  void testCreateHandleException() throws BusinessRuleValidationException {
    CreateUserCommand request = new CreateUserCommandBuilder().build();
    when(userRepository.update(any())).thenThrow(new RuntimeException("ERROR"));
    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              CreateUserHandler handler = new CreateUserHandler(userRepository);
              handler.handle(request);
            });

    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }
}
