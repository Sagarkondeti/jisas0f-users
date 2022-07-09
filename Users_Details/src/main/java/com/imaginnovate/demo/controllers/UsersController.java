package com.imaginnovate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.demo.DTO.UsersDTO;
import com.imaginnovate.demo.entities.Users;
import com.imaginnovate.demo.service.UsersService;


@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/addUsersDetails")
	public Users addUsersDetails(@RequestBody UsersDTO usersDTO)
	{
		return usersService.addUsersDetails(usersDTO);
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers()
	{
		return usersService.getAllUsers();
	}
	
	@PutMapping("/updateUser")
	public Users updateUserDetailsa(@RequestBody UsersDTO usersDTO) 
	{
		return usersService.updateUserDetails(usersDTO);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserDetails(@PathVariable("id") int id) 
	{
		 usersService.deleteUserDetails(id);
	}
//	
//	@DeleteMapping(path = "/{id}")
//	public UsersDTO deleteUserDetails(@PathVariable int id) {
//		
//		
//	}
}
