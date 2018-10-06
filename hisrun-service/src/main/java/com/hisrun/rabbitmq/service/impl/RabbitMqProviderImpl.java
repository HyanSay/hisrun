package com.hisrun.rabbitmq.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProviderImpl {

	@RabbitListener(queues = "queueName")
	public class HelloReceiver {

		@RabbitHandler
		public void process(String queueMsg) {
			System.out.println("Receiver  : " + queueMsg);
		}
	}
}
