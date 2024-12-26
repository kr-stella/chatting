package jj.stella.repository.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerService {
	
	private final KafkaTemplate<String,String> kafkaTemplate;
	public void sendMessage(String topic, String message){
		kafkaTemplate.send(topic,message);
	}
	
}