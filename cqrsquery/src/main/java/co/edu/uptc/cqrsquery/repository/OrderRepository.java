package co.edu.uptc.cqrsquery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import co.edu.uptc.cqrsquery.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
}