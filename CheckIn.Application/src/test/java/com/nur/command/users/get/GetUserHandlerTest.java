package com.nur.command.users.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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

class GetUserHandlerTest {
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
    GetUserQuery query = new GetUserQuery(UUID.randomUUID());

    when(userRepository.getById(any())).thenReturn(userDomain);

    GetUserHandler handler = new GetUserHandler(userRepository);

    UsersDTO response = handler.handle(query);
    assertNotNull(response);
    assertEquals(userJpa.getUserName(), response.getUserName());
    assertEquals(userJpa.getEmail(), response.getEmail());
    assertEquals(userJpa.getSecretPass(), response.getSecretPass());
    assertEquals(userJpa.getAccountType(), response.getAccountType());
    assertNotNull(response.getPersonId());
  }
}
