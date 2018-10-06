package com.hisrun.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hisrun.rabbitmq.service.RabbitMqConsumer;

@Component
public class RabbitMqConsumerImpl implements RabbitMqConsumer {

	private Logger logger = LoggerFactory.getLogger(RabbitMqConsumerImpl.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 推送消息到RabbitMQ
	 * 
	 * @param queueName
	 *            队列名称
	 * @param queueMsg
	 *            消息内容
	 */
	public void sendMsgToMq(String queueName, String queueMsg) {
		try {
			logger.info("推送消息到RabbitMq开始,推送到的队列为：" + queueName + " ,推送内容为：" + queueMsg);
			this.rabbitTemplate.convertAndSend(queueName, queueMsg);
			logger.info("推送消息到RabbitMq结束,推送到的队列为：" + queueName + " ,推送内容为：" + queueMsg);
		} catch (Exception e) {
			logger.error("推送消息到RabbitMq失败");
		}

	}
}
