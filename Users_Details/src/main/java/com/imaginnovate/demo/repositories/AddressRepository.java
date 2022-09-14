package com.imaginnovate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.demo.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
