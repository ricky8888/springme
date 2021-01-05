package com.ron.handler.controller;

import com.ron.handler.repository.TaskRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/handler")
@Slf4j
public class HandlerController {
    @Autowired
    private TaskRedisRepository redisRepository;

    @GetMapping(path = "/tasks")
    @ResponseBody
    public Map<Object, Object> getAll() {
        return redisRepository.findAllTasks();
    }
}

