package com.kunal.app.service;


import com.kunal.app.model.Hospital;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQHospitalSender {
  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Value("${rabbitmq.exchange.name}")
  private String exchange;

  @Value("${rabbitmq.routingkey.name}")
  private String routingkey;


  public void hsend(Hospital hospital) {
    rabbitTemplate.convertAndSend(exchange, routingkey, hospital);
    System.out.println("Send msg = " + hospital);
  }
}
