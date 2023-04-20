package dev.manyroads.Shipping.rest.repository;

import dev.manyroads.Shipping.domain.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShippingRepository extends CrudRepository<Shipment, Integer> {

}
