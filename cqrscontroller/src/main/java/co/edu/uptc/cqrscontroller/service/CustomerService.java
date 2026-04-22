package co.edu.uptc.cqrscontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uptc.cqrscontroller.model.Customer;
import co.edu.uptc.cqrscontroller.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEventProducer customerEventProducer;

    @Transactional
    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        customerEventProducer.sendMessage("add-customer-topic", savedCustomer);
        return savedCustomer;
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepository.save(customer);
        customerEventProducer.sendMessage("update-customer-topic", updatedCustomer);
        return updatedCustomer;
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        customerEventProducer.sendMessage("delete-customer-topic", customer);
    }
}