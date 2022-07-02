package com.imaginnovate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Users;
import com.imaginnovate.demo.repositories.AddressRepository;
import com.imaginnovate.demo.repositories.UsersRepository;

@RestController
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("/addUsersDetails")
	public Users addUsersDetails(@RequestBody UsersDTO usersDTO)
	{
		return usersRepository.save(usersDTO.getUsers());
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers()
	{
		return usersRepository.findAll();
	}
}
