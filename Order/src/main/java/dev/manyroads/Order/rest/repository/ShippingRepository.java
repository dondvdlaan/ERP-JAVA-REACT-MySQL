package dev.manyroads.Order.rest.repository;

import dev.manyroads.Order.domain.Shipping;
import org.springframework.data.repository.CrudRepository;

public interface ShippingRepository extends CrudRepository<Shipping, Integer> {

}
