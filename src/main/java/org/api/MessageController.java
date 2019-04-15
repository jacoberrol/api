package org.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	Logger logger = LoggerFactory.getLogger(MessageController.class);

	private final AtomicLong counter = new AtomicLong();
	private final Map<Long, Message> messageMap = new HashMap<Long, Message>();

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping("/message/{id}")
	public Message getGreeting(@PathVariable("id") long id) {
		logger.trace("getGreeting");
		Message rval = this.messageMap.get(id);
		if( rval != null ) {
			logger.debug(String.format("Found message %d",id));
		} else {
			logger.debug(String.format("Could not find message %d",id));
			throw new MessageNotFoundException();
		}
		return rval;
	}

	@PutMapping(value = "/message")
	public Message putGreeting(@RequestBody String content) {
		logger.trace("putGreeting");
		Message message = new Message(counter.incrementAndGet(), content);
		this.messageMap.put(message.getId(), message);
		return message;
	}
	
}
