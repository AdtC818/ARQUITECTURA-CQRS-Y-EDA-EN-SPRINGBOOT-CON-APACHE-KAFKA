package co.edu.uptc.cqrsquery.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import co.edu.uptc.cqrsquery.model.Login;
import co.edu.uptc.cqrsquery.utils.JsonUtils;

@Service
public class LoginEventConsumer {

    @Autowired
    private LoginService loginService;

    @KafkaListener(topics = "add-login-topic", groupId = "customer-group")
    public void consumeAddLogin(ConsumerRecord<String, String> record) {
        Login login = JsonUtils.fromJson(record.value(), Login.class);
        loginService.addLogin(login);
    }

    @KafkaListener(topics = "update-login-topic", groupId = "customer-group")
    public void consumeUpdateLogin(ConsumerRecord<String, String> record) {
        Login login = JsonUtils.fromJson(record.value(), Login.class);
        loginService.updateLogin(login);
    }

    @KafkaListener(topics = "delete-login-topic", groupId = "customer-group")
    public void consumeDeleteLogin(ConsumerRecord<String, String> record) {
        Login login = JsonUtils.fromJson(record.value(), Login.class);
        loginService.deleteLogin(login);
    }
}