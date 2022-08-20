package com.imaginnovate.demo.controller.intigrated;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.demo.entities.Users;

public interface UsersRepositoryH2 extends JpaRepository<Users, Integer>{

}
