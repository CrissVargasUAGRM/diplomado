package com.nur.command.commend.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import builder.CommendDTOBuilder;
import com.nur.dtos.CommendDTO;
import com.nur.model.Commend;
import com.nur.repositories.ICommendRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GetCommendHandlerTest {
  @Mock private ICommendRepository commendRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testCreateHandler() {
    assertDoesNotThrow(
        () -> {
          CommendDTO commendJpa = new CommendDTOBuilder().build();
          Commend commendDomain =
              new Commend(UUID.randomUUID(), "Bueno", "Lo que sea", "Condominio", 3);
          GetCommendQuery query = new GetCommendQuery(String.valueOf(UUID.randomUUID()));

          when(commendRepository.getById(any())).thenReturn(commendDomain);

          GetCommendHandler handler = new GetCommendHandler(commendRepository);

          CommendDTO response = handler.handle(query);

          assertNotNull(response);
          assertEquals(commendJpa.getValoration(), response.getValoration());
          assertEquals(commendJpa.getDescription(), response.getDescription());
          assertEquals(commendJpa.getProperty(), response.getProperty());
          assertEquals(commendJpa.getPoints(), response.getPoints());
          assertNotNull(response.getUserId());
        });
  }
}
