package com.nur.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import builder.CommendDTOBuilder;
import com.nur.dtos.CommendDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CommendControllerTest {
  @Mock Pipeline pipeline;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testControllerCreate() {
    CommendDTO commend = new CommendDTOBuilder().build();

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(commend);

    CommendController commendController = new CommendController(pipeline);

    CommendDTO response = commendController.createCommend(commend);
    assertNotNull(response);
  }

  @Test
  void testControllerGetById() {
    CommendDTO commend = new CommendDTOBuilder().build();

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(commend);

    CommendController commendController = new CommendController(pipeline);

    CommendDTO response = commendController.findById(String.valueOf(UUID.randomUUID()));
    assertNotNull(response);
  }

  @Test
  void testControllerGetAll() {
    List<CommendDTO> list = new ArrayList<>();
    list.add(new CommendDTOBuilder().build());

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(list);

    CommendController commendController = new CommendController(pipeline);

    List<CommendDTO> response = commendController.getAll();
    assertNotNull(response);
  }
}
