package dev.manyroads.Shipping.rest.repository;

import dev.manyroads.Shipping.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
