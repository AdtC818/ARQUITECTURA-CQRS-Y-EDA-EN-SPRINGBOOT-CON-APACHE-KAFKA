package co.edu.uptc.cqrsquery.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import co.edu.uptc.cqrsquery.model.Order;
import co.edu.uptc.cqrsquery.utils.JsonUtils;

@Service
public class OrderEventConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "add-order-topic", groupId = "order-group")
    public void consumeAddOrder(ConsumerRecord<String, String> record) {
        System.out.println("[KAFKA CONSUMER] Recibido add-order: " + record.value());
        Order order = JsonUtils.fromJson(record.value(), Order.class);
        orderService.addOrder(order);
    }

    @KafkaListener(topics = "update-order-topic", groupId = "order-group")
    public void consumeUpdateOrder(ConsumerRecord<String, String> record) {
        Order order = JsonUtils.fromJson(record.value(), Order.class);
        orderService.updateOrder(order);
    }

    @KafkaListener(topics = "delete-order-topic", groupId = "order-group")
    public void consumeDeleteOrder(ConsumerRecord<String, String> record) {
        Order order = JsonUtils.fromJson(record.value(), Order.class);
        orderService.deleteOrder(order);
    }
}