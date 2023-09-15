package com.kunal.app.service;
import com.kunal.app.model.Patient;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPatientSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingkey.name}")
    private String routingkey;

    public void psend(Patient patient) {
        rabbitTemplate.convertAndSend(exchange,routingkey,patient);
        System.out.println("Send msg = " + patient);
    }
}
