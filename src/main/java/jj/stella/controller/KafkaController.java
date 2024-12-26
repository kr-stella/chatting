package jj.stella.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jj.stella.repository.service.ProducerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class KafkaController {
	
	private final ProducerService producerService;
	
	@PostMapping("/send")
	public void send(@RequestParam("message") String message){
		producerService.sendMessage("test", message);
	}
	
}