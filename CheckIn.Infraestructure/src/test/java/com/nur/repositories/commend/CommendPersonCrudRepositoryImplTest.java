package com.nur.repositories.commend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nur.builder.CommendPersonBuilder;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CommendPerson;
import com.nur.model.CommendPersonJpaModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CommendPersonCrudRepositoryImplTest {
  @Mock ICommendPersonCrudRepository commendPersonCrudRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testUpdateCommendPerson() throws BusinessRuleValidationException {
    CommendPerson commend = new CommendPersonBuilder().build();
    CommendPersonJpaModel jpaModel = new CommendPersonJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoration());
    jpaModel.setComment(commend.getCommend());
    jpaModel.setPerson(commend.getPerson());
    jpaModel.setPoints(commend.getPoints());

    CommendPersonCrudRepositoryImpl commendsRepository = new CommendPersonCrudRepositoryImpl();
    commendsRepository.setCommendPersonCrudRepository(commendPersonCrudRepository);

    when(commendPersonCrudRepository.save(any())).thenReturn(jpaModel);

    UUID response = commendsRepository.update(commend);
    assertNotNull(response);
    assertEquals(4, response.version());
  }

  @Test
  void testGetById() throws BusinessRuleValidationException {
    CommendPerson commend = new CommendPersonBuilder().build();
    CommendPersonJpaModel jpaModel = new CommendPersonJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoration());
    jpaModel.setComment(commend.getCommend());
    jpaModel.setPerson(commend.getPerson());
    jpaModel.setPoints(commend.getPoints());

    CommendPersonCrudRepositoryImpl commendsRepository = new CommendPersonCrudRepositoryImpl();
    commendsRepository.setCommendPersonCrudRepository(commendPersonCrudRepository);

    when(commendPersonCrudRepository.findById(any())).thenReturn(Optional.of(jpaModel));

    CommendPerson commendGetById = commendsRepository.getById(UUID.randomUUID());

    assertNotNull(commendGetById);
    assertEquals("Bueno", commendGetById.getValoration());
    assertEquals("Lo que sea", commendGetById.getCommend());
    assertEquals("Cristhian", commendGetById.getPerson());
    assertEquals(3, commendGetById.getPoints());
    assertNotNull(commendGetById.getId());
    assertNotNull(commendGetById.getUserId());
  }

  @Test
  void testGetByIdException() {
    CommendPersonCrudRepositoryImpl commendsRepository = new CommendPersonCrudRepositoryImpl();
    commendsRepository.setCommendPersonCrudRepository(commendPersonCrudRepository);

    when(commendPersonCrudRepository.findById(any())).thenThrow(new RuntimeException("ERROR"));

    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              commendsRepository.getById(UUID.randomUUID());
            });

    assertNotNull(actual);
    assertEquals("ERROR", actual.getMessage());
  }

  @Test
  void testGetAll() throws BusinessRuleValidationException {
    CommendPerson commend = new CommendPersonBuilder().build();
    CommendPersonJpaModel jpaModel = new CommendPersonJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoration());
    jpaModel.setComment(commend.getCommend());
    jpaModel.setPerson(commend.getPerson());
    jpaModel.setPoints(commend.getPoints());

    List<CommendPersonJpaModel> list = new ArrayList<>();
    list.add(jpaModel);

    CommendPersonCrudRepositoryImpl commendsRepository = new CommendPersonCrudRepositoryImpl();
    commendsRepository.setCommendPersonCrudRepository(commendPersonCrudRepository);

    when(commendPersonCrudRepository.findAll()).thenReturn(list);

    List<CommendPerson> response = commendsRepository.getAll();

    assertNotNull(response);
    assertEquals(1, response.size());
    assertEquals(jpaModel.getValoration(), response.get(0).getValoration());
    assertEquals(jpaModel.getComment(), response.get(0).getCommend());
    assertEquals(jpaModel.getPerson(), response.get(0).getPerson());
    assertEquals(jpaModel.getPoints(), response.get(0).getPoints());
    assertNotNull(response.get(0).getUserId());
  }
}
