package com.ron.handler.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@Transactional
public class TaskListener {
//    @Autowired
//    private CoffeeOrderRepository orderRepository;
    @Autowired
    @Qualifier(Producer.FINISHED_TASKS)
    private MessageChannel finishedTasksMessageChannel;
    @Value("${task.handler-prefix}${random.uuid}")
    private String taskHandler;
    //private String barista;
    //todo redis integration

    @StreamListener(Producer.NEW_TASKS)
    public void processNewOrder(Long id) {
        /*
        CoffeeOrder o = orderRepository.getOne(id);
        if (o == null) {
            log.warn("Order id {} is NOT valid.", id);
            return;
        }
        log.info("Receive a new Order {}. Waiter: {}. Customer: {}",
                id, o.getWaiter(), o.getCustomer());
        o.setState(OrderState.BREWED);
        o.setBarista(barista);
        orderRepository.save(o);
        log.info("Order {} is READY.", id);
        */

        System.out.println("Hi Ron - begin to send msg of finishedTasks from " + taskHandler);

        //Todo integrate with redis
        finishedTasksMessageChannel.send(MessageBuilder.withPayload(id).build());

        System.out.println("Hi Ron - sent msg of finishedTasks from " + taskHandler);
    }
}
