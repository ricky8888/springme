package com.ron.handler.repository;

import com.ron.handler.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class TaskRedisRepositoryImpl implements TaskRedisRepository {
    private static final String KEY = "Task";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public TaskRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Task task) {
        hashOperations.put(KEY, task.getId(), task.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Task findTask(final String id){
        return (Task) hashOperations.get(KEY, id);
    }

    public Map<Object, Object> findAllTasks(){
        return hashOperations.entries(KEY);
    }
}
