package com.npltech.consumerkafka01.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.npltech.consumerkafka01.record.OrderRecord;

@Service
public class OrderService {

    // @KafkaListener(topics = "napoleao-order-processed", containerFactory = "orderKafkaListenerContainerFactory")
    @KafkaListener(topicPartitions = @TopicPartition(topic = "napoleao-order-processed", partitions = { "1" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(OrderRecord order) {
        System.out.println("Received Message Consumer 01: " + order.name());
    }
}
