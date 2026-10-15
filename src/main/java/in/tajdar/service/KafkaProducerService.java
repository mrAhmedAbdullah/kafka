package in.tajdar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	private static final String TOPIC_NAME = "orders-topic";
	@Autowired
	private KafkaTemplate<String , String> kafka;
	
	public void sendOrderMessage(String orderId, String messageDetails) {
		kafka.send(TOPIC_NAME, orderId, messageDetails);
		System.out.println("message sent successfully" + messageDetails);
	}
}
