package com.estockcompanyinfoservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;

@Service 
public class MessageService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MessageService.class);
	
	public void sendCreateRequestToEStockMarketApp(CompanyInfoModelDTO companyInfo) {
		LOGGER.info("Adding CompanyInfo to Queue-CreateCompanyDetials "+ companyInfo.toString());
		rabbitTemplate.convertAndSend("Queue-CreateCompanyDetials",companyInfo);
	}	
	
	public void sendDeleteRequestToEStockMarketApp(Long code) {
		LOGGER.info("Adding request to Queue-DeleteCompanyDetials for company "+code );
		rabbitTemplate.convertAndSend("Queue-DeleteCompanyDetials",code);
	}
	
	public void sendDeleteRequestToStockInfo(Long code) {
		LOGGER.info("Adding request to Queue-DeleteStocks of company "+code );
		rabbitTemplate.convertAndSend("Queue-DeleteStocks",code);
	}
}
