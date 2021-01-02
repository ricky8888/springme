package com.ron.producer.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Analyzer {
//    String NEW_ORDERS = "newOrders";
//    String FINISHED_ORDERS = "finishedOrders";

//    @Input
//    SubscribableChannel finishedOrders();
//
//    @Output
//    MessageChannel newOrders();

    String NEW_TASKS = "newTasks";
    String FINISHED_TASKS = "finishedTasks";

    @Input
    SubscribableChannel finishedTasks();

    @Output
    MessageChannel newTasks();
}