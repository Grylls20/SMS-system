package com.meesho.smssystem.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.sms.queue}")
    private String smsQueue;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendRequest(Long messageId){
        rabbitTemplate.convertAndSend(smsQueue, messageId);
    }

}
