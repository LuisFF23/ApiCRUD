package com.luis.crud.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luis.crud.entity.dto.BookDTO;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class BookMessageReceiver {

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	BookService service;

	@Bean
	public CachingConnectionFactory rabbitConnetctionFactory() throws Exception {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.getRabbitConnectionFactory().setUri("");
		return connectionFactory;
	}

	@RabbitListener(queues = {"${queue.order.name}"})
	public void consume (Message message) throws IOException {
		try {

			String json = new String(message.getBody());

			JsonValidatorService.validateBookDTO(json);

			BookDTO bookDTO = objectMapper.readValue(json, BookDTO.class);

			service.save(bookDTO);
		} catch (Exception e) {
			System.out.println("erro na msg: " + e.getMessage());
		}

	}

}
