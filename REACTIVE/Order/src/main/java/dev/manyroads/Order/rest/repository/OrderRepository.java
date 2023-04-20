package dev.manyroads.Order.rest.repository;


import dev.manyroads.Order.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
