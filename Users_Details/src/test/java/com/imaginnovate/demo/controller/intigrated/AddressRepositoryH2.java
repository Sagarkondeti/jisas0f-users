package com.imaginnovate.demo.controller.intigrated;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.demo.entities.Address;

public interface AddressRepositoryH2 extends JpaRepository<Address, Integer> {

}
