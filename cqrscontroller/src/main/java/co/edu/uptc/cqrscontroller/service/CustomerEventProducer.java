package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import co.edu.uptc.cqrscontroller.model.Customer;
import co.edu.uptc.cqrscontroller.utils.JsonUtils;

@Service
public class CustomerEventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, Customer customer) {
        String jsonPayload = JsonUtils.toJson(customer);
        kafkaTemplate.send(topic, jsonPayload);
    }
}