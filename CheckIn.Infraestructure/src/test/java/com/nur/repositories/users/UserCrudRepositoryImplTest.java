package com.nur.repositories.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nur.builder.UsersBuilder;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.UserJpaModel;
import com.nur.model.Usuario;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserCrudRepositoryImplTest {
  @Mock IUserCrudRepository userCrudRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCheckUpdate() throws BusinessRuleValidationException {
    Usuario user = new UsersBuilder().build();
    UserJpaModel jpaUser = new UserJpaModel();
    jpaUser.setId(UUID.randomUUID());
    jpaUser.setUsername(user.getUsername());
    jpaUser.setEmail(user.getEmail());
    jpaUser.setPassword(user.getPass());
    jpaUser.setAccountType(user.getAccountType());
    jpaUser.setPersonId(UUID.randomUUID());

    UserCrudRepositoryImpl usersRepository = new UserCrudRepositoryImpl();
    usersRepository.setUserRepository(userCrudRepository);

    when(userCrudRepository.save(any())).thenReturn(jpaUser);

    UUID response = usersRepository.update(user);
    assertNotNull(response);
    assertEquals(4, response.version());
  }

  @Test
  void testGetById() throws BusinessRuleValidationException {
    Usuario user = new UsersBuilder().build();
    UserJpaModel jpaUser = new UserJpaModel();
    jpaUser.setId(UUID.randomUUID());
    jpaUser.setUsername(user.getUsername());
    jpaUser.setEmail(user.getEmail());
    jpaUser.setPassword(user.getPass());
    jpaUser.setAccountType(user.getAccountType());
    jpaUser.setPersonId(UUID.randomUUID());

    UserCrudRepositoryImpl usersRepository = new UserCrudRepositoryImpl();
    usersRepository.setUserRepository(userCrudRepository);

    when(userCrudRepository.findById(any())).thenReturn(Optional.of(jpaUser));

    Usuario userById = usersRepository.getById(UUID.randomUUID());
    assertNotNull(userById);
    assertEquals("Criss", userById.getUsername());
    assertEquals("cristhian@gmail.com", userById.getEmail());
    assertEquals("123456", userById.getPass());
    assertEquals("Huesped", userById.getAccountType());
    assertNotNull(userById.getId());
  }

  @Test
  void testGetByIdException() {
    UserCrudRepositoryImpl usersRepository = new UserCrudRepositoryImpl();
    usersRepository.setUserRepository(userCrudRepository);

    when(userCrudRepository.findById(any())).thenThrow(new RuntimeException("ERROR"));

    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              usersRepository.getById(UUID.randomUUID());
            });

    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }

  @Test
  void testCheckGetAll() throws BusinessRuleValidationException {
    Usuario user = new UsersBuilder().build();
    UserJpaModel jpaUser = new UserJpaModel();
    jpaUser.setId(UUID.randomUUID());
    jpaUser.setUsername(user.getUsername());
    jpaUser.setEmail(user.getEmail());
    jpaUser.setPassword(user.getPass());
    jpaUser.setAccountType(user.getAccountType());
    jpaUser.setPersonId(UUID.randomUUID());

    List<UserJpaModel> list = new ArrayList<>();
    list.add(jpaUser);

    UserCrudRepositoryImpl usersRepository = new UserCrudRepositoryImpl();
    usersRepository.setUserRepository(userCrudRepository);

    when(userCrudRepository.findAll()).thenReturn(list);

    List<Usuario> users = usersRepository.getAll();

    assertNotNull(users);
    assertEquals(1, users.size());
    assertEquals("Criss", users.get(0).getUsername());
    assertEquals("cristhian@gmail.com", users.get(0).getEmail());
    assertEquals("123456", users.get(0).getPass());
    assertEquals("Huesped", users.get(0).getAccountType());
    assertNotNull(users.get(0).getId());
  }

  @Test
  void testGetAllException() throws BusinessRuleValidationException {
    Usuario user = new UsersBuilder().build();
    UserJpaModel jpaUser = new UserJpaModel();
    jpaUser.setId(UUID.randomUUID());
    jpaUser.setUsername(user.getUsername());
    jpaUser.setEmail(user.getEmail());
    jpaUser.setPassword(user.getPass());
    jpaUser.setAccountType(user.getAccountType());
    jpaUser.setPersonId(UUID.randomUUID());

    List<UserJpaModel> list = new ArrayList<>();
    list.add(jpaUser);

    UserCrudRepositoryImpl usersRepository = new UserCrudRepositoryImpl();
    usersRepository.setUserRepository(userCrudRepository);

    when(userCrudRepository.findAll()).thenThrow(new RuntimeException("ERROR"));

    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              usersRepository.getAll();
            });

    assertNotNull(actual);
    assertEquals("ERROR", actual.getMessage());
  }
}
