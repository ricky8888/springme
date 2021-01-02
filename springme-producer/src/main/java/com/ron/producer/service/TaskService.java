package com.ron.producer.service;

import com.ron.producer.integration.Analyzer;
import com.ron.producer.model.Task;
import com.ron.producer.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private Analyzer analyzer;

    public List<Task> getAllTask() {
        return taskRepository.findAll(Sort.by("id"));
    }

    public List<Task> geTaskByName(List<String> names) {
        return taskRepository.findByContentInOrderById(names);
    }

    public Task saveTask(String name, String content) {
        Task newTask = taskRepository.save(Task.builder().name(name).content(content).build());
        analyzer.newTasks().send(MessageBuilder.withPayload(newTask.getId()).build());
        return newTask;
    }
}