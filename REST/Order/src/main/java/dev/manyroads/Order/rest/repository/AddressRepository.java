package dev.manyroads.Order.rest.repository;

import dev.manyroads.Order.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
