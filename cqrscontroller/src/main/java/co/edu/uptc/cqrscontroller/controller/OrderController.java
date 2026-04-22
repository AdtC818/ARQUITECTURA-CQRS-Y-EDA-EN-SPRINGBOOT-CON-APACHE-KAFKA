package co.edu.uptc.cqrscontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uptc.cqrscontroller.model.Order;
import co.edu.uptc.cqrscontroller.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addorder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order savedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PostMapping("/updateorder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @PostMapping("/delorder")
    public ResponseEntity<Void> deleteOrder(@RequestBody Order order) {
        orderService.deleteOrder(order);
        return ResponseEntity.ok().build();
    }
}