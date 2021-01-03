package com.ron.handler.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Producer {
    String NEW_TASKS = "newTasks";
    String FINISHED_TASKS = "finishedTasks";

    @Input(NEW_TASKS)
    SubscribableChannel newTasks();

    @Output(FINISHED_TASKS)
    MessageChannel finishedTasks();
}