package com.ron.producer.repository;

import com.ron.producer.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByContentInOrderById(List<String> list);
}

