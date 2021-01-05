package com.ron.handler.repository;

import com.ron.handler.model.Task;

import java.util.Map;

public interface TaskRedisRepository {
    Map<Object, Object> findAllTasks();

    void add(Task task);

    void delete(String id);

    Task findTask(String id);
}
