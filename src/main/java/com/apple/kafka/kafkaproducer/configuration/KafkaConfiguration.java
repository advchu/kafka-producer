package com.apple.kafka.kafkaproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.apple.kafka.kafkaproducer.model.User;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String,User> producerFactroy() {
		Map<String, Object> configs=new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    return new DefaultKafkaProducerFactory<>(configs);
	} 
	
	@Bean 
	public KafkaTemplate<String, User> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactroy());
	}
	
	
}
