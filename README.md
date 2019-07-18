# jms-active-mq-demo

#### Prerequisite
* ActiveMQ must be installed  ( http://ec2-3-91-78-239.compute-1.amazonaws.com:8161 )

#### Spring Boot ( application.properties)
```
activemq.broker-url: tcp://ec2-3-91-78-239.compute-1.amazonaws.com:61616
```

#### Sender
```
package com.naresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Sender {

	  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	  @Autowired
	  private JmsTemplate jmsTemplate;

	  public void send(String message) {
	    LOGGER.info("sending message='{}'", message);
	    jmsTemplate.convertAndSend("transaction-queue", message);
	  }
	}
```

#### Receiver
```
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
```
#### Testing
```
package com.naresh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {

	@Autowired
	private Sender sender;

	@Test
	public void testSender() throws InterruptedException {
		sender.send("Hello Spring JMS ActiveMQ!");

	}

}
```
