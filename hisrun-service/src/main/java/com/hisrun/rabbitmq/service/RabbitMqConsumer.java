package com.hisrun.rabbitmq.service;

public interface RabbitMqConsumer {
	/**
	 * RabbitMq消息推送
	 * 
	 * @param queueName
	 *            队列名称
	 * @param queueMsg
	 *            消息内容
	 */
	public void sendMsgToMq(String queueName, String queueMsg);
}
