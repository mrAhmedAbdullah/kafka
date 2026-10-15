package in.tajdar.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "orders-topic", groupId = "inventory-group")
	public void consumeOrders(String message) {
		System.out.println("order recieved in Inventory service" + message);
	}
}
