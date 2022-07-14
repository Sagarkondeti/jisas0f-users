package com.imaginnovate.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Users;
import com.imaginnovate.demo.repositories.AddressRepository;
import com.imaginnovate.demo.repositories.UsersRepository;


@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	ModelMapper mm = new ModelMapper();
	
	public Users addUsersDetails(UsersDTO usersDTO)
	{
		Users users = mm.map(usersDTO, Users.class);
		return usersRepository.save(users);
	}
	
	public List<Users> getAllUsers()
	{
		return usersRepository.findAll();
	}
	
	public Users updateUserDetails(UsersDTO usersDTO) 
	{
		Users users = mm.map(usersDTO, Users.class);
		return usersRepository.save(users);
	}
	
	public void deleteUserDetails(int id) 
	{
	    usersRepository.deleteById(id);
	}
	
}
