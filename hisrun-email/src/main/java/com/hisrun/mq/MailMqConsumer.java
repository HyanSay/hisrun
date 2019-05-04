package com.hisrun.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MailMqConsumer {
	@RabbitListener(queues = "hello")
	@RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }
}
