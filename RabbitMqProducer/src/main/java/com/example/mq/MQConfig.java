package com.example.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


@Configuration
public class MQConfig {
	public static final String QUEUE="message_queue";
	public static final String EXCHANGE="message_exchange";
	public static final String ROUTING_KEY="message_routingKey";
	public static final String ROUTING_KEY1="message_routingKey1";
	public static final String NEWQUEUE="new_queue";
	public static final String NEWQUEUE1="new_queue1";
	public static final String ROUTING_KEY2="message_routingKey2";
	private static final String NEWQUEUE2 ="experiment_queue";
	public static final String ROUTING_KEY3="message_routingKey3";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	@Bean 
	public Queue queue1() {
		QueueBuilder queueBuilder=QueueBuilder.durable(NEWQUEUE);
		queueBuilder.maxLength(5);
		return queueBuilder.build();
	}
	@Bean 
	public Queue queue2() {
		return new Queue(NEWQUEUE1);
	}
	@Bean 
	public Queue queue3() {
		QueueBuilder queueBuilder=QueueBuilder.durable(NEWQUEUE2);
		queueBuilder.expires(100000);
		return queueBuilder.build();
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(@Qualifier("queue")Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	@Bean
	public Binding binding1(@Qualifier("queue1")Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY1);
	}
	@Bean
	public Binding binding2(@Qualifier("queue2")Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY2);
	}
	@Bean
	public Binding binding3(@Qualifier("queue3")Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY3);
	}
	@Bean
	public MessageConverter convertor() {
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	private static com.rabbitmq.client.ConnectionFactory newRabbitConnectionFactory() {
	    com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
	    connectionFactory.setAutomaticRecoveryEnabled(false);
	    return connectionFactory; 
	}
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template=new RabbitTemplate(connectionFactory);
		template.setMessageConverter(convertor());
		return template;
	}
	
}
