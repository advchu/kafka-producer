package com.apple.kafka.kafkaproducer.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apple.kafka.kafkaproducer.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate <String, User> kafkaTeamp;
	private static final String TOPIC="myTopicAnkit";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String msg) {
		kafkaTeamp.send(TOPIC,new User(msg,"technology","120k"));
		return "Message Published Successfully ";
	}
	
	

}
