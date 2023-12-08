package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.commend.create.CreateCommendPersonCommand;
import com.nur.command.commend.get.GetCommendPersonQuery;
import com.nur.command.commend.list.GetListCommendPersonQuery;
import com.nur.dtos.CommendPersonDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class CommendPersonController {
  Logger logger = LoggerFactory.getLogger(PersonsController.class);

  final Pipeline pipeline;

  public CommendPersonController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/commend-person/create")
  public CommendPersonDTO createCommend(@RequestBody CommendPersonDTO commend) {
    CreateCommendPersonCommand command = new CreateCommendPersonCommand(commend);
    return command.execute(pipeline);
  }

  @GetMapping("/commend-person/{commendId}")
  public CommendPersonDTO findById(@PathVariable String commendId) {
    GetCommendPersonQuery query = new GetCommendPersonQuery(commendId);
    return query.execute(pipeline);
  }

  @GetMapping("/commends-person")
  public List<CommendPersonDTO> getAll() {
    GetListCommendPersonQuery query = new GetListCommendPersonQuery();
    return query.execute(pipeline);
  }
}
