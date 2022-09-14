package com.imaginnovate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.demo.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
