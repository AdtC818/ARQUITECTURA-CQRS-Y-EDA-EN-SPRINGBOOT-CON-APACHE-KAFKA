package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uptc.cqrscontroller.model.Order;
import co.edu.uptc.cqrscontroller.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    @Transactional
    public Order addOrder(Order order) {
        order.setStatus("PENDING");
        Order savedOrder = orderRepository.save(order);
        orderEventProducer.sendMessage("add-order-topic", savedOrder);
        return savedOrder;
    }

    @Transactional
    public Order updateOrder(Order order) {
        Order updatedOrder = orderRepository.save(order);
        orderEventProducer.sendMessage("update-order-topic", updatedOrder);
        return updatedOrder;
    }

    @Transactional
    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getId()); 
        orderEventProducer.sendMessage("delete-order-topic", order); 
    }
}