package com.example.mq;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePusblisher {
	@Autowired
	private RabbitTemplate template;
	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY,message);
		return "message delivered successfully";
	}
	@PostMapping("/publish1")
	public String publishMessage1(@RequestBody CustomMessage message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY1,message);
		return "message delivered successfully";
	}
	@PostMapping("/publish2")
	public String publishMessage2(@RequestBody CustomMessage message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY2,message);
		return "message delivered successfully";
	}
	@PostMapping("/publish3")
	public String publishMessage3(@RequestBody CustomMessage message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY3,message);
		return "message delivered successfully";
	}

}
