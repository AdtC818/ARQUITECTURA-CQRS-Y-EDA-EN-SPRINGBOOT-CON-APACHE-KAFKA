package co.edu.uptc.cqrsquery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uptc.cqrsquery.model.Order;
import co.edu.uptc.cqrsquery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderQueryController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/allorders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/findorderbyid")
    public ResponseEntity<Order> getOrderById(@RequestParam("id") Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}