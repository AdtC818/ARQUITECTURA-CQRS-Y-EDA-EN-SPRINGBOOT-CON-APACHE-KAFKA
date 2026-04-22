package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import co.edu.uptc.cqrscontroller.model.Login;
import co.edu.uptc.cqrscontroller.utils.JsonUtils;

@Service
public class LoginEventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, Login login) {
        String jsonPayload = JsonUtils.toJson(login);
        kafkaTemplate.send(topic, jsonPayload);
    }
}