package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import co.edu.uptc.cqrscontroller.model.Order;
import co.edu.uptc.cqrscontroller.utils.JsonUtils;

@Service
public class OrderEventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, Order order) {
        String jsonPayload = JsonUtils.toJson(order);
        kafkaTemplate.send(topic, jsonPayload);
        System.out.println("[KAFKA PRODUCER] Evento enviado a " + topic + ": " + jsonPayload);
    }
}