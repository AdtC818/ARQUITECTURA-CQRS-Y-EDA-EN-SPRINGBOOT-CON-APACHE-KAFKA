package co.edu.uptc.cqrsquery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.cqrsquery.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}