package com.naresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);


	@JmsListener(destination = "transaction-queue")
	public void receive(String message) {
		LOGGER.info("received message='{}'", message);
		
	}
}