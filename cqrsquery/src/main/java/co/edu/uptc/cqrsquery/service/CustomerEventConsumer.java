package co.edu.uptc.cqrsquery.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import co.edu.uptc.cqrsquery.model.Customer;
import co.edu.uptc.cqrsquery.utils.JsonUtils;

@Service
public class CustomerEventConsumer {

    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "add-customer-topic", groupId = "customer-group")
    public void consumeAddCustomer(ConsumerRecord<String, String> record) {
        Customer customer = JsonUtils.fromJson(record.value(), Customer.class);
        customerService.addCustomer(customer);
    }

    @KafkaListener(topics = "update-customer-topic", groupId = "customer-group")
    public void consumeUpdateCustomer(ConsumerRecord<String, String> record) {
        Customer customer = JsonUtils.fromJson(record.value(), Customer.class);
        customerService.updateCustomer(customer);
    }

    @KafkaListener(topics = "delete-customer-topic", groupId = "customer-group")
    public void consumeDeleteCustomer(ConsumerRecord<String, String> record) {
        Customer customer = JsonUtils.fromJson(record.value(), Customer.class);
        customerService.deleteCustomer(customer);
    }
}