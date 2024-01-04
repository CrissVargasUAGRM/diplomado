package com.nur.repositories.commend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nur.builder.CommendBuilder;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import com.nur.model.CommendJpaModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CommendCrudRepositoryImplTest {
  @Mock ICommendCrudRepository commendCrudRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testUpdateCommend() throws BusinessRuleValidationException {
    Commend commend = new CommendBuilder().build();
    CommendJpaModel jpaModel = new CommendJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoracion());
    jpaModel.setCommend(commend.getComentario());
    jpaModel.setProperty(commend.getPropiedad());
    jpaModel.setPoints(commend.getPoints());

    CommendCrudRepositoryImpl commendsRepository = new CommendCrudRepositoryImpl();
    commendsRepository.setCommendCrudRepository(commendCrudRepository);

    when(commendCrudRepository.save(any())).thenReturn(jpaModel);

    UUID response = commendsRepository.update(commend);
    assertNotNull(response);
    assertEquals(4, response.version());
  }

  @Test
  void testGetById() throws BusinessRuleValidationException {
    Commend commend = new CommendBuilder().build();
    CommendJpaModel jpaModel = new CommendJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoracion());
    jpaModel.setCommend(commend.getComentario());
    jpaModel.setProperty(commend.getPropiedad());
    jpaModel.setPoints(commend.getPoints());

    CommendCrudRepositoryImpl commendsRepository = new CommendCrudRepositoryImpl();
    commendsRepository.setCommendCrudRepository(commendCrudRepository);

    when(commendCrudRepository.findById(any())).thenReturn(Optional.of(jpaModel));

    Commend commendGetById = commendsRepository.getById(UUID.randomUUID());

    assertNotNull(commendGetById);
    assertEquals("Bueno", commendGetById.getValoracion());
    assertEquals("Lo que sea", commendGetById.getComentario());
    assertEquals("Condominio", commendGetById.getPropiedad());
    assertEquals(3, commendGetById.getPoints());
    assertNotNull(commendGetById.getId());
    assertNotNull(commendGetById.getUserId());
  }

  @Test
  void testGetByIdException() {
    CommendCrudRepositoryImpl commendsRepository = new CommendCrudRepositoryImpl();
    commendsRepository.setCommendCrudRepository(commendCrudRepository);

    when(commendCrudRepository.findById(any())).thenThrow(new RuntimeException("ERROR"));

    RuntimeException actual =
        assertThrows(
            RuntimeException.class,
            () -> {
              commendsRepository.getById(UUID.randomUUID());
            });

    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException: ERROR", actual.getMessage());
  }

  @Test
  void testGetAll() throws BusinessRuleValidationException {
    Commend commend = new CommendBuilder().build();
    CommendJpaModel jpaModel = new CommendJpaModel();
    jpaModel.setId(UUID.randomUUID());
    jpaModel.setUserId(commend.getUserId());
    jpaModel.setValoration(commend.getValoracion());
    jpaModel.setCommend(commend.getComentario());
    jpaModel.setProperty(commend.getPropiedad());
    jpaModel.setPoints(commend.getPoints());

    List<CommendJpaModel> list = new ArrayList<>();
    list.add(jpaModel);

    CommendCrudRepositoryImpl commendsRepository = new CommendCrudRepositoryImpl();
    commendsRepository.setCommendCrudRepository(commendCrudRepository);

    when(commendCrudRepository.findAll()).thenReturn(list);

    List<Commend> response = commendsRepository.getAll();

    assertNotNull(response);
    assertEquals(1, response.size());
    assertEquals(jpaModel.getValoration(), response.get(0).getValoracion());
    assertEquals(jpaModel.getCommend(), response.get(0).getComentario());
    assertEquals(jpaModel.getProperty(), response.get(0).getPropiedad());
    assertEquals(jpaModel.getPoints(), response.get(0).getPoints());
    assertNotNull(response.get(0).getUserId());
  }
}
