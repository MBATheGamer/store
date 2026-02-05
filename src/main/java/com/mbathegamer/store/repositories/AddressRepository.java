package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbathegamer.store.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
