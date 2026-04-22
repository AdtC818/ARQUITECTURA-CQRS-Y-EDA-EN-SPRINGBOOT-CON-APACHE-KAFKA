package co.edu.uptc.cqrsquery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.cqrsquery.model.Customer;
import co.edu.uptc.cqrsquery.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerQueryController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/allcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/findcustomerbyid")
    public ResponseEntity<Customer> getCustomerById(@RequestParam("id") String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
}