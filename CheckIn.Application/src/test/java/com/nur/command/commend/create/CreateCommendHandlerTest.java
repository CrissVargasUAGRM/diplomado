package com.nur.command.commend.create;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.repositories.ICommendRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

class CreateCommendHandlerTest {
  @Mock private ICommendRepository commendRepository;

  @BeforeEach
  void setUp() {
    // MockitoAnnotations.initMocks(this);
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
