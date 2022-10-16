package com.estockcompanyinfoservice.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue createCreateCompanyDetialsQueue() {
		return new Queue("Queue-CreateCompanyDetials");
	}
	
	@Bean
	public Queue createDeleteCompanyDetialsQueue() {
		return new Queue("Queue-DeleteCompanyDetials");
	}

	@Bean
	public Queue createDeleteStockQueue() {
		return new Queue("Queue-DeleteStocks");
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}	
}
