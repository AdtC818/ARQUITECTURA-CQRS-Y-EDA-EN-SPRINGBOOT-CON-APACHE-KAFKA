package co.edu.uptc.cqrscontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.cqrscontroller.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}