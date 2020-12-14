package com.ron.producer.controller;

import com.ron.producer.controller.request.NewTaskRequest;
import com.ron.producer.model.Task;
import com.ron.producer.service.TaskService;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/task-lists")
@Slf4j
public class ProducerController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/")
    @ResponseBody
    public List<Task> getAll() {
        /*ArrayList<String> resultList = new ArrayList<String>();
        resultList.add("abc");
        resultList.add("efg");
        return resultList;*/
        return taskService.getAllTask();
    }

    @PostMapping(path = "/task", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Task saveTask(@Valid @RequestBody NewTaskRequest newTask) {
        return taskService.saveTask(newTask.getName(), newTask.getContent());
    }

}
