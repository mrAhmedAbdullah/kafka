package in.tajdar.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tajdar.service.KafkaProducerService;

@RestController
public class KafkaRestController {

    private final KafkaProducerService kafkaProducerService;

    KafkaRestController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
	@PostMapping("/order")
	public ResponseEntity<String> makeOrder(@RequestBody String orderId,@RequestBody String messageDetails){
		kafkaProducerService.sendOrderMessage(orderId, messageDetails);
		return new ResponseEntity<String>("order sent successfully", HttpStatus.CREATED);
	}
}
