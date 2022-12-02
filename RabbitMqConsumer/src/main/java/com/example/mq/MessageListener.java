package com.example.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	@RabbitListener(queues = MQConfig.QUEUE)
	public void listener(CustomMessage message) {
		System.out.println(message);
	}
	@RabbitListener(queues = MQConfig.NEWQUEUE)
	public void listener1(CustomMessage message) {
		System.out.println(message);
	}
	@RabbitListener(queues = MQConfig.NEWQUEUE1)
	public void listener2(CustomMessage message) {
		System.out.println(message);
	}
}
